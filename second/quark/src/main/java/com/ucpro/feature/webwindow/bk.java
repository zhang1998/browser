package com.ucpro.feature.webwindow;

import android.content.Context;
import android.text.TextUtils;
import com.quark.browser.R;
import com.ucpro.business.stat.m;
import com.ucpro.feature.w.b;
import com.ucpro.feature.webwindow.a.c;
import com.ucpro.feature.webwindow.a.g;
import com.ucpro.feature.webwindow.a.k;
import com.ucpro.services.a.a;

/* compiled from: ProGuard */
final class bk implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ bb b;

    bk(bb bbVar, String str) {
        this.b = bbVar;
        this.a = str;
    }

    public final void run() {
        g b = this.b.getGuideManager();
        Context context = this.b.getContext();
        bb bbVar = this.b;
        Object obj = this.a;
        if (!b.f) {
            boolean z;
            if (TextUtils.isEmpty(obj) || !obj.contains(".uc.cn")) {
                z = false;
            } else {
                z = true;
            }
            if (!z && bbVar.H()) {
                if (a.a.b("F2C1B9D490D098C810590705D2149EAA") && b.a()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    b.f = true;
                    if (b.c) {
                        z = b.b;
                    } else {
                        b.c = true;
                        b.b = com.ucweb.common.util.j.a.b("1BFFE8AD1E20ED68", false);
                        z = b.b;
                    }
                    if (!z) {
                        if (b.e) {
                            z = b.d;
                        } else {
                            b.e = true;
                            b.d = com.ucweb.common.util.j.a.b(context, "ECC3CF22A48D384F", "10DC82865F71921C", false);
                            z = b.d;
                        }
                        if (z) {
                            m.a("guide", "never_slide_to_home_after_guide", new String[0]);
                        } else if (bbVar.H() && bbVar.getAddressBar() != null && !com.ucpro.model.a.a.a.a("setting_night_mode", false)) {
                            com.ucweb.common.util.j.a.a(context, "ECC3CF22A48D384F", "10DC82865F71921C", true);
                            b.d = true;
                            b.a = new c(context, com.ucpro.ui.c.a.c((int) R.dimen.search_bar_max_height));
                            b.a.setListener(new k(b, bbVar));
                            bbVar.b(b.a);
                            bbVar.getAddressBar().setUrlTextVisibility(4);
                            m.a("guide", "has_show_slide_to_home_guide", new String[0]);
                        }
                    }
                }
            }
        }
    }
}
