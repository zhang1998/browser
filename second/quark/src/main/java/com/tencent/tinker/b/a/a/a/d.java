package com.tencent.tinker.b.a.a.a;

import com.tencent.tinker.b.a.b.a;
import com.tencent.tinker.b.a.c.f;
import com.tencent.tinker.b.a.c.i;
import com.tencent.tinker.c.a.a.b;
import com.tencent.tinker.c.a.ah;
import com.tencent.tinker.c.a.q;
import com.tencent.tinker.c.a.u;
import java.lang.reflect.Array;

/* compiled from: ProGuard */
public final class d extends i<com.tencent.tinker.c.a.d> {
    private ah c = null;
    private q d = null;

    protected final /* synthetic */ Comparable a(f fVar, Comparable comparable) {
        int i;
        com.tencent.tinker.c.a.d dVar = (com.tencent.tinker.c.a.d) comparable;
        int h = fVar.h(dVar.a);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.b.length, 2});
        for (i = 0; i < iArr.length; i++) {
            iArr[i][0] = fVar.d(dVar.b[i][0]);
            iArr[i][1] = fVar.h(dVar.b[i][1]);
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.c.length, 2});
        for (i = 0; i < iArr2.length; i++) {
            iArr2[i][0] = fVar.e(dVar.c[i][0]);
            iArr2[i][1] = fVar.h(dVar.c[i][1]);
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.d.length, 2});
        for (i = 0; i < iArr3.length; i++) {
            iArr3[i][0] = fVar.e(dVar.d[i][0]);
            iArr3[i][1] = fVar.i(dVar.d[i][1]);
        }
        return new com.tencent.tinker.c.a.d(dVar.i, h, iArr, iArr2, iArr3);
    }

    public d(a aVar, u uVar, u uVar2, i iVar) {
        super(aVar, uVar, iVar);
        if (uVar2 != null) {
            this.c = uVar2.b.r;
            this.d = uVar2.a(this.c);
        }
    }

    protected final void a(i iVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            iVar.j.a(i2, i4);
        }
    }

    protected final ah a(u uVar) {
        return uVar.b.r;
    }

    protected final void a(i iVar, int i, int i2) {
        if (i2 >= 0) {
            iVar.x.a(i2);
        }
    }

    protected final /* synthetic */ Comparable a(b bVar) {
        return bVar.n();
    }
}
