package com.uc.weex.component.k;

import android.mini.support.v4.view.ao;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class e extends ao {
    List<View> a = new ArrayList();
    final /* synthetic */ f b;

    e(f fVar) {
        this.b = fVar;
    }

    public final int a() {
        return this.a.size();
    }

    public final Object a(ViewGroup viewGroup, int i) {
        View view = (View) this.a.get(i);
        if (viewGroup.indexOfChild(view) < 0) {
            viewGroup.addView(view, 0, this.b.generateDefaultLayoutParams());
        }
        return view;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final int a(Object obj) {
        return this.a.indexOf(obj) >= 0 ? -1 : -2;
    }
}
