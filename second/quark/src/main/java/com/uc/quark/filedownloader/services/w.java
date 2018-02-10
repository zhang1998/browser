package com.uc.quark.filedownloader.services;

import com.uc.quark.ad;
import com.uc.quark.filedownloader.e.b;
import com.uc.quark.filedownloader.f;
import com.uc.quark.filedownloader.n;

/* compiled from: ProGuard */
public final class w implements f {
    final i a = ac.a;
    final ad b;
    final g c;

    public w() {
        u a = n.a.a();
        this.b = a.a();
        this.c = new g(b.j());
    }

    public final boolean a(String str, String str2) {
        boolean b;
        synchronized (this.c) {
            b = this.c.b(b.a(str, str2));
        }
        return b;
    }

    public final boolean a(com.uc.quark.filedownloader.model.b bVar) {
        boolean b;
        synchronized (this.c) {
            b = this.c.b(bVar.a);
        }
        return b;
    }

    public final byte[] a() {
        byte[] bArr;
        synchronized (this.c) {
            int[] b = this.c.b();
            bArr = new byte[b.length];
            for (int i = 0; i < b.length; i++) {
                bArr[i] = (byte) b[i];
            }
        }
        return bArr;
    }

    public final boolean b() {
        boolean a;
        synchronized (this.c) {
            a = this.c.a();
        }
        return a;
    }

    public final String a(int i) {
        String str;
        synchronized (this.c) {
            com.uc.quark.filedownloader.model.b a = this.a.a(i);
            if (a == null) {
                str = "";
            } else {
                str = a.b + "|" + a.e + "|" + a.c;
            }
        }
        return str;
    }

    public final boolean b(int i) {
        boolean z;
        synchronized (this.c) {
            com.uc.quark.filedownloader.model.b a = this.a.a(i);
            if (a == null) {
                z = true;
            } else {
                z = a.l;
            }
        }
        return z;
    }

    public final boolean c(int i) {
        boolean c;
        synchronized (this.c) {
            c = this.c.c(i);
        }
        return c;
    }

    public final boolean d(int i) {
        boolean z = false;
        synchronized (this.c) {
            if (i == 0) {
            } else if (this.c.b(i)) {
            } else {
                this.a.b(i);
                z = true;
            }
        }
        return z;
    }
}
