package com.ucpro.feature.webwindow.n;

import android.view.View;
import android.widget.RelativeLayout;
import com.ucpro.base.c.b.g;

/* compiled from: ProGuard */
public final class e implements d {
    public final g a;
    public final RelativeLayout b = new RelativeLayout(this.a.getContext());
    public b c;

    public e(g gVar) {
        this.a = gVar;
        this.a.b(this.b);
    }

    public final void a(View view) {
        if (view != null) {
            this.b.removeView(view);
        }
    }
}
