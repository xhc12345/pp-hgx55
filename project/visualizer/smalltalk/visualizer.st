"Change this file to desired path of the JSON file"
fileName := 'input/input.json'.
fileName asFileReference readStreamDo: [ :readStream |
	data := STONJSON fromStream: readStream
].

dict_nodes := data at: 'nodes'.
dict_edges := data at: 'edges'.

Transcript show: dict_nodes asString.
Transcript cr.
Transcript show: dict_edges asString.
Transcript cr.

numberOfEdges := dict_edges size.
numberOfNodes := dict_nodes size.
nodeSize := 50.

data_nodes := OrderedCollection new.
1 to: numberOfNodes do: [:index |
    | node |
    node := dict_nodes at: (index asString).
    data_nodes add: node.
].

data_edges := OrderedCollection new.
1 to: numberOfEdges do: [:index |
    | edge |
    edge := dict_edges at: (index asString).
    data_edges add: edge.
].

"==========================================================="

Transcript show: '================================='.
Transcript cr.

1 to: numberOfNodes do: [ :i|
	Transcript show: 'text for Node  ', i asString, ' = "',((data_nodes at: i) at: 'Text'), '", additional info: ', ((data_nodes at: i) at: 'Info') asString.
	Transcript cr.
].


1 to: numberOfEdges do: [ :i|
	Transcript show: 'text at ', i asString, ' = "',((data_edges at: i) at: 'Text'), '", from ', ((data_edges at: i) at: 'Source') asString, ' to ', ((data_edges at: i) at: 'Target') asString.
	Transcript cr.
].

"==========================================================="

"Create graph"
graph := RSCanvas new.

"Add nodes"
nodes := RSCircle models: (1 to: numberOfNodes) size: [ :nb | nodeSize ]. 
1 to: nodes size do: [ :i |
	| node node_data label hoverText |
	node := nodes at: i.
	node_data := data_nodes at: i.
	label := (node_data at: 'Text').
	hoverText := ((node_data at: 'Labels') joinUsing: ', '), Character cr asString, (node_data at: 'Info').
	node @ (RSLabeled highlightable text: label).
	node @ (RSPopup text: hoverText).
	node color: Color black .
].
graph addAll: nodes.

"Add edges"
edges := RSArrowedLine models: (1 to: data_edges size).
1 to: data_edges size do: [ :i |
	| edge edge_data label source target relationship hoverText |
	edge := edges at: i.
	edge_data := data_edges at: i.
	label := (edge_data at: 'Text').
	source := (edge_data at: 'Source') asNumber .
	target := (edge_data at: 'Target') asInteger .
	relationship := ((data_nodes at: source) at: 'Text') asString, ' - ', label, ' -> ', ((data_nodes at: target) at: 'Text').
	hoverText := label, Character cr asString, relationship, Character cr asString, (edge_data at: 'Info').
	
	edge @ (RSLabeled highlightable text: label).
	edge @ (RSPopup text: hoverText).
	
	edge from: (nodes at: source).
	edge to: (nodes at: target).
	edge attachPoint: RSBorderAttachPoint new.
	edge color: Color red.
].
"edges do: [ :l | l attachPoint: (RSHorizontalAttachPoint new).  ]."
graph addAll: edges.

"Spread nodes out"
RSGridLayout on: nodes. 
RSLocation new
	above;
	move: nodes first on: nodes allButFirst.
nodes @ RSDraggable.

"Open graph"
graph @ RSCanvasController.
graph open
