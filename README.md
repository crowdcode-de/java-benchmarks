# Java Micro-Benchmarks With JMH

These benchmarks are build with [OpenJDK JMH](https://openjdk.java.net/projects/code-tools/jmh/).

## How To Run The Benchmarks

Build the project `mvn clean install`.
 
You can call `java -jar target/benchmarks.jar -help` to see available command line parameters.

```
  java -Xmx1G -jar targget/benchmarks.jar -r 5 -i -wi 5 EmptyBenchmark
```

## Create Your Own Benchmark

```
mvn archetype:generate           
       -DinteractiveMode=false           
       -DarchetypeGroupId=org.openjdk.jmh          
       -DarchetypeArtifactId=jmh-java-benchmark-archetype
       -DarchetypeVersion=1.21           
       -DgroupId=org.sample           
       -DartifactId=test           
       -Dversion=1.0-SNAPSHOT
```

[CROWDCODE GmbH & Co. KG](https://www.crowdcode.io)
