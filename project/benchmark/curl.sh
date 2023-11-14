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

# Number of iterations
iterations=100

# Initialize total execution time
total_execution_time=0

# Run the curl command multiple times
for ((i=1; i<=$iterations; i++)); do
  start_time=$(date +%s.%N)
  curl -s -o /dev/null -X POST -H "Content-Type: application/octet-stream" -d "@$file_name" "$api_endpoint"
  end_time=$(date +%s.%N)

  # Calculate the execution time for each iteration
  execution_time=$(echo "$end_time - $start_time" | bc)

  # Add to the total execution time
  total_execution_time=$(echo "$total_execution_time + $execution_time" | bc)
done

# Calculate the average execution time
average_execution_time=$(echo "scale=4; $total_execution_time / $iterations" | bc)

# Print the average execution time
echo "Average execution time over $iterations iterations: $average_execution_time seconds. Total time: $total_execution_time seconds"