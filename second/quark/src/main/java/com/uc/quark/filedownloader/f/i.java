package com.uc.quark.filedownloader.f;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

/* compiled from: ProGuard */
public final class i {
    static final Logger a = Logger.getLogger("Okio");

    public static l a(a aVar) {
        return new g(aVar);
    }

    public static a a(OutputStream outputStream) {
        p pVar = new p();
        if (outputStream != null) {
            return new b(pVar, outputStream);
        }
        throw new IllegalArgumentException("out == null");
    }

    public static c a(InputStream inputStream) {
        p pVar = new p();
        if (inputStream != null) {
            return new f(pVar, inputStream);
        }
        throw new IllegalArgumentException("in == null");
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
