package com.taobao.weex.c.a;

import android.text.TextUtils;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.ai;
import com.taobao.weex.c.d;
import com.taobao.weex.c.p;
import com.taobao.weex.c.q;
import com.taobao.weex.common.g;
import com.taobao.weex.ui.component.ab;

/* compiled from: ProGuard */
public final class e implements d, p {
    private final String a;
    private final String b;
    private ae c;

    public e(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final void a(com.taobao.weex.c.e eVar) {
        ac d = eVar.d();
        ae c = eVar.c(this.a);
        if (c != null) {
            CharSequence charSequence = this.b;
            if (!TextUtils.isEmpty(charSequence)) {
                boolean z;
                if (c.u == null) {
                    c.u = new ai();
                }
                if (c.u == null) {
                    z = false;
                } else {
                    z = c.u.contains(charSequence);
                }
                if (!z) {
                    c.u.add(charSequence);
                }
            }
            this.c = c;
            eVar.a((p) this);
            if (d != null) {
                d.a("domModule", g.WX_SUCCESS);
            }
        } else if (d != null) {
            d.a("domModule", g.WX_ERR_DOM_ADDEVENT);
        }
    }

    public final void a(q qVar) {
        ab a = qVar.a(this.a);
        if (a != null) {
            a.updateDom(this.c);
            a.addEvent(this.b);
        }
    }
}
