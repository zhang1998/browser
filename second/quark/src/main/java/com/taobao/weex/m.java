package com.taobao.weex;

/* compiled from: ProGuard */
public final class m {
    private static l a = l.UNKNOWN;
    private static k b = k.UNKNOWN;

    public static void a(l lVar) {
        a = lVar;
    }

    public static k a() {
        if (b == k.UNKNOWN) {
            if (a == l.M40) {
                return k.SHARE_V8;
            }
            if (a == l.M57) {
                return k.UC_WEBVIEW;
            }
        }
        return b;
    }

    public static String b() {
        k a = a();
        if (a == k.JSC) {
            return "weexjsc";
        }
        if (a == k.BUILDIN_V8) {
            return "weexv8-m57";
        }
        if (a == l.M40) {
            return "weexv8-m40";
        }
        if (a == l.M57) {
            return "weexv8-m57";
        }
        return null;
    }

    public static long c() {
        if (a() == k.JSC) {
            return 0;
        }
        if (a == l.M40) {
            return 124236;
        }
        if (a == l.M57) {
            return 132432;
        }
        return -1;
    }
}
