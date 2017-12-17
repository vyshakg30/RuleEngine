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
      -forbidden values : eg: alt1 cannot not be 10
      -Exclusive : eg: alt1 should only be only 10
    -Date Time type :
      -forbidden values : eg: alt1 must never be in past
      -Exclusive values : eg: alt1 should only be only in past
 Note : Refer test cases for finding out more variations.


# Discussions

## Conceptual approach




## Performance : 
### Complexity

> O(R) * [ O(W) + O(log Ev)] + O(N log N)

    DAG : Rule formation process
        Total number of rules = R
        Total Words in a rule = W
        Total number of edges  = E
        Total number edge values = Ev
       Equation : O(R) * [ O(W) + O(log Ev)]
    
    Decision tree : route process , which could be either while adding a rule or finding a rule.
        Total number of data signals = N
       Equation : O(N)

## Improvements
    -Create thread pool to process input data stream and further move to SEDA(Staged event driven architecture : 
    (http://web.cecs.pdx.edu/~walpole/class/cs533/winter2009/slides/2b.pdf) which would increase performance.
    -Increase Rule Types by expanding both DAG and Decision tree.
    -Establish a dedicated Exception Handling Hierarchy.
    -Further optimise memory use by managing collection use.
    -I/O stream thorough memory leak check.
    -Add logging.
