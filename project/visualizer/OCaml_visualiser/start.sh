#!/bin/bash

dir=$(dirname "$0")
cd $dir

set -e  # stop when error

echo "building ocaml visualizer"
opam exec -- dune build

echo "starting visualizer program"
./_build/default/bin/main.exe