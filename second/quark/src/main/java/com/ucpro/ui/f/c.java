package com.ucpro.ui.f;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.uc.webview.export.extension.UCCore;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class c extends ViewGroup {
    protected List<List<View>> a = new ArrayList();
    protected List<Integer> b = new ArrayList();
    protected List<Integer> c = new ArrayList();
    private int d = -1;
    private boolean e = false;
    private int f = 0;

    public c(Context context) {
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        int i3 = 1;
        if (childCount <= 0) {
            i3 = 0;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = i3;
        int i8 = 0;
        int i9 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            childAt.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.rightMargin) + marginLayoutParams.leftMargin, marginLayoutParams.width), getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin, marginLayoutParams.height));
            int measuredWidth = (childAt.getMeasuredWidth() + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin;
            int measuredHeight = (childAt.getMeasuredHeight() + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin;
            int i10;
            if (i6 + measuredWidth > (size - getPaddingLeft()) - getPaddingRight()) {
                i3 = i7 + 1;
                if (this.d != -1 && i3 > this.d) {
                    i9 = Math.max(i6, i9);
                    i3 = i8 + i5;
                    this.f = i4;
                    i10 = i3;
                    i3 = i9;
                    i9 = i10;
                    break;
                }
                i7 = measuredHeight;
                measuredHeight = measuredWidth;
                i10 = i3;
                i3 = i8 + i5;
                i8 = Math.max(i9, i6);
                i9 = i10;
            } else {
                measuredWidth += i6;
                i3 = Math.max(i5, measuredHeight);
                measuredHeight = measuredWidth;
                i10 = i3;
                i3 = i8;
                i8 = i9;
                i9 = i7;
                i7 = i10;
            }
            if (i4 == childCount - 1) {
                i8 = Math.max(measuredHeight, i8);
                i3 += i7;
                this.f = childCount;
            }
            i4++;
            i5 = i7;
            i6 = measuredHeight;
            i7 = i9;
            i9 = i8;
            i8 = i3;
        }
        i3 = i9;
        i9 = i8;
        if (mode == UCCore.VERIFY_POLICY_QUICK) {
            i8 = size;
        } else {
            i8 = (i3 + getPaddingLeft()) + getPaddingRight();
        }
        if (mode2 == UCCore.VERIFY_POLICY_QUICK) {
            i3 = size2;
        } else {
            i3 = (getPaddingTop() + i9) + getPaddingBottom();
        }
        setMeasuredDimension(i8, i3);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        List list;
        int i7;
        for (i5 = 0; i5 < this.a.size(); i5++) {
            ((List) this.a.get(i5)).clear();
        }
        this.b.clear();
        this.c.clear();
        int measuredWidth = getMeasuredWidth();
        int i8 = 0;
        int i9 = 0;
        int childCount = getChildCount();
        if (childCount <= 0) {
            i6 = 0;
            list = null;
        } else if (1 > this.a.size() || this.a.get(0) == null) {
            ArrayList arrayList = new ArrayList();
            this.a.add(arrayList);
            Object obj = arrayList;
            i6 = 1;
        } else {
            list = (List) this.a.get(0);
            i6 = 1;
        }
        List list2 = list;
        i5 = i6;
        for (i7 = 0; i7 < childCount; i7++) {
            int measuredHeight;
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth2;
                int i10;
                List list3;
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
                measuredWidth2 = childAt.getMeasuredWidth();
                measuredHeight = childAt.getMeasuredHeight();
                int i11;
                if (((measuredWidth2 + i8) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin > (measuredWidth - getPaddingLeft()) - getPaddingRight()) {
                    this.b.add(Integer.valueOf(i9));
                    this.c.add(Integer.valueOf(i8));
                    i10 = i5 + 1;
                    if (this.d != -1 && i10 > this.d) {
                        break;
                    }
                    if (i10 > this.a.size() || this.a.get(i10 - 1) == null) {
                        list = new ArrayList();
                        this.a.add(list);
                    } else {
                        list = (List) this.a.get(i10 - 1);
                    }
                    i11 = i10;
                    i10 = (marginLayoutParams.topMargin + measuredHeight) + marginLayoutParams.bottomMargin;
                    i9 = 0;
                    list3 = list;
                    i5 = i11;
                } else {
                    i11 = i9;
                    i9 = i8;
                    list3 = list2;
                    i10 = i11;
                }
                measuredWidth2 = ((measuredWidth2 + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i9;
                i9 = Math.max(i10, marginLayoutParams.bottomMargin + (marginLayoutParams.topMargin + measuredHeight));
                list3.add(childAt);
                list2 = list3;
                i8 = measuredWidth2;
            }
        }
        this.b.add(Integer.valueOf(i9));
        this.c.add(Integer.valueOf(i8));
        for (i5 = this.a.size() - 1; i5 >= 0; i5--) {
            if (((List) this.a.get(i5)).isEmpty()) {
                this.a.remove(i5);
            }
        }
        View view;
        if (this.e) {
            getPaddingLeft();
            i5 = getMeasuredHeight() - getPaddingBottom();
            measuredWidth = this.a.size();
            measuredWidth2 = 0;
            i7 = i5;
            while (measuredWidth2 < measuredWidth) {
                list2 = (List) this.a.get(measuredWidth2);
                childCount = ((Integer) this.b.get(measuredWidth2)).intValue();
                i9 = 0;
                i8 = getPaddingLeft();
                while (i9 < list2.size()) {
                    view = (View) list2.get(i9);
                    if (view.getVisibility() != 8) {
                        MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) view.getLayoutParams();
                        int i12 = marginLayoutParams2.leftMargin + i8;
                        int i13 = i7 - marginLayoutParams2.bottomMargin;
                        view.layout(i12, i13 - view.getMeasuredHeight(), view.getMeasuredWidth() + i12, i13);
                        i5 = i8 + ((view.getMeasuredWidth() + marginLayoutParams2.leftMargin) + marginLayoutParams2.rightMargin);
                    } else {
                        i5 = i8;
                    }
                    i9++;
                    i8 = i5;
                }
                measuredWidth2++;
                i7 -= childCount;
            }
            return;
        }
        getPaddingLeft();
        i5 = getPaddingTop();
        measuredWidth = this.a.size();
        measuredWidth2 = 0;
        i7 = i5;
        while (measuredWidth2 < measuredWidth) {
            list2 = (List) this.a.get(measuredWidth2);
            childCount = ((Integer) this.b.get(measuredWidth2)).intValue();
            i9 = 0;
            i8 = getPaddingLeft();
            while (i9 < list2.size()) {
                view = (View) list2.get(i9);
                if (view.getVisibility() != 8) {
                    marginLayoutParams2 = (MarginLayoutParams) view.getLayoutParams();
                    i12 = marginLayoutParams2.leftMargin + i8;
                    measuredHeight = marginLayoutParams2.topMargin + i7;
                    view.layout(i12, measuredHeight, view.getMeasuredWidth() + i12, view.getMeasuredHeight() + measuredHeight);
                    i5 = i8 + ((view.getMeasuredWidth() + marginLayoutParams2.leftMargin) + marginLayoutParams2.rightMargin);
                } else {
                    i5 = i8;
                }
                i9++;
                i8 = i5;
            }
            measuredWidth2++;
            i7 += childCount;
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new MarginLayoutParams(layoutParams);
    }

    public void setMaxLines(int i) {
        this.d = i;
    }

    public void setStackFromBottom(boolean z) {
        this.e = z;
    }

    public int getMaxContainChildCount() {
        return this.f;
    }
}
