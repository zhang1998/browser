package com.ucpro.feature.f;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.ucpro.business.stat.m;

/* compiled from: ProGuard */
public final class d {
    public static void a(@NonNull boolean z, @Nullable String str, @Nullable String str2) {
        String str3 = "account";
        String str4 = "get_profile_async";
        String[] strArr = new String[4];
        strArr[0] = "server_result";
        strArr[1] = String.valueOf(z);
        strArr[2] = z ? "server_changed" : "error_msg";
        if (!z) {
            str = str2;
        }
        strArr[3] = str;
        m.a(str3, str4, strArr);
    }

    public static void a() {
        m.a("account", "show_captcha_dialog", new String[0]);
    }

    public static void a(@NonNull String str) {
        m.a("account", "refresh_captch", "result_status", str, "error_msg", "");
    }

    public static void b() {
        m.a("account", "submit_captcha", new String[0]);
    }

    public static void a(String str, String str2, String str3) {
        String str4 = "account";
        String str5 = "refresh_captch";
        String[] strArr = new String[6];
        strArr[0] = "server_result";
        strArr[1] = str2;
        strArr[2] = "enter_type";
        strArr[3] = str;
        strArr[4] = "error_msg";
        if (str3 == null) {
            str3 = "";
        }
        strArr[5] = str3;
        m.a(str4, str5, strArr);
    }
}
