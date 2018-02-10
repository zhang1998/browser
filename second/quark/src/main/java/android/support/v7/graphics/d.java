package android.support.v7.graphics;

import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import java.util.Arrays;

/* compiled from: ProGuard */
final class d {
    int a;
    final /* synthetic */ f b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    d(f fVar, int i, int i2) {
        this.b = fVar;
        this.c = i;
        this.a = i2;
        c();
    }

    final int a() {
        return (((this.f - this.e) + 1) * ((this.h - this.g) + 1)) * ((this.j - this.i) + 1);
    }

    final boolean b() {
        return (this.a + 1) - this.c > 1;
    }

    final void c() {
        int[] iArr = this.b.a;
        int[] iArr2 = this.b.b;
        int i = SectionHeader.SHT_LOUSER;
        int i2 = 0;
        int i3 = SectionHeader.SHT_LOUSER;
        int i4 = Integer.MAX_VALUE;
        int i5 = Integer.MAX_VALUE;
        int i6 = Integer.MAX_VALUE;
        int i7 = SectionHeader.SHT_LOUSER;
        for (int i8 = this.c; i8 <= this.a; i8++) {
            int i9 = iArr[i8];
            i2 += iArr2[i9];
            int a = ((i9 >> 10) & 31);
            int b = ((i9 >> 5) & 31);
            i9 = (i9 & 31);
            if (a > i3) {
                i3 = a;
            }
            if (a < i6) {
                i6 = a;
            }
            if (b > i7) {
                i7 = b;
            }
            if (b < i5) {
                i5 = b;
            }
            if (i9 > i) {
                i = i9;
            }
            if (i9 < i4) {
                i4 = i9;
            }
        }
        this.e = i6;
        this.f = i3;
        this.g = i5;
        this.h = i7;
        this.i = i4;
        this.j = i;
        this.d = i2;
    }

    final b e() {
        int i = 0;
        int[] iArr = this.b.a;
        int[] iArr2 = this.b.b;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = this.c; i5 <= this.a; i5++) {
            int i6 = iArr[i5];
            int i7 = iArr2[i6];
            i += i7;
            i4 += ((i6 >> 10) & 31) * i7;
            i3 += ((i6 >> 5) & 31) * i7;
            i2 += (i6 & 31) * i7;
        }
        return new b(f.b(Math.round(((float) i4) / ((float) i)), Math.round(((float) i3) / ((float) i)), Math.round(((float) i2) / ((float) i))), i);
    }

    final int d() {
        int i = this.f - this.e;
        int i2 = this.h - this.g;
        int i3 = this.j - this.i;
        if (i >= i2 && i >= i3) {
            i = -3;
        } else if (i2 < i || i2 < i3) {
            i = -1;
        } else {
            i = -2;
        }
        int[] iArr = this.b.a;
        int[] iArr2 = this.b.b;
        f.a(iArr, i, this.c, this.a);
        Arrays.sort(iArr, this.c, this.a + 1);
        f.a(iArr, i, this.c, this.a);
        int i4 = this.d / 2;
        i = 0;
        for (i2 = this.c; i2 <= this.a; i2++) {
            i += iArr2[iArr[i2]];
            if (i >= i4) {
                return i2;
            }
        }
        return this.c;
    }
}
