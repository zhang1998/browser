package com.ucpro.business.stat;

import android.text.TextUtils;
import com.f.a.c.e;
import com.uc.apollo.impl.SettingsConst;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class f {
    private static String a;
    private static boolean b = false;

    public static String b() {
        if (b) {
            return SettingsConst.FALSE;
        }
        CharSequence a = e.a(d.a());
        c.a(a);
        if (TextUtils.isEmpty(a)) {
            return SettingsConst.FALSE;
        }
        return a;
    }

    public static String c() {
        if (b) {
            return SettingsConst.FALSE;
        }
        if (TextUtils.isEmpty(a)) {
            CharSequence a = com.uc.encrypt.f.a(e.a(d.a()));
            a = a;
            c.a(a);
        }
        if (TextUtils.isEmpty(a)) {
            a = SettingsConst.FALSE;
        }
        return a;
    }

    public static void a() {
        e.a(d.a());
    }
}
