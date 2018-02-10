package com.google.zxing.oned.rss.expanded.decoders;

/* compiled from: ProGuard */
abstract class DecodedObject {
    private final int newPosition;

    DecodedObject(int i) {
        this.newPosition = i;
    }

    final int getNewPosition() {
        return this.newPosition;
    }
}
