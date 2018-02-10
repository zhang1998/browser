package com.uc.quark.filedownloader.f;

import java.io.IOException;
import java.io.InterruptedIOException;

/* compiled from: ProGuard */
public class p {
    public static final p a = new m();
    private boolean b;
    private long c;

    public void a() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.b && this.c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
