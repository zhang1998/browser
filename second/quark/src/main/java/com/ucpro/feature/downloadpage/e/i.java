package com.ucpro.feature.downloadpage.e;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ aa e;

    i(aa aaVar, String str, String str2, String str3, String str4) {
        this.e = aaVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public final void run() {
        if (this.e.a != null) {
            this.e.a.onReceiveValue(new String[]{this.a, this.b, this.c, this.d});
        }
    }
}
