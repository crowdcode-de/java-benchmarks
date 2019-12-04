package io.crowdcode.java.benchmarks.collections;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class HashMapBenchmark {

	@Benchmark
	public void getBrokenWithComparableKeys(HashMapState state, Blackhole blackhole) {
		state.getHashMapWithBrokenHashCodeComparable().values().stream()
				.map(k -> state.getHashMap().get(k))
				.forEach(blackhole::consume);
	}

	@Benchmark
    public void getBrokenKeys(HashMapState state, Blackhole blackhole) {
        state.getHashMap().values().stream()
                .map(k -> state.getHashMapWithBrokenHashCode().get(k))
                .forEach(blackhole::consume);
    }

	@Benchmark
	public void getRandomKeys(HashMapState state, Blackhole blackhole) {
		state.getHashMap().values().stream()
				.map(k -> state.getHashMap().get(k))
				.forEach(blackhole::consume);
	}


}
