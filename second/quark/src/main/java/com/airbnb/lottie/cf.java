package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import java.util.List;

/* compiled from: ProGuard */
final class cf implements bo, bq {
    private final Path a = new Path();
    private final cu b;
    private final bl<?, PointF> c;
    private final bl<?, PointF> d;
    @Nullable
    private bu e;
    private boolean f;

    cf(cu cuVar, cz czVar, dp dpVar) {
        this.b = cuVar;
        this.c = dpVar.b.b();
        this.d = dpVar.a.a();
        czVar.a(this.c);
        czVar.a(this.d);
        this.c.a((bq) this);
        this.d.a((bq) this);
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
        if (this.f) {
            return this.a;
        }
        this.a.reset();
        PointF pointF = (PointF) this.c.a();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.a.reset();
        this.a.moveTo(0.0f, -f2);
        this.a.cubicTo(0.0f + f3, -f2, f, 0.0f - f4, f, 0.0f);
        this.a.cubicTo(f, 0.0f + f4, 0.0f + f3, f2, 0.0f, f2);
        this.a.cubicTo(0.0f - f3, f2, -f, 0.0f + f4, -f, 0.0f);
        this.a.cubicTo(-f, 0.0f - f4, 0.0f - f3, -f2, 0.0f, -f2);
        pointF = (PointF) this.d.a();
        this.a.offset(pointF.x, pointF.y);
        this.a.close();
        dn.a(this.a, this.e);
        this.f = true;
        return this.a;
    }

    public final void a() {
        this.f = false;
        this.b.invalidateSelf();
    }
}
