# javaC=javac
# JFLAGS = -g
# javaR=java
# CC=g++

# CFLAGS=-O0
# OPT=-deprecation
# TARGET1=./Solution1
# TARGET2=./Solution1

# $(TARGET1).class: Solution1.java
# 	$(javaC) Solution1.java

# $(TARGET2): Solution1.cpp
# 	$(CC) $(CFLAGS) -Wall -pedantic -std=c++14 Solution1.cpp -o $(TARGET2)

# clean:
# 	rm -f *.class 
# 	rm -f *.o $(TARGET2)
# run: $(TARGET1).class


JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = *.java 

default: classes

classes: $(CLASSES:.java=.class)

# Solution1:Solution1.cpp
# 	g++ -Wall -pedantic -std=c++14 -o Solution1 Solution1.cpp

clean:
	$(RM) *.class

