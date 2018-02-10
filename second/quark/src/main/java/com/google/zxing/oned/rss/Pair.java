package com.google.zxing.oned.rss;

/* compiled from: ProGuard */
final class Pair extends DataCharacter {
    private int count;
    private final FinderPattern finderPattern;

    Pair(int i, int i2, FinderPattern finderPattern) {
        super(i, i2);
        this.finderPattern = finderPattern;
    }

    final FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    final int getCount() {
        return this.count;
    }

    final void incrementCount() {
        this.count++;
    }
}
