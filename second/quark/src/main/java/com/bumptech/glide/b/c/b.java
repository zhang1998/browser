package com.bumptech.glide.b.c;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.b.a.c;
import com.bumptech.glide.b.a.j;

/* compiled from: ProGuard */
public final class b implements a<ParcelFileDescriptor>, ar<Uri, ParcelFileDescriptor> {
    private final AssetManager a;

    public b(AssetManager assetManager) {
        this.a = assetManager;
    }

    public final aq<Uri, ParcelFileDescriptor> a(ba baVar) {
        return new d(this.a, this);
    }

    public final c<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
        return new j(assetManager, str);
    }
}
