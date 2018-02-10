package com.ucpro.feature.a;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.b.d.e.f;
import com.uc.imagecodec.export.ImageDrawable;
import com.uc.weex.component.c;
import com.uc.weex.component.d;

/* compiled from: ProGuard */
final class p implements d {
    final /* synthetic */ r a;

    p(r rVar) {
        this.a = rVar;
    }

    public final void a(Drawable drawable, c cVar) {
        if (drawable instanceof ImageDrawable) {
            ImageDrawable imageDrawable = (ImageDrawable) drawable;
            imageDrawable.setAnimationListener(new n(this, cVar));
            imageDrawable.start();
        } else if (drawable instanceof f) {
            ((f) drawable).start();
        }
    }

    public final void a(Drawable drawable) {
        if (drawable instanceof ImageDrawable) {
            ((ImageDrawable) drawable).stop();
        } else if (drawable instanceof f) {
            ((f) drawable).stop();
        }
    }
}
