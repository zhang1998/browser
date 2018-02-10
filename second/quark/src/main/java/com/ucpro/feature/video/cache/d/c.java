package com.ucpro.feature.video.cache.d;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: ProGuard */
public abstract class c {
    final String a;
    final int b;
    ServerSocket c;
    Thread d;
    v e;
    n f;
    private Set<Socket> g = new HashSet();

    public c(String str, int i) {
        this.a = str;
        this.b = i;
        this.f = new p();
        this.e = new r();
    }

    public final synchronized void a(Socket socket) {
        this.g.add(socket);
    }

    public final synchronized void b(Socket socket) {
        this.g.remove(socket);
    }

    public final d a(i iVar) {
        Map hashMap = new HashMap();
        b e = iVar.e();
        if (b.PUT.equals(e) || b.c.equals(e)) {
            try {
                iVar.a(hashMap);
            } catch (IOException e2) {
                return new d(q.INTERNAL_ERROR, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e2.getMessage());
            } catch (m e3) {
                return new d(e3.a, "text/plain", e3.getMessage());
            }
        }
        hashMap = iVar.a();
        hashMap.put("NanoHttpd.QUERY_STRING", iVar.d());
        return a(iVar.c(), e, iVar.b(), hashMap);
    }

    @Deprecated
    public d a(String str, b bVar, Map<String, String> map, Map<String, String> map2) {
        return new d(q.NOT_FOUND, "text/plain", "Not Found");
    }

    protected static String a(String str) {
        String str2 = null;
        try {
            str2 = URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e) {
        }
        return str2;
    }

    static /* synthetic */ void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    static /* synthetic */ void c(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
}
