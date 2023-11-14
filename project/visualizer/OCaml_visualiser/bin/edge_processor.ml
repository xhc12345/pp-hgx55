open Yojson.Basic

type edge = {
  id:         string;
  edge_type:  string;
  source:     Node_processor.node;
  target:     Node_processor.node;
  props:      (string * t) list;  (* Assoc list, string as key and any as val *)
}

(* json -> edge *)
let edge_of_json allNodes json  = {
  id = json |> Util.member "ID" |> Util.to_string;
  edge_type = json |> Util.member "Text" |> Util.to_string;
  source = json |> Util.member "Source" |> Util.to_string |> Node_processor.find_node_by_id allNodes;
  target = json |> Util.member "Target" |> Util.to_string |> Node_processor.find_node_by_id allNodes;
  props = (match json |> Util.member "Props" with
    | `Assoc assoc -> List.map (fun (key, value) -> (key, value)) assoc
    | _ -> []
  );
}

(* take stringified map of edges and convert to list of assoc *)
let read_edges_str edges_json allNodes =
  let json = from_string edges_json in
  (match json with
  | `Assoc assoc -> List.map (fun (key, value) ->
      (key, value |> edge_of_json allNodes)
    ) assoc
  | _ -> []
  )

let print_edge_simple edge =
  let id = edge.id in
  let eType = edge.edge_type in
  let s = edge.source.text in
  let t = edge.target.text in
  let props = String.concat ", " (List.map (
    fun (key, value) ->
      key ^ "=" ^ to_string value
  ) edge.props) in
  Printf.printf
    "| ID: %s | (%s)-[%s]->(%s) | Type: %s | Props: %s |\n"
           id    s    eType t           eType       props