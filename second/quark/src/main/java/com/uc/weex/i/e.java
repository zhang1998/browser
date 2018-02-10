package com.uc.weex.i;

import java.io.File;
import java.io.IOException;

/* compiled from: ProGuard */
public class e extends m {
    protected final File a;
    private final int b;
    private d c;

    final File a() {
        return this.a;
    }

    public e(File file, int i, d dVar) {
        this.a = file;
        this.b = i;
        this.c = dVar;
    }

    public final int a(String str, int i) throws IOException {
        int i2 = 0;
        File file = new File(this.a, str);
        if (!file.exists()) {
            return 0;
        }
        if ((i & 1) != 0 && (this.b & 2) != 0) {
            return 2;
        }
        if ((this.b & 1) != 0) {
            String[] a = j.a(file);
            while (i2 < a.length) {
                String str2 = a[i2];
                if (!(str2.startsWith("/") || str2.contains("webviewuc") || this.c == null)) {
                    this.c.a(str2, i | 1);
                }
                i2++;
            }
        }
        try {
            if (this.c != null) {
                this.c.a(file.getAbsolutePath());
            }
        } catch (UnsatisfiedLinkError e) {
            if (!(str.equals("libV8_UC.so") || str.equals("libwebviewuc.so") || str.equals("libv8uc.so") || str.equals("libv9uc.so"))) {
                throw e;
            }
        }
        return 1;
    }

    public final boolean a(String str) throws IOException {
        if (new File(this.a, str).exists()) {
            return true;
        }
        return false;
    }
}
