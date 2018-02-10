package com.uc.apollo.media.widget;

import com.c.a.t;
import com.uc.apollo.media.MediaDefines;

/* compiled from: ProGuard */
final class l implements t {
    final /* synthetic */ SurfaceProviderVRImpl a;

    l(SurfaceProviderVRImpl surfaceProviderVRImpl) {
        this.a = surfaceProviderVRImpl;
    }

    public final void onNotSupport(int i) {
        if (i == 1 && this.a.b != null) {
            this.a.b.onSurfaceInfo(MediaDefines.MSG_DISABLE_VR_SENSOR, 1);
        }
    }
}
