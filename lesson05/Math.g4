grammar Math;

math: entry+ ;

entry : expr NL # printResult
      | NL      # blank
      ;

expr : <assoc=right> expr '^' expr # Power
     | expr op=('*'|'/') expr      # MulDiv
     | expr op=('+'|'-') expr      # AddSub
     | INT                         # Num
     ;


INT : [0-9]+ ;
NL  : '\r'? '\n' ;
WS  : [\t ] -> skip ;

SUM : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
