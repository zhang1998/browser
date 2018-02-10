package com.ucpro.feature.video.player.view;

import android.content.Context;
import com.ucpro.ui.widget.TextView;

/* compiled from: ProGuard */
public final class av extends TextView {
    private int a = 0;

    public av(Context context) {
        super(context);
        setSingleLine();
        setGravity(17);
    }

    public final void setMinWidth(int i) {
        this.a = i;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() < this.a) {
            setMeasuredDimension(this.a, getMeasuredHeight());
        }
    }
}
