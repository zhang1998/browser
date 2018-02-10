package com.uc.base.a.a.a.g;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class a implements b {
    private HttpURLConnection a;
    private boolean b;

    public final void a(String str) throws Exception {
        URL url = new URL(str);
        this.a = (HttpURLConnection) url.openConnection();
        this.b = "https".equals(url.getProtocol());
    }

    public final void b(String str) {
        if (SpdyRequest.POST_METHOD.equals(str)) {
            this.a.setDoOutput(true);
        }
    }

    public final void a() {
        this.a.setConnectTimeout(5000);
    }

    public final void b() {
        this.a.setReadTimeout(5000);
    }

    public final OutputStream c() throws Exception {
        return this.a.getOutputStream();
    }

    public final InputStream d() throws Exception {
        return this.a.getInputStream();
    }

    public final void e() throws Exception {
        this.a.connect();
    }

    public final int f() throws Exception {
        return this.a.getResponseCode();
    }

    public final String g() throws Exception {
        return this.a.getResponseMessage();
    }
}
