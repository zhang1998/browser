package com.ucweb.common.util.c;

import android.os.Process;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;

/* compiled from: ProGuard */
public final class a {
    public static String a() {
        Closeable bufferedReader;
        Throwable th;
        String str = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    str = readLine.trim();
                    com.ucweb.common.util.o.a.a(bufferedReader);
                } else {
                    com.ucweb.common.util.o.a.a(bufferedReader);
                }
            } catch (Exception e) {
                if (bufferedReader != null) {
                    com.ucweb.common.util.o.a.a(bufferedReader);
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    com.ucweb.common.util.o.a.a(bufferedReader);
                }
                throw th;
            }
        } catch (Exception e2) {
            bufferedReader = null;
            if (bufferedReader != null) {
                com.ucweb.common.util.o.a.a(bufferedReader);
            }
            return str;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedReader = null;
            th = th4;
            if (bufferedReader != null) {
                com.ucweb.common.util.o.a.a(bufferedReader);
            }
            throw th;
        }
        return str;
    }
}
