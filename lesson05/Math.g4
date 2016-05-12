grammar Math;

math: entry+ ;

entry : expr NL
      | NL
      ;

expr : INT ;

INT : [0-9]+ ;
NL  : '\r'? '\n' ;
WS  : [\t ] -> skip ;
