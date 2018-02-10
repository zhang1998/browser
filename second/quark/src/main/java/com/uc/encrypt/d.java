package com.uc.encrypt;

import com.UCMobile.Apollo.Global;
import com.uc.apollo.impl.SettingsConst;
import com.ucweb.common.util.c;
import com.ucweb.common.util.n.a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ProGuard */
public final class d {
    public static boolean a = false;
    private static final CopyOnWriteArrayList<Object> b = new CopyOnWriteArrayList();
    private static final CopyOnWriteArrayList<Object> c = new CopyOnWriteArrayList();
    private i d;
    private i e;
    private ConcurrentHashMap<Short, String> f;

    public static d a() {
        return n.a;
    }

    private d() {
        this.f = new ConcurrentHashMap();
        List a = a("B8BCA277D19FDABA50AE27B06A9A9B77");
        if (a.size() >= 2) {
            this.d = (i) a.get(0);
            this.e = (i) a.get(1);
        } else {
            this.d = new i((short) 3, "3");
            this.e = new i((short) 4, "4");
            if (a) {
                this.d = new i((short) 1, SettingsConst.TRUE);
                this.e = new i((short) 2, Global.APOLLO_SERIES);
            }
            f();
        }
        f();
    }

    private void f() {
        this.f.clear();
        this.f.put(Short.valueOf(this.d.a), this.d.b);
        this.f.put(Short.valueOf(this.e.a), this.e.b);
        this.f.put(Short.valueOf((short) 1000), "1000");
        this.f.put(Short.valueOf((short) 1001), "1001");
        Iterator it = b.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final short b() {
        c.a(this.d);
        if (this.d != null) {
            return this.d.a;
        }
        return (short) -1;
    }

    public final String a(short s) {
        return (String) this.f.get(Short.valueOf(s));
    }

    public static void c() {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private static List<i> a(String str) {
        List<i> arrayList = new ArrayList();
        if (!a.a(str)) {
            String[] split = str.split(";");
            if (split != null && split.length >= 2) {
                for (String str2 : split) {
                    String str22;
                    if (!a.a(str22)) {
                        String[] split2 = str22.split(":");
                        if (split2 != null && split2.length == 2) {
                            short a = (short) a.a(split2[0], 0);
                            str22 = split2[1];
                            if (!(a == (short) 0 || a.a(str22))) {
                                arrayList.add(new i(a, str22));
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static String d() {
        return "3";
    }

    public static String e() {
        return "3";
    }

    public static byte[] b(short s) {
        return ByteBuffer.allocate(2).putShort(s).array();
    }

    public static short a(byte[] bArr) {
        return ByteBuffer.wrap(bArr).getShort();
    }
}
