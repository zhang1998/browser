package com.bumptech.glide.b.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.b.a;
import com.bumptech.glide.b.a.b;
import com.bumptech.glide.b.a.c;
import com.bumptech.glide.g;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: ProGuard */
final class ak implements c<File> {
    private static final String[] a = new String[]{"_data"};
    private final Context b;
    private final Uri c;

    ak(Context context, Uri uri) {
        this.b = context;
        this.c = uri;
    }

    public final void a(g gVar, b<? super File> bVar) {
        Object obj = null;
        Cursor query = this.b.getContentResolver().query(this.c, a, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    obj = query.getString(query.getColumnIndexOrThrow("_data"));
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
        if (TextUtils.isEmpty(obj)) {
            bVar.a(new FileNotFoundException("Failed to find file path for: " + this.c));
        } else {
            bVar.a(new File(obj));
        }
    }

    public final void a() {
    }

    public final void b() {
    }

    public final Class<File> d() {
        return File.class;
    }

    public final a c() {
        return a.LOCAL;
    }
}
