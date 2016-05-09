grammar Expr;
import CommonLexerRules;

prog    : stat+ ;

stat    : 'clear' NEWLINE  # clear
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
