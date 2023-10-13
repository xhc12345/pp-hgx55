MATCH (p:Person{name:'tom'})-[r:Rel]-(r:Movie)
RETURN p, r, m