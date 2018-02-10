package android.support.v4.app;

import android.support.annotation.Nullable;
import android.support.v4.d.s;

/* compiled from: ProGuard */
public final class am {
    public final bm<?> a;

    am(bm<?> bmVar) {
        this.a = bmVar;
    }

    @Nullable
    final Fragment a(String str) {
        return this.a.e.b(str);
    }

    public final void a() {
        this.a.e.t = false;
    }

    public final boolean b() {
        return this.a.e.e();
    }

    public final s<String, cr> c() {
        int i;
        int i2 = 0;
        bm bmVar = this.a;
        if (bmVar.f != null) {
            int size = bmVar.f.size();
            cs[] csVarArr = new cs[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                csVarArr[i3] = (cs) bmVar.f.c(i3);
            }
            i = 0;
            while (i2 < size) {
                cs csVar = csVarArr[i2];
                if (csVar.f) {
                    i = 1;
                } else {
                    csVar.g();
                    bmVar.f.remove(csVar.d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            return bmVar.f;
        }
        return null;
    }
}
