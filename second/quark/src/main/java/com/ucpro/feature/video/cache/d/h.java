package com.ucpro.feature.video.cache.d;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ c a;

    h(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        try {
            SocketAddress inetSocketAddress;
            ServerSocket serverSocket = this.a.c;
            if (this.a.a != null) {
                inetSocketAddress = new InetSocketAddress(this.a.a, this.a.b);
            } else {
                inetSocketAddress = new InetSocketAddress(this.a.b);
            }
            serverSocket.bind(inetSocketAddress);
            do {
                try {
                    Socket accept = this.a.c.accept();
                    this.a.a(accept);
                    accept.setSoTimeout(5000);
                    this.a.e.a(new o(this, accept, accept.getInputStream()));
                } catch (IOException e) {
                } catch (Throwable th) {
                }
            } while (!this.a.c.isClosed());
        } catch (Exception e2) {
        }
    }
}
