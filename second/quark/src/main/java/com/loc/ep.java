package com.loc;

import android.text.TextUtils;
import com.uc.aerie.loader.stable.AerieLoaderConfig;
import java.util.HashMap;
import java.util.Map;

@ad(a = "a")
/* compiled from: ProGuard */
public class ep {
    @ae(a = "a6", b = 2)
    int a;
    @ae(a = "a1", b = 6)
    private String b;
    @ae(a = "a2", b = 6)
    private String c;
    @ae(a = "a3", b = 6)
    private String d;
    @ae(a = "a4", b = 6)
    private String e;
    @ae(a = "a5", b = 6)
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String[] k;

    private ep() {
        this.a = 1;
        this.k = null;
    }

    private ep(eo eoVar) {
        int i = 1;
        this.a = 1;
        this.k = null;
        this.g = eoVar.a;
        this.i = eoVar.b;
        this.h = eoVar.c;
        if (!eoVar.d) {
            i = 0;
        }
        this.a = i;
        this.j = eoVar.e;
        this.k = eoVar.f;
        this.c = eq.b(this.g);
        this.b = eq.b(this.i);
        this.d = eq.b(this.h);
        this.e = eq.b(a(this.k));
        this.f = eq.b(this.j);
    }

    public static String a(String str) {
        Map hashMap = new HashMap();
        hashMap.put("a1", eq.b(str));
        return n.a(hashMap);
    }

    private static String a(String[] strArr) {
        String str = null;
        if (strArr != null) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                for (String append : strArr) {
                    stringBuilder.append(append).append(";");
                }
                str = stringBuilder.toString();
            } catch (Throwable th) {
            }
        }
        return str;
    }

    private static String[] b(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            return null;
        }
    }

    public static String e() {
        return "a6=1";
    }

    public final String a() {
        if (TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.b)) {
            this.i = eq.c(this.b);
        }
        return this.i;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.g) && !TextUtils.isEmpty(this.c)) {
            this.g = eq.c(this.c);
        }
        return this.g;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.f)) {
            this.j = eq.c(this.f);
        }
        if (TextUtils.isEmpty(this.j)) {
            this.j = AerieLoaderConfig.UPDATER_TYPE_STANDARD;
        }
        return this.j;
    }

    public final String[] d() {
        if ((this.k == null || this.k.length == 0) && !TextUtils.isEmpty(this.e)) {
            this.k = b(eq.c(this.e));
        }
        return (String[]) this.k.clone();
    }
}
