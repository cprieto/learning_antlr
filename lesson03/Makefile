GRAMMAR=ArrayInit
ANTLR=/usr/local/Cellar/antlr/4.5.2/antlr-4.5.2-complete.jar

all: Test.jar

%.java: $(GRAMMAR).g4
	antlr4 $(GRAMMAR).g4

%.class: %.java
	javac *.java -classpath $(ANTLR):.

Test.jar: %.class
	kotlinc Test.kt -include-runtime -d Test.jar -classpath $(ANTLR):.
	jar uvf Test.jar *.class *.tokens
	jar umf manifest.mf Test.jar
	rm *.class *.java *.tokens

clean:
	rm -f *.class *.java *.tokens *.jar
