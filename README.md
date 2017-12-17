# RuleEngine
A rule engine that accepts a rule iteratively and applies it on a running data stream.
Data stream element that violates a rule is displayed on console.

# Getting started

## Prerequisites
    Java 8
    maven

## Running
On root directory of project containing pom.xml, use following commands to build and run.
    Installing
    > mvn clean compile package
    > java -cp target/RuleEngine-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.ruleengine.main.control.DataStreamApp
