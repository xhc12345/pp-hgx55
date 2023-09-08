grammar SimpleLang;

// #####    lexer   #####

// constants
Num_Const:      '-'?[0-9]+;
Char_Const:     '\''.'\'';
Boolean_Const:  'true' | 'false';

// math operators
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
MOD: '%';

// comparison operators
EQ: '==';   // EQual
NEQ: '!=';  // Not EQual
GT: '>';    // Greater Than
GTEQ: '>='; // Greater Than or EQual to
LT: '<';    // Less Than
LTEQ: '<='; // Less Than or EQual to

// logical operators
AND: '&&';
OR: '||';

// assignment Operators
ASSIGN: '=';
INCREMENT: '++';
DECREMENT: '--';

// misc operators
SEMICOLON: ';';
COMMA: ',';
DOT: '.';
LPAREN: '(';
RPAREN: ')';
LBRACKET: '[';
RBRACKET: ']';
LBRACE: '{';
RBRACE: '}';

// Keywords
PROJECT: 'project';
BREAK: 'break';
CLASS: 'class';
INTERFACE: 'interface';
ENUM: 'enum';
ELSE: 'else';
CONST: 'const';
IF: 'if';
NEW: 'new';
PRINT: 'print';
READ: 'read';
RETURN: 'return';
VOID: 'void';
FOR: 'for';
EXTENDS: 'extends';
IMPLEMENTS: 'implements';
CONTINUE: 'continue';

ID:     [a-zA-Z_] [a-zA-Z_0-9]*;
STRING: '"'[a-z]*'"';

WHITE_SPACE:    [ \t\r\n] -> skip;
COMMENT:        '//' ~[\r\n]* -> skip;

// #####    parser  #####

project:
    PROJECT ID (
        constDecl | varDecl | classDecl | enumDecl | interfaceDecl
    )* '{' 
        methodDecl*     // at least the void entry() method in semantic analyze
    '}' EOF;

constDecl:
    CONST type
        ID ASSIGN (Num_Const | Char_Const | Boolean_Const)
        (',' 
            ID ASSIGN (Num_Const | Char_Const | Boolean_Const)
        )*  // multiple const declarations in the same line
    ';';

enumDecl:
    ENUM ID '{'
        ID (ASSIGN Num_Const)?
        (','
            ID (ASSIGN Num_Const)?
        )*
    '}';

varDecl: type var (',' var)* ';';
var: ID (LBRACKET RBRACKET)?;

classDecl:
    CLASS ID
    (EXTENDS type)?
    (IMPLEMENTS type (',' type)*)? 
    '{'
        varDecl*
        ('{'
            methodDecl*
        '}')?
    '}';

interfaceDecl:
    INTERFACE ID '{'
        interfaceMethodDecl*
    '}';

interfaceMethodDecl: (type | VOID) ID '(' formPars? ')' ';';

methodDecl:
    (type | VOID) ID '(' formPars? ')' varDecl* '{'
        statement*
    '}';

formPars: formPar (',' formPar)*;
formPar: type ID (LBRACKET RBRACKET)?;

type: ID;

statement:
    designatorStatement ';' 
    |   IF '(' condition ')'
            statement
        (ELSE
            statement
        )?
    |   FOR '('
            designatorStatement? ';'
            condition? ';'
            designatorStatement?
        ')'
            statement
    |   BREAK ';'
    |   CONTINUE ';'
    |   RETURN expr? ';'
    |   READ '(' designator ')' ';'
    |   PRINT '(' expr (',' Num_Const)? ')' ';'
    |   '{' statement* '}';

designatorStatement: designator (assignop expr | '(' actPars? ')' | INCREMENT | DECREMENT);

actPars: expr (',' expr)*;

condition: condTerm (OR condTerm)*;
condTerm: condFact (AND condFact)*;
condFact: expr (relop expr)?;

expr: SUB? term (addop term)*;

term: factor (mulop factor)*;

factor:
    designator ('(' actPars? ')')?
    | Num_Const
    | Char_Const
    | Boolean_Const
    | NEW type (LBRACKET expr RBRACKET)?
    | '(' expr ')';

designator: ID (('.' ID) | (LBRACKET expr RBRACKET))*;

// operators
assignop:   ASSIGN;
relop:      EQ | NEQ | GT | GTEQ | LT | LTEQ;
addop:      ADD | SUB;
mulop:      MUL | DIV | MOD;