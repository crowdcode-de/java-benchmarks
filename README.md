# Java Micro-Benchmarks With JMH

These benchmarks are build with [OpenJDK JMH](https://openjdk.java.net/projects/code-tools/jmh/).

### How To Run The Benchmarks

Build the project `mvn clean install`.
 
You can call `java -jar target/benchmarks.jar -help` to see available command line parameters.

```
  java -Xmx1G -jar targget/benchmarks.jar -r 5 -i -wi 5 EmptyBenchmark
```

### Create Your Own Benchmark

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

## Use Multiply Instead Of Divide

It is faster to multiply than to divide

```
    double divisor = 10.0;
    double a = a / divisor // repeat this 1_000 times
    ...
```

better use

```
    double divisor = 10.0;
    double factor = 1 / divisor;
    double a = nextDouble() * factor; // repeat this 1_000 times
```

````
java -Xmx1G -jar target/benchmarks.jar -f 1 -r 1 -i 5 -w 1 -wi 5 MultiplyVsDivisionBenchmark
````

|Benchmark                                             |  Mode |  Cnt |      Score |      Error | Units|
|:-----------------------------------------------------|:-----:|:----:|:----------:|:----------:|:----:|
|MultiplyVsDivisionBenchmark.divideDoubles             | thrpt |   5  | 207619,369 | ± 2662,392 | ops/s|
|MultiplyVsDivisionBenchmark.divideDoublesWithMultiply | thrpt |   5  | 508495,675 | ± 8033,898 | ops/s|





[CROWDCODE GmbH & Co. KG](https://www.crowdcode.io)
