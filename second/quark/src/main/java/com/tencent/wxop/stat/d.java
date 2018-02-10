package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.n;
import com.tencent.wxop.stat.a.p;
import com.tencent.wxop.stat.a.s;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;

public class d {
    private static d i = null;
    List<String> a = null;
    volatile int b = 2;
    public volatile String c = "";
    volatile HttpHost d = null;
    int e = 0;
    Context f = null;
    p g = null;
    private com.tencent.wxop.stat.a.d h = null;

    private d(Context context) {
        this.f = context.getApplicationContext();
        this.h = new com.tencent.wxop.stat.a.d();
        n.a(context);
        this.g = n.c();
        e();
        this.a = new ArrayList(10);
        this.a.add("117.135.169.101");
        this.a.add("140.207.54.125");
        this.a.add("180.153.8.53");
        this.a.add("120.198.203.175");
        this.a.add("14.17.43.18");
        this.a.add("163.177.71.186");
        this.a.add("111.30.131.31");
        this.a.add("123.126.121.167");
        this.a.add("123.151.152.111");
        this.a.add("113.142.45.79");
        this.a.add("123.138.162.90");
        this.a.add("103.7.30.94");
        c();
    }

    public static d a(Context context) {
        if (i == null) {
            synchronized (d.class) {
                if (i == null) {
                    i = new d(context);
                }
            }
        }
        return i;
    }

    static boolean a(String str) {
        return Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(str).matches();
    }

    private String d() {
        try {
            String str = "pingma.qq.com";
            if (!a(str)) {
                return InetAddress.getByName(str).getHostAddress();
            }
        } catch (Throwable e) {
            this.g.b(e);
        }
        return "";
    }

    private void e() {
        this.b = 0;
        this.d = null;
        this.c = null;
    }

    public final boolean a() {
        return this.b == 1;
    }

    public final boolean b() {
        return this.b != 0;
    }

    final void c() {
        if (s.e(this.f)) {
            if (i.g) {
                String d = d();
                if (i.b()) {
                    this.g.a("remoteIp ip is " + d);
                }
                if (n.c(d)) {
                    String str;
                    if (this.a.contains(d)) {
                        str = d;
                    } else {
                        str = (String) this.a.get(this.e);
                        if (i.b()) {
                            this.g.c(d + " not in ip list, change to:" + str);
                        }
                    }
                    i.c("http://" + str + ":80/mstat/report");
                }
            }
            this.c = n.k(this.f);
            if (i.b()) {
                this.g.a("NETWORK name:" + this.c);
            }
            if (n.c(this.c)) {
                if ("WIFI".equalsIgnoreCase(this.c)) {
                    this.b = 1;
                } else {
                    this.b = 2;
                }
                this.d = n.a(this.f);
            }
            if (ah.a()) {
                ah.c(this.f);
                return;
            }
            return;
        }
        if (i.b()) {
            this.g.a((Object) "NETWORK TYPE: network is close.");
        }
        e();
    }
}
