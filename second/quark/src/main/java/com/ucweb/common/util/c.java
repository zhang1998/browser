package com.ucweb.common.util;

import android.text.TextUtils;
import java.util.Collection;

/* compiled from: ProGuard */
public final class c {
    private static boolean a = true;
    private static i b = new j();

    public static void a(boolean z) {
        a = z;
    }

    public static void a(Object obj) {
        a(obj, "notNull assert fail");
    }

    private static void b(String str, Throwable th) {
        if (!a) {
            i iVar = b;
            if (th == null) {
                th = new Throwable();
            }
            iVar.a(str, th);
        } else if (th != null) {
            b.a(str, null);
            throw new AssertionError(th);
        } else {
            throw new AssertionError(str);
        }
    }

    public static void a(CharSequence charSequence) {
        String str = "notEmpty assert fail";
        if (TextUtils.isEmpty(charSequence)) {
            b(str, null);
        }
    }

    public static void a(Collection collection) {
        String str = "notEmpty assert fail";
        if (collection == null || collection.isEmpty()) {
            b(str, null);
        }
    }

    public static void a(boolean z, String str) {
        b(z, str);
    }

    private static void b(boolean z, String str) {
        if (!z) {
            b(str, null);
        }
    }

    public static void a() {
        b("assert fail", null);
    }

    public static void a(String str, Throwable th) {
        b(str, th);
    }

    public static void a(int i) {
        if (a && i != 2) {
            b(i + " not equal to 2", null);
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            b(str, null);
        }
    }

    public static void b(boolean z) {
        b(z, "beTrueIf assert fail");
    }

    public static void c(boolean z) {
        String str = "beFalseIf assert fail";
        if (z) {
            b(str, null);
        }
    }

    public static void a(String str) {
        b(str, null);
    }
}
