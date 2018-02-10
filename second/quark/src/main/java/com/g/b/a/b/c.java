package com.g.b.a.b;

import android.content.Context;
import android.os.Bundle;
import com.g.b.a.d.b;

/* compiled from: ProGuard */
public final class c {
    public Bundle a = null;
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";

    public c(Context context, String str, String str2) {
        this.b = str;
        this.c = str2;
        this.d = null;
        this.e = context.getPackageName();
        this.f = b.a(context, this.e);
        this.a = new Bundle();
        this.a.putString("appKey", this.b);
        this.a.putString("redirectUri", this.c);
        this.a.putString("scope", this.d);
        this.a.putString("packagename", this.e);
        this.a.putString("key_hash", this.f);
    }
}
