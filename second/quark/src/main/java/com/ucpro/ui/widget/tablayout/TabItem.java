package com.ucpro.ui.widget.tablayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.dh;
import android.util.AttributeSet;
import android.view.View;
import com.ucpro.d;

/* compiled from: ProGuard */
public final class TabItem extends View {
    final CharSequence a;
    final Drawable b;
    final int c;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        dh a = dh.a(context, attributeSet, d.TabItem);
        this.a = a.c(2);
        this.b = a.a(0);
        this.c = a.e(1, 0);
        a.a.recycle();
    }
}
