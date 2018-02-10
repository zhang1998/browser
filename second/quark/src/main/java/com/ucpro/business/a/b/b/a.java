package com.ucpro.business.a.b.b;

import android.content.Context;
import com.airbnb.lottie.LottieAnimationView;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class a extends LottieAnimationView {
    final /* synthetic */ h b;

    a(h hVar, Context context) {
        this.b = hVar;
        super(context);
    }

    public final void b() {
        if (h.a(this.b)) {
            d();
            setProgress(IPictureView.DEFAULT_MIN_SCALE);
            return;
        }
        if (this.b.i <= 0) {
            a(true);
        } else {
            setRepeatCount(this.b.i - 1);
        }
        super.b();
    }

    public final void c() {
        if (h.a(this.b)) {
            d();
            setProgress(IPictureView.DEFAULT_MIN_SCALE);
            return;
        }
        if (this.b.i <= 0) {
            a(true);
        } else {
            setRepeatCount(this.b.i - 1);
        }
        super.c();
    }
}
