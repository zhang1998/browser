package com.uc.c;

import android.net.Uri;
import android.util.Log;
import com.uc.c;
import com.uc.m;
import com.xigua.p2p.P2PClass;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: ProGuard */
public final class d implements c {
    String a;

    d() {
    }

    private static String a(String str) {
        String str2 = null;
        try {
            str2 = URLDecoder.decode(str, "UTF-8").replaceAll("xg://", "ftp://").split("\\|")[0].replace("xg://", "ftp://");
        } catch (UnsupportedEncodingException e) {
        }
        return str2;
    }

    public final void a() {
        String a = a(this.a);
        try {
            P2PClass a2 = a.a;
            byte[] bytes = a.getBytes("GBK");
            Log.e("vanda", " start exec native doxstart");
            a2.doxstart(bytes);
        } catch (UnsupportedEncodingException e) {
        }
    }

    public final void b() {
        String a = a(this.a);
        if (!new File(m.b + File.separator + Uri.parse(a).getLastPathSegment()).exists()) {
            try {
                a.a.doxdel(a.getBytes("GBK"));
            } catch (UnsupportedEncodingException e) {
            }
        }
    }

    public final void c() {
        try {
            a.a.doxpause(a(this.a).getBytes("GBK"));
        } catch (UnsupportedEncodingException e) {
        }
    }

    public final String d() {
        return "http://127.0.0.1:8083/" + Uri.parse(a(this.a)).getLastPathSegment();
    }
}
