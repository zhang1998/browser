package com.bumptech.glide.b;

import android.support.annotation.Nullable;
import com.bumptech.glide.b.b.a.b;
import com.bumptech.glide.b.d.a.ad;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ProGuard */
public final class h {
    public static f a(List<g> list, @Nullable InputStream inputStream, b bVar) throws IOException {
        if (inputStream == null) {
            return f.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new ad(inputStream, bVar);
        }
        inputStream.mark(5242880);
        for (g a : list) {
            try {
                f a2 = a.a(inputStream);
                if (a2 != f.UNKNOWN) {
                    inputStream.reset();
                    return a2;
                }
                inputStream.reset();
            } catch (Throwable th) {
                inputStream.reset();
            }
        }
        return f.UNKNOWN;
    }

    public static int b(List<g> list, @Nullable InputStream inputStream, b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new ad(inputStream, bVar);
        }
        inputStream.mark(5242880);
        for (g a : list) {
            try {
                int a2 = a.a(inputStream, bVar);
                if (a2 != -1) {
                    inputStream.reset();
                    return a2;
                }
                inputStream.reset();
            } catch (Throwable th) {
                inputStream.reset();
            }
        }
        return -1;
    }
}
