package com.taobao.weex.c;

import com.taobao.weex.ui.c;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.d;
import com.taobao.weex.ui.m;

/* compiled from: ProGuard */
final class j implements c {
    final /* synthetic */ ae a;
    final /* synthetic */ k b;

    j(k kVar, ae aeVar) {
        this.b = kVar;
        this.a = aeVar;
    }

    public final void a() {
        ab abVar;
        m mVar = this.b.a.d;
        String str = this.b.a.c;
        String str2 = this.a.q;
        o oVar = this.a;
        d dVar = (d) mVar.a.get(str);
        if (dVar != null) {
            abVar = (ab) dVar.a.get(str2);
            if (abVar != null) {
                abVar.setLayout(oVar);
            }
        }
        if (this.a.q() != null) {
            mVar = this.b.a.d;
            str = this.b.a.c;
            str2 = this.a.q;
            Object q = this.a.q();
            dVar = (d) mVar.a.get(str);
            if (dVar != null) {
                abVar = (ab) dVar.a.get(str2);
                if (abVar != null) {
                    abVar.updateExtra(q);
                }
            }
        }
    }

    public final String toString() {
        return "setLayout & setExtra";
    }
}
