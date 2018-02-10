package com.ucpro.feature.downloadpage.e.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class q extends AnimatorListenerAdapter {
    final /* synthetic */ t a;

    q(t tVar) {
        this.a = tVar;
    }

    public final void onAnimationEnd(Animator animator) {
        ((LayoutParams) this.a.l.getLayoutParams()).rightMargin = a.c((int) R.dimen.download_list_item_status_icon_padding);
        this.a.requestLayout();
    }
}
