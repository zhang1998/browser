package com.uc.sync.e;

import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.uc.apollo.impl.SettingsConst;
import com.uc.sync.d.a;
import com.uc.sync.f.g;
import com.uc.sync.f.h;
import com.uc.sync.f.i;
import com.uc.sync.f.o;
import com.ucweb.common.util.f;

/* compiled from: ProGuard */
public abstract class d implements i {
    private static final String m = d.class.getName();
    protected boolean a = true;
    protected volatile int b = 0;
    protected int c;
    protected long d;
    protected int e;
    protected int f = 1;
    protected int g;
    protected g h;
    String i = "";
    int j = 0;
    int k = 0;
    int l = 0;

    protected abstract void b(int i);

    protected abstract void c(int i);

    public d(int i) {
        this.e = i;
    }

    public final void a(g gVar) {
        this.h = gVar;
    }

    protected final int a() {
        return this.e;
    }

    protected final boolean b() {
        if (!h.a().b(this.e)) {
            return false;
        }
        Log.e(m, "Has dup Sync Type" + this.e);
        return true;
    }

    public final o a(int i) {
        o oVar = new o(this.e, i);
        oVar.k = 2048;
        oVar.e = 1;
        oVar.d = this.g;
        return oVar;
    }

    public final boolean c() {
        return this.b == 1;
    }

    protected final boolean d() {
        this.c++;
        if (this.c > 1) {
            b(SettingsConst.SINFO_VERSION);
            this.c = 0;
            return false;
        }
        this.b = 0;
        if (this.a) {
            a.a("发起重试...");
            c(this.f);
        }
        return true;
    }

    protected final void e() {
        String format = f.a("yyyy-MM-dd HH:mm").format(Long.valueOf(System.currentTimeMillis()));
        int i = this.e;
        com.uc.sync.c.a.h();
        Editor edit = com.uc.sync.c.a.o().edit();
        edit.putString("last_sync_time" + i, format);
        com.ucweb.common.util.j.a.a(edit);
    }
}
