package com.uc.a.c;

import android.text.TextUtils;
import android.util.Log;
import com.uc.a.o;
import com.uc.base.b.b.b;

/* compiled from: ProGuard */
public final class a extends b {
    private String c;
    private o d;

    public a(String str, com.uc.base.b.c.a.a aVar, o oVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("appDataDir can't be empty");
        } else if (aVar == null) {
            throw new IllegalArgumentException("encrypt factory can't be null");
        } else {
            this.c = str;
            this.d = oVar;
            a(aVar);
            b.b = 1;
        }
    }

    public final void a(Throwable th) {
        Log.w("US", "exception:", th);
    }

    public final void a(String str) {
        if (this.d != null) {
            this.d.a(str);
            return;
        }
        throw new RuntimeException(str);
    }

    public final void a(String str, byte[] bArr) {
        if (this.d == null) {
            throw new RuntimeException(str);
        } else if (bArr != null) {
            this.d.a(str + ", data size is:" + bArr.length);
        } else {
            this.d.a(str + ", data size is: 0");
        }
    }

    public final String a() {
        return "zh-cn";
    }

    public final String b() {
        return this.c;
    }
}
