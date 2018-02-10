package com.uc.quark;

import java.io.File;

/* compiled from: ProGuard */
public final class a implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ x c;

    public a(x xVar, String str, int i) {
        this.c = xVar;
        this.a = str;
        this.b = i;
    }

    public final void run() {
        File file = new File(this.a);
        if (file.exists()) {
            long length = file.length();
            com.uc.quark.filedownloader.contentprovider.a.a(this.b, length, length, this.a);
            i.a.a();
        }
    }
}
