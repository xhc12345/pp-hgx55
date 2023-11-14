#!/bin/bash

dir=$(dirname "$0")
cd $dir

fileName="queries/1.cql"
API_ENDPOINT="http://localhost:8080/run"

# Check if the file exists
if [ ! -f "$fileName" ]; then
  echo "Error: File $fileName not found."
  exit 1
fi

iterations=10
totalTime=0

# Run the curl command by iteration times
for ((i=1; i<=$iterations; i++)); do
  startTime=$(date +%s.%N)
  curl -s -o /dev/null -X POST -H "Content-Type: application/octet-stream" -d "@$fileName" "$API_ENDPOINT"
  endTime=$(date +%s.%N)
  # Calculate the execution time for current iteration and add it to total
  execTime=$(echo "$endTime - $startTime" | bc)
  totalTime=$(echo "$totalTime + $execTime" | bc)
done

# Calculate the average execution time
avgExecTime=$(echo "scale=4; $totalTime / $iterations" | bc)

# Print the average execution time
echo "Average execution time over $iterations iterations: $avgExecTime seconds. Total time: $totalTime seconds"