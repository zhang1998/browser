package com.alibaba.analytics.a;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: ProGuard */
public final class o {
    static File a = null;
    static FileChannel b;
    static FileLock c;

    public static synchronized boolean a(Context context) {
        boolean z = true;
        synchronized (o.class) {
            if (a == null) {
                a = new File(context.getFilesDir() + File.separator + "Analytics.Lock");
            }
            boolean exists = a.exists();
            if (!exists) {
                try {
                    exists = a.createNewFile();
                } catch (IOException e) {
                }
            }
            if (exists) {
                if (b == null) {
                    try {
                        b = new RandomAccessFile(a, "rw").getChannel();
                    } catch (Exception e2) {
                        z = false;
                    }
                }
                Object obj;
                try {
                    FileLock tryLock = b.tryLock();
                    if (tryLock != null) {
                        c = tryLock;
                    } else {
                        FileLock fileLock = tryLock;
                        new StringBuilder("mLock:").append(obj);
                        z = false;
                    }
                } catch (Throwable th) {
                    obj = null;
                }
            }
        }
        return z;
    }

    public static synchronized void a() {
        synchronized (o.class) {
            if (c != null) {
                try {
                    c.release();
                    c = null;
                } catch (Exception e) {
                    b = null;
                } catch (IOException e2) {
                    c = null;
                } catch (Throwable th) {
                    c = null;
                }
            }
            if (b != null) {
                b.close();
                b = null;
            }
        }
    }
}
