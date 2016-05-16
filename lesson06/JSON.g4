grammar JSON;

json : object ;

object : '{' pair '}'
       | '{' '}' ; // empty object


pair : STRING ':' value ;

value : STRING
      | NUMBER
      | object ; // Recursive rule!

STRING : '"' (~["\\])* '"' ;

NUMBER : INT ;

fragment INT : '-'? [1-9] [0-9]* ; // No leading zeroes!

NL : [\n\r ] -> skip;
