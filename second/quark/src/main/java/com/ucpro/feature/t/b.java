package com.ucpro.feature.t;

import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.t.a.a;
import com.ucpro.feature.t.b.k;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ k b;

    b(k kVar, int i) {
        this.b = kVar;
        this.a = i;
    }

    public final void run() {
        l e = this.b.e;
        int i = this.a;
        f rVar = new r(this);
        if (i >= 0 && i < e.a.getChildCount()) {
            k kVar = (k) e.a.a(i);
            if (kVar != null) {
                int[] iArr = new int[2];
                kVar.getLocationInWindow(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                e.c.setAnimStartX((float) i2);
                e.c.setAnimStartY((float) i3);
                if (i == 0) {
                    e.d.getLocationInWindow(iArr);
                    e.c.a(true, iArr);
                } else {
                    e.c.a(false, null);
                }
                a aVar = e.c;
                aVar.b = aVar.p.getScaleX();
                aVar.c = IPictureView.DEFAULT_MIN_SCALE;
                aVar.d = 0.0f;
                aVar.e = 0.0f;
                i = (int) (((float) aVar.g) / aVar.b);
                aVar.k = IPictureView.DEFAULT_MIN_SCALE;
                aVar.l = 0.0f;
                aVar.a(i, aVar.f, rVar, false);
                aVar.setVisibility(0);
            }
            e.b.a();
            e.d.animate().cancel();
        }
    }
}
