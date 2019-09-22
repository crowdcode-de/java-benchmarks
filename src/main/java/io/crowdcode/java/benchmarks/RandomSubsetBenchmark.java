package io.crowdcode.java.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@State(Scope.Thread)
public class RandomSubsetBenchmark {

	public static final int SIZE_ALL = 90_000;
	public static final int MAX_SIZE = 10_000;

	public List<String> values = new Random()
			.ints(SIZE_ALL, 1, 1_000_000)
			.mapToObj(n -> "M"+n)
			.collect(Collectors.toList());

	@Benchmark
	public void subsetWithStreams(Blackhole blackhole) {
		List<String> subset = new Random().ints(0, values.size())
				.distinct()
				.limit(MAX_SIZE)
				.mapToObj(values::get)
				.collect(Collectors.toList());

		blackhole.consume(subset);
	}

	@Benchmark
	public void subsetWithParallelStreams(Blackhole blackhole) {
		List<String> subset = new Random().ints(0, values.size())
				.distinct()
				.limit(MAX_SIZE)
				.parallel()
				.mapToObj(values::get)
				.collect(Collectors.toList());

		blackhole.consume(subset);
	}

	@Benchmark
	public void subsetWithForLoop(Blackhole blackhole) {

		List<String> subset = new ArrayList<>(MAX_SIZE);
		List<String> valueCopy = new ArrayList<>(values);

		Random random = new Random();

		while (subset.size() < MAX_SIZE) {
			int index = random.nextInt(SIZE_ALL);
			if (valueCopy.get(index) != null) {
				subset.add(valueCopy.get(index));
				valueCopy.set(index, null);
			}
		}

		blackhole.consume(subset);
	}



}
