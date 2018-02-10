package com.uc.quark.filedownloader.f;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: ProGuard */
public interface a extends Closeable, Flushable {
    void a(o oVar, long j) throws IOException;

    void close() throws IOException;

    void flush() throws IOException;
}
