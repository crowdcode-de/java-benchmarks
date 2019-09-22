package io.crowdcode.java.benchmarks.strings;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Thread)
public class StringBenchmark {

    public static final int SIZE = 10_000;

    @Benchmark
	public void stringFormat(Blackhole blackhole) {
		String text = "text";
		String formattedString = String.format("%s = %d", text, 2);

		blackhole.consume(formattedString);
	}

	@Benchmark
	public void stringConcat(Blackhole blackhole) {
		String text = "text";
		String concattedString = text + " = " + 2;

		blackhole.consume(concattedString);
	}

	@Benchmark
	public void stringAppendLoop(Blackhole blackhole) {
		String s = "";

		for (int i = 0; i < SIZE; i++) {
			if (s.length() > 0) s += ", ";
			s += "bar";
		}

		blackhole.consume(s);
	}

	@Benchmark
	public void stringAppendLoopPlus(Blackhole blackhole) {
		String s = "";

		for (int i = 0; i < SIZE; i++) {
			if (s.length() > 0) s = s + ", ";
			s = s + "bar";
		}

		blackhole.consume(s);
	}

	@Benchmark
	public void stringAppendLoopPlusDouble(Blackhole blackhole) {
		String s = "";
		String bar = "bar";

		for (int i = 0; i < SIZE; i++) {
			if (s.length() > 0) s = s + ",";
			s = s + " " + bar;
		}

		blackhole.consume(s);
	}

	@Benchmark
	public void stringCreateLoop(Blackhole blackhole) {
		String s = "";

		for (int i = 0; i < SIZE; i++) {
			s = "Hello world " + i;
		}

		blackhole.consume(s);
	}

	@Benchmark
	public void stringAppendBuilderLoop(Blackhole blackhole) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < SIZE; i++) {
			if (sb.length() > 0) sb.append(", ");
			sb.append("bar");
		}

		blackhole.consume(sb.toString());
	}

	@Benchmark
	public void stringAppendBuilderLoopSized(Blackhole blackhole) {
		StringBuilder sb = new StringBuilder(SIZE * 5);

		for (int i = 0; i < SIZE; i++) {
			if (sb.length() > 0) sb.append(", ");
			sb.append("bar");
		}

		blackhole.consume(sb.toString());
	}

	@Benchmark
	public void stringAppend(Blackhole blackhole) {
		String s = "foo";
		s += ", bar";
		s += ", baz";
		s += ", qux";
		s += ", bar";
		s += ", bar";
		s += ", bar";
		s += ", bar";
		s += ", bar";
		s += ", bar";
		s += ", baz";
		s += ", qux";
		s += ", baz";
		s += ", qux";
		s += ", baz";
		s += ", qux";
		s += ", baz";
		s += ", qux";
		s += ", baz";
		s += ", qux";
		s += ", baz";
		s += ", qux";

		blackhole.consume(s);
	}

	@Benchmark
	public void stringAppendBuilder(Blackhole blackhole) {
		StringBuilder sb = new StringBuilder();
		sb.append("foo");
		sb.append(", bar");
		sb.append(", bar");
		sb.append(", baz");
		sb.append(", qux");
		sb.append(", baz");
		sb.append(", qux");
		sb.append(", baz");
		sb.append(", qux");
		sb.append(", baz");
		sb.append(", qux");
		sb.append(", baz");
		sb.append(", qux");
		sb.append(", baz");
		sb.append(", qux");
		sb.append(", baz");
		sb.append(", qux");
		sb.append(", baz");
		sb.append(", qux");
		sb.append(", baz");
		sb.append(", qux");
		sb.append(", baz");
		sb.append(", qux");

		blackhole.consume(sb.toString());
	}
}
