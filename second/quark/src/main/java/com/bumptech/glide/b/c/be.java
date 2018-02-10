package com.bumptech.glide.b.c;

import android.util.Log;
import com.bumptech.glide.b.b.a.b;
import com.bumptech.glide.b.c;
import com.bumptech.glide.b.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: ProGuard */
public final class be implements c<InputStream> {
    private final b a;

    public final /* bridge */ /* synthetic */ boolean a(Object obj, File file, m mVar) {
        return a((InputStream) obj, file);
    }

    public be(b bVar) {
        this.a = bVar;
    }

    private boolean a(InputStream inputStream, File file) {
        OutputStream fileOutputStream;
        Throwable th;
        Object obj = (byte[]) this.a.a(65536, byte[].class);
        try {
            fileOutputStream = new FileOutputStream(file);
            while (true) {
                try {
                    int read = inputStream.read(obj);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(obj, 0, read);
                } catch (IOException e) {
                }
            }
            fileOutputStream.close();
            try {
                fileOutputStream.close();
            } catch (IOException e2) {
            }
            this.a.a(obj, byte[].class);
            return true;
        } catch (IOException e3) {
            fileOutputStream = null;
            try {
                Log.isLoggable("StreamEncoder", 3);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
                this.a.a(obj, byte[].class);
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                    }
                }
                this.a.a(obj, byte[].class);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            this.a.a(obj, byte[].class);
            throw th;
        }
    }
}
