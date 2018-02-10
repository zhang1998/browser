package com.bumptech.glide.b.a;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: ProGuard */
public final class k extends q<ParcelFileDescriptor> {
    protected final /* synthetic */ void a(Object obj) throws IOException {
        ((ParcelFileDescriptor) obj).close();
    }

    public k(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public final Class<ParcelFileDescriptor> d() {
        return ParcelFileDescriptor.class;
    }

    protected final /* synthetic */ Object a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor.getParcelFileDescriptor();
        }
        throw new FileNotFoundException("FileDescriptor is null for: " + uri);
    }
}
