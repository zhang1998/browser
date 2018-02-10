package com.bumptech.glide.b.b;

/* compiled from: ProGuard */
final class l {
    private boolean a;
    private boolean b;
    private boolean c;

    l() {
    }

    final synchronized boolean a() {
        this.a = true;
        return a(false);
    }

    final synchronized boolean b() {
        this.b = true;
        return a(false);
    }

    final synchronized boolean c() {
        this.c = true;
        return a(false);
    }

    final synchronized void d() {
        this.b = false;
        this.a = false;
        this.c = false;
    }

    private boolean a(boolean z) {
        return (this.c || this.b) && this.a;
    }
}
