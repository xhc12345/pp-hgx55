open Yojson.Basic

let get_node_text node =
  match node with
  | `Assoc fields ->
    let info = List.assoc "info" fields in
    match info with
    | `String str -> str
    | _ -> ""
  | _ -> ""

let print_table nodes edges =
  Printf.printf "node\t\t\t\t\t| relationship\t| node\n";
  Printf.printf "----------------------------+---------------+---------------------\n";
  List.iter (fun (_, edge) ->
    let source = List.assoc edge["source"] nodes in
    let target = List.assoc edge["target"] nodes in
    Printf.printf "%s\t| %s\t\t| %s\n" (get_node_text source) (edge["text"] |> to_string) (get_node_text target)
  ) edges

(* Function to parse JSON data *)
let parse_json_data json_str =
  let json = Yojson.Basic.from_string json_str in
  match json with
  | `Assoc data ->
    let nodes = List.assoc "nodes" data |> Util.to_assoc in
    let edges = List.assoc "edges" data |> Util.to_assoc in
    print_table nodes edges
  | _ -> ()
