package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ca;
import android.support.v4.view.cx;
import android.support.v4.view.dw;
import android.support.v4.view.dx;
import android.support.v7.c.h;
import android.support.v7.c.k;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.u;
import android.support.v7.view.menu.z;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class Toolbar extends ViewGroup {
    private CharSequence A;
    private CharSequence B;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private final ArrayList<View> G;
    private final int[] H;
    private do I;
    private final bw J;
    private cx K;
    private boolean L;
    private final Runnable M;
    private final fb N;
    ActionMenuView a;
    TextView b;
    TextView c;
    View d;
    Context e;
    int f;
    int g;
    int h;
    final du i;
    final ArrayList<View> j;
    ActionMenuPresenter k;
    eg l;
    m m;
    z n;
    private ImageButton o;
    private ImageView p;
    private Drawable q;
    private CharSequence r;
    private ImageButton s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* compiled from: ProGuard */
    public class LayoutParams extends android.support.v7.app.ActionBar.LayoutParams {
        int b;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public LayoutParams() {
            this.b = 0;
            this.a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
            this.b = 0;
            this.b = layoutParams.b;
        }

        public LayoutParams(android.support.v7.app.ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super((android.view.ViewGroup.LayoutParams) marginLayoutParams);
            this.b = 0;
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }
    }

    /* compiled from: ProGuard */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new ft();
        int a;
        boolean b;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
            this.b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, k.toolbarStyle);
    }

    public Toolbar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new du();
        this.z = 8388627;
        this.G = new ArrayList();
        this.j = new ArrayList();
        this.H = new int[2];
        this.J = new cr(this);
        this.M = new fx(this);
        dh a = dh.a(getContext(), attributeSet, h.Toolbar, i);
        this.g = a.e(h.Toolbar_titleTextAppearance, 0);
        this.h = a.e(h.Toolbar_subtitleTextAppearance, 0);
        this.z = a.a.getInteger(h.Toolbar_android_gravity, this.z);
        this.t = 48;
        int b = a.b(h.Toolbar_titleMargins, 0);
        this.y = b;
        this.x = b;
        this.w = b;
        this.v = b;
        b = a.b(h.Toolbar_titleMarginStart, -1);
        if (b >= 0) {
            this.v = b;
        }
        b = a.b(h.Toolbar_titleMarginEnd, -1);
        if (b >= 0) {
            this.w = b;
        }
        b = a.b(h.Toolbar_titleMarginTop, -1);
        if (b >= 0) {
            this.x = b;
        }
        b = a.b(h.Toolbar_titleMarginBottom, -1);
        if (b >= 0) {
            this.y = b;
        }
        this.u = a.c(h.Toolbar_maxButtonHeight, -1);
        b = a.b(h.Toolbar_contentInsetStart, SectionHeader.SHT_LOUSER);
        int b2 = a.b(h.Toolbar_contentInsetEnd, SectionHeader.SHT_LOUSER);
        int c = a.c(h.Toolbar_contentInsetLeft, 0);
        int c2 = a.c(h.Toolbar_contentInsetRight, 0);
        du duVar = this.i;
        duVar.h = false;
        if (c != SectionHeader.SHT_LOUSER) {
            duVar.e = c;
            duVar.a = c;
        }
        if (c2 != SectionHeader.SHT_LOUSER) {
            duVar.f = c2;
            duVar.b = c2;
        }
        if (!(b == SectionHeader.SHT_LOUSER && b2 == SectionHeader.SHT_LOUSER)) {
            this.i.a(b, b2);
        }
        this.q = a.a(h.Toolbar_collapseIcon);
        this.r = a.c(h.Toolbar_collapseContentDescription);
        CharSequence c3 = a.c(h.Toolbar_title);
        if (!TextUtils.isEmpty(c3)) {
            setTitle(c3);
        }
        c3 = a.c(h.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c3)) {
            setSubtitle(c3);
        }
        this.e = getContext();
        setPopupTheme(a.e(h.Toolbar_popupTheme, 0));
        Drawable a2 = a.a(h.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c3 = a.c(h.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c3)) {
            setNavigationContentDescription(c3);
        }
        a2 = a.a(h.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        c3 = a.c(h.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c3)) {
            setLogoDescription(c3);
        }
        if (a.e(h.Toolbar_titleTextColor)) {
            setTitleTextColor(a.d(h.Toolbar_titleTextColor));
        }
        if (a.e(h.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.d(h.Toolbar_subtitleTextColor));
        }
        a.a.recycle();
        this.N = fb.a();
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.f != i) {
            this.f = i;
            if (i == 0) {
                this.e = getContext();
            } else {
                this.e = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f;
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        du duVar = this.i;
        if (i != 1) {
            z = false;
        }
        if (z != duVar.g) {
            duVar.g = z;
            if (!duVar.h) {
                duVar.a = duVar.e;
                duVar.b = duVar.f;
            } else if (z) {
                duVar.a = duVar.d != SectionHeader.SHT_LOUSER ? duVar.d : duVar.e;
                duVar.b = duVar.c != SectionHeader.SHT_LOUSER ? duVar.c : duVar.f;
            } else {
                duVar.a = duVar.c != SectionHeader.SHT_LOUSER ? duVar.c : duVar.e;
                duVar.b = duVar.d != SectionHeader.SHT_LOUSER ? duVar.d : duVar.f;
            }
        }
    }

    public void setLogo(@DrawableRes int i) {
        setLogo(this.N.a(getContext(), i, false));
    }

    public final boolean a() {
        if (this.a != null) {
            boolean z;
            ActionMenuView actionMenuView = this.a;
            if (actionMenuView.c == null || !actionMenuView.c.g()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean b() {
        if (this.a != null) {
            boolean z;
            ActionMenuView actionMenuView = this.a;
            if (actionMenuView.c == null || !actionMenuView.c.c()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            f();
            if (!d(this.p)) {
                a(this.p, true);
            }
        } else if (this.p != null && d(this.p)) {
            removeView(this.p);
            this.j.remove(this.p);
        }
        if (this.p != null) {
            this.p.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.p != null ? this.p.getDrawable() : null;
    }

    public void setLogoDescription(@StringRes int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            f();
        }
        if (this.p != null) {
            this.p.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.p != null ? this.p.getContentDescription() : null;
    }

    private void f() {
        if (this.p == null) {
            this.p = new ImageView(getContext());
        }
    }

    public final void c() {
        i iVar = this.l == null ? null : this.l.b;
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.A;
    }

    public void setTitle(@StringRes int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.b == null) {
                Context context = getContext();
                this.b = new TextView(context);
                this.b.setSingleLine();
                this.b.setEllipsize(TruncateAt.END);
                if (this.g != 0) {
                    this.b.setTextAppearance(context, this.g);
                }
                if (this.C != 0) {
                    this.b.setTextColor(this.C);
                }
            }
            if (!d(this.b)) {
                a(this.b, true);
            }
        } else if (this.b != null && d(this.b)) {
            removeView(this.b);
            this.j.remove(this.b);
        }
        if (this.b != null) {
            this.b.setText(charSequence);
        }
        this.A = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.B;
    }

    public void setSubtitle(@StringRes int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.c == null) {
                Context context = getContext();
                this.c = new TextView(context);
                this.c.setSingleLine();
                this.c.setEllipsize(TruncateAt.END);
                if (this.h != 0) {
                    this.c.setTextAppearance(context, this.h);
                }
                if (this.D != 0) {
                    this.c.setTextColor(this.D);
                }
            }
            if (!d(this.c)) {
                a(this.c, true);
            }
        } else if (this.c != null && d(this.c)) {
            removeView(this.c);
            this.j.remove(this.c);
        }
        if (this.c != null) {
            this.c.setText(charSequence);
        }
        this.B = charSequence;
    }

    public void setTitleTextColor(@ColorInt int i) {
        this.C = i;
        if (this.b != null) {
            this.b.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(@ColorInt int i) {
        this.D = i;
        if (this.c != null) {
            this.c.setTextColor(i);
        }
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        return this.o != null ? this.o.getContentDescription() : null;
    }

    public void setNavigationContentDescription(@StringRes int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            h();
        }
        if (this.o != null) {
            this.o.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(@DrawableRes int i) {
        setNavigationIcon(this.N.a(getContext(), i, false));
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            h();
            if (!d(this.o)) {
                a(this.o, true);
            }
        } else if (this.o != null && d(this.o)) {
            removeView(this.o);
            this.j.remove(this.o);
        }
        if (this.o != null) {
            this.o.setImageDrawable(drawable);
        }
    }

    @Nullable
    public Drawable getNavigationIcon() {
        return this.o != null ? this.o.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        h();
        this.o.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        g();
        return this.a.getMenu();
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        g();
        this.a.setOverflowIcon(drawable);
    }

    @Nullable
    public Drawable getOverflowIcon() {
        g();
        return this.a.getOverflowIcon();
    }

    private void g() {
        d();
        if (this.a.a == null) {
            u uVar = (u) this.a.getMenu();
            if (this.l == null) {
                this.l = new eg();
            }
            this.a.setExpandedActionViewsExclusive(true);
            uVar.a(this.l, this.e);
        }
    }

    final void d() {
        if (this.a == null) {
            this.a = new ActionMenuView(getContext());
            this.a.setPopupTheme(this.f);
            this.a.setOnMenuItemClickListener(this.J);
            this.a.a(this.m, this.n);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.a = 8388613 | (this.t & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED);
            this.a.setLayoutParams(layoutParams);
            a(this.a, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new android.support.v7.view.i(getContext());
    }

    public void setOnMenuItemClickListener(do doVar) {
        this.I = doVar;
    }

    public int getContentInsetStart() {
        du duVar = this.i;
        return duVar.g ? duVar.b : duVar.a;
    }

    public int getContentInsetEnd() {
        du duVar = this.i;
        return duVar.g ? duVar.a : duVar.b;
    }

    public int getContentInsetLeft() {
        return this.i.a;
    }

    public int getContentInsetRight() {
        return this.i.b;
    }

    private void h() {
        if (this.o == null) {
            this.o = new ImageButton(getContext(), null, k.toolbarNavigationButtonStyle);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.a = 8388611 | (this.t & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED);
            this.o.setLayoutParams(layoutParams);
        }
    }

    private void a(View view, boolean z) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams();
        } else if (checkLayoutParams(layoutParams)) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        } else {
            layoutParams = a(layoutParams);
        }
        layoutParams.b = 1;
        if (!z || this.d == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.j.add(view);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.l == null || this.l.b == null)) {
            savedState.a = this.l.b.getItemId();
        }
        savedState.b = a();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            Menu menu;
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.a != null) {
                menu = this.a.a;
            } else {
                menu = null;
            }
            if (!(savedState.a == 0 || this.l == null || menu == null)) {
                MenuItem findItem = menu.findItem(savedState.a);
                if (findItem != null) {
                    dw.b(findItem);
                }
            }
            if (savedState.b) {
                removeCallbacks(this.M);
                post(this.M);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.M);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = cx.a(motionEvent);
        if (a == 0) {
            this.E = false;
        }
        if (!this.E) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.E = true;
            }
        }
        if (a == 1 || a == 3) {
            this.E = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = cx.a(motionEvent);
        if (a == 9) {
            this.F = false;
        }
        if (!this.F) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.F = true;
            }
        }
        if (a == 10 || a == 3) {
            this.F = false;
        }
        return true;
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + 0, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != UCCore.VERIFY_POLICY_QUICK && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i4, UCCore.VERIFY_POLICY_QUICK);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int a;
        int i5;
        Object obj;
        int[] iArr = this.H;
        if (co.a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i6 = 0;
        if (a(this.o)) {
            a(this.o, i, 0, i2, this.u);
            i6 = this.o.getMeasuredWidth() + b(this.o);
            max = Math.max(0, this.o.getMeasuredHeight() + c(this.o));
            a = co.a(0, ViewCompat.l(this.o));
            i5 = max;
        } else {
            a = 0;
            i5 = 0;
        }
        if (a(this.s)) {
            a(this.s, i, 0, i2, this.u);
            i6 = this.s.getMeasuredWidth() + b(this.s);
            i5 = Math.max(i5, this.s.getMeasuredHeight() + c(this.s));
            a = co.a(a, ViewCompat.l(this.s));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = Math.max(contentInsetStart, i6) + 0;
        iArr[i4] = Math.max(0, contentInsetStart - i6);
        i6 = 0;
        if (a(this.a)) {
            a(this.a, i, max2, i2, this.u);
            i6 = this.a.getMeasuredWidth() + b(this.a);
            i5 = Math.max(i5, this.a.getMeasuredHeight() + c(this.a));
            a = co.a(a, ViewCompat.l(this.a));
        }
        contentInsetStart = getContentInsetEnd();
        max2 += Math.max(contentInsetStart, i6);
        iArr[i3] = Math.max(0, contentInsetStart - i6);
        if (a(this.d)) {
            max2 += a(this.d, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.d.getMeasuredHeight() + c(this.d));
            a = co.a(a, ViewCompat.l(this.d));
        }
        if (a(this.p)) {
            max2 += a(this.p, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.p.getMeasuredHeight() + c(this.p));
            a = co.a(a, ViewCompat.l(this.p));
        }
        i4 = getChildCount();
        i3 = 0;
        int i7 = a;
        int i8 = i5;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).b == 0 && a(childAt)) {
                max2 += a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + c(childAt));
                i6 = co.a(i7, ViewCompat.l(childAt));
                contentInsetStart = max;
            } else {
                i6 = i7;
                contentInsetStart = i8;
            }
            i3++;
            i7 = i6;
            i8 = contentInsetStart;
        }
        contentInsetStart = 0;
        i6 = 0;
        int i9 = this.x + this.y;
        max = this.v + this.w;
        if (a(this.b)) {
            a(this.b, i, max2 + max, i2, i9, iArr);
            contentInsetStart = b(this.b) + this.b.getMeasuredWidth();
            i6 = this.b.getMeasuredHeight() + c(this.b);
            i7 = co.a(i7, ViewCompat.l(this.b));
        }
        if (a(this.c)) {
            contentInsetStart = Math.max(contentInsetStart, a(this.c, i, max2 + max, i2, i9 + i6, iArr));
            i6 += this.c.getMeasuredHeight() + c(this.c);
            i7 = co.a(i7, ViewCompat.l(this.c));
        }
        contentInsetStart += max2;
        i6 = Math.max(i8, i6) + (getPaddingTop() + getPaddingBottom());
        int i10 = i;
        max = ViewCompat.a(Math.max(contentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i10, -16777216 & i7);
        i6 = ViewCompat.a(Math.max(i6, getSuggestedMinimumHeight()), i2, i7 << 16);
        if (this.L) {
            max2 = getChildCount();
            for (contentInsetStart = 0; contentInsetStart < max2; contentInsetStart++) {
                View childAt2 = getChildAt(contentInsetStart);
                if (a(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i6 = 0;
        }
        setMeasuredDimension(max, i6);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj;
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int paddingTop;
        int measuredWidth;
        if (ViewCompat.h(this) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.H;
        iArr[1] = 0;
        iArr[0] = 0;
        int p = ViewCompat.p(this);
        if (!a(this.o)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = b(this.o, i8, iArr, p);
            i5 = paddingLeft;
        } else {
            i5 = a(this.o, paddingLeft, iArr, p);
        }
        if (a(this.s)) {
            if (obj != null) {
                i8 = b(this.s, i8, iArr, p);
            } else {
                i5 = a(this.s, i5, iArr, p);
            }
        }
        if (a(this.a)) {
            if (obj != null) {
                i5 = a(this.a, i5, iArr, p);
            } else {
                i8 = b(this.a, i8, iArr, p);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i8));
        i5 = Math.max(i5, getContentInsetLeft());
        i8 = Math.min(i8, (width - paddingRight) - getContentInsetRight());
        if (a(this.d)) {
            if (obj != null) {
                i8 = b(this.d, i8, iArr, p);
            } else {
                i5 = a(this.d, i5, iArr, p);
            }
        }
        if (!a(this.p)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = b(this.p, i8, iArr, p);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = a(this.p, i5, iArr, p);
        }
        boolean a = a(this.b);
        boolean a2 = a(this.c);
        i5 = 0;
        if (a) {
            LayoutParams layoutParams = (LayoutParams) this.b.getLayoutParams();
            i5 = (layoutParams.bottomMargin + (layoutParams.topMargin + this.b.getMeasuredHeight())) + 0;
        }
        if (a2) {
            layoutParams = (LayoutParams) this.c.getLayoutParams();
            measuredHeight = (layoutParams.bottomMargin + (layoutParams.topMargin + this.c.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            layoutParams = (LayoutParams) (a ? this.b : this.c).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) (a2 ? this.c : this.b).getLayoutParams();
            Object obj2 = ((!a || this.b.getMeasuredWidth() <= 0) && (!a2 || this.c.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.z & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) {
                case 48:
                    paddingTop = (layoutParams.topMargin + getPaddingTop()) + this.x;
                    break;
                case 80:
                    paddingTop = (((height - paddingBottom) - layoutParams2.bottomMargin) - this.y) - measuredHeight;
                    break;
                default:
                    paddingTop = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop < layoutParams.topMargin + this.x) {
                        i8 = layoutParams.topMargin + this.x;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop) - paddingTop2;
                        if (measuredHeight < layoutParams.bottomMargin + this.y) {
                            i8 = Math.max(0, paddingTop - ((layoutParams2.bottomMargin + this.y) - measuredHeight));
                        } else {
                            i8 = paddingTop;
                        }
                    }
                    paddingTop = paddingTop2 + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.v : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (a) {
                    layoutParams = (LayoutParams) this.b.getLayoutParams();
                    measuredWidth = i5 - this.b.getMeasuredWidth();
                    i6 = this.b.getMeasuredHeight() + paddingTop;
                    this.b.layout(measuredWidth, paddingTop, i5, i6);
                    paddingTop = i6 + layoutParams.bottomMargin;
                    i6 = measuredWidth - this.w;
                } else {
                    i6 = i5;
                }
                if (a2) {
                    layoutParams = (LayoutParams) this.c.getLayoutParams();
                    measuredWidth = layoutParams.topMargin + paddingTop;
                    this.c.layout(i5 - this.c.getMeasuredWidth(), measuredWidth, i5, this.c.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i5 - this.w;
                    i8 = layoutParams.bottomMargin;
                    i8 = measuredWidth;
                } else {
                    i8 = i5;
                }
                if (obj2 != null) {
                    i8 = Math.min(i6, i8);
                } else {
                    i8 = i5;
                }
                i6 = i8;
            } else {
                i8 = (obj2 != null ? this.v : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (a) {
                    layoutParams = (LayoutParams) this.b.getLayoutParams();
                    i5 = this.b.getMeasuredWidth() + i7;
                    measuredWidth = this.b.getMeasuredHeight() + paddingTop;
                    this.b.layout(i7, paddingTop, i5, measuredWidth);
                    i8 = layoutParams.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.w;
                    i5 = i8;
                } else {
                    measuredWidth = i7;
                    i5 = paddingTop;
                }
                if (a2) {
                    layoutParams = (LayoutParams) this.c.getLayoutParams();
                    i5 += layoutParams.topMargin;
                    paddingTop = this.c.getMeasuredWidth() + i7;
                    this.c.layout(i7, i5, paddingTop, this.c.getMeasuredHeight() + i5);
                    i5 = this.w + paddingTop;
                    i8 = layoutParams.bottomMargin;
                    i8 = i5;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        a(this.G, 3);
        int size = this.G.size();
        measuredWidth = i7;
        for (i5 = 0; i5 < size; i5++) {
            measuredWidth = a((View) this.G.get(i5), measuredWidth, iArr, p);
        }
        a(this.G, 5);
        i7 = this.G.size();
        i5 = 0;
        measuredHeight = i6;
        while (i5 < i7) {
            i6 = b((View) this.G.get(i5), measuredHeight, iArr, p);
            i5++;
            measuredHeight = i6;
        }
        a(this.G, 1);
        List list = this.G;
        i6 = iArr[0];
        i7 = iArr[1];
        paddingTop2 = list.size();
        size = i6;
        paddingTop = i7;
        i6 = 0;
        i7 = 0;
        while (i6 < paddingTop2) {
            View view = (View) list.get(i6);
            layoutParams = (LayoutParams) view.getLayoutParams();
            size = layoutParams.leftMargin - size;
            i8 = layoutParams.rightMargin - paddingTop;
            paddingBottom = Math.max(0, size);
            int max = Math.max(0, i8);
            size = Math.max(0, -size);
            paddingTop = Math.max(0, -i8);
            i6++;
            i7 += (view.getMeasuredWidth() + paddingBottom) + max;
        }
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (i7 / 2);
        i5 = i8 + i7;
        if (i8 < measuredWidth) {
            i8 = measuredWidth;
        } else if (i5 > measuredHeight) {
            i8 -= i5 - measuredHeight;
        }
        paddingLeft = this.G.size();
        measuredWidth = 0;
        i5 = i8;
        while (measuredWidth < paddingLeft) {
            i8 = a((View) this.G.get(measuredWidth), i5, iArr, p);
            measuredWidth++;
            i5 = i8;
        }
        this.G.clear();
    }

    private int a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (layoutParams.rightMargin + measuredWidth) + max;
    }

    private int b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    private int a(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i3 = layoutParams.a & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED;
        switch (i3) {
            case 16:
            case 48:
            case 80:
                break;
            default:
                i3 = this.z & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED;
                break;
        }
        switch (i3) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
            default:
                int i4;
                i3 = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - i3) - paddingBottom) - measuredHeight) / 2;
                if (i2 < layoutParams.topMargin) {
                    i4 = layoutParams.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - i3;
                    i4 = measuredHeight < layoutParams.bottomMargin ? Math.max(0, i2 - (layoutParams.bottomMargin - measuredHeight)) : i2;
                }
                return i4 + i3;
        }
    }

    private void a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (ViewCompat.h(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = ca.a(i, ViewCompat.h(this));
        list.clear();
        LayoutParams layoutParams;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.b == 0 && a(childAt) && a(layoutParams.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams.b == 0 && a(childAt2) && a(layoutParams.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int a(int i) {
        int h = ViewCompat.h(this);
        int a = ca.a(i, h) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return h == 1 ? 5 : 3;
        }
    }

    private boolean a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private static int b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return dx.b(marginLayoutParams) + dx.a(marginLayoutParams);
    }

    private static int c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private static LayoutParams a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof android.support.v7.app.ActionBar.LayoutParams) {
            return new LayoutParams((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected static LayoutParams e() {
        return new LayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public bt getWrapper() {
        if (this.K == null) {
            this.K = new cx(this);
        }
        return this.K;
    }

    private boolean d(View view) {
        return view.getParent() == this || this.j.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.L = z;
        requestLayout();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    static /* synthetic */ void b(Toolbar toolbar) {
        if (toolbar.s == null) {
            toolbar.s = new ImageButton(toolbar.getContext(), null, k.toolbarNavigationButtonStyle);
            toolbar.s.setImageDrawable(toolbar.q);
            toolbar.s.setContentDescription(toolbar.r);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.a = 8388611 | (toolbar.t & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED);
            layoutParams.b = 2;
            toolbar.s.setLayoutParams(layoutParams);
            toolbar.s.setOnClickListener(new cq(toolbar));
        }
    }
}
