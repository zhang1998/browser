package com.ucpro.ui.widget.viewpager;

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
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ao;
import android.support.v4.view.cx;
import android.support.v4.view.eh;
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
public class ProViewPager extends ViewGroup {
    private static final e aj = new e();
    private static final int[] b = new int[]{16842931};
    private static final Comparator<f> d = new a();
    private static final Interpolator e = new b();
    private boolean A;
    private boolean B;
    private int C = 0;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private float I;
    private float J;
    private float K;
    private float L;
    private int M = -1;
    private VelocityTracker N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private bx T;
    private bx U;
    private boolean V = true;
    private boolean W = false;
    public List<n> a;
    private boolean aa;
    private int ab;
    private n ac;
    private n ad;
    private j ae;
    private m af;
    private Method ag;
    private int ah;
    private ArrayList<View> ai;
    private final Runnable ak = new h(this);
    private int al = 0;
    private int c;
    private final ArrayList<f> f = new ArrayList();
    private final f g = new f();
    private final Rect h = new Rect();
    private g i;
    private int j;
    private int k = -1;
    private Parcelable l = null;
    private ClassLoader m = null;
    private Scroller n;
    private boolean o;
    private boolean p = true;
    private k q;
    private int r;
    private Drawable s;
    private int t;
    private int u;
    private float v = -3.4028235E38f;
    private float w = Float.MAX_VALUE;
    private int x;
    private int y;
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ProViewPager.b);
            this.b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ProGuard */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = d.a(new d());
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

    public ProViewPager(Context context) {
        super(context);
        d();
    }

    public ProViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    private void d() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.n = new Scroller(context, e);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.H = eh.a(viewConfiguration);
        this.O = (int) (400.0f * f);
        this.P = viewConfiguration.getScaledMaximumFlingVelocity();
        this.T = new bx(context);
        this.U = new bx(context);
        this.Q = (int) (25.0f * f);
        this.R = (int) (2.0f * f);
        this.F = (int) (16.0f * f);
        ViewCompat.a((View) this, new i(this));
        if (ViewCompat.e(this) == 0) {
            ViewCompat.c((View) this, 1);
        }
        ViewCompat.a((View) this, new l(this));
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ak);
        if (!(this.n == null || this.n.isFinished())) {
            this.n.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    private void setScrollState(int i) {
        int i2 = 0;
        if (this.al != i) {
            this.al = i;
            if (this.af != null) {
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
            if (this.ac != null) {
                this.ac.b(i);
            }
            if (this.a != null) {
                int size = this.a.size();
                while (i2 < size) {
                    n nVar = (n) this.a.get(i2);
                    if (nVar != null) {
                        nVar.b(i);
                    }
                    i2++;
                }
            }
            if (this.ad != null) {
                this.ad.b(i);
            }
        }
    }

    public void setAdapter(g gVar) {
        if (this.i != null) {
            int i;
            this.i.a(null);
            for (i = 0; i < this.f.size(); i++) {
                this.i.a((ViewGroup) this, ((f) this.f.get(i)).a);
            }
            this.f.clear();
            i = 0;
            while (i < getChildCount()) {
                if (!((LayoutParams) getChildAt(i).getLayoutParams()).a) {
                    removeViewAt(i);
                    i--;
                }
                i++;
            }
            this.j = 0;
            scrollTo(0, 0);
        }
        this.i = gVar;
        this.c = 0;
        if (this.i != null) {
            if (this.q == null) {
                this.q = new k();
            }
            this.i.a(this.q);
            this.B = false;
            boolean z = this.V;
            this.V = true;
            this.c = this.i.a();
            if (this.k >= 0) {
                a(this.k, false, true);
                this.k = -1;
                this.l = null;
                this.m = null;
            } else if (z) {
                requestLayout();
            } else {
                b();
            }
        }
    }

    public g getAdapter() {
        return this.i;
    }

    void setOnAdapterChangeListener(j jVar) {
        this.ae = jVar;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.B = false;
        if (this.V) {
            z = false;
        } else {
            z = true;
        }
        a(i, z, false);
    }

    public final void setCurrentItem$2563266(int i) {
        this.B = false;
        a(i, true, false);
    }

    public int getCurrentItem() {
        return this.j;
    }

    private void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    private void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.i == null || this.i.a() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.j != i || this.f.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.i.a()) {
                i = this.i.a() - 1;
            }
            int i3 = this.C;
            if (i > this.j + i3 || i < this.j - i3) {
                for (int i4 = 0; i4 < this.f.size(); i4++) {
                    ((f) this.f.get(i4)).c = true;
                }
            }
            if (this.j != i) {
                z3 = true;
            }
            if (this.V) {
                this.j = i;
                if (z3) {
                    d(i);
                }
                requestLayout();
                return;
            }
            a(i);
            a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        int clientWidth;
        f b = b(i);
        if (b != null) {
            clientWidth = (int) (((float) getClientWidth()) * Math.max(this.v, Math.min(b.e, this.w)));
        } else {
            clientWidth = 0;
        }
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                int currX;
                int i3;
                Object obj = (this.n == null || this.n.isFinished()) ? null : 1;
                if (obj != null) {
                    currX = this.o ? this.n.getCurrX() : this.n.getStartX();
                    this.n.abortAnimation();
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
                        currX = (int) (((((float) Math.abs(clientWidth)) / ((((float) currX) * IPictureView.DEFAULT_MIN_SCALE) + ((float) this.r))) + IPictureView.DEFAULT_MIN_SCALE) * 100.0f);
                    }
                    i5 = Math.min(currX, SecExceptionCode.SEC_ERROR_SIGNATRUE);
                    this.o = false;
                    this.n.startScroll(i3, scrollY, clientWidth, i4, i5);
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
        c(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(n nVar) {
        this.ac = nVar;
    }

    public final void a(n nVar) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(nVar);
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ag == null) {
                try {
                    this.ag = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ProViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ag.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ProViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ah == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.ai.get(i2)).getLayoutParams()).f;
    }

    public int getOffscreenPageLimit() {
        return this.C;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 0) {
            Log.w("ProViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 0");
            i = 0;
        }
        if (i != this.C) {
            this.C = i;
            b();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.r;
        this.r = i;
        int width = getWidth();
        a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.r;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.s = drawable;
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
        return super.verifyDrawable(drawable) || drawable == this.s;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.s;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    private f a(int i, int i2) {
        f fVar = new f();
        fVar.b = i;
        fVar.a = this.i.a((ViewGroup) this, i);
        fVar.d = IPictureView.DEFAULT_MIN_SCALE;
        if (i2 < 0 || i2 >= this.f.size()) {
            this.f.add(fVar);
        } else {
            this.f.add(i2, fVar);
        }
        return fVar;
    }

    final void a() {
        boolean z;
        int i;
        int a = this.i.a();
        this.c = a;
        if (this.f.size() >= (this.C * 2) + 1 || this.f.size() >= a) {
            z = false;
        } else {
            z = true;
        }
        int i2 = this.j;
        for (i = 0; i < this.f.size(); i++) {
            this.f.get(i);
        }
        Collections.sort(this.f, d);
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
        a(this.j);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.j;
        r0 = r18;
        if (r3 == r0) goto L_0x0300;
    L_0x0009:
        r0 = r17;
        r2 = r0.j;
        r0 = r17;
        r2 = r0.b(r2);
        r0 = r18;
        r1 = r17;
        r1.j = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.i;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.e();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.B;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.e();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.C;
        r4 = 0;
        r0 = r17;
        r5 = r0.j;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.i;
        r11 = r4.a();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.j;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.c;
        if (r11 == r2) goto L_0x00be;
    L_0x005b:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00b4 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00b4 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00b4 }
    L_0x0067:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r5 = "The application's ProPagerAdapter changed the adapter's contents without calling ProPagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4.<init>(r5);
        r0 = r17;
        r5 = r0.c;
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
        r4 = r0.i;
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
        r2 = r0.f;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x02fd;
    L_0x00cb:
        r0 = r17;
        r2 = r0.f;
        r2 = r2.get(r4);
        r2 = (com.ucpro.ui.widget.viewpager.f) r2;
        r6 = r2.b;
        r0 = r17;
        r7 = r0.j;
        if (r6 < r7) goto L_0x0151;
    L_0x00dd:
        r6 = r2.b;
        r0 = r17;
        r7 = r0.j;
        if (r6 != r7) goto L_0x02fd;
    L_0x00e5:
        if (r2 != 0) goto L_0x02fa;
    L_0x00e7:
        if (r11 <= 0) goto L_0x02fa;
    L_0x00e9:
        r0 = r17;
        r2 = r0.j;
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
        r2 = r0.f;
        r2 = r2.get(r7);
        r2 = (com.ucpro.ui.widget.viewpager.f) r2;
    L_0x0105:
        r13 = r17.getClientWidth();
        if (r13 > 0) goto L_0x0158;
    L_0x010b:
        r5 = 0;
    L_0x010c:
        r0 = r17;
        r6 = r0.j;
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
        r14 = r0.f;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.i;
        r2 = r2.a;
        r0 = r17;
        r14.a(r0, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x0166;
    L_0x0144:
        r0 = r17;
        r2 = r0.f;
        r2 = r2.get(r4);
        r2 = (com.ucpro.ui.widget.viewpager.f) r2;
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
        r2 = r0.f;
        r2 = r2.get(r4);
        r2 = (com.ucpro.ui.widget.viewpager.f) r2;
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
        r2 = r0.f;
        r2 = r2.get(r4);
        r2 = (com.ucpro.ui.widget.viewpager.f) r2;
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
        r2 = r0.f;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x020c;
    L_0x01b2:
        r0 = r17;
        r2 = r0.f;
        r2 = r2.get(r8);
        r2 = (com.ucpro.ui.widget.viewpager.f) r2;
        r6 = r2;
    L_0x01bd:
        if (r13 > 0) goto L_0x020e;
    L_0x01bf:
        r2 = 0;
        r4 = r2;
    L_0x01c1:
        r0 = r17;
        r2 = r0.j;
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
        if (r8 != r10) goto L_0x02f5;
    L_0x01d9:
        r10 = r2.c;
        if (r10 != 0) goto L_0x02f5;
    L_0x01dd:
        r0 = r17;
        r10 = r0.f;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.i;
        r2 = r2.a;
        r0 = r17;
        r10.a(r0, r2);
        r0 = r17;
        r2 = r0.f;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x021a;
    L_0x01f9:
        r0 = r17;
        r2 = r0.f;
        r2 = r2.get(r6);
        r2 = (com.ucpro.ui.widget.viewpager.f) r2;
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
        r2 = r0.f;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x023f;
    L_0x0231:
        r0 = r17;
        r2 = r0.f;
        r2 = r2.get(r6);
        r2 = (com.ucpro.ui.widget.viewpager.f) r2;
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
        r2 = r0.f;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0264;
    L_0x0256:
        r0 = r17;
        r2 = r0.f;
        r2 = r2.get(r6);
        r2 = (com.ucpro.ui.widget.viewpager.f) r2;
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
        r0 = r17;
        r3 = r0.i;
        if (r9 == 0) goto L_0x02ab;
    L_0x0271:
        r2 = r9.a;
    L_0x0273:
        r3.a(r2);
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x027c:
        if (r3 >= r4) goto L_0x02ad;
    L_0x027e:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (com.ucpro.ui.widget.viewpager.ProViewPager.LayoutParams) r2;
        r2.f = r3;
        r6 = r2.a;
        if (r6 != 0) goto L_0x02a7;
    L_0x0290:
        r6 = r2.c;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x02a7;
    L_0x0297:
        r0 = r17;
        r5 = r0.a(r5);
        if (r5 == 0) goto L_0x02a7;
    L_0x029f:
        r6 = r5.d;
        r2.c = r6;
        r5 = r5.b;
        r2.e = r5;
    L_0x02a7:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x027c;
    L_0x02ab:
        r2 = 0;
        goto L_0x0273;
    L_0x02ad:
        r17.e();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02b6:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x02f3;
    L_0x02bc:
        r0 = r17;
        r2 = r0.b(r2);
    L_0x02c2:
        if (r2 == 0) goto L_0x02cc;
    L_0x02c4:
        r2 = r2.b;
        r0 = r17;
        r3 = r0.j;
        if (r2 == r3) goto L_0x0023;
    L_0x02cc:
        r2 = 0;
    L_0x02cd:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02d3:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.a(r3);
        if (r4 == 0) goto L_0x02f0;
    L_0x02e1:
        r4 = r4.b;
        r0 = r17;
        r5 = r0.j;
        if (r4 != r5) goto L_0x02f0;
    L_0x02e9:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x02f0:
        r2 = r2 + 1;
        goto L_0x02cd;
    L_0x02f3:
        r2 = 0;
        goto L_0x02c2;
    L_0x02f5:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x0206;
    L_0x02fa:
        r9 = r2;
        goto L_0x00f4;
    L_0x02fd:
        r2 = r5;
        goto L_0x00e5;
    L_0x0300:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.ui.widget.viewpager.ProViewPager.a(int):void");
    }

    private void e() {
        if (this.ah != 0) {
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

    private void a(f fVar, int i, f fVar2) {
        float f;
        int i2;
        f fVar3;
        float f2;
        int i3;
        int a = this.i.a();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.r) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (fVar2 != null) {
            clientWidth = fVar2.b;
            float f3;
            int i4;
            int i5;
            if (clientWidth < fVar.b) {
                f3 = (fVar2.e + fVar2.d) + f;
                i2 = 0;
                i4 = clientWidth + 1;
                while (i4 <= fVar.b && i2 < this.f.size()) {
                    fVar3 = (f) this.f.get(i2);
                    while (i4 > fVar3.b && i2 < this.f.size() - 1) {
                        i2++;
                        fVar3 = (f) this.f.get(i2);
                    }
                    i5 = i4;
                    f2 = f3;
                    i3 = i5;
                    while (i3 < fVar3.b) {
                        i3++;
                        f2 = (IPictureView.DEFAULT_MIN_SCALE + f) + f2;
                    }
                    fVar3.e = f2;
                    f2 += fVar3.d + f;
                    clientWidth = i3 + 1;
                    f3 = f2;
                    i4 = clientWidth;
                }
            } else if (clientWidth > fVar.b) {
                i2 = this.f.size() - 1;
                f3 = fVar2.e;
                i4 = clientWidth - 1;
                while (i4 >= fVar.b && i2 >= 0) {
                    fVar3 = (f) this.f.get(i2);
                    while (i4 < fVar3.b && i2 > 0) {
                        i2--;
                        fVar3 = (f) this.f.get(i2);
                    }
                    i5 = i4;
                    f2 = f3;
                    i3 = i5;
                    while (i3 > fVar3.b) {
                        i3--;
                        f2 -= IPictureView.DEFAULT_MIN_SCALE + f;
                    }
                    f2 -= fVar3.d + f;
                    fVar3.e = f2;
                    clientWidth = i3 - 1;
                    f3 = f2;
                    i4 = clientWidth;
                }
            }
        }
        int size = this.f.size();
        f2 = fVar.e;
        i3 = fVar.b - 1;
        this.v = fVar.b == 0 ? fVar.e : -3.4028235E38f;
        this.w = fVar.b == a + -1 ? (fVar.e + fVar.d) - IPictureView.DEFAULT_MIN_SCALE : Float.MAX_VALUE;
        for (i2 = i - 1; i2 >= 0; i2--) {
            fVar3 = (f) this.f.get(i2);
            while (i3 > fVar3.b) {
                i3--;
                f2 -= IPictureView.DEFAULT_MIN_SCALE + f;
            }
            f2 -= fVar3.d + f;
            fVar3.e = f2;
            if (fVar3.b == 0) {
                this.v = f2;
            }
            i3--;
        }
        f2 = (fVar.e + fVar.d) + f;
        i3 = fVar.b + 1;
        for (i2 = i + 1; i2 < size; i2++) {
            fVar3 = (f) this.f.get(i2);
            while (i3 < fVar3.b) {
                i3++;
                f2 += IPictureView.DEFAULT_MIN_SCALE + f;
            }
            if (fVar3.b == a - 1) {
                this.w = (fVar3.d + f2) - IPictureView.DEFAULT_MIN_SCALE;
            }
            fVar3.e = f2;
            f2 += fVar3.d + f;
            i3++;
        }
        this.W = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.j;
        if (this.i != null) {
            savedState.b = null;
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.i != null) {
                Parcelable parcelable2 = savedState.b;
                ClassLoader classLoader = savedState.c;
                a(savedState.a, false, true);
                return;
            }
            this.k = savedState.a;
            this.l = savedState.b;
            this.m = savedState.c;
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
        layoutParams3.a |= view instanceof c;
        if (!this.z) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.a) {
            layoutParams3.d = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.z) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    private f a(View view) {
        for (int i = 0; i < this.f.size(); i++) {
            f fVar = (f) this.f.get(i);
            if (this.i.a(view, fVar.a)) {
                return fVar;
            }
        }
        return null;
    }

    private f b(View view) {
        while (true) {
            ProViewPager parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    private f b(int i) {
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            f fVar = (f) this.f.get(i2);
            if (fVar.b == i) {
                return fVar;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.V = true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.G = Math.min(measuredWidth / 10, this.F);
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
        this.x = MeasureSpec.makeMeasureSpec(paddingLeft, UCCore.VERIFY_POLICY_QUICK);
        this.y = MeasureSpec.makeMeasureSpec(measuredHeight, UCCore.VERIFY_POLICY_QUICK);
        this.z = true;
        b();
        this.z = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams == null || !layoutParams.a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.c * ((float) paddingLeft)), UCCore.VERIFY_POLICY_QUICK), this.y);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            a(i, i3, this.r, this.r);
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f.isEmpty()) {
            f b = b(this.j);
            int min = (int) ((b != null ? Math.min(b.e, this.w) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                a(false);
                scrollTo(min, getScrollY());
            }
        } else if (this.n.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.n.setFinalX(getCurrentItem() * getClientWidth());
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
                    f a = a(childAt2);
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
        this.t = paddingTop;
        this.u = i6 - paddingBottom;
        this.ab = i7;
        if (this.V) {
            a(this.j, false, 0, false);
        }
        this.V = false;
    }

    public void computeScroll() {
        this.o = true;
        if (this.n.isFinished() || !this.n.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.n.getCurrX();
        int currY = this.n.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!c(currX)) {
                this.n.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.d(this);
    }

    private boolean c(int i) {
        if (this.f.size() != 0) {
            f h = h();
            int clientWidth = getClientWidth();
            float f = ((float) this.r) / ((float) clientWidth);
            int i2 = h.b;
            float f2 = ((((float) i) / ((float) clientWidth)) - h.e) / (h.d + f);
            this.aa = false;
            a(i2, f2);
            if (this.aa) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.V) {
            return false;
        } else {
            this.aa = false;
            a(0, 0.0f);
            if (this.aa) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    @CallSuper
    private void a(int i, float f) {
        int paddingLeft;
        int paddingRight;
        if (this.ab > 0) {
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
        if (this.ac != null) {
            this.ac.a(i, f);
        }
        if (this.a != null) {
            paddingRight = this.a.size();
            for (paddingLeft = 0; paddingLeft < paddingRight; paddingLeft++) {
                n nVar = (n) this.a.get(paddingLeft);
                if (nVar != null) {
                    nVar.a(i, f);
                }
            }
        }
        if (this.ad != null) {
            this.ad.a(i, f);
        }
        if (this.af != null) {
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
        this.aa = true;
    }

    private void d(int i) {
        if (this.ac != null) {
            this.ac.a(i);
        }
        if (this.a != null) {
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                n nVar = (n) this.a.get(i2);
                if (nVar != null) {
                    nVar.a(i);
                }
            }
        }
        if (this.ad != null) {
            this.ad.a(i);
        }
    }

    private void a(boolean z) {
        int scrollX;
        boolean z2 = this.al == 2;
        if (z2) {
            boolean z3;
            setScrollingCacheEnabled(false);
            if (this.n.isFinished()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                this.n.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.n.getCurrX();
                int currY = this.n.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        c(currX);
                    }
                }
            }
        }
        this.B = false;
        boolean z4 = z2;
        for (scrollX = 0; scrollX < this.f.size(); scrollX++) {
            f fVar = (f) this.f.get(scrollX);
            if (fVar.c) {
                fVar.c = false;
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

    public void setPagingEnabled(boolean z) {
        this.p = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.p) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            f();
            return false;
        }
        if (action != 0) {
            if (this.D) {
                return true;
            }
            if (this.E) {
                return false;
            }
        }
        float x;
        switch (action) {
            case 0:
                x = motionEvent.getX();
                this.K = x;
                this.I = x;
                x = motionEvent.getY();
                this.L = x;
                this.J = x;
                this.M = cx.b(motionEvent, 0);
                this.E = false;
                this.o = true;
                this.n.computeScrollOffset();
                if (this.al == 2 && Math.abs(this.n.getFinalX() - this.n.getCurrX()) > this.R) {
                    this.n.abortAnimation();
                    this.B = false;
                    b();
                    this.D = true;
                    g();
                    setScrollState(1);
                    break;
                }
                a(false);
                this.D = false;
                break;
            case 2:
                action = this.M;
                if (action != -1) {
                    action = cx.a(motionEvent, action);
                    if (action != -1) {
                        float c = cx.c(motionEvent, action);
                        float f = c - this.I;
                        float abs = Math.abs(f);
                        float d = cx.d(motionEvent, action);
                        float abs2 = Math.abs(d - this.L);
                        if (f != 0.0f) {
                            boolean z;
                            x = this.I;
                            if ((x >= ((float) this.G) || f <= 0.0f) && (x <= ((float) (getWidth() - this.G)) || f >= 0.0f)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (!z && a(this, false, (int) f, (int) c, (int) d)) {
                                this.I = c;
                                this.J = d;
                                this.E = true;
                                return false;
                            }
                        }
                        if (abs > ((float) this.H) && 0.5f * abs > abs2) {
                            this.D = true;
                            g();
                            setScrollState(1);
                            this.I = f > 0.0f ? this.K + ((float) this.H) : this.K - ((float) this.H);
                            this.J = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.H)) {
                            this.E = true;
                        }
                        if (this.D && a(c)) {
                            ViewCompat.d(this);
                            break;
                        }
                    }
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        return this.D;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.S) {
            return true;
        }
        if (!this.p) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.i == null || this.i.a() == 0) {
            return false;
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        float x;
        int i;
        float f;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.n.abortAnimation();
                this.B = false;
                b();
                x = motionEvent.getX();
                this.K = x;
                this.I = x;
                x = motionEvent.getY();
                this.L = x;
                this.J = x;
                this.M = cx.b(motionEvent, 0);
                break;
            case 1:
                if (this.D) {
                    VelocityTracker velocityTracker = this.N;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.P);
                    int a = (int) ao.a(velocityTracker, this.M);
                    this.B = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    f h = h();
                    float f2 = ((float) this.r) / ((float) clientWidth);
                    i = h.b;
                    f = ((((float) scrollX) / ((float) clientWidth)) - h.e) / (h.d + f2);
                    if (Math.abs((int) (cx.c(motionEvent, cx.a(motionEvent, this.M)) - this.K)) <= this.Q || Math.abs(a) <= this.O) {
                        scrollX = (int) ((((float) i) + f) + (i >= this.j ? 0.4f : 0.6f));
                    } else {
                        if (a <= 0) {
                            i++;
                        }
                        scrollX = i;
                    }
                    if (this.f.size() > 0) {
                        scrollX = Math.max(((f) this.f.get(0)).b, Math.min(scrollX, ((f) this.f.get(this.f.size() - 1)).b));
                    }
                    a(scrollX, true, true, a);
                    z = f();
                    break;
                }
                break;
            case 2:
                if (!this.D) {
                    i = cx.a(motionEvent, this.M);
                    if (i == -1) {
                        z = f();
                        break;
                    }
                    float c = cx.c(motionEvent, i);
                    f = Math.abs(c - this.I);
                    float d = cx.d(motionEvent, i);
                    x = Math.abs(d - this.J);
                    if (f > ((float) this.H) && f > x) {
                        this.D = true;
                        g();
                        if (c - this.K > 0.0f) {
                            x = this.K + ((float) this.H);
                        } else {
                            x = this.K - ((float) this.H);
                        }
                        this.I = x;
                        this.J = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.D) {
                    z = a(cx.c(motionEvent, cx.a(motionEvent, this.M))) | 0;
                    break;
                }
                break;
            case 3:
                if (this.D) {
                    a(this.j, true, 0, false);
                    z = f();
                    break;
                }
                break;
            case 5:
                i = cx.b(motionEvent);
                this.I = cx.c(motionEvent, i);
                this.M = cx.b(motionEvent, i);
                break;
            case 6:
                a(motionEvent);
                this.I = cx.c(motionEvent, cx.a(motionEvent, this.M));
                break;
        }
        if (z) {
            ViewCompat.d(this);
        }
        return true;
    }

    private boolean f() {
        this.M = -1;
        this.D = false;
        this.E = false;
        if (this.N != null) {
            this.N.recycle();
            this.N = null;
        }
        return this.T.c() | this.U.c();
    }

    private void g() {
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
        float f3 = this.I - f;
        this.I = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.v;
        float f5 = ((float) clientWidth) * this.w;
        f fVar = (f) this.f.get(0);
        f fVar2 = (f) this.f.get(this.f.size() - 1);
        if (fVar.b != 0) {
            f4 = fVar.e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (fVar2.b != this.i.a() - 1) {
            f2 = fVar2.e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.T.a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.U.a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.I += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        c((int) f4);
        return z3;
    }

    private f h() {
        float f;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.r) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        f fVar = null;
        while (i2 < this.f.size()) {
            int i3;
            f fVar2;
            f fVar3 = (f) this.f.get(i2);
            f fVar4;
            if (obj != null || fVar3.b == i + 1) {
                fVar4 = fVar3;
                i3 = i2;
                fVar2 = fVar4;
            } else {
                fVar3 = this.g;
                fVar3.e = (f2 + f3) + f;
                fVar3.b = i + 1;
                fVar3.d = IPictureView.DEFAULT_MIN_SCALE;
                fVar4 = fVar3;
                i3 = i2 - 1;
                fVar2 = fVar4;
            }
            f2 = fVar2.e;
            f3 = (fVar2.d + f2) + f;
            if (obj == null && scrollX < f2) {
                return fVar;
            }
            if (scrollX < f3 || i3 == this.f.size() - 1) {
                return fVar2;
            }
            f3 = f2;
            i = fVar2.b;
            obj = null;
            f2 = fVar2.d;
            fVar = fVar2;
            i2 = i3 + 1;
        }
        return fVar;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = ViewCompat.a((View) this);
        if (a == 0 || (a == 1 && this.i != null && this.i.a() > 1)) {
            int width;
            if (!this.T.a()) {
                a = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), this.v * ((float) width));
                this.T.a(i, width);
                i = this.T.a(canvas) | 0;
                canvas.restoreToCount(a);
            }
            if (!this.U.a()) {
                a = canvas.save();
                width = getWidth();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.w + IPictureView.DEFAULT_MIN_SCALE)) * ((float) width));
                this.U.a(height, width);
                i |= this.U.a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.T.b();
            this.U.b();
        }
        if (i != 0) {
            ViewCompat.d(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.r > 0 && this.s != null && this.f.size() > 0 && this.i != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.r) / ((float) width);
            f fVar = (f) this.f.get(0);
            float f2 = fVar.e;
            int size = this.f.size();
            int i = fVar.b;
            int i2 = ((f) this.f.get(size - 1)).b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > fVar.b && i3 < size) {
                    i3++;
                    fVar = (f) this.f.get(i3);
                }
                if (i4 == fVar.b) {
                    f3 = (fVar.e + fVar.d) * ((float) width);
                    f2 = (fVar.e + fVar.d) + f;
                } else {
                    f3 = (IPictureView.DEFAULT_MIN_SCALE + f2) * ((float) width);
                    f2 += IPictureView.DEFAULT_MIN_SCALE + f;
                }
                if (((float) this.r) + f3 > ((float) scrollX)) {
                    this.s.setBounds(Math.round(f3), this.t, Math.round(((float) this.r) + f3), this.u);
                    this.s.draw(canvas);
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
        if (cx.b(motionEvent, b) == this.M) {
            b = b == 0 ? 1 : 0;
            this.I = cx.c(motionEvent, b);
            this.M = cx.b(motionEvent, b);
            if (this.N != null) {
                this.N.clear();
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.A != z) {
            this.A = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        if (this.i == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.v))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollX >= ((int) (((float) clientWidth) * this.w))) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.ui.widget.viewpager.ProViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
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
        r2 = r9.h;
        r2 = r9.a(r2, r1);
        r2 = r2.left;
        r3 = r9.h;
        r3 = r9.a(r3, r0);
        r3 = r3.left;
        if (r0 == 0) goto L_0x009c;
    L_0x002e:
        if (r2 < r3) goto L_0x009c;
    L_0x0030:
        r0 = r9.i();
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
        r0 = "ProViewPager";
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
        r2 = r9.h;
        r2 = r9.a(r2, r1);
        r2 = r2.left;
        r5 = r9.h;
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
        r0 = r9.i();
        goto L_0x0034;
    L_0x00c7:
        if (r10 == r8) goto L_0x00cc;
    L_0x00c9:
        r0 = 2;
        if (r10 != r0) goto L_0x0035;
    L_0x00cc:
        r0 = r9.i;
        if (r0 == 0) goto L_0x00e6;
    L_0x00d0:
        r0 = r9.j;
        r1 = r9.i;
        r1 = r1.a();
        r1 = r1 + -1;
        if (r0 >= r1) goto L_0x00e6;
    L_0x00dc:
        r0 = r9.j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.ui.widget.viewpager.ProViewPager.e(int):boolean");
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
        ProViewPager parent = view.getParent();
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

    private boolean i() {
        if (this.j <= 0) {
            return false;
        }
        setCurrentItem$2563266(this.j - 1);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    f a = a(childAt);
                    if (a != null && a.b == this.j) {
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
                f a = a(childAt);
                if (a != null && a.b == this.j) {
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
                f a = a(childAt);
                if (a != null && a.b == this.j && childAt.requestFocus(i, rect)) {
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
                f a = a(childAt);
                if (a != null && a.b == this.j && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
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
