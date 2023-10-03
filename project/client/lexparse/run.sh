#!/bin/bash

dir=$(dirname "$0")
cd $dir
./build/cypher-parser.exe > ../IO/stdout.txt 2> ../IO/stderr.txt