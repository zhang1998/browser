package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class SlidingPaneLayout extends ViewGroup {
    static final v a;
    private int b;
    private int c;
    private Drawable d;
    private Drawable e;
    private final int f;
    private boolean g;
    private View h;
    private float i;
    private float j;
    private int k;
    private boolean l;
    private int m;
    private float n;
    private float o;
    private br p;
    private final bt q;
    private boolean r;
    private boolean s;
    private final Rect t;
    private final ArrayList<ch> u;

    /* compiled from: ProGuard */
    public class LayoutParams extends MarginLayoutParams {
        private static final int[] e = new int[]{16843137};
        public float a = 0.0f;
        boolean b;
        boolean c;
        Paint d;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e);
            this.a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ProGuard */
    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new bn();
        boolean a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a ? 1 : 0);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            a = new bl();
        } else if (i >= 16) {
            a = new aw();
        } else {
            a = new p();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -858993460;
        this.s = true;
        this.t = new Rect();
        this.u = new ArrayList();
        float f = context.getResources().getDisplayMetrics().density;
        this.f = (int) ((32.0f * f) + 0.5f);
        ViewConfiguration.get(context);
        setWillNotDraw(false);
        ViewCompat.a((View) this, new bo(this));
        ViewCompat.c((View) this, 1);
        this.q = bt.a((ViewGroup) this, 0.5f, new bs());
        this.q.g = f * 400.0f;
    }

    public void setParallaxDistance(int i) {
        this.m = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.m;
    }

    public void setSliderFadeColor(@ColorInt int i) {
        this.b = i;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.b;
    }

    public void setCoveredFadeColor(@ColorInt int i) {
        this.c = i;
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.c;
    }

    public void setPanelSlideListener(br brVar) {
        this.p = brVar;
    }

    final void a(View view) {
        int paddingLeft;
        int left;
        int right;
        int top;
        int bottom;
        int childCount;
        int i;
        View childAt;
        int max;
        int i2;
        boolean c = c();
        int width = c ? getWidth() - getPaddingRight() : getPaddingLeft();
        if (c) {
            paddingLeft = getPaddingLeft();
        } else {
            paddingLeft = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view != null) {
            Object obj;
            if (ViewCompat.j(view)) {
                obj = 1;
            } else {
                if (VERSION.SDK_INT < 18) {
                    Drawable background = view.getBackground();
                    if (background != null) {
                        obj = background.getOpacity() == -1 ? 1 : null;
                    }
                }
                obj = null;
            }
            if (obj != null) {
                left = view.getLeft();
                right = view.getRight();
                top = view.getTop();
                bottom = view.getBottom();
                childCount = getChildCount();
                i = 0;
                while (i < childCount) {
                    childAt = getChildAt(i);
                    if (childAt != view) {
                        max = Math.max(c ? paddingLeft : width, childAt.getLeft());
                        int max2 = Math.max(paddingTop, childAt.getTop());
                        if (c) {
                            i2 = paddingLeft;
                        } else {
                            i2 = width;
                        }
                        i2 = Math.min(i2, childAt.getRight());
                        int min = Math.min(height, childAt.getBottom());
                        if (max >= left || max2 < r3 || i2 > r4 || min > r2) {
                            i2 = 0;
                        } else {
                            i2 = 4;
                        }
                        childAt.setVisibility(i2);
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
        bottom = 0;
        top = 0;
        right = 0;
        left = 0;
        childCount = getChildCount();
        i = 0;
        while (i < childCount) {
            childAt = getChildAt(i);
            if (childAt != view) {
                if (c) {
                }
                max = Math.max(c ? paddingLeft : width, childAt.getLeft());
                int max22 = Math.max(paddingTop, childAt.getTop());
                if (c) {
                    i2 = paddingLeft;
                } else {
                    i2 = width;
                }
                i2 = Math.min(i2, childAt.getRight());
                int min2 = Math.min(height, childAt.getBottom());
                if (max >= left) {
                }
                i2 = 0;
                childAt.setVisibility(i2);
                i++;
            } else {
                return;
            }
        }
    }

    final void a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s = true;
        int size = this.u.size();
        for (int i = 0; i < size; i++) {
            ((ch) this.u.get(i)).run();
        }
        this.u.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == UCCore.VERIFY_POLICY_QUICK) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    size = SecExceptionCode.SEC_ERROR_STA_ENC;
                }
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else if (isInEditMode()) {
            if (mode != SectionHeader.SHT_LOUSER && mode == 0) {
                i3 = mode2;
                i4 = SecExceptionCode.SEC_ERROR_STA_ENC;
                size = size2;
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        switch (i3) {
            case SectionHeader.SHT_LOUSER /*-2147483648*/:
                mode2 = 0;
                size2 = (size - getPaddingTop()) - getPaddingBottom();
                break;
            case UCCore.VERIFY_POLICY_QUICK /*1073741824*/:
                mode2 = (size - getPaddingTop()) - getPaddingBottom();
                size2 = mode2;
                break;
            default:
                mode2 = 0;
                size2 = -1;
                break;
        }
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.h = null;
        int i5 = 0;
        int i6 = paddingLeft;
        int i7 = mode2;
        float f = 0.0f;
        while (i5 < childCount) {
            float f2;
            boolean z2;
            int makeMeasureSpec;
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.c = false;
                mode2 = i6;
                mode = i7;
                f2 = f;
                z2 = z;
            } else {
                if (layoutParams.a > 0.0f) {
                    f += layoutParams.a;
                    if (layoutParams.width == 0) {
                        mode2 = i6;
                        mode = i7;
                        f2 = f;
                        z2 = z;
                    }
                }
                mode = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, SectionHeader.SHT_LOUSER);
                } else if (layoutParams.width == -1) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, UCCore.VERIFY_POLICY_QUICK);
                } else {
                    mode = MeasureSpec.makeMeasureSpec(layoutParams.width, UCCore.VERIFY_POLICY_QUICK);
                }
                if (layoutParams.height == -2) {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, SectionHeader.SHT_LOUSER);
                } else if (layoutParams.height == -1) {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, UCCore.VERIFY_POLICY_QUICK);
                } else {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, UCCore.VERIFY_POLICY_QUICK);
                }
                childAt.measure(mode, makeMeasureSpec);
                mode = childAt.getMeasuredWidth();
                makeMeasureSpec = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && makeMeasureSpec > i7) {
                    i7 = Math.min(makeMeasureSpec, size2);
                }
                makeMeasureSpec = i6 - mode;
                boolean z3 = makeMeasureSpec < 0;
                layoutParams.b = z3;
                z3 |= z;
                if (layoutParams.b) {
                    this.h = childAt;
                }
                mode2 = makeMeasureSpec;
                f2 = f;
                z2 = z3;
                mode = i7;
            }
            i5++;
            z = z2;
            i7 = mode;
            i6 = mode2;
            f = f2;
        }
        if (z || f > 0.0f) {
            int i8 = paddingLeft - this.f;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (layoutParams.width != 0 || layoutParams.a <= 0.0f) ? null : 1;
                        makeMeasureSpec = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.h) {
                            if (layoutParams.a > 0.0f) {
                                if (layoutParams.width != 0) {
                                    mode = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK);
                                } else if (layoutParams.height == -2) {
                                    mode = MeasureSpec.makeMeasureSpec(size2, SectionHeader.SHT_LOUSER);
                                } else if (layoutParams.height == -1) {
                                    mode = MeasureSpec.makeMeasureSpec(size2, UCCore.VERIFY_POLICY_QUICK);
                                } else {
                                    mode = MeasureSpec.makeMeasureSpec(layoutParams.height, UCCore.VERIFY_POLICY_QUICK);
                                }
                                if (z) {
                                    mode2 = paddingLeft - (layoutParams.rightMargin + layoutParams.leftMargin);
                                    i5 = MeasureSpec.makeMeasureSpec(mode2, UCCore.VERIFY_POLICY_QUICK);
                                    if (makeMeasureSpec != mode2) {
                                        childAt2.measure(i5, mode);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((layoutParams.a * ((float) Math.max(0, i6))) / f)) + makeMeasureSpec, UCCore.VERIFY_POLICY_QUICK), mode);
                                }
                            }
                        } else if (layoutParams.width < 0 && (makeMeasureSpec > i8 || layoutParams.a > 0.0f)) {
                            if (obj == null) {
                                mode2 = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK);
                            } else if (layoutParams.height == -2) {
                                mode2 = MeasureSpec.makeMeasureSpec(size2, SectionHeader.SHT_LOUSER);
                            } else if (layoutParams.height == -1) {
                                mode2 = MeasureSpec.makeMeasureSpec(size2, UCCore.VERIFY_POLICY_QUICK);
                            } else {
                                mode2 = MeasureSpec.makeMeasureSpec(layoutParams.height, UCCore.VERIFY_POLICY_QUICK);
                            }
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i8, UCCore.VERIFY_POLICY_QUICK), mode2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, (getPaddingTop() + i7) + getPaddingBottom());
        this.g = z;
        if (this.q.a != 0 && !z) {
            this.q.b();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean c = c();
        if (c) {
            this.q.i = 2;
        } else {
            this.q.i = 1;
        }
        int i5 = i3 - i;
        int paddingRight = c ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = c ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.s) {
            float f = (this.g && this.r) ? IPictureView.DEFAULT_MIN_SCALE : 0.0f;
            this.i = f;
        }
        int i6 = 0;
        int i7 = paddingRight;
        while (i6 < childCount) {
            int i8;
            int i9;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int i10;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int i11 = 0;
                if (layoutParams.b) {
                    int min = (Math.min(paddingRight, (i5 - paddingLeft) - this.f) - i7) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.k = min;
                    i8 = c ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.c = ((i7 + i8) + min) + (measuredWidth / 2) > i5 - paddingLeft;
                    i9 = (int) (((float) min) * this.i);
                    i10 = i7 + (i8 + i9);
                    this.i = ((float) i9) / ((float) this.k);
                } else {
                    if (!this.g || this.m == 0) {
                        i9 = 0;
                    } else {
                        i9 = (int) ((IPictureView.DEFAULT_MIN_SCALE - this.i) * ((float) this.m));
                    }
                    i11 = i9;
                    i10 = paddingRight;
                }
                if (c) {
                    i8 = (i5 - i10) + i11;
                    i9 = i8 - measuredWidth;
                } else {
                    i9 = i10 - i11;
                    i8 = i9 + measuredWidth;
                }
                childAt.layout(i9, paddingTop, i8, childAt.getMeasuredHeight() + paddingTop);
                i9 = childAt.getWidth() + paddingRight;
                i8 = i10;
            } else {
                i9 = paddingRight;
                i8 = i7;
            }
            i6++;
            paddingRight = i9;
            i7 = i8;
        }
        if (this.s) {
            if (this.g) {
                if (this.m != 0) {
                    b(this.i);
                }
                if (((LayoutParams) this.h.getLayoutParams()).c) {
                    a(this.h, this.i, this.b);
                }
            } else {
                for (i9 = 0; i9 < childCount; i9++) {
                    a(getChildAt(i9), 0.0f, this.b);
                }
            }
            a(this.h);
        }
        this.s = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.s = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.g) {
            this.r = view == this.h;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
        r6 = this;
        r2 = 0;
        r1 = 1;
        r3 = android.support.v4.view.cx.a(r7);
        r0 = r6.g;
        if (r0 != 0) goto L_0x002b;
    L_0x000a:
        if (r3 != 0) goto L_0x002b;
    L_0x000c:
        r0 = r6.getChildCount();
        if (r0 <= r1) goto L_0x002b;
    L_0x0012:
        r0 = r6.getChildAt(r1);
        if (r0 == 0) goto L_0x002b;
    L_0x0018:
        r4 = r7.getX();
        r4 = (int) r4;
        r5 = r7.getY();
        r5 = (int) r5;
        r0 = android.support.v4.widget.bt.b(r0, r4, r5);
        if (r0 != 0) goto L_0x003f;
    L_0x0028:
        r0 = r1;
    L_0x0029:
        r6.r = r0;
    L_0x002b:
        r0 = r6.g;
        if (r0 == 0) goto L_0x0035;
    L_0x002f:
        r0 = r6.l;
        if (r0 == 0) goto L_0x0041;
    L_0x0033:
        if (r3 == 0) goto L_0x0041;
    L_0x0035:
        r0 = r6.q;
        r0.a();
        r2 = super.onInterceptTouchEvent(r7);
    L_0x003e:
        return r2;
    L_0x003f:
        r0 = r2;
        goto L_0x0029;
    L_0x0041:
        r0 = 3;
        if (r3 == r0) goto L_0x0046;
    L_0x0044:
        if (r3 != r1) goto L_0x004c;
    L_0x0046:
        r0 = r6.q;
        r0.a();
        goto L_0x003e;
    L_0x004c:
        switch(r3) {
            case 0: goto L_0x005c;
            case 1: goto L_0x004f;
            case 2: goto L_0x007e;
            default: goto L_0x004f;
        };
    L_0x004f:
        r0 = r2;
    L_0x0050:
        r3 = r6.q;
        r3 = r3.a(r7);
        if (r3 != 0) goto L_0x005a;
    L_0x0058:
        if (r0 == 0) goto L_0x003e;
    L_0x005a:
        r2 = r1;
        goto L_0x003e;
    L_0x005c:
        r6.l = r2;
        r0 = r7.getX();
        r3 = r7.getY();
        r6.n = r0;
        r6.o = r3;
        r4 = r6.h;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = android.support.v4.widget.bt.b(r4, r0, r3);
        if (r0 == 0) goto L_0x004f;
    L_0x0074:
        r0 = r6.h;
        r0 = r6.b(r0);
        if (r0 == 0) goto L_0x004f;
    L_0x007c:
        r0 = r1;
        goto L_0x0050;
    L_0x007e:
        r0 = r7.getX();
        r3 = r7.getY();
        r4 = r6.n;
        r0 = r0 - r4;
        r0 = java.lang.Math.abs(r0);
        r4 = r6.o;
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r4 = r6.q;
        r4 = r4.b;
        r4 = (float) r4;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x004f;
    L_0x009d:
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x004f;
    L_0x00a1:
        r0 = r6.q;
        r0.a();
        r6.l = r1;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.g) {
            return super.onTouchEvent(motionEvent);
        }
        this.q.b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.n = x;
                this.o = y;
                break;
            case 1:
                if (b(this.h)) {
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    float f = x - this.n;
                    float f2 = y - this.o;
                    int i = this.q.b;
                    if ((f * f) + (f2 * f2) < ((float) (i * i)) && bt.b(this.h, (int) x, (int) y)) {
                        b();
                        break;
                    }
                }
                break;
        }
        return true;
    }

    private boolean b() {
        if (!this.s && !a(0.0f)) {
            return false;
        }
        this.r = false;
        return true;
    }

    private void a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (layoutParams.d == null) {
                layoutParams.d = new Paint();
            }
            layoutParams.d.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (ViewCompat.g(view) != 2) {
                ViewCompat.a(view, 2, layoutParams.d);
            }
            c(view);
        } else if (ViewCompat.g(view) != 0) {
            if (layoutParams.d != null) {
                layoutParams.d.setColorFilter(null);
            }
            Runnable chVar = new ch(this, view);
            this.u.add(chVar);
            ViewCompat.a((View) this, chVar);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.g || layoutParams.b || this.h == null)) {
            canvas.getClipBounds(this.t);
            if (c()) {
                this.t.left = Math.max(this.t.left, this.h.getRight());
            } else {
                this.t.right = Math.min(this.t.right, this.h.getLeft());
            }
            canvas.clipRect(this.t);
        }
        if (VERSION.SDK_INT < 11) {
            if (layoutParams.c && this.i > 0.0f) {
                if (!view.isDrawingCacheEnabled()) {
                    view.setDrawingCacheEnabled(true);
                }
                Bitmap drawingCache = view.getDrawingCache();
                if (drawingCache != null) {
                    canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), layoutParams.d);
                    z = false;
                    canvas.restoreToCount(save);
                    return z;
                }
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
            } else if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
        }
        z = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return z;
    }

    private void c(View view) {
        a.a(this, view);
    }

    private boolean a(float f) {
        if (!this.g) {
            return false;
        }
        int width;
        LayoutParams layoutParams = (LayoutParams) this.h.getLayoutParams();
        if (c()) {
            width = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.k) * f)) + ((float) this.h.getWidth())));
        } else {
            width = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.k) * f));
        }
        if (!this.q.a(this.h, width, this.h.getTop())) {
            return false;
        }
        a();
        ViewCompat.d(this);
        return true;
    }

    public void computeScroll() {
        if (!this.q.c()) {
            return;
        }
        if (this.g) {
            ViewCompat.d(this);
        } else {
            this.q.b();
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.d = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.e = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(getResources().getDrawable(i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(getResources().getDrawable(i));
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        if (c()) {
            drawable = this.e;
        } else {
            drawable = this.d;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (c()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    private void b(float f) {
        Object obj;
        int childCount;
        int i;
        View childAt;
        int i2;
        float f2;
        boolean c = c();
        LayoutParams layoutParams = (LayoutParams) this.h.getLayoutParams();
        if (layoutParams.c) {
            if ((c ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
                obj = 1;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    childAt = getChildAt(i);
                    if (childAt != this.h) {
                        i2 = (int) ((IPictureView.DEFAULT_MIN_SCALE - this.j) * ((float) this.m));
                        this.j = f;
                        i2 -= (int) ((IPictureView.DEFAULT_MIN_SCALE - f) * ((float) this.m));
                        if (c) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (obj == null) {
                            if (c) {
                                f2 = IPictureView.DEFAULT_MIN_SCALE - this.j;
                            } else {
                                f2 = this.j - IPictureView.DEFAULT_MIN_SCALE;
                            }
                            a(childAt, f2, this.c);
                        }
                    }
                }
            }
        }
        obj = null;
        childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            childAt = getChildAt(i);
            if (childAt != this.h) {
                i2 = (int) ((IPictureView.DEFAULT_MIN_SCALE - this.j) * ((float) this.m));
                this.j = f;
                i2 -= (int) ((IPictureView.DEFAULT_MIN_SCALE - f) * ((float) this.m));
                if (c) {
                    i2 = -i2;
                }
                childAt.offsetLeftAndRight(i2);
                if (obj == null) {
                    if (c) {
                        f2 = IPictureView.DEFAULT_MIN_SCALE - this.j;
                    } else {
                        f2 = this.j - IPictureView.DEFAULT_MIN_SCALE;
                    }
                    a(childAt, f2, this.c);
                }
            }
        }
    }

    final boolean b(View view) {
        if (view == null) {
            return false;
        }
        return this.g && ((LayoutParams) view.getLayoutParams()).c && this.i > 0.0f;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        boolean z = this.g ? !this.g || this.i == IPictureView.DEFAULT_MIN_SCALE : this.r;
        savedState.a = z;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (!savedState.a) {
                b();
            } else if (this.s || a((float) IPictureView.DEFAULT_MIN_SCALE)) {
                this.r = true;
            }
            this.r = savedState.a;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private boolean c() {
        return ViewCompat.h(this) == 1;
    }

    static /* synthetic */ void a(SlidingPaneLayout slidingPaneLayout, int i) {
        if (slidingPaneLayout.h == null) {
            slidingPaneLayout.i = 0.0f;
            return;
        }
        boolean c = slidingPaneLayout.c();
        LayoutParams layoutParams = (LayoutParams) slidingPaneLayout.h.getLayoutParams();
        int width = slidingPaneLayout.h.getWidth();
        if (c) {
            i = (slidingPaneLayout.getWidth() - i) - width;
        }
        slidingPaneLayout.i = ((float) (i - ((c ? layoutParams.rightMargin : layoutParams.leftMargin) + (c ? slidingPaneLayout.getPaddingRight() : slidingPaneLayout.getPaddingLeft())))) / ((float) slidingPaneLayout.k);
        if (slidingPaneLayout.m != 0) {
            slidingPaneLayout.b(slidingPaneLayout.i);
        }
        if (layoutParams.c) {
            slidingPaneLayout.a(slidingPaneLayout.h, slidingPaneLayout.i, slidingPaneLayout.b);
        }
    }
}
