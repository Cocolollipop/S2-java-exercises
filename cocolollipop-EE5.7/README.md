#*** Solution for EXERCICE 5.7 ***
*********************

Supplementary requirements: your code must lie in at least two packages;

The idea of this exercice is that you simulate that three different people work on this exercice: one provides some interfaces; another implements the interfaces; a third one uses the interfaces and their implementations to solve the exercice (except you represent all these persons).

1) Declare at least one interface in another Eclipse project, exported as a Java archive (JAR file);

2) implement those interfaces in another Eclipse project, exported as a Java archive (JAR file) (will you need the previous JAR file? Why / why not?);

- We will need the previous JAR file because the implementation needs to know which interface we are talking about.

3) solve the exercices in a third Eclipse project (will you need the previous JAR files? Which ones and why?).
- We will need both previous JAR files because a JAR file only keep the java code. It does not keep the libraries. So we need the first JAR file to have the code of the interface and the other one to have the implementations so the project can work. 


JAR files are a good thing because it is easy to use and to add as libraries. We can create different JAR files and put them together so we do not have to see all the packages on the first level. 
It is helpful for important project to have an organized sight of the project.
In my opinion, it can make the project more understandable on the first sight (if we name them right).


