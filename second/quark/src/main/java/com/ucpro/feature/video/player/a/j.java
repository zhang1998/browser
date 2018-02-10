package com.ucpro.feature.video.player.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class j extends AnimatorListenerAdapter {
    public View a = null;

    public j(View view) {
        new StringBuilder("mAnimView : ").append(view);
        this.a = view;
    }

    public final void onAnimationEnd(Animator animator) {
        new StringBuilder("onAnimationEnd mAnimView : ").append(this.a);
        c.a(this.a);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
    }
}
