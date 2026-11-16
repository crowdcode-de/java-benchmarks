package io.crowdcode.java.benchmarks.time;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.time.LocalDateTime;

@State(Scope.Thread)
public class LocalDateTimeNowBenchmark {

	LocalDateTime beginDateTime = LocalDateTime.now().plusMinutes(30);
	LocalDateTime expireDateTime = LocalDateTime.now().plusMinutes(5);


	@Benchmark
	public boolean previousIsRunning() {
		return (beginDateTime.isBefore(LocalDateTime.now())
				|| beginDateTime.isEqual(LocalDateTime.now()))
				&& expireDateTime.isAfter(LocalDateTime.now());
	}

	@Benchmark
	public boolean optimizedIsRunning() {
		LocalDateTime now = LocalDateTime.now();
		return (beginDateTime.isBefore(now)
				|| beginDateTime.isEqual(now))
				&& expireDateTime.isAfter(now);
	}

}
