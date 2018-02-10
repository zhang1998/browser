package com.bumptech.glide.b.a;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* compiled from: ProGuard */
public final class j extends a<ParcelFileDescriptor> {
    protected final /* synthetic */ void a(Object obj) throws IOException {
        ((ParcelFileDescriptor) obj).close();
    }

    public j(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    public final Class<ParcelFileDescriptor> d() {
        return ParcelFileDescriptor.class;
    }

    protected final /* synthetic */ Object a(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
