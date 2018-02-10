package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.bg;
import android.support.v4.view.bo;
import android.support.v4.view.ea;
import android.support.v4.widget.l;
import android.support.v7.c.j;
import android.support.v7.c.k;
import android.support.v7.view.menu.m;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;
import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.crashsdk.export.LogType;

/* compiled from: ProGuard */
public class ActionBarOverlayLayout extends ViewGroup implements bg, ds {
    static final int[] b = new int[]{k.actionBarSize, 16842841};
    private final Runnable A;
    private final ea B;
    public boolean a;
    private int c;
    private int d;
    private ContentFrameLayout e;
    private ActionBarContainer f;
    private bt g;
    private Drawable h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private final Rect o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private cl u;
    private final int v;
    private l w;
    private bo x;
    private final android.support.v4.view.l y;
    private final Runnable z;

    /* compiled from: ProGuard */
    public class LayoutParams extends MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.v = SecExceptionCode.SEC_ERROR_SIGNATRUE;
        this.y = new ca(this);
        this.z = new dr(this);
        this.A = new dm(this);
        a(context);
        this.B = new ea(this);
    }

    private void a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(b);
        this.c = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.h = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.h == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.i = z;
        this.w = l.a(context, null);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    public void setActionBarVisibilityCallback(cl clVar) {
        this.u = clVar;
        if (getWindowToken() != null) {
            this.u.a(this.d);
            if (this.n != 0) {
                onWindowSystemUiVisibilityChanged(this.n);
                ViewCompat.u(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.a = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.i = z2;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.j = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        a(getContext());
        ViewCompat.u(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        h();
        int i2 = this.n ^ i;
        this.n = i;
        boolean z3 = (i & 4) == 0;
        if ((i & LogType.UNEXP) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.u != null) {
            cl clVar = this.u;
            if (z) {
                z2 = false;
            }
            clVar.d(z2);
            if (z3 || !z) {
                this.u.h();
            } else {
                this.u.i();
            }
        }
        if ((i2 & LogType.UNEXP) != 0 && this.u != null) {
            ViewCompat.u(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.d = i;
        if (this.u != null) {
            this.u.a(i);
        }
    }

    private static boolean a(View view, Rect rect, boolean z) {
        boolean z2 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z2 = true;
        }
        if (layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z2 = true;
        }
        if (layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z2 = true;
        }
        if (!z || layoutParams.bottomMargin == rect.bottom) {
            return z2;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        h();
        ViewCompat.t(this);
        boolean a = a(this.f, rect, false);
        this.r.set(rect);
        co.a(this, this.r, this.o);
        if (!this.p.equals(this.o)) {
            this.p.set(this.o);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        h();
        measureChildWithMargins(this.f, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.f.getLayoutParams();
        int max = Math.max(0, (this.f.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        int max2 = Math.max(0, layoutParams.bottomMargin + (this.f.getMeasuredHeight() + layoutParams.topMargin));
        int a = co.a(0, ViewCompat.l(this.f));
        boolean z = (ViewCompat.t(this) & LogType.UNEXP) != 0;
        if (z) {
            i3 = this.c;
            if (this.j && this.f.getTabContainer() != null) {
                i3 += this.c;
            }
        } else {
            i3 = this.f.getVisibility() != 8 ? this.f.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        this.s.set(this.r);
        Rect rect;
        Rect rect2;
        if (this.a || z) {
            rect = this.s;
            rect.top = i3 + rect.top;
            rect2 = this.s;
            rect2.bottom += 0;
        } else {
            rect = this.q;
            rect.top = i3 + rect.top;
            rect2 = this.q;
            rect2.bottom += 0;
        }
        a(this.e, this.q, true);
        if (!this.t.equals(this.s)) {
            this.t.set(this.s);
            this.e.a(this.s);
        }
        measureChildWithMargins(this.e, i, 0, i2, 0);
        layoutParams = (LayoutParams) this.e.getLayoutParams();
        int max3 = Math.max(max, (this.e.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        i3 = Math.max(max2, layoutParams.bottomMargin + (this.e.getMeasuredHeight() + layoutParams.topMargin));
        int a2 = co.a(a, ViewCompat.l(this.e));
        setMeasuredDimension(ViewCompat.a(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, a2), ViewCompat.a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, a2 << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i6 = layoutParams.leftMargin + paddingLeft;
                int i7 = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, i7, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + i7);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.h != null && !this.i) {
            int bottom = this.f.getVisibility() == 0 ? (int) ((((float) this.f.getBottom()) + ViewCompat.n(this.f)) + 0.5f) : 0;
            this.h.setBounds(0, bottom, getWidth(), this.h.getIntrinsicHeight() + bottom);
            this.h.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f.getVisibility() != 0) {
            return false;
        }
        return this.k;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.B.a = i;
        this.m = getActionBarHideOffset();
        i();
        if (this.u != null) {
            this.u.j();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.m += i2;
        setActionBarHideOffset(this.m);
    }

    public void onStopNestedScroll(View view) {
        if (this.k && !this.l) {
            if (this.m <= this.f.getHeight()) {
                i();
                postDelayed(this.z, 600);
                return;
            }
            i();
            postDelayed(this.A, 600);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int i = 0;
        if (!this.k || !z) {
            return false;
        }
        this.w.a(0, (int) f2, 0, 0);
        if (this.w.e() > this.f.getHeight()) {
            i = 1;
        }
        if (i != 0) {
            i();
            this.A.run();
        } else {
            i();
            this.z.run();
        }
        this.l = true;
        return true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.B.a;
    }

    private void h() {
        if (this.e == null) {
            bt btVar;
            this.e = (ContentFrameLayout) findViewById(j.action_bar_activity_content);
            this.f = (ActionBarContainer) findViewById(j.action_bar_container);
            View findViewById = findViewById(j.action_bar);
            if (findViewById instanceof bt) {
                btVar = (bt) findViewById;
            } else if (findViewById instanceof Toolbar) {
                btVar = ((Toolbar) findViewById).getWrapper();
            } else {
                throw new IllegalStateException("Can't make a decor toolbar out of " + findViewById.getClass().getSimpleName());
            }
            this.g = btVar;
        }
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.k) {
            this.k = z;
            if (!z) {
                i();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        return this.f != null ? -((int) ViewCompat.n(this.f)) : 0;
    }

    public void setActionBarHideOffset(int i) {
        i();
        ViewCompat.b(this.f, (float) (-Math.max(0, Math.min(i, this.f.getHeight()))));
    }

    private void i() {
        removeCallbacks(this.z);
        removeCallbacks(this.A);
        if (this.x != null) {
            this.x.a();
        }
    }

    public void setWindowCallback(Callback callback) {
        h();
        this.g.a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        h();
        this.g.a(charSequence);
    }

    public CharSequence getTitle() {
        h();
        return this.g.e();
    }

    public final void a(int i) {
        h();
        switch (i) {
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(int i) {
        h();
        this.g.a(i);
    }

    public void setIcon(Drawable drawable) {
        h();
        this.g.a(drawable);
    }

    public void setLogo(int i) {
        h();
        this.g.b(i);
    }

    public final boolean a() {
        h();
        return this.g.f();
    }

    public final boolean b() {
        h();
        return this.g.g();
    }

    public final boolean c() {
        h();
        return this.g.h();
    }

    public final boolean d() {
        h();
        return this.g.i();
    }

    public final boolean e() {
        h();
        return this.g.j();
    }

    public final void f() {
        h();
        this.g.k();
    }

    public final void a(Menu menu, m mVar) {
        h();
        this.g.a(menu, mVar);
    }

    public final void g() {
        h();
        this.g.l();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
