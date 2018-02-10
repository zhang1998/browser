package com.taobao.weex;

/* compiled from: ProGuard */
public final class v implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ ac d;

    public v(ac acVar, String str, String str2, String str3) {
        this.d = acVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final void run() {
        if (this.d.b != null && this.d.d != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(this.b);
            this.d.b.a(this.d, this.c, stringBuilder.toString());
        }
    }
}
