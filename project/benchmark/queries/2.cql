CREATE (n:Person {name: 'Alice', age: 30}) RETURN n
CREATE (n:Person {name: 'Bob', age: 28}) RETURN n
CREATE (n:Company {name: 'Acme Inc.'}) RETURN n
MATCH (person:Person {name: 'Alice'}), (company:Company {name: 'Acme Inc.'}) CREATE (person)-[:WORKS_AT]->(company)
MATCH (alice:Person {name: 'Alice'}), (bob:Person {name: 'Bob'}) CREATE (alice)-[:FRIENDS_WITH]->(bob)
MATCH (person:Person) RETURN person
MATCH (company:Company) RETURN company