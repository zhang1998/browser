package com.ucpro.ui.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* compiled from: ProGuard */
public class ScrollViewWithMaxHeight extends ScrollView {
    private int a = 0;

    public ScrollViewWithMaxHeight(Context context) {
        super(context);
    }

    public ScrollViewWithMaxHeight(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() > this.a) {
            setMeasuredDimension(getMeasuredWidth(), this.a);
        }
    }

    public void setMaxHeight(int i) {
        this.a = i;
    }
}
