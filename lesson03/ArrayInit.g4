grammar ArrayInit;

init  : '{' INT (',' INT)* '}' ;
INT   : [0-9]+ ;
WS    : [ \n\r]+ -> skip ;
