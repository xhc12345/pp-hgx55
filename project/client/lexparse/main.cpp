/**
 * @file    main.cpp
 * @brief   program entry for Cypher semantic analyzer program
 *          initial version using demo from ANTLR GitHub to test setup
 * @version 0.1
 * @date    2023-09-20
 */

#include <iostream>

#include "TLexer.h"
#include "TParser.h"
#include "antlr4-runtime.h"

using namespace antlrcpptest;
using namespace antlr4;

int main(int argc, const char* argv[]) {
  ANTLRInputStream input(
      "a = b + \"c\";(((x * d))) * e + f; a + (x * (y ? 0 : 1) + z);");
  TLexer lexer(&input);
  CommonTokenStream tokens(&lexer);
  // tokens.fill();
  // for (auto token : tokens.getTokens()) {
  //   std::cout << token->toString() << std::endl;
  // }

  TParser parser(&tokens);
  tree::ParseTree* tree = parser.main();

  auto s = tree->toStringTree(&parser);
  std::cout << "Parse Tree: " << s << std::endl;

  return 0;
}