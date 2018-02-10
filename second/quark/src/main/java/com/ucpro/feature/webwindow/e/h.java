package com.ucpro.feature.webwindow.e;

import android.webkit.ValueCallback;
import com.uc.quark.n;
import com.uc.quark.x;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.l.d;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ValueCallback b;
    final /* synthetic */ String c;

    h(String str, ValueCallback valueCallback, String str2) {
        this.a = str;
        this.b = valueCallback;
        this.c = str2;
    }

    public final void run() {
        String a;
        String a2 = d.a(this.a, "", "");
        String d = d.d(d.a(this.a, "", ""));
        if (this.a.indexOf("http") == 0) {
            a = k.a(this.a);
        } else {
            a = "";
        }
        if (a.b(a)) {
            d = d.b(a);
        }
        if (!a.d(d, "bin")) {
            if (a.b(a2)) {
                if (a2.contains(".")) {
                    a2 = a2.substring(0, a2.lastIndexOf("."));
                }
                a2 = a2 + "." + d;
            }
            if (!a.b(a)) {
                a = d.a(d);
            }
            n nVar = new n();
            nVar.a = this.a;
            nVar.d = a2;
            if (a.b(this.c)) {
                d = this.c;
            } else {
                d = this.a;
            }
            nVar.b = d;
            if (a.a(a)) {
                a = "";
            }
            nVar.c = a;
            x.a().a(nVar.a()).a(new w(this)).k();
        } else if (this.b != null) {
            m.a(2, new b(this));
        }
    }
}
