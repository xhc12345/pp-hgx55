grammar SimpleLang;

// #####    lexer   #####

// keywords
PROJECT: 'project';
CLASS: 'class';
INTERFACE: 'interface';
ENUM: 'enum';
CONST: 'const';
IF: 'if';
FOR: 'for';
RETURN: 'return';
VOID: 'void';

// constants
Num_Const: '-'?[0-9]+;
Char_Const: '\'' [a-zA-Z] '\'';
Boolean_Const: 'true' | 'false';
Type_Const: 'int' | 'char' | 'boolean';

// operators
Assignop: '=';
Relop: '==' | '!=' | '>' | '>=' | '<' | '<=';
Addop: '+' | '-';
Mulop: '*' | '/' | '%';



ID: [a-zA-Z_] [a-zA-Z_0-9]*;
STRING: '"'[a-z]*'"';

WHITE_SPACE: [ \t\r\n] -> skip;
COMMENT: '//' ~[\r\n]* -> skip;
OTHER: .;

// #####    parser  #####

project:
    'project' ID (
        constDecl | varDecl | classDecl | enumDecl | interfaceDecl
    )* '{' 
        methodDecl+     // at least the entry() method
    '}' EOF;

constDecl:
    'const' Type_Const ID '=' 
        (Num_Const | Char_Const | Boolean_Const)
        (',' ID '='
            (Num_Const | Char_Const | Boolean_Const)
        )*  // multiple const declarations in the same line
    ';';

enumDecl:
    'enum' ID '{'
        ID ('=' Num_Const)?
        (',' ID ('=' Num_Const)?)*
    '}';

varDecl: 'var' ID ';';
classDecl: 'class C implements I';
interfaceDecl: 'interface I';
methodDecl: 'void entry(){}';