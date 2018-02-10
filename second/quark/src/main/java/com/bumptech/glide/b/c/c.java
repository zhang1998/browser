package com.bumptech.glide.b.c;

import android.content.res.AssetManager;
import android.net.Uri;
import com.bumptech.glide.b.a.r;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class c implements a<InputStream>, ar<Uri, InputStream> {
    private final AssetManager a;

    public c(AssetManager assetManager) {
        this.a = assetManager;
    }

    public final aq<Uri, InputStream> a(ba baVar) {
        return new d(this.a, this);
    }

    public final com.bumptech.glide.b.a.c<InputStream> a(AssetManager assetManager, String str) {
        return new r(assetManager, str);
    }
}
