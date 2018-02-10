package com.ucpro.feature.video.player.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class d extends AnimatorListenerAdapter {
    public View a = null;

    public d(View view) {
        this.a = view;
    }

    public final void onAnimationStart(Animator animator) {
        c.a(this.a);
        if (this.a != null) {
            this.a.setVisibility(0);
        }
    }
}
