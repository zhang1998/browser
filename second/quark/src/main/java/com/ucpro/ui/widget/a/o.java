package com.ucpro.ui.widget.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.os.Message;
import android.view.View;
import com.uc.crashsdk.export.LogType;

/* compiled from: ProGuard */
final class o implements AnimatorListener {
    final /* synthetic */ int a;
    final /* synthetic */ View b;
    final /* synthetic */ View c;
    final /* synthetic */ w d;

    o(w wVar, int i, View view, View view2) {
        this.d = wVar;
        this.a = i;
        this.b = view;
        this.c = view2;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.d.a.v.hasMessages(this.a)) {
            this.d.a.v.removeMessages(this.a);
        }
        d dVar = new d();
        dVar.a = this.b;
        dVar.b = this.c;
        w wVar = this.d;
        Message obtain = Message.obtain();
        obtain.what = LogType.UNEXP;
        obtain.obj = dVar;
        wVar.a.v.sendMessageDelayed(obtain, 0);
    }

    public final void onAnimationCancel(Animator animator) {
    }
}
