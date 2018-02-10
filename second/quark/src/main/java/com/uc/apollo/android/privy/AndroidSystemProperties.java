package com.uc.apollo.android.privy;

import com.uc.apollo.annotation.KeepForSdk;
import com.uc.apollo.util.ReflectUtil;
import java.lang.reflect.Method;

@KeepForSdk
/* compiled from: ProGuard */
public class AndroidSystemProperties {

    /* compiled from: ProGuard */
    final class a {
        private static Method a;
        private static Method b;

        static {
            Class cls = ReflectUtil.getClass("android.os.SystemProperties");
            if (cls != null) {
                a = ReflectUtil.getMethod(cls, "get", String.class);
                b = ReflectUtil.getMethod(cls, "get", String.class, String.class);
            }
        }

        static String a(String str, String str2) {
            String str3;
            try {
                if (b != null) {
                    str3 = (String) b.invoke(null, new Object[]{str, null});
                    if (str3 != null) {
                        str3 = str3.trim();
                    }
                    if (str3 != null && str3.length() > 0) {
                        return str3;
                    }
                }
            } catch (Throwable th) {
            }
            try {
                if (a == null) {
                    return str2;
                }
                str3 = (String) a.invoke(null, new Object[]{str});
                if (str3 != null) {
                    str3 = str3.trim();
                }
                if (str3 == null || str3.length() <= 0) {
                    return str2;
                }
                return str3;
            } catch (Throwable th2) {
                return str2;
            }
        }
    }

    public static String get(String str, String str2) {
        return a.a(str, str2);
    }

    public static int get(String str, int i) {
        String str2 = get(str, null);
        if (str2 != null) {
            try {
                i = Integer.valueOf(str2).intValue();
            } catch (Throwable th) {
            }
        }
        return i;
    }
}
