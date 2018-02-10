package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.bf;
import android.support.v4.view.bg;
import android.support.v4.view.cx;
import android.support.v4.view.ea;
import android.support.v4.view.eb;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public class SwipeRefreshLayout extends ViewGroup implements bg, eb {
    private static final String c = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] y = new int[]{16842766};
    private int A = -1;
    private float B;
    private MaterialProgressDrawable C;
    private Animation D;
    private Animation E;
    private Animation F;
    private Animation G;
    private Animation H;
    private float I;
    private boolean J;
    private int K;
    private int L;
    private boolean M;
    private AnimationListener N = new ca(this);
    private final Animation O = new u(this);
    private final Animation P = new by(this);
    protected int a;
    protected int b;
    private View d;
    private af e;
    private boolean f = false;
    private int g;
    private float h = -1.0f;
    private float i;
    private final ea j;
    private final bf k;
    private final int[] l = new int[2];
    private final int[] m = new int[2];
    private boolean n;
    private int o;
    private int p;
    private boolean q = false;
    private float r;
    private float s;
    private boolean t;
    private int u = -1;
    private boolean v;
    private boolean w;
    private final DecelerateInterpolator x;
    private cb z;

    private void a() {
        this.z.clearAnimation();
        this.C.stop();
        this.z.setVisibility(8);
        setColorViewAlpha(255);
        if (this.v) {
            setAnimationProgress(0.0f);
        } else {
            a(this.b - this.p, true);
        }
        this.p = this.z.getTop();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    private void setColorViewAlpha(int i) {
        this.z.getBackground().setAlpha(i);
        this.C.setAlpha(i);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i2;
            if (i == 0) {
                i2 = (int) (displayMetrics.density * 56.0f);
                this.K = i2;
                this.L = i2;
            } else {
                i2 = (int) (displayMetrics.density * 40.0f);
                this.K = i2;
                this.L = i2;
            }
            this.z.setImageDrawable(null);
            this.C.a(i);
            this.z.setImageDrawable(this.C);
        }
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = ViewConfiguration.get(context).getScaledTouchSlop();
        this.o = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.x = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.K = (int) (displayMetrics.density * 40.0f);
        this.L = (int) (displayMetrics.density * 40.0f);
        this.z = new cb(getContext());
        this.C = new MaterialProgressDrawable(getContext(), this);
        this.C.b(-328966);
        this.z.setImageDrawable(this.C);
        this.z.setVisibility(8);
        addView(this.z);
        ViewCompat.a((ViewGroup) this);
        this.I = displayMetrics.density * 64.0f;
        this.h = this.I;
        this.j = new ea(this);
        this.k = new bf(this);
        setNestedScrollingEnabled(true);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.A < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.A;
        }
        if (i2 >= this.A) {
            return i2 + 1;
        }
        return i2;
    }

    public void setOnRefreshListener(af afVar) {
        this.e = afVar;
    }

    private static boolean b() {
        return VERSION.SDK_INT < 11;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.f == z) {
            a(z, false);
            return;
        }
        int i;
        this.f = z;
        if (this.M) {
            i = (int) this.I;
        } else {
            i = (int) (this.I + ((float) this.b));
        }
        a(i - this.p, true);
        this.J = false;
        AnimationListener animationListener = this.N;
        this.z.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            this.C.setAlpha(255);
        }
        this.D = new cf(this);
        this.D.setDuration((long) this.o);
        if (animationListener != null) {
            this.z.a = animationListener;
        }
        this.z.clearAnimation();
        this.z.startAnimation(this.D);
    }

    private void setAnimationProgress(float f) {
        if (b()) {
            setColorViewAlpha((int) (255.0f * f));
            return;
        }
        ViewCompat.d(this.z, f);
        ViewCompat.e(this.z, f);
    }

    private void a(boolean z, boolean z2) {
        if (this.f != z) {
            this.J = z2;
            c();
            this.f = z;
            if (this.f) {
                int i = this.p;
                AnimationListener animationListener = this.N;
                this.a = i;
                this.O.reset();
                this.O.setDuration(200);
                this.O.setInterpolator(this.x);
                if (animationListener != null) {
                    this.z.a = animationListener;
                }
                this.z.clearAnimation();
                this.z.startAnimation(this.O);
                return;
            }
            a(this.N);
        }
    }

    private void a(AnimationListener animationListener) {
        this.E = new aj(this);
        this.E.setDuration(150);
        this.z.a = animationListener;
        this.z.clearAnimation();
        this.z.startAnimation(this.E);
    }

    private Animation a(int i, int i2) {
        if (this.v && b()) {
            return null;
        }
        Animation adVar = new ad(this, i, i2);
        adVar.setDuration(300);
        this.z.a = null;
        this.z.clearAnimation();
        this.z.startAnimation(adVar);
        return adVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i));
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i) {
        this.z.setBackgroundColor(i);
        this.C.b(i);
    }

    @Deprecated
    public void setColorScheme(@ColorInt int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    @ColorInt
    public void setColorSchemeColors(int... iArr) {
        c();
        MaterialProgressDrawable materialProgressDrawable = this.C;
        materialProgressDrawable.a.a(iArr);
        materialProgressDrawable.a.a(0);
    }

    private void c() {
        if (this.d == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.z)) {
                    i++;
                } else {
                    this.d = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.h = (float) i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.d == null) {
                c();
            }
            if (this.d != null) {
                View view = this.d;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.z.getMeasuredWidth();
                this.z.layout((measuredWidth / 2) - (measuredHeight / 2), this.p, (measuredWidth / 2) + (measuredHeight / 2), this.p + this.z.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.d == null) {
            c();
        }
        if (this.d != null) {
            int i3;
            this.d.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), UCCore.VERIFY_POLICY_QUICK));
            this.z.measure(MeasureSpec.makeMeasureSpec(this.K, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.L, UCCore.VERIFY_POLICY_QUICK));
            if (!(this.M || this.q)) {
                this.q = true;
                i3 = -this.z.getMeasuredHeight();
                this.b = i3;
                this.p = i3;
            }
            this.A = -1;
            for (i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.z) {
                    this.A = i3;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.z != null ? this.z.getMeasuredHeight() : 0;
    }

    private boolean d() {
        if (VERSION.SDK_INT >= 14) {
            return ViewCompat.b(this.d, -1);
        }
        if (!(this.d instanceof AbsListView)) {
            return ViewCompat.b(this.d, -1) || this.d.getScrollY() > 0;
        } else {
            AbsListView absListView = (AbsListView) this.d;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        c();
        int a = cx.a(motionEvent);
        if (this.w && a == 0) {
            this.w = false;
        }
        if (!isEnabled() || this.w || d() || this.f || this.n) {
            return false;
        }
        float a2;
        switch (a) {
            case 0:
                a(this.b - this.z.getTop(), true);
                this.u = cx.b(motionEvent, 0);
                this.t = false;
                a2 = a(motionEvent, this.u);
                if (a2 != -1.0f) {
                    this.s = a2;
                    break;
                }
                return false;
            case 1:
            case 3:
                this.t = false;
                this.u = -1;
                break;
            case 2:
                if (this.u == -1) {
                    Log.e(c, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                a2 = a(motionEvent, this.u);
                if (a2 != -1.0f) {
                    if (a2 - this.s > ((float) this.g) && !this.t) {
                        this.r = this.s + ((float) this.g);
                        this.t = true;
                        this.C.setAlpha(76);
                        break;
                    }
                }
                return false;
            case 6:
                a(motionEvent);
                break;
        }
        return this.t;
    }

    private static float a(MotionEvent motionEvent, int i) {
        int a = cx.a(motionEvent, i);
        if (a < 0) {
            return -1.0f;
        }
        return cx.d(motionEvent, a);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.d instanceof AbsListView)) {
            return;
        }
        if (this.d == null || ViewCompat.B(this.d)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.w || this.f || (i & 2) == 0) ? false : true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.j.a = i;
        startNestedScroll(i & 2);
        this.i = 0.0f;
        this.n = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.i > 0.0f) {
            if (((float) i2) > this.i) {
                iArr[1] = i2 - ((int) this.i);
                this.i = 0.0f;
            } else {
                this.i -= (float) i2;
                iArr[1] = i2;
            }
            a(this.i);
        }
        if (this.M && i2 > 0 && this.i == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.z.setVisibility(8);
        }
        int[] iArr2 = this.l;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.j.a;
    }

    public void onStopNestedScroll(View view) {
        this.j.a = 0;
        this.n = false;
        if (this.i > 0.0f) {
            b(this.i);
            this.i = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.m);
        int i5 = this.m[1] + i4;
        if (i5 < 0 && !d()) {
            this.i = ((float) Math.abs(i5)) + this.i;
            a(this.i);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.k.a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.k.a;
    }

    public boolean startNestedScroll(int i) {
        return this.k.a(i);
    }

    public void stopNestedScroll() {
        this.k.b();
    }

    public boolean hasNestedScrollingParent() {
        return this.k.a();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.k.a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.k.a(i, i2, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.k.a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.k.a(f, f2);
    }

    private static boolean a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void a(float f) {
        this.C.a(true);
        float min = Math.min(IPictureView.DEFAULT_MIN_SCALE, Math.abs(f / this.h));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / IPictureView.DEFAULT_MAX_SCALE;
        float abs = Math.abs(f) - this.h;
        float f2 = this.M ? this.I - ((float) this.b) : this.I;
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.b;
        if (this.z.getVisibility() != 0) {
            this.z.setVisibility(0);
        }
        if (!this.v) {
            ViewCompat.d(this.z, (float) IPictureView.DEFAULT_MIN_SCALE);
            ViewCompat.e(this.z, (float) IPictureView.DEFAULT_MIN_SCALE);
        }
        if (this.v) {
            setAnimationProgress(Math.min(IPictureView.DEFAULT_MIN_SCALE, f / this.h));
        }
        if (f < this.h) {
            if (this.C.getAlpha() > 76 && !a(this.F)) {
                this.F = a(this.C.getAlpha(), 76);
            }
        } else if (this.C.getAlpha() < 255 && !a(this.G)) {
            this.G = a(this.C.getAlpha(), 255);
        }
        this.C.b(Math.min(0.8f, max * 0.8f));
        this.C.a(Math.min(IPictureView.DEFAULT_MIN_SCALE, max));
        this.C.a.c(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        a(i - this.p, true);
    }

    private void b(float f) {
        if (f > this.h) {
            a(true, true);
            return;
        }
        this.f = false;
        this.C.b(0.0f);
        AnimationListener animationListener = null;
        if (!this.v) {
            animationListener = new ai(this);
        }
        int i = this.p;
        if (this.v) {
            this.a = i;
            if (b()) {
                this.B = (float) this.C.getAlpha();
            } else {
                this.B = ViewCompat.r(this.z);
            }
            this.H = new ap(this);
            this.H.setDuration(150);
            if (animationListener != null) {
                this.z.a = animationListener;
            }
            this.z.clearAnimation();
            this.z.startAnimation(this.H);
        } else {
            this.a = i;
            this.P.reset();
            this.P.setDuration(200);
            this.P.setInterpolator(this.x);
            if (animationListener != null) {
                this.z.a = animationListener;
            }
            this.z.clearAnimation();
            this.z.startAnimation(this.P);
        }
        this.C.a(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = cx.a(motionEvent);
        if (this.w && a == 0) {
            this.w = false;
        }
        if (!isEnabled() || this.w || d() || this.n) {
            return false;
        }
        float d;
        switch (a) {
            case 0:
                this.u = cx.b(motionEvent, 0);
                this.t = false;
                break;
            case 1:
                a = cx.a(motionEvent, this.u);
                if (a < 0) {
                    Log.e(c, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                d = (cx.d(motionEvent, a) - this.r) * 0.5f;
                this.t = false;
                b(d);
                this.u = -1;
                return false;
            case 2:
                a = cx.a(motionEvent, this.u);
                if (a < 0) {
                    Log.e(c, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                d = (cx.d(motionEvent, a) - this.r) * 0.5f;
                if (this.t) {
                    if (d > 0.0f) {
                        a(d);
                        break;
                    }
                    return false;
                }
                break;
            case 3:
                return false;
            case 5:
                a = cx.b(motionEvent);
                if (a >= 0) {
                    this.u = cx.b(motionEvent, a);
                    break;
                }
                Log.e(c, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                return false;
            case 6:
                a(motionEvent);
                break;
        }
        return true;
    }

    private void a(int i, boolean z) {
        this.z.bringToFront();
        this.z.offsetTopAndBottom(i);
        this.p = this.z.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void a(MotionEvent motionEvent) {
        int b = cx.b(motionEvent);
        if (cx.b(motionEvent, b) == this.u) {
            this.u = cx.b(motionEvent, b == 0 ? 1 : 0);
        }
    }
}
