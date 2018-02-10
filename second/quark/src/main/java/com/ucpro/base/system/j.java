package com.ucpro.base.system;

import java.io.File;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ String a;

    j(String str) {
        this.a = str;
    }

    public final void run() {
        File file = new File(this.a);
        if (file.exists()) {
            file.delete();
        }
    }
}
