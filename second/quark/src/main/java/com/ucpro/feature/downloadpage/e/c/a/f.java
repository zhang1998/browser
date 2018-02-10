package com.ucpro.feature.downloadpage.e.c.a;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.ucpro.base.system.b;

/* compiled from: ProGuard */
public final class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ g b;

    public f(g gVar, String str) {
        this.b = gVar;
        this.a = str;
    }

    public final void run() {
        Drawable a = b.a.a(this.a);
        if (a != null) {
            g gVar = this.b;
            CharSequence charSequence = this.a;
            if (!TextUtils.isEmpty(charSequence)) {
                gVar.a.put(charSequence, a);
            }
        }
    }
}
