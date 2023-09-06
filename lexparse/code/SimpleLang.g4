grammar SimpleLang;

// #####    lexer   #####

// constants
Num_Const:      '-'?[0-9]+;
Char_Const:     '\''.'\'';
Boolean_Const:  'true' | 'false';

ID:     [a-zA-Z_] [a-zA-Z_0-9]*;
STRING: '"'[a-z]*'"';

WHITE_SPACE:    [ \t\r\n] -> skip;
COMMENT:        '//' ~[\r\n]* -> skip;
OTHER:          .;

// #####    parser  #####

project:
    'project' ID (
        constDecl | varDecl | classDecl | enumDecl | interfaceDecl
    )* '{' 
        methodDecl*     // at least the void entry() method in semantic analyze
    '}' EOF;

constDecl:
    'const' type
        ID '=' (Num_Const | Char_Const | Boolean_Const)
        (',' 
            ID '=' (Num_Const | Char_Const | Boolean_Const)
        )*  // multiple const declarations in the same line
    ';';

enumDecl:
    'enum' ID '{'
        ID ('=' Num_Const)?
        (','
            ID ('=' Num_Const)?
        )*
    '}';

varDecl:
    type
        ID ('['']')? 
        (','
            ID ('['']')?
        )*
    ';';

classDecl:
    'class' ID
    ('extends' type)?
    ('implements' type (',' type)*)? 
    '{'
        varDecl*
        ('{'
            methodDecl*
        '}')?
    '}';

interfaceDecl:
    'interface' ID '{'
        interfaceMethodDecl*
    '}';

interfaceMethodDecl: (type | 'void') ID '(' formPars? ')' ';';

methodDecl:
    (type | 'void') ID '(' formPars? ')' varDecl* '{'
        statement*
    '}';

formPars: type ID ('['']')? (',' type ID ('['']')?)*;

type: ID;

statement:
    designatorStatement ';' 
    |   'if' '(' condition ')'
            statement
        ('else'
            statement
        )?
    |   'for' '('
            designatorStatement? ';'
            condition? ';'
            designatorStatement?
        ')'
            statement
    |   'break' ';'
    |   'continue' ';'
    |   'return' expr? ';'
    |   'read' '(' designator ')' ';'
    |   'print' '(' expr (',' Num_Const)? ')' ';'
    |   '{' statement* '}';

designatorStatement: designator (assignop expr | '(' actPars? ')' | '++' | '--');

actPars: expr (',' expr)*;

condition: condTerm ('||' condTerm)*;
condTerm: condFact ('&&' condFact)*;
condFact: expr (relop expr)?;

expr: '-'? term (addop term)*;

term: factor (mulop factor)*;

factor:
    designator ('(' actPars? ')')?
    | Num_Const
    | Char_Const
    | Boolean_Const
    | 'new' type ('[' expr ']')?
    | '(' expr ')';

designator: ID (('.' ID) | ('[' expr ']'))*;

// operators
assignop:   '=';
relop:      '==' | '!=' | '>' | '>=' | '<' | '<=';
addop:      '+' | '-';
mulop:      '*' | '/' | '%';