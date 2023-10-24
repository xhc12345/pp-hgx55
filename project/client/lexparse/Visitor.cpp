#include "Visitor.h"
#include <iostream>
#include <fstream>

// using namespace std;

bool isUpdatingGraph = false;

std::any Visitor::visitOC_Cypher(CypherParser::OC_CypherContext* ctx) {
  std::cout << "Starts visiting..." << std::endl;
  isUpdatingGraph = false;  // reset flag for new query
  std::any ret = visitChildren(ctx);  // visit all tokens

  // at this point, the entire AST has been visited. If flag triggered then it's a modify query
  // TODO: generate new file to indicate the query as updating
  ofstream flagFile;
  flagFile.open ("../IO/isModifyQuery.txt");
  if(isUpdatingGraph){  
    flagFile << "true\n";
  } else{
    flagFile << "false\n";
  }
  flagFile.close();
  
  return ret
}

/* 
  TODO: add functionality to check if graph-modifying keywords are present
  and store it in a file in IO folder.
  Thoughts: when visiting terminals like "CREATE" or "MERGE" that are operands,
  not user-defined IDs, trigger a global flag. Once returned to visitOC_Cypher,
  generate new file with flag.
*/

std::any Visitor::visitOC_UpdatingClause(CypherParser::OC_UpdatingClauseContext *ctx){
  std::cout << "Encountering Modifying Keyword (Updating Clause) in query..." << std::endl;
  isUpdatingGraph = true; // set flag
  return visitChildren(ctx);
}