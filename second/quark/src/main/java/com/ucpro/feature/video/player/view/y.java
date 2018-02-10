package com.ucpro.feature.video.player.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class y extends FrameLayout {
    final /* synthetic */ ah a;

    public y(ah ahVar, Context context) {
        this.a = ahVar;
        super(context);
    }

    protected final void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        List arrayList = new ArrayList();
        for (i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getVisibility() == 0) {
                arrayList.add(childAt);
            }
        }
        childCount = 0;
        for (i3 = 0; i3 < arrayList.size(); i3++) {
            childCount += ((View) arrayList.get(i3)).getMeasuredWidth();
            if (i3 + 1 < arrayList.size()) {
                childCount += this.a.i;
            }
        }
        setMeasuredDimension(childCount, getMeasuredHeight());
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        List arrayList = new ArrayList();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null && childAt.getVisibility() == 0) {
                arrayList.add(childAt);
            }
        }
        int i6 = 0;
        for (childCount = 0; childCount < arrayList.size(); childCount++) {
            View view = (View) arrayList.get(childCount);
            int measuredWidth = view.getMeasuredWidth() + i6;
            view.layout(i6, 0, measuredWidth, view.getMeasuredHeight() + 0);
            if (childCount + 1 < arrayList.size()) {
                i6 = measuredWidth + this.a.i;
            } else {
                i6 = measuredWidth;
            }
        }
    }
}
