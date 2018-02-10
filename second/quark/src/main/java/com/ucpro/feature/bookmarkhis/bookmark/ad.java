package com.ucpro.feature.bookmarkhis.bookmark;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.ucpro.base.system.b;
import com.ucpro.feature.inputenhance.a.a;

/* compiled from: ProGuard */
final class ad implements OnGlobalLayoutListener {
    final /* synthetic */ o a;

    ad(o oVar) {
        this.a = oVar;
    }

    public final void onGlobalLayout() {
        int height = a.a(this.a.a).height();
        boolean z = ((float) height) < ((float) b.a.g()) * 0.8f;
        if (z && this.a.h) {
            this.a.b.a(height);
            this.a.h = false;
            this.a.i = true;
        }
        if (!z && this.a.i) {
            m mVar = this.a.b;
            mVar.g.animate().alpha(0.0f).setDuration(300).setListener(new h(mVar)).start();
            this.a.i = false;
        }
    }
}
