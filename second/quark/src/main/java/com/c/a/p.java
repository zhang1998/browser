package com.c.a;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.c.a.b.b.c;
import com.c.a.b.c.l;
import com.c.a.e.d;
import com.c.a.e.e;
import com.c.a.f.a;
import com.c.a.f.b;
import com.c.a.f.h;
import com.uc.imagecodec.export.IPictureView;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: ProGuard */
public final class p implements Renderer {
    private c a;
    private l b;
    private h c;
    private b d;
    private e e;
    private com.c.a.e.c f;
    private int g;
    private int h;
    private final Context i;

    private p(v vVar) {
        this.f = new com.c.a.e.c();
        this.i = vVar.a;
        this.a = vVar.b;
        this.b = vVar.c;
        this.c = vVar.e;
        this.e = vVar.d;
        this.d = new com.c.a.f.e(this.a);
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glEnable(2884);
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.g = i;
        this.h = i2;
        this.e.a();
    }

    public final void onDrawFrame(GL10 gl10) {
        this.e.a();
        GLES20.glClear(16640);
        d.a("MD360Renderer onDrawFrame 1");
        int a = this.a.a();
        int i = (int) ((((float) this.g) * IPictureView.DEFAULT_MIN_SCALE) / ((float) a));
        int i2 = this.h;
        this.d.b(this.i);
        this.d.a(this.g, this.h, a);
        List list = this.b.b;
        a c = this.b.c();
        if (c != null) {
            c.b(this.i);
            c.a(this.g, this.h);
        }
        for (a aVar : this.c.a) {
            aVar.b(this.i);
            aVar.a(this.g, this.h);
        }
        int i3 = 0;
        while (i3 < a && i3 < list.size()) {
            ac acVar = (ac) list.get(i3);
            GLES20.glViewport(i * i3, 0, i, i2);
            GLES20.glEnable(3089);
            GLES20.glScissor(i * i3, 0, i, i2);
            if (c != null) {
                c.a(i3, i, i2, acVar);
            }
            for (a a2 : this.c.a) {
                a2.a(i3, i, i2, acVar);
            }
            GLES20.glDisable(3089);
            i3++;
        }
        this.d.b(this.g, this.h, a);
    }

    public static v a(Context context) {
        v vVar = new v();
        vVar.a = context;
        return vVar;
    }
}
