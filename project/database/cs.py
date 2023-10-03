import subprocess
import time

cypher_queries = (
    "CREATE (n:Person {name: 'Alice', age: 30}) RETURN n"
    "CREATE (n:Person {name: 'Bob', age: 28}) RETURN n"
    "CREATE (n:Company {name: 'Acme Inc.'}) RETURN n"
    "MATCH (person:Person {name: 'Alice'}), (company:Company {name: 'Acme Inc.'}) CREATE (person)-[:WORKS_AT]->(company)"
    "MATCH (alice:Person {name: 'Alice'}), (bob:Person {name: 'Bob'}) CREATE (alice)-[:FRIENDS_WITH]->(bob)"
    "MATCH (person:Person) RETURN person"
    "MATCH (company:Company) RETURN company"
)

# time.sleep(5)
ret: subprocess.CompletedProcess = subprocess.run(
    [
        "docker",
        "exec",
        "--interactive",
        "--tty",
        "server1",
        "cypher-shell",
        "-u",
        "neo4j",
        "-p",
        "password",
        cypher_queries,
    ],
    # capture_output=True,
)
# print("\n\n" + str(ret.returncode) + "\n" + str(ret.stderr) + "\n\n")
