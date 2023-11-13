#!/bin/bash

dir=$(dirname "$0")
cd $dir

echo "building ocaml visualizer"
$dune build

echo "starting visualizer program"
bash ./_build/default/bin/main.exe
