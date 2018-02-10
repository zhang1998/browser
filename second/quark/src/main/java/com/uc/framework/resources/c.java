package com.uc.framework.resources;

import android.content.res.AssetManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class c {
    static AssetManager a;
    private static c b;
    private Map<String, TaxFile> c = new HashMap();

    static c a() {
        if (a == null) {
            throw new RuntimeException("Please invoke initAssetsFile function before use getInstance!");
        }
        if (b == null) {
            b = new c();
        }
        return b;
    }

    private c() {
    }

    private TaxFile a(String str) throws IOException {
        TaxFile taxFile = (TaxFile) this.c.get(str);
        if (taxFile != null) {
            return taxFile;
        }
        taxFile = new TaxFile(a, str);
        this.c.put(str, taxFile);
        return taxFile;
    }

    final InputStream a(String str, String str2) {
        try {
            TaxFile a = a(str);
            return a.a(str2) != null ? new ByteArrayInputStream(a.a(str2)) : null;
        } catch (Exception e) {
            return null;
        }
    }

    final byte[] b(String str, String str2) {
        try {
            return a(str).a(str2);
        } catch (Exception e) {
            return null;
        }
    }
}
