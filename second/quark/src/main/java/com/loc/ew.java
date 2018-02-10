package com.loc;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: ProGuard */
public final class ew {
    public static final String a = "/a/";
    static final String b = "b";
    static final String c = "c";
    static final String d = "d";
    public static final String e = "e";
    public static final String f = "f";

    public static Class<? extends v> a(int i) {
        switch (i) {
            case 0:
                return p.class;
            case 1:
                return s.class;
            case 2:
                return o.class;
            default:
                return null;
        }
    }

    public static String a(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getFilesDir().getAbsolutePath());
        stringBuilder.append(a);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    static void a(Context context) {
        try {
            l d = d(2);
            if (d != null) {
                d.a(context);
            }
        } catch (Throwable th) {
        }
    }

    static void a(Context context, ep epVar, String str, String str2) {
        Object obj = 1;
        try {
            if (epVar.a != 1) {
                obj = null;
            }
            if (obj != null) {
                ExecutorService b = fa.b();
                if (b != null && !b.isShutdown()) {
                    b.submit(new et(context, str2, epVar, str));
                }
            }
        } catch (RejectedExecutionException e) {
        } catch (Throwable th) {
        }
    }

    static void a(Context context, Throwable th, int i, String str, String str2) {
        try {
            ExecutorService b = fa.b();
            if (b != null && !b.isShutdown()) {
                b.submit(new eu(context, i, th, str, str2));
            }
        } catch (RejectedExecutionException e) {
        } catch (Throwable th2) {
        }
    }

    public static v b(int i) {
        switch (i) {
            case 0:
                return new p();
            case 1:
                return new s();
            case 2:
                return new o();
            default:
                return null;
        }
    }

    static void b(Context context) {
        try {
            ExecutorService b = fa.b();
            if (b != null && !b.isShutdown()) {
                b.submit(new ev(context));
            }
        } catch (Throwable th) {
            es.a(th, "Log", "processLog");
        }
    }

    public static String c(int i) {
        switch (i) {
            case 0:
                return c;
            case 1:
                return b;
            case 2:
                return d;
            default:
                return "";
        }
    }

    static l d(int i) {
        switch (i) {
            case 0:
                return new fc(i);
            case 1:
                return new fd(i);
            case 2:
                return new fb(i);
            default:
                return null;
        }
    }
}
