package com.google.zxing.oned.rss.expanded.decoders;

/* compiled from: ProGuard */
final class DecodedChar extends DecodedObject {
    static final char FNC1 = '$';
    private final char value;

    DecodedChar(int i, char c) {
        super(i);
        this.value = c;
    }

    final char getValue() {
        return this.value;
    }

    final boolean isFNC1() {
        return this.value == FNC1;
    }
}
