package com.uc.base.wa.b;

import java.util.HashMap;

/* compiled from: ProGuard */
public final class c {
    public HashMap<String, String> a;
    public q b;
    public String c;
    public HashMap<String, String> d;
    public boolean e = false;

    public final HashMap<String, String> a() {
        if (this.a == null) {
            this.a = new HashMap();
        }
        return this.a;
    }

    public final q b() {
        if (this.b == null) {
            this.b = new q();
        }
        return this.b;
    }

    public final boolean c() {
        return this.a != null;
    }

    public final boolean d() {
        return this.b != null;
    }
}
