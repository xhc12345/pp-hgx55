#!/bin/bash

dir=$(dirname "$0")
cd $dir

# change this for different test cases
test="../tests/t6.cql"
target="../IO/input.cql"

cat $test > $target

echo "starting program to test"
./build/cypher-parser.exe
echo "finished"