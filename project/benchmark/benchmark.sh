#!/bin/bash

dir=$(dirname "$0")
cd $dir

echo "STARTING BENCHMARK"
./curl.sh

