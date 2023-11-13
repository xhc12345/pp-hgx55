package main

type Node struct {
	ID    string
	Text  []string // Labels
	Info  string
	Props map[string]any
}

type Edge struct {
	ID     string
	Text   string // Type
	Source string // StartElementId
	Target string // EndElementId
	Info   string
	Props  map[string]any
}
