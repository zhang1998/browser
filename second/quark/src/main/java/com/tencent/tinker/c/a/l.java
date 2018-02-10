package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.c;

/* compiled from: ProGuard */
public final class l extends ag<l> {
    public int a;
    public int[] b;
    public byte[] c;

    public final /* synthetic */ int compareTo(Object obj) {
        l lVar = (l) obj;
        int i = this.a;
        int i2 = lVar.a;
        if (i != i2) {
            return i - i2;
        }
        int[] iArr = this.b;
        int[] iArr2 = lVar.b;
        int length = iArr.length;
        i = iArr2.length;
        if (length < i) {
            i = -1;
        } else if (length > i) {
            i = 1;
        } else {
            for (i2 = 0; i2 < length; i2++) {
                i = c.a(iArr[i2], iArr2[i2]);
                if (i != 0) {
                    break;
                }
            }
            i = 0;
        }
        if (i == 0) {
            return c.a(this.c, lVar.c);
        }
        return i;
    }

    public l(int i, int i2, int[] iArr, byte[] bArr) {
        super(i);
        this.a = i2;
        this.b = iArr;
        this.c = bArr;
    }
}
