package com.ucpro.feature.video.e;

import com.ucpro.feature.video.e.a.a;
import com.ucpro.services.f.g;
import com.ucweb.common.util.c;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import okhttp3.Request;

/* compiled from: ProGuard */
public final class b {
    private static b a = new b();
    private Queue<com.ucpro.feature.video.e.a.b> b = new LinkedBlockingDeque();

    private b() {
    }

    public static b a() {
        return a;
    }

    public final synchronized void a(Request request, a aVar) {
        c.a((Object) request);
        a(new com.ucpro.feature.video.e.a.b(request, aVar));
    }

    public final synchronized void a(com.ucpro.feature.video.e.a.b bVar) {
        Object obj = bVar.a;
        c.a(obj);
        g.a().newCall(obj).enqueue(new a(bVar));
    }
}
