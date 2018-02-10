package com.tencent.tinker.b.a.a.a;

import com.tencent.tinker.b.a.b.a;
import com.tencent.tinker.b.a.c.f;
import com.tencent.tinker.b.a.c.h;
import com.tencent.tinker.c.a.a.b;
import com.tencent.tinker.c.a.ah;
import com.tencent.tinker.c.a.i;
import com.tencent.tinker.c.a.k;
import com.tencent.tinker.c.a.q;
import com.tencent.tinker.c.a.u;

/* compiled from: ProGuard */
public final class g extends i<k> {
    private ah c = null;
    private q d = null;

    protected final /* synthetic */ Comparable a(f fVar, Comparable comparable) {
        i[] iVarArr;
        k kVar = (k) comparable;
        int m = fVar.m(kVar.d);
        short[] sArr = kVar.e;
        if (!(sArr == null || sArr.length == 0)) {
            sArr = new h(fVar).a(sArr);
        }
        i[] iVarArr2 = kVar.g;
        if (iVarArr2 == null || iVarArr2.length == 0) {
            iVarArr = iVarArr2;
        } else {
            iVarArr = new i[iVarArr2.length];
            for (int i = 0; i < iVarArr2.length; i++) {
                i iVar = iVarArr2[i];
                int length = iVar.a.length;
                int[] iArr = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = fVar.b(iVar.a[i2]);
                }
                iVarArr[i] = new i(iArr, iVar.b, iVar.c, iVar.d);
            }
        }
        return new k(kVar.i, kVar.a, kVar.b, kVar.c, m, sArr, kVar.f, iVarArr);
    }

    public g(a aVar, u uVar, u uVar2, com.tencent.tinker.b.a.c.i iVar) {
        super(aVar, uVar, iVar);
        if (uVar2 != null) {
            this.c = uVar2.b.m;
            this.d = uVar2.a(this.c);
        }
    }

    protected final void a(com.tencent.tinker.b.a.c.i iVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            iVar.n.a(i2, i4);
        }
    }

    protected final ah a(u uVar) {
        return uVar.b.m;
    }

    protected final void a(com.tencent.tinker.b.a.c.i iVar, int i, int i2) {
        if (i2 >= 0) {
            iVar.B.a(i2);
        }
    }

    protected final /* synthetic */ Comparable a(b bVar) {
        return bVar.h();
    }
}
