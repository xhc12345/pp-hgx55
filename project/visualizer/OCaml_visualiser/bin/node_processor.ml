open Yojson.Basic

type node = {
  id:     string;
  text:   string;             (* server-optimized smart display text *)
  labels: string list;
  props:  (string * t) list;  (* Assoc list, string as key and any as val *)
}

(* json -> node *)
let to_node json = {
  id = json |> Util.member "ID" |> Util.to_string;
  text = json |> Util.member "Text" |> Util.to_string;
  labels = (match json |> Util.member "Labels" with
    | `List labels -> List.map (fun label -> Util.to_string label) labels
    | _ -> []
  );
  props = (match json |> Util.member "Props" with
    | `Assoc tuples -> List.map (fun (key, value) -> (key, value)) tuples
    | _ -> []
  );
}

(* default not found node *)
let default_node = {
  id = "-1";
  text = "Nil";
  labels = [];
  props = [];
}

(* take stringified map of nodes and convert to list of assoc *)
let read_nodes_str nodes_json =
  let json = from_string nodes_json in
  (match json with
  | `Assoc tuples -> List.map (fun (key, value) ->
      (key, value |> to_node)
    ) tuples
  | _ -> []
  )

let find_node_by_id allNodes id =
  match List.assoc id allNodes with
  | exception Not_found -> default_node
  | v -> v

(* print a node's summary *)
let print_node_simple node =
  let id = node.id in
  let text = node.text in
  let labels = String.concat ", " node.labels in
  let props = String.concat ", " (List.map (
    fun (key, value) ->
      key ^ "=" ^ to_string value
  ) node.props) in
  Printf.printf
    "| ID: %s | Text: %s | Labels: %s | Props: %s |\n"
           id         text         labels      props