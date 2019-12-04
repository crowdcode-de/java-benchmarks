package io.crowdcode.java.benchmarks.collections.model;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
public class BrokenHashCodeComparableKey implements Comparable<BrokenHashCodeComparableKey>{

    private long key;

    public BrokenHashCodeComparableKey(long key) {
        this.key = key;
    }

    public long getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrokenHashCodeComparableKey that = (BrokenHashCodeComparableKey) o;

        return that.key == key;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public int compareTo(BrokenHashCodeComparableKey o) {
        return (int) (this.key - o.key);
    }
}
