package com.bumptech.glide.b.a;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class r extends a<InputStream> {
    protected final /* synthetic */ void a(Object obj) throws IOException {
        ((InputStream) obj).close();
    }

    public r(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    public final Class<InputStream> d() {
        return InputStream.class;
    }

    protected final /* synthetic */ Object a(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }
}
