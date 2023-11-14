#!/bin/bash

dir=$(dirname "$0")
cd $dir

# Define the file name
file_name="queries/1.cql"

# Define the REST API endpoint
api_endpoint="http://localhost:8080/run"

# Check if the file exists
if [ ! -f "$file_name" ]; then
  echo "Error: File $file_name not found."
  exit 1
fi

# Measure the execution time of the curl command
start_time=$(date +%s.%N)
curl -s -o /dev/null -X POST -H "Content-Type: application/octet-stream" -d "@$file_name" "$api_endpoint"
end_time=$(date +%s.%N)

# Calculate the execution time
execution_time=$(echo "$end_time - $start_time" | bc)
# Print the execution time
echo "Curl command took $execution_time seconds to execute."