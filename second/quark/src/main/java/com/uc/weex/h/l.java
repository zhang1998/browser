package com.uc.weex.h;

import android.text.TextUtils;
import com.uc.weex.a.a;
import com.uc.weex.e.b;
import com.uc.weex.e.d;
import com.uc.weex.e.e;
import com.uc.weex.h;

/* compiled from: ProGuard */
public final class l extends e<Object> {
    private String d;
    private e e = b.c().b;
    private e<o> f;
    private e<a> g;

    public l(e<o> eVar, String str, e<a> eVar2) {
        this.d = str;
        this.f = eVar;
        this.g = eVar2;
        a(this.e, this.f, this.g);
    }

    protected final void h_() {
        e eVar = this.e;
        int i = eVar.b == null ? d.a : eVar.b.booleanValue() ? d.b : d.c;
        o oVar = (o) this.f.c;
        a aVar = (a) this.g.c;
        if (d.c == i) {
            oVar.a(h.WEEX_ERR_ENGINE_INIT_FAILED.g, h.WEEX_ERR_ENGINE_INIT_FAILED.h);
            super.a(null);
            return;
        }
        String str;
        if (oVar instanceof a) {
            ((a) oVar).a(aVar.a);
            CharSequence charSequence = aVar.b;
            if (TextUtils.isEmpty(charSequence)) {
                h hVar;
                switch (com.uc.weex.b.a.a[aVar.c - 1]) {
                    case 1:
                    case 2:
                        hVar = h.WEEX_ERR_BUNDLE_FROM_LOCAL_URL_EMPTY;
                        break;
                    case 3:
                        hVar = h.WEEX_ERR_BUNDLE_FROM_BUNDLE_NAME_EMPTY;
                        break;
                    case 4:
                        hVar = h.WEEX_ERR_BUNDLE_FROM_REMOTE_URL_EMPTY;
                        break;
                    default:
                        hVar = h.WEEX_RRR_BUNDLE_FROM_UNKNOW_EMPTY;
                        break;
                }
                oVar.a(hVar.g, hVar.h);
                super.a(null);
                return;
            }
            CharSequence charSequence2 = charSequence;
        } else {
            str = this.d;
        }
        oVar.a(str);
        a(null);
    }
}
