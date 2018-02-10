package com.bumptech.glide.b.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.b.b.a.b;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.m;
import com.bumptech.glide.b.n;
import com.bumptech.glide.util.e;
import com.bumptech.glide.util.h;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class af implements n<InputStream, Bitmap> {
    private final r a;
    private final b b;

    public af(r rVar, b bVar) {
        this.a = rVar;
        this.b = bVar;
    }

    private au<Bitmap> a(InputStream inputStream, int i, int i2, m mVar) throws IOException {
        if (inputStream instanceof ad) {
            inputStream = (ad) inputStream;
            Object obj = null;
        } else {
            int i3 = 1;
            inputStream = new ad(inputStream, this.b);
        }
        InputStream a = e.a(inputStream);
        try {
            au<Bitmap> a2 = this.a.a(new h(a), i, i2, mVar, new ae(inputStream, a));
            return a2;
        } finally {
            a.a();
            if (obj != null) {
                inputStream.b();
            }
        }
    }

    public final /* bridge */ /* synthetic */ boolean a(Object obj, m mVar) throws IOException {
        return r.a();
    }
}
