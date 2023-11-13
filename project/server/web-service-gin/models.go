package main

import "strconv"

type Node struct {
	ID     string
	Text   string   // summary display
	Labels []string // Labels
	Info   string
	Props  map[string]any
}

// increment the str ID, assuming its a number
func (n *Node) make_smalltalk_friendly() {
	id, err := strconv.Atoi(n.ID)
	handleError(err)
	id++
	n.ID = strconv.Itoa(id)
}

type Edge struct {
	ID     string
	Text   string // Type
	Source string // StartElementId
	Target string // EndElementId
	Info   string
	Props  map[string]any
}

// increment the ID, Source, and Target, assuming they are numbers
func (e *Edge) make_smalltalk_friendly() {
	id, err := strconv.Atoi(e.ID)
	handleError(err)
	s, err := strconv.Atoi(e.Source)
	handleError(err)
	t, err := strconv.Atoi(e.Target)
	handleError(err)

	id++
	s++
	t++

	e.ID = strconv.Itoa(id)
	e.Source = strconv.Itoa(s)
	e.Target = strconv.Itoa(t)
}
