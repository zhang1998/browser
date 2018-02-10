package android.mini.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.mini.support.annotation.CallSuper;
import android.mini.support.annotation.DrawableRes;
import android.mini.support.v4.c.c;
import android.mini.support.v4.e.e;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public class ViewPager extends ViewGroup {
    public static final Interpolator a = new bs();
    private static final cb aj = new cb();
    private static final int[] o = new int[]{16842931};
    private static final Comparator<bv> q = new br();
    private Drawable A;
    private int B;
    private int C;
    private int D;
    private int E;
    private boolean F;
    private boolean G;
    private boolean H;
    private int I = 1;
    private boolean J;
    private int K;
    private int L;
    private int M;
    private float N;
    private float O;
    private int P = -1;
    private int Q;
    private int R;
    private int S;
    private int T;
    private e U;
    private e V;
    private boolean W = true;
    private boolean aa = false;
    private boolean ab;
    private int ac;
    private List<bx> ad;
    private bx ae;
    private bx af;
    private List<Object> ag;
    private Method ah;
    private ArrayList<View> ai;
    private final Runnable ak = new bt(this);
    private int al = 0;
    public final ArrayList<bv> b = new ArrayList();
    public ao c;
    public Scroller d;
    public float e = -3.4028235E38f;
    public float f = Float.MAX_VALUE;
    public boolean g;
    public float h;
    public float i;
    public VelocityTracker j;
    public boolean k;
    public long l;
    public bz m;
    public int n;
    private int p;
    private final bv r = new bv();
    private final Rect s = new Rect();
    private int t;
    private int u = -1;
    private Parcelable v = null;
    private ClassLoader w = null;
    private boolean x;
    private by y;
    private int z;

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: ProGuard */
    public @interface DecorView {
    }

    /* compiled from: ProGuard */
    public class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public boolean a;
        public int b;
        float c = 0.0f;
        boolean d;
        int e;
        int f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.o);
            this.b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ProGuard */
    public class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = c.a(new ca());
        int c;
        Parcelable d;
        ClassLoader e;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
            parcel.writeParcelable(this.d, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.c + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.c = parcel.readInt();
            this.d = parcel.readParcelable(classLoader);
            this.e = classLoader;
        }
    }

    public ViewPager(Context context) {
        super(context);
        e();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    private void e() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.d = new Scroller(context, a);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.M = bq.a(viewConfiguration);
        this.Q = (int) (400.0f * f);
        this.R = viewConfiguration.getScaledMaximumFlingVelocity();
        this.U = new e(context);
        this.V = new e(context);
        this.S = (int) (25.0f * f);
        this.T = (int) (2.0f * f);
        this.K = (int) (16.0f * f);
        ViewCompat.a((View) this, new bw(this));
        if (ViewCompat.e(this) == 0) {
            ViewCompat.c((View) this, 1);
        }
        ViewCompat.a((View) this, new bu(this));
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.ak);
        if (!(this.d == null || this.d.isFinished())) {
            this.d.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    public void setScrollState(int i) {
        int i2 = 0;
        if (this.al != i) {
            this.al = i;
            if (this.m != null) {
                int i3;
                if (i != 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                int childCount = getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewCompat.a(getChildAt(i4), i3 != 0 ? 2 : 0, null);
                }
            }
            if (this.ae != null) {
                this.ae.b(i);
            }
            if (this.ad != null) {
                int size = this.ad.size();
                while (i2 < size) {
                    bx bxVar = (bx) this.ad.get(i2);
                    if (bxVar != null) {
                        bxVar.b(i);
                    }
                    i2++;
                }
            }
            if (this.af != null) {
                this.af.b(i);
            }
        }
    }

    public void setAdapter(ao aoVar) {
        int i = false;
        if (this.c != null) {
            int i2;
            this.c.a(null);
            for (i2 = 0; i2 < this.b.size(); i2++) {
                bv bvVar = (bv) this.b.get(i2);
                this.c.a(this, bvVar.b, bvVar.a);
            }
            this.b.clear();
            i2 = 0;
            while (i2 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i2).getLayoutParams()).a) {
                    removeViewAt(i2);
                    i2--;
                }
                i2++;
            }
            this.t = 0;
            scrollTo(0, 0);
        }
        this.c = aoVar;
        this.p = 0;
        if (this.c != null) {
            if (this.y == null) {
                this.y = new by();
            }
            this.c.a(this.y);
            this.H = false;
            boolean z = this.W;
            this.W = true;
            this.p = this.c.a();
            if (this.u >= 0) {
                a(this.u, false, true);
                this.u = -1;
                this.v = null;
                this.w = null;
            } else if (z) {
                requestLayout();
            } else {
                b();
            }
        }
        if (this.ag != null && !this.ag.isEmpty()) {
            int size = this.ag.size();
            while (i < size) {
                this.ag.get(i);
                i++;
            }
        }
    }

    public ao getAdapter() {
        return this.c;
    }

    public int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.H = false;
        if (this.W) {
            z = false;
        } else {
            z = true;
        }
        a(i, z, false);
    }

    public final void a(int i, boolean z) {
        this.H = false;
        a(i, z, false);
    }

    public int getCurrentItem() {
        return this.t;
    }

    private void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    private void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.c == null || this.c.a() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.t != i || this.b.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.c.a()) {
                i = this.c.a() - 1;
            }
            int i3 = this.I;
            if (i > this.t + i3 || i < this.t - i3) {
                for (int i4 = 0; i4 < this.b.size(); i4++) {
                    ((bv) this.b.get(i4)).c = true;
                }
            }
            if (this.t != i) {
                z3 = true;
            }
            if (this.W) {
                this.t = i;
                if (z3) {
                    d(i);
                }
                requestLayout();
                return;
            }
            b(i);
            a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        int clientWidth;
        bv c = c(i);
        if (c != null) {
            clientWidth = (int) (((float) getClientWidth()) * Math.max(this.e, Math.min(c.e, this.f)));
        } else {
            clientWidth = 0;
        }
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                int currX;
                int i3;
                Object obj = (this.d == null || this.d.isFinished()) ? null : 1;
                if (obj != null) {
                    currX = this.x ? this.d.getCurrX() : this.d.getStartX();
                    this.d.abortAnimation();
                    setScrollingCacheEnabled(false);
                    i3 = currX;
                } else {
                    i3 = getScrollX();
                }
                int scrollY = getScrollY();
                clientWidth -= i3;
                int i4 = 0 - scrollY;
                if (clientWidth == 0 && i4 == 0) {
                    a(false);
                    b();
                    setScrollState(0);
                } else {
                    setScrollingCacheEnabled(true);
                    setScrollState(2);
                    currX = getClientWidth();
                    int i5 = currX / 2;
                    float sin = (((float) i5) * ((float) Math.sin((double) ((float) (((double) (Math.min(IPictureView.DEFAULT_MIN_SCALE, (IPictureView.DEFAULT_MIN_SCALE * ((float) Math.abs(clientWidth))) / ((float) currX)) - 0.5f)) * 0.4712389167638204d))))) + ((float) i5);
                    int abs = Math.abs(i2);
                    if (abs > 0) {
                        currX = Math.round(1000.0f * Math.abs(sin / ((float) abs))) * 4;
                    } else {
                        currX = (int) (((((float) Math.abs(clientWidth)) / ((((float) currX) * IPictureView.DEFAULT_MIN_SCALE) + ((float) this.z))) + IPictureView.DEFAULT_MIN_SCALE) * 100.0f);
                    }
                    i5 = Math.min(currX, SecExceptionCode.SEC_ERROR_SIGNATRUE);
                    this.x = false;
                    this.d.startScroll(i3, scrollY, clientWidth, i4, i5);
                    ViewCompat.d(this);
                }
            }
            if (z2) {
                d(i);
                return;
            }
            return;
        }
        if (z2) {
            d(i);
        }
        a(false);
        scrollTo(clientWidth, 0);
        a(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(bx bxVar) {
        this.ae = bxVar;
    }

    public final void a(bx bxVar) {
        if (this.ad == null) {
            this.ad = new ArrayList();
        }
        this.ad.add(bxVar);
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ah == null) {
                try {
                    this.ah = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ah.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.n == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.ai.get(i2)).getLayoutParams()).f;
    }

    public int getOffscreenPageLimit() {
        return this.I;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.I) {
            this.I = i;
            b();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.z;
        this.z = i;
        int width = getWidth();
        a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.z;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.A = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(@DrawableRes int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.A;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.A;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    private bv a(int i, int i2) {
        bv bvVar = new bv();
        bvVar.b = i;
        bvVar.a = this.c.a((ViewGroup) this, i);
        bvVar.d = IPictureView.DEFAULT_MIN_SCALE;
        if (i2 < 0 || i2 >= this.b.size()) {
            this.b.add(bvVar);
        } else {
            this.b.add(i2, bvVar);
        }
        return bvVar;
    }

    final void a() {
        boolean z;
        int a = this.c.a();
        this.p = a;
        if (this.b.size() >= (this.I * 2) + 1 || this.b.size() >= a) {
            z = false;
        } else {
            z = true;
        }
        int i = this.t;
        boolean z2 = z;
        int i2 = 0;
        while (i2 < this.b.size()) {
            int i3;
            boolean z3;
            bv bvVar = (bv) this.b.get(i2);
            int a2 = this.c.a(bvVar.a);
            if (a2 != -1) {
                if (a2 == -2) {
                    this.b.remove(i2);
                    i2--;
                    this.c.a(this, bvVar.b, bvVar.a);
                    if (this.t == bvVar.b) {
                        i3 = i2;
                        i2 = Math.max(0, Math.min(this.t, a - 1));
                        z3 = true;
                    } else {
                        i3 = i2;
                        i2 = i;
                        z3 = true;
                    }
                } else if (bvVar.b != a2) {
                    if (bvVar.b == this.t) {
                        i = a2;
                    }
                    bvVar.b = a2;
                    i3 = i2;
                    i2 = i;
                    z3 = true;
                }
                z2 = z3;
                i = i2;
                i2 = i3 + 1;
            }
            i3 = i2;
            i2 = i;
            z3 = z2;
            z2 = z3;
            i = i2;
            i2 = i3 + 1;
        }
        Collections.sort(this.b, q);
        if (z2) {
            int childCount = getChildCount();
            for (i2 = 0; i2 < childCount; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!layoutParams.a) {
                    layoutParams.c = 0.0f;
                }
            }
            a(i, false, true);
            requestLayout();
        }
    }

    public final void b() {
        b(this.t);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.t;
        r0 = r18;
        if (r3 == r0) goto L_0x02f3;
    L_0x0009:
        r0 = r17;
        r2 = r0.t;
        r0 = r17;
        r2 = r0.c(r2);
        r0 = r18;
        r1 = r17;
        r1.t = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.c;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.f();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.H;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.f();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.I;
        r4 = 0;
        r0 = r17;
        r5 = r0.t;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.c;
        r11 = r4.a();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.t;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.p;
        if (r11 == r2) goto L_0x00be;
    L_0x005b:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00b4 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00b4 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00b4 }
    L_0x0067:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4.<init>(r5);
        r0 = r17;
        r5 = r0.p;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.c;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00b4:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0067;
    L_0x00be:
        r5 = 0;
        r2 = 0;
        r4 = r2;
    L_0x00c1:
        r0 = r17;
        r2 = r0.b;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x02f0;
    L_0x00cb:
        r0 = r17;
        r2 = r0.b;
        r2 = r2.get(r4);
        r2 = (android.mini.support.v4.view.bv) r2;
        r6 = r2.b;
        r0 = r17;
        r7 = r0.t;
        if (r6 < r7) goto L_0x0151;
    L_0x00dd:
        r6 = r2.b;
        r0 = r17;
        r7 = r0.t;
        if (r6 != r7) goto L_0x02f0;
    L_0x00e5:
        if (r2 != 0) goto L_0x02ed;
    L_0x00e7:
        if (r11 <= 0) goto L_0x02ed;
    L_0x00e9:
        r0 = r17;
        r2 = r0.t;
        r0 = r17;
        r2 = r0.a(r2, r4);
        r9 = r2;
    L_0x00f4:
        if (r9 == 0) goto L_0x026b;
    L_0x00f6:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x0156;
    L_0x00fb:
        r0 = r17;
        r2 = r0.b;
        r2 = r2.get(r7);
        r2 = (android.mini.support.v4.view.bv) r2;
    L_0x0105:
        r13 = r17.getClientWidth();
        if (r13 > 0) goto L_0x0158;
    L_0x010b:
        r5 = 0;
    L_0x010c:
        r0 = r17;
        r6 = r0.t;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x011a:
        if (r8 < 0) goto L_0x019e;
    L_0x011c:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x0168;
    L_0x0120:
        if (r8 >= r10) goto L_0x0168;
    L_0x0122:
        if (r2 == 0) goto L_0x019e;
    L_0x0124:
        r14 = r2.b;
        if (r8 != r14) goto L_0x014e;
    L_0x0128:
        r14 = r2.c;
        if (r14 != 0) goto L_0x014e;
    L_0x012c:
        r0 = r17;
        r14 = r0.b;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.c;
        r2 = r2.a;
        r0 = r17;
        r14.a(r0, r8, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x0166;
    L_0x0144:
        r0 = r17;
        r2 = r0.b;
        r2 = r2.get(r4);
        r2 = (android.mini.support.v4.view.bv) r2;
    L_0x014e:
        r8 = r8 + -1;
        goto L_0x011a;
    L_0x0151:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00c1;
    L_0x0156:
        r2 = 0;
        goto L_0x0105;
    L_0x0158:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.d;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x010c;
    L_0x0166:
        r2 = 0;
        goto L_0x014e;
    L_0x0168:
        if (r2 == 0) goto L_0x0182;
    L_0x016a:
        r14 = r2.b;
        if (r8 != r14) goto L_0x0182;
    L_0x016e:
        r2 = r2.d;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x0180;
    L_0x0175:
        r0 = r17;
        r2 = r0.b;
        r2 = r2.get(r4);
        r2 = (android.mini.support.v4.view.bv) r2;
        goto L_0x014e;
    L_0x0180:
        r2 = 0;
        goto L_0x014e;
    L_0x0182:
        r2 = r4 + 1;
        r0 = r17;
        r2 = r0.a(r8, r2);
        r2 = r2.d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x019c;
    L_0x0191:
        r0 = r17;
        r2 = r0.b;
        r2 = r2.get(r4);
        r2 = (android.mini.support.v4.view.bv) r2;
        goto L_0x014e;
    L_0x019c:
        r2 = 0;
        goto L_0x014e;
    L_0x019e:
        r5 = r9.d;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0266;
    L_0x01a8:
        r0 = r17;
        r2 = r0.b;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x020c;
    L_0x01b2:
        r0 = r17;
        r2 = r0.b;
        r2 = r2.get(r8);
        r2 = (android.mini.support.v4.view.bv) r2;
        r6 = r2;
    L_0x01bd:
        if (r13 > 0) goto L_0x020e;
    L_0x01bf:
        r2 = 0;
        r4 = r2;
    L_0x01c1:
        r0 = r17;
        r2 = r0.t;
        r2 = r2 + 1;
        r15 = r6;
        r6 = r8;
        r8 = r2;
        r2 = r15;
    L_0x01cb:
        if (r8 >= r11) goto L_0x0266;
    L_0x01cd:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x021c;
    L_0x01d1:
        if (r8 <= r12) goto L_0x021c;
    L_0x01d3:
        if (r2 == 0) goto L_0x0266;
    L_0x01d5:
        r10 = r2.b;
        if (r8 != r10) goto L_0x02e8;
    L_0x01d9:
        r10 = r2.c;
        if (r10 != 0) goto L_0x02e8;
    L_0x01dd:
        r0 = r17;
        r10 = r0.b;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.c;
        r2 = r2.a;
        r0 = r17;
        r10.a(r0, r8, r2);
        r0 = r17;
        r2 = r0.b;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x021a;
    L_0x01f9:
        r0 = r17;
        r2 = r0.b;
        r2 = r2.get(r6);
        r2 = (android.mini.support.v4.view.bv) r2;
    L_0x0203:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x0206:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x01cb;
    L_0x020c:
        r6 = 0;
        goto L_0x01bd;
    L_0x020e:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x01c1;
    L_0x021a:
        r2 = 0;
        goto L_0x0203;
    L_0x021c:
        if (r2 == 0) goto L_0x0241;
    L_0x021e:
        r10 = r2.b;
        if (r8 != r10) goto L_0x0241;
    L_0x0222:
        r2 = r2.d;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.b;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x023f;
    L_0x0231:
        r0 = r17;
        r2 = r0.b;
        r2 = r2.get(r6);
        r2 = (android.mini.support.v4.view.bv) r2;
    L_0x023b:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x0206;
    L_0x023f:
        r2 = 0;
        goto L_0x023b;
    L_0x0241:
        r0 = r17;
        r2 = r0.a(r8, r6);
        r6 = r6 + 1;
        r2 = r2.d;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.b;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0264;
    L_0x0256:
        r0 = r17;
        r2 = r0.b;
        r2 = r2.get(r6);
        r2 = (android.mini.support.v4.view.bv) r2;
    L_0x0260:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x0206;
    L_0x0264:
        r2 = 0;
        goto L_0x0260;
    L_0x0266:
        r0 = r17;
        r0.a(r9, r7, r3);
    L_0x026b:
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x0271:
        if (r3 >= r4) goto L_0x02a0;
    L_0x0273:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (android.mini.support.v4.view.ViewPager.LayoutParams) r2;
        r2.f = r3;
        r6 = r2.a;
        if (r6 != 0) goto L_0x029c;
    L_0x0285:
        r6 = r2.c;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x029c;
    L_0x028c:
        r0 = r17;
        r5 = r0.a(r5);
        if (r5 == 0) goto L_0x029c;
    L_0x0294:
        r6 = r5.d;
        r2.c = r6;
        r5 = r5.b;
        r2.e = r5;
    L_0x029c:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0271;
    L_0x02a0:
        r17.f();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02a9:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x02e6;
    L_0x02af:
        r0 = r17;
        r2 = r0.b(r2);
    L_0x02b5:
        if (r2 == 0) goto L_0x02bf;
    L_0x02b7:
        r2 = r2.b;
        r0 = r17;
        r3 = r0.t;
        if (r2 == r3) goto L_0x0023;
    L_0x02bf:
        r2 = 0;
    L_0x02c0:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02c6:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.a(r3);
        if (r4 == 0) goto L_0x02e3;
    L_0x02d4:
        r4 = r4.b;
        r0 = r17;
        r5 = r0.t;
        if (r4 != r5) goto L_0x02e3;
    L_0x02dc:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x02e3:
        r2 = r2 + 1;
        goto L_0x02c0;
    L_0x02e6:
        r2 = 0;
        goto L_0x02b5;
    L_0x02e8:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x0206;
    L_0x02ed:
        r9 = r2;
        goto L_0x00f4;
    L_0x02f0:
        r2 = r5;
        goto L_0x00e5;
    L_0x02f3:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.mini.support.v4.view.ViewPager.b(int):void");
    }

    private void f() {
        if (this.n != 0) {
            if (this.ai == null) {
                this.ai = new ArrayList();
            } else {
                this.ai.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ai.add(getChildAt(i));
            }
            Collections.sort(this.ai, aj);
        }
    }

    private void a(bv bvVar, int i, bv bvVar2) {
        float f;
        int i2;
        bv bvVar3;
        float f2;
        int i3;
        int a = this.c.a();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.z) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (bvVar2 != null) {
            clientWidth = bvVar2.b;
            float f3;
            int i4;
            int i5;
            if (clientWidth < bvVar.b) {
                f3 = (bvVar2.e + bvVar2.d) + f;
                i2 = 0;
                i4 = clientWidth + 1;
                while (i4 <= bvVar.b && i2 < this.b.size()) {
                    bvVar3 = (bv) this.b.get(i2);
                    while (i4 > bvVar3.b && i2 < this.b.size() - 1) {
                        i2++;
                        bvVar3 = (bv) this.b.get(i2);
                    }
                    i5 = i4;
                    f2 = f3;
                    i3 = i5;
                    while (i3 < bvVar3.b) {
                        i3++;
                        f2 = (IPictureView.DEFAULT_MIN_SCALE + f) + f2;
                    }
                    bvVar3.e = f2;
                    f2 += bvVar3.d + f;
                    clientWidth = i3 + 1;
                    f3 = f2;
                    i4 = clientWidth;
                }
            } else if (clientWidth > bvVar.b) {
                i2 = this.b.size() - 1;
                f3 = bvVar2.e;
                i4 = clientWidth - 1;
                while (i4 >= bvVar.b && i2 >= 0) {
                    bvVar3 = (bv) this.b.get(i2);
                    while (i4 < bvVar3.b && i2 > 0) {
                        i2--;
                        bvVar3 = (bv) this.b.get(i2);
                    }
                    i5 = i4;
                    f2 = f3;
                    i3 = i5;
                    while (i3 > bvVar3.b) {
                        i3--;
                        f2 -= IPictureView.DEFAULT_MIN_SCALE + f;
                    }
                    f2 -= bvVar3.d + f;
                    bvVar3.e = f2;
                    clientWidth = i3 - 1;
                    f3 = f2;
                    i4 = clientWidth;
                }
            }
        }
        int size = this.b.size();
        f2 = bvVar.e;
        i3 = bvVar.b - 1;
        this.e = bvVar.b == 0 ? bvVar.e : -3.4028235E38f;
        this.f = bvVar.b == a + -1 ? (bvVar.e + bvVar.d) - IPictureView.DEFAULT_MIN_SCALE : Float.MAX_VALUE;
        for (i2 = i - 1; i2 >= 0; i2--) {
            bvVar3 = (bv) this.b.get(i2);
            while (i3 > bvVar3.b) {
                i3--;
                f2 -= IPictureView.DEFAULT_MIN_SCALE + f;
            }
            f2 -= bvVar3.d + f;
            bvVar3.e = f2;
            if (bvVar3.b == 0) {
                this.e = f2;
            }
            i3--;
        }
        f2 = (bvVar.e + bvVar.d) + f;
        i3 = bvVar.b + 1;
        for (i2 = i + 1; i2 < size; i2++) {
            bvVar3 = (bv) this.b.get(i2);
            while (i3 < bvVar3.b) {
                i3++;
                f2 += IPictureView.DEFAULT_MIN_SCALE + f;
            }
            if (bvVar3.b == a - 1) {
                this.f = (bvVar3.d + f2) - IPictureView.DEFAULT_MIN_SCALE;
            }
            bvVar3.e = f2;
            f2 += bvVar3.d + f;
            i3++;
        }
        this.aa = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = this.t;
        if (this.c != null) {
            savedState.d = null;
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.b);
            if (this.c != null) {
                Parcelable parcelable2 = savedState.d;
                ClassLoader classLoader = savedState.e;
                a(savedState.c, false, true);
                return;
            }
            this.u = savedState.c;
            this.v = savedState.d;
            this.w = savedState.e;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams layoutParams2;
        int i2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
        boolean z = layoutParams3.a;
        if (view.getClass().getAnnotation(DecorView.class) != null) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        layoutParams3.a = i2 | z;
        if (!this.F) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.a) {
            layoutParams3.d = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.F) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    private bv a(View view) {
        for (int i = 0; i < this.b.size(); i++) {
            bv bvVar = (bv) this.b.get(i);
            if (this.c.a(view, bvVar.a)) {
                return bvVar;
            }
        }
        return null;
    }

    private bv b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    private bv c(int i) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            bv bvVar = (bv) this.b.get(i2);
            if (bvVar.b == i) {
                return bvVar;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.W = true;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.L = Math.min(measuredWidth / 10, this.K);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            LayoutParams layoutParams;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.a) {
                    int i6 = layoutParams.b & 7;
                    int i7 = layoutParams.b & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED;
                    i3 = SectionHeader.SHT_LOUSER;
                    i5 = SectionHeader.SHT_LOUSER;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = UCCore.VERIFY_POLICY_QUICK;
                    } else if (obj2 != null) {
                        i5 = UCCore.VERIFY_POLICY_QUICK;
                    }
                    if (layoutParams.width != -2) {
                        i7 = UCCore.VERIFY_POLICY_QUICK;
                        i3 = layoutParams.width != -1 ? layoutParams.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (layoutParams.height != -2) {
                        i5 = UCCore.VERIFY_POLICY_QUICK;
                        if (layoutParams.height != -1) {
                            measuredWidth = layoutParams.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.D = MeasureSpec.makeMeasureSpec(paddingLeft, UCCore.VERIFY_POLICY_QUICK);
        this.E = MeasureSpec.makeMeasureSpec(measuredHeight, UCCore.VERIFY_POLICY_QUICK);
        this.F = true;
        b();
        this.F = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams == null || !layoutParams.a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.c * ((float) paddingLeft)), UCCore.VERIFY_POLICY_QUICK), this.E);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            a(i, i3, this.z, this.z);
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.b.isEmpty()) {
            bv c = c(this.t);
            int min = (int) ((c != null ? Math.min(c.e, this.f) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                a(false);
                scrollTo(min, getScrollY());
            }
        } else if (this.d.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.d.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            LayoutParams layoutParams;
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.a) {
                    int i9 = layoutParams.b & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED;
                    switch (layoutParams.b & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.a) {
                    bv a = a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.e * ((float) max))) + paddingLeft;
                        if (layoutParams.d) {
                            layoutParams.d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.c * ((float) max)), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, UCCore.VERIFY_POLICY_QUICK));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.B = paddingTop;
        this.C = i6 - paddingBottom;
        this.ac = i7;
        if (this.W) {
            a(this.t, false, 0, false);
        }
        this.W = false;
    }

    public void computeScroll() {
        this.x = true;
        if (this.d.isFinished() || !this.d.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.d.getCurrX();
        int currY = this.d.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!a(currX)) {
                this.d.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.d(this);
    }

    public final boolean a(int i) {
        if (this.b.size() != 0) {
            bv i2 = i();
            int clientWidth = getClientWidth();
            int i3 = this.z + clientWidth;
            float f = ((float) this.z) / ((float) clientWidth);
            int i4 = i2.b;
            float f2 = ((((float) i) / ((float) clientWidth)) - i2.e) / (i2.d + f);
            clientWidth = (int) (((float) i3) * f2);
            this.ab = false;
            a(i4, f2, clientWidth);
            if (this.ab) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.W) {
            return false;
        } else {
            this.ab = false;
            a(0, 0.0f, 0);
            if (this.ab) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    @CallSuper
    private void a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.ac > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.a) {
                    int max;
                    switch (layoutParams.b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        if (this.ae != null) {
            this.ae.a(i, f, i2);
        }
        if (this.ad != null) {
            paddingRight = this.ad.size();
            for (paddingLeft = 0; paddingLeft < paddingRight; paddingLeft++) {
                bx bxVar = (bx) this.ad.get(paddingLeft);
                if (bxVar != null) {
                    bxVar.a(i, f, i2);
                }
            }
        }
        if (this.af != null) {
            this.af.a(i, f, i2);
        }
        if (this.m != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).a) {
                    this.m.a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.ab = true;
    }

    private void d(int i) {
        if (this.ae != null) {
            this.ae.a(i);
        }
        if (this.ad != null) {
            int size = this.ad.size();
            for (int i2 = 0; i2 < size; i2++) {
                bx bxVar = (bx) this.ad.get(i2);
                if (bxVar != null) {
                    bxVar.a(i);
                }
            }
        }
        if (this.af != null) {
            this.af.a(i);
        }
    }

    private void a(boolean z) {
        int scrollX;
        boolean z2 = this.al == 2;
        if (z2) {
            boolean z3;
            setScrollingCacheEnabled(false);
            if (this.d.isFinished()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                this.d.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.d.getCurrX();
                int currY = this.d.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        a(currX);
                    }
                }
            }
        }
        this.H = false;
        boolean z4 = z2;
        for (scrollX = 0; scrollX < this.b.size(); scrollX++) {
            bv bvVar = (bv) this.b.get(scrollX);
            if (bvVar.c) {
                bvVar.c = false;
                z4 = true;
            }
        }
        if (!z4) {
            return;
        }
        if (z) {
            ViewCompat.a((View) this, this.ak);
        } else {
            this.ak.run();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            g();
            return false;
        }
        if (action != 0) {
            if (this.g) {
                return true;
            }
            if (this.J) {
                return false;
            }
        }
        float x;
        switch (action) {
            case 0:
                x = motionEvent.getX();
                this.i = x;
                this.h = x;
                x = motionEvent.getY();
                this.O = x;
                this.N = x;
                this.P = aj.b(motionEvent, 0);
                this.J = false;
                this.x = true;
                this.d.computeScrollOffset();
                if (this.al == 2 && Math.abs(this.d.getFinalX() - this.d.getCurrX()) > this.T) {
                    this.d.abortAnimation();
                    this.H = false;
                    b();
                    this.g = true;
                    h();
                    setScrollState(1);
                    break;
                }
                a(false);
                this.g = false;
                break;
                break;
            case 2:
                action = this.P;
                if (action != -1) {
                    action = aj.a(motionEvent, action);
                    float c = aj.c(motionEvent, action);
                    float f = c - this.h;
                    float abs = Math.abs(f);
                    float d = aj.d(motionEvent, action);
                    float abs2 = Math.abs(d - this.O);
                    if (f != 0.0f) {
                        boolean z;
                        x = this.h;
                        if ((x >= ((float) this.L) || f <= 0.0f) && (x <= ((float) (getWidth() - this.L)) || f >= 0.0f)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && a(this, false, (int) f, (int) c, (int) d)) {
                            this.h = c;
                            this.N = d;
                            this.J = true;
                            return false;
                        }
                    }
                    if (abs > ((float) this.M) && 0.5f * abs > abs2) {
                        this.g = true;
                        h();
                        setScrollState(1);
                        this.h = f > 0.0f ? this.i + ((float) this.M) : this.i - ((float) this.M);
                        this.N = d;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.M)) {
                        this.J = true;
                    }
                    if (this.g && a(c)) {
                        ViewCompat.d(this);
                        break;
                    }
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        if (this.j == null) {
            this.j = VelocityTracker.obtain();
        }
        this.j.addMovement(motionEvent);
        return this.g;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.k) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.c == null || this.c.a() == 0) {
            return false;
        }
        if (this.j == null) {
            this.j = VelocityTracker.obtain();
        }
        this.j.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.d.abortAnimation();
                this.H = false;
                b();
                x = motionEvent.getX();
                this.i = x;
                this.h = x;
                x = motionEvent.getY();
                this.O = x;
                this.N = x;
                this.P = aj.b(motionEvent, 0);
                break;
            case 1:
                if (this.g) {
                    VelocityTracker velocityTracker = this.j;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.R);
                    a = (int) at.a(velocityTracker, this.P);
                    this.H = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    bv i = i();
                    a(a(i.b, ((((float) scrollX) / ((float) clientWidth)) - i.e) / (i.d + (((float) this.z) / ((float) clientWidth))), a, (int) (aj.c(motionEvent, aj.a(motionEvent, this.P)) - this.i)), true, true, a);
                    z = g();
                    break;
                }
                break;
            case 2:
                if (!this.g) {
                    a = aj.a(motionEvent, this.P);
                    if (a == -1) {
                        z = g();
                        break;
                    }
                    float c = aj.c(motionEvent, a);
                    float abs = Math.abs(c - this.h);
                    float d = aj.d(motionEvent, a);
                    x = Math.abs(d - this.N);
                    if (abs > ((float) this.M) && abs > x) {
                        this.g = true;
                        h();
                        if (c - this.i > 0.0f) {
                            x = this.i + ((float) this.M);
                        } else {
                            x = this.i - ((float) this.M);
                        }
                        this.h = x;
                        this.N = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.g) {
                    z = a(aj.c(motionEvent, aj.a(motionEvent, this.P))) | 0;
                    break;
                }
                break;
            case 3:
                if (this.g) {
                    a(this.t, true, 0, false);
                    z = g();
                    break;
                }
                break;
            case 5:
                a = aj.b(motionEvent);
                this.h = aj.c(motionEvent, a);
                this.P = aj.b(motionEvent, a);
                break;
            case 6:
                a(motionEvent);
                this.h = aj.c(motionEvent, aj.a(motionEvent, this.P));
                break;
        }
        if (z) {
            ViewCompat.d(this);
        }
        return true;
    }

    private boolean g() {
        this.P = -1;
        j();
        return this.U.c() | this.V.c();
    }

    private void h() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean a(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.h - f;
        this.h = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.e;
        float f5 = ((float) clientWidth) * this.f;
        bv bvVar = (bv) this.b.get(0);
        bv bvVar2 = (bv) this.b.get(this.b.size() - 1);
        if (bvVar.b != 0) {
            f4 = bvVar.e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (bvVar2.b != this.c.a() - 1) {
            f2 = bvVar2.e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.U.a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.V.a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.h += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        a((int) f4);
        return z3;
    }

    private bv i() {
        float f;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.z) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        bv bvVar = null;
        while (i2 < this.b.size()) {
            int i3;
            bv bvVar2;
            bv bvVar3 = (bv) this.b.get(i2);
            bv bvVar4;
            if (obj != null || bvVar3.b == i + 1) {
                bvVar4 = bvVar3;
                i3 = i2;
                bvVar2 = bvVar4;
            } else {
                bvVar3 = this.r;
                bvVar3.e = (f2 + f3) + f;
                bvVar3.b = i + 1;
                bvVar3.d = IPictureView.DEFAULT_MIN_SCALE;
                bvVar4 = bvVar3;
                i3 = i2 - 1;
                bvVar2 = bvVar4;
            }
            f2 = bvVar2.e;
            f3 = (bvVar2.d + f2) + f;
            if (obj == null && scrollX < f2) {
                return bvVar;
            }
            if (scrollX < f3 || i3 == this.b.size() - 1) {
                return bvVar2;
            }
            f3 = f2;
            i = bvVar2.b;
            obj = null;
            f2 = bvVar2.d;
            bvVar = bvVar2;
            i2 = i3 + 1;
        }
        return bvVar;
    }

    private int a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.S || Math.abs(i2) <= this.Q) {
            i += (int) ((i >= this.t ? 0.4f : 0.6f) + f);
        } else if (i2 <= 0) {
            i++;
        }
        if (this.b.size() <= 0) {
            return i;
        }
        return Math.max(((bv) this.b.get(0)).b, Math.min(i, ((bv) this.b.get(this.b.size() - 1)).b));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = ViewCompat.a(this);
        if (a == 0 || (a == 1 && this.c != null && this.c.a() > 1)) {
            int width;
            if (!this.U.a()) {
                a = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), this.e * ((float) width));
                this.U.a(i, width);
                i = this.U.a(canvas) | 0;
                canvas.restoreToCount(a);
            }
            if (!this.V.a()) {
                a = canvas.save();
                width = getWidth();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f + IPictureView.DEFAULT_MIN_SCALE)) * ((float) width));
                this.V.a(height, width);
                i |= this.V.a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.U.b();
            this.V.b();
        }
        if (i != 0) {
            ViewCompat.d(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.z > 0 && this.A != null && this.b.size() > 0 && this.c != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.z) / ((float) width);
            bv bvVar = (bv) this.b.get(0);
            float f2 = bvVar.e;
            int size = this.b.size();
            int i = bvVar.b;
            int i2 = ((bv) this.b.get(size - 1)).b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > bvVar.b && i3 < size) {
                    i3++;
                    bvVar = (bv) this.b.get(i3);
                }
                if (i4 == bvVar.b) {
                    f3 = (bvVar.e + bvVar.d) * ((float) width);
                    f2 = (bvVar.e + bvVar.d) + f;
                } else {
                    f3 = (IPictureView.DEFAULT_MIN_SCALE + f2) * ((float) width);
                    f2 += IPictureView.DEFAULT_MIN_SCALE + f;
                }
                if (((float) this.z) + f3 > ((float) scrollX)) {
                    this.A.setBounds(Math.round(f3), this.B, Math.round(((float) this.z) + f3), this.C);
                    this.A.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public final void c() {
        if (this.k) {
            if (this.c != null) {
                VelocityTracker velocityTracker = this.j;
                velocityTracker.computeCurrentVelocity(1000, (float) this.R);
                int a = (int) at.a(velocityTracker, this.P);
                this.H = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                bv i = i();
                a(a(i.b, ((((float) scrollX) / ((float) clientWidth)) - i.e) / i.d, a, (int) (this.h - this.i)), true, true, a);
            }
            j();
            this.k = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    private void a(MotionEvent motionEvent) {
        int b = aj.b(motionEvent);
        if (aj.b(motionEvent, b) == this.P) {
            b = b == 0 ? 1 : 0;
            this.h = aj.c(motionEvent, b);
            this.P = aj.b(motionEvent, b);
            if (this.j != null) {
                this.j.clear();
            }
        }
    }

    private void j() {
        this.g = false;
        this.J = false;
        if (this.j != null) {
            this.j.recycle();
            this.j = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.G != z) {
            this.G = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        if (this.c == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.e))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollX >= ((int) (((float) clientWidth) * this.f))) {
            return false;
        } else {
            return true;
        }
    }

    private boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && ViewCompat.a(view, -i)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
        r4 = this;
        r1 = 1;
        r0 = 0;
        r2 = super.dispatchKeyEvent(r5);
        if (r2 != 0) goto L_0x0018;
    L_0x0008:
        r2 = r5.getAction();
        if (r2 != 0) goto L_0x0015;
    L_0x000e:
        r2 = r5.getKeyCode();
        switch(r2) {
            case 21: goto L_0x001a;
            case 22: goto L_0x0021;
            case 61: goto L_0x0028;
            default: goto L_0x0015;
        };
    L_0x0015:
        r2 = r0;
    L_0x0016:
        if (r2 == 0) goto L_0x0019;
    L_0x0018:
        r0 = r1;
    L_0x0019:
        return r0;
    L_0x001a:
        r2 = 17;
        r2 = r4.e(r2);
        goto L_0x0016;
    L_0x0021:
        r2 = 66;
        r2 = r4.e(r2);
        goto L_0x0016;
    L_0x0028:
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = 11;
        if (r2 < r3) goto L_0x0015;
    L_0x002e:
        r2 = android.mini.support.v4.view.s.b(r5);
        if (r2 == 0) goto L_0x003a;
    L_0x0034:
        r2 = 2;
        r2 = r4.e(r2);
        goto L_0x0016;
    L_0x003a:
        r2 = android.mini.support.v4.view.s.a(r5);
        if (r2 == 0) goto L_0x0015;
    L_0x0040:
        r2 = r4.e(r1);
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.mini.support.v4.view.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(int r10) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 66;
        r7 = 17;
        r4 = 0;
        r3 = 1;
        r2 = r9.findFocus();
        if (r2 != r9) goto L_0x003f;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r1 = android.view.FocusFinder.getInstance();
        r1 = r1.findNextFocus(r9, r0, r10);
        if (r1 == 0) goto L_0x00bd;
    L_0x0018:
        if (r1 == r0) goto L_0x00bd;
    L_0x001a:
        if (r10 != r7) goto L_0x00a1;
    L_0x001c:
        r2 = r9.s;
        r2 = r9.a(r2, r1);
        r2 = r2.left;
        r3 = r9.s;
        r3 = r9.a(r3, r0);
        r3 = r3.left;
        if (r0 == 0) goto L_0x009c;
    L_0x002e:
        if (r2 < r3) goto L_0x009c;
    L_0x0030:
        r0 = r9.k();
    L_0x0034:
        r4 = r0;
    L_0x0035:
        if (r4 == 0) goto L_0x003e;
    L_0x0037:
        r0 = android.view.SoundEffectConstants.getContantForFocusDirection(r10);
        r9.playSoundEffect(r0);
    L_0x003e:
        return r4;
    L_0x003f:
        if (r2 == 0) goto L_0x00e9;
    L_0x0041:
        r0 = r2.getParent();
    L_0x0045:
        r5 = r0 instanceof android.view.ViewGroup;
        if (r5 == 0) goto L_0x00ec;
    L_0x0049:
        if (r0 != r9) goto L_0x007c;
    L_0x004b:
        r0 = r3;
    L_0x004c:
        if (r0 != 0) goto L_0x00e9;
    L_0x004e:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r2.getClass();
        r0 = r0.getSimpleName();
        r5.append(r0);
        r0 = r2.getParent();
    L_0x0062:
        r2 = r0 instanceof android.view.ViewGroup;
        if (r2 == 0) goto L_0x0081;
    L_0x0066:
        r2 = " => ";
        r2 = r5.append(r2);
        r6 = r0.getClass();
        r6 = r6.getSimpleName();
        r2.append(r6);
        r0 = r0.getParent();
        goto L_0x0062;
    L_0x007c:
        r0 = r0.getParent();
        goto L_0x0045;
    L_0x0081:
        r0 = "ViewPager";
        r2 = new java.lang.StringBuilder;
        r6 = "arrowScroll tried to find focus based on non-child current focused view ";
        r2.<init>(r6);
        r5 = r5.toString();
        r2 = r2.append(r5);
        r2 = r2.toString();
        android.util.Log.e(r0, r2);
        r0 = r1;
        goto L_0x000e;
    L_0x009c:
        r0 = r1.requestFocus();
        goto L_0x0034;
    L_0x00a1:
        if (r10 != r8) goto L_0x0035;
    L_0x00a3:
        r2 = r9.s;
        r2 = r9.a(r2, r1);
        r2 = r2.left;
        r5 = r9.s;
        r5 = r9.a(r5, r0);
        r5 = r5.left;
        if (r0 == 0) goto L_0x00b7;
    L_0x00b5:
        if (r2 <= r5) goto L_0x00cc;
    L_0x00b7:
        r0 = r1.requestFocus();
        goto L_0x0034;
    L_0x00bd:
        if (r10 == r7) goto L_0x00c1;
    L_0x00bf:
        if (r10 != r3) goto L_0x00c7;
    L_0x00c1:
        r0 = r9.k();
        goto L_0x0034;
    L_0x00c7:
        if (r10 == r8) goto L_0x00cc;
    L_0x00c9:
        r0 = 2;
        if (r10 != r0) goto L_0x0035;
    L_0x00cc:
        r0 = r9.c;
        if (r0 == 0) goto L_0x00e6;
    L_0x00d0:
        r0 = r9.t;
        r1 = r9.c;
        r1 = r1.a();
        r1 = r1 + -1;
        if (r0 >= r1) goto L_0x00e6;
    L_0x00dc:
        r0 = r9.t;
        r0 = r0 + 1;
        r9.a(r0, r3);
        r0 = r3;
        goto L_0x0034;
    L_0x00e6:
        r0 = r4;
        goto L_0x0034;
    L_0x00e9:
        r0 = r2;
        goto L_0x000e;
    L_0x00ec:
        r0 = r4;
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.mini.support.v4.view.ViewPager.e(int):boolean");
    }

    private Rect a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private boolean k() {
        if (this.t <= 0) {
            return false;
        }
        a(this.t - 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    bv a = a(childAt);
                    if (a != null && a.b == this.t) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                bv a = a(childAt);
                if (a != null && a.b == this.t) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                bv a = a(childAt);
                if (a != null && a.b == this.t && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == SpdyProtocol.SLIGHTSSL_0_RTT_MODE) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                bv a = a(childAt);
                if (a != null && a.b == this.t && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
