package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public class PagerTitleStrip extends ViewGroup implements az {
    private static final int[] n = new int[]{16842804, 16842901, 16842904, 16842927};
    private static final int[] o = new int[]{16843660};
    private static final bi q;
    ViewPager a;
    TextView b;
    TextView c;
    TextView d;
    int e;
    private int f = -1;
    private float g = -1.0f;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private final cb l = new cb();
    private WeakReference<dr> m;
    private int p;

    static {
        if (VERSION.SDK_INT >= 14) {
            q = new as();
        } else {
            q = new cv();
        }
    }

    private static void setSingleLineAllCaps(TextView textView) {
        q.a(textView);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        View textView = new TextView(context);
        this.b = textView;
        addView(textView);
        textView = new TextView(context);
        this.c = textView;
        addView(textView);
        textView = new TextView(context);
        this.d = textView;
        addView(textView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.b.setTextAppearance(context, resourceId);
            this.c.setTextAppearance(context, resourceId);
            this.d.setTextAppearance(context, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            float f = (float) dimensionPixelSize;
            this.b.setTextSize(0, f);
            this.c.setTextSize(0, f);
            this.d.setTextSize(0, f);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            dimensionPixelSize = obtainStyledAttributes.getColor(2, 0);
            this.b.setTextColor(dimensionPixelSize);
            this.c.setTextColor(dimensionPixelSize);
            this.d.setTextColor(dimensionPixelSize);
        }
        this.i = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.e = this.c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.b.setEllipsize(TruncateAt.END);
        this.c.setEllipsize(TruncateAt.END);
        this.d.setEllipsize(TruncateAt.END);
        if (resourceId != 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, o);
            z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.b);
            setSingleLineAllCaps(this.c);
            setSingleLineAllCaps(this.d);
        } else {
            this.b.setSingleLine();
            this.c.setSingleLine();
            this.d.setSingleLine();
        }
        this.h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void setTextSpacing(int i) {
        this.h = i;
        requestLayout();
    }

    public int getTextSpacing() {
        return this.h;
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.p = ((int) (255.0f * f)) & 255;
        int i = (this.p << 24) | (this.e & 16777215);
        this.b.setTextColor(i);
        this.d.setTextColor(i);
    }

    public void setTextColor(@ColorInt int i) {
        this.e = i;
        this.c.setTextColor(i);
        int i2 = (this.p << 24) | (this.e & 16777215);
        this.b.setTextColor(i2);
        this.d.setTextColor(i2);
    }

    public void setGravity(int i) {
        this.i = i;
        requestLayout();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            dr adapter = viewPager.getAdapter();
            viewPager.a(this.l);
            viewPager.setOnAdapterChangeListener(this.l);
            this.a = viewPager;
            a(this.m != null ? (dr) this.m.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            a(this.a.getAdapter(), null);
            this.a.a(null);
            this.a.setOnAdapterChangeListener(null);
            this.a = null;
        }
    }

    final void a(int i) {
        this.j = true;
        this.b.setText(null);
        this.c.setText(null);
        this.d.setText(null);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), SectionHeader.SHT_LOUSER);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), SectionHeader.SHT_LOUSER);
        this.b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f = i;
        if (!this.k) {
            a(i, this.g, false);
        }
        this.j = false;
    }

    public void requestLayout() {
        if (!this.j) {
            super.requestLayout();
        }
    }

    final void a(dr drVar, dr drVar2) {
        if (drVar != null) {
            drVar.a.unregisterObserver(this.l);
            this.m = null;
        }
        if (drVar2 != null) {
            drVar2.a.registerObserver(this.l);
            this.m = new WeakReference(drVar2);
        }
        if (this.a != null) {
            this.f = -1;
            this.g = -1.0f;
            a(this.a.getCurrentItem());
            requestLayout();
        }
    }

    void a(int i, float f, boolean z) {
        if (i != this.f) {
            this.a.getAdapter();
            a(i);
        } else if (!z && f == this.g) {
            return;
        }
        this.k = true;
        int measuredWidth = this.b.getMeasuredWidth();
        int measuredWidth2 = this.c.getMeasuredWidth();
        int measuredWidth3 = this.d.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = paddingRight + i2;
        int i4 = (width - (paddingLeft + i2)) - i3;
        float f2 = 0.5f + f;
        if (f2 > IPictureView.DEFAULT_MIN_SCALE) {
            f2 -= IPictureView.DEFAULT_MIN_SCALE;
        }
        i3 = ((width - i3) - ((int) (f2 * ((float) i4)))) - i2;
        i4 = i3 + measuredWidth2;
        int baseline = this.b.getBaseline();
        measuredWidth2 = this.c.getBaseline();
        i2 = this.d.getBaseline();
        int max = Math.max(Math.max(baseline, measuredWidth2), i2);
        baseline = max - baseline;
        measuredWidth2 = max - measuredWidth2;
        max -= i2;
        int measuredHeight = this.d.getMeasuredHeight() + max;
        i2 = Math.max(Math.max(this.b.getMeasuredHeight() + baseline, this.c.getMeasuredHeight() + measuredWidth2), measuredHeight);
        switch (this.i & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) {
            case 16:
                height = (((height - paddingTop) - paddingBottom) - i2) / 2;
                i2 = height + baseline;
                baseline = height + measuredWidth2;
                measuredWidth2 = height + max;
                break;
            case 80:
                height = (height - paddingBottom) - i2;
                i2 = height + baseline;
                baseline = height + measuredWidth2;
                measuredWidth2 = height + max;
                break;
            default:
                i2 = paddingTop + baseline;
                baseline = paddingTop + measuredWidth2;
                measuredWidth2 = paddingTop + max;
                break;
        }
        this.c.layout(i3, baseline, i4, this.c.getMeasuredHeight() + baseline);
        baseline = Math.min(paddingLeft, (i3 - this.h) - measuredWidth);
        this.b.layout(baseline, i2, measuredWidth + baseline, this.b.getMeasuredHeight() + i2);
        baseline = Math.max((width - paddingRight) - measuredWidth3, this.h + i4);
        this.d.layout(baseline, measuredWidth2, baseline + measuredWidth3, this.d.getMeasuredHeight() + measuredWidth2);
        this.g = f;
        this.k = false;
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) != UCCore.VERIFY_POLICY_QUICK) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int size = MeasureSpec.getSize(i);
        int childMeasureSpec2 = getChildMeasureSpec(i, (int) (((float) size) * 0.2f), -2);
        this.b.measure(childMeasureSpec2, childMeasureSpec);
        this.c.measure(childMeasureSpec2, childMeasureSpec);
        this.d.measure(childMeasureSpec2, childMeasureSpec);
        if (MeasureSpec.getMode(i2) == UCCore.VERIFY_POLICY_QUICK) {
            paddingTop = MeasureSpec.getSize(i2);
        } else {
            paddingTop = Math.max(getMinHeight(), paddingTop + this.c.getMeasuredHeight());
        }
        setMeasuredDimension(size, ViewCompat.a(paddingTop, i2, ViewCompat.l(this.c) << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        if (this.a != null) {
            if (this.g >= 0.0f) {
                f = this.g;
            }
            a(this.f, f, true);
        }
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }
}
