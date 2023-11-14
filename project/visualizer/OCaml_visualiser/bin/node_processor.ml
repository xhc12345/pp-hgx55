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

let print_all_nodes assoc_list = List.iter (
  fun (_, value) ->
      (* Printf.printf "\"%s\":, " key; *)
      print_node_simple value
) assoc_list

(* given assoc list of nodes, create new assoc list for the sum of each repeating prop *)
let compile_prop_sum allNodes =
  List.fold_left (
    fun allSums (_, n) -> (* each node n *)
      List.fold_left (    (* do operation on the basis of allSums *)
        fun allSums (prop, value) ->
          match value with
          | `Int num ->   (* if num can be generated from value, then it's an integer value *)
            (* get current sum for this prop, if none assume 0 *)
            let currSum = try List.assoc prop allSums with Not_found -> 0 in
            (* remove old key-val pair, then prepend the updated pair *)
            (prop, currSum + num) :: (List.remove_assoc prop allSums)
          | _ -> allSums
      ) allSums n.props
  ) [] allNodes

(* given assoc list of nodes, create new assoc list for the sum of each repeating prop *)
let compile_prop_count allNodes =
  List.fold_left (
    fun allCounts (_, n) -> (* each node n *)
      List.fold_left (    (* do operation on the basis of allCounts *)
        fun allCounts (prop, value) ->
          match value with
          | `Int _ ->   (* if Int can be generated from value, then it's an integer value *)
            (* get current count for this prop, if none assume 0 *)
            let currCnt = try List.assoc prop allCounts with Not_found -> 0 in
            (* remove old key-val pair, then prepend the updated pair *)
            (prop, currCnt + 1) :: (List.remove_assoc prop allCounts)
          | _ -> allCounts
      ) allCounts n.props
  ) [] allNodes

(* Calculate statistics: average value of the sum of all int values for each property *)
let get_node_prop_averages nodes =
  let allPropSums = nodes |> compile_prop_sum in
  let allPropCounts = nodes |> compile_prop_count in
  allPropCounts |> List.map (
    fun (prop, count) -> (* for each prop counted do: *)
      (* using the prop present, get its respective sums from allPropSums *)
      let sum = try List.assoc prop allPropSums with Not_found -> 0 in
      let avg = (float_of_int sum) /. (float_of_int count) in
      (prop, avg)     (* returnee *)
  )