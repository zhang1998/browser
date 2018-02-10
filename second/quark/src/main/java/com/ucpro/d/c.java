package com.ucpro.d;

import android.app.Activity;
import com.uc.encrypt.f;
import com.ucpro.b.d.a.b;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class c implements Runnable {
    final /* synthetic */ Activity a;

    public c(Activity activity) {
        this.a = activity;
    }

    public final void run() {
        b a = b.a();
        a.a.edit().putString("orin_ver", a.e).putString("orin_sver", a.f).putString("orin_bseq", a.g).putString("last_ver", a.h).putString("last_sver", a.i).putString("last_bseq", a.j).putString("ver", a.b).putString("sver", a.c).putString("bseq", a.d).apply();
        e.a("oif1");
        f.a(d.a(), false, (byte) 1);
        e.a("oif2");
    }
}
