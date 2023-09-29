#include <string>
#include "antlr4-runtime.h"
#include "libs/CypherBaseVisitor.h"

class Visitor : public CypherBaseVisitor {
 public:
  virtual std::any visitOC_Cypher(CypherParser::OC_CypherContext* ctx);
};