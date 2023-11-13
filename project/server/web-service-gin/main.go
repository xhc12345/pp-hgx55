package main

import (
	"fmt"
	"os"

	"github.com/gin-gonic/gin"
)

const QUERY string = "MATCH (p:Person{name:'tom'})-[r:Rel]-(r:Movie)\r\nRETURN p, r, m"

const DB_ADDRESS string = "neo4j://localhost:7687"
const DB_ACCOUNT string = "neo4j"
const DB_PASSWORD string = "password"

func main() {
	fmt.Println("### SERVER IS RUNNING ##")

	os.Setenv("neo4j@v4_address", DB_ADDRESS)
	os.Setenv("neo4j@v4_account", DB_ACCOUNT)
	os.Setenv("neo4j@v4_password", DB_PASSWORD)

	// sendQueryToDB(QUERY)
	start()
}

func setupRouter() *gin.Engine {
	router := gin.Default()
	router.GET("/ping", ping)
	router.POST("/run", runCqlCmd)
	router.GET("/graph", getGraph)
	return router
}

func start() {
	router := setupRouter()
	// router.GET("/albums", getAlbums)
	// router.GET("/albums/:id", getAlbumByID)
	// router.POST("/albums", postAlbums)
	router.Run("localhost:8080") // listen and serve on localhost:8080
}
