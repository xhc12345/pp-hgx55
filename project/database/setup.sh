#!/bin/bash

dir=$(dirname "$0")
cd $dir

export USER_ID="$(id -u)"
export GROUP_ID="$(id -g)"

export NEO4J_DOCKER_IMAGE=neo4j:4.4.26-community
export NEO4J_EDITION=docker_compose

export EXTENDED_CONF=yes
export NEO4J_ACCEPT_LICENSE_AGREEMENT=yes

export NEO4J_AUTH=neo4j/password

# compose the docker image for neo4j
docker-compose up

echo === docker compose done ===

docker network create --driver=bridge neo4j-cluster

docker run --name=server1 --detach --network=neo4j-cluster \
    --publish=7474:7474 --publish=7473:7473 --publish=7687:7687 \
    --hostname=server1 \
    --env NEO4J_initial_server_mode__constraint=PRIMARY \
    --env NEO4J_dbms_cluster_discovery_endpoints=server1:5000 \
    --env NEO4J_ACCEPT_LICENSE_AGREEMENT=yes \
    --env NEO4j_server_bolt_advertised_address=localhost:7687 \
    --env NEO4j_server_http_advertised_address=localhost:7474 \
    --env NEO4J_AUTH=neo4j/password \
    neo4j:4.4.26-community

echo "Starting cypher-shell"

# docker exec -it server1 bash
# docker exec -it server1 bash < cypherShell.sh
# docker exec -it server1 bash -c "cypher-shell -u neo4j -p password"

# cypher-shell -u neo4j -p password




