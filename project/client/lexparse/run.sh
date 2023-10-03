#!/bin/bash

dir=$(dirname "$0")
cd $dir
./build/cypher-parser.exe 2> ../IO/stderr.txt