package com.ucpro.model;

import java.io.File;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ File a;

    c(File file) {
        this.a = file;
    }

    public final void run() {
        try {
            a.b(this.a);
        } catch (Throwable th) {
        }
    }
}
