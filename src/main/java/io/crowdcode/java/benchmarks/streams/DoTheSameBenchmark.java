package io.crowdcode.java.benchmarks.streams;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Simple Benchmark with no alternative to check the measurement
 *
 * @author Ingo Dueppe (CROWDCODE)
 */
public class DoTheSameBenchmark {

	@Benchmark
	public void testStreamA(ArrayState state, Blackhole blackhole) {
		List<String> collect = state.testList
				.stream()
				.filter(s -> s.length() > 5)
				.map(s -> "A: " + s)
				.sorted(String::compareTo)
				.collect(Collectors.toList());

		blackhole.consume(collect);
	}

	@Benchmark
	public void testStreamB(ArrayState state, Blackhole blackhole) {
		List<String> collect = state.testList
				.stream()
				.filter(s -> s.length() > 5)
				.map(s -> "B: " + s)
				.sorted(String::compareTo)
				.collect(Collectors.toList());
		blackhole.consume(collect);
	}


}
