grammar JSON;

json : object
     | array
     ;

object : '{' pair (',' pair)* '}'
       | '{' '}' ; // empty object


pair : STRING ':' value ;

value : STRING
      | NUMBER
      | object  // Recursive rule!
      | array
      ;

array : '[' value (',' value)* ']'
      | '[' ']' ; // empty array

STRING : '"' (ESC | ~["\\])* '"' ;

NUMBER : '-'? INT '.' [0-9]+  EXP? // 1.35, 1.35e-9
       | '-'? INT EXP // 13e45, -12e-34
       | '-'? INT //122, -12
       ;

fragment INT     : '0' | [1-9] [0-9]* ; // No leading zeroes!
fragment EXP     : [Ee] [+\-]? INT ;

fragment ESC     : '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX     : [0-9a-fA-F] ;

WS : [\t\n\r ]+ -> skip;
