package com.ucpro.feature.bookmarkhis.bookmark.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class a extends AnimatorListenerAdapter {
    final /* synthetic */ int a;
    final /* synthetic */ s b;

    a(s sVar, int i) {
        this.b = sVar;
        this.a = i;
    }

    public final void onAnimationEnd(Animator animator) {
        this.b.e();
        this.b.j();
        this.b.setTextRightBound(this.a);
        this.b.a(false);
    }
}
