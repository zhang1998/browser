package com.airbnb.lottie;

import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class ca implements t {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ LottieAnimationView c;

    ca(LottieAnimationView lottieAnimationView, int i, String str) {
        this.c = lottieAnimationView;
        this.a = i;
        this.b = str;
    }

    public final void a(k kVar) {
        if (this.a == at.c) {
            LottieAnimationView.c.put(this.b, kVar);
        } else if (this.a == at.b) {
            LottieAnimationView.d.put(this.b, new WeakReference(kVar));
        }
        this.c.setComposition(kVar);
    }
}
