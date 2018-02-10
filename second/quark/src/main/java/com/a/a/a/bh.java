package com.a.a.a;

import android.content.Context;
import java.io.File;

/* compiled from: ProGuard */
public final class bh extends as {
    Context d;
    String e = null;
    String f = null;

    public bh(Context context) {
        super("oldumid");
        this.d = context;
    }

    public final String b() {
        return this.e;
    }

    final void c() {
        try {
            a("/data/local/tmp/.um");
            fu.a(new File("/data/local/tmp/.um/sysid.dat"), this.f);
        } catch (Throwable th) {
        }
    }

    final void d() {
        try {
            a("/sdcard/Android/obj/.um");
            fu.a(new File("/sdcard/Android/obj/.um/sysid.dat"), this.f);
        } catch (Throwable th) {
        }
    }

    final void e() {
        try {
            a("/sdcard/Android/data/.um");
            fu.a(new File("/sdcard/Android/data/.um/sysid.dat"), this.f);
        } catch (Throwable th) {
        }
    }

    private static void a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
