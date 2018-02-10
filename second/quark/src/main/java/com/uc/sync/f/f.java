package com.uc.sync.f;

import com.uc.sync.b.a.a;
import com.uc.sync.b.a.b;
import java.io.UnsupportedEncodingException;

/* compiled from: ProGuard */
public final class f {
    private static int h = 123;
    final int a;
    final int b = b();
    String c = null;
    String d = null;
    public byte[] e = null;
    byte[] f = null;
    l g;

    public f(int i) {
        this.a = i;
    }

    private static synchronized int b() {
        int i;
        synchronized (f.class) {
            i = h;
            h = i + 1;
        }
        return i;
    }

    final a a() {
        a aVar = new a();
        aVar.b = this.a;
        aVar.a = this.b;
        if (this.e != null) {
            aVar.c = this.e;
        }
        if (!(this.c == null && this.d == null && this.f == null)) {
            b bVar = new b();
            if (this.c != null) {
                try {
                    bVar.b = this.c.getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                }
            }
            if (this.d != null) {
                try {
                    bVar.a = this.d.getBytes("UTF-8");
                } catch (UnsupportedEncodingException e2) {
                }
            }
            if (this.f != null) {
                bVar.c = this.f;
            }
            aVar.d = bVar;
        }
        return aVar;
    }
}
