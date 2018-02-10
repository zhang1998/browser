package android.support.v7.graphics;

import android.graphics.Color;
import android.support.v4.b.a;
import android.util.TimingLogger;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* compiled from: ProGuard */
public final class f {
    private static final Comparator<d> g = new a();
    final int[] a;
    final int[] b;
    public final List<b> c;
    final TimingLogger d = null;
    final c[] e;
    private final float[] f = new float[3];

    public f(int[] iArr, int i, c[] cVarArr) {
        int i2;
        int i3 = 0;
        this.e = cVarArr;
        int[] iArr2 = new int[WXMediaMessage.THUMB_LENGTH_LIMIT];
        this.b = iArr2;
        for (i2 = 0; i2 < iArr.length; i2++) {
            int i4 = iArr[i2];
            i4 = c(Color.blue(i4), 8, 5) | ((c(Color.red(i4), 8, 5) << 10) | (c(Color.green(i4), 8, 5) << 5));
            iArr[i2] = i4;
            iArr2[i4] = iArr2[i4] + 1;
        }
        i2 = 0;
        for (i4 = 0; i4 < WXMediaMessage.THUMB_LENGTH_LIMIT; i4++) {
            if (iArr2[i4] > 0) {
                a.a(d(i4), this.f);
                if (a(this.f)) {
                    iArr2[i4] = 0;
                }
            }
            if (iArr2[i4] > 0) {
                i2++;
            }
        }
        int[] iArr3 = new int[i2];
        this.a = iArr3;
        int i5 = 0;
        int i6 = 0;
        while (i5 < WXMediaMessage.THUMB_LENGTH_LIMIT) {
            if (iArr2[i5] > 0) {
                i4 = i6 + 1;
                iArr3[i6] = i5;
            } else {
                i4 = i6;
            }
            i5++;
            i6 = i4;
        }
        if (i2 <= i) {
            this.c = new ArrayList();
            i2 = iArr3.length;
            while (i3 < i2) {
                i4 = iArr3[i3];
                this.c.add(new b(d(i4), iArr2[i4]));
                i3++;
            }
            return;
        }
        Collection priorityQueue = new PriorityQueue(i, g);
        priorityQueue.offer(new d(this, 0, this.a.length - 1));
        a(priorityQueue, i);
        this.c = a(priorityQueue);
    }

    private static void a(PriorityQueue<d> priorityQueue, int i) {
        while (priorityQueue.size() < i) {
            d dVar = (d) priorityQueue.poll();
            if (dVar != null && dVar.b()) {
                if (dVar.b()) {
                    int d = dVar.d();
                    d dVar2 = new d(dVar.b, d + 1, dVar.a);
                    dVar.a = d;
                    dVar.c();
                    priorityQueue.offer(dVar2);
                    priorityQueue.offer(dVar);
                } else {
                    throw new IllegalStateException("Can not split a box with only 1 color");
                }
            }
            return;
        }
    }

    private List<b> a(Collection<d> collection) {
        List arrayList = new ArrayList(collection.size());
        for (d e : collection) {
            b e2 = e.e();
            if (!a(e2.a())) {
                arrayList.add(e2);
            }
        }
        return arrayList;
    }

    private boolean a(float[] fArr) {
        if (this.e == null || this.e.length <= 0) {
            return false;
        }
        for (c a : this.e) {
            if (!a.a(fArr)) {
                return true;
            }
        }
        return false;
    }

    private static int b(int i, int i2, int i3) {
        return Color.rgb(c(i, 5, 8), c(i2, 5, 8), c(i3, 5, 8));
    }

    private static int c(int i, int i2, int i3) {
        int i4;
        if (i3 > i2) {
            i4 = (((1 << i3) - 1) * i) / ((1 << i2) - 1);
        } else {
            i4 = i >> (i2 - i3);
        }
        return i4 & ((1 << i3) - 1);
    }

    private static int d(int i) {
        return b((i >> 10) & 31, (i >> 5) & 31, i & 31);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(int[] r3, int r4, int r5, int r6) {
        /*
        switch(r4) {
            case -3: goto L_0x0003;
            case -2: goto L_0x0004;
            case -1: goto L_0x001d;
            default: goto L_0x0003;
        };
    L_0x0003:
        return;
    L_0x0004:
        if (r5 > r6) goto L_0x0003;
    L_0x0006:
        r0 = r3[r5];
        r1 = r0 >> 5;
        r1 = r1 & 31;
        r1 = r1 << 10;
        r2 = r0 >> 10;
        r2 = r2 & 31;
        r2 = r2 << 5;
        r1 = r1 | r2;
        r0 = r0 & 31;
        r0 = r0 | r1;
        r3[r5] = r0;
        r5 = r5 + 1;
        goto L_0x0004;
    L_0x001d:
        if (r5 > r6) goto L_0x0003;
    L_0x001f:
        r0 = r3[r5];
        r1 = r0 & 31;
        r1 = r1 << 10;
        r2 = r0 >> 5;
        r2 = r2 & 31;
        r2 = r2 << 5;
        r1 = r1 | r2;
        r0 = r0 >> 10;
        r0 = r0 & 31;
        r0 = r0 | r1;
        r3[r5] = r0;
        r5 = r5 + 1;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.graphics.f.a(int[], int, int, int):void");
    }
}
