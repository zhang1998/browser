package com.bumptech.glide.b.d.f;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.d.b.c;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* compiled from: ProGuard */
public final class a implements d<Bitmap, byte[]> {
    private final CompressFormat a;
    private final int b;

    public a() {
        this(CompressFormat.JPEG);
    }

    private a(CompressFormat compressFormat) {
        this.a = compressFormat;
        this.b = 100;
    }

    public final au<byte[]> a(au<Bitmap> auVar) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) auVar.b()).compress(this.a, this.b, byteArrayOutputStream);
        auVar.d();
        return new c(byteArrayOutputStream.toByteArray());
    }
}
