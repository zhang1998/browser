package com.bumptech.glide.b.d.e;

import android.util.Log;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.d;
import com.bumptech.glide.b.m;
import com.bumptech.glide.b.o;
import com.bumptech.glide.util.c;
import java.io.File;

/* compiled from: ProGuard */
public final class g implements o<f> {
    public final /* bridge */ /* synthetic */ boolean a(Object obj, File file, m mVar) {
        return a((au) obj, file);
    }

    public final d a(m mVar) {
        return d.SOURCE;
    }

    private static boolean a(au<f> auVar, File file) {
        try {
            c.a(((f) auVar.b()).b(), file);
            return true;
        } catch (Throwable e) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e);
            }
            return false;
        }
    }
}
