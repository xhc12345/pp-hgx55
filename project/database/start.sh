#!bin/bash

dir=$(dirname "$0")
cd $dir

./setup.sh
sleep 5s

python3 cypherShell.py

./cleanUp.sh