#include <iostream>
#include <fstream>

#include "Visitor.h"
#include "antlr4-runtime.h"
#include "libs/CypherLexer.h"
#include "libs/CypherParser.h"

using namespace std;
using namespace antlr4;

bool hasErrors = false;
const bool isUpdatingGraph = false;
void setUpdatingClauseFlag(){
  std::ofstream flagFile;
  flagFile.open ("../IO/isModifyQuery.txt");
  if(isUpdatingGraph){  
    flagFile << "true\n";
  } else {
    flagFile << "false\n";
  }
  flagFile.close();
}

class LexerErrorListener : public antlr4::BaseErrorListener {
 public:
  virtual void syntaxError(antlr4::Recognizer* recognizer,
                           antlr4::Token* offendingSymbol,
                           size_t line,
                           size_t charPositionInLine,
                           const std::string& msg,
                           std::exception_ptr e) override {
    hasErrors = true;
    std::cerr << "Lexer Error at line " << line << ":" << charPositionInLine
              << " - " << msg << std::endl;
  }
};

class ParserErrorListener : public antlr4::BaseErrorListener {
 public:
  virtual void syntaxError(antlr4::Recognizer* recognizer,
                           antlr4::Token* offendingSymbol,
                           size_t line,
                           size_t charPositionInLine,
                           const std::string& msg,
                           std::exception_ptr e) override {
    hasErrors = true;
    std::cerr << "Parser Error at line " << line << ":" << charPositionInLine
              << " - " << msg << std::endl;
  }
};

int main(int argc, const char* argv[]) {
  // std::cout << "Running Cypher Lexer and Parser..." << std::endl;

  std::ifstream stream;
  stream.open("../IO/input.cql");

  ANTLRInputStream input(stream);
  // std::cout << "Fetched input, generating lexer..." << std::endl;
  CypherLexer lexer(&input);
  lexer.removeErrorListeners();
  lexer.addErrorListener(new LexerErrorListener());
  // std::cout << "Lexer generated, creating tokens..." << std::endl;
  CommonTokenStream tokens(&lexer);

  // std::cout << "Tokens created, generating parser..." << std::endl;
  CypherParser parser(&tokens);
  parser.removeErrorListeners();
  parser.addErrorListener(new ParserErrorListener());
  // std::cout << "Parser generated, creating AST..." << std::endl;
  CypherParser::OC_CypherContext* tree = parser.oC_Cypher();

  // std::cout << "AST created, printing..." << std::endl;
  auto s = tree->toStringTree(&parser);
  std::cout << "Parse Tree: " << s << std::endl;

  if(!hasErrors){
    // std::cout << "Start visiting tree..." << s << std::endl;
    Visitor visitor;
    visitor.visit(tree);
  }
  

  return 0;
}