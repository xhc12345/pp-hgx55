package main

import (
	"bytes"
	"net/http"
	"net/http/httptest"
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestPingRoute(t *testing.T) {
	router := setupRouter()
	w := httptest.NewRecorder()

	reqPing, _ := http.NewRequest("GET", "/ping", nil)
	router.ServeHTTP(w, reqPing)
	assert.Equal(t, 200, w.Code)
}

func TestRunRoute(t *testing.T) {
	router := setupRouter()
	w := httptest.NewRecorder()

	testRun := []byte("CREATE (n:Person {name: 'Alice', age: 30}) RETURN n" + "CREATE (n:Person {name: 'Bob', age: 28}) RETURN n" + "CREATE (n:Company {name: 'Acme Inc.'}) RETURN n" + "MATCH (person:Person {name: 'Alice'}), (company:Company {name: 'Acme Inc.'}) CREATE (person)-[:WORKS_AT]->(company)" + "MATCH (alice:Person {name: 'Alice'}), (bob:Person {name: 'Bob'}) CREATE (alice)-[:FRIENDS_WITH]->(bob)" + "MATCH (person:Person) RETURN person" + "MATCH (company:Company) RETURN company")
	testRunReader := bytes.NewReader(testRun)

	reqRun, _ := http.NewRequest("POST", "/run", testRunReader)
	router.ServeHTTP(w, reqRun)
	assert.Equal(t, 200, w.Code)
}

func TestGraphRoute(t *testing.T) {
	router := setupRouter()
	w := httptest.NewRecorder()

	reqRun, _ := http.NewRequest("GET", "/graph", nil)
	router.ServeHTTP(w, reqRun)
	assert.Equal(t, 200, w.Code)
}
