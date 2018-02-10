package com.uc.apollo.util;

import java.io.File;

/* compiled from: ProGuard */
public final class b {
    public static boolean a(String str) {
        try {
            return new File(str).exists();
        } catch (Throwable th) {
            return false;
        }
    }
}
