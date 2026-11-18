# Java Micro-Benchmarks With JMH

[![Build](https://github.com/crowdcode-de/java-benchmarks/actions/workflows/build.yml/badge.svg)](https://github.com/crowdcode-de/java-benchmarks/actions/workflows/build.yml)

These benchmarks are build with [OpenJDK JMH](https://github.com/openjdk/jmh).

Just another collection of typical Java Code Benchmarks.

### How To Run The Benchmarks

Build the project `mvn clean install` (requires JDK 17 or newer).
 
You can call `java -jar target/benchmarks.jar -help` to see available command line parameters.

For instance, 
```
  java -Xmx1G -jar target/benchmarks.jar -f 1 -r 5 -i 5 -wi 5 EmptyBenchmark
```

### Create Your Own Benchmark

```
mvn archetype:generate           
       -DinteractiveMode=false           
       -DarchetypeGroupId=org.openjdk.jmh          
       -DarchetypeArtifactId=jmh-java-benchmark-archetype
       -DarchetypeVersion=1.37           
       -DgroupId=org.sample           
       -DartifactId=test           
       -Dversion=1.0-SNAPSHOT
```

### Workshop Exercise

`io.crowdcode.java.benchmarks.exercise.ContainsBenchmark` is an unfinished benchmark with `TODO` markers.
It does not show up in `java -jar target/benchmarks.jar -l` until the first benchmark method is added.
The task description and the solution are part of the CROWDCODE workshop material.

## Benchmark Results

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

All results below were measured with OpenJDK 25.0.4 (Zulu) on an Apple M4 Max (macOS, aarch64).

### Use Multiply Instead Of Divide 

Check `MultiplyVsDivisionBenchmark` to see that it is faster to multiply than to divide doubles.

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

|Benchmark                                             |  Mode | Cnt |       Score |        Error | Units|
|:-----------------------------------------------------|:-----:|:---:|:-----------:|:------------:|:----:|
|MultiplyVsDivisionBenchmark.divideDoubles             | thrpt |  5  |  409528,749 | ± 208420,064 | ops/s|
|MultiplyVsDivisionBenchmark.divideDoublesWithMultiply | thrpt |  5  | 1750332,557 | ±  15010,078 | ops/s|


### Random Subset Without Duplicates
 
`RandomSubsetBenchmark`

````
java -Xmx1G -jar target/benchmarks.jar -f 1 -r 1 -i 5 -w 1 -wi 5 RandomSubsetBenchmark
````

|Benchmark                                             |  Mode | Cnt |     Score |      Error | Units|
|:-----------------------------------------------------|:-----:|:---:|:---------:|:----------:|:----:|
|RandomSubsetBenchmark.subsetWithForLoop               | thrpt |  5  | 14836,280 | ± 1454,678 | ops/s|
|RandomSubsetBenchmark.subsetWithParallelStreams       | thrpt |  5  |   190,552 | ±   16,030 | ops/s|
|RandomSubsetBenchmark.subsetWithStreams               | thrpt |  5  |  2439,445 | ±  277,583 | ops/s|


### Date Parsing And Adding An Hour Benchmark 
 
`DateBenchmark`

````
java -Xmx1G -jar target/benchmarks.jar -f 1 -r 1 -i 5 -w 1 -wi 5 DateBenchmark
````

|Benchmark                           |  Mode | Cnt |          Score |           Error | Units|
|:-----------------------------------|:-----:|:---:|:--------------:|:---------------:|:----:|
|DateBenchmark.dateLong              | thrpt |  5  | 2331729611,705 | ± 513245910,474 | ops/s|
|DateBenchmark.dateLongWithFormat    | thrpt |  5  |    9561979,184 | ±    798131,749 | ops/s|
|DateBenchmark.dateParsingWithFormat | thrpt |  5  |    2718024,132 | ±     17929,441 | ops/s|
|DateBenchmark.parsingLocalDateTime  | thrpt |  5  |    2847071,202 | ±     52263,829 | ops/s|

### Using Initial Capacity At ArrayList

`InitialCapacityBenchmark`

````
java -jar target/benchmarks.jar -f 1 -r 2 -w 2 -wi 5 InitialCapacityBenchmark
````

|Benchmark                                                     |  Mode | Cnt |  Score  |   Error  | Units|
|:-------------------------------------------------------------|:-----:|:---:|:-------:|:--------:|:----:|
|InitialCapacityBenchmark.addWithInitialCapacity               | thrpt |  5  | 659,095 | ±  7,489 | ops/s|
|InitialCapacityBenchmark.addWithInitialCapacityWithStreams    | thrpt |  5  | 402,918 | ± 67,462 | ops/s|
|InitialCapacityBenchmark.addWithoutInitialCapacity            | thrpt |  5  | 238,364 | ± 34,793 | ops/s|
|InitialCapacityBenchmark.addWithoutInitialCapacityWithStreams | thrpt |  5  | 183,303 | ± 11,041 | ops/s|


### Created By

[CROWDCODE GmbH & Co. KG](https://www.crowdcode.io)
