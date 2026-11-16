package io.crowdcode.java.benchmarks.collections;

import io.crowdcode.java.benchmarks.collections.model.BrokenHashCodeComparableKey;
import io.crowdcode.java.benchmarks.collections.model.BrokenHashCodeKey;
import io.crowdcode.java.benchmarks.collections.model.HashCodeKey;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
@State(Scope.Thread)
public class HashMapState {

    public static final int AMOUNT = 50_000;
    public static final int LOOKUPS = 1_000;

    private final HashCodeKey[] lookupKeys = new HashCodeKey[LOOKUPS];
    private final BrokenHashCodeKey[] brokenLookupKeys = new BrokenHashCodeKey[LOOKUPS];
    private final BrokenHashCodeComparableKey[] brokenComparableLookupKeys = new BrokenHashCodeComparableKey[LOOKUPS];

    private HashMap<HashCodeKey, String> hashMap;
    private HashMap<BrokenHashCodeKey, String> hashMapWithBrokenHashCode;
    private HashMap<BrokenHashCodeComparableKey, String> hashMapWithBrokenHashCodeComparable;

    public HashMapState() {
        this.hashMap = new HashMap<>();
        this.hashMapWithBrokenHashCode = new HashMap<>();
        this.hashMapWithBrokenHashCodeComparable = new HashMap<>();

        for (int i = 0; i < AMOUNT; i++) {
            String uuid = UUID.randomUUID().toString();
            hashMap.put(new HashCodeKey(i), uuid);
            hashMapWithBrokenHashCode.put(new BrokenHashCodeKey(i), uuid);
            hashMapWithBrokenHashCodeComparable.put(new BrokenHashCodeComparableKey(i), uuid);
        }

        // keys to look up, spread evenly over all stored keys
        for (int i = 0; i < LOOKUPS; i++) {
            long key = (long) i * (AMOUNT / LOOKUPS);
            lookupKeys[i] = new HashCodeKey(key);
            brokenLookupKeys[i] = new BrokenHashCodeKey(key);
            brokenComparableLookupKeys[i] = new BrokenHashCodeComparableKey(key);
        }
    }

    public HashCodeKey[] getLookupKeys() {
        return lookupKeys;
    }

    public BrokenHashCodeKey[] getBrokenLookupKeys() {
        return brokenLookupKeys;
    }

    public BrokenHashCodeComparableKey[] getBrokenComparableLookupKeys() {
        return brokenComparableLookupKeys;
    }

    public HashMap<HashCodeKey, String> getHashMap() {
        return hashMap;
    }

    public HashMap<BrokenHashCodeKey, String> getHashMapWithBrokenHashCode() {
        return hashMapWithBrokenHashCode;
    }

    public HashMap<BrokenHashCodeComparableKey, String> getHashMapWithBrokenHashCodeComparable() {
        return hashMapWithBrokenHashCodeComparable;
    }
}
