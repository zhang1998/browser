package com.taobao.weex.ui.view.listview.a;

import android.mini.support.v7.widget.bf;
import android.view.View;
import com.taobao.weex.ui.component.ab;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class c extends bf {
    public boolean l = true;
    public WeakReference<ab> m;
    private int n;

    public c(ab abVar, int i) {
        super(abVar.getHostView());
        this.n = i;
        this.m = new WeakReference(abVar);
    }

    public c(View view, int i) {
        super(view);
        this.n = i;
    }

    public final void b(boolean z) {
        if (this.m != null && this.m.get() != null) {
            ((ab) this.m.get()).setUsing(z);
        }
    }

    public final ab t() {
        return this.m != null ? (ab) this.m.get() : null;
    }
}
