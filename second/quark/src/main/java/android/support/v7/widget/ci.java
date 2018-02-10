package android.support.v7.widget;

import android.support.v7.view.menu.h;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
final class ci implements OnClickListener {
    final h a = new h(this.b.a.getContext(), this.b.b);
    final /* synthetic */ cx b;

    ci(cx cxVar) {
        this.b = cxVar;
    }

    public final void onClick(View view) {
        if (this.b.c != null && this.b.d) {
            this.b.c.onMenuItemSelected(0, this.a);
        }
    }
}
