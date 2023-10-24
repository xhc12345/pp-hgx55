#include "Visitor.h"

using namespace std;

std::any Visitor::visitOC_Cypher(CypherParser::OC_CypherContext* ctx) {
  std::cout << "Starts visiting..." << std::endl;
  return visitChildren(ctx);
}

/* 
  TODO: add functionality to check if graph-modifying keywords are present
  and store it in a file in IO folder.
  Thoughts: when visiting terminals like "CREATE" or "MERGE" that are operands,
  not user-defined IDs, trigger a global flag. Once returned to visitOC_Cypher,
  generate new file with flag.
*/