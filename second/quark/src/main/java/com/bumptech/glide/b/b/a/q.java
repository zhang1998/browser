package com.bumptech.glide.b.b.a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ProGuard */
public final class q implements g {
    private static final Config a = Config.ARGB_8888;
    private final r b;
    private final Set<Config> c;
    private final int d;
    private final o e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    private q(int i, r rVar, Set<Config> set) {
        this.d = i;
        this.f = i;
        this.b = rVar;
        this.c = set;
        this.e = new p();
    }

    public q(int i) {
        r wVar;
        if (VERSION.SDK_INT >= 19) {
            wVar = new w();
        } else {
            wVar = new e();
        }
        Set hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Config.values()));
        if (VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        this(i, wVar, Collections.unmodifiableSet(hashSet));
    }

    public final synchronized void a(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (bitmap.isRecycled()) {
            throw new IllegalStateException("Cannot pool recycled bitmap");
        } else if (bitmap.isMutable() && this.b.c(bitmap) <= this.f && this.c.contains(bitmap.getConfig())) {
            int c = this.b.c(bitmap);
            this.b.a(bitmap);
            this.j++;
            this.g = c + this.g;
            if (Log.isLoggable("LruBitmapPool", 2)) {
                new StringBuilder("Put bitmap in pool=").append(this.b.b(bitmap));
            }
            b();
            b(this.f);
        } else {
            if (Log.isLoggable("LruBitmapPool", 2)) {
                new StringBuilder("Reject bitmap from pool, bitmap: ").append(this.b.b(bitmap)).append(", is mutable: ").append(bitmap.isMutable()).append(", is allowed config: ").append(this.c.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        }
    }

    @NonNull
    public final Bitmap a(int i, int i2, Config config) {
        Bitmap c = c(i, i2, config);
        if (c == null) {
            return Bitmap.createBitmap(i, i2, config);
        }
        c.eraseColor(0);
        return c;
    }

    @NonNull
    public final Bitmap b(int i, int i2, Config config) {
        Bitmap c = c(i, i2, config);
        if (c == null) {
            return Bitmap.createBitmap(i, i2, config);
        }
        return c;
    }

    @Nullable
    private synchronized Bitmap c(int i, int i2, Config config) {
        Bitmap a;
        a = this.b.a(i, i2, config != null ? config : a);
        if (a == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                new StringBuilder("Missing bitmap=").append(this.b.b(i, i2, config));
            }
            this.i++;
        } else {
            this.h++;
            this.g -= this.b.c(a);
            a.setHasAlpha(true);
            if (VERSION.SDK_INT >= 19) {
                a.setPremultiplied(true);
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            new StringBuilder("Get bitmap=").append(this.b.b(i, i2, config));
        }
        b();
        return a;
    }

    public final void a() {
        Log.isLoggable("LruBitmapPool", 3);
        b(0);
    }

    @SuppressLint({"InlinedApi"})
    public final void a(int i) {
        Log.isLoggable("LruBitmapPool", 3);
        if (i >= 40) {
            a();
        } else if (i >= 20) {
            b(this.f / 2);
        }
    }

    private synchronized void b(int i) {
        while (this.g > i) {
            Bitmap a = this.b.a();
            if (a == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    c();
                }
                this.g = 0;
            } else {
                this.g -= this.b.c(a);
                this.k++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    new StringBuilder("Evicting bitmap=").append(this.b.b(a));
                }
                b();
                a.recycle();
            }
        }
    }

    private void b() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            c();
        }
    }

    private void c() {
        new StringBuilder("Hits=").append(this.h).append(", misses=").append(this.i).append(", puts=").append(this.j).append(", evictions=").append(this.k).append(", currentSize=").append(this.g).append(", maxSize=").append(this.f).append("\nStrategy=").append(this.b);
    }
}
