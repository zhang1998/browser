package com.ucpro.ui.widget.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.uc.crashsdk.export.LogType;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
final class m extends AnimatorListenerAdapter implements AnimatorUpdateListener {
    final /* synthetic */ z a;
    private final ac b;
    private final View c;

    private m(z zVar, ac acVar, View view) {
        this.a = zVar;
        this.b = acVar;
        this.c = view;
    }

    public final void onAnimationStart(Animator animator) {
        this.a.t = true;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.b.a(((Integer) valueAnimator.getAnimatedValue()).intValue());
        this.a.l.a().postInvalidate();
    }

    public final void onAnimationEnd(Animator animator) {
        this.c.setVisibility(0);
        x.a(z.a, "origin position is " + this.a.q + " last position is " + this.a.a(this.a.f));
        this.a.v.removeMessages(SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
        this.a.v.removeMessages(LogType.UNEXP);
        if (this.a.u != null) {
            this.a.u.a();
        }
        n nVar = (n) this.a.d;
        this.a.o;
        nVar.a(this.a.q);
        this.a.e = null;
        this.a.o = null;
        this.a.f = -1;
        this.a.q = -1;
        this.a.t = false;
    }
}
