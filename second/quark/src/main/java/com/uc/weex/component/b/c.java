package com.uc.weex.component.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.taobao.weex.ui.view.n;

/* compiled from: ProGuard */
public final class c extends n {
    private b a;

    public c(Context context, b bVar) {
        super(context);
        this.a = bVar;
    }

    public final void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.a.a((ImageView) this);
    }
}
