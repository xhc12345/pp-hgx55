// error parsing
CREATE (p:Person {name: 'Tom Hanks', age: 30})
MATCH (tom:Person {name:'Tom Hanks'})-[rel:DIRECTED]-(movie:Movie)
RETURN asldfjalksdjflasdjkfl