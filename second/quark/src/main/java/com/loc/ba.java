package com.loc;

import java.io.Closeable;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class ba implements Closeable {
    final InputStream[] a;
    final /* synthetic */ bc b;
    private final String c;
    private final long d;
    private final long[] e;

    private ba(bc bcVar, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
        this.b = bcVar;
        this.c = str;
        this.d = j;
        this.a = inputStreamArr;
        this.e = jArr;
    }

    public final void close() {
        for (Closeable a : this.a) {
            bg.a(a);
        }
    }
}
