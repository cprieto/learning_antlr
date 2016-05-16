grammar JSON;

json : object ;

object : '{' '}' ; // empty object

NL : [\n\r] -> skip;
