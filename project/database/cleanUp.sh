#!/bin/bash

export USER_ID="$(id -u)"
export GROUP_ID="$(id -g)"

export NEO4J_DOCKER_IMAGE=neo4j:4.4.26-community

echo "cypher-shell finished, cleaning up everything"

docker stop server1
docker rm server1
docker network rm neo4j-cluster
docker-compose down

echo ""
echo "Exiting"