package com.c.a.f;

import android.content.Context;
import android.opengl.GLES20;
import com.c.a.ac;
import com.c.a.b.b.c;
import com.c.a.d;
import com.c.a.d.a;
import com.c.a.z;

/* compiled from: ProGuard */
public final class e extends b {
    com.c.a.a.e a;
    private d b = new d(1);
    private i c = new i(this);
    private ac d = new z().a();
    private boolean e;
    private c f = new c();
    private c g;

    public e(c cVar) {
        this.g = cVar;
        this.a = cVar.c;
    }

    public final void a(Context context) {
        this.b.a();
        a.a(context, this.c);
    }

    public final void a(int i, int i2, int i3) {
        this.e = this.g.b;
        if (this.e) {
            this.f.a(i, i2);
            this.d.a(i, i2);
            this.c.c = i3;
            GLES20.glClear(16640);
            com.c.a.e.d.a("MDBarrelDistortionLinePipe glClear");
        }
    }

    public final void b(int i, int i2, int i3) {
        if (this.e) {
            this.f.a();
            int i4 = i / i3;
            for (int i5 = 0; i5 < i3; i5++) {
                GLES20.glViewport(i4 * i5, 0, i4, i2);
                GLES20.glEnable(3089);
                GLES20.glScissor(i4 * i5, 0, i4, i2);
                this.b.b();
                com.c.a.e.d.a("MDBarrelDistortionLinePipe mProgram use");
                this.c.a(this.b, i5);
                this.c.b(this.b, i5);
                this.d.a(this.b);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.f.a);
                this.c.b();
                GLES20.glDisable(3089);
            }
        }
    }
}
