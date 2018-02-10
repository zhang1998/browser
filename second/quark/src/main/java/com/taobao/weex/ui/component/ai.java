package com.taobao.weex.ui.component;

import android.view.View;
import android.widget.FrameLayout;
import com.taobao.weex.ac;
import com.taobao.weex.e;

/* compiled from: ProGuard */
final class ai implements e {
    aj a;
    n b = new ag();

    ai(aj ajVar) {
        this.a = ajVar;
    }

    public final void a(ac acVar, View view) {
        FrameLayout frameLayout = (FrameLayout) this.a.getHostView();
        frameLayout.removeAllViews();
        frameLayout.addView(view);
    }

    public final void a(ac acVar) {
    }

    public final void a(ac acVar, String str, String str2) {
        if (this.b != null) {
            this.b.a(this.a, str, str2);
        }
    }
}
