package com.ucpro.feature.l.a;

import android.graphics.drawable.Drawable;
import android.webkit.ValueCallback;
import android.widget.ImageView;

/* compiled from: ProGuard */
final class c implements ValueCallback<Boolean> {
    final /* synthetic */ ImageView a;
    final /* synthetic */ Drawable b;
    final /* synthetic */ ValueCallback c;
    final /* synthetic */ j d;

    c(j jVar, ImageView imageView, Drawable drawable, ValueCallback valueCallback) {
        this.d = jVar;
        this.a = imageView;
        this.b = drawable;
        this.c = valueCallback;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Boolean bool = (Boolean) obj;
        this.a.setImageDrawable(this.b);
        if (bool.booleanValue()) {
            this.a.setTag(Boolean.valueOf(true));
            this.a.animate().rotation(135.0f).alpha(0.5f);
        } else if ((this.a.getTag() instanceof Boolean) && ((Boolean) this.a.getTag()).booleanValue()) {
            this.a.setTag(Boolean.valueOf(false));
            this.a.animate().rotation(0.0f);
        }
        if (this.c != null) {
            this.c.onReceiveValue(bool);
        }
    }
}
