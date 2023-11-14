let print_prop_averages propsAvg =
  Printf.printf " _____________________________________________ \n";
  Printf.printf
    "| %-20s | %-20s |\n"
    "Prop (known int)" "Average value";
  Printf.printf "|----------------------|----------------------|\n";
  List.iter (
    fun (prop, avg) ->
      Printf.printf
        "| %-20s | %-20f |\n"
           prop    avg
  ) propsAvg