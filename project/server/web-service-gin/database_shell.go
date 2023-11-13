package main

import (
	"fmt"
	"os"
	"os/exec"
	"strings"
)

func sendQueryToDB(query string) bool {
	if !writeInput(query) {
		return false
	}
	cmd := exec.Command("./runQuery.sh")
	err := cmd.Run()
	if err != nil {
		fmt.Println(err)
		return false
	}
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

func responseHasError() (bool, string) {
	b, err := os.ReadFile("IO/out.txt")
	if err != nil {
		return true, "Failed to find output file from db:" + err.Error()
	}
	output := string(b)
	const ESC string = "\x1b" // \x1b === 
	isError := strings.Contains(output, ESC)
	if isError {
		// fmt.Println("IO/out.txt contains error:")
		// fmt.Println(output)
		return true, output
	} else {
		// fmt.Println("IO/out.txt doesn't have error")
		// fmt.Println(output)
		return false, output
	}
}
