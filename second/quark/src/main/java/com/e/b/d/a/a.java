package com.e.b.d.a;

import com.alibaba.analytics.a.ab;
import com.alibaba.analytics.a.af;

/* compiled from: ProGuard */
public final class a implements c {
    public boolean a;
    public String b = null;
    public String c = null;

    public final String a() {
        return this.b;
    }

    public a(String str, String str2, boolean z) {
        this.b = str;
        this.c = str2;
        this.a = z;
    }

    public final String a(String str) {
        if (this.b == null || this.c == null) {
            af.d("UTBaseRequestAuthentication", "There is no appkey,please check it!");
            return null;
        } else if (str != null) {
            return ab.a(ab.c((str + this.c).getBytes()));
        } else {
            return null;
        }
    }
}
