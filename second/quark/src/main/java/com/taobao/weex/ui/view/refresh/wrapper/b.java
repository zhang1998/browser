package com.taobao.weex.ui.view.refresh.wrapper;

import android.content.Context;
import android.view.View;
import com.taobao.weex.common.w;
import com.taobao.weex.ui.component.be;
import com.taobao.weex.ui.view.WXScrollView;

/* compiled from: ProGuard */
public class b extends BaseBounceView<WXScrollView> {
    public /* synthetic */ View a(Context context) {
        return b(context);
    }

    public boolean postDelayed(Runnable runnable, long j) {
        return super.postDelayed(w.a(runnable), j);
    }

    public b(Context context, int i, be beVar) {
        super(context, i);
        a(context, true);
        if (getInnerView() != null) {
            ((WXScrollView) getInnerView()).setWAScroller(beVar);
        }
    }

    public WXScrollView b(Context context) {
        return new WXScrollView(context);
    }

    public final void c() {
    }

    public final void d() {
    }
}
