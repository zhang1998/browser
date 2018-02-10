package com.taobao.weex.ui.view.refresh.circlebar;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.mini.support.v4.view.ViewCompat;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public class CircleProgressBar extends ImageView {
    public MaterialProgressDrawable a;
    private AnimationListener b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private ShapeDrawable n;
    private boolean o;
    private int[] p = new int[]{-16777216};

    public CircleProgressBar(Context context) {
        super(context);
        a();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.d = -328966;
        this.e = -1048576;
        this.p = new int[]{this.e};
        this.l = -1;
        this.f = (int) (f * IPictureView.DEFAULT_MAX_SCALE);
        this.g = -1;
        this.h = -1;
        this.m = true;
        this.o = true;
        this.i = 0;
        this.j = 100;
        this.a = new MaterialProgressDrawable(getContext(), this);
        super.setImageDrawable(this.a);
    }

    public void setProgressBackGroundColor(int i) {
        this.d = i;
    }

    private static boolean b() {
        return VERSION.SDK_INT >= 21;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!b()) {
            setMeasuredDimension(getMeasuredWidth() + (this.c * 2), getMeasuredHeight() + (this.c * 2));
        }
    }

    public int getProgressStokeWidth() {
        return this.f;
    }

    public void setProgressStokeWidth(int i) {
        this.f = (int) (getContext().getResources().getDisplayMetrics().density * ((float) i));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float f = getContext().getResources().getDisplayMetrics().density;
        this.k = Math.min(getMeasuredWidth(), getMeasuredHeight());
        if (this.k <= 0) {
            this.k = ((int) f) * 40;
        }
        if (getBackground() == null && this.o) {
            int i5 = (int) (IPictureView.DEFAULT_MID_SCALE * f);
            int i6 = (int) (f * 0.0f);
            this.c = (int) (3.5f * f);
            if (b()) {
                this.n = new ShapeDrawable(new OvalShape());
                ViewCompat.d(this, f * 4.0f);
            } else {
                this.n = new ShapeDrawable(new a(this, this.c, this.k - (this.c * 2)));
                ViewCompat.a((View) this, 1, this.n.getPaint());
                this.n.getPaint().setShadowLayer((float) this.c, (float) i6, (float) i5, 503316480);
                int i7 = this.c;
                setPadding(i7, i7, i7, i7);
            }
            this.n.getPaint().setColor(this.d);
            setBackgroundDrawable(this.n);
        }
        this.a.a.v = this.d;
        this.a.a(this.p);
        if (this.m) {
            e eVar = this.a.a;
            if (IPictureView.DEFAULT_MIN_SCALE != eVar.p) {
                eVar.p = IPictureView.DEFAULT_MIN_SCALE;
                eVar.d();
            }
            this.a.a.a(true);
        }
        super.setImageDrawable(null);
        super.setImageDrawable(this.a);
        this.a.setAlpha(255);
        if (getVisibility() == 0) {
            this.a.a(0.0f, 0.8f);
        }
    }

    public void setShowArrow(boolean z) {
        this.m = z;
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.b = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.b != null) {
            this.b.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.b != null) {
            this.b.onAnimationEnd(getAnimation());
        }
    }

    public void setColorSchemeColors(int... iArr) {
        this.p = iArr;
        if (this.a != null) {
            this.a.a(iArr);
        }
    }

    public void setBackgroundColorResource(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(getResources().getColor(i));
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    public int getMax() {
        return this.j;
    }

    public void setMax(int i) {
        this.j = i;
    }

    public int getProgress() {
        return this.i;
    }

    public void setProgress(int i) {
        if (getMax() > 0) {
            this.i = i;
        }
        invalidate();
    }

    public void setCircleBackgroundEnabled(boolean z) {
        this.o = z;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            boolean z;
            this.a.stop();
            MaterialProgressDrawable materialProgressDrawable = this.a;
            if (getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            materialProgressDrawable.setVisible(z, false);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            this.a.stop();
            this.a.setVisible(false, false);
        }
    }

    public void setProgressRotation(float f) {
        this.a.a.c(f);
    }
}
