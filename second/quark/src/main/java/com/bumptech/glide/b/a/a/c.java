package com.bumptech.glide.b.a.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;

/* compiled from: ProGuard */
public final class c implements f {
    private static final String[] b = new String[]{"_data"};
    private final ContentResolver a;

    public c(ContentResolver contentResolver) {
        this.a = contentResolver;
    }

    public final Cursor a(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        return this.a.query(Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
    }
}
