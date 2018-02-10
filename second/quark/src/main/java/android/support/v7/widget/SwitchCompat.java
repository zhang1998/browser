package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.b.a.q;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.cx;
import android.support.v7.a.a;
import android.support.v7.c.h;
import android.support.v7.c.k;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public class SwitchCompat extends CompoundButton {
    private static final int[] F = new int[]{16842912};
    private Layout A;
    private TransformationMethod B;
    private bz C;
    private final Rect D;
    private final fb E;
    private Drawable a;
    private Drawable b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private CharSequence g;
    private CharSequence h;
    private boolean i;
    private int j;
    private int k;
    private float l;
    private float m;
    private VelocityTracker n;
    private int o;
    private float p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private TextPaint x;
    private ColorStateList y;
    private Layout z;

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = VelocityTracker.obtain();
        this.D = new Rect();
        this.x = new TextPaint(1);
        Resources resources = getResources();
        this.x.density = resources.getDisplayMetrics().density;
        dh a = dh.a(context, attributeSet, h.SwitchCompat, i);
        this.a = a.a(h.SwitchCompat_android_thumb);
        if (this.a != null) {
            this.a.setCallback(this);
        }
        this.b = a.a(h.SwitchCompat_track);
        if (this.b != null) {
            this.b.setCallback(this);
        }
        this.g = a.c(h.SwitchCompat_android_textOn);
        this.h = a.c(h.SwitchCompat_android_textOff);
        this.i = a.a(h.SwitchCompat_showText, true);
        this.c = a.c(h.SwitchCompat_thumbTextPadding, 0);
        this.d = a.c(h.SwitchCompat_switchMinWidth, 0);
        this.e = a.c(h.SwitchCompat_switchPadding, 0);
        this.f = a.a(h.SwitchCompat_splitTrack, false);
        int e = a.e(h.SwitchCompat_switchTextAppearance, 0);
        if (e != 0) {
            Typeface typeface;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(e, h.TextAppearance);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(h.TextAppearance_android_textColor);
            if (colorStateList != null) {
                this.y = colorStateList;
            } else {
                this.y = getTextColors();
            }
            e = obtainStyledAttributes.getDimensionPixelSize(h.TextAppearance_android_textSize, 0);
            if (!(e == 0 || ((float) e) == this.x.getTextSize())) {
                this.x.setTextSize((float) e);
                requestLayout();
            }
            e = obtainStyledAttributes.getInt(h.TextAppearance_android_typeface, -1);
            int i2 = obtainStyledAttributes.getInt(h.TextAppearance_android_textStyle, -1);
            switch (e) {
                case 1:
                    typeface = Typeface.SANS_SERIF;
                    break;
                case 2:
                    typeface = Typeface.SERIF;
                    break;
                case 3:
                    typeface = Typeface.MONOSPACE;
                    break;
                default:
                    typeface = null;
                    break;
            }
            if (i2 > 0) {
                boolean z;
                float f;
                if (typeface == null) {
                    typeface = Typeface.defaultFromStyle(i2);
                } else {
                    typeface = Typeface.create(typeface, i2);
                }
                setSwitchTypeface(typeface);
                if (typeface != null) {
                    e = typeface.getStyle();
                } else {
                    e = 0;
                }
                i2 &= e ^ -1;
                TextPaint textPaint = this.x;
                if ((i2 & 1) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                textPaint.setFakeBoldText(z);
                TextPaint textPaint2 = this.x;
                if ((i2 & 2) != 0) {
                    f = -0.25f;
                } else {
                    f = 0.0f;
                }
                textPaint2.setTextSkewX(f);
            } else {
                this.x.setFakeBoldText(false);
                this.x.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (obtainStyledAttributes.getBoolean(h.TextAppearance_textAllCaps, false)) {
                this.B = new a(getContext());
            } else {
                this.B = null;
            }
            obtainStyledAttributes.recycle();
        }
        this.E = fb.a();
        a.a.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.k = viewConfiguration.getScaledTouchSlop();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.x.getTypeface() != typeface) {
            this.x.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int i) {
        this.e = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.e;
    }

    public void setSwitchMinWidth(int i) {
        this.d = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.d;
    }

    public void setThumbTextPadding(int i) {
        this.c = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.c;
    }

    public void setTrackDrawable(Drawable drawable) {
        this.b = drawable;
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(this.E.a(getContext(), i, false));
    }

    public Drawable getTrackDrawable() {
        return this.b;
    }

    public void setThumbDrawable(Drawable drawable) {
        this.a = drawable;
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(this.E.a(getContext(), i, false));
    }

    public Drawable getThumbDrawable() {
        return this.a;
    }

    public void setSplitTrack(boolean z) {
        this.f = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.f;
    }

    public CharSequence getTextOn() {
        return this.g;
    }

    public void setTextOn(CharSequence charSequence) {
        this.g = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.h;
    }

    public void setTextOff(CharSequence charSequence) {
        this.h = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.i != z) {
            this.i = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.i;
    }

    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int max;
        int i3 = 0;
        if (this.i) {
            if (this.z == null) {
                this.z = a(this.g);
            }
            if (this.A == null) {
                this.A = a(this.h);
            }
        }
        Rect rect = this.D;
        if (this.a != null) {
            this.a.getPadding(rect);
            intrinsicWidth = (this.a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.a.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        if (this.i) {
            max = Math.max(this.z.getWidth(), this.A.getWidth()) + (this.c * 2);
        } else {
            max = 0;
        }
        this.s = Math.max(max, intrinsicWidth);
        if (this.b != null) {
            this.b.getPadding(rect);
            i3 = this.b.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        intrinsicWidth = rect.left;
        max = rect.right;
        if (this.a != null) {
            rect = cb.a(this.a);
            intrinsicWidth = Math.max(intrinsicWidth, rect.left);
            max = Math.max(max, rect.right);
        }
        intrinsicWidth = Math.max(this.d, (intrinsicWidth + (this.s * 2)) + max);
        intrinsicHeight = Math.max(i3, intrinsicHeight);
        this.q = intrinsicWidth;
        this.r = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(ViewCompat.k(this), intrinsicHeight);
        }
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.g : this.h;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    private Layout a(CharSequence charSequence) {
        CharSequence transformation;
        if (this.B != null) {
            transformation = this.B.getTransformation(charSequence, this);
        } else {
            transformation = charSequence;
        }
        return new StaticLayout(transformation, this.x, transformation != null ? (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.x)) : 0, Alignment.ALIGN_NORMAL, IPictureView.DEFAULT_MIN_SCALE, 0.0f, true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = IPictureView.DEFAULT_MIN_SCALE;
        int i = 0;
        this.n.addMovement(motionEvent);
        float x;
        switch (cx.a(motionEvent)) {
            case 0:
                x = motionEvent.getX();
                f = motionEvent.getY();
                if (isEnabled()) {
                    if (this.a != null) {
                        int thumbOffset = getThumbOffset();
                        this.a.getPadding(this.D);
                        int i2 = this.u - this.k;
                        thumbOffset = (thumbOffset + this.t) - this.k;
                        int i3 = (((this.s + thumbOffset) + this.D.left) + this.D.right) + this.k;
                        int i4 = this.w + this.k;
                        if (x > ((float) thumbOffset) && x < ((float) i3) && f > ((float) i2) && f < ((float) i4)) {
                            i = 1;
                        }
                    }
                    if (i != 0) {
                        this.j = 1;
                        this.l = x;
                        this.m = f;
                        break;
                    }
                }
                break;
            case 1:
            case 3:
                if (this.j != 2) {
                    this.j = 0;
                    this.n.clear();
                    break;
                }
                this.j = 0;
                boolean z = motionEvent.getAction() == 1 && isEnabled();
                boolean isChecked = isChecked();
                if (z) {
                    this.n.computeCurrentVelocity(1000);
                    x = this.n.getXVelocity();
                    z = Math.abs(x) > ((float) this.o) ? co.a(this) ? x < 0.0f : x > 0.0f : getTargetCheckedState();
                } else {
                    z = isChecked;
                }
                if (z != isChecked) {
                    playSoundEffect(0);
                }
                setChecked(z);
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                super.onTouchEvent(obtain);
                obtain.recycle();
                super.onTouchEvent(motionEvent);
                return true;
            case 2:
                switch (this.j) {
                    case 0:
                        break;
                    case 1:
                        x = motionEvent.getX();
                        f = motionEvent.getY();
                        if (Math.abs(x - this.l) > ((float) this.k) || Math.abs(f - this.m) > ((float) this.k)) {
                            this.j = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.l = x;
                            this.m = f;
                            return true;
                        }
                    case 2:
                        float x2 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f2 = x2 - this.l;
                        if (thumbScrollRange != 0) {
                            x = f2 / ((float) thumbScrollRange);
                        } else {
                            x = f2 > 0.0f ? IPictureView.DEFAULT_MIN_SCALE : -1.0f;
                        }
                        if (co.a(this)) {
                            x = -x;
                        }
                        x += this.p;
                        if (x < 0.0f) {
                            f = 0.0f;
                        } else if (x <= IPictureView.DEFAULT_MIN_SCALE) {
                            f = x;
                        }
                        if (f == this.p) {
                            return true;
                        }
                        this.l = x2;
                        setThumbPosition(f);
                        return true;
                    default:
                        break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void a() {
        if (this.C != null) {
            clearAnimation();
            this.C = null;
        }
    }

    private boolean getTargetCheckedState() {
        return this.p > 0.5f;
    }

    private void setThumbPosition(float f) {
        this.p = f;
        invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean z) {
        float f = IPictureView.DEFAULT_MIN_SCALE;
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && ViewCompat.D(this) && isShown()) {
            if (this.C != null) {
                a();
            }
            float f2 = this.p;
            if (!isChecked) {
                f = 0.0f;
            }
            this.C = new bz(this, f2, f);
            this.C.setDuration(250);
            this.C.setAnimationListener(new ed(this, isChecked));
            startAnimation(this.C);
            return;
        }
        a();
        if (!isChecked) {
            f = 0.0f;
        }
        setThumbPosition(f);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int paddingLeft;
        int paddingTop;
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.a != null) {
            Rect rect = this.D;
            if (this.b != null) {
                this.b.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect a = cb.a(this.a);
            max = Math.max(0, a.left - rect.left);
            i5 = Math.max(0, a.right - rect.right);
        } else {
            max = 0;
        }
        if (co.a(this)) {
            paddingLeft = getPaddingLeft() + max;
            max = ((this.q + paddingLeft) - max) - i5;
            i5 = paddingLeft;
        } else {
            paddingLeft = (getWidth() - getPaddingRight()) - i5;
            i5 += max + (paddingLeft - this.q);
            max = paddingLeft;
        }
        switch (getGravity() & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.r / 2);
                paddingLeft = this.r + paddingTop;
                break;
            case 80:
                paddingLeft = getHeight() - getPaddingBottom();
                paddingTop = paddingLeft - this.r;
                break;
            default:
                paddingTop = getPaddingTop();
                paddingLeft = this.r + paddingTop;
                break;
        }
        this.t = i5;
        this.u = paddingTop;
        this.w = paddingLeft;
        this.v = max;
    }

    public void draw(Canvas canvas) {
        Rect a;
        int i;
        Rect rect = this.D;
        int i2 = this.t;
        int i3 = this.u;
        int i4 = this.v;
        int i5 = this.w;
        int thumbOffset = i2 + getThumbOffset();
        if (this.a != null) {
            a = cb.a(this.a);
        } else {
            a = cb.a;
        }
        if (this.b != null) {
            this.b.getPadding(rect);
            int i6 = rect.left + thumbOffset;
            if (a != null) {
                if (a.left > rect.left) {
                    i2 += a.left - rect.left;
                }
                if (a.top > rect.top) {
                    thumbOffset = (a.top - rect.top) + i3;
                } else {
                    thumbOffset = i3;
                }
                if (a.right > rect.right) {
                    i4 -= a.right - rect.right;
                }
                i = a.bottom > rect.bottom ? i5 - (a.bottom - rect.bottom) : i5;
            } else {
                i = i5;
                thumbOffset = i3;
            }
            this.b.setBounds(i2, thumbOffset, i4, i);
            i = i6;
        } else {
            i = thumbOffset;
        }
        if (this.a != null) {
            this.a.getPadding(rect);
            i2 = i - rect.left;
            i = (i + this.s) + rect.right;
            this.a.setBounds(i2, i3, i, i5);
            Drawable background = getBackground();
            if (background != null) {
                q.a(background, i2, i3, i, i5);
            }
        }
        super.draw(canvas);
    }

    protected void onDraw(Canvas canvas) {
        int save;
        super.onDraw(canvas);
        Rect rect = this.D;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.u + rect.top;
        int i2 = this.w - rect.bottom;
        Drawable drawable2 = this.a;
        if (drawable != null) {
            if (!this.f || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect a = cb.a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += a.left;
                rect.right -= a.right;
                save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        save = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.z : this.A;
        if (layout != null) {
            int i3;
            int[] drawableState = getDrawableState();
            if (this.y != null) {
                this.x.setColor(this.y.getColorForState(drawableState, 0));
            }
            this.x.drawableState = drawableState;
            if (drawable2 != null) {
                rect = drawable2.getBounds();
                i3 = rect.right + rect.left;
            } else {
                i3 = getWidth();
            }
            canvas.translate((float) ((i3 / 2) - (layout.getWidth() / 2)), (float) (((i + i2) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public int getCompoundPaddingLeft() {
        if (!co.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.q;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft;
        }
        return compoundPaddingLeft + this.e;
    }

    public int getCompoundPaddingRight() {
        if (co.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.q;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingRight;
        }
        return compoundPaddingRight + this.e;
    }

    private int getThumbOffset() {
        float f;
        if (co.a(this)) {
            f = IPictureView.DEFAULT_MIN_SCALE - this.p;
        } else {
            f = this.p;
        }
        return (int) ((f * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.b == null) {
            return 0;
        }
        Rect a;
        Rect rect = this.D;
        this.b.getPadding(rect);
        if (this.a != null) {
            a = cb.a(this.a);
        } else {
            a = cb.a;
        }
        return ((((this.q - this.s) - rect.left) - rect.right) - a.left) - a.right;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, F);
        }
        return onCreateDrawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.a != null) {
            this.a.setState(drawableState);
        }
        if (this.b != null) {
            this.b.setState(drawableState);
        }
        invalidate();
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.a != null) {
            q.a(this.a, f, f2);
        }
        if (this.b != null) {
            q.a(this.b, f, f2);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.a || drawable == this.b;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.a != null) {
                this.a.jumpToCurrentState();
            }
            if (this.b != null) {
                this.b.jumpToCurrentState();
            }
            a();
            setThumbPosition(isChecked() ? IPictureView.DEFAULT_MIN_SCALE : 0.0f);
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.g : this.h;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(stringBuilder);
            }
        }
    }
}
