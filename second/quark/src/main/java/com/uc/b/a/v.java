package com.uc.b.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.ArrayList;

/* compiled from: ProGuard */
class v extends c {
    ArrayList<c> c = new ArrayList();

    public v(v vVar) {
        super(vVar);
        int size = vVar.c.size();
        for (int i = 0; i < size; i++) {
            this.c.add(((c) vVar.c.get(i)).a());
        }
    }

    final void a(Canvas canvas, Paint paint) {
        s sVar = this.a;
        if (255 != sVar.a) {
            canvas.saveLayerAlpha(this.b, sVar.a, 4);
        }
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            c cVar = (c) this.c.get(i);
            if (cVar != null) {
                cVar.a(canvas, paint);
            }
        }
        if (255 != this.a.a) {
            canvas.restore();
        }
    }

    public final void a(float f, b bVar, boolean z) {
        super.a(f, bVar, z);
        Matrix d = d();
        if (z && d != null) {
            bVar.a();
            bVar.a(d);
        }
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            c cVar = (c) this.c.get(i);
            if (cVar != null) {
                cVar.b(f, bVar, z);
            }
        }
        if (z && d != null) {
            bVar.b();
        }
    }

    public final void a(s sVar) {
        super.a(sVar);
        s sVar2 = this.a;
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            c cVar = (c) this.c.get(i);
            if (cVar != null) {
                cVar.a(sVar2);
            }
        }
    }

    protected final c a() {
        return new v(this);
    }

    public final void b() {
        this.b.setEmpty();
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            c cVar = (c) this.c.get(i);
            if (cVar != null) {
                RectF rectF = cVar.b;
                if (rectF != null) {
                    a(rectF.left, rectF.top, rectF.right, rectF.bottom);
                }
            }
        }
    }
}
