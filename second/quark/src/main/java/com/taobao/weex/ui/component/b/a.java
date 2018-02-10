package com.taobao.weex.ui.component.b;

import android.mini.support.v7.widget.RecyclerView;
import android.mini.support.v7.widget.av;
import android.view.View;
import com.taobao.weex.common.b;
import com.taobao.weex.common.e;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.view.listview.a.c;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
final class a extends av {
    final /* synthetic */ e a;

    a(e eVar) {
        this.a = eVar;
    }

    public final void a(RecyclerView recyclerView, int i) {
        super.a(recyclerView, i);
        if (i == 0) {
            Iterator it = this.a.i.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (!(cVar == null || cVar.t() == null || cVar.t().isUsing() || cVar.m == null || cVar.m.get() == null)) {
                    ((ab) cVar.m.get()).recycled();
                    cVar.l = true;
                }
            }
            this.a.i.clear();
        }
        List<e> n = this.a.getInstance().n();
        if (n != null && n.size() > 0) {
            for (e eVar : n) {
                if (eVar != null) {
                    View childAt = recyclerView.getChildAt(0);
                    if (childAt != null) {
                        childAt.getTop();
                    }
                }
            }
        }
    }

    public final void a(RecyclerView recyclerView, int i, int i2) {
        super.a(recyclerView, i, i2);
        List<e> n = this.a.getInstance().n();
        if (n != null && n.size() > 0) {
            for (e eVar : n) {
                if (eVar != null && (!(eVar instanceof b) || ((b) eVar).a(this.a.getRef()))) {
                    eVar.a((float) i, (float) i2);
                }
            }
        }
    }
}
