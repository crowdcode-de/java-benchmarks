package io.crowdcode.java.benchmarks.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Exercise: from which collection size on does a {@link HashSet} pay off
 * compared to an {@link ArrayList} when calling {@code contains()}?
 */
// TODO 1: turn this class into a JMH state object with one instance per benchmark thread
public class ContainsBenchmark {

    // TODO 2: let JMH run the benchmark for the sizes 1, 10, 1000 and 100000
    int size;

    List<Integer> list;
    Set<Integer> set;
    Integer searched;

    // TODO 3: let JMH call this method once before each trial
    public void fillCollections() {
        list = new ArrayList<>(size);
        set = new HashSet<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i);
            set.add(i);
        }
        // worst case for the list: the searched element is the last one
        searched = size - 1;
    }

    // TODO 4: add a benchmark method "listContains" that searches the element in the list

    // TODO 5: add a benchmark method "setContains" that searches the element in the set

}
