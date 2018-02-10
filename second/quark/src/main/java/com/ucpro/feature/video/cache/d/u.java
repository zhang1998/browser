package com.ucpro.feature.video.cache.d;

import android.util.Log;
import com.alibaba.wireless.security.SecExceptionCode;
import com.ucpro.c.b;
import com.ucpro.feature.video.cache.g.a;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.URLDecoder;
import java.util.Map;

/* compiled from: ProGuard */
public class u extends c {
    static int g = 0;
    private static final String h = u.class.getSimpleName();
    private static u i = null;
    private static Object j = new Object();
    private static String k;

    private u(int i) {
        super("localhost", i);
    }

    public static synchronized boolean a() {
        boolean z = true;
        synchronized (u.class) {
            synchronized (j) {
                if (i != null) {
                    c cVar = i;
                    boolean z2 = (cVar.c == null || cVar.d == null) ? false : true;
                    if (z2 && !cVar.c.isClosed() && cVar.d.isAlive()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                    }
                }
                int i = 0;
                while (i < SecExceptionCode.SEC_ERROR_DYN_STORE) {
                    try {
                        i = new u(i + 8180);
                        k = "http://localhost:" + (i + 8180) + "/";
                        c cVar2 = i;
                        cVar2.c = new ServerSocket();
                        cVar2.d = new Thread(new h(cVar2));
                        cVar2.d.setDaemon(true);
                        cVar2.d.setName("NanoHttpd Main Listener");
                        cVar2.d.start();
                        if (b.b()) {
                            int i2;
                            Log.e(h, "startService: started service at port=" + (i + 8180));
                            String str = h;
                            StringBuilder stringBuilder = new StringBuilder("startService: started service's Listening Port=");
                            cVar2 = i;
                            if (cVar2.c == null) {
                                i2 = -1;
                            } else {
                                i2 = cVar2.c.getLocalPort();
                            }
                            Log.e(str, stringBuilder.append(i2).toString());
                        }
                        break;
                    } catch (Exception e) {
                        if (b.b()) {
                            new StringBuilder("VideoPlayLocalProxy opensock when bind: ").append(i + 8180);
                        }
                        i++;
                    }
                }
                z = false;
            }
        }
        return z;
    }

    public static String b() {
        return k;
    }

    public final d a(String str, b bVar, Map<String, String> map, Map<String, String> map2) {
        if (b.b()) {
            Log.w(h, "handle " + str);
        }
        if (str == null) {
            return null;
        }
        try {
            if (str.length() == 0 || bVar != b.a) {
                return null;
            }
            d dVar;
            if (b.b()) {
                new StringBuilder("serveLocalVideo: header: ").append(map.toString());
                new StringBuilder("serveLocalVideo: params: ").append(map2.toString());
            }
            new f().a = k;
            String str2 = (String) map2.get("type");
            String decode = URLDecoder.decode((String) map2.get("filepath"));
            Log.e("hjw-m3u8", "type=" + str2 + ",path=" + decode);
            if (!new File(decode).exists()) {
                dVar = null;
            } else if (decode.endsWith("/local.m3u8")) {
                if (b.b()) {
                    Log.e("hjw-m3u8", "asking for m3u8 meta data@" + decode);
                }
                Object a = f.a(decode);
                if (b.b()) {
                    Log.e("hjw-m3u8", "m3u8 meta byte[] is:" + a);
                }
                if (a == null || a.length == 0) {
                    dVar = new d(q.NOT_FOUND, "text/html", "Error 404, file not found.");
                    if (b.b()) {
                        Log.e("hjw-m3u8", "m3u8 meta file not found.");
                    }
                } else {
                    dVar = new d(q.OK, "application/vnd.apple.mpegurl", new ByteArrayInputStream(a));
                    dVar.a("Content-Length", Integer.toString(a.length));
                    if (b.b()) {
                        Log.e("hjw-m3u8", "m3u8 meta file OK.");
                    }
                }
            } else {
                if (b.b()) {
                    Log.e("hjw-m3u8", "asking for m3u8 ts data@" + decode);
                }
                dVar = f.b(decode);
            }
            return dVar;
        } catch (Exception e) {
            r1 = g;
            g = r1 + 1;
            int i;
            if (i >= 20) {
                return null;
            }
            Writer stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            if (stringWriter.getBuffer() != null) {
                a.d(str + "," + stringWriter.getBuffer().toString());
                return null;
            }
            a.d(str + "," + e.getMessage());
            return null;
        }
    }
}
