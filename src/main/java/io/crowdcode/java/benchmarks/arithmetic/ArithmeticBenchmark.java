package io.crowdcode.java.benchmarks.arithmetic;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigInteger;

@State(Scope.Benchmark)
public class ArithmeticBenchmark {

	private long a = 5;
	private long b = 10;


	private BigInteger bigIntA = BigInteger.valueOf(a);
	private BigInteger bigIntB = BigInteger.valueOf(b);

	// No need for loops, JMH will handle this better...
	@Benchmark
	public long addPrimitives() {
		return a + b;
	}

	// No need for loops, JMH will handle this better...
	@Benchmark
	public BigInteger addBigIntegers() {
		return bigIntA.add(bigIntB);
	}

	@Benchmark
	public void addWithBlackhole(Blackhole blackhole) {
		blackhole.consume(a + b);
	}


}
