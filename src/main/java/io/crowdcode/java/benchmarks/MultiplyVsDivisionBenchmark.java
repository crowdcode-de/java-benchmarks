package io.crowdcode.java.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class MultiplyVsDivisionBenchmark {

	@Benchmark
	public void divideDoubles(MultiplyVsDivisionState state, Blackhole blackhole) {
		double divisor = (state.nextRandom() * 10.0);

		double result = state.nextRandom() * 1_000_000.0;

		for (int i = 0; i < state.loops; i++) {
			result = result / divisor;
		}

		blackhole.consume(result);
	}

	@Benchmark
	public void divideDoublesWithMultiply(MultiplyVsDivisionState state, Blackhole blackhole) {
		double factor = 1 / (state.nextRandom() * 10.0);

		double result = state.nextRandom() * 1_000_000.0;

		for (int i = 0; i < state.loops; i++) {
			result = result * factor;
		}

		blackhole.consume(result);
	}

}
