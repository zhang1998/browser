package com.uc.weex.component.c;

import android.content.Context;
import com.taobao.weex.common.b;
import com.taobao.weex.common.e;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.uc.weex.component.c.a.d;
import com.uc.weex.component.g;
import java.util.List;

/* compiled from: ProGuard */
public final class f extends WXRecyclerView implements g {
    d u = null;
    private float v;

    public f(Context context) {
        super(context, null, 16842880);
    }

    final void setMaxOverScrollDistance(float f) {
        if (this.u != null) {
            this.u.a(f);
        }
    }

    public final float getScrollOffsetY() {
        return this.v;
    }

    public final void setOffset(float f) {
        this.v = f;
    }

    static /* synthetic */ void a(b bVar, float f, float f2) {
        List<e> n = bVar.getInstance().n();
        if (n != null && n.size() > 0) {
            for (e eVar : n) {
                if (eVar != null && (!(eVar instanceof b) || ((b) eVar).a(bVar.getRef()))) {
                    eVar.a(f, f2);
                }
            }
        }
    }
}
