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

let print_all_edges assoc_list = List.iter (
  fun (key, value) ->
    Printf.printf "\"%s\":, " key;
    print_edge_simple value
) assoc_list

(* given assoc list of Edges, create new assoc list for the sum of each repeating prop *)
let compile_prop_sum allEdges =
  List.fold_left (
    fun allSums (_, n) -> (* each Edge n *)
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
  ) [] allEdges

(* given assoc list of Edges, create new assoc list for the sum of each repeating prop *)
let compile_prop_count allEdges =
  List.fold_left (
    fun allCounts (_, n) -> (* each Edge n *)
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
  ) [] allEdges

(* Calculate statistics: average value of the sum of all int values for each property *)
let get_edge_prop_averages edges =
  let allPropSums = edges |> compile_prop_sum in
  let allPropCounts = edges |> compile_prop_count in
  allPropCounts |> List.map (
    fun (prop, count) -> (* for each prop counted do: *)
      (* using the prop present, get its respective sums from allPropSums *)
      let sum = try List.assoc prop allPropSums with Not_found -> 0 in
      let avg = (float_of_int sum) /. (float_of_int count) in
      (prop, avg)     (* returnee *)
  )