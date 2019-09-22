package io.crowdcode.java.benchmarks;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@State(Scope.Thread)
public class DateState {
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;
	long oneHour = 3600 * 1000;
	long time;

	public DateState() {
        try {
            time = formatter.parse("23-09-2019 00:00:00").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
