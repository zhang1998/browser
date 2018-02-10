package com.uc.apollo.media.impl;

import android.util.Log;
import android.view.Surface;
import com.uc.apollo.annotation.KeepForRuntime;

/* compiled from: ProGuard */
class UCSurface {
    private static final String a = (e.a + "UCSurface");
    private Surface b;
    private int c;
    @KeepForRuntime
    private int mHeight;
    @KeepForRuntime
    private int mWidth;

    private static native int create(UCSurface uCSurface, Surface surface, int i, int i2);

    private static native void destroy(int i);

    private static native void drawBitmap(int i, int[] iArr);

    private static native boolean lock(int i);

    private static native void setSize(int i, int i2, int i3);

    private static native void unlock(int i);

    static {
        try {
            System.loadLibrary("ucmedia");
        } catch (Throwable th) {
            Log.e(a, "System.loadLibrary(\"ucmedia\") failure: " + th);
        }
    }

    public UCSurface(Surface surface, int i, int i2) {
        this.b = surface;
        this.c = create(this, surface, i, i2);
    }

    final void a(int i, int i2) {
        setSize(this.c, i, i2);
    }

    protected void finalize() throws Throwable {
        b();
        super.finalize();
    }

    final boolean a() {
        return this.c != 0;
    }

    public final void b() {
        if (this.c != 0) {
            destroy(this.c);
            this.c = 0;
        }
    }

    final int c() {
        return this.mWidth;
    }

    final int d() {
        return this.mHeight;
    }

    final boolean e() {
        return lock(this.c);
    }

    final void f() {
        unlock(this.c);
    }

    final void a(int[] iArr) {
        drawBitmap(this.c, iArr);
    }
}
