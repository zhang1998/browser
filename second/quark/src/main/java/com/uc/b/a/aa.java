package com.uc.b.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path.Direction;
import android.graphics.RectF;

/* compiled from: ProGuard */
public final class aa extends d {
    public final /* bridge */ /* synthetic */ void a(float f, b bVar, boolean z) {
        super.a(f, bVar, z);
    }

    public final /* bridge */ /* synthetic */ void a(Canvas canvas, Paint paint) {
        super.a(canvas, paint);
    }

    public final /* bridge */ /* synthetic */ void a(s sVar) {
        super.a(sVar);
    }

    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    public final /* bridge */ /* synthetic */ void b(float f, b bVar, boolean z) {
        super.b(f, bVar, z);
    }

    public final /* bridge */ /* synthetic */ Matrix d() {
        return super.d();
    }

    public aa(float f, float f2, float f3, float f4) {
        this.c.moveTo(f, f2);
        this.c.lineTo(f, f2 + f4);
        this.c.lineTo(f + f3, f2 + f4);
        this.c.lineTo(f + f3, f2);
        this.c.close();
    }

    public aa(float f, float f2, float f3, float f4, float f5, float f6) {
        this.c.addRoundRect(new RectF(f, f2, f + f3, f2 + f4), f5, f6, Direction.CCW);
    }
}
