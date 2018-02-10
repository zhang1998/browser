package com.ucpro.feature.g.c;

import com.ucpro.business.stat.m;
import com.ucpro.feature.g.c.b.b;

/* compiled from: ProGuard */
public final class e {
    public static void a(b bVar) {
        m.a("login", "start_login", "login_type", bVar.name());
    }

    public static void b(b bVar) {
        m.a("login", "sdk_login_success", "login_type", bVar.name());
    }

    public static void a(b bVar, String str, String str2) {
        String str3 = "login";
        String str4 = "sdk_login_error";
        String[] strArr = new String[6];
        strArr[0] = "login_type";
        strArr[1] = bVar.name();
        strArr[2] = "error_type";
        strArr[3] = str;
        strArr[4] = "error_msg";
        if (str2 == null) {
            str2 = "";
        }
        strArr[5] = str2;
        m.a(str3, str4, strArr);
    }
}
