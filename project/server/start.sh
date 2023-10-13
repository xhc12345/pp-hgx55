#!/bin/bash

dir=$(dirname "$0")
cd $dir

# start the database
./../database/setup.sh

# start the server
./initServer.sh

# clean up the database too
./../database/cleanUp.sh