package com.uc.apollo.media.a;

import android.net.Uri;

/* compiled from: ProGuard */
public final class b {
    private String a;
    private Uri b;
    private int c;
    private int d = -1;

    public b(String str, Uri uri, int i) {
        this.a = str;
        this.b = uri;
        this.c = i;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void a(Uri uri) {
        this.b = uri;
    }

    final String a() {
        return this.a;
    }

    final String b() {
        return this.b.toString();
    }

    final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final void b(int i) {
        this.d = i;
    }
}
