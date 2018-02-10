package com.google.zxing.common;

/* compiled from: ProGuard */
public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public final int getBitOffset() {
        return this.bitOffset;
    }

    public final int getByteOffset() {
        return this.byteOffset;
    }

    public final int readBits(int i) {
        if (i <= 0 || i > 32 || i > available()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2;
        int i3;
        if (this.bitOffset > 0) {
            i2 = 8 - this.bitOffset;
            i3 = i < i2 ? i : i2;
            i2 -= i3;
            i2 = (((255 >> (8 - i3)) << i2) & this.bytes[this.byteOffset]) >> i2;
            i -= i3;
            this.bitOffset = i3 + this.bitOffset;
            if (this.bitOffset == 8) {
                this.bitOffset = 0;
                this.byteOffset++;
            }
            i3 = i2;
            i2 = i;
        } else {
            i3 = 0;
            i2 = i;
        }
        if (i2 <= 0) {
            return i3;
        }
        while (i2 >= 8) {
            i3 = (i3 << 8) | (this.bytes[this.byteOffset] & 255);
            this.byteOffset++;
            i2 -= 8;
        }
        if (i2 <= 0) {
            return i3;
        }
        int i4 = 8 - i2;
        i3 = (i3 << i2) | ((((255 >> i4) << i4) & this.bytes[this.byteOffset]) >> i4);
        this.bitOffset = i2 + this.bitOffset;
        return i3;
    }

    public final int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }
}
