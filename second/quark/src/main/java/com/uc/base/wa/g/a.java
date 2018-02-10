package com.uc.base.wa.g;

import android.util.Base64;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public final class a {
    private static Method a = null;
    private static boolean b = false;

    public static String a(String str) {
        Object obj = null;
        if (str == null) {
            return str;
        }
        byte[] bytes = str.getBytes();
        for (byte valueOf : bytes) {
            Byte valueOf2 = Byte.valueOf(valueOf);
            if ((valueOf2.byteValue() >= (byte) 0 && valueOf2.byteValue() <= (byte) 31) || valueOf2.byteValue() == (byte) 96 || valueOf2.byteValue() == Byte.MAX_VALUE) {
                Log.w("gzm_wa_WaEntry", str + " cotains invalid char");
                obj = 1;
                break;
            }
        }
        if (obj != null) {
            return Base64.encodeToString(bytes, 2);
        }
        return str;
    }
}
