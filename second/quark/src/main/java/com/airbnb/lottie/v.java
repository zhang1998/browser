package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import java.util.List;

/* compiled from: ProGuard */
final class v implements bo, bq {
    private final Path a = new Path();
    private final RectF b = new RectF();
    private final cu c;
    private final bl<?, PointF> d;
    private final bl<?, PointF> e;
    private final bl<?, Float> f;
    @Nullable
    private bu g;
    private boolean h;

    v(cu cuVar, cz czVar, u uVar) {
        this.c = cuVar;
        this.d = uVar.a.a();
        this.e = uVar.b.b();
        this.f = uVar.c.b();
        czVar.a(this.d);
        czVar.a(this.e);
        czVar.a(this.f);
        this.d.a((bq) this);
        this.e.a((bq) this);
        this.f.a((bq) this);
    }

    public final void a(List<de> list, List<de> list2) {
        for (int i = 0; i < list.size(); i++) {
            de deVar = (de) list.get(i);
            if ((deVar instanceof bu) && ((bu) deVar).a == o.a) {
                this.g = (bu) deVar;
                this.g.a(this);
            }
        }
    }

    public final Path b() {
        if (this.h) {
            return this.a;
        }
        this.a.reset();
        PointF pointF = (PointF) this.e.a();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        float floatValue = this.f == null ? 0.0f : ((Float) this.f.a()).floatValue();
        float min = Math.min(f, f2);
        if (floatValue <= min) {
            min = floatValue;
        }
        pointF = (PointF) this.d.a();
        this.a.moveTo(pointF.x + f, (pointF.y - f2) + min);
        this.a.lineTo(pointF.x + f, (pointF.y + f2) - min);
        if (min > 0.0f) {
            this.b.set((pointF.x + f) - (2.0f * min), (pointF.y + f2) - (2.0f * min), pointF.x + f, pointF.y + f2);
            this.a.arcTo(this.b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((pointF.x - f) + min, pointF.y + f2);
        if (min > 0.0f) {
            this.b.set(pointF.x - f, (pointF.y + f2) - (2.0f * min), (pointF.x - f) + (2.0f * min), pointF.y + f2);
            this.a.arcTo(this.b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(pointF.x - f, (pointF.y - f2) + (2.0f * min));
        if (min > 0.0f) {
            this.b.set(pointF.x - f, pointF.y - f2, (pointF.x - f) + (2.0f * min), (pointF.y - f2) + (2.0f * min));
            this.a.arcTo(this.b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((pointF.x + f) - (2.0f * min), pointF.y - f2);
        if (min > 0.0f) {
            this.b.set((pointF.x + f) - (2.0f * min), pointF.y - f2, f + pointF.x, (pointF.y - f2) + (min * 2.0f));
            this.a.arcTo(this.b, 270.0f, 90.0f, false);
        }
        this.a.close();
        dn.a(this.a, this.g);
        this.h = true;
        return this.a;
    }

    public final void a() {
        this.h = false;
        this.c.invalidateSelf();
    }
}
