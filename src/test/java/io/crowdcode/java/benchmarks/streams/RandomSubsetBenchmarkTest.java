package io.crowdcode.java.benchmarks.streams;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
class RandomSubsetBenchmarkTest {

    @Test
    void testRandSubsetBenchmark() {
        RandomSubsetBenchmark randomSubsetBenchmark = new RandomSubsetBenchmark();
        for (int i=0; i<20_000; i++) {
            long start = System.currentTimeMillis();
            randomSubsetBenchmark.generateSubsetString();
            long stop = System.currentTimeMillis();
            System.out.println("> "+ i + " took " + (stop-start) + "ms.");
        }
    }

//    @Test
//    void testRandSubsetBenchmark2() {
//        RandomSubsetBenchmark randomSubsetBenchmark = new RandomSubsetBenchmark();
//        for (int i=0; i<20_000; i++) {
//            randomSubsetBenchmark.generateSubsetString();
//            System.out.println("> "+i);
//        }
//    }
}
