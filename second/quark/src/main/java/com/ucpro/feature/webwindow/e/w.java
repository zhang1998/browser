package com.ucpro.feature.webwindow.e;

import android.text.TextUtils;
import com.uc.quark.h;
import com.uc.quark.s;
import com.ucpro.base.system.b;
import com.ucpro.business.stat.m;
import com.ucweb.common.util.d;
import java.util.HashMap;

/* compiled from: ProGuard */
final class w implements h {
    final /* synthetic */ h a;

    w(h hVar) {
        this.a = hVar;
    }

    public final void a(s sVar, int i, long j, long j2) {
        if (i == -1 || i == -3) {
            CharSequence g = sVar.g();
            if (!TextUtils.isEmpty(g)) {
                HashMap hashMap = new HashMap();
                hashMap.put("pic_url", g);
                hashMap.put("save_pic_status", String.valueOf(i));
                m.a("webview", "webview_save_pic", hashMap);
            }
            if (i == -3) {
                String h = sVar.h();
                b.a.b(d.a(), h);
                if (this.a.b != null) {
                    this.a.b.onReceiveValue(k.a(true, this.a.a, h));
                }
            }
        }
    }
}
