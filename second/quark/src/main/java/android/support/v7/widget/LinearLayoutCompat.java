package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.c.h;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: ProGuard */
public class LinearLayoutCompat extends ViewGroup {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    /* compiled from: ProGuard */
    public class LayoutParams extends MarginLayoutParams {
        public float g;
        public int h;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.LinearLayoutCompat_Layout);
            this.g = obtainStyledAttributes.getFloat(h.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.h = obtainStyledAttributes.getInt(h.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.h = -1;
            this.g = 0.0f;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.h = -1;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface DividerMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface OrientationMode {
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return c();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.b = -1;
        this.c = 0;
        this.e = 8388659;
        dh a = dh.a(context, attributeSet, h.LinearLayoutCompat, i);
        int a2 = a.a(h.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.a(h.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.a(h.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.g = a.a.getFloat(h.LinearLayoutCompat_android_weightSum, -1.0f);
        this.b = a.a(h.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = a.a(h.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.a(h.LinearLayoutCompat_divider));
        this.n = a.a(h.LinearLayoutCompat_showDividers, 0);
        this.o = a.c(h.LinearLayoutCompat_dividerPadding, 0);
        a.a.recycle();
    }

    public void setShowDividers(int i) {
        if (i != this.n) {
            requestLayout();
        }
        this.n = i;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.n;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.k) {
            this.k = drawable;
            if (drawable != null) {
                this.l = drawable.getIntrinsicWidth();
                this.m = drawable.getIntrinsicHeight();
            } else {
                this.l = 0;
                this.m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.o = i;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    protected void onDraw(Canvas canvas) {
        if (this.k != null) {
            int virtualChildCount;
            int i;
            View childAt;
            int height;
            LayoutParams layoutParams;
            if (this.d == 1) {
                virtualChildCount = getVirtualChildCount();
                i = 0;
                while (i < virtualChildCount) {
                    View childAt2 = getChildAt(i);
                    if (!(childAt2 == null || childAt2.getVisibility() == 8 || !a(i))) {
                        a(canvas, (childAt2.getTop() - ((LayoutParams) childAt2.getLayoutParams()).topMargin) - this.m);
                    }
                    i++;
                }
                if (a(virtualChildCount)) {
                    childAt = getChildAt(virtualChildCount - 1);
                    if (childAt == null) {
                        height = (getHeight() - getPaddingBottom()) - this.m;
                    } else {
                        layoutParams = (LayoutParams) childAt.getLayoutParams();
                        height = layoutParams.bottomMargin + childAt.getBottom();
                    }
                    a(canvas, height);
                    return;
                }
                return;
            }
            virtualChildCount = getVirtualChildCount();
            boolean a = co.a(this);
            i = 0;
            while (i < virtualChildCount) {
                View childAt3 = getChildAt(i);
                if (!(childAt3 == null || childAt3.getVisibility() == 8 || !a(i))) {
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (a) {
                        height = layoutParams.rightMargin + childAt3.getRight();
                    } else {
                        height = (childAt3.getLeft() - layoutParams.leftMargin) - this.l;
                    }
                    b(canvas, height);
                }
                i++;
            }
            if (a(virtualChildCount)) {
                childAt = getChildAt(virtualChildCount - 1);
                if (childAt != null) {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (a) {
                        height = (childAt.getLeft() - layoutParams.leftMargin) - this.l;
                    } else {
                        height = layoutParams.rightMargin + childAt.getRight();
                    }
                } else if (a) {
                    height = getPaddingLeft();
                } else {
                    height = (getWidth() - getPaddingRight()) - this.l;
                }
                b(canvas, height);
            }
        }
    }

    private void a(Canvas canvas, int i) {
        this.k.setBounds(getPaddingLeft() + this.o, i, (getWidth() - getPaddingRight()) - this.o, this.m + i);
        this.k.draw(canvas);
    }

    private void b(Canvas canvas, int i) {
        this.k.setBounds(i, getPaddingTop() + this.o, this.l + i, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    public int getBaseline() {
        if (this.b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.c;
            if (this.d == 1) {
                i = this.e & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f) / 2);
                            break;
                        case 80:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f;
                            break;
                    }
                }
            }
            i = i2;
            return (((LayoutParams) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.b = i;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    public void setWeightSum(float f) {
        this.g = Math.max(0.0f, f);
    }

    protected void onMeasure(int i, int i2) {
        if (this.d == 1) {
            int i3;
            int i4;
            int i5;
            int i6;
            int measuredWidth;
            int max;
            int i7;
            int i8;
            LayoutParams layoutParams;
            this.f = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            Object obj = 1;
            float f = 0.0f;
            int virtualChildCount = getVirtualChildCount();
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            Object obj2 = null;
            Object obj3 = null;
            int i13 = this.b;
            boolean z = this.h;
            int i14 = SectionHeader.SHT_LOUSER;
            int i15 = 0;
            while (i15 < virtualChildCount) {
                View childAt = getChildAt(i15);
                if (childAt == null) {
                    this.f += 0;
                    i3 = i15;
                } else {
                    Object obj4;
                    int a;
                    Object obj5;
                    float f2;
                    Object obj6;
                    if (childAt.getVisibility() != 8) {
                        Object obj7;
                        if (a(i15)) {
                            this.f += this.m;
                        }
                        LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                        float f3 = f + layoutParams2.g;
                        if (mode2 == 1073741824 && layoutParams2.height == 0 && layoutParams2.g > 0.0f) {
                            i3 = this.f;
                            this.f = Math.max(i3, (layoutParams2.topMargin + i3) + layoutParams2.bottomMargin);
                            i4 = i14;
                            obj7 = 1;
                        } else {
                            i3 = SectionHeader.SHT_LOUSER;
                            if (layoutParams2.height == 0 && layoutParams2.g > 0.0f) {
                                i3 = 0;
                                layoutParams2.height = -2;
                            }
                            int i16 = i3;
                            a(childAt, i, 0, i2, f3 == 0.0f ? this.f : 0);
                            if (i16 != Integer.MIN_VALUE) {
                                layoutParams2.height = i16;
                            }
                            i3 = childAt.getMeasuredHeight();
                            i5 = this.f;
                            this.f = Math.max(i5, (((i5 + i3) + layoutParams2.topMargin) + layoutParams2.bottomMargin) + 0);
                            if (z) {
                                i4 = Math.max(i3, i14);
                                obj7 = obj3;
                            } else {
                                i4 = i14;
                                obj7 = obj3;
                            }
                        }
                        if (i13 >= 0 && i13 == i15 + 1) {
                            this.c = this.f;
                        }
                        if (i15 >= i13 || layoutParams2.g <= 0.0f) {
                            Object obj8 = null;
                            if (mode == 1073741824 || layoutParams2.width != -1) {
                                obj4 = obj2;
                            } else {
                                obj4 = 1;
                                obj8 = 1;
                            }
                            i6 = layoutParams2.leftMargin + layoutParams2.rightMargin;
                            measuredWidth = childAt.getMeasuredWidth() + i6;
                            max = Math.max(i9, measuredWidth);
                            a = co.a(i10, ViewCompat.l(childAt));
                            obj5 = (obj == null || layoutParams2.width != -1) ? null : 1;
                            if (layoutParams2.g > 0.0f) {
                                if (obj8 != null) {
                                    i3 = i6;
                                } else {
                                    i3 = measuredWidth;
                                }
                                f2 = f3;
                                obj6 = obj5;
                                i7 = i11;
                                obj5 = obj7;
                                i14 = max;
                                int i17 = i4;
                                i4 = Math.max(i12, i3);
                                i3 = i17;
                            } else {
                                if (obj8 == null) {
                                    i6 = measuredWidth;
                                }
                                i3 = Math.max(i11, i6);
                                f2 = f3;
                                obj6 = obj5;
                                i7 = i3;
                                obj5 = obj7;
                                i3 = i4;
                                i4 = i12;
                                i14 = max;
                            }
                        } else {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                    }
                    i3 = i14;
                    obj5 = obj3;
                    f2 = f;
                    obj6 = obj;
                    i4 = i12;
                    i7 = i11;
                    obj4 = obj2;
                    i14 = i9;
                    a = i10;
                    obj = obj6;
                    i12 = i4;
                    i11 = i7;
                    i10 = a;
                    i9 = i14;
                    i14 = i3;
                    obj2 = obj4;
                    i3 = i15 + 0;
                    f = f2;
                    obj3 = obj5;
                }
                i15 = i3 + 1;
            }
            if (this.f > 0 && a(virtualChildCount)) {
                this.f += this.m;
            }
            if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
                this.f = 0;
                i8 = 0;
                while (i8 < virtualChildCount) {
                    View childAt2 = getChildAt(i8);
                    if (childAt2 == null) {
                        this.f += 0;
                        i3 = i8;
                    } else if (childAt2.getVisibility() == 8) {
                        i3 = i8 + 0;
                    } else {
                        layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        i6 = this.f;
                        this.f = Math.max(i6, (layoutParams.bottomMargin + ((i6 + i14) + layoutParams.topMargin)) + 0);
                        i3 = i8;
                    }
                    i8 = i3 + 1;
                }
            }
            this.f += getPaddingTop() + getPaddingBottom();
            i15 = ViewCompat.a(Math.max(this.f, getSuggestedMinimumHeight()), i2, 0);
            i6 = (16777215 & i15) - this.f;
            int i18;
            if (obj3 != null || (i6 != 0 && f > 0.0f)) {
                if (this.g > 0.0f) {
                    f = this.g;
                }
                this.f = 0;
                i12 = 0;
                obj3 = obj;
                i18 = i11;
                i14 = i10;
                int i19 = i9;
                while (i12 < virtualChildCount) {
                    float f4;
                    Object obj9;
                    View childAt3 = getChildAt(i12);
                    if (childAt3.getVisibility() != 8) {
                        layoutParams = (LayoutParams) childAt3.getLayoutParams();
                        float f5 = layoutParams.g;
                        if (f5 > 0.0f) {
                            View view;
                            i8 = (int) ((((float) i6) * f5) / f);
                            f5 = f - f5;
                            i7 = i6 - i8;
                            i5 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + layoutParams.leftMargin) + layoutParams.rightMargin, layoutParams.width);
                            if (layoutParams.height != 0 || mode2 != 1073741824) {
                                i8 += childAt3.getMeasuredHeight();
                                if (i8 < 0) {
                                    i8 = 0;
                                }
                                view = childAt3;
                            } else if (i8 > 0) {
                                view = childAt3;
                            } else {
                                i8 = 0;
                                view = childAt3;
                            }
                            view.measure(i5, MeasureSpec.makeMeasureSpec(i8, UCCore.VERIFY_POLICY_QUICK));
                            i5 = i7;
                            i6 = co.a(i14, ViewCompat.l(childAt3) & -256);
                            f4 = f5;
                        } else {
                            f4 = f;
                            i5 = i6;
                            i6 = i14;
                        }
                        i4 = layoutParams.leftMargin + layoutParams.rightMargin;
                        i7 = childAt3.getMeasuredWidth() + i4;
                        i14 = Math.max(i19, i7);
                        obj = (mode == 1073741824 || layoutParams.width != -1) ? null : 1;
                        if (obj == null) {
                            i4 = i7;
                        }
                        i7 = Math.max(i18, i4);
                        obj9 = (obj3 == null || layoutParams.width != -1) ? null : 1;
                        max = this.f;
                        this.f = Math.max(max, (layoutParams.bottomMargin + ((childAt3.getMeasuredHeight() + max) + layoutParams.topMargin)) + 0);
                        i3 = i7;
                        measuredWidth = i14;
                    } else {
                        f4 = f;
                        obj9 = obj3;
                        i3 = i18;
                        measuredWidth = i19;
                        i5 = i6;
                        i6 = i14;
                    }
                    i12++;
                    obj3 = obj9;
                    i18 = i3;
                    i14 = i6;
                    i19 = measuredWidth;
                    i6 = i5;
                    f = f4;
                }
                this.f += getPaddingTop() + getPaddingBottom();
                i3 = i18;
                i10 = i14;
                i8 = i19;
                obj = obj3;
            } else {
                i18 = Math.max(i11, i12);
                if (z && mode2 != 1073741824) {
                    for (i8 = 0; i8 < virtualChildCount; i8++) {
                        View childAt4 = getChildAt(i8);
                        if (!(childAt4 == null || childAt4.getVisibility() == 8 || ((LayoutParams) childAt4.getLayoutParams()).g <= 0.0f)) {
                            childAt4.measure(MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(i14, UCCore.VERIFY_POLICY_QUICK));
                        }
                    }
                }
                i3 = i18;
                i8 = i9;
            }
            if (obj != null || mode == 1073741824) {
                i3 = i8;
            }
            setMeasuredDimension(ViewCompat.a(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i10), i15);
            if (obj2 != null) {
                a(virtualChildCount, i2);
                return;
            }
            return;
        }
        b(i, i2);
    }

    private boolean a(int i) {
        if (i == 0) {
            if ((this.n & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.n & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.n & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    private void a(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private void b(int i, int i2) {
        Object obj;
        int i3;
        int measuredHeight;
        int a;
        LayoutParams layoutParams;
        this.f = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        if (this.i == null || this.j == null) {
            this.i = new int[4];
            this.j = new int[4];
        }
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.a;
        boolean z2 = this.h;
        if (mode == 1073741824) {
            obj = 1;
        } else {
            obj = null;
        }
        int i8 = SectionHeader.SHT_LOUSER;
        int i9 = 0;
        while (i9 < virtualChildCount) {
            LayoutParams layoutParams2;
            int i10;
            Object obj5;
            Object obj6;
            int i11;
            int baseline;
            Object obj7;
            int i12;
            View childAt = getChildAt(i9);
            if (childAt == null) {
                this.f += 0;
                i3 = i9;
            } else {
                float f2;
                Object obj8;
                if (childAt.getVisibility() != 8) {
                    if (a(i9)) {
                        this.f += this.l;
                    }
                    layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                    float f3 = f + layoutParams2.g;
                    if (mode == 1073741824 && layoutParams2.width == 0 && layoutParams2.g > 0.0f) {
                        if (obj != null) {
                            this.f += layoutParams2.leftMargin + layoutParams2.rightMargin;
                        } else {
                            i3 = this.f;
                            this.f = Math.max(i3, (layoutParams2.leftMargin + i3) + layoutParams2.rightMargin);
                        }
                        if (z) {
                            i3 = MeasureSpec.makeMeasureSpec(0, 0);
                            childAt.measure(i3, i3);
                            i10 = i8;
                            obj5 = obj4;
                        } else {
                            i10 = i8;
                            i8 = 1;
                        }
                    } else {
                        i3 = SectionHeader.SHT_LOUSER;
                        if (layoutParams2.width == 0 && layoutParams2.g > 0.0f) {
                            i3 = 0;
                            layoutParams2.width = -2;
                        }
                        int i13 = i3;
                        a(childAt, i, f3 == 0.0f ? this.f : 0, i2, 0);
                        if (i13 != Integer.MIN_VALUE) {
                            layoutParams2.width = i13;
                        }
                        i3 = childAt.getMeasuredWidth();
                        if (obj != null) {
                            this.f += ((layoutParams2.leftMargin + i3) + layoutParams2.rightMargin) + 0;
                        } else {
                            int i14 = this.f;
                            this.f = Math.max(i14, (((i14 + i3) + layoutParams2.leftMargin) + layoutParams2.rightMargin) + 0);
                        }
                        if (z2) {
                            i10 = Math.max(i3, i8);
                            obj5 = obj4;
                        } else {
                            i10 = i8;
                            obj5 = obj4;
                        }
                    }
                    Object obj9 = null;
                    if (mode2 == 1073741824 || layoutParams2.height != -1) {
                        obj6 = obj3;
                    } else {
                        obj6 = 1;
                        obj9 = 1;
                    }
                    i11 = layoutParams2.topMargin + layoutParams2.bottomMargin;
                    measuredHeight = childAt.getMeasuredHeight() + i11;
                    a = co.a(i5, ViewCompat.l(childAt));
                    if (z) {
                        baseline = childAt.getBaseline();
                        if (baseline != -1) {
                            int i15 = ((((layoutParams2.h < 0 ? this.e : layoutParams2.h) & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) >> 4) & -2) >> 1;
                            iArr[i15] = Math.max(iArr[i15], baseline);
                            iArr2[i15] = Math.max(iArr2[i15], measuredHeight - baseline);
                        }
                    }
                    baseline = Math.max(i4, measuredHeight);
                    obj7 = (obj2 == null || layoutParams2.height != -1) ? null : 1;
                    if (layoutParams2.g > 0.0f) {
                        if (obj9 != null) {
                            i3 = i11;
                        } else {
                            i3 = measuredHeight;
                        }
                        f2 = f3;
                        obj8 = obj7;
                        i12 = i6;
                        obj7 = obj5;
                        i8 = baseline;
                        int i16 = i10;
                        i10 = Math.max(i7, i3);
                        i3 = i16;
                    } else {
                        if (obj9 == null) {
                            i11 = measuredHeight;
                        }
                        i3 = Math.max(i6, i11);
                        f2 = f3;
                        obj8 = obj7;
                        i12 = i3;
                        obj7 = obj5;
                        i3 = i10;
                        i10 = i7;
                        i8 = baseline;
                    }
                } else {
                    i3 = i8;
                    obj7 = obj4;
                    f2 = f;
                    obj8 = obj2;
                    i10 = i7;
                    i12 = i6;
                    obj6 = obj3;
                    i8 = i4;
                    a = i5;
                }
                obj2 = obj8;
                i7 = i10;
                i6 = i12;
                i5 = a;
                i4 = i8;
                i8 = i3;
                obj3 = obj6;
                i3 = i9 + 0;
                f = f2;
                obj4 = obj7;
            }
            i9 = i3 + 1;
        }
        if (this.f > 0 && a(virtualChildCount)) {
            this.f += this.l;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i11 = i4;
        } else {
            i11 = Math.max(i4, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f = 0;
            i15 = 0;
            while (i15 < virtualChildCount) {
                View childAt2 = getChildAt(i15);
                if (childAt2 == null) {
                    this.f += 0;
                    i3 = i15;
                } else if (childAt2.getVisibility() == 8) {
                    i3 = i15 + 0;
                } else {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (obj != null) {
                        this.f = ((layoutParams.rightMargin + (layoutParams.leftMargin + i8)) + 0) + this.f;
                        i3 = i15;
                    } else {
                        measuredHeight = this.f;
                        this.f = Math.max(measuredHeight, (layoutParams.rightMargin + ((measuredHeight + i8) + layoutParams.leftMargin)) + 0);
                        i3 = i15;
                    }
                }
                i15 = i3 + 1;
            }
        }
        this.f += getPaddingLeft() + getPaddingRight();
        i4 = ViewCompat.a(Math.max(this.f, getSuggestedMinimumWidth()), i, 0);
        measuredHeight = (16777215 & i4) - this.f;
        View view;
        if (obj4 != null || (measuredHeight != 0 && f > 0.0f)) {
            if (this.g > 0.0f) {
                f = this.g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f = 0;
            i7 = 0;
            obj5 = obj2;
            baseline = i6;
            int i17 = -1;
            i10 = i5;
            while (i7 < virtualChildCount) {
                float f4;
                View childAt3 = getChildAt(i7);
                if (childAt3 == null || childAt3.getVisibility() == 8) {
                    f4 = f;
                    i15 = measuredHeight;
                    i11 = baseline;
                    obj6 = obj5;
                    measuredHeight = i10;
                    i10 = i17;
                } else {
                    int childMeasureSpec;
                    float f5;
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    float f6 = layoutParams.g;
                    if (f6 > 0.0f) {
                        i15 = (int) ((((float) measuredHeight) * f6) / f);
                        f6 = f - f6;
                        measuredHeight -= i15;
                        childMeasureSpec = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + layoutParams.topMargin) + layoutParams.bottomMargin, layoutParams.height);
                        if (layoutParams.width != 0 || mode != 1073741824) {
                            i15 += childAt3.getMeasuredWidth();
                            if (i15 < 0) {
                                i15 = 0;
                            }
                            view = childAt3;
                        } else if (i15 > 0) {
                            view = childAt3;
                        } else {
                            i15 = 0;
                            view = childAt3;
                        }
                        view.measure(MeasureSpec.makeMeasureSpec(i15, UCCore.VERIFY_POLICY_QUICK), childMeasureSpec);
                        childMeasureSpec = co.a(i10, ViewCompat.l(childAt3) & -16777216);
                        f5 = f6;
                        i12 = measuredHeight;
                    } else {
                        i12 = measuredHeight;
                        childMeasureSpec = i10;
                        f5 = f;
                    }
                    if (obj != null) {
                        this.f += ((childAt3.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin) + 0;
                    } else {
                        i15 = this.f;
                        this.f = Math.max(i15, (((childAt3.getMeasuredWidth() + i15) + layoutParams.leftMargin) + layoutParams.rightMargin) + 0);
                    }
                    obj7 = (mode2 == 1073741824 || layoutParams.height != -1) ? null : 1;
                    i14 = layoutParams.topMargin + layoutParams.bottomMargin;
                    measuredHeight = childAt3.getMeasuredHeight() + i14;
                    i17 = Math.max(i17, measuredHeight);
                    if (obj7 != null) {
                        i15 = i14;
                    } else {
                        i15 = measuredHeight;
                    }
                    i14 = Math.max(baseline, i15);
                    obj7 = (obj5 == null || layoutParams.height != -1) ? null : 1;
                    if (z) {
                        i11 = childAt3.getBaseline();
                        if (i11 != -1) {
                            i3 = ((((layoutParams.h < 0 ? this.e : layoutParams.h) & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i11);
                            iArr2[i3] = Math.max(iArr2[i3], measuredHeight - i11);
                        }
                    }
                    f4 = f5;
                    i11 = i14;
                    measuredHeight = childMeasureSpec;
                    obj6 = obj7;
                    i10 = i17;
                    i15 = i12;
                }
                i7++;
                obj5 = obj6;
                baseline = i11;
                i17 = i10;
                i10 = measuredHeight;
                f = f4;
                measuredHeight = i15;
            }
            this.f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i17 = Math.max(i17, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            i3 = baseline;
            i5 = i10;
            i15 = i17;
            obj2 = obj5;
        } else {
            baseline = Math.max(i6, i7);
            if (z2 && mode != 1073741824) {
                for (i15 = 0; i15 < virtualChildCount; i15++) {
                    view = getChildAt(i15);
                    if (!(view == null || view.getVisibility() == 8 || ((LayoutParams) view.getLayoutParams()).g <= 0.0f)) {
                        view.measure(MeasureSpec.makeMeasureSpec(i8, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
                    }
                }
            }
            i3 = baseline;
            i15 = i11;
        }
        if (obj2 != null || mode2 == 1073741824) {
            i3 = i15;
        }
        setMeasuredDimension((-16777216 & i5) | i4, ViewCompat.a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i5 << 16));
        if (obj3 != null) {
            measuredHeight = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK);
            for (int i18 = 0; i18 < virtualChildCount; i18++) {
                childAt = getChildAt(i18);
                if (childAt.getVisibility() != 8) {
                    layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams2.height == -1) {
                        a = layoutParams2.width;
                        layoutParams2.width = childAt.getMeasuredWidth();
                        measureChildWithMargins(childAt, i, 0, measuredHeight, 0);
                        layoutParams2.width = a;
                    }
                }
            }
        }
    }

    private static int getChildrenSkipCount$5359dca7() {
        return 0;
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    private static int getLocationOffset$3c7ec8d0() {
        return 0;
    }

    private static int getNextLocationOffset$3c7ec8d0() {
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onLayout(boolean r24, int r25, int r26, int r27, int r28) {
        /*
        r23 = this;
        r0 = r23;
        r3 = r0.d;
        r4 = 1;
        if (r3 != r4) goto L_0x00bd;
    L_0x0007:
        r8 = r23.getPaddingLeft();
        r3 = r27 - r25;
        r4 = r23.getPaddingRight();
        r9 = r3 - r4;
        r3 = r3 - r8;
        r4 = r23.getPaddingRight();
        r10 = r3 - r4;
        r11 = r23.getVirtualChildCount();
        r0 = r23;
        r3 = r0.e;
        r3 = r3 & 112;
        r0 = r23;
        r4 = r0.e;
        r5 = 8388615; // 0x800007 float:1.1754953E-38 double:4.1445265E-317;
        r5 = r5 & r4;
        switch(r3) {
            case 16: goto L_0x0053;
            case 80: goto L_0x0045;
            default: goto L_0x002f;
        };
    L_0x002f:
        r3 = r23.getPaddingTop();
    L_0x0033:
        r7 = 0;
        r6 = r3;
    L_0x0035:
        if (r7 >= r11) goto L_0x01d6;
    L_0x0037:
        r0 = r23;
        r12 = r0.getChildAt(r7);
        if (r12 != 0) goto L_0x0062;
    L_0x003f:
        r6 = r6 + 0;
        r3 = r7;
    L_0x0042:
        r7 = r3 + 1;
        goto L_0x0035;
    L_0x0045:
        r3 = r23.getPaddingTop();
        r3 = r3 + r28;
        r3 = r3 - r26;
        r0 = r23;
        r4 = r0.f;
        r3 = r3 - r4;
        goto L_0x0033;
    L_0x0053:
        r3 = r23.getPaddingTop();
        r4 = r28 - r26;
        r0 = r23;
        r6 = r0.f;
        r4 = r4 - r6;
        r4 = r4 / 2;
        r3 = r3 + r4;
        goto L_0x0033;
    L_0x0062:
        r3 = r12.getVisibility();
        r4 = 8;
        if (r3 == r4) goto L_0x01e2;
    L_0x006a:
        r13 = r12.getMeasuredWidth();
        r14 = r12.getMeasuredHeight();
        r3 = r12.getLayoutParams();
        r3 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r3;
        r4 = r3.h;
        if (r4 >= 0) goto L_0x007d;
    L_0x007c:
        r4 = r5;
    L_0x007d:
        r15 = android.support.v4.view.ViewCompat.h(r23);
        r4 = android.support.v4.view.ca.a(r4, r15);
        r4 = r4 & 7;
        switch(r4) {
            case 1: goto L_0x00ab;
            case 5: goto L_0x00b7;
            default: goto L_0x008a;
        };
    L_0x008a:
        r4 = r3.leftMargin;
        r4 = r4 + r8;
    L_0x008d:
        r0 = r23;
        r15 = r0.a(r7);
        if (r15 == 0) goto L_0x009a;
    L_0x0095:
        r0 = r23;
        r15 = r0.m;
        r6 = r6 + r15;
    L_0x009a:
        r15 = r3.topMargin;
        r6 = r6 + r15;
        r15 = r6 + 0;
        b(r12, r4, r15, r13, r14);
        r3 = r3.bottomMargin;
        r3 = r3 + r14;
        r3 = r3 + 0;
        r6 = r6 + r3;
        r3 = r7 + 0;
        goto L_0x0042;
    L_0x00ab:
        r4 = r10 - r13;
        r4 = r4 / 2;
        r4 = r4 + r8;
        r15 = r3.leftMargin;
        r4 = r4 + r15;
        r15 = r3.rightMargin;
        r4 = r4 - r15;
        goto L_0x008d;
    L_0x00b7:
        r4 = r9 - r13;
        r15 = r3.rightMargin;
        r4 = r4 - r15;
        goto L_0x008d;
    L_0x00bd:
        r5 = android.support.v7.widget.co.a(r23);
        r8 = r23.getPaddingTop();
        r3 = r28 - r26;
        r4 = r23.getPaddingBottom();
        r12 = r3 - r4;
        r3 = r3 - r8;
        r4 = r23.getPaddingBottom();
        r13 = r3 - r4;
        r14 = r23.getVirtualChildCount();
        r0 = r23;
        r3 = r0.e;
        r4 = 8388615; // 0x800007 float:1.1754953E-38 double:4.1445265E-317;
        r3 = r3 & r4;
        r0 = r23;
        r4 = r0.e;
        r11 = r4 & 112;
        r0 = r23;
        r15 = r0.a;
        r0 = r23;
        r0 = r0.i;
        r16 = r0;
        r0 = r23;
        r0 = r0.j;
        r17 = r0;
        r4 = android.support.v4.view.ViewCompat.h(r23);
        r3 = android.support.v4.view.ca.a(r3, r4);
        switch(r3) {
            case 1: goto L_0x0134;
            case 5: goto L_0x0125;
            default: goto L_0x0101;
        };
    L_0x0101:
        r9 = r23.getPaddingLeft();
    L_0x0105:
        r4 = 0;
        r3 = 1;
        if (r5 == 0) goto L_0x01de;
    L_0x0109:
        r4 = r14 + -1;
        r3 = -1;
        r5 = r4;
        r4 = r3;
    L_0x010e:
        r10 = 0;
    L_0x010f:
        if (r10 >= r14) goto L_0x01d6;
    L_0x0111:
        r3 = r4 * r10;
        r18 = r5 + r3;
        r0 = r23;
        r1 = r18;
        r19 = r0.getChildAt(r1);
        if (r19 != 0) goto L_0x0144;
    L_0x011f:
        r9 = r9 + 0;
        r3 = r10;
    L_0x0122:
        r10 = r3 + 1;
        goto L_0x010f;
    L_0x0125:
        r3 = r23.getPaddingLeft();
        r3 = r3 + r27;
        r3 = r3 - r25;
        r0 = r23;
        r4 = r0.f;
        r9 = r3 - r4;
        goto L_0x0105;
    L_0x0134:
        r3 = r23.getPaddingLeft();
        r4 = r27 - r25;
        r0 = r23;
        r6 = r0.f;
        r4 = r4 - r6;
        r4 = r4 / 2;
        r9 = r3 + r4;
        goto L_0x0105;
    L_0x0144:
        r3 = r19.getVisibility();
        r6 = 8;
        if (r3 == r6) goto L_0x01db;
    L_0x014c:
        r20 = r19.getMeasuredWidth();
        r21 = r19.getMeasuredHeight();
        r6 = -1;
        r3 = r19.getLayoutParams();
        r3 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r3;
        if (r15 == 0) goto L_0x0169;
    L_0x015d:
        r7 = r3.height;
        r22 = -1;
        r0 = r22;
        if (r7 == r0) goto L_0x0169;
    L_0x0165:
        r6 = r19.getBaseline();
    L_0x0169:
        r7 = r3.h;
        if (r7 >= 0) goto L_0x016e;
    L_0x016d:
        r7 = r11;
    L_0x016e:
        r7 = r7 & 112;
        switch(r7) {
            case 16: goto L_0x01ad;
            case 48: goto L_0x019c;
            case 80: goto L_0x01b9;
            default: goto L_0x0173;
        };
    L_0x0173:
        r6 = r8;
    L_0x0174:
        r0 = r23;
        r1 = r18;
        r7 = r0.a(r1);
        if (r7 == 0) goto L_0x01d7;
    L_0x017e:
        r0 = r23;
        r7 = r0.l;
        r7 = r7 + r9;
    L_0x0183:
        r9 = r3.leftMargin;
        r7 = r7 + r9;
        r9 = r7 + 0;
        r0 = r19;
        r1 = r20;
        r2 = r21;
        b(r0, r9, r6, r1, r2);
        r3 = r3.rightMargin;
        r3 = r3 + r20;
        r3 = r3 + 0;
        r9 = r7 + r3;
        r3 = r10 + 0;
        goto L_0x0122;
    L_0x019c:
        r7 = r3.topMargin;
        r7 = r7 + r8;
        r22 = -1;
        r0 = r22;
        if (r6 == r0) goto L_0x01d9;
    L_0x01a5:
        r22 = 1;
        r22 = r16[r22];
        r6 = r22 - r6;
        r6 = r6 + r7;
        goto L_0x0174;
    L_0x01ad:
        r6 = r13 - r21;
        r6 = r6 / 2;
        r6 = r6 + r8;
        r7 = r3.topMargin;
        r6 = r6 + r7;
        r7 = r3.bottomMargin;
        r6 = r6 - r7;
        goto L_0x0174;
    L_0x01b9:
        r7 = r12 - r21;
        r0 = r3.bottomMargin;
        r22 = r0;
        r7 = r7 - r22;
        r22 = -1;
        r0 = r22;
        if (r6 == r0) goto L_0x01d9;
    L_0x01c7:
        r22 = r19.getMeasuredHeight();
        r6 = r22 - r6;
        r22 = 2;
        r22 = r17[r22];
        r6 = r22 - r6;
        r6 = r7 - r6;
        goto L_0x0174;
    L_0x01d6:
        return;
    L_0x01d7:
        r7 = r9;
        goto L_0x0183;
    L_0x01d9:
        r6 = r7;
        goto L_0x0174;
    L_0x01db:
        r3 = r10;
        goto L_0x0122;
    L_0x01de:
        r5 = r4;
        r4 = r3;
        goto L_0x010e;
    L_0x01e2:
        r3 = r7;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutCompat.onLayout(boolean, int, int, int, int):void");
    }

    private static void b(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.d;
    }

    public void setGravity(int i) {
        if (this.e != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) == 0) {
                i2 |= 48;
            }
            this.e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.e & 8388615) != i2) {
            this.e = i2 | (this.e & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED;
        if ((this.e & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) != i2) {
            this.e = i2 | (this.e & -113);
            requestLayout();
        }
    }

    public LayoutParams a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams c() {
        if (this.d == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.d == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    protected LayoutParams b(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
        }
    }
}
