package com.ucpro.business.stat;

import com.ucpro.c.c;
import java.io.File;

/* compiled from: ProGuard */
public final class l implements Runnable {
    public final void run() {
        k.b().edit().putString("state", n.BG.toString()).apply();
        File file = new File(c.a(), "crash_flag");
        if (file.exists()) {
            file.delete();
        }
    }
}
