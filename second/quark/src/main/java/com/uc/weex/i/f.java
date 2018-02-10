package com.uc.weex.i;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/* compiled from: ProGuard */
public final class f implements Closeable {
    private final FileOutputStream a;
    private final FileLock b;

    public static f a(File file) throws IOException {
        return new f(file);
    }

    private f(File file) throws IOException {
        this.a = new FileOutputStream(file);
        try {
            FileLock lock = this.a.getChannel().lock();
            if (lock == null) {
            }
            this.b = lock;
        } finally {
            this.a.close();
        }
    }

    public final void close() throws IOException {
        try {
            this.b.release();
        } finally {
            this.a.close();
        }
    }
}
