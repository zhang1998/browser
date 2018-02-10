package com.c.a;

import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.view.View;

/* compiled from: ProGuard */
public final class m extends n {
    GLSurfaceView a;

    private m(GLSurfaceView gLSurfaceView) {
        this.a = gLSurfaceView;
    }

    public final View a() {
        return this.a;
    }

    public final void a(Renderer renderer) {
        this.a.setRenderer(renderer);
    }

    public final void b() {
        this.a.setEGLContextClientVersion(2);
        this.a.setPreserveEGLContextOnPause(true);
    }

    public final void c() {
        this.a.onResume();
    }

    public final void d() {
        this.a.onPause();
    }
}
