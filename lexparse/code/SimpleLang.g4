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

// const
Num_Const: [0-9]+;
Char_Const: '\'' [a-zA-Z] '\'';
Boolean_Const: 'true' | 'false';
Val_Const: Num_Const | Char_Const | Boolean_Const;
Type_Const: 'int' | 'char' | 'boolean';

// Operators
Assignop: '=';
Relop: '==' | '!=' | '>' | '>=' | '<' | '<=';
Addop: '+' | '-';
Mulop: '*' | '/' | '%';



ID: [a-zA-Z_] [a-zA-Z_0-9]*;
STRING: '"'[a-z]*'"';
ID_String: ID | STRING;

WHITE_SPACE: [ \t\r\n] -> skip;
OTHER: .;

// #####    parser  #####

// Define rules for statements and expressions similarly.
// Example: ifStatement, forStatement, returnStatement, etc.

project: 'project' ID EOF;

constDecl: 'const' Type_Const ID '=' Type_Const (',' ID '=' Val_Const)* ';';