package com.uc.weex.component.j;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;

/* compiled from: ProGuard */
public final class a implements ValueCallback<View> {
    final /* synthetic */ c a;

    public a(c cVar) {
        this.a = cVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        View view = (View) obj;
        if (view != null && this.a.getHostView() != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            ((FrameLayout) this.a.getHostView()).addView(view, new LayoutParams(-1, -1));
        }
    }
}
