#!/bin/bash
dir=$(dirname "$0")
cd $dir

# bash ./lexparse/compile.sh
python3 Client.py
echo "closing client"