package com.bumptech.glide.b.d.e;

import android.util.Log;
import com.bumptech.glide.b.b.a.b;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.f;
import com.bumptech.glide.b.g;
import com.bumptech.glide.b.h;
import com.bumptech.glide.b.l;
import com.bumptech.glide.b.m;
import com.bumptech.glide.b.n;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: ProGuard */
public final class p implements n<InputStream, f> {
    public static final l<Boolean> a = l.a("com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.DisableAnimation", Boolean.valueOf(false));
    private final List<g> b;
    private final n<ByteBuffer, f> c;
    private final b d;

    public final /* synthetic */ au a(Object obj, int i, int i2, m mVar) throws IOException {
        byte[] a = a((InputStream) obj);
        if (a == null) {
            return null;
        }
        return this.c.a(ByteBuffer.wrap(a), i, i2, mVar);
    }

    public final /* synthetic */ boolean a(Object obj, m mVar) throws IOException {
        return !((Boolean) mVar.a(a)).booleanValue() && h.a(this.b, (InputStream) obj, this.d) == f.GIF;
    }

    public p(List<g> list, n<ByteBuffer, f> nVar, b bVar) {
        this.b = list;
        this.c = nVar;
        this.d = bVar;
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Throwable e) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e);
            }
            return null;
        }
    }
}
