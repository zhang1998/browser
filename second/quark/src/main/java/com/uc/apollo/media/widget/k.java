package com.uc.apollo.media.widget;

import android.content.Context;
import com.uc.apollo.base.ConfigFile;
import com.uc.apollo.media.widget.SurfaceProvider.a;

/* compiled from: ProGuard */
public final class k extends j {
    private boolean k;

    public k(Context context, boolean z) {
        super(context, z);
    }

    public final void setVideoSize(int i, int i2) {
        boolean z = true;
        int vRType = ConfigFile.getVRType();
        if (!(vRType == 1 || (vRType == 0 && this.j && i > 0 && i == i2 * 2))) {
            z = false;
        }
        this.k = z;
        if (this.g != null) {
            if (this.k) {
                if (!(this.g instanceof SurfaceProviderVRImpl)) {
                    a();
                }
            } else if (this.g instanceof SurfaceProviderVRImpl) {
                a();
            }
        }
        super.setVideoSize(i, i2);
    }

    protected final void b() {
        if (this.g == null) {
            if (this.k) {
                this.g = SurfaceProviderVRImpl.c();
                if (this.g != null) {
                    this.g.setOnInfoListener(this.h);
                }
            }
            if (this.g == null) {
                super.b();
            } else {
                c();
            }
        }
    }

    public final void setOnInfoListener(a aVar) {
        super.setOnInfoListener(aVar);
        if (this.g != null) {
            this.g.setOnInfoListener(this.h);
        }
    }
}
