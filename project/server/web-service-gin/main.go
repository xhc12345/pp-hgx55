package main

import (
	"fmt"

	"github.com/gin-gonic/gin"
)

func main() {
	fmt.Println("### SERVER IS RUNNING ##")
	router := gin.Default()
	router.GET("/ping", ping)
	router.POST("/run", runCqlCmd)
	// router.GET("/albums", getAlbums)
	// router.GET("/albums/:id", getAlbumByID)
	// router.POST("/albums", postAlbums)
	router.Run("localhost:8080") // listen and serve on localhost:8080
}
