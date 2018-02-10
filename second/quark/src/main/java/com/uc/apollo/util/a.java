package com.uc.apollo.util;

import java.io.IOException;
import java.io.Writer;

/* compiled from: ProGuard */
final class a extends Writer {
    a() {
    }

    public final void close() throws IOException {
        throw new UnsupportedOperationException("Shouldn't be here");
    }

    public final void flush() throws IOException {
        close();
    }

    public final void write(char[] cArr, int i, int i2) throws IOException {
        close();
    }
}
