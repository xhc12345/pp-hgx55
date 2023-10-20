import subprocess
import time

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
        # "MATCH (p:Person)-[p:DIRECTED]-(p:Movie)\r\nRETURN p;",
    ],
    # capture_output=True,
)
# print("\n\n" + str(ret.returncode) + "\n" + str(ret.stderr) + "\n\n")

# Match (n)-[r]->(m) Return n,r,m