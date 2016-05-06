grammar ArrayInit;

init  : '{' value (',' value)* '}' ;
value : init | INT ;
INT   : [0-9]+ ;
WS    : [ \n\r]+ -> skip ;
