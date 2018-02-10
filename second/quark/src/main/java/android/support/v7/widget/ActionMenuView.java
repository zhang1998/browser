package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.c;
import android.support.v7.view.menu.d;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.t;
import android.support.v7.view.menu.u;
import android.support.v7.view.menu.z;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public class ActionMenuView extends LinearLayoutCompat implements d, t {
    u a;
    boolean b;
    ActionMenuPresenter c;
    private Context d;
    private int e;
    private m f;
    private z g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private bw l;

    /* compiled from: ProGuard */
    public class LayoutParams extends android.support.v7.widget.LinearLayoutCompat.LayoutParams {
        @ExportedProperty
        public boolean a;
        @ExportedProperty
        public int b;
        @ExportedProperty
        public int c;
        @ExportedProperty
        public boolean d;
        @ExportedProperty
        public boolean e;
        boolean f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.a = layoutParams.a;
        }

        public LayoutParams() {
            super(-2, -2);
            this.a = false;
        }
    }

    public final /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams a(AttributeSet attributeSet) {
        return b(attributeSet);
    }

    protected final /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams b(android.view.ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    protected final /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams c() {
        return d();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return d();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return b(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.j = (int) (56.0f * f);
        this.k = (int) (f * 4.0f);
        this.d = context;
        this.e = 0;
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.e != i) {
            this.e = i;
            if (i == 0) {
                this.d = getContext();
            } else {
                this.d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.e;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.c = actionMenuPresenter;
        this.c.a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.c != null) {
            this.c.a(false);
            if (this.c.g()) {
                this.c.d();
                this.c.c();
            }
        }
    }

    public void setOnMenuItemClickListener(bw bwVar) {
        this.l = bwVar;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.h;
        this.h = MeasureSpec.getMode(i) == UCCore.VERIFY_POLICY_QUICK;
        if (z != this.h) {
            this.i = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.h || this.a == null || size == this.i)) {
            this.i = size;
            this.a.b(true);
        }
        int childCount = getChildCount();
        int i3;
        if (!this.h || childCount <= 0) {
            for (i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i2);
        size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        i3 = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i4 = size - i3;
        int i5 = i4 / this.j;
        size = i4 % this.j;
        if (i5 == 0) {
            setMeasuredDimension(i4, 0);
            return;
        }
        int i6;
        Object obj;
        Object obj2;
        int i7 = this.j + (size / i5);
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        i3 = 0;
        Object obj3 = null;
        long j = 0;
        int childCount2 = getChildCount();
        int i11 = 0;
        while (i11 < childCount2) {
            int i12;
            int i13;
            long j2;
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                boolean z2 = childAt instanceof ActionMenuItemView;
                i6 = i3 + 1;
                if (z2) {
                    childAt.setPadding(this.k, 0, this.k, 0);
                }
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f = false;
                layoutParams.c = 0;
                layoutParams.b = 0;
                layoutParams.d = false;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                z = z2 && ((ActionMenuItemView) childAt).b();
                layoutParams.e = z;
                if (layoutParams.a) {
                    i3 = 1;
                } else {
                    i3 = i5;
                }
                int a = a(childAt, i7, i3, childMeasureSpec, paddingTop);
                i9 = Math.max(i9, a);
                if (layoutParams.d) {
                    i3 = i10 + 1;
                } else {
                    i3 = i10;
                }
                if (layoutParams.a) {
                    obj = 1;
                } else {
                    obj = obj3;
                }
                int i14 = i5 - a;
                i10 = Math.max(i8, childAt.getMeasuredHeight());
                if (a == 1) {
                    long j3 = ((long) (1 << i11)) | j;
                    i12 = i10;
                    i13 = i14;
                    i10 = i3;
                    obj3 = obj;
                    j2 = j3;
                    i5 = i9;
                    childCount = i6;
                } else {
                    childCount = i6;
                    i5 = i9;
                    long j4 = j;
                    i12 = i10;
                    i13 = i14;
                    obj3 = obj;
                    i10 = i3;
                    j2 = j4;
                }
            } else {
                childCount = i3;
                j2 = j;
                i12 = i8;
                i13 = i5;
                i5 = i9;
            }
            i11++;
            i9 = i5;
            i8 = i12;
            i5 = i13;
            j = j2;
            i3 = childCount;
        }
        if (obj3 == null || i3 != 2) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        Object obj4 = null;
        long j5 = j;
        paddingTop = i5;
        while (i10 > 0 && paddingTop > 0) {
            i6 = Integer.MAX_VALUE;
            j = 0;
            i5 = 0;
            int i15 = 0;
            while (i15 < childCount2) {
                layoutParams = (LayoutParams) getChildAt(i15).getLayoutParams();
                if (layoutParams.d) {
                    if (layoutParams.b < i6) {
                        i5 = layoutParams.b;
                        j = (long) (1 << i15);
                        size = 1;
                    } else if (layoutParams.b == i6) {
                        j |= (long) (1 << i15);
                        size = i5 + 1;
                        i5 = i6;
                    }
                    i15++;
                    i6 = i5;
                    i5 = size;
                }
                size = i5;
                i5 = i6;
                i15++;
                i6 = i5;
                i5 = size;
            }
            j5 |= j;
            if (i5 > paddingTop) {
                break;
            }
            i15 = i6 + 1;
            i6 = 0;
            i5 = paddingTop;
            long j6 = j5;
            while (i6 < childCount2) {
                View childAt2 = getChildAt(i6);
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if ((((long) (1 << i6)) & j) != 0) {
                    if (obj2 != null && layoutParams.e && i5 == 1) {
                        childAt2.setPadding(this.k + i7, 0, this.k, 0);
                    }
                    layoutParams.b++;
                    layoutParams.f = true;
                    size = i5 - 1;
                } else if (layoutParams.b == i15) {
                    j6 |= (long) (1 << i6);
                    size = i5;
                } else {
                    size = i5;
                }
                i6++;
                i5 = size;
            }
            j5 = j6;
            i11 = 1;
            paddingTop = i5;
        }
        j = j5;
        obj = (obj3 == null && i3 == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= i3 - 1 && obj == null && i9 <= 1)) {
            obj2 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((LayoutParams) getChildAt(0).getLayoutParams()).e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount2 - 1))) & j) == 0 || ((LayoutParams) getChildAt(childCount2 - 1).getLayoutParams()).e)) {
                    f = bitCount - 0.5f;
                    if (f <= 0.0f) {
                        i3 = (int) (((float) (paddingTop * i7)) / f);
                    } else {
                        i3 = 0;
                    }
                    i5 = 0;
                    obj2 = obj4;
                    while (i5 < childCount2) {
                        if ((((long) (1 << i5)) & j) != 0) {
                            childAt3 = getChildAt(i5);
                            layoutParams = (LayoutParams) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                layoutParams.c = i3;
                                layoutParams.f = true;
                                if (i5 == 0 && !layoutParams.e) {
                                    layoutParams.leftMargin = (-i3) / 2;
                                }
                                obj = 1;
                            } else if (layoutParams.a) {
                                if (i5 != 0) {
                                    layoutParams.leftMargin = i3 / 2;
                                }
                                if (i5 != childCount2 - 1) {
                                    layoutParams.rightMargin = i3 / 2;
                                }
                            } else {
                                layoutParams.c = i3;
                                layoutParams.f = true;
                                layoutParams.rightMargin = (-i3) / 2;
                                obj = 1;
                            }
                            i5++;
                            obj2 = obj;
                        }
                        obj = obj2;
                        i5++;
                        obj2 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
                i3 = 0;
            } else {
                i3 = (int) (((float) (paddingTop * i7)) / f);
            }
            i5 = 0;
            obj2 = obj4;
            while (i5 < childCount2) {
                if ((((long) (1 << i5)) & j) != 0) {
                    childAt3 = getChildAt(i5);
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams.c = i3;
                        layoutParams.f = true;
                        layoutParams.leftMargin = (-i3) / 2;
                        obj = 1;
                    } else if (layoutParams.a) {
                        if (i5 != 0) {
                            layoutParams.leftMargin = i3 / 2;
                        }
                        if (i5 != childCount2 - 1) {
                            layoutParams.rightMargin = i3 / 2;
                        }
                    } else {
                        layoutParams.c = i3;
                        layoutParams.f = true;
                        layoutParams.rightMargin = (-i3) / 2;
                        obj = 1;
                    }
                    i5++;
                    obj2 = obj;
                }
                obj = obj2;
                i5++;
                obj2 = obj;
            }
        }
        if (obj2 != null) {
            for (i3 = 0; i3 < childCount2; i3++) {
                childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(layoutParams.c + (layoutParams.b * i7), UCCore.VERIFY_POLICY_QUICK), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i8 = size2;
        }
        setMeasuredDimension(i4, i8);
    }

    static int a(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        boolean z2 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        if (actionMenuItemView == null || !actionMenuItemView.b()) {
            z = false;
        } else {
            z = true;
        }
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, SectionHeader.SHT_LOUSER), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z && r1 < 2) {
                i5 = 2;
            }
        }
        if (!layoutParams.a && z) {
            z2 = true;
        }
        layoutParams.d = z2;
        layoutParams.b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, UCCore.VERIFY_POLICY_QUICK), makeMeasureSpec);
        return i5;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.h) {
            LayoutParams layoutParams;
            int measuredWidth;
            int paddingLeft;
            int i5;
            int childCount = getChildCount();
            int i6 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i7 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = co.a(this);
            int i8 = 0;
            while (i8 < childCount) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.a) {
                        measuredWidth = childAt.getMeasuredWidth();
                        if (a(i8)) {
                            measuredWidth += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = layoutParams.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + measuredWidth;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                            paddingLeft = i5 - measuredWidth;
                        }
                        int i9 = i6 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i9, i5, measuredHeight + i9);
                        paddingLeft = paddingRight - measuredWidth;
                        obj = 1;
                        measuredWidth = i7;
                    } else {
                        paddingLeft = paddingRight - (layoutParams.rightMargin + (childAt.getMeasuredWidth() + layoutParams.leftMargin));
                        a(i8);
                        measuredWidth = i7 + 1;
                    }
                } else {
                    paddingLeft = paddingRight;
                    measuredWidth = i7;
                }
                i8++;
                i7 = measuredWidth;
                paddingRight = paddingLeft;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                measuredWidth = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (measuredWidth / 2);
                i7 = i6 - (i5 / 2);
                childAt2.layout(paddingRight, i7, measuredWidth + paddingRight, i5 + i7);
                return;
            }
            paddingLeft = i7 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            int i10;
            if (a) {
                measuredWidth = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8 || layoutParams.a) {
                        paddingLeft = measuredWidth;
                    } else {
                        measuredWidth -= layoutParams.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        dividerWidth = childAt3.getMeasuredHeight();
                        i10 = i6 - (dividerWidth / 2);
                        childAt3.layout(measuredWidth - i8, i10, measuredWidth, dividerWidth + i10);
                        paddingLeft = measuredWidth - ((layoutParams.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    measuredWidth = paddingLeft;
                }
                return;
            }
            measuredWidth = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                layoutParams = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8 || layoutParams.a) {
                    paddingLeft = measuredWidth;
                } else {
                    measuredWidth += layoutParams.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    dividerWidth = childAt3.getMeasuredHeight();
                    i10 = i6 - (dividerWidth / 2);
                    childAt3.layout(measuredWidth, i10, measuredWidth + i8, dividerWidth + i10);
                    paddingLeft = ((layoutParams.rightMargin + i8) + paddingRight) + measuredWidth;
                }
                i5++;
                measuredWidth = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.c;
        if (actionMenuPresenter.i != null) {
            actionMenuPresenter.i.setImageDrawable(drawable);
            return;
        }
        actionMenuPresenter.k = true;
        actionMenuPresenter.j = drawable;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.c;
        if (actionMenuPresenter.i != null) {
            return actionMenuPresenter.i.getDrawable();
        }
        if (actionMenuPresenter.k) {
            return actionMenuPresenter.j;
        }
        return null;
    }

    public void setOverflowReserved(boolean z) {
        this.b = z;
    }

    private static LayoutParams d() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.h = 16;
        return layoutParams;
    }

    private LayoutParams b(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected static LayoutParams a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return d();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.h > 0) {
            return layoutParams2;
        }
        layoutParams2.h = 16;
        return layoutParams2;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public static LayoutParams a() {
        LayoutParams d = d();
        d.a = true;
        return d;
    }

    public final boolean a(i iVar) {
        return this.a.a((MenuItem) iVar, null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final void a(u uVar) {
        this.a = uVar;
    }

    public Menu getMenu() {
        if (this.a == null) {
            m mVar;
            Context context = getContext();
            this.a = new u(context);
            this.a.a(new eq());
            this.c = new ActionMenuPresenter(context);
            this.c.a();
            c cVar = this.c;
            if (this.f != null) {
                mVar = this.f;
            } else {
                mVar = new cf();
            }
            cVar.f = mVar;
            this.a.a(this.c, this.d);
            this.c.a(this);
        }
        return this.a;
    }

    public final void a(m mVar, z zVar) {
        this.f = mVar;
        this.g = zVar;
    }

    public final void b() {
        if (this.c != null) {
            this.c.e();
        }
    }

    private boolean a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof eu)) {
            z = ((eu) childAt).d() | 0;
        }
        return (i <= 0 || !(childAt2 instanceof eu)) ? z : ((eu) childAt2).c() | z;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.c.n = z;
    }
}
