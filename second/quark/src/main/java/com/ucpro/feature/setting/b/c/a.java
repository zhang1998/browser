package com.ucpro.feature.setting.b.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.ucpro.c.b;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class a {
    private SharedPreferences a;

    private a() {
        this.a = d.a().getSharedPreferences("__df", 0);
    }

    public final boolean a() {
        return b("76C1F34B9171FBB7", b.b());
    }

    public final boolean b() {
        return b("D76AB98A1A2A898B", b.b());
    }

    public final boolean c() {
        return b("1DC0BFC82DD28F77", b.b());
    }

    public final void a(String str, boolean z) {
        if (!"".equals(str)) {
            Editor edit = this.a.edit();
            edit.putBoolean(str, z);
            edit.apply();
        }
    }

    private boolean b(String str, boolean z) {
        return "".equals(str) ? z : this.a.getBoolean(str, z);
    }
}
