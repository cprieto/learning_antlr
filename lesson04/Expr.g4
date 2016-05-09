grammar Expr;
import CommonLexerRules;

prog    : stat+ ;

CLEAR   : C L E A R ;

stat    : CLEAR NEWLINE  # clear
        | expr NEWLINE     # printExpr
        | ID '=' expr      # assign
        | NEWLINE          # blank
        ;

expr    : expr op=('*'|'/') expr   # MulDiv
        | expr op=('+'|'-') expr   # AddSub
        | INT                      # int
        | ID                       # id
        | '(' expr ')'             # parens
        ;

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;

fragment C: ('c'|'C') ;
fragment L: ('l'|'L') ;
fragment E: ('e'|'E') ;
fragment A: ('a'|'A') ;
fragment R: ('r'|'R') ;