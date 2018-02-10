package com.bumptech.glide.b.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.b.b.a.g;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.p;
import com.bumptech.glide.c;
import com.bumptech.glide.util.l;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
public abstract class f implements p<Bitmap> {
    protected abstract Bitmap a(@NonNull g gVar, @NonNull Bitmap bitmap, int i, int i2);

    public final au<Bitmap> a(Context context, au<Bitmap> auVar, int i, int i2) {
        if (l.a(i, i2)) {
            g gVar = c.a(context).b;
            Bitmap bitmap = (Bitmap) auVar.b();
            if (i == SectionHeader.SHT_LOUSER) {
                i = bitmap.getWidth();
            }
            if (i2 == SectionHeader.SHT_LOUSER) {
                i2 = bitmap.getHeight();
            }
            Bitmap a = a(gVar, bitmap, i, i2);
            if (bitmap.equals(a)) {
                return auVar;
            }
            return e.a(a, gVar);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
