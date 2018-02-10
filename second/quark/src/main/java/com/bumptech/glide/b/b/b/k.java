package com.bumptech.glide.b.b.b;

import android.content.Context;
import java.io.File;

/* compiled from: ProGuard */
final class k implements h {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;

    k(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    public final File a() {
        File cacheDir = this.a.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        return this.b != null ? new File(cacheDir, this.b) : cacheDir;
    }
}
