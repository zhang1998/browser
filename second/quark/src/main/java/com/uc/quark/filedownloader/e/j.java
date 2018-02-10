package com.uc.quark.filedownloader.e;

import android.util.Log;

/* compiled from: ProGuard */
public final class j {
    public static boolean a = false;

    public static void a(Object obj, String str, Object... objArr) {
        a(6, obj, str, objArr);
    }

    public static void b(Object obj, String str, Object... objArr) {
        a(6, obj, str, objArr);
    }

    public static void c(Object obj, String str, Object... objArr) {
        a(4, obj, str, objArr);
    }

    public static void d(Object obj, String str, Object... objArr) {
        a(3, obj, str, objArr);
    }

    public static void e(Object obj, String str, Object... objArr) {
        a(5, obj, str, objArr);
    }

    public static void f(Object obj, String str, Object... objArr) {
        a(2, obj, str, objArr);
    }

    private static void a(int i, Object obj, String str, Object... objArr) {
        if ((i >= 5 ? 1 : null) != null || a) {
            String simpleName;
            StringBuilder stringBuilder = new StringBuilder("FileDownloader.");
            if (obj instanceof Class) {
                simpleName = ((Class) obj).getSimpleName();
            } else {
                simpleName = obj.getClass().getSimpleName();
            }
            Log.println(i, stringBuilder.append(simpleName).toString(), b.a(str, objArr));
        }
    }
}
