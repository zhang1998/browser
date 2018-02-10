package com.uc.weex.component.j;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.uc.weex.component.e;

/* compiled from: ProGuard */
public final class b implements e {
    final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    public final void a() {
        a("start");
    }

    public final void b() {
        a("pause");
    }

    public final void c() {
        a("finish");
    }

    public final void d() {
        a("fail");
    }

    public final void e() {
        if (this.a.getHostView() != null) {
            ((FrameLayout) this.a.getHostView()).removeAllViews();
        }
    }

    private void a(String str) {
        if (this.a.getDomObject().c_().contains(str)) {
            this.a.getInstance().b(this.a.getDomObject().b_(), str);
        }
    }

    public final void a(View view) {
        if (this.a.getHostView() != null && view != null) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(view);
            }
            ((FrameLayout) this.a.getHostView()).addView(view, new LayoutParams(-1, -1));
        }
    }
}
