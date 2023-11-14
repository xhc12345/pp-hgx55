#!/bin/bash

echo "updating opam"
opam update

echo "installing dependencies"
opam install .