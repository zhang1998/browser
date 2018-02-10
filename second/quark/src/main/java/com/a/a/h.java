package com.a.a;

import android.app.Activity;
import android.content.Context;
import com.a.a.a.eo;
import com.a.a.a.fa;

/* compiled from: ProGuard */
final class h extends fa {
    final /* synthetic */ Context a;
    final /* synthetic */ e b;

    h(e eVar, Context context) {
        this.b = eVar;
        this.a = context;
    }

    public final void a() {
        if (this.a instanceof Activity) {
            this.b.d = new eo((Activity) this.a);
        }
    }
}
