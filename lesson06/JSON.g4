grammar JSON;

json : object ;

object : '{' pair '}'
       | '{' '}' ; // empty object


pair : STRING ':' value ;

value : object ; // Recursive rule!

STRING : '"' (~["])* '"' ;

NL : [\n\r ] -> skip;
