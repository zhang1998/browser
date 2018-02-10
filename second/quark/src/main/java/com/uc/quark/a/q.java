package com.uc.quark.a;

import java.io.File;

/* compiled from: ProGuard */
final class q implements Runnable {
    final /* synthetic */ String a;

    q(String str) {
        this.a = str;
    }

    public final void run() {
        File file = new File(this.a);
        if (file.exists()) {
            file.delete();
        }
    }
}
