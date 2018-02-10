package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ao;
import android.support.v4.view.bf;
import android.support.v4.view.bg;
import android.support.v4.view.ch;
import android.support.v4.view.cx;
import android.support.v4.view.ea;
import android.support.v4.view.eb;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import java.util.List;

/* compiled from: ProGuard */
public class NestedScrollView extends FrameLayout implements bg, ch, eb {
    private static final t v = new t();
    private static final int[] w = new int[]{16843130};
    private bc A;
    private long a;
    private final Rect b;
    private l c;
    private bx d;
    private bx e;
    private int f;
    private boolean g;
    private boolean h;
    private View i;
    private boolean j;
    private VelocityTracker k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private final int[] r;
    private final int[] s;
    private int t;
    private SavedState u;
    private final ea x;
    private final bf y;
    private float z;

    /* compiled from: ProGuard */
    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new cl();
        public int a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.a + "}";
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Rect();
        this.g = true;
        this.h = false;
        this.i = null;
        this.j = false;
        this.m = true;
        this.q = -1;
        this.r = new int[2];
        this.s = new int[2];
        this.c = l.a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.n = viewConfiguration.getScaledTouchSlop();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.p = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.x = new ea(this);
        this.y = new bf(this);
        setNestedScrollingEnabled(true);
        ViewCompat.a((View) this, v);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.y.a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.y.a;
    }

    public boolean startNestedScroll(int i) {
        return this.y.a(i);
    }

    public void stopNestedScroll() {
        this.y.b();
    }

    public boolean hasNestedScrollingParent() {
        return this.y.a();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.y.a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.y.a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.y.a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.y.a(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.x.a = i;
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        this.x.a = 0;
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        e((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public int getNestedScrollAxes() {
        return this.x.a;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return IPictureView.DEFAULT_MIN_SCALE;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return IPictureView.DEFAULT_MIN_SCALE;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnScrollChangeListener(bc bcVar) {
        this.A = bcVar;
    }

    public void setFillViewport(boolean z) {
        if (z != this.l) {
            this.l = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.m = z;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.A != null) {
            this.A.a(this);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), UCCore.VERIFY_POLICY_QUICK));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public final boolean a(KeyEvent keyEvent) {
        boolean z;
        this.b.setEmpty();
        View childAt = getChildAt(0);
        if (childAt != null) {
            z = getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
        } else {
            z = false;
        }
        View childAt2;
        if (z) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case 19:
                    if (keyEvent.isAltPressed()) {
                        return b(33);
                    }
                    return c(33);
                case 20:
                    if (keyEvent.isAltPressed()) {
                        return b(130);
                    }
                    return c(130);
                case 62:
                    int i;
                    if (keyEvent.isShiftPressed()) {
                        i = 33;
                    } else {
                        i = 130;
                    }
                    boolean z2 = i == 130;
                    int height = getHeight();
                    if (z2) {
                        this.b.top = getScrollY() + height;
                        int childCount = getChildCount();
                        if (childCount > 0) {
                            childAt2 = getChildAt(childCount - 1);
                            if (this.b.top + height > childAt2.getBottom()) {
                                this.b.top = childAt2.getBottom() - height;
                            }
                        }
                    } else {
                        this.b.top = getScrollY() - height;
                        if (this.b.top < 0) {
                            this.b.top = 0;
                        }
                    }
                    this.b.bottom = height + this.b.top;
                    a(i, this.b.top, this.b.bottom);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            childAt2 = findFocus();
            if (childAt2 == this) {
                childAt2 = null;
            }
            childAt2 = FocusFinder.getInstance().findNextFocus(this, childAt2, 130);
            if (childAt2 == null || childAt2 == this || !childAt2.requestFocus(130)) {
                return false;
            }
            return true;
        }
    }

    private void a() {
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
        }
    }

    private void b() {
        if (this.k != null) {
            this.k.recycle();
            this.k = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            b();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int action = motionEvent.getAction();
        if (action == 2 && this.j) {
            return true;
        }
        int y;
        switch (action & 255) {
            case 0:
                boolean z2;
                y = (int) motionEvent.getY();
                action = (int) motionEvent.getX();
                if (getChildCount() > 0) {
                    int scrollY = getScrollY();
                    View childAt = getChildAt(0);
                    z2 = y >= childAt.getTop() - scrollY && y < childAt.getBottom() - scrollY && action >= childAt.getLeft() && action < childAt.getRight();
                } else {
                    z2 = false;
                }
                if (!z2) {
                    this.j = false;
                    b();
                    break;
                }
                this.f = y;
                this.q = cx.b(motionEvent, 0);
                if (this.k == null) {
                    this.k = VelocityTracker.obtain();
                } else {
                    this.k.clear();
                }
                this.k.addMovement(motionEvent);
                this.c.g();
                if (this.c.a()) {
                    z = false;
                }
                this.j = z;
                startNestedScroll(2);
                break;
                break;
            case 1:
            case 3:
                this.j = false;
                this.q = -1;
                b();
                if (this.c.a(getScrollX(), getScrollY(), getScrollRange())) {
                    ViewCompat.d(this);
                }
                stopNestedScroll();
                break;
            case 2:
                action = this.q;
                if (action != -1) {
                    y = cx.a(motionEvent, action);
                    if (y != -1) {
                        action = (int) cx.d(motionEvent, y);
                        if (Math.abs(action - this.f) > this.n && (getNestedScrollAxes() & 2) == 0) {
                            this.j = true;
                            this.f = action;
                            a();
                            this.k.addMovement(motionEvent);
                            this.t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        return this.j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        a();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a = cx.a(motionEvent);
        if (a == 0) {
            this.t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.t);
        switch (a) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.c.a();
                    this.j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.c.a()) {
                        this.c.h();
                    }
                    this.f = (int) motionEvent.getY();
                    this.q = cx.b(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case 1:
                if (this.j) {
                    VelocityTracker velocityTracker = this.k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.p);
                    a = (int) ao.b(velocityTracker, this.q);
                    if (Math.abs(a) > this.o) {
                        e(-a);
                    } else if (this.c.a(getScrollX(), getScrollY(), getScrollRange())) {
                        ViewCompat.d(this);
                    }
                }
                this.q = -1;
                c();
                break;
            case 2:
                int a2 = cx.a(motionEvent, this.q);
                if (a2 != -1) {
                    int i;
                    int d = (int) cx.d(motionEvent, a2);
                    a = this.f - d;
                    if (dispatchNestedPreScroll(0, a, this.s, this.r)) {
                        a -= this.s[1];
                        obtain.offsetLocation(0.0f, (float) this.r[1]);
                        this.t += this.r[1];
                    }
                    if (this.j || Math.abs(a) <= this.n) {
                        i = a;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.j = true;
                        if (a > 0) {
                            i = a - this.n;
                        } else {
                            i = a + this.n;
                        }
                    }
                    if (this.j) {
                        Object obj;
                        this.f = d - this.r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        a = ViewCompat.a((View) this);
                        if (a == 0 || (a == 1 && scrollRange > 0)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (a(0, i, 0, getScrollY(), scrollRange) && !hasNestedScrollingParent()) {
                            this.k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.r)) {
                            if (obj != null) {
                                d();
                                a = scrollY + i;
                                if (a < 0) {
                                    this.d.a(((float) i) / ((float) getHeight()), cx.c(motionEvent, a2) / ((float) getWidth()));
                                    if (!this.e.a()) {
                                        this.e.c();
                                    }
                                } else if (a > scrollRange) {
                                    this.e.a(((float) i) / ((float) getHeight()), IPictureView.DEFAULT_MIN_SCALE - (cx.c(motionEvent, a2) / ((float) getWidth())));
                                    if (!this.d.a()) {
                                        this.d.c();
                                    }
                                }
                                if (!(this.d == null || (this.d.a() && this.e.a()))) {
                                    ViewCompat.d(this);
                                    break;
                                }
                            }
                        }
                        this.f -= this.r[1];
                        obtain.offsetLocation(0.0f, (float) this.r[1]);
                        this.t += this.r[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.q + " in onTouchEvent");
                break;
                break;
            case 3:
                if (this.j && getChildCount() > 0 && this.c.a(getScrollX(), getScrollY(), getScrollRange())) {
                    ViewCompat.d(this);
                }
                this.q = -1;
                c();
                break;
            case 5:
                a = cx.b(motionEvent);
                this.f = (int) cx.d(motionEvent, a);
                this.q = cx.b(motionEvent, a);
                break;
            case 6:
                a(motionEvent);
                this.f = (int) cx.d(motionEvent, cx.a(motionEvent, this.q));
                break;
        }
        if (this.k != null) {
            this.k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (cx.b(motionEvent, action) == this.q) {
            action = action == 0 ? 1 : 0;
            this.f = (int) cx.d(motionEvent, action);
            this.q = cx.b(motionEvent, action);
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((cx.d(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.j) {
                    return false;
                }
                float e = cx.e(motionEvent, 9);
                if (e == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (e * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.z;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    private boolean a(int i, int i2, int i3, int i4, int i5) {
        boolean z;
        int i6;
        boolean z2;
        ViewCompat.a((View) this);
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int i7 = i3 + i;
        int i8 = i4 + i2;
        int i9 = i5 + 0;
        if (i7 > 0) {
            z = true;
            i6 = 0;
        } else if (i7 < 0) {
            z = true;
            i6 = 0;
        } else {
            i6 = i7;
            z = false;
        }
        if (i8 > i9) {
            i8 = i9;
            z2 = true;
        } else if (i8 < 0) {
            z2 = true;
            i8 = 0;
        } else {
            z2 = false;
        }
        if (z2) {
            this.c.a(i6, i8, getScrollRange());
        }
        onOverScrolled(i6, i8, z, z2);
        if (z || z2) {
            return true;
        }
        return false;
    }

    private int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private boolean b(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.b.top = 0;
        this.b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.b.top = this.b.bottom - height;
            }
        }
        return a(i, this.b.top, this.b.bottom);
    }

    private boolean a(int i, int i2, int i3) {
        Object obj;
        boolean z;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        if (i == 33) {
            obj = 1;
        } else {
            obj = null;
        }
        List focusables = getFocusables(2);
        View view = null;
        Object obj2 = null;
        int size = focusables.size();
        int i5 = 0;
        while (i5 < size) {
            View view2;
            Object obj3;
            View view3 = (View) focusables.get(i5);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i2 < bottom && top < i3) {
                Object obj4 = (i2 >= top || bottom >= i3) ? null : 1;
                if (view == null) {
                    Object obj5 = obj4;
                    view2 = view3;
                    obj3 = obj5;
                } else {
                    Object obj6 = ((obj == null || top >= view.getTop()) && (obj != null || bottom <= view.getBottom())) ? null : 1;
                    if (obj2 != null) {
                        if (!(obj4 == null || obj6 == null)) {
                            view2 = view3;
                            obj3 = obj2;
                        }
                    } else if (obj4 != null) {
                        view2 = view3;
                        height = 1;
                    } else if (obj6 != null) {
                        view2 = view3;
                        obj3 = obj2;
                    }
                }
                i5++;
                view = view2;
                obj2 = obj3;
            }
            obj3 = obj2;
            view2 = view;
            i5++;
            view = view2;
            obj2 = obj3;
        }
        if (view == null) {
            view = this;
        }
        if (i2 < scrollY || i3 > i4) {
            d(obj != null ? i2 - scrollY : i3 - i4);
            z = true;
        } else {
            z = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i);
        }
        return z;
    }

    private boolean c(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            d(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.b);
            offsetDescendantRectToMyCoords(findNextFocus, this.b);
            d(a(this.b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean a(View view) {
        return !a(view, 0, getHeight());
    }

    private boolean a(View view, int i, int i2) {
        view.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(view, this.b);
        return this.b.bottom + i >= getScrollY() && this.b.top - i <= getScrollY() + i2;
    }

    private void d(int i) {
        if (i == 0) {
            return;
        }
        if (this.m) {
            a(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private void a(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                max = Math.max(0, Math.min(scrollY + i2, max)) - scrollY;
                l lVar = this.c;
                lVar.b.a(lVar.a, getScrollX(), scrollY, max);
                ViewCompat.d(this);
            } else {
                if (!this.c.a()) {
                    this.c.h();
                }
                scrollBy(i, i2);
            }
            this.a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void a(int i) {
        a(0 - getScrollX(), i - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > height) {
            return bottom + (scrollY - height);
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void computeScroll() {
        if (this.c.g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.c.b();
            int c = this.c.c();
            if (scrollX != b || scrollY != c) {
                int scrollRange = getScrollRange();
                int a = ViewCompat.a((View) this);
                Object obj = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : null;
                a(b - scrollX, c - scrollY, scrollX, scrollY, scrollRange);
                if (obj != null) {
                    d();
                    if (c <= 0 && scrollY > 0) {
                        this.d.a((int) this.c.f());
                    } else if (c >= scrollRange && scrollY < scrollRange) {
                        this.e.a((int) this.c.f());
                    }
                }
            }
        }
    }

    private void b(View view) {
        view.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(view, this.b);
        int a = a(this.b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private int a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            if (rect.height() > height) {
                scrollY = (rect.top - scrollY) + 0;
            } else {
                scrollY = (rect.bottom - i) + 0;
            }
            scrollY = Math.min(scrollY, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            if (rect.height() > height) {
                scrollY = 0 - (i - rect.bottom);
            } else {
                scrollY = 0 - (scrollY - rect.top);
            }
            scrollY = Math.max(scrollY, -getScrollY());
        }
        return scrollY;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.g) {
            this.i = view2;
        } else {
            b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (findNextFocus == null || a(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int a = a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                a(0, a);
            }
        }
        return z2;
    }

    public void requestLayout() {
        this.g = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.g = false;
        if (this.i != null && a(this.i, (View) this)) {
            b(this.i);
        }
        this.i = null;
        if (!this.h) {
            if (this.u != null) {
                scrollTo(getScrollX(), this.u.a);
                this.u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.h = true;
    }

    public void onAttachedToWindow() {
        this.h = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.b);
            offsetDescendantRectToMyCoords(findFocus, this.b);
            d(a(this.b));
        }
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && a((View) parent, view2);
    }

    private void e(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z && getChildCount() > 0) {
                scrollY = (getHeight() - getPaddingBottom()) - getPaddingTop();
                int height = getChildAt(0).getHeight();
                l lVar = this.c;
                lVar.b.b(lVar.a, getScrollX(), getScrollY(), i, Math.max(0, height - scrollY), scrollY / 2);
                ViewCompat.d(this);
            }
        }
    }

    private void c() {
        this.j = false;
        b();
        stopNestedScroll();
        if (this.d != null) {
            this.d.c();
            this.e.c();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    private void d() {
        if (ViewCompat.a((View) this) == 2) {
            this.d = null;
            this.e = null;
        } else if (this.d == null) {
            Context context = getContext();
            this.d = new bx(context);
            this.e = new bx(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.d.a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.d.a(width, getHeight());
                if (this.d.a(canvas)) {
                    ViewCompat.d(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.e.a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.e.a(width, height);
                if (this.e.a(canvas)) {
                    ViewCompat.d(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    private static int b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        if (i2 + i > i3) {
            return i3 - i2;
        }
        return i;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.u = savedState;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = getScrollY();
        return savedState;
    }
}
