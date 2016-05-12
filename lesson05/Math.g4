grammar Math;

math: entry+ ;

entry : expr NL # printResult
      | NL      # blank
      ;

expr : expr '+' expr  # Sum
     | INT            # Num
     ;


INT : [0-9]+ ;
NL  : '\r'? '\n' ;
WS  : [\t ] -> skip ;
