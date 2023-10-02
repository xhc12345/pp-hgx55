#!/bin/bash

# make sure everything done is relative to the location of the script
# and not where it's launched
dir=$(dirname "$0")
cd $dir

mkdir tools
cd tools
set -e
if [ ! -e antlr-4.13.1-complete.jar ]; then
        curl -O https://www.antlr.org/download/antlr-4.13.1-complete.jar
fi
cd ..

mkdir libs
# create a build directory to keep the main one clean
mkdir build
cd build
# to run CMake
cmake ../
# to build on Linux and Mac
make
# run the executable
# ./antlr4-tutorial
# to build and run on Windows
# open the "Antlr-cpp-tutorial.sln" file with Visual Studio generate by CMake inside the build directory
# build and run the project antlr-tutorial (do not select the auto-generated ALL_BUILD)