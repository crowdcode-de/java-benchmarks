package io.crowdcode.java.benchmarks;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.Random;

@State(Scope.Thread)
public class MultiplyVsDivisionState {

	public Random random = new Random();

	public int loops = 1_000;

	public double nextRandom() {
		return random.nextDouble();
	}

}
