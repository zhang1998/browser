package com.uc.framework.resources;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class y {
    private static y a;
    private static boolean b = false;
    private List<String> c = null;
    private List<String> d = null;
    private long e = 0;
    private String f = null;
    private long g = 0;

    public static y a() {
        if (a == null) {
            a = new y();
        }
        return a;
    }

    public static boolean b() {
        return b;
    }

    public final void a(String str) {
        if (b) {
            if ("scrollbar_thumb.9.png".equals(str)) {
                Exception exception = new Exception("Extra resource loading...");
            }
            this.f = str;
            this.g = System.currentTimeMillis();
        }
    }

    public final void b(String str) {
        if (b && str != null && str.equals(this.f)) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            if (!this.c.contains(str)) {
                this.c.add(str);
            }
            this.e = (System.currentTimeMillis() - this.g) + this.e;
        }
    }
}
