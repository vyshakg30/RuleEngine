# RuleEngine
A rule engine that accepts a rule iteratively and applies it on a running data stream.
Data stream element that violates a rule is displayed on console.

# Getting started
## Prerequisites

    -Java 8
    -maven

## Running
On root directory of project containing pom.xml, use following commands to build and run.
    
    -mvn clean compile package
    -java -cp target/RuleEngine-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.ruleengine.main.control.DataStreamApp


## Rule Formation 
> **8** Different category of rules are currently accepted.
       
    -Integer Type :
      -upper limit : eg: alt1 should only be above 10
      -lower limit : eg: alt1 mustn't be below 10
      -forbidden : eg: alt1 should should not be 10
      -Exclusive : eg: alt1 must only be 10
    -String Type :
      -forbidden values : eg: alt1 cannot not be low
      -Exclusive : eg: alt1 should only be high
    -Date Time type :
      -forbidden values : eg: alt1 must never be in past
      -Exclusive values : eg: alt1 should only be only in past
 Note : Refer test cases for finding out more variations.


# Discussions

## Conceptual approach

A Directed Acyclic Words graph [DAWG](https://en.wikipedia.org/wiki/Directed_acyclic_word_graph) and Rule based 
decision tree [RBDT](publication/221343165_RBDT-1_A_New_Rule-Based_Decision_Tree_Generation_Technique) approaches are primarily followed in this solution.

Each Node of a DAG acts as rule creater and every edge which would contain a set of string values acts as contextual 
information identifier(used during parsing rules). Decision tree's synergy with DAG is by having a model(Type of 
Parent/Child lineage) that would identify and store rule conditions set forth by DAG's Node.

    Simple algorigthm :
        1.Create DAG with prior values for the edges.
        2.Obtain rule sentence from user.
        3.parse rule sentence by navigating through graph by comparing values at the edge .
         3.1 After the parse obtain conditions of the rule from the last node the parse process ended at.
        4.Add those conditions to Decision tree.
        5.Check signal comming from the stream with the decision tree. 
            5.1 Obtaining the data type of of the signal.
            5.2 compare the value of the signal with the values present at its corresponding 
            data type node in the decision tree.
            5.3 if the comparisions with any previously added condition is successfull a rule would has been
            violated.
         6.I/O.
        
            
## Performance : 
### Complexity

> O(W) + O(log Ev)+ O(N log N)

    DAG : Rule formation process
        Total Words in all rules = W
        Total number of edges  = E
        Total number edge values = Ev
       Equation : O(W) + O(log Ev)
    
    Decision tree : route process , which could be either while adding a rule or finding a rule.
        Total number of data signals = N
       Equation : O(N log N)

## Improvements
    -Create thread pool to process input data stream and further move to SEDA(Staged event driven 
    architecture : (http://web.cecs.pdx.edu/~walpole/class/cs533/winter2009/slides/2b.pdf) which 
    would increase performance.
    
    -Increase Rule Types by expanding both DAG and Decision tree.
    
    -Establish a dedicated Exception Handling and its Hierarchy by creating wrappers.
    
    -Programming : Further optimise memory use by managing collection use.
    
    -I/O stream thorough memory leak check.
    
    -Translate implementation into pure abstract factory and command pattern.
    
    -Add logging.
