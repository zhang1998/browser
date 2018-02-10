package com.ucpro.business.e.e;

import android.content.SharedPreferences;
import com.uc.encrypt.f;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class b {
    SharedPreferences a;

    private b() {
        this.a = d.a().getSharedPreferences("us_model", 0);
    }

    public final String a() {
        return a("cp_param", "");
    }

    public static b b() {
        return c.a;
    }

    public final String a(String str, String str2) {
        String a = f.a(str);
        String a2 = f.a(str2);
        try {
            a2 = this.a.getString(a, a2);
        } catch (ClassCastException e) {
        }
        return f.b(a2);
    }

    public final String c() {
        return a("dn", "");
    }

    public final String d() {
        return a("sn", "");
    }
}
