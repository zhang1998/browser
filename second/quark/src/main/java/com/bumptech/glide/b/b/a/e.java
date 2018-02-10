package com.bumptech.glide.b.b.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.util.l;

/* compiled from: ProGuard */
final class e implements r {
    private final d a = new d();
    private final j<c, Bitmap> b = new j();

    e() {
    }

    public final void a(Bitmap bitmap) {
        this.b.a(this.a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public final Bitmap a(int i, int i2, Config config) {
        return (Bitmap) this.b.a(this.a.a(i, i2, config));
    }

    public final Bitmap a() {
        return (Bitmap) this.b.a();
    }

    public final String b(int i, int i2, Config config) {
        return c(i, i2, config);
    }

    public final int c(Bitmap bitmap) {
        return l.a(bitmap);
    }

    public final String toString() {
        return "AttributeStrategy:\n  " + this.b;
    }

    static String c(int i, int i2, Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    public final String b(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }
}
