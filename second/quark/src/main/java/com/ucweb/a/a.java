package com.ucweb.a;

import android.text.TextUtils;
import com.ucweb.a.a.c;
import okhttp3.Headers;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
abstract class a implements b, c {
    final f a = new f();

    public void a() {
        f fVar = this.a;
        if (this != null) {
            fVar.a = this;
            if (c() != null) {
                RequestBody create;
                if (TextUtils.equals(fVar.a.d(), SpdyRequest.POST_METHOD)) {
                    byte[] e = fVar.a.e();
                    if (e == null) {
                        e = new byte[0];
                    }
                    create = RequestBody.create(null, e);
                } else {
                    create = null;
                }
                Builder method = new Builder().url(fVar.a.c()).method(fVar.a.d(), create);
                Headers.Builder builder = new Headers.Builder();
                builder.add("User-Agent", "MobileUA");
                builder.add("Accept-Language", "zh-CN");
                builder.add("Accept", "application/xml,application/vnd.wap.xhtml+xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
                builder.add("Connection", "close");
                builder.add("Content-Type", "application/x-www-form-urlencoded");
                c.c().K().newCall(method.headers(builder.build()).build()).enqueue(new e(fVar));
            } else if (fVar.b != null) {
                fVar.b.b();
            }
        }
    }
}
