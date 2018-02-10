package com.UCMobile.Apollo.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;

/* compiled from: ProGuard */
public final class a {
    public static String a(File file) {
        Closeable bufferedReader;
        Throwable th;
        String str = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                str = bufferedReader.readLine();
                b.a(bufferedReader);
            } catch (Exception e) {
                b.a(bufferedReader);
                return str;
            } catch (Throwable th2) {
                th = th2;
                b.a(bufferedReader);
                throw th;
            }
        } catch (Exception e2) {
            bufferedReader = str;
            b.a(bufferedReader);
            return str;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedReader = str;
            th = th4;
            b.a(bufferedReader);
            throw th;
        }
        return str;
    }
}
