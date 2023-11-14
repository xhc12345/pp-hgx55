#!/bin/bash

dir=$(dirname "$0")
cd $dir

echo "STARTING BENCHMARK"


folder="queries"
# Checks if the subfolder exists
if [ ! -d "$folder" ]; then
  echo "Error: Subfolder $folder not found."
  exit 1
fi

# goes through each cql file in queries folder
cd $folder
for file in *; do
  # Check if the file exists
  if [ ! -f "$file" ]; then
    echo "File doens't exists: $file"
    continue
  fi

  # Runs the query in the file against server 100 times
  ./../curl.sh "$file"
done

cd ..

echo "DONE"