let input = "../Smalltalk/input/input.json" in

Printf.printf "\n...............................................\n";
Printf.printf "All nodes:\n";
let node_json = File_fetch.get_nodes_or_edges input "nodes" in
let nodes = Node_processor.read_nodes_str node_json in
Node_processor.print_all_nodes nodes;

Printf.printf "\n";

let nodesPropAvg = Node_processor.get_node_prop_averages nodes in
Graph_generator.print_prop_averages nodesPropAvg;

Printf.printf "\n...............................................\n";
Printf.printf "All edges:\n";
let edge_json = File_fetch.get_nodes_or_edges input "edges" in
let edges = Edge_processor.read_edges_str edge_json nodes in
Edge_processor.print_all_edges edges;

Printf.printf "\n";

let edgesPropAvg = Edge_processor.get_edge_prop_averages edges in
Graph_generator.print_prop_averages edgesPropAvg;

Printf.printf "\n...............................................\n";