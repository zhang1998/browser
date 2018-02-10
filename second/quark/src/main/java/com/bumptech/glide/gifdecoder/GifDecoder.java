package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* compiled from: ProGuard */
public interface GifDecoder {

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface GifDecodeStatus {
    }

    ByteBuffer a();

    void b();

    int c();

    int d();

    int e();

    void f();

    int g();

    Bitmap h();

    void i();
}
