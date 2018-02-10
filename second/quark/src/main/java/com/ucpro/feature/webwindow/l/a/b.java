package com.ucpro.feature.webwindow.l.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.h;
import android.view.View;

/* compiled from: ProGuard */
public final class b extends h {
    public static final int[] b = new int[]{16843284};
    Drawable a;
    private Context c;
    private int d = 0;

    public b(Context context) {
        this.c = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(b);
        this.a = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public final void a(Canvas canvas, RecyclerView recyclerView) {
        int i = 0;
        int paddingTop;
        int height;
        int childCount;
        int i2;
        if (this.d == 0) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            childCount = recyclerView.getChildCount();
            if (childCount > 1) {
                i2 = childCount - 1;
            } else {
                i2 = childCount;
            }
            while (i < i2) {
                View childAt = recyclerView.getChildAt(i);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                childCount = layoutParams.rightMargin + childAt.getRight();
                this.a.setBounds(childCount, paddingTop, this.a.getIntrinsicWidth() + childCount, height);
                this.a.draw(canvas);
                i++;
            }
            return;
        }
        paddingTop = recyclerView.getPaddingLeft();
        height = recyclerView.getWidth() - recyclerView.getPaddingRight();
        childCount = recyclerView.getChildCount();
        if (childCount > 1) {
            i2 = childCount - 1;
        } else {
            i2 = childCount;
        }
        while (i < i2) {
            childAt = recyclerView.getChildAt(i);
            layoutParams = (LayoutParams) childAt.getLayoutParams();
            childCount = layoutParams.bottomMargin + childAt.getBottom();
            this.a.setBounds(paddingTop, childCount, height, this.a.getIntrinsicHeight() + childCount);
            this.a.draw(canvas);
            i++;
        }
    }

    public final void a(Rect rect, View view) {
        if (this.d == 0) {
            rect.set(0, 0, 0, this.a.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.a.getIntrinsicWidth(), 0);
        }
    }
}
