package com.UCMobile.Apollo.util;

import java.io.Closeable;

/* compiled from: ProGuard */
public final class b {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }
}
