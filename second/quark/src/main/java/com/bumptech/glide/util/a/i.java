package com.bumptech.glide.util.a;

/* compiled from: ProGuard */
public final class i extends j {
    private volatile boolean a;

    public i() {
        super();
    }

    public final void a() {
        if (this.a) {
            throw new IllegalStateException("Already released");
        }
    }

    public final void a(boolean z) {
        this.a = z;
    }
}
