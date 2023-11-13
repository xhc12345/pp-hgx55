open Graph_generator

let () =
  let json_str = {|{
    "nodes":{
        "1":{
            "text":"Person",
            "info":"{name: 'Alexia Midgar'}"
        },
        "2":{
            "text":"Person",
            "info":"{name: 'Beta'}"
        },
        "3":{
            "text":"Person",
            "info":"{name: 'Cid Kagenou'}"
        }
    },
    "edges":{
        "1":{
            "text":"Loves",
            "source":"1",
            "target":"3"
        },
        "2":{
            "text":"Loves",
            "source":"2",
            "target":"3"
        },
        "3":{
            "text":"Hates",
            "source":"1",
            "target":"2"
        }
    }
}|} in

  Graph_generator.parse_json_data json_str
