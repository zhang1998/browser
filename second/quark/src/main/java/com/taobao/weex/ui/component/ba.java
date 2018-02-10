package com.taobao.weex.ui.component;

import com.taobao.weex.common.b;
import com.taobao.weex.common.e;
import com.taobao.weex.ui.view.WXScrollView;
import com.taobao.weex.ui.view.q;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
final class ba implements q {
    final /* synthetic */ be a;

    ba(be beVar) {
        this.a = beVar;
    }

    public final void a(WXScrollView wXScrollView, int i, int i2, int i3, int i4) {
    }

    public final void b(WXScrollView wXScrollView, int i, int i2) {
        List n = this.a.getInstance().n();
        if (n != null && n.size() > 0) {
            Iterator it = n.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void a(WXScrollView wXScrollView, int i, int i2) {
        List<e> n = this.a.getInstance().n();
        if (n != null && n.size() > 0) {
            for (e eVar : n) {
                if (eVar != null && (!(eVar instanceof b) || ((b) eVar).a(this.a.getRef()))) {
                    eVar.a((float) i, (float) i2);
                }
            }
        }
    }

    public final void a(boolean z) {
    }

    public final void a(int i, int i2, int i3, int i4) {
    }
}
