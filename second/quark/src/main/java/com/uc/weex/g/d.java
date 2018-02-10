package com.uc.weex.g;

import com.taobao.weex.bridge.h;
import com.taobao.weex.c.e;
import com.taobao.weex.c.p;
import com.taobao.weex.c.q;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.refresh.wrapper.a;
import com.uc.weex.component.c.b;

/* compiled from: ProGuard */
final class d implements com.taobao.weex.c.d, p {
    final /* synthetic */ e a;
    private final b b;
    private final String c;

    public d(e eVar, b bVar, String str) {
        this.a = eVar;
        this.b = bVar;
        this.c = str;
    }

    public final void a(e eVar) {
        eVar.a((p) this);
    }

    public final void a(q qVar) {
        b bVar = this.b;
        if (bVar.getHostView() != null) {
            ((WXRecyclerView) ((a) bVar.getHostView()).getInnerView()).a(bVar.g.size() - 1);
        }
        new h(this.a.b.e, this.c).a("{}");
    }
}
