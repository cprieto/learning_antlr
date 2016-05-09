GRAMMAR=Expr
ANTLR=/usr/local/Cellar/antlr/4.5.2/antlr-4.5.2-complete.jar

$(GRAMMAR)%.java %.tokens: $(GRAMMAR).g4
	antlr4 -no-listener -visitor $(GRAMMAR).g4

$(GRAMMAR)%.class: $(GRAMMAR)%.java
	javac *.java -classpath $(ANTLR):.

Expr.jar: $(GRAMMAR)%.class $(GRAMMAR)%.tokens Expr.kt
	kotlinc Expr.kt -include-runtime -classpath $(ANTLR):. -d Expr.jar
	echo 'Class-Path:' $(ANTLR) > manifest.mf
	jar uvf Expr.jar *.class *.tokens
	jar umf manifest.mf Expr.jar
	rm -f *.java *.class *.tokens *.mf

clean:
	rm -rf *.java *.class *.tokens *.mf

test: $(GRAMMAR)%.class $(GRAMMAR)%.tokens
	grun Expr prog -tokens t.expr

run: Expr.jar
	java -jar Expr.jar t.expr
