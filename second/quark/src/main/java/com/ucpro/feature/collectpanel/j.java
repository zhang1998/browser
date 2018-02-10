package com.ucpro.feature.collectpanel;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.ucpro.base.system.b;
import com.ucpro.feature.inputenhance.a.a;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class j implements OnGlobalLayoutListener {
    final /* synthetic */ i a;
    private int b = -1;

    public j(i iVar) {
        this.a = iVar;
        this.b = a.a(iVar.b.h()).height();
    }

    public final void onGlobalLayout() {
        int height = a.a(this.a.b.h()).height();
        if (((float) height) < ((float) b.a.g()) * 0.8f) {
            if (this.a.i) {
                this.a.a.c();
                m.a(2, new c(this), 300);
                this.a.i = false;
            }
            this.a.a.getContent().animate().translationY((float) (height - this.b));
            this.a.j = true;
            return;
        }
        this.a.a.getContent().animate().translationY(0.0f);
        this.a.j = false;
    }
}
