package main

import (
	"fmt"
	"os"
	"os/exec"
	"strings"
)

func sendQueryToDB(query string) bool {
	writeInput(query)
	fmt.Println("Sending command to Neo4j Cypher Shell")
	cmd := exec.Command("./runQuery.sh")
	err := cmd.Run()
	if err != nil {
		return false
	}
	checkResponseForError()
	return true
}

func writeInput(query string) bool {
	file, errs := os.Create("IO/in.cql")
	if errs != nil {
		fmt.Println("Failed to create file:", errs)
		return false
	}
	fmt.Println("Successfully written to in.cql")
	file.WriteString(query)
	defer file.Close()
	return true
}

func checkResponseForError() bool {
	b, err := os.ReadFile("IO/out.txt")
	if err != nil {
		fmt.Println("Failed to find out.txt:", err)
		return false
	}
	output := string(b)
	const ESC string = "\x1b" // \x1b === 
	isError := strings.Contains(output, ESC)
	if isError {
		fmt.Println("IO/out.txt contains error:")
		fmt.Println(output)
		return false
	} else {
		fmt.Println("IO/out.txt doesn't have error")
		fmt.Println(output)
		return true
	}
}
