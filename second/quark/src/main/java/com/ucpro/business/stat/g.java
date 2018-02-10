package com.ucpro.business.stat;

import android.content.Context;
import android.text.TextUtils;
import com.a.a.a;
import com.a.a.a.fw;
import com.a.a.b;
import com.a.a.c;
import com.a.a.d;
import com.a.a.e;

/* compiled from: ProGuard */
public final class g implements Runnable {
    final /* synthetic */ String a;

    public g(String str) {
        this.a = str;
    }

    public final void run() {
        d dVar = new d(com.ucweb.common.util.d.a(), "57e0fcc8e0f55abfa80034e4", this.a);
        e a = c.a;
        if (dVar.e != null) {
            a.a = dVar.e.getApplicationContext();
        }
        if (TextUtils.isEmpty(dVar.a)) {
            fw.d("the appkey is null!");
        } else {
            b.a(dVar.e, dVar.a);
            if (!TextUtils.isEmpty(dVar.b)) {
                b.a(dVar.b);
            }
            b.f = dVar.c;
            Context context = a.a;
            a aVar = dVar.d;
            if (context != null) {
                a.a = context.getApplicationContext();
            }
            if (aVar != null) {
                b.a(a.a, aVar.e);
            }
        }
        boolean b = com.ucpro.c.b.b();
        c.a;
        fw.a = b;
    }
}
