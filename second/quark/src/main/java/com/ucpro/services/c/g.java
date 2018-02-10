package com.ucpro.services.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.uc.util.b;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ e d;

    g(e eVar, Context context, String str, String str2) {
        this.d = eVar;
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    public final void run() {
        Bitmap a = b.a(this.a.getResources(), this.b);
        if (a != null) {
            e eVar = this.d;
            Object obj = this.c;
            if (!TextUtils.isEmpty(obj)) {
                String b = e.b(obj);
                if (!a.a(b)) {
                    eVar.a.put(b, a);
                }
            }
        }
    }
}
