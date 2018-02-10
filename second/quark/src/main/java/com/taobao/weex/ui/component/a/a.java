package com.taobao.weex.ui.component.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: ProGuard */
public final class a implements OnGlobalLayoutListener {
    final /* synthetic */ View a;
    final /* synthetic */ c b;
    private final Rect c = new Rect();
    private final int d = WXViewUtils.f(100.0f);
    private boolean e = false;

    public a(View view, c cVar) {
        this.a = view;
        this.b = cVar;
    }

    public final void onGlobalLayout() {
        this.a.getWindowVisibleDisplayFrame(this.c);
        boolean z = this.a.getRootView().getHeight() - this.c.height() > this.d;
        if (z != this.e) {
            this.e = z;
            this.b.a(z);
        }
    }
}
