package io.crowdcode.java.benchmarks.collections.model;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
public class BrokenHashCodeKey {

    private long key;

    public BrokenHashCodeKey(long key) {
        this.key = key;
    }

    public long getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrokenHashCodeKey that = (BrokenHashCodeKey) o;

        return that.key == key;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
