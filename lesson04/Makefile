GRAMMAR=Expr
ANTLR=/usr/local/Cellar/antlr/4.5.2/antlr-4.5.2-complete.jar

%.java: $(GRAMMAR).g4
	antlr4 $(GRAMMAR).g4

%.class: %.java
	javac *.java -classpath $(ANTLR):.

Expr.jar: %.class Expr.kt
	kotlinc Expr.kt -include-runtime -classpath $(ANTLR):. -d Expr.jar

clean:
	rm -rf *.java *.class *.tokens

test: %.class
	grun Expr prog -tokens t.expr

run: Expr.jar
	java -jar Expr.jar
