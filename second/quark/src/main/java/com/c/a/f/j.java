package com.c.a.f;

import android.content.Context;
import android.opengl.GLES20;
import com.c.a.a.a;
import com.c.a.ac;
import com.c.a.b.c.l;
import com.c.a.c.b;
import com.c.a.d;
import com.c.a.d.c;
import com.c.a.z;

/* compiled from: ProGuard */
public final class j extends a {
    private d a;
    private d b = new d(1);
    private b c;
    private l d;
    private f e;
    private ac f;
    private c g;

    public j(a aVar, float f, int i) {
        this.c = aVar.a;
        this.a = new d(aVar.b);
        this.d = aVar.c;
        this.f = new z().a();
        this.e = new f(this, f, i);
        this.g = new c();
    }

    public final void a(Context context) {
        this.a.a();
        this.b.a();
        this.c.b();
        com.c.a.d.a.a(context, this.e);
    }

    public final void a(int i, int i2) {
        this.f.a(i, i2);
        this.g.a(i, i2);
        GLES20.glClear(16640);
        com.c.a.e.d.a("MDMultiFisheyeConvertLinePipe glClear");
        int i3 = i / 2;
        for (int i4 = 0; i4 < 2; i4++) {
            GLES20.glViewport(i3 * i4, 0, i3, i2);
            GLES20.glEnable(3089);
            GLES20.glScissor(i3 * i4, 0, i3, i2);
            this.a.b();
            this.c.a(this.a);
            this.f.a(i3, i2);
            this.e.a(this.a, i4);
            this.e.b(this.a, i4);
            this.f.a(this.a);
            this.e.b();
            GLES20.glDisable(3089);
        }
        this.g.a();
    }

    public final void a(int i, int i2, int i3, ac acVar) {
        c a = this.d.a();
        if (a != null) {
            acVar.a(i2, i3);
            this.b.b();
            com.c.a.e.d.a("MDPanoramaPlugin mProgram use");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.g.a);
            a.a(this.b, i);
            a.b(this.b, i);
            acVar.a(this.b, this.d.b());
            a.b();
        }
    }

    public final void a() {
        this.c = null;
    }
}
