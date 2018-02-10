package com.ucpro.base.weex;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.f.f;
import com.taobao.weex.common.k;

/* compiled from: ProGuard */
final class i implements f<Drawable> {
    final /* synthetic */ String a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ k c;
    final /* synthetic */ b d;

    i(b bVar, String str, ImageView imageView, k kVar) {
        this.d = bVar;
        this.a = str;
        this.b = imageView;
        this.c = kVar;
    }

    public final /* synthetic */ boolean a(Object obj) {
        Drawable drawable = (Drawable) obj;
        b.a(drawable, this.b, this.c);
        if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicHeight() > 2048) {
            this.b.post(new g(this, ((BitmapDrawable) drawable).getBitmap()));
        }
        return false;
    }
}
