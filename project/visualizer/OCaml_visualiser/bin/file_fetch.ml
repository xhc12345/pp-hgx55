open Yojson.Basic

(* read json from <filename>, then return json corresponding to <key> at top level *)
let get_nodes_or_edges filename key =
  let json = from_file filename in
  (match json with
  | `Assoc alist ->
    begin match List.assoc key alist with
    | `Assoc edges_json -> to_string (`Assoc edges_json)
    | _ -> "{}"
    end
  | _ -> "{}")