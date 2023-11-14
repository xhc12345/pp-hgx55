#!/bin/bash

dir=$(dirname "$0")
cd $dir

echo "STARTING BENCHMARK"


folder="queries"
# Check if the subfolder exists
if [ ! -d "$folder" ]; then
  echo "Error: Subfolder $folder not found."
  exit 1
fi

cd $folder

# Iterate through every CQL file in the subfolder and call the second script for each file
for file in *; do
  # Check if the file exists
  if [ ! -f "$file" ]; then
    echo "File doens't exists: $file"
    continue
  fi

  # Call the second script for each file
  ./../curl.sh "$file"
done

cd ..

echo "DONE"