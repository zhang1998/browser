package com.ucpro.base.weex;

import android.text.TextUtils;
import com.UCMobile.Apollo.Global;
import com.taobao.weex.bridge.c;
import com.ucpro.base.weex.b.a;
import com.ucpro.c.b;
import com.ucpro.feature.lightapp.b.d;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;
    final /* synthetic */ String c;
    final /* synthetic */ c d;

    j(c cVar, String str, c cVar2, String str2) {
        this.d = cVar;
        this.a = str;
        this.b = cVar2;
        this.c = str2;
    }

    public final void run() {
        int i = 1;
        if (TextUtils.isEmpty(this.a)) {
            c.a(this.b, d.a("error_msg", "method is empty"), false);
        }
        String str = this.a;
        String str2 = this.c;
        if ("weex.stat".equals(str)) {
            b.b();
            com.ucpro.base.weex.b.b bVar = new com.ucpro.base.weex.b.b(str2);
            a.a(bVar.a, bVar.b, bVar.c);
        } else {
            i = 0;
        }
        if (i == 0) {
            c cVar = this.d;
            int i2 = cVar.c + 1;
            cVar.c = i2;
            String valueOf = String.valueOf(i2);
            this.d.a.putIfAbsent(valueOf, this.b);
            this.d.b.a(this.a, this.c, valueOf, Global.APOLLO_SERIES);
        }
    }
}
