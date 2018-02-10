package com.uc.encrypt.a;

import com.alibaba.wireless.security.open.SecException;
import com.uc.encrypt.a.a.a;

/* compiled from: ProGuard */
public final class b {
    private a a;
    private f b;
    private int c;

    private b() {
    }

    public final synchronized a a() throws SecException {
        if (this.a == null) {
            switch (d.a[c() - 1]) {
                case 1:
                    this.a = new com.uc.encrypt.a.a.b();
                    break;
            }
        }
        return this.a;
    }

    public final synchronized f b() {
        if (this.b == null) {
            switch (d.a[c() - 1]) {
                case 1:
                    this.b = new a();
                    break;
            }
        }
        return this.b;
    }

    private synchronized int c() {
        int i;
        if (this.c != 0) {
            i = this.c;
        } else {
            this.c = e.b;
            i = this.c;
        }
        return i;
    }
}
