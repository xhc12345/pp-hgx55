/**
 * @file    main.cpp
 * @brief   program entry for Cypher semantic analyzer program
 *          initial version using demo from ANTLR GitHub to test setup
 * @version 0.1
 * @date    2023-09-20
 */

#include <iostream>

#include "CypherLexer.h"
#include "CypherParser.h"
#include "antlr4-runtime.h"

#pragma execution_character_set("utf-8")

using namespace antlrcpptest;
using namespace antlr4;

int main(int argc, const char* argv[]) {
  ANTLRInputStream input(
      "a = b + \"c\";(((x * d))) * e + f; a + (x * (y ? 0 : 1) + z);");
  CypherLexer lexer(&input);
  CommonTokenStream tokens(&lexer);

  CypherParser parser(&tokens);
  tree::ParseTree* tree = parser.main();

  auto s = tree->toStringTree(&parser);
  std::cout << "Parse Tree: " << s << std::endl;

  return 0;
}