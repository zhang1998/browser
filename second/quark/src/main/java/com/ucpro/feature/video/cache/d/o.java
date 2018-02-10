package com.ucpro.feature.video.cache.d;

import java.io.Closeable;
import java.io.InputStream;
import java.net.Socket;

/* compiled from: ProGuard */
final class o implements Runnable {
    final /* synthetic */ Socket a;
    final /* synthetic */ InputStream b;
    final /* synthetic */ h c;

    o(h hVar, Socket socket, InputStream inputStream) {
        this.c = hVar;
        this.a = socket;
        this.b = inputStream;
    }

    public final void run() {
        Closeable closeable = null;
        try {
            closeable = this.a.getOutputStream();
            l lVar = new l(this.c.a, this.c.a.f.a(), this.b, closeable, this.a.getInetAddress());
            while (!this.a.isClosed()) {
                lVar.f();
            }
        } catch (Exception e) {
        } finally {
            c.a(closeable);
            c.a(this.b);
            c.c(this.a);
            this.c.a.b(this.a);
        }
    }
}
