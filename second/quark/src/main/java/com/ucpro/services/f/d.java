package com.ucpro.services.f;

import com.ucweb.common.util.n.a;
import java.util.HashMap;
import java.util.Map.Entry;
import okhttp3.Headers;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ h a;

    d(h hVar) {
        this.a = hVar;
    }

    public final void run() {
        RequestBody create;
        h hVar = this.a;
        if (a.d(hVar.a.b(), SpdyRequest.POST_METHOD)) {
            byte[] d = hVar.a.d();
            if (d == null) {
                d = new byte[0];
            }
            create = RequestBody.create(null, d);
        } else {
            create = null;
        }
        Builder method = new Builder().url(hVar.a.a()).method(hVar.a.b(), create);
        Headers.Builder builder = new Headers.Builder();
        builder.add("User-Agent", "MobileUA");
        builder.add("Accept-Language", "zh-CN");
        builder.add("Accept", "application/xml,application/vnd.wap.xhtml+xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        builder.add("Connection", "close");
        builder.add("Content-Type", "application/x-www-form-urlencoded");
        HashMap c = hVar.a.c();
        if (c != null && c.size() > 0) {
            for (Entry key : c.entrySet()) {
                builder.removeAll((String) key.getKey());
            }
            for (Entry key2 : c.entrySet()) {
                builder.add((String) key2.getKey(), (String) key2.getValue());
            }
        }
        g.a().newCall(method.headers(builder.build()).build()).enqueue(new f(hVar));
    }
}
