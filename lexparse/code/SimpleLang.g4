grammar SimpleLang;

// #####    lexer   #####

// Keywords
PROJECT: 'project';
CLASS: 'class';
INTERFACE: 'interface';
ENUM: 'enum';
CONST: 'const';
IF: 'if';
FOR: 'for';
RETURN: 'return';
VOID: 'void';

// Identifiers
IDENT: [a-zA-Z_] [a-zA-Z_0-9]*;

// Constants
NUM_CONST: [0-9]+;
CHAR_CONST: '\'' [a-zA-Z] '\'';
BOOL_CONST: 'true' | 'false';

// Operators
ADDOP: '+' | '-';
MULOP: '*' | '/' | '%';
RELOP: '==' | '!=' | '>' | '>=' | '<' | '<=';
ASSIGNOP: '=';

// Other symbols
SEMICOLON: ';';
COMMA: ',';
DOT: '.';
LPAREN: '(';
RPAREN: ')';
LBRACKET: '[';
RBRACKET: ']';
LBRACE: '{';
RBRACE: '}';

// #####    parser  #####

// Define rules for statements and expressions similarly.
// Example: ifStatement, forStatement, returnStatement, etc.

r  : 'hello' ID EOF ;         // match keyword hello followed by an identifier

ID : [a-z]+ ;             // match lower-case identifiers

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

OTHER: . ;
