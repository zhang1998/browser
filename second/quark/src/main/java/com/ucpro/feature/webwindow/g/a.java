package com.ucpro.feature.webwindow.g;

import android.graphics.Rect;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
public final class a implements OnGlobalLayoutListener {
    final /* synthetic */ d a;

    public a(d dVar) {
        this.a = dVar;
    }

    public final void onGlobalLayout() {
        d dVar = this.a;
        Rect rect = new Rect();
        dVar.a.getWindowVisibleDisplayFrame(rect);
        int i = rect.bottom - rect.top;
        if (i != dVar.f) {
            dVar.e.topMargin = i - dVar.b.getSearchPageHeight();
            dVar.b.setVisibility(4);
            dVar.a.getBusinessLayer().requestLayout();
            dVar.b.setVisibility(0);
            dVar.f = i;
            m.a(2, new l(dVar));
        }
    }
}
