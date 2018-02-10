package android.support.v7.widget;

import android.support.v4.view.cy;
import android.view.View;

/* compiled from: ProGuard */
final class ee extends cy {
    final /* synthetic */ int a;
    final /* synthetic */ cx b;
    private boolean c = false;

    ee(cx cxVar, int i) {
        this.b = cxVar;
        this.a = i;
    }

    public final void a(View view) {
        this.b.a.setVisibility(0);
    }

    public final void b(View view) {
        if (!this.c) {
            this.b.a.setVisibility(this.a);
        }
    }

    public final void c(View view) {
        this.c = true;
    }
}
