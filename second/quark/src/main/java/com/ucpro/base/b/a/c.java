package com.ucpro.base.b.a;

import android.support.annotation.NonNull;
import com.bumptech.glide.b.a;
import com.bumptech.glide.b.a.b;
import com.bumptech.glide.b.c.ac;
import com.bumptech.glide.g;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Request.Builder;
import okhttp3.ResponseBody;

/* compiled from: ProGuard */
public final class c implements com.bumptech.glide.b.a.c<InputStream> {
    InputStream a;
    ResponseBody b;
    private final Factory c;
    private final ac d;
    private volatile Call e;

    public c(Factory factory, ac acVar) {
        this.c = factory;
        this.d = acVar;
    }

    public final void a(g gVar, b<? super InputStream> bVar) {
        Builder url = new Builder().url(this.d.a());
        for (Entry entry : this.d.b().entrySet()) {
            url.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        this.e = this.c.newCall(url.build());
        this.e.enqueue(new a(this, bVar));
    }

    public final void a() {
        try {
            if (this.a != null) {
                this.a.close();
            }
        } catch (IOException e) {
        }
        if (this.b != null) {
            this.b.close();
        }
    }

    public final void b() {
        Call call = this.e;
        if (call != null) {
            call.cancel();
        }
    }

    @NonNull
    public final Class<InputStream> d() {
        return InputStream.class;
    }

    @NonNull
    public final a c() {
        return a.REMOTE;
    }
}
