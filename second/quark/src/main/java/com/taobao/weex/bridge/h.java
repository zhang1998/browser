package com.taobao.weex.bridge;

/* compiled from: ProGuard */
public final class h implements c {
    String a;
    String b;

    public h(String str, String str2) {
        this.b = str2;
        this.a = str;
    }

    public final void a(Object obj) {
        s.a().b(this.a, this.b, obj, false);
    }

    public final void b(Object obj) {
        s.a().b(this.a, this.b, obj, true);
    }
}
