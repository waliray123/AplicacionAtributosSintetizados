#! /bin/bash 
echo "INICIANDO COMPILACION JFLEX "
java -jar ../lib/jflex-full-1.8.2.jar Lexer.jflex
echo "INICIANDO COMPILACION JAVA CUP"
java -jar ../lib/java-cup-11b.jar -parser Parser -symbols sym Parser.cup