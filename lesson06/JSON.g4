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

STRING : '"' (~["\\])* '"' ;

NUMBER : '-'? INT
       | '-'? INT '.' [0-9]+  // float numbers
       ;

fragment INT   : '0' | [1-9] [0-9]* ; // No leading zeroes!

NL : [\n\r ] -> skip;
