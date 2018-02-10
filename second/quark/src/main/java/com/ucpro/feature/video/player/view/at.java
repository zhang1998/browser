package com.ucpro.feature.video.player.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class at extends FrameLayout {
    final /* synthetic */ ah a;

    public at(ah ahVar, Context context) {
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
            childCount += ((View) arrayList.get(i3)).getMeasuredHeight();
            if (i3 + 1 < arrayList.size()) {
                childCount += this.a.h;
            }
        }
        setMeasuredDimension(getMeasuredWidth(), childCount);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int childCount = getChildCount();
        List arrayList = new ArrayList();
        for (i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null && childAt.getVisibility() == 0) {
                arrayList.add(childAt);
            }
        }
        childCount = 0;
        for (i5 = 0; i5 < arrayList.size(); i5++) {
            View view = (View) arrayList.get(i5);
            int measuredWidth = (getMeasuredWidth() - view.getMeasuredWidth()) / 2;
            int measuredHeight = view.getMeasuredHeight() + childCount;
            view.layout(measuredWidth, childCount, measuredWidth + view.getMeasuredWidth(), measuredHeight);
            if (i5 + 1 < arrayList.size()) {
                childCount = measuredHeight + this.a.h;
            } else {
                childCount = measuredHeight;
            }
        }
    }
}
