package com.ucpro.feature.video.cache.e.b;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class e implements Iterable<i> {
    public final List<i> a;
    public final int b;
    public int c;
    private final boolean d;

    e(List<i> list, boolean z, int i, int i2) {
        if (list == null) {
            throw new NullPointerException("elements");
        }
        this.b = i;
        this.a = list;
        this.d = z;
        this.c = i2;
    }

    public static e a(InputStream inputStream) throws c {
        return new a(g.M3U8).a(new InputStreamReader(inputStream));
    }

    public final Iterator<i> iterator() {
        return this.a.iterator();
    }

    public final String toString() {
        return "PlayListImpl{elements=" + this.a + ", endSet=" + this.d + ", targetDuration=" + this.b + ", mMediaSequenceNumber=" + this.c + '}';
    }
}
