package io.crowdcode.java.benchmarks.collections;

import io.crowdcode.java.benchmarks.collections.model.BrokenHashCodeComparableKey;
import io.crowdcode.java.benchmarks.collections.model.BrokenHashCodeKey;
import io.crowdcode.java.benchmarks.collections.model.HashCodeKey;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.HashMap;

/**
 * Looks up {@link HashMapState#LOOKUPS} existing keys per invocation.
 */
@State(Scope.Benchmark)
public class HashMapBenchmark {

	@Benchmark
	public void getBrokenWithComparableKeys(HashMapState state, Blackhole blackhole) {
		HashMap<BrokenHashCodeComparableKey, String> map = state.getHashMapWithBrokenHashCodeComparable();
		for (BrokenHashCodeComparableKey key : state.getBrokenComparableLookupKeys()) {
			blackhole.consume(map.get(key));
		}
	}

	@Benchmark
	public void getBrokenKeys(HashMapState state, Blackhole blackhole) {
		HashMap<BrokenHashCodeKey, String> map = state.getHashMapWithBrokenHashCode();
		for (BrokenHashCodeKey key : state.getBrokenLookupKeys()) {
			blackhole.consume(map.get(key));
		}
	}

	@Benchmark
	public void getRandomKeys(HashMapState state, Blackhole blackhole) {
		HashMap<HashCodeKey, String> map = state.getHashMap();
		for (HashCodeKey key : state.getLookupKeys()) {
			blackhole.consume(map.get(key));
		}
	}

}
