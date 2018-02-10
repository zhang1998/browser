package com.google.zxing.oned.rss.expanded.decoders;

/* compiled from: ProGuard */
final class DecodedInformation extends DecodedObject {
    private final String newString;
    private final boolean remaining;
    private final int remainingValue;

    DecodedInformation(int i, String str) {
        super(i);
        this.newString = str;
        this.remaining = false;
        this.remainingValue = 0;
    }

    DecodedInformation(int i, String str, int i2) {
        super(i);
        this.remaining = true;
        this.remainingValue = i2;
        this.newString = str;
    }

    final String getNewString() {
        return this.newString;
    }

    final boolean isRemaining() {
        return this.remaining;
    }

    final int getRemainingValue() {
        return this.remainingValue;
    }
}
