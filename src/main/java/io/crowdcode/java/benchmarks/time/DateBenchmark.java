package io.crowdcode.java.benchmarks.time;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

public class DateBenchmark {

    @Benchmark
    public void dateParsingWithFormat(DateState state, Blackhole blackhole) throws ParseException {
        Date date = state.formatter.parse("20-09-2017 00:00:00");
        date = new Date(date.getTime() + 24 * state.oneHour);
        blackhole.consume(state.formatter.format(date));
    }

    @Benchmark
    public void parsingLocalDateTime(DateState state, Blackhole blackhole) {
        LocalDateTime dateTime = LocalDateTime.parse("2019-09-23T00:00:00");
        dateTime = dateTime.plusHours(1);
        String result = dateTime.format(state.dateTimeFormatter);
        blackhole.consume(result);
    }

    @Benchmark
    public void dateLongWithFormat(DateState state, Blackhole blackhole) {
        long newTime = state.time + 24 * state.oneHour;
        String result = state.formatter.format(new Date(newTime));
        blackhole.consume(result);
    }

    @Benchmark
    public void dateLong(DateState state, Blackhole blackhole) {
        long newTime = state.time + 24 * state.oneHour;

        blackhole.consume(newTime);
    }
}


