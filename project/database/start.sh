#!bin/bash

./setup.sh
sleep 5s

python3 cypherShell.py > out.txt 2> err.txt

./cleanUp.sh