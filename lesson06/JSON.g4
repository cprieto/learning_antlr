grammar JSON;

json : object ;

object : '{' pair '}'
       | '{' '}' ; // empty object


pair : STRING ':' value ;

value : STRING
      | object ; // Recursive rule!

STRING : '"' (~["])* '"' ;

NL : [\n\r ] -> skip;
