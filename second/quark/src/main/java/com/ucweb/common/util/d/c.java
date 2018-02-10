package com.ucweb.common.util.d;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* compiled from: ProGuard */
public final class c {
    private static c a;
    private final Properties b = new Properties();

    private c() throws IOException {
        InputStream fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
        this.b.load(fileInputStream);
        fileInputStream.close();
    }

    public final String a(String str, String str2) {
        return this.b.getProperty(str, str2);
    }

    public static c a() throws IOException {
        if (a == null) {
            a = new c();
        }
        return a;
    }
}
