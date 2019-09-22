package io.crowdcode.java.benchmarks.collections;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
public class InitialCapacityBenchmark {

	private int SIZE = 1_000_000;

	@Benchmark
	public void addWithoutInitialCapacity(Blackhole blackhole) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < SIZE; i++) {
			result.add(i);
		}

		blackhole.consume(result);
	}

	@Benchmark
	public void addWithInitialCapacity(Blackhole blackhole) {
		List<Integer> result = new ArrayList<>(SIZE);

		for (int i = 0; i < SIZE; i++) {
			result.add(i);
		}

		blackhole.consume(result);
	}

	@Benchmark
	public void addWithoutInitialCapacityWithStreams(Blackhole blackhole) {
		List<Integer> result = IntStream.range(0, SIZE).boxed().collect(Collectors.toCollection(ArrayList::new));
		blackhole.consume(result);
	}

	@Benchmark
	public void addWithInitialCapacityWithStreams(Blackhole blackhole) {
		List<Integer> result = IntStream.range(0, SIZE).boxed().collect(Collectors.toCollection(()->new ArrayList<>(SIZE)));
		blackhole.consume(result);
	}


}
