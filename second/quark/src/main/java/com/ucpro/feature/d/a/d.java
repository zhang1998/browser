package com.ucpro.feature.d.a;

import java.io.File;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    d(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        File[] listFiles = new File(this.b).listFiles(new c(this));
        if (listFiles != null && listFiles.length > 0) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }
}
