package com.ucpro.base.b.a;

import com.bumptech.glide.b.c.ac;
import com.bumptech.glide.b.c.aq;
import com.bumptech.glide.b.c.ar;
import com.bumptech.glide.b.c.ba;
import java.io.InputStream;
import okhttp3.Call.Factory;
import okhttp3.OkHttpClient;

/* compiled from: ProGuard */
public class d implements ar<ac, InputStream> {
    private static volatile Factory a;
    private Factory b;

    private static Factory a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new OkHttpClient();
                }
            }
        }
        return a;
    }

    public d() {
        this(a());
    }

    private d(Factory factory) {
        this.b = factory;
    }

    public final aq<ac, InputStream> a(ba baVar) {
        return new b(this.b);
    }
}
