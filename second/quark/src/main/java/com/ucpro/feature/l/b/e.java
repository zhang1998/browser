package com.ucpro.feature.l.b;

import android.content.Context;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/* compiled from: ProGuard */
public final class e extends HorizontalScrollView {
    LinearLayout a;

    public e(Context context) {
        super(context);
        this.a = null;
        this.a = new LinearLayout(getContext());
        this.a.setOrientation(0);
        addView(this.a);
    }
}
