package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.b.a.a.a.g;
import com.tencent.b.a.a.a.h;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.a.p;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.android.spdy.SpdyProtocol;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

class n {
    static p a = com.tencent.wxop.stat.a.n.c();
    static Context e = null;
    private static n g = null;
    DefaultHttpClient b = null;
    d c = null;
    StringBuilder d = new StringBuilder(SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
    long f = 0;

    private n(Context context) {
        try {
            e = context.getApplicationContext();
            this.f = System.currentTimeMillis() / 1000;
            this.c = new d();
            if (i.b()) {
                try {
                    Logger.getLogger("org.apache.http.wire").setLevel(Level.FINER);
                    Logger.getLogger("org.apache.http.headers").setLevel(Level.FINER);
                    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
                    System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
                    System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");
                } catch (Throwable th) {
                }
            }
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            this.b = new DefaultHttpClient(basicHttpParams);
            this.b.setKeepAliveStrategy(new l(this));
        } catch (Throwable th2) {
            a.b(th2);
        }
    }

    static Context a() {
        return e;
    }

    static void a(Context context) {
        e = context.getApplicationContext();
    }

    static void a(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("mid");
            if (h.b(optString)) {
                if (i.b()) {
                    a.a("update mid:" + optString);
                }
                g.a(e).a(optString);
            }
            if (!jSONObject.isNull("cfg")) {
                i.a(e, jSONObject.getJSONObject("cfg"));
            }
            if (!jSONObject.isNull("ncts")) {
                int i = jSONObject.getInt("ncts");
                int currentTimeMillis = (int) (((long) i) - (System.currentTimeMillis() / 1000));
                if (i.b()) {
                    a.a("server time:" + i + ", diff time:" + currentTimeMillis);
                }
                com.tencent.wxop.stat.a.n.w(e);
                com.tencent.wxop.stat.a.n.a(e, currentTimeMillis);
            }
        } catch (Throwable th) {
            a.c(th);
        }
    }

    static n b(Context context) {
        if (g == null) {
            synchronized (n.class) {
                if (g == null) {
                    g = new n(context);
                }
            }
        }
        return g;
    }

    final void a(com.tencent.wxop.stat.b.d dVar, k kVar) {
        a(Arrays.asList(new String[]{dVar.f()}), kVar);
    }

    final void a(List<?> list, k kVar) {
        if (this.c != null) {
            this.c.a(new m(this, list, kVar));
        }
    }
}
