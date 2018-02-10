package com.ucpro.base.system;

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
        try {
            File file = new File(this.a);
            File file2 = new File(this.b);
            if (file2.exists()) {
                file2.delete();
            }
            file.renameTo(file2);
            file.delete();
        } catch (NullPointerException e) {
        }
    }
}
