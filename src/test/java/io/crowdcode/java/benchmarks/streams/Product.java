package io.crowdcode.java.benchmarks.streams;

import java.util.EnumSet;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
public class Product {

    private enum Flags {VALID, AVAILABLE, OUTOFSTOCK};

    // 4x32 + n-flags x 8 = 152
    private boolean[] flagsArray = null; //new boolean[];

    // 160
    private EnumSet<Flags> flags = EnumSet.of(Flags.AVAILABLE);

    // 3 x 32 = 96
    private boolean valid;
    private boolean available;
    private boolean outofstock;


    public void setValid() {
        flags.add(Flags.VALID);
    }
}
