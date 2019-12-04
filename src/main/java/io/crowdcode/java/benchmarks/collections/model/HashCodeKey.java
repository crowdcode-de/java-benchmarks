package io.crowdcode.java.benchmarks.collections.model;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
public class HashCodeKey {

    private long key;

    public HashCodeKey(long key) {
        this.key = key;
    }

    public long getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashCodeKey that = (HashCodeKey) o;

        return key == that.key;
    }

    @Override
    public int hashCode() {
        return (int) key;
    }
}
