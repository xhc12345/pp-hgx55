package main

type Node struct {
	id    string
	text  []string // Labels
	info  string
	props map[string]any
}

type Edge struct {
	id     string
	text   string // Type
	source string // StartElementId
	target string // EndElementId
	info   string
	props  map[string]any
}
