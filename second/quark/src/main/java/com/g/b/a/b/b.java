package com.g.b.a.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.uc.apollo.impl.SettingsConst;

/* compiled from: ProGuard */
public final class b {
    public String a = "";
    private String b = "";
    private String c = "";
    private long d = 0;

    public static b a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        b bVar = new b();
        bVar.b = a(bundle, "uid", "");
        bVar.a = a(bundle, "access_token", "");
        String a = a(bundle, "expires_in", "");
        if (!(TextUtils.isEmpty(a) || a.equals(SettingsConst.FALSE))) {
            bVar.d = System.currentTimeMillis() + (Long.parseLong(a) * 1000);
        }
        bVar.c = a(bundle, "refresh_token", "");
        return bVar;
    }

    public final boolean a() {
        return (TextUtils.isEmpty(this.a) || this.d == 0 || System.currentTimeMillis() >= this.d) ? false : true;
    }

    public final String toString() {
        return "uid: " + this.b + ", access_token: " + this.a + ", refresh_token: " + this.c + ", expires_in: " + Long.toString(this.d);
    }

    private static String a(Bundle bundle, String str, String str2) {
        if (bundle == null) {
            return str2;
        }
        String string = bundle.getString(str);
        if (string != null) {
            return string;
        }
        return str2;
    }
}
