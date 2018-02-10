package com.ucpro.ui.widget.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.os.Message;
import java.util.ArrayList;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
final class aa implements AnimatorListener {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ w b;

    aa(w wVar, ArrayList arrayList) {
        this.b = wVar;
        this.a = arrayList;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        Message obtain = Message.obtain();
        obtain.what = SpdyProtocol.SLIGHTSSL_0_RTT_MODE;
        obtain.obj = this.a;
        this.b.a.v.sendMessage(obtain);
    }

    public final void onAnimationCancel(Animator animator) {
    }
}
