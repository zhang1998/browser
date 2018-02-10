package com.uc.base.b.c;

import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: ProGuard */
public abstract class a extends i {
    private static HashMap<Class<? extends a>, HashSet<Integer>> b = new HashMap();
    private HashSet<Integer> a = new HashSet();

    public abstract i a(int i);

    public abstract m a();

    public abstract boolean a(m mVar);

    public abstract boolean b(m mVar);

    public static int a(int i, Class<? extends a> cls) {
        int i2 = (16777215 & i) + 16777316;
        if (com.uc.base.b.b.a.a()) {
            if (i2 <= 100) {
                throw new Error("invalid type from hash, please change another class name!");
            }
            HashSet hashSet = (HashSet) b.get(cls);
            if (hashSet == null) {
                hashSet = new HashSet();
            }
            if (hashSet.contains(Integer.valueOf(i2))) {
                throw new Error("id must be different !");
            }
            hashSet.add(Integer.valueOf(i2));
        }
        return i2;
    }

    public static int b(int i) {
        return ((i - 100) >> 24) & 255;
    }

    public byte k_() {
        return (byte) 1;
    }

    public final byte[] l_() {
        m a = a();
        a(a);
        if (k_() == (byte) 2) {
            return new b().a(a);
        }
        f fVar = new f();
        return f.a(a);
    }

    public final boolean a(d dVar) {
        boolean z = false;
        if (!(dVar == null || dVar.b == null)) {
            if (k_() < dVar.a) {
                File file = dVar.c;
                if (file != null) {
                    file.deleteOnExit();
                }
            } else {
                m a;
                if (dVar.a == (byte) 2) {
                    a = new h().a(dVar.b);
                } else {
                    a = new g().a(dVar.b);
                }
                if (a != null) {
                    try {
                        z = b(a);
                    } catch (Throwable e) {
                        Log.e("Bean", "parse struct exception", e);
                        com.uc.base.b.b.a.a("parse struct exception: " + e.getMessage());
                    }
                }
            }
        }
        return z;
    }

    public final boolean a(byte[] bArr) {
        boolean z = false;
        if (bArr != null) {
            m a = new h().a(bArr);
            if (a != null) {
                try {
                    z = b(a);
                } catch (Throwable e) {
                    Log.e("Bean", "parse struct exception", e);
                    com.uc.base.b.b.a.a("parse struct exception: " + e.getMessage());
                }
            }
        }
        return z;
    }
}
