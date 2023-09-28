/**
 * @file    main.cpp
 * @brief   program entry for Cypher semantic analyzer program
 *          initial version using demo from ANTLR GitHub to test setup
 * @version 0.1
 * @date    2023-09-20
 */

#include <iostream>

#include "antlr4-runtime.h"
#include "build/CypherLexer.h"
#include "build/CypherParser.h"

#pragma execution_character_set("utf-8")

using namespace antlrcpptest;
using namespace antlr4;

int main(int argc, const char* argv[]) {
  ANTLRInputStream input(
      "MATCH (tom:Person {name:\'Tom Hanks\'})-[rel:DIRECTED]-(movie:Movie)\n "
      "RETURN tom.name AS name, tom.born AS \'Year Born\', movie.title AS "
      "title, movie.released AS \'Year Released\'");
  CypherLexer lexer(&input);
  CommonTokenStream tokens(&lexer);

  CypherParser parser(&tokens);
  tree::ParseTree* tree = parser.oC_Cypher();

  auto s = tree->toStringTree(&parser);
  std::cout << "Parse Tree: " << s << std::endl;

  return 0;
}