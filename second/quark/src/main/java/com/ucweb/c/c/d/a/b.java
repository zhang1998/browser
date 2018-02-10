package com.ucweb.c.c.d.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.g.b.a.a.e;
import com.g.b.a.b.a;
import com.g.b.a.b.a.c;
import com.g.b.a.b.d;

/* compiled from: ProGuard */
public final class b implements a, com.g.b.a.b.a.b {
    a a;
    public e b;
    private c c;
    private d d;
    private boolean e;

    public b(Context context) {
        this.b = com.g.b.a.a.a.a(context, com.ucweb.c.a.b.WEIBO.i);
        this.d = new d(context, com.ucweb.c.a.b.WEIBO.i, "http://www.uc.cn/");
        try {
            this.c = new c((Activity) context, this.d);
        } catch (Exception e) {
            c();
        }
    }

    public final void b() {
        if (this.c != null) {
            this.c.a(this);
        }
    }

    private void c() {
        if (this.a != null && !this.e) {
            d();
        }
    }

    private static c d() {
        c cVar = new c();
        cVar.c = c.b;
        cVar.d = 0;
        cVar.e = new Bundle();
        return cVar;
    }

    public final void a() {
        c cVar = new c();
        cVar.c = c.a;
        cVar.d = 0;
    }

    public final void a(Bundle bundle) {
        if (bundle == null) {
            c();
            return;
        }
        com.g.b.a.b.b a = com.g.b.a.b.b.a(bundle);
        if (a == null || !a.a()) {
            c();
            return;
        }
        c cVar = new c();
        cVar.d = 0;
        cVar.e = bundle;
        if (this.a != null) {
            cVar.e.putString("stats", "sdk_sina");
        }
    }

    public final void a(com.g.b.a.c.a aVar) {
        Log.e("vanda", "paramWeiboException=" + aVar);
        c();
    }

    public final void a(String str) {
        if (str != null && str.length() != 0) {
            b();
        } else if (this.a != null) {
            d().e.putString("stats", "sdk_sinaclient_yes_logout");
        }
    }
}
