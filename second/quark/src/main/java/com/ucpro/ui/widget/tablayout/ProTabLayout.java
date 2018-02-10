package com.ucpro.ui.widget.tablayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.d.m;
import android.support.v4.d.p;
import android.support.v4.d.q;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.alibaba.wireless.security.SecExceptionCode;
import com.quark.browser.R;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.d;
import com.ucpro.ui.widget.viewpager.ProViewPager;
import com.ucpro.ui.widget.viewpager.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public class ProTabLayout extends HorizontalScrollView {
    private static final int[] F = new int[]{R.attr.colorPrimary};
    private static final q<c> a = new p(16);
    private w A;
    private final q<q> B;
    private boolean C;
    private int D;
    private boolean E;
    private final ArrayList<c> b;
    private c c;
    private final p d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private ColorStateList j;
    private float k;
    private float l;
    private final int m;
    private int n;
    private final int o;
    private final int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private d v;
    private x w;
    private ProViewPager x;
    private g y;
    private DataSetObserver z;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface Mode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface TabGravity {
    }

    public ProTabLayout(Context context) {
        this(context, null);
    }

    public ProTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new ArrayList();
        this.n = Integer.MAX_VALUE;
        this.u = true;
        this.B = new m(12);
        this.C = true;
        this.D = 1;
        this.E = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(F);
        boolean z = !obtainStyledAttributes.hasValue(0);
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
        setHorizontalScrollBarEnabled(false);
        this.d = new p(this, context);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        super.addView(this.d, 0, layoutParams);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, d.TabLayout, i, R.style.Widget.Design.TabLayout);
        this.d.b(obtainStyledAttributes2.getDimensionPixelSize(1, 0));
        this.d.c(obtainStyledAttributes2.getDimensionPixelSize(2, 0));
        this.d.d(obtainStyledAttributes2.getDimensionPixelSize(3, 0));
        this.d.a(obtainStyledAttributes2.getColor(0, 0));
        int dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(17, 0);
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        this.e = dimensionPixelSize;
        this.e = obtainStyledAttributes2.getDimensionPixelSize(13, this.e);
        this.f = obtainStyledAttributes2.getDimensionPixelSize(14, this.f);
        this.g = obtainStyledAttributes2.getDimensionPixelSize(15, this.g);
        this.h = obtainStyledAttributes2.getDimensionPixelSize(16, this.h);
        this.i = obtainStyledAttributes2.getResourceId(10, R.style.TextAppearance.Design.Tab);
        obtainStyledAttributes = context.obtainStyledAttributes(this.i, d.TextAppearance);
        try {
            this.k = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.j = obtainStyledAttributes.getColorStateList(3);
            if (obtainStyledAttributes2.hasValue(11)) {
                this.j = obtainStyledAttributes2.getColorStateList(11);
            }
            if (obtainStyledAttributes2.hasValue(12)) {
                this.j = b(this.j.getDefaultColor(), obtainStyledAttributes2.getColor(12, 0));
            }
            this.o = obtainStyledAttributes2.getDimensionPixelSize(8, -1);
            this.p = obtainStyledAttributes2.getDimensionPixelSize(9, -1);
            this.m = obtainStyledAttributes2.getResourceId(5, 0);
            this.r = obtainStyledAttributes2.getDimensionPixelSize(4, 0);
            this.t = obtainStyledAttributes2.getInt(6, 1);
            this.s = obtainStyledAttributes2.getInt(7, 0);
            obtainStyledAttributes2.recycle();
            Resources resources = getResources();
            this.l = (float) resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.q = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            d();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setTabTextSize(float f) {
        this.k = f;
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i) {
        this.d.a(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.d.b(i);
    }

    public void setSelectedTabIndicatorWidth(int i) {
        this.d.c(i);
    }

    public void setSelectedTabIndicatorRadius(int i) {
        this.d.d(i);
    }

    private void setScrollPosition$4867b5c2(int i) {
        a(i, 0.0f, true, true);
    }

    private void a(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0 && round < this.d.getChildCount()) {
            if (z2) {
                p pVar = this.d;
                if (pVar.c != null && pVar.c.a.b()) {
                    pVar.c.a.e();
                }
                pVar.a = i;
                pVar.b = f;
                pVar.a();
            }
            if (this.w != null && this.w.a.b()) {
                this.w.a.e();
            }
            scrollTo(a(i, f), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    private float getScrollPosition() {
        p pVar = this.d;
        return pVar.b + ((float) pVar.a);
    }

    public void setOnTabSelectedListener(d dVar) {
        this.v = dVar;
    }

    @NonNull
    public final c a() {
        c cVar;
        c cVar2 = (c) a.a();
        if (cVar2 == null) {
            cVar = new c();
        } else {
            cVar = cVar2;
        }
        cVar.g = this;
        q qVar = this.B != null ? (q) this.B.a() : null;
        if (qVar == null) {
            qVar = new q(this, getContext());
        }
        qVar.a(cVar);
        qVar.setFocusable(true);
        qVar.setMinimumWidth(getTabMinWidth());
        cVar.h = qVar;
        return cVar;
    }

    public int getTabCount() {
        return this.b.size();
    }

    @Nullable
    public final c a(int i) {
        return (c) this.b.get(i);
    }

    public int getSelectedTabPosition() {
        if (this.c != null) {
            return this.c.e;
        }
        return -1;
    }

    public final void b() {
        for (int childCount = this.d.getChildCount() - 1; childCount >= 0; childCount--) {
            q qVar = (q) this.d.getChildAt(childCount);
            this.d.removeViewAt(childCount);
            if (qVar != null) {
                q.a(qVar);
                this.B.a(qVar);
            }
            requestLayout();
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            it.remove();
            cVar.g = null;
            cVar.h = null;
            cVar.a = null;
            cVar.b = null;
            cVar.c = null;
            cVar.d = null;
            cVar.e = -1;
            cVar.f = null;
            a.a(cVar);
        }
        this.c = null;
    }

    public void setTabMode(int i) {
        if (i != this.t) {
            this.t = i;
            d();
            if (this.t == 0 && this.d != null && (this.d.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                ((FrameLayout.LayoutParams) this.d.getLayoutParams()).gravity = 16;
            }
        }
    }

    public int getTabMode() {
        return this.t;
    }

    public void setTabGravity(int i) {
        if (this.s != i) {
            this.s = i;
            d();
        }
    }

    public int getTabGravity() {
        return this.s;
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                ((c) this.b.get(i)).b();
            }
        }
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.j;
    }

    public final void a(int i, int i2) {
        setTabTextColors(b(i, i2));
    }

    public void setupWithViewPager(@Nullable ProViewPager proViewPager) {
        w wVar;
        if (!(this.x == null || this.A == null)) {
            ProViewPager proViewPager2 = this.x;
            wVar = this.A;
            if (proViewPager2.a != null) {
                proViewPager2.a.remove(wVar);
            }
        }
        if (proViewPager != null) {
            g adapter = proViewPager.getAdapter();
            if (adapter == null) {
                throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
            }
            this.x = proViewPager;
            if (this.A == null) {
                this.A = new w(this);
            }
            wVar = this.A;
            wVar.b = 0;
            wVar.a = 0;
            proViewPager.a(this.A);
            setOnTabSelectedListener(new g(proViewPager));
            a(adapter, true);
            return;
        }
        this.x = null;
        setOnTabSelectedListener(null);
        a(null, true);
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable g gVar) {
        a(gVar, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void a(@Nullable g gVar, boolean z) {
        if (!(this.y == null || this.z == null)) {
            g gVar2 = this.y;
            gVar2.a.unregisterObserver(this.z);
        }
        this.y = gVar;
        if (z && gVar != null) {
            if (this.z == null) {
                this.z = new j();
            }
            gVar.a.registerObserver(this.z);
        }
        c();
    }

    private void c() {
        b();
        if (this.y != null) {
            int i;
            int a = this.y.a();
            for (i = 0; i < a; i++) {
                a(a().a(this.y.a(i)), false);
            }
            if (this.x != null && a > 0) {
                i = this.x.getCurrentItem();
                if (i != getSelectedTabPosition() && i < getTabCount()) {
                    b(a(i), true);
                    return;
                }
                return;
            }
            return;
        }
        b();
    }

    public void addView(View view) {
        a(view);
    }

    public void addView(View view, int i) {
        a(view);
    }

    public void addView(View view, LayoutParams layoutParams) {
        a(view);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        a(view);
    }

    private void a(View view) {
        if (view instanceof TabItem) {
            TabItem tabItem = (TabItem) view;
            c a = a();
            if (tabItem.a != null) {
                a.a(tabItem.a);
            }
            if (tabItem.b != null) {
                a.b = tabItem.b;
                a.b();
            }
            if (tabItem.c != 0) {
                a.f = LayoutInflater.from(a.h.getContext()).inflate(tabItem.c, a.h, false);
                a.b();
            }
            a(a, this.b.isEmpty());
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.t == 1 && this.s == 0) {
            layoutParams.width = 0;
            layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private int b(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1;
        int b = (b(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case SectionHeader.SHT_LOUSER /*-2147483648*/:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(b, MeasureSpec.getSize(i2)), UCCore.VERIFY_POLICY_QUICK);
                break;
            case 0:
                i2 = MeasureSpec.makeMeasureSpec(b, UCCore.VERIFY_POLICY_QUICK);
                break;
        }
        b = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            if (this.p > 0) {
                b = this.p;
            } else {
                b -= b(56);
            }
            this.n = b;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.t) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        b = 0;
                        break;
                    } else {
                        b = 1;
                        break;
                    }
                case 1:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        i3 = 0;
                    }
                    b = i3;
                    break;
                default:
                    b = 0;
                    break;
            }
            if (b != 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    private void c(int i) {
        Object obj = null;
        if (i != -1) {
            if (getWindowToken() != null && ViewCompat.D(this)) {
                int i2;
                p pVar = this.d;
                int childCount = pVar.getChildCount();
                for (i2 = 0; i2 < childCount; i2++) {
                    if (pVar.getChildAt(i2).getWidth() <= 0) {
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    int scrollX = getScrollX();
                    i2 = a(i, 0.0f);
                    if (scrollX != i2) {
                        if (this.w == null) {
                            this.w = z.a();
                            this.w.a(o.b);
                            this.w.a((int) SecExceptionCode.SEC_ERROR_STA_ENC);
                            this.w.a(new e(this));
                        }
                        this.w.a.a(scrollX, i2);
                        this.w.a.a();
                    }
                    this.d.a(i, (int) SecExceptionCode.SEC_ERROR_STA_ENC);
                    return;
                }
            }
            setScrollPosition$4867b5c2(i);
        }
    }

    private void setSelectedTabView(int i) {
        int childCount = this.d.getChildCount();
        if (i < childCount && !this.d.getChildAt(i).isSelected()) {
            for (int i2 = 0; i2 < childCount; i2++) {
                boolean z;
                View childAt = this.d.getChildAt(i2);
                if (i2 == i) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    public void setTabClickable(boolean z) {
        this.u = z;
    }

    public final void b(c cVar, boolean z) {
        if (!this.u) {
            return;
        }
        if (this.c != cVar) {
            if (z) {
                int i;
                if (cVar != null) {
                    i = cVar.e;
                } else {
                    i = -1;
                }
                if (i != -1) {
                    setSelectedTabView(i);
                }
                if ((this.c == null || this.c.e == -1) && i != -1) {
                    setScrollPosition$4867b5c2(i);
                } else {
                    c(i);
                }
            }
            if (!(this.c == null || this.v == null)) {
                this.v.onTabUnselected(this.c);
            }
            this.c = cVar;
            if (this.c != null && this.v != null) {
                this.v.onTabSelected(this.c);
            }
        } else if (this.c != null) {
            if (this.v != null) {
                this.v.onTabReselected(this.c);
            }
            c(cVar.e);
        }
    }

    private int a(int i, float f) {
        int i2 = 0;
        if (this.t != 0) {
            return 0;
        }
        int width;
        View childAt = this.d.getChildAt(i);
        View childAt2 = i + 1 < this.d.getChildCount() ? this.d.getChildAt(i + 1) : null;
        if (childAt != null) {
            width = childAt.getWidth();
        } else {
            width = 0;
        }
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        return ((((int) ((((float) (i2 + width)) * f) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    private void d() {
        int max;
        if (this.t == 0) {
            max = Math.max(0, this.r - this.e);
        } else {
            max = 0;
        }
        ViewCompat.b(this.d, max, 0, 0, 0);
        switch (this.t) {
            case 0:
                this.d.setGravity(8388611);
                break;
            case 1:
                this.d.setGravity(1);
                break;
        }
        a(true);
    }

    private void a(boolean z) {
        for (int i = 0; i < this.d.getChildCount(); i++) {
            View childAt = this.d.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    public void setScrollableTabMinWidth(int i) {
        this.q = i;
    }

    public void setUseBoldTabStyle(boolean z) {
        this.C = z;
    }

    public void setTypeface(int i) {
        this.D = i;
    }

    public void setAllCaps(boolean z) {
        this.E = z;
    }

    private static ColorStateList b(int i, int i2) {
        r0 = new int[2][];
        int[] iArr = new int[]{SELECTED_STATE_SET, i2};
        r0[1] = EMPTY_STATE_SET;
        iArr[1] = i;
        return new ColorStateList(r0, iArr);
    }

    private int getDefaultHeight() {
        Object obj;
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            c cVar = (c) this.b.get(i);
            if (cVar != null && cVar.b != null && !TextUtils.isEmpty(cVar.c)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            return 72;
        }
        return 48;
    }

    private int getTabMinWidth() {
        if (this.o != -1) {
            return this.o;
        }
        return this.t == 0 ? this.q : 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    private int getTabMaxWidth() {
        return this.n;
    }

    public final void a(@NonNull c cVar, boolean z) {
        if (cVar.g != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        View view = cVar.h;
        p pVar = this.d;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        pVar.addView(view, layoutParams);
        if (z) {
            view.setSelected(true);
        }
        a(cVar, this.b.size());
        if (z) {
            cVar.a();
        }
    }

    private void a(c cVar, int i) {
        cVar.e = i;
        this.b.add(i, cVar);
        int size = this.b.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((c) this.b.get(i2)).e = i2;
        }
    }
}
