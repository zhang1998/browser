package com.bumptech.glide.b.c;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.b.a.c;
import com.bumptech.glide.b.a.k;

/* compiled from: ProGuard */
public final class bl implements ar<Uri, ParcelFileDescriptor>, bm<ParcelFileDescriptor> {
    private final ContentResolver a;

    public bl(ContentResolver contentResolver) {
        this.a = contentResolver;
    }

    public final c<ParcelFileDescriptor> a(Uri uri) {
        return new k(this.a, uri);
    }

    public final aq<Uri, ParcelFileDescriptor> a(ba baVar) {
        return new bo(this);
    }
}
