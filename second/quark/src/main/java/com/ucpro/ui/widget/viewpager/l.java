package com.ucpro.ui.widget.viewpager;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.b;
import android.support.v4.view.g;
import android.view.View;

/* compiled from: ProGuard */
final class l implements b {
    final /* synthetic */ ProViewPager a;
    private final Rect b = new Rect();

    l(ProViewPager proViewPager) {
        this.a = proViewPager;
    }

    public final g a(View view, g gVar) {
        g a = ViewCompat.a(view, gVar);
        if (a.e()) {
            return a;
        }
        Rect rect = this.b;
        rect.left = a.a();
        rect.top = a.b();
        rect.right = a.c();
        rect.bottom = a.d();
        int childCount = this.a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            g b = ViewCompat.b(this.a.getChildAt(i), a);
            rect.left = Math.min(b.a(), rect.left);
            rect.top = Math.min(b.b(), rect.top);
            rect.right = Math.min(b.c(), rect.right);
            rect.bottom = Math.min(b.d(), rect.bottom);
        }
        return a.a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
