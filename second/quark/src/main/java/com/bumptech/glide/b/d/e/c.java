package com.bumptech.glide.b.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.b.b.a.b;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.f;
import com.bumptech.glide.b.g;
import com.bumptech.glide.b.l;
import com.bumptech.glide.b.m;
import com.bumptech.glide.b.n;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.d;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: ProGuard */
public final class c implements n<ByteBuffer, f> {
    public static final l<Boolean> a = l.a("com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.DisableAnimation", Boolean.valueOf(false));
    private static final a b = new a();
    private static final b c = new b();
    private final Context d;
    private final List<g> e;
    private final b f;
    private final com.bumptech.glide.b.b.a.g g;
    private final a h;
    private final d i;

    public final /* bridge */ /* synthetic */ au a(Object obj, int i, int i2, m mVar) throws IOException {
        return a((ByteBuffer) obj, i, i2);
    }

    public final /* synthetic */ boolean a(Object obj, m mVar) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (!((Boolean) mVar.a(a)).booleanValue()) {
            f a;
            List<g> list = this.e;
            if (byteBuffer != null) {
                for (g a2 : list) {
                    a = a2.a(byteBuffer);
                    if (a != f.UNKNOWN) {
                        break;
                    }
                }
            }
            a = f.UNKNOWN;
            if (a == f.GIF) {
                return true;
            }
        }
        return false;
    }

    public c(Context context, List<g> list, com.bumptech.glide.b.b.a.g gVar, b bVar) {
        this(context, list, gVar, bVar, c, b);
    }

    private c(Context context, List<g> list, com.bumptech.glide.b.b.a.g gVar, b bVar, b bVar2, a aVar) {
        this.d = context.getApplicationContext();
        this.e = list;
        this.g = gVar;
        this.h = aVar;
        this.i = new d(gVar, bVar);
        this.f = bVar2;
    }

    private h a(ByteBuffer byteBuffer, int i, int i2) {
        h hVar = null;
        com.bumptech.glide.gifdecoder.c a = this.f.a(byteBuffer);
        try {
            long a2 = com.bumptech.glide.util.f.a();
            if (a.b == null) {
                throw new IllegalStateException("You must call setData() before parseHeader()");
            }
            if (!a.c()) {
                a.b();
                if (!a.c()) {
                    a.a();
                    if (a.c.c < 0) {
                        a.c.b = 1;
                    }
                }
            }
            com.bumptech.glide.gifdecoder.b bVar = a.c;
            if (bVar.c > 0 && bVar.b == 0) {
                int min = Math.min(bVar.g / i2, bVar.f / i);
                min = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    new StringBuilder("Downsampling GIF, sampleSize: ").append(min).append(", target dimens: [").append(i).append("x").append(i2).append("], actual dimens: [").append(bVar.f).append("x").append(bVar.g).append("]");
                }
                GifDecoder dVar = new d(this.i, bVar, byteBuffer, min);
                dVar.b();
                Bitmap h = dVar.h();
                if (h != null) {
                    f fVar = new f(this.d, dVar, this.g, com.bumptech.glide.b.d.b.a(), i, i2, h);
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        new StringBuilder("Decoded GIF from stream in ").append(com.bumptech.glide.util.f.a(a2));
                    }
                    hVar = new h(fVar);
                }
            }
            this.f.a(a);
            return hVar;
        } catch (Throwable th) {
            this.f.a(a);
        }
    }
}
