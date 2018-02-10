package com.google.zxing.common;

import java.util.Arrays;

/* compiled from: ProGuard */
public final class BitArray implements Cloneable {
    private int[] bits;
    private int size;

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    public BitArray(int i) {
        this.size = i;
        this.bits = makeArray(i);
    }

    BitArray(int[] iArr, int i) {
        this.bits = iArr;
        this.size = i;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getSizeInBytes() {
        return (this.size + 7) / 8;
    }

    private void ensureCapacity(int i) {
        if (i > this.bits.length * 32) {
            Object makeArray = makeArray(i);
            System.arraycopy(this.bits, 0, makeArray, 0, this.bits.length);
            this.bits = makeArray;
        }
    }

    public final boolean get(int i) {
        return (this.bits[i / 32] & (1 << (i & 31))) != 0;
    }

    public final void set(int i) {
        int[] iArr = this.bits;
        int i2 = i / 32;
        iArr[i2] = iArr[i2] | (1 << (i & 31));
    }

    public final void flip(int i) {
        int[] iArr = this.bits;
        int i2 = i / 32;
        iArr[i2] = iArr[i2] ^ (1 << (i & 31));
    }

    public final int getNextSet(int i) {
        if (i >= this.size) {
            return this.size;
        }
        int i2 = i / 32;
        int i3 = this.bits[i2] & (((1 << (i & 31)) - 1) ^ -1);
        while (i3 == 0) {
            i2++;
            if (i2 == this.bits.length) {
                return this.size;
            }
            i3 = this.bits[i2];
        }
        i2 = (i2 * 32) + Integer.numberOfTrailingZeros(i3);
        return i2 > this.size ? this.size : i2;
    }

    public final int getNextUnset(int i) {
        if (i >= this.size) {
            return this.size;
        }
        int i2 = i / 32;
        int i3 = (this.bits[i2] ^ -1) & (((1 << (i & 31)) - 1) ^ -1);
        while (i3 == 0) {
            i2++;
            if (i2 == this.bits.length) {
                return this.size;
            }
            i3 = this.bits[i2] ^ -1;
        }
        i2 = (i2 * 32) + Integer.numberOfTrailingZeros(i3);
        return i2 > this.size ? this.size : i2;
    }

    public final void setBulk(int i, int i2) {
        this.bits[i / 32] = i2;
    }

    public final void setRange(int i, int i2) {
        if (i2 < i || i < 0 || i2 > this.size) {
            throw new IllegalArgumentException();
        } else if (i2 != i) {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7 = (2 << (i6 < i5 ? 31 : i3 & 31)) - (1 << (i6 > i4 ? 0 : i & 31));
                int[] iArr = this.bits;
                iArr[i6] = i7 | iArr[i6];
                i6++;
            }
        }
    }

    public final void clear() {
        int length = this.bits.length;
        for (int i = 0; i < length; i++) {
            this.bits[i] = 0;
        }
    }

    public final boolean isRange(int i, int i2, boolean z) {
        if (i2 < i || i < 0 || i2 > this.size) {
            throw new IllegalArgumentException();
        } else if (i2 == i) {
            return true;
        } else {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7 = (2 << (i6 < i5 ? 31 : i3 & 31)) - (1 << (i6 > i4 ? 0 : i & 31));
                int i8 = this.bits[i6] & i7;
                if (!z) {
                    i7 = 0;
                }
                if (i8 != i7) {
                    return false;
                }
                i6++;
            }
            return true;
        }
    }

    public final void appendBit(boolean z) {
        ensureCapacity(this.size + 1);
        if (z) {
            int[] iArr = this.bits;
            int i = this.size / 32;
            iArr[i] = iArr[i] | (1 << (this.size & 31));
        }
        this.size++;
    }

    public final void appendBits(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        ensureCapacity(this.size + i2);
        while (i2 > 0) {
            appendBit(((i >> (i2 + -1)) & 1) == 1);
            i2--;
        }
    }

    public final void appendBitArray(BitArray bitArray) {
        int i = bitArray.size;
        ensureCapacity(this.size + i);
        for (int i2 = 0; i2 < i; i2++) {
            appendBit(bitArray.get(i2));
        }
    }

    public final void xor(BitArray bitArray) {
        if (this.size != bitArray.size) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i = 0; i < this.bits.length; i++) {
            int[] iArr = this.bits;
            iArr[i] = iArr[i] ^ bitArray.bits[i];
        }
    }

    public final void toBytes(int i, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        int i5 = i;
        while (i4 < i3) {
            int i6 = i5;
            i5 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (get(i6)) {
                    i5 |= 1 << (7 - i7);
                }
                i6++;
            }
            bArr[i2 + i4] = (byte) i5;
            i4++;
            i5 = i6;
        }
    }

    public final int[] getBitArray() {
        return this.bits;
    }

    public final void reverse() {
        int i;
        int i2 = 1;
        int[] iArr = new int[this.bits.length];
        int i3 = (this.size - 1) / 32;
        int i4 = i3 + 1;
        for (i = 0; i < i4; i++) {
            long j = (long) this.bits[i];
            j = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            j = ((j & 858993459) << 2) | ((j >> 2) & 858993459);
            j = ((j & 252645135) << 4) | ((j >> 4) & 252645135);
            j = ((j & 16711935) << 8) | ((j >> 8) & 16711935);
            iArr[i3 - i] = (int) (((j & 65535) << 16) | ((j >> 16) & 65535));
        }
        if (this.size != i4 * 32) {
            i3 = (i4 * 32) - this.size;
            i = iArr[0] >>> i3;
            while (i2 < i4) {
                int i5 = iArr[i2];
                iArr[i2 - 1] = i | (i5 << (32 - i3));
                i = i5 >>> i3;
                i2++;
            }
            iArr[i4 - 1] = i;
        }
        this.bits = iArr;
    }

    private static int[] makeArray(int i) {
        return new int[((i + 31) / 32)];
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        if (this.size == bitArray.size && Arrays.equals(this.bits, bitArray.bits)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.size * 31) + Arrays.hashCode(this.bits);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.size);
        for (int i = 0; i < this.size; i++) {
            if ((i & 7) == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(get(i) ? 'X' : '.');
        }
        return stringBuilder.toString();
    }

    public final BitArray clone() {
        return new BitArray((int[]) this.bits.clone(), this.size);
    }
}
