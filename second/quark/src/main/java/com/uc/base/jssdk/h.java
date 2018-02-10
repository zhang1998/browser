package com.uc.base.jssdk;

import android.text.TextUtils;
import com.uc.base.jssdk.a.f;

/* compiled from: ProGuard */
public final class h {
    m a;
    ShellJsInterface b;
    int c = -1;
    g d;
    private a e;
    private n f;

    h(m mVar, g gVar, a aVar, int i) {
        this.a = mVar;
        this.b = new ShellJsInterface(this);
        this.d = gVar;
        this.c = i;
        this.e = aVar;
        this.f = new n(this.a);
    }

    public final String a(String str, String str2, String str3, String str4) {
        return this.d.a(str, str2, str3, str4, this.c, TextUtils.isEmpty(this.a.getCallerUrl()) ? "" : this.a.getCallerUrl(), this.f);
    }

    public final String a(String str, String str2, String[] strArr) {
        g gVar = this.d;
        int i = this.c;
        n nVar = this.f;
        if (!"shell.jsdk.bridge".equals(str)) {
            f b = gVar.a.b(str);
            if (b != null && b.b()) {
                return b.a();
            }
        } else if (strArr.length == 4) {
            return gVar.a(strArr[0], strArr[1], strArr[2], strArr[3], i, str2, nVar);
        }
        return "";
    }
}
