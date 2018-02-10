package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.CallSuper;
import android.support.annotation.DrawableRes;
import android.support.v4.os.d;
import android.support.v4.widget.bx;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public class ViewPager extends ViewGroup {
    private static final int[] a = new int[]{16842931};
    private static final ag ai = new ag();
    private static final Comparator<bk> c = new br();
    private static final Interpolator d = new ax();
    private int A = 1;
    private boolean B;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private int K = -1;
    private VelocityTracker L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private bx R;
    private bx S;
    private boolean T = true;
    private boolean U = false;
    private boolean V;
    private int W;
    private List<ef> aa;
    private ef ab;
    private ef ac;
    private cg ad;
    private ak ae;
    private Method af;
    private int ag;
    private ArrayList<View> ah;
    private final Runnable aj = new ap(this);
    private int ak = 0;
    private int b;
    private final ArrayList<bk> e = new ArrayList();
    private final bk f = new bk();
    private final Rect g = new Rect();
    private dr h;
    private int i;
    private int j = -1;
    private Parcelable k = null;
    private ClassLoader l = null;
    private Scroller m;
    private boolean n;
    private ec o;
    private int p;
    private Drawable q;
    private int r;
    private int s;
    private float t = -3.4028235E38f;
    private float u = Float.MAX_VALUE;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;

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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.a);
            this.b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ProGuard */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = d.a(new ci());
        int a;
        Parcelable b;
        ClassLoader c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeParcelable(this.b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.a = parcel.readInt();
            this.b = parcel.readParcelable(classLoader);
            this.c = classLoader;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.m = new Scroller(context2, d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f = context2.getResources().getDisplayMetrics().density;
        this.F = eh.a(viewConfiguration);
        this.M = (int) (400.0f * f);
        this.N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.R = new bx(context2);
        this.S = new bx(context2);
        this.O = (int) (25.0f * f);
        this.P = (int) (2.0f * f);
        this.D = (int) (16.0f * f);
        ViewCompat.a((View) this, new at(this));
        if (ViewCompat.e(this) == 0) {
            ViewCompat.c((View) this, 1);
        }
        ViewCompat.a((View) this, new bz(this));
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.aj);
        if (!(this.m == null || this.m.isFinished())) {
            this.m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    private void setScrollState(int i) {
        int i2 = 0;
        if (this.ak != i) {
            this.ak = i;
            if (this.ae != null) {
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
            if (this.ab != null) {
                this.ab.a(i);
            }
            if (this.aa != null) {
                int size = this.aa.size();
                while (i2 < size) {
                    ef efVar = (ef) this.aa.get(i2);
                    if (efVar != null) {
                        efVar.a(i);
                    }
                    i2++;
                }
            }
            if (this.ac != null) {
                this.ac.a(i);
            }
        }
    }

    public void setAdapter(dr drVar) {
        if (this.h != null) {
            this.h.a(null);
            for (int i = 0; i < this.e.size(); i++) {
                this.e.get(i);
                dr.b();
            }
            this.e.clear();
            int i2 = 0;
            while (i2 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i2).getLayoutParams()).a) {
                    removeViewAt(i2);
                    i2--;
                }
                i2++;
            }
            this.i = 0;
            scrollTo(0, 0);
        }
        dr drVar2 = this.h;
        this.h = drVar;
        this.b = 0;
        if (this.h != null) {
            if (this.o == null) {
                this.o = new ec();
            }
            this.h.a(this.o);
            this.z = false;
            boolean z = this.T;
            this.T = true;
            this.b = this.h.a();
            if (this.j >= 0) {
                a(this.j, false, true);
                this.j = -1;
                this.k = null;
                this.l = null;
            } else if (z) {
                requestLayout();
            } else {
                b();
            }
        }
        if (this.ad != null && drVar2 != drVar) {
            this.ad.a(drVar2, drVar);
        }
    }

    public dr getAdapter() {
        return this.h;
    }

    void setOnAdapterChangeListener(cg cgVar) {
        this.ad = cgVar;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.z = false;
        if (this.T) {
            z = false;
        } else {
            z = true;
        }
        a(i, z, false);
    }

    private void setCurrentItem$2563266(int i) {
        this.z = false;
        a(i, true, false);
    }

    public int getCurrentItem() {
        return this.i;
    }

    private void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    private void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.h == null || this.h.a() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.i != i || this.e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.h.a()) {
                i = this.h.a() - 1;
            }
            int i3 = this.A;
            if (i > this.i + i3 || i < this.i - i3) {
                for (int i4 = 0; i4 < this.e.size(); i4++) {
                    ((bk) this.e.get(i4)).b = true;
                }
            }
            if (this.i != i) {
                z3 = true;
            }
            if (this.T) {
                this.i = i;
                if (z3) {
                    f();
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
        bk c = c(i);
        if (c != null) {
            clientWidth = (int) (((float) getClientWidth()) * Math.max(this.t, Math.min(c.d, this.u)));
        } else {
            clientWidth = 0;
        }
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                int currX;
                int i3;
                Object obj = (this.m == null || this.m.isFinished()) ? null : 1;
                if (obj != null) {
                    currX = this.n ? this.m.getCurrX() : this.m.getStartX();
                    this.m.abortAnimation();
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
                        currX = (int) (((((float) Math.abs(clientWidth)) / ((((float) currX) * IPictureView.DEFAULT_MIN_SCALE) + ((float) this.p))) + IPictureView.DEFAULT_MIN_SCALE) * 100.0f);
                    }
                    i5 = Math.min(currX, SecExceptionCode.SEC_ERROR_SIGNATRUE);
                    this.n = false;
                    this.m.startScroll(i3, scrollY, clientWidth, i4, i5);
                    ViewCompat.d(this);
                }
            }
            if (z2) {
                f();
                return;
            }
            return;
        }
        if (z2) {
            f();
        }
        a(false);
        scrollTo(clientWidth, 0);
        d(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(ef efVar) {
        this.ab = efVar;
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.af == null) {
                try {
                    this.af = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.af.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ag == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.ah.get(i2)).getLayoutParams()).f;
    }

    final ef a(ef efVar) {
        ef efVar2 = this.ac;
        this.ac = efVar;
        return efVar2;
    }

    public int getOffscreenPageLimit() {
        return this.A;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.A) {
            this.A = i;
            b();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.p;
        this.p = i;
        int width = getWidth();
        a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.p;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.q = drawable;
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
        return super.verifyDrawable(drawable) || drawable == this.q;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    private static bk a(int i) {
        new bk().a = i;
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    final void a() {
        int i;
        int a = this.h.a();
        this.b = a;
        boolean z = this.e.size() < (this.A * 2) + 1 && this.e.size() < a;
        int i2 = this.i;
        for (i = 0; i < this.e.size(); i++) {
            this.e.get(i);
        }
        Collections.sort(this.e, c);
        if (z) {
            int childCount = getChildCount();
            for (i = 0; i < childCount; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                if (!layoutParams.a) {
                    layoutParams.c = 0.0f;
                }
            }
            a(i2, false, true);
            requestLayout();
        }
    }

    final void b() {
        b(this.i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.i;
        r0 = r18;
        if (r3 == r0) goto L_0x02d7;
    L_0x0009:
        r0 = r17;
        r2 = r0.i;
        r0 = r17;
        r2 = r0.c(r2);
        r0 = r18;
        r1 = r17;
        r1.i = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.h;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.d();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.z;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.d();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.A;
        r4 = 0;
        r0 = r17;
        r5 = r0.i;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.h;
        r11 = r4.a();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.i;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.b;
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
        r5 = r0.b;
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
        r4 = r0.h;
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
        r2 = r0.e;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x02d4;
    L_0x00cb:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.bk) r2;
        r6 = r2.a;
        r0 = r17;
        r7 = r0.i;
        if (r6 < r7) goto L_0x0147;
    L_0x00dd:
        r6 = r2.a;
        r0 = r17;
        r7 = r0.i;
        if (r6 != r7) goto L_0x02d4;
    L_0x00e5:
        if (r2 != 0) goto L_0x02d1;
    L_0x00e7:
        if (r11 <= 0) goto L_0x02d1;
    L_0x00e9:
        r0 = r17;
        r2 = r0.i;
        r2 = a(r2);
        r9 = r2;
    L_0x00f2:
        if (r9 == 0) goto L_0x0253;
    L_0x00f4:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x014c;
    L_0x00f9:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.bk) r2;
    L_0x0103:
        r13 = r17.getClientWidth();
        if (r13 > 0) goto L_0x014e;
    L_0x0109:
        r5 = 0;
    L_0x010a:
        r0 = r17;
        r6 = r0.i;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x0118:
        if (r8 < 0) goto L_0x0190;
    L_0x011a:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x015e;
    L_0x011e:
        if (r8 >= r10) goto L_0x015e;
    L_0x0120:
        if (r2 == 0) goto L_0x0190;
    L_0x0122:
        r14 = r2.a;
        if (r8 != r14) goto L_0x0144;
    L_0x0126:
        r14 = r2.b;
        if (r14 != 0) goto L_0x0144;
    L_0x012a:
        r0 = r17;
        r2 = r0.e;
        r2.remove(r4);
        android.support.v4.view.dr.b();
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x015c;
    L_0x013a:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.bk) r2;
    L_0x0144:
        r8 = r8 + -1;
        goto L_0x0118;
    L_0x0147:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00c1;
    L_0x014c:
        r2 = 0;
        goto L_0x0103;
    L_0x014e:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.c;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x010a;
    L_0x015c:
        r2 = 0;
        goto L_0x0144;
    L_0x015e:
        if (r2 == 0) goto L_0x0178;
    L_0x0160:
        r14 = r2.a;
        if (r8 != r14) goto L_0x0178;
    L_0x0164:
        r2 = r2.c;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x0176;
    L_0x016b:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.bk) r2;
        goto L_0x0144;
    L_0x0176:
        r2 = 0;
        goto L_0x0144;
    L_0x0178:
        r2 = a(r8);
        r2 = r2.c;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x018e;
    L_0x0183:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.bk) r2;
        goto L_0x0144;
    L_0x018e:
        r2 = 0;
        goto L_0x0144;
    L_0x0190:
        r5 = r9.c;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x024e;
    L_0x019a:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x01f6;
    L_0x01a4:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.bk) r2;
        r6 = r2;
    L_0x01af:
        if (r13 > 0) goto L_0x01f8;
    L_0x01b1:
        r2 = 0;
        r4 = r2;
    L_0x01b3:
        r0 = r17;
        r2 = r0.i;
        r2 = r2 + 1;
        r15 = r6;
        r6 = r8;
        r8 = r2;
        r2 = r15;
    L_0x01bd:
        if (r8 >= r11) goto L_0x024e;
    L_0x01bf:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x0206;
    L_0x01c3:
        if (r8 <= r12) goto L_0x0206;
    L_0x01c5:
        if (r2 == 0) goto L_0x024e;
    L_0x01c7:
        r10 = r2.a;
        if (r8 != r10) goto L_0x02cc;
    L_0x01cb:
        r10 = r2.b;
        if (r10 != 0) goto L_0x02cc;
    L_0x01cf:
        r0 = r17;
        r2 = r0.e;
        r2.remove(r6);
        android.support.v4.view.dr.b();
        r0 = r17;
        r2 = r0.e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0204;
    L_0x01e3:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.bk) r2;
    L_0x01ed:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x01f0:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x01bd;
    L_0x01f6:
        r6 = 0;
        goto L_0x01af;
    L_0x01f8:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x01b3;
    L_0x0204:
        r2 = 0;
        goto L_0x01ed;
    L_0x0206:
        if (r2 == 0) goto L_0x022b;
    L_0x0208:
        r10 = r2.a;
        if (r8 != r10) goto L_0x022b;
    L_0x020c:
        r2 = r2.c;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0229;
    L_0x021b:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.bk) r2;
    L_0x0225:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x01f0;
    L_0x0229:
        r2 = 0;
        goto L_0x0225;
    L_0x022b:
        r2 = a(r8);
        r6 = r6 + 1;
        r2 = r2.c;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x024c;
    L_0x023e:
        r0 = r17;
        r2 = r0.e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.bk) r2;
    L_0x0248:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x01f0;
    L_0x024c:
        r2 = 0;
        goto L_0x0248;
    L_0x024e:
        r0 = r17;
        r0.a(r9, r7, r3);
    L_0x0253:
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x0259:
        if (r3 >= r4) goto L_0x0286;
    L_0x025b:
        r0 = r17;
        r2 = r0.getChildAt(r3);
        r2 = r2.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.LayoutParams) r2;
        r2.f = r3;
        r5 = r2.a;
        if (r5 != 0) goto L_0x0282;
    L_0x026d:
        r5 = r2.c;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 != 0) goto L_0x0282;
    L_0x0274:
        r5 = r17.e();
        if (r5 == 0) goto L_0x0282;
    L_0x027a:
        r6 = r5.c;
        r2.c = r6;
        r5 = r5.a;
        r2.e = r5;
    L_0x0282:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0259;
    L_0x0286:
        r17.d();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x028f:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x02ca;
    L_0x0295:
        r0 = r17;
        r2 = r0.a(r2);
    L_0x029b:
        if (r2 == 0) goto L_0x02a5;
    L_0x029d:
        r2 = r2.a;
        r0 = r17;
        r3 = r0.i;
        if (r2 == r3) goto L_0x0023;
    L_0x02a5:
        r2 = 0;
    L_0x02a6:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02ac:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r4 = r17.e();
        if (r4 == 0) goto L_0x02c7;
    L_0x02b8:
        r4 = r4.a;
        r0 = r17;
        r5 = r0.i;
        if (r4 != r5) goto L_0x02c7;
    L_0x02c0:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x02c7:
        r2 = r2 + 1;
        goto L_0x02a6;
    L_0x02ca:
        r2 = 0;
        goto L_0x029b;
    L_0x02cc:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x01f0;
    L_0x02d1:
        r9 = r2;
        goto L_0x00f2;
    L_0x02d4:
        r2 = r5;
        goto L_0x00e5;
    L_0x02d7:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.b(int):void");
    }

    private void d() {
        if (this.ag != 0) {
            if (this.ah == null) {
                this.ah = new ArrayList();
            } else {
                this.ah.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ah.add(getChildAt(i));
            }
            Collections.sort(this.ah, ai);
        }
    }

    private void a(bk bkVar, int i, bk bkVar2) {
        float f;
        int i2;
        bk bkVar3;
        float f2;
        int i3;
        int a = this.h.a();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.p) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (bkVar2 != null) {
            clientWidth = bkVar2.a;
            float f3;
            int i4;
            int i5;
            if (clientWidth < bkVar.a) {
                f3 = (bkVar2.d + bkVar2.c) + f;
                i2 = 0;
                i4 = clientWidth + 1;
                while (i4 <= bkVar.a && i2 < this.e.size()) {
                    bkVar3 = (bk) this.e.get(i2);
                    while (i4 > bkVar3.a && i2 < this.e.size() - 1) {
                        i2++;
                        bkVar3 = (bk) this.e.get(i2);
                    }
                    i5 = i4;
                    f2 = f3;
                    i3 = i5;
                    while (i3 < bkVar3.a) {
                        i3++;
                        f2 = (IPictureView.DEFAULT_MIN_SCALE + f) + f2;
                    }
                    bkVar3.d = f2;
                    f2 += bkVar3.c + f;
                    clientWidth = i3 + 1;
                    f3 = f2;
                    i4 = clientWidth;
                }
            } else if (clientWidth > bkVar.a) {
                i2 = this.e.size() - 1;
                f3 = bkVar2.d;
                i4 = clientWidth - 1;
                while (i4 >= bkVar.a && i2 >= 0) {
                    bkVar3 = (bk) this.e.get(i2);
                    while (i4 < bkVar3.a && i2 > 0) {
                        i2--;
                        bkVar3 = (bk) this.e.get(i2);
                    }
                    i5 = i4;
                    f2 = f3;
                    i3 = i5;
                    while (i3 > bkVar3.a) {
                        i3--;
                        f2 -= IPictureView.DEFAULT_MIN_SCALE + f;
                    }
                    f2 -= bkVar3.c + f;
                    bkVar3.d = f2;
                    clientWidth = i3 - 1;
                    f3 = f2;
                    i4 = clientWidth;
                }
            }
        }
        int size = this.e.size();
        f2 = bkVar.d;
        i3 = bkVar.a - 1;
        this.t = bkVar.a == 0 ? bkVar.d : -3.4028235E38f;
        this.u = bkVar.a == a + -1 ? (bkVar.d + bkVar.c) - IPictureView.DEFAULT_MIN_SCALE : Float.MAX_VALUE;
        for (i2 = i - 1; i2 >= 0; i2--) {
            bkVar3 = (bk) this.e.get(i2);
            while (i3 > bkVar3.a) {
                i3--;
                f2 -= IPictureView.DEFAULT_MIN_SCALE + f;
            }
            f2 -= bkVar3.c + f;
            bkVar3.d = f2;
            if (bkVar3.a == 0) {
                this.t = f2;
            }
            i3--;
        }
        f2 = (bkVar.d + bkVar.c) + f;
        i3 = bkVar.a + 1;
        for (i2 = i + 1; i2 < size; i2++) {
            bkVar3 = (bk) this.e.get(i2);
            while (i3 < bkVar3.a) {
                i3++;
                f2 += IPictureView.DEFAULT_MIN_SCALE + f;
            }
            if (bkVar3.a == a - 1) {
                this.u = (bkVar3.c + f2) - IPictureView.DEFAULT_MIN_SCALE;
            }
            bkVar3.d = f2;
            f2 += bkVar3.c + f;
            i3++;
        }
        this.U = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.i;
        if (this.h != null) {
            savedState.b = null;
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.h != null) {
                Parcelable parcelable2 = savedState.b;
                ClassLoader classLoader = savedState.c;
                a(savedState.a, false, true);
                return;
            }
            this.j = savedState.a;
            this.k = savedState.b;
            this.l = savedState.c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
        layoutParams3.a |= view instanceof az;
        if (!this.x) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.a) {
            layoutParams3.d = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    private bk e() {
        for (int i = 0; i < this.e.size(); i++) {
            bk bkVar = (bk) this.e.get(i);
            if (this.h.c()) {
                return bkVar;
            }
        }
        return null;
    }

    private bk a(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return e();
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    private bk c(int i) {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            bk bkVar = (bk) this.e.get(i2);
            if (bkVar.a == i) {
                return bkVar;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T = true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.E = Math.min(measuredWidth / 10, this.D);
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
        this.v = MeasureSpec.makeMeasureSpec(paddingLeft, UCCore.VERIFY_POLICY_QUICK);
        this.w = MeasureSpec.makeMeasureSpec(measuredHeight, UCCore.VERIFY_POLICY_QUICK);
        this.x = true;
        b();
        this.x = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams == null || !layoutParams.a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.c * ((float) paddingLeft)), UCCore.VERIFY_POLICY_QUICK), this.w);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            a(i, i3, this.p, this.p);
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.e.isEmpty()) {
            bk c = c(this.i);
            int min = (int) ((c != null ? Math.min(c.d, this.u) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                a(false);
                scrollTo(min, getScrollY());
            }
        } else if (this.m.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.m.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
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
                    bk e = e();
                    if (e != null) {
                        i5 = ((int) (e.d * ((float) max))) + paddingLeft;
                        if (layoutParams.d) {
                            layoutParams.d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.c * ((float) max)), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, UCCore.VERIFY_POLICY_QUICK));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.r = paddingTop;
        this.s = i6 - paddingBottom;
        this.W = i7;
        if (this.T) {
            a(this.i, false, 0, false);
        }
        this.T = false;
    }

    public void computeScroll() {
        this.n = true;
        if (this.m.isFinished() || !this.m.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.m.getCurrX();
        int currY = this.m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!d(currX)) {
                this.m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.d(this);
    }

    private boolean d(int i) {
        if (this.e.size() != 0) {
            bk i2 = i();
            int clientWidth = getClientWidth();
            float f = ((float) this.p) / ((float) clientWidth);
            int i3 = i2.a;
            float f2 = ((((float) i) / ((float) clientWidth)) - i2.d) / (i2.c + f);
            this.V = false;
            a(i3, f2);
            if (this.V) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.T) {
            return false;
        } else {
            this.V = false;
            a(0, 0.0f);
            if (this.V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    @CallSuper
    private void a(int i, float f) {
        int paddingLeft;
        int paddingRight;
        if (this.W > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                int i3;
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.a) {
                    int max;
                    switch (layoutParams.b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i3 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i3;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i3 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i3;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i3 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i3;
                            break;
                        default:
                            max = paddingLeft;
                            i3 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i3;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i3 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i3;
                }
                i2++;
                i3 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i3;
            }
        }
        if (this.ab != null) {
            this.ab.a(i, f);
        }
        if (this.aa != null) {
            paddingRight = this.aa.size();
            for (paddingLeft = 0; paddingLeft < paddingRight; paddingLeft++) {
                ef efVar = (ef) this.aa.get(paddingLeft);
                if (efVar != null) {
                    efVar.a(i, f);
                }
            }
        }
        if (this.ac != null) {
            this.ac.a(i, f);
        }
        if (this.ae != null) {
            getScrollX();
            paddingRight = getChildCount();
            for (paddingLeft = 0; paddingLeft < paddingRight; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).a) {
                    childAt2.getLeft();
                    getClientWidth();
                }
            }
        }
        this.V = true;
    }

    private void f() {
        if (this.ab != null) {
            this.ab.a();
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i = 0; i < size; i++) {
                ef efVar = (ef) this.aa.get(i);
                if (efVar != null) {
                    efVar.a();
                }
            }
        }
        if (this.ac != null) {
            this.ac.a();
        }
    }

    private void a(boolean z) {
        int scrollX;
        boolean z2 = this.ak == 2;
        if (z2) {
            boolean z3;
            setScrollingCacheEnabled(false);
            if (this.m.isFinished()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                this.m.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.m.getCurrX();
                int currY = this.m.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        d(currX);
                    }
                }
            }
        }
        this.z = false;
        boolean z4 = z2;
        for (scrollX = 0; scrollX < this.e.size(); scrollX++) {
            bk bkVar = (bk) this.e.get(scrollX);
            if (bkVar.b) {
                bkVar.b = false;
                z4 = true;
            }
        }
        if (!z4) {
            return;
        }
        if (z) {
            ViewCompat.a((View) this, this.aj);
        } else {
            this.aj.run();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            g();
            return false;
        }
        if (action != 0) {
            if (this.B) {
                return true;
            }
            if (this.C) {
                return false;
            }
        }
        float x;
        switch (action) {
            case 0:
                x = motionEvent.getX();
                this.I = x;
                this.G = x;
                x = motionEvent.getY();
                this.J = x;
                this.H = x;
                this.K = cx.b(motionEvent, 0);
                this.C = false;
                this.n = true;
                this.m.computeScrollOffset();
                if (this.ak == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.P) {
                    this.m.abortAnimation();
                    this.z = false;
                    b();
                    this.B = true;
                    h();
                    setScrollState(1);
                    break;
                }
                a(false);
                this.B = false;
                break;
                break;
            case 2:
                action = this.K;
                if (action != -1) {
                    action = cx.a(motionEvent, action);
                    float c = cx.c(motionEvent, action);
                    float f = c - this.G;
                    float abs = Math.abs(f);
                    float d = cx.d(motionEvent, action);
                    float abs2 = Math.abs(d - this.J);
                    if (f != 0.0f) {
                        boolean z;
                        x = this.G;
                        if ((x >= ((float) this.E) || f <= 0.0f) && (x <= ((float) (getWidth() - this.E)) || f >= 0.0f)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && a(this, false, (int) f, (int) c, (int) d)) {
                            this.G = c;
                            this.H = d;
                            this.C = true;
                            return false;
                        }
                    }
                    if (abs > ((float) this.F) && 0.5f * abs > abs2) {
                        this.B = true;
                        h();
                        setScrollState(1);
                        this.G = f > 0.0f ? this.I + ((float) this.F) : this.I - ((float) this.F);
                        this.H = d;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.F)) {
                        this.C = true;
                    }
                    if (this.B && a(c)) {
                        ViewCompat.d(this);
                        break;
                    }
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        return this.B;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.Q) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.h == null || this.h.a() == 0) {
            return false;
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        float x;
        int i;
        float f;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.m.abortAnimation();
                this.z = false;
                b();
                x = motionEvent.getX();
                this.I = x;
                this.G = x;
                x = motionEvent.getY();
                this.J = x;
                this.H = x;
                this.K = cx.b(motionEvent, 0);
                break;
            case 1:
                if (this.B) {
                    VelocityTracker velocityTracker = this.L;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.N);
                    int a = (int) ao.a(velocityTracker, this.K);
                    this.z = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    bk i2 = i();
                    float f2 = ((float) this.p) / ((float) clientWidth);
                    i = i2.a;
                    f = ((((float) scrollX) / ((float) clientWidth)) - i2.d) / (i2.c + f2);
                    if (Math.abs((int) (cx.c(motionEvent, cx.a(motionEvent, this.K)) - this.I)) <= this.O || Math.abs(a) <= this.M) {
                        scrollX = (int) ((((float) i) + f) + (i >= this.i ? 0.4f : 0.6f));
                    } else {
                        if (a <= 0) {
                            i++;
                        }
                        scrollX = i;
                    }
                    if (this.e.size() > 0) {
                        scrollX = Math.max(((bk) this.e.get(0)).a, Math.min(scrollX, ((bk) this.e.get(this.e.size() - 1)).a));
                    }
                    a(scrollX, true, true, a);
                    z = g();
                    break;
                }
                break;
            case 2:
                if (!this.B) {
                    i = cx.a(motionEvent, this.K);
                    if (i == -1) {
                        z = g();
                        break;
                    }
                    float c = cx.c(motionEvent, i);
                    f = Math.abs(c - this.G);
                    float d = cx.d(motionEvent, i);
                    x = Math.abs(d - this.H);
                    if (f > ((float) this.F) && f > x) {
                        this.B = true;
                        h();
                        if (c - this.I > 0.0f) {
                            x = this.I + ((float) this.F);
                        } else {
                            x = this.I - ((float) this.F);
                        }
                        this.G = x;
                        this.H = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.B) {
                    z = a(cx.c(motionEvent, cx.a(motionEvent, this.K))) | 0;
                    break;
                }
                break;
            case 3:
                if (this.B) {
                    a(this.i, true, 0, false);
                    z = g();
                    break;
                }
                break;
            case 5:
                i = cx.b(motionEvent);
                this.G = cx.c(motionEvent, i);
                this.K = cx.b(motionEvent, i);
                break;
            case 6:
                a(motionEvent);
                this.G = cx.c(motionEvent, cx.a(motionEvent, this.K));
                break;
        }
        if (z) {
            ViewCompat.d(this);
        }
        return true;
    }

    private boolean g() {
        this.K = -1;
        this.B = false;
        this.C = false;
        if (this.L != null) {
            this.L.recycle();
            this.L = null;
        }
        return this.R.c() | this.S.c();
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
        float f3 = this.G - f;
        this.G = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.t;
        float f5 = ((float) clientWidth) * this.u;
        bk bkVar = (bk) this.e.get(0);
        bk bkVar2 = (bk) this.e.get(this.e.size() - 1);
        if (bkVar.a != 0) {
            f4 = bkVar.d * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (bkVar2.a != this.h.a() - 1) {
            f2 = bkVar2.d * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.R.a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.S.a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.G += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        d((int) f4);
        return z3;
    }

    private bk i() {
        float f;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.p) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        bk bkVar = null;
        while (i2 < this.e.size()) {
            int i3;
            bk bkVar2;
            bk bkVar3 = (bk) this.e.get(i2);
            bk bkVar4;
            if (obj != null || bkVar3.a == i + 1) {
                bkVar4 = bkVar3;
                i3 = i2;
                bkVar2 = bkVar4;
            } else {
                bkVar3 = this.f;
                bkVar3.d = (f2 + f3) + f;
                bkVar3.a = i + 1;
                bkVar3.c = IPictureView.DEFAULT_MIN_SCALE;
                bkVar4 = bkVar3;
                i3 = i2 - 1;
                bkVar2 = bkVar4;
            }
            f2 = bkVar2.d;
            f3 = (bkVar2.c + f2) + f;
            if (obj == null && scrollX < f2) {
                return bkVar;
            }
            if (scrollX < f3 || i3 == this.e.size() - 1) {
                return bkVar2;
            }
            f3 = f2;
            i = bkVar2.a;
            obj = null;
            f2 = bkVar2.c;
            bkVar = bkVar2;
            i2 = i3 + 1;
        }
        return bkVar;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = ViewCompat.a((View) this);
        if (a == 0 || (a == 1 && this.h != null && this.h.a() > 1)) {
            int width;
            if (!this.R.a()) {
                a = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), this.t * ((float) width));
                this.R.a(i, width);
                i = this.R.a(canvas) | 0;
                canvas.restoreToCount(a);
            }
            if (!this.S.a()) {
                a = canvas.save();
                width = getWidth();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.u + IPictureView.DEFAULT_MIN_SCALE)) * ((float) width));
                this.S.a(height, width);
                i |= this.S.a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.R.b();
            this.S.b();
        }
        if (i != 0) {
            ViewCompat.d(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.p > 0 && this.q != null && this.e.size() > 0 && this.h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.p) / ((float) width);
            bk bkVar = (bk) this.e.get(0);
            float f2 = bkVar.d;
            int size = this.e.size();
            int i = bkVar.a;
            int i2 = ((bk) this.e.get(size - 1)).a;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > bkVar.a && i3 < size) {
                    i3++;
                    bkVar = (bk) this.e.get(i3);
                }
                if (i4 == bkVar.a) {
                    f3 = (bkVar.d + bkVar.c) * ((float) width);
                    f2 = (bkVar.d + bkVar.c) + f;
                } else {
                    f3 = (IPictureView.DEFAULT_MIN_SCALE + f2) * ((float) width);
                    f2 += IPictureView.DEFAULT_MIN_SCALE + f;
                }
                if (((float) this.p) + f3 > ((float) scrollX)) {
                    this.q.setBounds(Math.round(f3), this.r, Math.round(((float) this.p) + f3), this.s);
                    this.q.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    private void a(MotionEvent motionEvent) {
        int b = cx.b(motionEvent);
        if (cx.b(motionEvent, b) == this.K) {
            b = b == 0 ? 1 : 0;
            this.G = cx.c(motionEvent, b);
            this.K = cx.b(motionEvent, b);
            if (this.L != null) {
                this.L.clear();
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.y != z) {
            this.y = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        if (this.h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.t))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollX >= ((int) (((float) clientWidth) * this.u))) {
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
        r0 = 0;
        r1 = 1;
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
        r2 = android.support.v4.view.dn.a(r5);
        if (r2 == 0) goto L_0x003a;
    L_0x0034:
        r2 = 2;
        r2 = r4.e(r2);
        goto L_0x0016;
    L_0x003a:
        r2 = android.support.v4.view.dn.a(r5, r1);
        if (r2 == 0) goto L_0x0015;
    L_0x0040:
        r2 = r4.e(r1);
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(int r10) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 66;
        r7 = 17;
        r3 = 1;
        r4 = 0;
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
        r2 = r9.g;
        r2 = r9.a(r2, r1);
        r2 = r2.left;
        r3 = r9.g;
        r3 = r9.a(r3, r0);
        r3 = r3.left;
        if (r0 == 0) goto L_0x009c;
    L_0x002e:
        if (r2 < r3) goto L_0x009c;
    L_0x0030:
        r0 = r9.j();
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
        r2 = r9.g;
        r2 = r9.a(r2, r1);
        r2 = r2.left;
        r5 = r9.g;
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
        r0 = r9.j();
        goto L_0x0034;
    L_0x00c7:
        if (r10 == r8) goto L_0x00cc;
    L_0x00c9:
        r0 = 2;
        if (r10 != r0) goto L_0x0035;
    L_0x00cc:
        r0 = r9.h;
        if (r0 == 0) goto L_0x00e6;
    L_0x00d0:
        r0 = r9.i;
        r1 = r9.h;
        r1 = r1.a();
        r1 = r1 + -1;
        if (r0 >= r1) goto L_0x00e6;
    L_0x00dc:
        r0 = r9.i;
        r0 = r0 + 1;
        r9.setCurrentItem$2563266(r0);
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.e(int):boolean");
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

    private boolean j() {
        if (this.i <= 0) {
            return false;
        }
        setCurrentItem$2563266(this.i - 1);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    bk e = e();
                    if (e != null && e.a == this.i) {
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
                bk e = e();
                if (e != null && e.a == this.i) {
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
                bk e = e();
                if (e != null && e.a == this.i && childAt.requestFocus(i, rect)) {
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
                bk e = e();
                if (e != null && e.a == this.i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
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
