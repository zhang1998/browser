package com.ucpro.feature.y;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

/* compiled from: ProGuard */
public final class e extends FrameLayout {
    ImageView a;
    View b;

    public e(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.a = new ImageView(getContext());
        addView(this.a, new LayoutParams(-1, -1));
    }

    public final void setImageDrawable(Drawable drawable) {
        this.a.setImageDrawable(drawable);
    }

    public final void setColorFilter(int i) {
        if (this.a != null) {
            this.a.setColorFilter(i);
        }
    }
}
