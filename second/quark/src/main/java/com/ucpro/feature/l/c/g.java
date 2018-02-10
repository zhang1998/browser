package com.ucpro.feature.l.c;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: ProGuard */
public final class g extends com.ucpro.ui.widget.viewpager.g {
    final /* synthetic */ j b;

    public g(j jVar) {
        this.b = jVar;
    }

    public final int a() {
        return this.b.d.size();
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final Object a(ViewGroup viewGroup, int i) {
        View view = (View) this.b.d.get(i);
        viewGroup.addView(view);
        return view;
    }

    public final void a(ViewGroup viewGroup, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final CharSequence a(int i) {
        return ((m) this.b.d.get(i)).getPageTitle();
    }
}
