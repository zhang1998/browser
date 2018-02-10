package com.ucpro.feature.a;

import android.view.View;
import com.uc.weex.component.e;
import com.ucpro.feature.video.player.a.g;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class j {
    private static j d;
    e a;
    WeakReference<View> b;
    g c = new t(this);

    private j() {
    }

    public static j a() {
        if (d == null) {
            d = new j();
        }
        return d;
    }

    public final void a(View view) {
        this.b = new WeakReference(view);
    }

    public final void b() {
        if (this.a != null) {
            try {
                this.a.c();
            } catch (Exception e) {
            }
        }
    }
}
