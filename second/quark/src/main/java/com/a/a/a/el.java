package com.a.a.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* compiled from: ProGuard */
final class el implements ez {
    final /* synthetic */ et a;

    el(et etVar) {
        this.a = etVar;
    }

    public final boolean a(File file) {
        Throwable th;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] b = fu.b(fileInputStream);
                try {
                    fu.c(fileInputStream);
                    byte[] a = this.a.b.a(b);
                    int i;
                    if (a == null) {
                        i = 1;
                    } else {
                        i = this.a.a(a);
                    }
                    if (!this.a.e && r2 == 1) {
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                fu.c(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            fu.c(fileInputStream);
            throw th;
        }
    }

    public final void a() {
        this.a.a.b();
    }
}
