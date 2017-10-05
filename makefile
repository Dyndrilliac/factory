JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		SleepUtilities.java \
		Channel.java \
		MessageQueue.java \
		Producer.java \
		Consumer.java \
		Factory.java 
		

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class

execute: default
		java Factory