package com.uc.apollo.media.widget;

import android.view.Surface;

/* compiled from: ProGuard */
final class g implements SurfaceListener {
    final /* synthetic */ MediaViewImpl a;
    private Object b;

    g(MediaViewImpl mediaViewImpl) {
        this.a = mediaViewImpl;
    }

    public final void surfaceChanged(Surface surface, int i, int i2, int i3) {
    }

    public final Object getSibling() {
        return this.b;
    }

    public final void setSibling(Object obj) {
        this.b = obj;
    }

    public final void surfaceCreated(Surface surface) {
        this.a.mLogTag;
        this.a.setSurface(surface);
    }

    public final void surfaceDestroyed(Surface surface) {
        this.a.mLogTag;
        this.a.setSurface(null);
    }
}
