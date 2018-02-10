package com.ucpro.feature.y;

import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout.LayoutParams;
import com.ucpro.business.a.b.b.c;

/* compiled from: ProGuard */
final class s implements ValueCallback<View> {
    final /* synthetic */ g a;

    s(g gVar) {
        this.a = gVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        View view = (View) obj;
        if (view != null && (view instanceof c)) {
            if (this.a.d != null) {
                this.a.d.a(((c) view).getInsetBottom());
            }
            com.ucweb.common.util.c.b(this.a.c.getLogo() instanceof e);
            e eVar = (e) this.a.c.getLogo();
            eVar.b = view;
            eVar.addView(eVar.b, new LayoutParams(-1, -1));
            eVar.a.setVisibility(8);
        }
    }
}
