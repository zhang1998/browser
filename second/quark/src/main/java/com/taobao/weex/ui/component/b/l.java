package com.taobao.weex.ui.component.b;

import android.view.View;
import android.view.ViewGroup;
import com.taobao.weex.common.w;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class l {
    public final ViewGroup a;
    public Map<String, View> b = new HashMap();
    public Map<String, m> c = new HashMap();
    public String d = null;

    public l(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public final void a(m mVar) {
        if (mVar != null) {
            m mVar2 = (m) this.c.remove(mVar.getRef());
            View view = (View) this.b.remove(mVar.getRef());
            if (mVar2 == null || view == null) {
                WXLogUtils.e(" sticky header to remove not found." + mVar.getRef());
                return;
            }
            if (this.d != null && this.d.equals(mVar.getRef())) {
                this.d = null;
            }
            this.a.post(w.a(new k(this, view, mVar2)));
        }
    }
}
