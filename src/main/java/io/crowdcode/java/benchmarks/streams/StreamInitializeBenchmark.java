package io.crowdcode.java.benchmarks.streams;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamInitializeBenchmark {

	@Benchmark
	public void testStream(ArrayState state, Blackhole blackhole) {
		List<String> collect = state.testList
				.stream()
				.filter(s -> s.length() > 5)
				.map(s -> "A: " + s)
				.sorted(String::compareTo)
				.collect(Collectors.toList());

		blackhole.consume(collect);
	}

	@Benchmark
	public void testStreamWithInit(ArrayState state, Blackhole blackhole) {
		List<String> collect = state.testList
				.stream()
				.filter(s -> s.length() > 5)
				.map(s -> "B: " + s)
				.sorted(String::compareTo)
				.collect(Collectors.toCollection(() -> new ArrayList<>(state.testList.size())));
		blackhole.consume(collect);
	}


}
