

let input = "../Smalltalk/input/input.json" in

let node_json = File_fetch.get_nodes_or_edges input "nodes" in

let nodes = Node_processor.read_nodes_str node_json in
let print_all_nodes assoc_list = 
    List.iter (fun (key, value) ->
        Printf.printf "\"%s\":, " key;
        Node_processor.print_node_simple value
    ) assoc_list
in
print_all_nodes nodes;

Printf.printf "\n=====================\n";

let edge_json = File_fetch.get_nodes_or_edges input "edges" in

let edges = Edge_processor.read_edges_str edge_json nodes in
let print_all_edges assoc_list =
    List.iter (fun (key, value) ->
        Printf.printf "\"%s\":, " key;
        Edge_processor.print_edge_simple value
    ) assoc_list
in
print_all_edges edges

