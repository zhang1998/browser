package com.taobao.weex.c.a;

import android.mini.support.v4.d.b;
import com.alibaba.fastjson.e;
import com.taobao.weex.ac;
import com.taobao.weex.c.b.k;
import com.taobao.weex.c.b.r;
import com.taobao.weex.c.d;
import com.taobao.weex.c.p;
import com.taobao.weex.c.q;
import com.taobao.weex.common.g;
import com.taobao.weex.ui.component.ab;
import java.util.Map;

/* compiled from: ProGuard */
public final class x implements d, p {
    private final String a;
    private final e b;
    private final boolean c;
    private r d;
    private r e;

    public x(String str, e eVar) {
        this(str, eVar, false);
    }

    public x(String str, e eVar, boolean z) {
        this.a = str;
        this.b = eVar;
        this.c = z;
    }

    public final void a(com.taobao.weex.c.e eVar) {
        if (this.b != null) {
            ac d = eVar.d();
            k c = eVar.c(this.a);
            if (c != null) {
                this.d = c.a_.k;
                this.e = c.a_.l;
                Map bVar = new b(2);
                bVar.put("transform", this.b.remove("transform"));
                bVar.put("transformOrigin", this.b.remove("transformOrigin"));
                eVar.a(this.a, bVar);
                if (!this.b.isEmpty()) {
                    c.a(this.b, this.c);
                    c.a(eVar.c());
                    eVar.a((p) this);
                }
                if (d != null) {
                    d.a("domModule", g.WX_SUCCESS);
                }
            } else if (d != null) {
                d.a("domModule", g.WX_ERR_DOM_UPDATESTYLE);
            }
        }
    }

    public final void a(q qVar) {
        ab a = qVar.a(this.a);
        if (a != null) {
            a.updateProperties(this.b);
            if (this.b.containsKey("padding") || this.b.containsKey("paddingTop") || this.b.containsKey("paddingLeft") || this.b.containsKey("paddingRight") || this.b.containsKey("paddingBottom") || this.b.containsKey("borderWidth")) {
                a.setPadding(this.d, this.e);
            }
        }
    }
}
