package com.uc.b.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.io.DataInputStream;
import java.io.IOException;

/* compiled from: ProGuard */
public final class y extends e {
    public final /* bridge */ /* synthetic */ void a(float f, b bVar, boolean z) {
        super.a(f, bVar, z);
    }

    public final /* bridge */ /* synthetic */ void a(Canvas canvas, Paint paint) {
        super.a(canvas, paint);
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

    public y() {
        super();
    }

    static y a(DataInputStream dataInputStream) throws IOException {
        float[] a = af.b(dataInputStream);
        if (a == null || a.length <= 0) {
            return null;
        }
        e yVar = new y();
        super.a(a);
        return yVar;
    }

    public final boolean c() {
        return true;
    }
}
