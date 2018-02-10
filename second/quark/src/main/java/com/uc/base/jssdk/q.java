package com.uc.base.jssdk;

import org.json.JSONObject;

/* compiled from: ProGuard */
public final class q {
    int a;
    String b;
    String c;
    String d;
    int e;

    public q(int i, String str, String str2, String str3, int i2) {
        this.a = i;
        this.b = str;
        this.d = str3;
        this.e = i2;
        this.c = str2;
    }

    public q(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public q(int i, JSONObject jSONObject) {
        this.a = i;
        this.b = jSONObject.toString();
    }
}
