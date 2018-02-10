package com.uc.a.d;

import android.text.TextUtils;
import android.util.Log;
import com.uc.base.b.c.a.b;
import com.uc.base.b.c.c.a;
import java.io.File;

/* compiled from: ProGuard */
public final class l {
    private static String c(String str) {
        if (TextUtils.isEmpty(str) || h.a == null) {
            return null;
        }
        return h.a.a(str);
    }

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object c = c(str);
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        File file = new File(c);
        if (!file.exists()) {
            return null;
        }
        byte[] a = a.a(file);
        if (a == null) {
            return null;
        }
        b a2 = com.uc.base.b.b.a.a((byte) 1, (byte) 1);
        if (a2 != null) {
            return a2.b(a);
        }
        Log.e("UsResFileManager", "get encrypt handler failed for type: 1");
        return null;
    }

    public static boolean a(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null) {
            return false;
        }
        Object b = h.a.b();
        if (!b.endsWith("/")) {
            b = b + File.separator;
        }
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        b a = com.uc.base.b.b.a.a((byte) 1, (byte) 1);
        if (a == null) {
            return false;
        }
        byte[] a2 = a.a(bArr);
        if (a2 == null) {
            return false;
        }
        return a.a(b, str, null, a2, a2.length, false);
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Object c = c(str);
        if (TextUtils.isEmpty(c)) {
            return false;
        }
        return a.c(c);
    }
}
