package main

import (
	"context"
	"encoding/json"
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

const QUERY_ALL_NODES string = "MATCH (n) RETURN n"
const QUERY_ALL_EDGES string = "MATCH ()-[r]->() RETURN r"

func processNode(result *neo4j.ResultWithContext, nodeMap *map[string]interface{}) {
	record := (*result).Record()
	nodeValue := record.Values[0]
	node, convertible := nodeValue.(neo4j.Node)
	if !convertible {
		panic("NODE NOT OK")
	}

	nodeID := node.GetElementId()
	nodeLabels := node.Labels
	nodeProps := node.Props
	nodeInfo, err := json.Marshal(nodeProps)
	handleError(err)

	var nodeObj Node = Node{
		ID:    nodeID,
		Text:  nodeLabels,
		Props: nodeProps,
		Info:  string(nodeInfo),
	}

	fmt.Println("Node ID:", nodeObj.ID, "\tLabels:", nodeObj.Text, "\n\tProps:", nodeObj.Props, "\n\tDisplayed info:", nodeObj.Info)

	(*nodeMap)[nodeObj.ID] = nodeObj
}

func processEdge(result *neo4j.ResultWithContext, edgeMap *map[string]interface{}) {
	record := (*result).Record()
	edgeValue := record.Values[0]
	edge, convertible := edgeValue.(neo4j.Relationship)
	if !convertible {
		panic("EDGE NOT OK")
	}

	edgeID := edge.GetElementId()
	edgeEnd := edge.EndElementId
	edgeStart := edge.StartElementId
	edgeType := edge.Type
	edgeProps := edge.Props
	edgeInfo, err := json.Marshal(edgeProps)
	handleError(err)

	var edgeObj Edge = Edge{
		ID:     edgeID,
		Text:   edgeType,
		Source: edgeStart,
		Target: edgeEnd,
		Props:  edgeProps,
		Info:   string(edgeInfo),
	}
	fmt.Println("Edge ID:", edgeObj.ID, "\tFrom", edgeObj.Source, "to", edgeObj.Target, "\tType:", edgeObj.Text, "\n\tProps:", edgeObj.Props, "\n\tDisplayed info:", edgeObj.Info)

	(*edgeMap)[edgeObj.ID] = edgeObj
}

func getAllNodesOrEdges(nodeMode bool, mapOfTargets *map[string]interface{}) {
	// if nodeMode is true, get all nodes. else get all edges
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

	var queryToSend string
	var processFunction func(*neo4j.ResultWithContext, *map[string]interface{})
	if nodeMode { // get all nodes
		queryToSend = QUERY_ALL_NODES
		processFunction = processNode
	} else { // get all edges
		queryToSend = QUERY_ALL_EDGES
		processFunction = processEdge
	}

	result, err := session.Run(ctx, queryToSend, nil)
	handleError(err)
	for result.Next(ctx) {
		processFunction(&result, mapOfTargets)
	}

}

func compileGraph() map[string]interface{} {
	graphMap := make(map[string]interface{})

	nodeMap := make(map[string]interface{})
	getAllNodesOrEdges(true, &nodeMap)
	graphMap["nodes"] = nodeMap

	fmt.Println()

	edgeMap := make(map[string]interface{})
	getAllNodesOrEdges(false, &edgeMap)
	graphMap["edges"] = edgeMap

	graphJSON, err := json.MarshalIndent(graphMap, "", "\t")
	handleError(err)
	fmt.Println("FINAL GRAPH JSON:")
	fmt.Println(string(graphJSON))

	return graphMap
}
