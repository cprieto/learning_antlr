GRAMMAR=Expr
ENTRY=prog
ARGS=
EXTENSION=$(shell echo $(GRAMMAR)|tr A-Z a-z)
ANTLR=/usr/local/Cellar/antlr/4.5.2/antlr-4.5.2-complete.jar

$(GRAMMAR)%.java %.tokens: $(GRAMMAR).g4
	antlr4 -no-listener -visitor $(GRAMMAR).g4

$(GRAMMAR)%.class: $(GRAMMAR)%.java
	javac *.java -classpath $(ANTLR):.

$(GRAMMAR).jar: $(GRAMMAR)%.class $(GRAMMAR)%.tokens $(GRAMMAR).kt
	kotlinc $(GRAMMAR).kt -include-runtime -classpath $(ANTLR):. -d $(GRAMMAR).jar
	echo 'Class-Path:' $(ANTLR) > manifest.mf
	jar uvf $(GRAMMAR).jar $(GRAMMAR)*.class $(GRAMMAR)*.tokens
	jar umf manifest.mf $(GRAMMAR).jar
	rm -f *.java *.class *.tokens *.mf

clean:
	rm -rf *.java *.class *.tokens *.mf *.jar

test: $(GRAMMAR)%.class $(GRAMMAR)%.tokens
	grun $(GRAMMAR) $(ENTRY) -tree t.$(GRAMMAR)

run: $(GRAMMAR).jar
	java -jar $(GRAMMAR).jar t.$(EXTENSION) $(ARGS)
