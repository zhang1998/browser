package com.airbnb.lottie;

import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class aj implements bq {
    final /* synthetic */ bs a;
    final /* synthetic */ cz b;

    aj(cz czVar, bs bsVar) {
        this.b = czVar;
        this.a = bsVar;
    }

    public final void a() {
        boolean z;
        cz czVar = this.b;
        if (((Float) this.a.a()).floatValue() == IPictureView.DEFAULT_MIN_SCALE) {
            z = true;
        } else {
            z = false;
        }
        czVar.a(z);
    }
}
