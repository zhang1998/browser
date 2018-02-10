package com.taobao.weex.ui.component.b;

import android.content.Context;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.listview.a.d;

/* compiled from: ProGuard */
final class i extends WXRecyclerView implements g {
    private d u = null;

    public i(Context context) {
        super(context);
    }

    public final WXRecyclerView getInnerView() {
        return this;
    }

    public final void setRecyclerViewBaseAdapter(d dVar) {
        setAdapter(dVar);
        this.u = dVar;
    }

    public final void a(m mVar) {
    }

    public final void b(m mVar) {
    }

    public final void a_(int i) {
    }

    public final d getRecyclerViewBaseAdapter() {
        return this.u;
    }
}
