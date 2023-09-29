#include "Visitor.h"

using namespace std;

std::any Visitor::visitOC_Cypher(CypherParser::OC_CypherContext* ctx) {
  std::cout << "Starts visiting..." << std::endl;
  return visitChildren(ctx);
}
