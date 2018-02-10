package com.bumptech.glide.b.b;

import com.bumptech.glide.b.b.b.a;
import com.bumptech.glide.b.b.b.c;
import com.bumptech.glide.b.b.b.d;

/* compiled from: ProGuard */
public final class ab implements k {
    private final a a;
    private volatile c b;

    public ab(a aVar) {
        this.a = aVar;
    }

    public final c a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = this.a.a();
                }
                if (this.b == null) {
                    this.b = new d();
                }
            }
        }
        return this.b;
    }
}
