(* open Yojson.Basic

let rec print_assoc_list = function
  | [] -> ()
  | (key, value) :: rest ->
    Printf.printf "Key: %s, Value: %s\n" key (string_of_int value);
    print_assoc_list rest

(* let get_node_text node =
  match node with
  | `Assoc fields ->
    let info = List.assoc "Info" fields in
    match info with
    | `String str -> str
    | _ -> ""
  | _ -> ""

let get_edge_text edge =
  match edge with
  | `Assoc fields ->
    let info = List.assoc "Info" fields in
    match info with
    | `String str -> str
    | _ -> ""
  | _ -> ""

let print_table nodes edges =
  Printf.printf "node\t\t\t\t\t| relationship\t| node\n";
  Printf.printf "----------------------------+---------------+---------------------\n";
  List.iter (fun (_, edge) ->
    let source_id = edge |> List.assoc "Source" |> int_of_string in
    let target_id = edge |> List.assoc "Target" |> int_of_string in
    let source = List.assoc (string_of_int source_id) nodes in
    let target = List.assoc (string_of_int target_id) nodes in
    (* Printf.printf "%s\t| %s\t\t| %s\n" (get_node_text source) (edge |> List.assoc "text" |> Yojson.Basic.Util.to_string) (get_node_text target) *)
    (* Printf.printf "%s\t| %s\t\t| %s\n" (get_node_text source) (edge |> List.assoc "Text" |> Yojson.Basic.Util.to_assoc |> List.assoc "Text" |> Yojson.Basic.Util.to_string) (get_node_text target) *)
    Printf.printf "%s\t| %s\t\t| %s\n" (get_node_text source) "edge_text" (get_node_text target)

  ) edges   *)

(* Function to parse JSON data *)
let parse_json_data json_str =
  (* let json = Yojson.Basic.from_string json_str in *)
  (* match json with
  | `Assoc data ->
    let nodes = List.assoc "nodes" data |> Util.to_assoc in
    let edges = List.assoc "edges" data |> Util.to_assoc in
    (* print_table nodes edges *)
  | _ -> () *)
  let my_list = [("a", 1); ("b", 2); ("c", 3)] in
  print_assoc_list my_list
  Printf.printf json_str *)