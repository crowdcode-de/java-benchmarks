package io.crowdcode.java.benchmarks.streams;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@State(Scope.Thread)
public class ArrayState {

	private static final int SIZE = 100_000;

	ArrayList<String> testList;
	ArrayList<String> smallList;
	ArrayList<Integer> integerList;

	public ArrayState() {
		testList = IntStream.range(1, SIZE).mapToObj(String::valueOf).collect(Collectors.toCollection(ArrayList::new));

		Collections.shuffle(testList);

		smallList = testList.stream().limit(100).collect(Collectors.toCollection(ArrayList::new));
		integerList = IntStream.range(0, 1_000_000).boxed().collect(Collectors.toCollection(ArrayList::new));
	}
}
