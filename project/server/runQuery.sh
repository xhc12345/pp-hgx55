#!/bin/bash

dir=$(dirname "$0")
cd $dir

# ./../../database/runCypherShell.sh

echo "Sending command to Neo4j Cypher Shell"

input=$(cat IO/in.cql)
echo $input

docker exec -t server1 cypher-shell -u neo4j -p password "$input" > IO/out.txt
# docker exec -t server1 cypher-shell -u neo4j -p password "$input" > IO/out.txt 2> IO/err.txt
# docker exec --interactive --tty server1 cypher-shell -u neo4j -p password "$input" > IO/out.txt 2> IO/err.txt

echo "Neo4j has responded to our request"