package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.b.a.q;
import android.support.v4.content.g;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.be;
import android.support.v4.view.ca;
import android.support.v4.view.dn;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class DrawerLayout extends ViewGroup implements e {
    static final be h;
    private static final int[] i = new int[]{16842931};
    private static final boolean j = (VERSION.SDK_INT >= 19);
    private static final boolean k;
    @Nullable
    @Deprecated
    private bv A;
    private float B;
    private float C;
    private Drawable D;
    private Drawable E;
    private Drawable F;
    private Object G;
    private boolean H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private Drawable L;
    private final ArrayList<View> M;
    final bt a;
    final bt b;
    int c;
    boolean d;
    List<bv> e;
    CharSequence f;
    CharSequence g;
    private final j l;
    private float m;
    private int n;
    private int o;
    private float p;
    private Paint q;
    private final ae r;
    private final ae s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private int y;
    private boolean z;

    /* compiled from: ProGuard */
    public class LayoutParams extends MarginLayoutParams {
        public int a = 0;
        private float b;
        private boolean c;
        private int d;

        static /* synthetic */ int b(LayoutParams layoutParams, int i) {
            int i2 = layoutParams.d | i;
            layoutParams.d = i2;
            return i2;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.i);
            this.a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.a = layoutParams.a;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* compiled from: ProGuard */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new al();
        int a = 0;
        int b;
        int c;
        int d;
        int e;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        k = z;
        if (VERSION.SDK_INT >= 21) {
            h = new ce();
        } else {
            h = new q();
        }
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = new j(this);
        this.o = -1728053248;
        this.q = new Paint();
        this.u = true;
        this.v = 3;
        this.w = 3;
        this.x = 3;
        this.y = 3;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.n = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.r = new ae(this, 3);
        this.s = new ae(this, 5);
        this.a = bt.a((ViewGroup) this, (float) IPictureView.DEFAULT_MIN_SCALE, this.r);
        this.a.i = 1;
        this.a.g = f2;
        this.r.b = this.a;
        this.b = bt.a((ViewGroup) this, (float) IPictureView.DEFAULT_MIN_SCALE, this.s);
        this.b.i = 2;
        this.b.g = f2;
        this.s.b = this.b;
        setFocusableInTouchMode(true);
        ViewCompat.c((View) this, 1);
        ViewCompat.a((View) this, new am(this));
        be.a(this);
        if (ViewCompat.v(this)) {
            h.a((View) this);
            this.D = h.a(context);
        }
        this.m = f * 10.0f;
        this.M = new ArrayList();
    }

    public void setDrawerElevation(float f) {
        this.m = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (d(childAt)) {
                ViewCompat.f(childAt, this.m);
            }
        }
    }

    public float getDrawerElevation() {
        if (k) {
            return this.m;
        }
        return 0.0f;
    }

    public final void a(Object obj, boolean z) {
        this.G = obj;
        this.H = z;
        boolean z2 = !z && getBackground() == null;
        setWillNotDraw(z2);
        requestLayout();
    }

    public void setScrimColor(@ColorInt int i) {
        this.o = i;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(bv bvVar) {
        if (this.A != null) {
            bv bvVar2 = this.A;
            if (!(bvVar2 == null || this.e == null)) {
                this.e.remove(bvVar2);
            }
        }
        if (!(bvVar == null || bvVar == null)) {
            if (this.e == null) {
                this.e = new ArrayList();
            }
            this.e.add(bvVar);
        }
        this.A = bvVar;
    }

    public void setDrawerLockMode(int i) {
        a(i, 3);
        a(i, 5);
    }

    private void a(int i, int i2) {
        int a = ca.a(i2, ViewCompat.h(this));
        switch (i2) {
            case 3:
                this.v = i;
                break;
            case 5:
                this.w = i;
                break;
            case 8388611:
                this.x = i;
                break;
            case 8388613:
                this.y = i;
                break;
        }
        if (i != 0) {
            (a == 3 ? this.a : this.b).a();
        }
        View a2;
        switch (i) {
            case 1:
                a2 = a(a);
                if (a2 != null) {
                    e(a2);
                    return;
                }
                return;
            case 2:
                a2 = a(a);
                if (a2 != null) {
                    h(a2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final int a(View view) {
        if (d(view)) {
            int i = ((LayoutParams) view.getLayoutParams()).a;
            int h = ViewCompat.h(this);
            switch (i) {
                case 3:
                    if (this.v != 3) {
                        return this.v;
                    }
                    i = h == 0 ? this.x : this.y;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 5:
                    if (this.w != 3) {
                        return this.w;
                    }
                    i = h == 0 ? this.y : this.x;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388611:
                    if (this.x != 3) {
                        return this.x;
                    }
                    i = h == 0 ? this.v : this.w;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388613:
                    if (this.y != 3) {
                        return this.y;
                    }
                    i = h == 0 ? this.w : this.v;
                    if (i != 3) {
                        return i;
                    }
                    break;
            }
            return 0;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    final void a(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || d(childAt)) && !(z && childAt == view)) {
                ViewCompat.c(childAt, 4);
            } else {
                ViewCompat.c(childAt, 1);
            }
        }
    }

    final void a(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.b) {
            layoutParams.b = f;
            if (this.e != null) {
                for (int size = this.e.size() - 1; size >= 0; size--) {
                    this.e.get(size);
                }
            }
        }
    }

    static float b(View view) {
        return ((LayoutParams) view.getLayoutParams()).b;
    }

    final int c(View view) {
        return ca.a(((LayoutParams) view.getLayoutParams()).a, ViewCompat.h(this));
    }

    final boolean a(View view, int i) {
        return (c(view) & i) == i;
    }

    private View c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    final View a(int i) {
        int a = ca.a(i, ViewCompat.h(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((c(childAt) & 7) == a) {
                return childAt;
            }
        }
        return null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.u = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.u = true;
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int h;
        Object obj2;
        Object obj3;
        int childCount;
        int i3;
        View childAt;
        MarginLayoutParams marginLayoutParams;
        int a;
        int c;
        Object obj4;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (!(mode == UCCore.VERIFY_POLICY_QUICK && mode2 == UCCore.VERIFY_POLICY_QUICK)) {
            if (isInEditMode()) {
                if (mode != SectionHeader.SHT_LOUSER && mode == 0) {
                    size = SecExceptionCode.SEC_ERROR_STA_ENC;
                }
                if (mode2 != SectionHeader.SHT_LOUSER && mode2 == 0) {
                    mode = size;
                    size = SecExceptionCode.SEC_ERROR_STA_ENC;
                    setMeasuredDimension(mode, size);
                    if (this.G == null && ViewCompat.v(this)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    h = ViewCompat.h(this);
                    obj2 = null;
                    obj3 = null;
                    childCount = getChildCount();
                    for (i3 = 0; i3 < childCount; i3++) {
                        childAt = getChildAt(i3);
                        if (childAt.getVisibility() != 8) {
                            marginLayoutParams = (LayoutParams) childAt.getLayoutParams();
                            if (obj != null) {
                                a = ca.a(marginLayoutParams.a, h);
                                if (ViewCompat.v(childAt)) {
                                    h.a(marginLayoutParams, this.G, a);
                                } else {
                                    h.a(childAt, this.G, a);
                                }
                            }
                            if (g(childAt)) {
                                childAt.measure(MeasureSpec.makeMeasureSpec((mode - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec((size - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, UCCore.VERIFY_POLICY_QUICK));
                            } else if (d(childAt)) {
                                throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                            } else {
                                if (k && ViewCompat.s(childAt) != this.m) {
                                    ViewCompat.f(childAt, this.m);
                                }
                                c = c(childAt) & 7;
                                obj4 = c != 3 ? 1 : null;
                                if ((obj4 != null || r5 == null) && (obj4 != null || r4 == null)) {
                                    if (obj4 == null) {
                                        obj2 = 1;
                                    } else {
                                        obj3 = 1;
                                    }
                                    childAt.measure(getChildMeasureSpec(i, (this.n + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                                } else {
                                    String str;
                                    StringBuilder stringBuilder = new StringBuilder("Child drawer has absolute gravity ");
                                    if ((c & 3) == 3) {
                                        str = "LEFT";
                                    } else if ((c & 5) == 5) {
                                        str = "RIGHT";
                                    } else {
                                        str = Integer.toHexString(c);
                                    }
                                    throw new IllegalStateException(stringBuilder.append(str).append(" but this DrawerLayout already has a drawer view along that edge").toString());
                                }
                            }
                        }
                    }
                }
            }
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        }
        mode = size;
        size = size2;
        setMeasuredDimension(mode, size);
        if (this.G == null) {
        }
        obj = null;
        h = ViewCompat.h(this);
        obj2 = null;
        obj3 = null;
        childCount = getChildCount();
        for (i3 = 0; i3 < childCount; i3++) {
            childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                marginLayoutParams = (LayoutParams) childAt.getLayoutParams();
                if (obj != null) {
                    a = ca.a(marginLayoutParams.a, h);
                    if (ViewCompat.v(childAt)) {
                        h.a(marginLayoutParams, this.G, a);
                    } else {
                        h.a(childAt, this.G, a);
                    }
                }
                if (g(childAt)) {
                    childAt.measure(MeasureSpec.makeMeasureSpec((mode - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec((size - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, UCCore.VERIFY_POLICY_QUICK));
                } else if (d(childAt)) {
                    throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                } else {
                    ViewCompat.f(childAt, this.m);
                    c = c(childAt) & 7;
                    if (c != 3) {
                    }
                    if (obj4 != null) {
                    }
                    if (obj4 == null) {
                        obj3 = 1;
                    } else {
                        obj2 = 1;
                    }
                    childAt.measure(getChildMeasureSpec(i, (this.n + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                }
            }
        }
    }

    private static boolean a(Drawable drawable, int i) {
        if (drawable == null || !q.b(drawable)) {
            return false;
        }
        q.b(drawable, i);
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.t = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (g(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int a;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        a = ((int) (((float) measuredWidth) * layoutParams.b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + a)) / ((float) measuredWidth);
                    } else {
                        a = i5 - ((int) (((float) measuredWidth) * layoutParams.b));
                        f = ((float) (i5 - a)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.b ? 1 : null;
                    int i7;
                    switch (layoutParams.a & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) {
                        case 16:
                            int i8 = i4 - i2;
                            i7 = (i8 - measuredHeight) / 2;
                            if (i7 < layoutParams.topMargin) {
                                i7 = layoutParams.topMargin;
                            } else if (i7 + measuredHeight > i8 - layoutParams.bottomMargin) {
                                i7 = (i8 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(a, i7, measuredWidth + a, measuredHeight + i7);
                            break;
                        case 80:
                            i7 = i4 - i2;
                            childAt.layout(a, (i7 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + a, i7 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(a, layoutParams.topMargin, measuredWidth + a, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (obj != null) {
                        a(childAt, f);
                    }
                    int i9 = layoutParams.b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i9) {
                        childAt.setVisibility(i9);
                    }
                }
            }
        }
        this.t = false;
        this.u = false;
    }

    public void requestLayout() {
        if (!this.t) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).b);
        }
        this.p = f;
        if ((this.a.c() | this.b.c()) != 0) {
            ViewCompat.d(this);
        }
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.D = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.D;
    }

    public void setStatusBarBackground(int i) {
        this.D = i != 0 ? g.a(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int i) {
        this.D = new ColorDrawable(i);
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.H && this.D != null) {
            int a = h.a(this.G);
            if (a > 0) {
                this.D.setBounds(0, 0, getWidth(), a);
                this.D.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int right;
        int height = getHeight();
        boolean g = g(view);
        int i = 0;
        int width = getWidth();
        int save = canvas.save();
        if (g) {
            int childCount = getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt != view && childAt.getVisibility() == 0) {
                    Object obj;
                    Drawable background = childAt.getBackground();
                    if (background == null) {
                        obj = null;
                    } else if (background.getOpacity() == -1) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null && d(childAt) && childAt.getHeight() >= height) {
                        if (a(childAt, 3)) {
                            right = childAt.getRight();
                            if (right <= i) {
                                right = i;
                            }
                            i = right;
                            right = width;
                        } else {
                            right = childAt.getLeft();
                            if (right < width) {
                            }
                        }
                        i2++;
                        width = right;
                    }
                }
                right = width;
                i2++;
                width = right;
            }
            canvas.clipRect(i, 0, width, getHeight());
        }
        right = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.p > 0.0f && g) {
            this.q.setColor((((int) (((float) ((this.o & -16777216) >>> 24)) * this.p)) << 24) | (this.o & 16777215));
            canvas.drawRect((float) i, 0.0f, (float) right, (float) getHeight(), this.q);
        } else if (this.E != null && a(view, 3)) {
            right = this.E.getIntrinsicWidth();
            i = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i) / ((float) this.a.h), IPictureView.DEFAULT_MIN_SCALE));
            this.E.setBounds(i, view.getTop(), right + i, view.getBottom());
            this.E.setAlpha((int) (255.0f * r2));
            this.E.draw(canvas);
        } else if (this.F != null && a(view, 5)) {
            right = this.F.getIntrinsicWidth();
            i = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i)) / ((float) this.b.h), IPictureView.DEFAULT_MIN_SCALE));
            this.F.setBounds(i - right, view.getTop(), i, view.getBottom());
            this.F.setAlpha((int) (255.0f * r2));
            this.F.draw(canvas);
        }
        return drawChild;
    }

    private static boolean g(View view) {
        return ((LayoutParams) view.getLayoutParams()).a == 0;
    }

    static boolean d(View view) {
        int a = ca.a(((LayoutParams) view.getLayoutParams()).a, ViewCompat.h(view));
        if ((a & 3) != 0) {
            return true;
        }
        if ((a & 5) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r10) {
        /*
        r9 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.support.v4.view.cx.a(r10);
        r3 = r9.a;
        r3 = r3.a(r10);
        r4 = r9.b;
        r4 = r4.a(r10);
        r4 = r4 | r3;
        switch(r0) {
            case 0: goto L_0x003b;
            case 1: goto L_0x00ad;
            case 2: goto L_0x0064;
            case 3: goto L_0x00ad;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r4 != 0) goto L_0x0039;
    L_0x0019:
        if (r0 != 0) goto L_0x0039;
    L_0x001b:
        r4 = r9.getChildCount();
        r3 = r2;
    L_0x0020:
        if (r3 >= r4) goto L_0x00bb;
    L_0x0022:
        r0 = r9.getChildAt(r3);
        r0 = r0.getLayoutParams();
        r0 = (android.support.v4.widget.DrawerLayout.LayoutParams) r0;
        r0 = r0.c;
        if (r0 == 0) goto L_0x00b6;
    L_0x0032:
        r0 = r1;
    L_0x0033:
        if (r0 != 0) goto L_0x0039;
    L_0x0035:
        r0 = r9.d;
        if (r0 == 0) goto L_0x003a;
    L_0x0039:
        r2 = r1;
    L_0x003a:
        return r2;
    L_0x003b:
        r0 = r10.getX();
        r3 = r10.getY();
        r9.B = r0;
        r9.C = r3;
        r5 = r9.p;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x00be;
    L_0x004e:
        r5 = r9.a;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = r5.b(r0, r3);
        if (r0 == 0) goto L_0x00be;
    L_0x0058:
        r0 = g(r0);
        if (r0 == 0) goto L_0x00be;
    L_0x005e:
        r0 = r1;
    L_0x005f:
        r9.z = r2;
        r9.d = r2;
        goto L_0x0017;
    L_0x0064:
        r5 = r9.a;
        r0 = r5.c;
        r6 = r0.length;
        r0 = r2;
    L_0x006a:
        if (r0 >= r6) goto L_0x00ab;
    L_0x006c:
        r3 = r5.a(r0);
        if (r3 == 0) goto L_0x00a6;
    L_0x0072:
        r3 = r5.e;
        r3 = r3[r0];
        r7 = r5.c;
        r7 = r7[r0];
        r3 = r3 - r7;
        r7 = r5.f;
        r7 = r7[r0];
        r8 = r5.d;
        r8 = r8[r0];
        r7 = r7 - r8;
        r3 = r3 * r3;
        r7 = r7 * r7;
        r3 = r3 + r7;
        r7 = r5.b;
        r8 = r5.b;
        r7 = r7 * r8;
        r7 = (float) r7;
        r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r3 <= 0) goto L_0x00a4;
    L_0x0091:
        r3 = r1;
    L_0x0092:
        if (r3 == 0) goto L_0x00a8;
    L_0x0094:
        r0 = r1;
    L_0x0095:
        if (r0 == 0) goto L_0x0016;
    L_0x0097:
        r0 = r9.r;
        r0.a();
        r0 = r9.s;
        r0.a();
        r0 = r2;
        goto L_0x0017;
    L_0x00a4:
        r3 = r2;
        goto L_0x0092;
    L_0x00a6:
        r3 = r2;
        goto L_0x0092;
    L_0x00a8:
        r0 = r0 + 1;
        goto L_0x006a;
    L_0x00ab:
        r0 = r2;
        goto L_0x0095;
    L_0x00ad:
        r9.a(r1);
        r9.z = r2;
        r9.d = r2;
        goto L_0x0016;
    L_0x00b6:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0020;
    L_0x00bb:
        r0 = r2;
        goto L_0x0033;
    L_0x00be:
        r0 = r2;
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.a.b(motionEvent);
        this.b.b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.B = x;
                this.C = y;
                this.z = false;
                this.d = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View b = this.a.b((int) x, (int) y);
                if (b != null && g(b)) {
                    x -= this.B;
                    y -= this.C;
                    int i = this.a.b;
                    if ((x * x) + (y * y) < ((float) (i * i))) {
                        View c = c();
                        if (c != null) {
                            z = a(c) == 2;
                            a(z);
                            this.z = false;
                            break;
                        }
                    }
                }
                z = true;
                a(z);
                this.z = false;
            case 3:
                a(true);
                this.z = false;
                this.d = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.z = z;
        if (z) {
            a(true);
        }
    }

    private void a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (d(childAt) && (!z || layoutParams.c)) {
                int width = childAt.getWidth();
                if (a(childAt, 3)) {
                    i |= this.a.a(childAt, -width, childAt.getTop());
                } else {
                    i |= this.b.a(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.c = false;
            }
        }
        this.r.a();
        this.s.a();
        if (i != 0) {
            invalidate();
        }
    }

    private void h(View view) {
        if (d(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.u) {
                layoutParams.b = IPictureView.DEFAULT_MIN_SCALE;
                layoutParams.d = 1;
                a(view, true);
            } else {
                LayoutParams.b(layoutParams, 2);
                if (a(view, 3)) {
                    this.a.a(view, 0, view.getTop());
                } else {
                    this.b.a(view, getWidth() - view.getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final void e(View view) {
        if (d(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.u) {
                layoutParams.b = 0.0f;
                layoutParams.d = 0;
            } else {
                LayoutParams.b(layoutParams, 4);
                if (a(view, 3)) {
                    this.a.a(view, -view.getWidth(), view.getTop());
                } else {
                    this.b.a(view, getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            int i3 = 0;
            Object obj = null;
            while (i3 < childCount) {
                Object obj2;
                View childAt = getChildAt(i3);
                if (!d(childAt)) {
                    this.M.add(childAt);
                    obj2 = obj;
                } else if (d(childAt)) {
                    if ((((LayoutParams) childAt.getLayoutParams()).d & 1) == 1) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        childAt.addFocusables(arrayList, i, i2);
                        obj2 = 1;
                    }
                    obj2 = obj;
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
                i3++;
                obj = obj2;
            }
            if (obj == null) {
                int size = this.M.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = (View) this.M.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.M.clear();
        }
    }

    private View d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (d(childAt)) {
                if (d(childAt)) {
                    Object obj;
                    if (((LayoutParams) childAt.getLayoutParams()).b > 0.0f) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        return childAt;
                    }
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
            }
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z;
            if (d() != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                dn.b(keyEvent);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View d = d();
        if (d != null && a(d) == 0) {
            a(false);
        }
        if (d != null) {
            return true;
        }
        return false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (savedState.a != 0) {
                View a = a(savedState.a);
                if (a != null) {
                    h(a);
                }
            }
            if (savedState.b != 3) {
                a(savedState.b, 3);
            }
            if (savedState.c != 3) {
                a(savedState.c, 5);
            }
            if (savedState.d != 3) {
                a(savedState.d, 8388611);
            }
            if (savedState.e != 3) {
                a(savedState.e, 8388613);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            Object obj = layoutParams.d == 1 ? 1 : null;
            Object obj2;
            if (layoutParams.d == 2) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj != null || r4 != null) {
                savedState.a = layoutParams.a;
                break;
            }
        }
        savedState.b = this.v;
        savedState.c = this.w;
        savedState.d = this.x;
        savedState.e = this.y;
        return savedState;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (c() != null || d(view)) {
            ViewCompat.c(view, 4);
        } else {
            ViewCompat.c(view, 1);
        }
        if (!j) {
            ViewCompat.a(view, this.l);
        }
    }

    public void onRtlPropertiesChanged(int i) {
        if (!k) {
            Drawable drawable;
            int h = ViewCompat.h(this);
            if (h == 0) {
                if (this.I != null) {
                    a(this.I, h);
                    drawable = this.I;
                }
                drawable = this.K;
            } else {
                if (this.J != null) {
                    a(this.J, h);
                    drawable = this.J;
                }
                drawable = this.K;
            }
            this.E = drawable;
            h = ViewCompat.h(this);
            if (h == 0) {
                if (this.J != null) {
                    a(this.J, h);
                    drawable = this.J;
                }
                drawable = this.L;
            } else {
                if (this.I != null) {
                    a(this.I, h);
                    drawable = this.I;
                }
                drawable = this.L;
            }
            this.F = drawable;
        }
    }

    static /* synthetic */ boolean f(View view) {
        return (ViewCompat.e(view) == 4 || ViewCompat.e(view) == 2) ? false : true;
    }
}
