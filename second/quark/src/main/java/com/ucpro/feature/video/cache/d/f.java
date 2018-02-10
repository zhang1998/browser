package com.ucpro.feature.video.cache.d;

import com.ucweb.common.util.k.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: ProGuard */
public final class f {
    private static String b;
    String a;

    static {
        b = null;
        b = u.class.getSimpleName();
    }

    static byte[] a(String str) {
        byte[] bArr = null;
        File file = new File(str);
        if (file.exists()) {
            try {
                bArr = a.f(file);
            } catch (IOException e) {
            }
        }
        return bArr;
    }

    static d b(String str) {
        String str2 = "video/mpegts";
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return new d(q.NOT_FOUND, "text/plain", "Error 404, file not found.");
        }
        try {
            long length = file.length();
            d dVar = new d(q.OK, str2, new FileInputStream(file));
            dVar.a("Content-Length", String.valueOf(length));
            dVar.a("Content-Type", str2);
            return dVar;
        } catch (IOException e) {
            return new d(q.FORBIDDEN, "text/plain", "FORBIDDEN: Reading file failed." + e.getMessage());
        }
    }
}
