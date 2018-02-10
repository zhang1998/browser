package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import java.util.List;

/* compiled from: ProGuard */
final class f implements bo, bq {
    private final Path a = new Path();
    private final cu b;
    private final bl<?, Path> c;
    private boolean d;
    @Nullable
    private bu e;

    f(cu cuVar, cz czVar, cw cwVar) {
        this.b = cuVar;
        this.c = cwVar.a.a();
        czVar.a(this.c);
        this.c.a((bq) this);
    }

    public final void a(List<de> list, List<de> list2) {
        for (int i = 0; i < list.size(); i++) {
            de deVar = (de) list.get(i);
            if ((deVar instanceof bu) && ((bu) deVar).a == o.a) {
                this.e = (bu) deVar;
                this.e.a(this);
            }
        }
    }

    public final Path b() {
        if (this.d) {
            return this.a;
        }
        this.a.reset();
        this.a.set((Path) this.c.a());
        this.a.setFillType(FillType.EVEN_ODD);
        dn.a(this.a, this.e);
        this.d = true;
        return this.a;
    }

    public final void a() {
        this.d = false;
        this.b.invalidateSelf();
    }
}
