package com.uc.base.a.a.a.e;

import android.text.TextUtils;
import com.uc.base.a.a.a.c;
import com.uc.base.a.a.a.f.a;
import com.uc.base.a.a.a.h.b;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class i {
    public static String a = "service_ticket";
    public static String b = "uid";
    public static String c = "nickname";
    public static String d = "number";
    public String e;
    public String f;
    public String g;

    public static i a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i iVar = new i();
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
                    iVar.e = jSONObject.optString("service_ticket");
                    iVar.f = jSONObject.optString("uid");
                    iVar.g = jSONObject.optString("nickname");
                    return iVar;
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
        }
        return null;
    }

    public final void a() {
        a a = c.a();
        a.a(a, this.e);
        a.a(b, this.f);
        a.a(c, this.g);
        if (b.a == null) {
            b.a = new com.uc.base.a.a.a.h.a();
        }
        b.a.a = this.g;
        com.uc.base.a.a.a.h.a.a(b.a);
    }

    public static void b() {
        a a = c.a();
        a.d(a);
        a.d(b);
        a.d(c);
        a.d(d);
    }

    public static void b(String str) {
        c.a().a(d, str);
    }
}
