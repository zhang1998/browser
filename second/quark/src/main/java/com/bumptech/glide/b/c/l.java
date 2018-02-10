package com.bumptech.glide.b.c;

import android.util.Log;
import com.bumptech.glide.b.c;
import com.bumptech.glide.b.m;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ProGuard */
public final class l implements c<ByteBuffer> {
    public final /* bridge */ /* synthetic */ boolean a(Object obj, File file, m mVar) {
        return a((ByteBuffer) obj, file);
    }

    private static boolean a(ByteBuffer byteBuffer, File file) {
        try {
            com.bumptech.glide.util.c.a(byteBuffer, file);
            return true;
        } catch (IOException e) {
            Log.isLoggable("ByteBufferEncoder", 3);
            return false;
        }
    }
}
