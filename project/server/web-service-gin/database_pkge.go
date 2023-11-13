package main

import (
	"context"
	"fmt"
	"os"

	"github.com/neo4j/neo4j-go-driver/v5/neo4j"
)

func handleError(err error) {
	if err != nil {
		panic(err)
	}
}

type ctxCloser interface {
	Close(context.Context) error
}

func handleClose(ctx context.Context, closer ctxCloser) {
	handleError(closer.Close(ctx))
}

const QUERY_TEST string = "MATCH (n) RETURN n"

func testRun() {
	ctx := context.Background()
	DB_address := os.Getenv("neo4j@v4_address") // set by main.go
	DB_account := os.Getenv("neo4j@v4_account")
	DB_password := os.Getenv("neo4j@v4_password")
	driver, err := neo4j.NewDriverWithContext(DB_address, neo4j.BasicAuth(DB_account, DB_password, ""))
	handleError(err)
	err = driver.VerifyConnectivity(ctx)
	handleError(err)
	defer handleClose(ctx, driver)

	session := driver.NewSession(ctx, neo4j.SessionConfig{ /*AccessMode: neo4j.AccessModeWrite*/ })
	defer handleClose(ctx, session)

	result, err := session.Run(ctx, QUERY_TEST, nil)
	handleError(err)
	for result.Next(ctx) {
		record := result.Record()
		nodeValue := record.Values[0]
		node, convertible := nodeValue.(neo4j.Node)
		if !convertible {
			panic("NODE NOT OK")
		}
		nodeID := node.GetElementId()
		nodeLabels := node.Labels
		nodeProps := node.Props
		fmt.Println("Node ID:", nodeID, "\tLabels:", nodeLabels, "\n\tProps:", nodeProps)
	}
}
