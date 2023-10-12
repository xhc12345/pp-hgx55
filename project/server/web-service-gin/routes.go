package main

import (
	"fmt"
	"net/http"

	"github.com/gin-gonic/gin"
)

func ping(c *gin.Context) {
	fmt.Println("### RECEIVED PING REQUEST ##")
	c.JSON(http.StatusOK, gin.H{
		"message": "ping",
	})
}
