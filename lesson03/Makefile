GRAMMAR=ArrayInit
ANTLR=/usr/local/Cellar/antlr/4.5.2/antlr-4.5.2-complete.jar

all: Test.jar

%.java: $(GRAMMAR).g4
	antlr4 $(GRAMMAR).g4

%.class: %.java
	javac *.java -classpath $(ANTLR):.

manifest.mf:
	echo 'Class-Path:' $(ANTLR) > manifest.mf

Test.jar: %.class manifest.mf
	kotlinc Test.kt -include-runtime -d Test.jar -classpath $(ANTLR):.
	jar uvf Test.jar *.class *.tokens
	jar umf manifest.mf Test.jar
	rm *.class *.java *.tokens manifest.mf

clean:
	rm -f *.class *.java *.tokens *.jar *.mf
