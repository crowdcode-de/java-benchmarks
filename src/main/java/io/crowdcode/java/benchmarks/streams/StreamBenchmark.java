package io.crowdcode.java.benchmarks.streams;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBenchmark {

	@Benchmark
	public void testStream(ArrayState state, Blackhole blackhole) {
		List<String> collect = state.testList
				.stream()
				.filter(s -> s.length() > 5)
				.map(s -> "Value: " + s)
				.sorted(String::compareTo)
				.collect(Collectors.toList());

		blackhole.consume(collect);
	}

	@Benchmark
	public void testStreamParallel(ArrayState state, Blackhole blackhole) {
		List<String> collect = state.testList
				.stream()
				.parallel()
				.filter(s -> s.length() > 5)
				.map(s -> "Value: " + s)
				.sorted(String::compareTo)
				.collect(Collectors.toList());
		blackhole.consume(collect);
	}

	@Benchmark
	public void testLargeStreamParallel(ArrayState state, Blackhole blackhole) {
		ArrayList<Double> collect = state.integerList
				.stream()
				.parallel()
				.map(i -> Math.sqrt(i * 2 / ((i >> 3) + 1)))
				.collect(Collectors.toCollection(ArrayList::new));

		blackhole.consume(collect);
	}

	@Benchmark
	public void testLargeStream(ArrayState state, Blackhole blackhole) {
		ArrayList<Double> collect = new ArrayList<>();
		for (Integer i : state.integerList) {
			collect.add(Math.sqrt(i * 2 / ((i >> 3) + 1)));
		}

		blackhole.consume(collect);
	}

	@Benchmark
	public void testFor(ArrayState state, Blackhole blackhole) {
		ArrayList<String> results = new ArrayList<>();

		for (int i = 0; i < state.testList.size(); i++) {
			String s = state.testList.get(i);

			if (s.length() > 5) {
				results.add("Value: " + s);
			}
		}

		results.sort(String::compareTo);

		blackhole.consume(results);
	}

	@Benchmark
	public void testStreamInLoop(ArrayState state, Blackhole blackhole) {
		ArrayList<String> output = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			state.smallList
					.stream()
					.filter(s -> s.length() > 2)
					.map(s -> "Value: " + s)
					.forEach(output::add);
		}
		blackhole.consume(output);
	}

	@Benchmark
	public void testForInLoop(ArrayState state, Blackhole blackhole) {
		ArrayList<String> output = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			for (String s : state.smallList) {
				if (s.length() > 2) {
					output.add("Value: " + s);
				}
			}
		}
		blackhole.consume(output);
	}
}

