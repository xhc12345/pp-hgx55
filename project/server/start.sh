#!/bin/bash

dir=$(dirname "$0")
cd $dir

go mod tidy

go run web-service-gin/*.go