package com.ucpro.feature.video.cache.e.b;

import java.net.URI;

/* compiled from: ProGuard */
final class k implements i {
    private final h a;
    private final d b;
    private final double c;
    private final URI d;
    private final boolean e;
    private final String f;
    private final long g;

    public k(h hVar, d dVar, double d, URI uri, String str, long j, boolean z) {
        if (uri == null) {
            throw new NullPointerException("uri");
        } else if (d < -1.0d) {
            throw new IllegalArgumentException();
        } else if (hVar == null || dVar == null) {
            this.a = hVar;
            this.b = dVar;
            this.c = d;
            this.d = uri;
            this.f = str;
            this.e = z;
            this.g = j;
        } else {
            throw new IllegalArgumentException("Element cannot be a encrypted playlist.");
        }
    }

    public final int a() {
        return (int) Math.round(this.c);
    }

    public final URI b() {
        return this.d;
    }

    public final h c() {
        return this.a;
    }

    public final String toString() {
        return "ElementImpl{playlistInfo=" + this.a + ", encryptionInfo=" + this.b + ", discontinuity=" + this.e + ", duration=" + this.c + ", uri=" + this.d + ", title='" + this.f + '\'' + '}';
    }
}
