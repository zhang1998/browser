package com.uc.weex.component.i;

import java.net.URI;

/* compiled from: ProGuard */
public final class b {
    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean b(String str) {
        if (str != null) {
            try {
                if (str.indexOf(".") <= 0) {
                    return true;
                }
                String path = URI.create(str).getPath();
                if (path != null && path.length() > 0 && (path.toLowerCase().endsWith(".gif") || path.indexOf(".") <= 0)) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        return false;
    }
}
