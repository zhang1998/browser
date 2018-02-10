package com.uc.a.f;

import android.text.TextUtils;
import android.util.Log;
import com.uc.a.e;
import com.uc.a.g;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class a {
    public c a;
    public d b;
    public j c;
    ArrayList<e> d;

    private a() {
        this.d = new ArrayList();
        RuntimeException runtimeException = new RuntimeException("DispatcherService construction");
    }

    private a(c cVar) {
        this.d = new ArrayList();
        this.a = cVar;
        this.c = new j(cVar.a, cVar.j);
        this.b = new d(cVar.g);
        this.b.a(e.b, new i(this));
        g.a.a("MainDispAddr", this.a.c);
        g.a.a("SubDispAddr1", this.a.d);
        this.b.c = new k(this.a.b);
    }

    public final void a(e eVar) {
        if (eVar != null && this.d.indexOf(eVar) < 0) {
            this.d.add(eVar);
        }
    }

    public final String a() {
        String a = a("us_srv_url_https");
        if (TextUtils.isEmpty(a)) {
            return a("us_srv_url");
        }
        return a;
    }

    public final int b() {
        int i = 0;
        try {
            i = Integer.parseInt(a("cd_recycle"));
        } catch (NumberFormatException e) {
            Log.e("dispatcher", "[dispatcher] can't parse us period as number");
        }
        return i;
    }

    public final String a(String str) {
        return this.c.a(str);
    }

    public final String a(String str, String str2) {
        String a = this.c.a(str);
        return a == null ? str2 : a;
    }
}
