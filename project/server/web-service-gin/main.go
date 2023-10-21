package main

import (
	"fmt"

	"github.com/gin-gonic/gin"
)

const QUERY string = "MATCH (p:Person{name:'tom'})-[r:Rel]-(r:Movie)\r\nRETURN p, r, m"

func main() {
	fmt.Println("### SERVER IS RUNNING ##")
	// sendQueryToDB(QUERY)
	start()
}

func setupRouter() *gin.Engine {
	router := gin.Default()
	router.GET("/ping", ping)
	router.POST("/run", runCqlCmd)
	return router
}

func start() {
	router := setupRouter()
	// router.GET("/albums", getAlbums)
	// router.GET("/albums/:id", getAlbumByID)
	// router.POST("/albums", postAlbums)
	router.Run("localhost:8080") // listen and serve on localhost:8080
}
