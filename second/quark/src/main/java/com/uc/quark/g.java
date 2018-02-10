package com.uc.quark;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public interface g {
    long a(long j) throws IOException;

    String a(String str);

    void a(int i, String str) throws IOException;

    void a(OutputStream outputStream);

    void a(String str, String str2);

    Map<String, List<String>> b();

    Map<String, List<String>> c();

    int d() throws IOException;

    void e() throws Throwable;

    void f() throws IOException;

    void g() throws IOException;

    @Deprecated
    InputStream h() throws IOException;

    boolean i();
}
