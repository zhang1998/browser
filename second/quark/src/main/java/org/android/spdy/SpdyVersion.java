package org.android.spdy;

/* compiled from: ProGuard */
public enum SpdyVersion {
    SPDY2(2),
    SPDY3(3),
    SPDY3DOT1(4);
    
    private int version;

    private SpdyVersion(int i) {
        this.version = i;
    }

    final int getInt() {
        return this.version;
    }
}
