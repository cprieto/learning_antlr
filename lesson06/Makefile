GRAMMAR:=CSV
ENTRY:=file
ARGS:=-tokens
ANTLR:=/usr/local/Cellar/antlr/4.5.2/antlr-4.5.2-complete.jar

$(GRAMMAR)%.class: $(GRAMMAR)%.java $(GRAMMAR)%.tokens
	javac $(GRAMMAR)*.java -classpath $(ANTLR):.

$(GRAMMAR)%.java $(GRAMMAR)%.tokens : $(GRAMMAR).g4
	antlr4 $(GRAMMAR).g4

test: $(GRAMMAR)%.class $(GRAMMAR)%.tokens
	grun $(GRAMMAR) $(ENTRY) $(ARGS) data.$(shell echo $(GRAMMAR)|tr A-Z a-z)

clean:
	@- rm -rf *.java *.class *.tokens
