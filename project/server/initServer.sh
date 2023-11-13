#!/bin/bash

dir=$(dirname "$0")
cd $dir

go mod tidy
# go run web-service-gin/*.go

# cd web-service-gin
# go build
# cd ..
# ./web-service-gin/web-service-gin
d="web-service-gin"
go run $d/main.go $d/routes.go $d/database_shell.go $d/database_pkge.go $d/models.go

echo "Server down"