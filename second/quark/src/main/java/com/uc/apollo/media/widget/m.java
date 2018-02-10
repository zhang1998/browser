package com.uc.apollo.media.widget;

import android.view.Surface;
import com.c.a.j;

/* compiled from: ProGuard */
final class m implements j {
    final /* synthetic */ SurfaceProviderVRImpl a;

    m(SurfaceProviderVRImpl surfaceProviderVRImpl) {
        this.a = surfaceProviderVRImpl;
    }

    public final void onSurfaceReady(Surface surface) {
        this.a.d = surface;
        this.a.a(surface);
    }
}
