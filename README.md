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

## Use Multiply Instead Of Divide (`MultiplyVsDivisionBenchmark`)

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

Results with JDK 13:

````
java -Xmx1G -jar target/benchmarks.jar -f 1 -r 1 -i 5 -w 1 -wi 5 MultiplyVsDivisionBenchmark
````

|Benchmark                                             |  Mode |  Cnt |      Score |      Error | Units|
|:-----------------------------------------------------|:-----:|:----:|:----------:|:----------:|:----:|
|MultiplyVsDivisionBenchmark.divideDoubles             | thrpt |   5  | 207619,369 | ± 2662,392 | ops/s|
|MultiplyVsDivisionBenchmark.divideDoublesWithMultiply | thrpt |   5  | 508495,675 | ± 8033,898 | ops/s|


## Random Subset Without Duplicates - `RandomSubsetBenchmark`

Results with JDK 13:

````
java -Xmx1G -jar target/benchmarks.jar -f 1 -r 1 -i 5 -w 1 -wi 5 MultiplyVsDivisionBenchmark
````

|Benchmark                                             |  Mode |  Cnt |      Score |      Error | Units|
|:-----------------------------------------------------|:-----:|:----:|:----------:|:----------:|:----:|
|RandomSubsetBenchmark.subsetWithForLoop               | thrpt |   5|  1720,292 | ± 330,771 | ops/s|
|RandomSubsetBenchmark.subsetWithParallelStreams       | thrpt |   5|   779,079 | ±  23,238 | ops/s|
|RandomSubsetBenchmark.subsetWithStreams               | thrpt |   5|  1200,939 | ± 140,346 | ops/s|


## Date Parsing And Adding An Hour Benchmark - `DateBenchmark`

|Benchmark                                             |  Mode |  Cnt |      Score |      Error | Units|
|:-----------------------------------------------------|:-----:|:----:|:----------:|:----------:|:----:|
|DateBenchmark.dateLong              | thrpt |   5 | 386571214,471 | ± 10171784,541 | ops/s|
|DateBenchmark.dateLongWithFormat    | thrpt |   5 |   3358368,673 | ±    31265,425 | ops/s|
|DateBenchmark.dateParsingWithFormat | thrpt |   5 |    728327,799 | ±    19937,432 | ops/s|
|DateBenchmark.parsingLocalDateTime  | thrpt |   5 |    873308,951 | ±    97291,855 | ops/s|



## Created By

[CROWDCODE GmbH & Co. KG](https://www.crowdcode.io)

