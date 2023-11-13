#!/bin/bash

dir=$(dirname "$0")
cd $dir

export dune="~/.opam/default/bin/dune"

echo "updating opam"
opam update

echo "installing dependencies"
opam install .

bash ./start.sh