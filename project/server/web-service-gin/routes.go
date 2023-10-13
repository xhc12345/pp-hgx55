package main

import (
	"fmt"
	"io"
	"net/http"

	"github.com/gin-gonic/gin"
)

// Path = /ping;
// Sends ok status and let client know that the server is up
func ping(c *gin.Context) {
	fmt.Println("### RECEIVED PING REQUEST ##")
	// time.Sleep(5 * time.Second)
	c.JSON(http.StatusOK, gin.H{
		"success": true,
		"message": "ping ok",
	})
}

// Path = /run;
// Takes input CQL query from request body and sends to Neo4j Cypher Shell
func runCqlCmd(c *gin.Context) {
	fmt.Println("### RECEIVED RUN CMD REQUEST ###")
	bodyData, err := io.ReadAll(c.Request.Body)
	var cmd string = string(bodyData)
	fmt.Println("Body data = " + cmd)
	if err != nil {
		// Handle error
		fmt.Println("\t!!! NO BODY IN THIS REQUEST !!!")
		c.IndentedJSON(http.StatusBadRequest, gin.H{
			"success": false,
			"message": "no request body",
		})
	} else {
		fmt.Println("\tBODY REQUEST:\n" + string(bodyData))
		c.IndentedJSON(http.StatusOK, gin.H{
			"success": true,
			"message": "found request body = " + cmd,
		})
	}
}
