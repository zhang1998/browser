package com.github.rahatarmanahmed.cpv;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public class CircularProgressView extends View {
    private Paint a;
    private int b = 0;
    private RectF c;
    private boolean d;
    private boolean e;
    private float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private List<Object> p;
    private float q;
    private float r;
    private ValueAnimator s;
    private ValueAnimator t;
    private AnimatorSet u;
    private float v;

    public CircularProgressView(Context context) {
        super(context);
        a(null, 0);
    }

    public CircularProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 0);
    }

    public CircularProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet, i);
    }

    private void a(AttributeSet attributeSet, int i) {
        this.p = new ArrayList();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, n.CircularProgressView, i, 0);
        Resources resources = getResources();
        this.f = obtainStyledAttributes.getFloat(n.CircularProgressView_cpv_progress, (float) resources.getInteger(k.cpv_default_progress));
        this.g = obtainStyledAttributes.getFloat(n.CircularProgressView_cpv_maxProgress, (float) resources.getInteger(k.cpv_default_max_progress));
        this.j = obtainStyledAttributes.getDimensionPixelSize(n.CircularProgressView_cpv_thickness, resources.getDimensionPixelSize(l.cpv_default_thickness));
        this.d = obtainStyledAttributes.getBoolean(n.CircularProgressView_cpv_indeterminate, resources.getBoolean(o.cpv_default_is_indeterminate));
        this.e = obtainStyledAttributes.getBoolean(n.CircularProgressView_cpv_animAutostart, resources.getBoolean(o.cpv_default_anim_autostart));
        this.v = obtainStyledAttributes.getFloat(n.CircularProgressView_cpv_startAngle, (float) resources.getInteger(k.cpv_default_start_angle));
        this.q = this.v;
        int identifier = getContext().getResources().getIdentifier("colorAccent", "attr", getContext().getPackageName());
        if (obtainStyledAttributes.hasValue(n.CircularProgressView_cpv_color)) {
            this.k = obtainStyledAttributes.getColor(n.CircularProgressView_cpv_color, resources.getColor(j.cpv_default_color));
        } else if (identifier != 0) {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(identifier, typedValue, true);
            this.k = typedValue.data;
        } else if (VERSION.SDK_INT >= 21) {
            this.k = getContext().obtainStyledAttributes(new int[]{16843829}).getColor(0, resources.getColor(j.cpv_default_color));
        } else {
            this.k = resources.getColor(j.cpv_default_color);
        }
        this.l = obtainStyledAttributes.getInteger(n.CircularProgressView_cpv_animDuration, resources.getInteger(k.cpv_default_anim_duration));
        this.m = obtainStyledAttributes.getInteger(n.CircularProgressView_cpv_animSwoopDuration, resources.getInteger(k.cpv_default_anim_swoop_duration));
        this.n = obtainStyledAttributes.getInteger(n.CircularProgressView_cpv_animSyncDuration, resources.getInteger(k.cpv_default_anim_sync_duration));
        this.o = obtainStyledAttributes.getInteger(n.CircularProgressView_cpv_animSteps, resources.getInteger(k.cpv_default_anim_steps));
        obtainStyledAttributes.recycle();
        this.a = new Paint(1);
        d();
        this.c = new RectF();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int measuredWidth = getMeasuredWidth() - paddingLeft;
        int measuredHeight = getMeasuredHeight() - paddingTop;
        if (measuredWidth >= measuredHeight) {
            measuredWidth = measuredHeight;
        }
        this.b = measuredWidth;
        setMeasuredDimension(this.b + paddingLeft, this.b + paddingTop);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i >= i2) {
            i = i2;
        }
        this.b = i;
        c();
    }

    private void c() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.c.set((float) (this.j + paddingLeft), (float) (this.j + paddingTop), (float) ((this.b - paddingLeft) - this.j), (float) ((this.b - paddingTop) - this.j));
    }

    private void d() {
        this.a.setColor(this.k);
        this.a.setStyle(Style.STROKE);
        this.a.setStrokeWidth((float) this.j);
        this.a.setStrokeCap(Cap.BUTT);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = isInEditMode() ? (this.f / this.g) * 360.0f : (this.r / this.g) * 360.0f;
        if (this.d) {
            canvas.drawArc(this.c, this.i + this.q, this.h, false, this.a);
            return;
        }
        canvas.drawArc(this.c, this.q, f, false, this.a);
    }

    public void setIndeterminate(boolean z) {
        boolean z2 = this.d;
        Object obj = this.d == z ? 1 : null;
        this.d = z;
        if (obj != null) {
            a();
        }
        if (z2 != z) {
            Iterator it = this.p.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public int getThickness() {
        return this.j;
    }

    public void setThickness(int i) {
        this.j = i;
        d();
        c();
        invalidate();
    }

    public int getColor() {
        return this.k;
    }

    public void setColor(int i) {
        this.k = i;
        d();
        invalidate();
    }

    public float getMaxProgress() {
        return this.g;
    }

    public void setMaxProgress(float f) {
        this.g = f;
        invalidate();
    }

    public float getProgress() {
        return this.f;
    }

    public void setProgress(float f) {
        this.f = f;
        if (!this.d) {
            if (this.t != null && this.t.isRunning()) {
                this.t.cancel();
            }
            this.t = ValueAnimator.ofFloat(new float[]{this.r, f});
            this.t.setDuration((long) this.n);
            this.t.setInterpolator(new LinearInterpolator());
            this.t.addUpdateListener(new a(this));
            this.t.addListener(new b(this, f));
            this.t.start();
        }
        invalidate();
        Iterator it = this.p.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final void a() {
        if (this.s != null && this.s.isRunning()) {
            this.s.cancel();
        }
        if (this.t != null && this.t.isRunning()) {
            this.t.cancel();
        }
        if (this.u != null && this.u.isRunning()) {
            this.u.cancel();
        }
        if (this.d) {
            this.h = 15.0f;
            this.u = new AnimatorSet();
            Animator animator = null;
            int i = 0;
            while (i < this.o) {
                float f = ((360.0f * ((float) (this.o - 1))) / ((float) this.o)) + 15.0f;
                float f2 = -90.0f + ((f - 15.0f) * ((float) i));
                Animator ofFloat = ValueAnimator.ofFloat(new float[]{15.0f, f});
                ofFloat.setDuration((long) ((this.l / this.o) / 2));
                ofFloat.setInterpolator(new DecelerateInterpolator(IPictureView.DEFAULT_MIN_SCALE));
                ofFloat.addUpdateListener(new f(this));
                Animator ofFloat2 = ValueAnimator.ofFloat(new float[]{(720.0f * r2) / ((float) this.o), ((0.5f + r2) * 720.0f) / ((float) this.o)});
                ofFloat2.setDuration((long) ((this.l / this.o) / 2));
                ofFloat2.setInterpolator(new LinearInterpolator());
                ofFloat2.addUpdateListener(new g(this));
                Animator ofFloat3 = ValueAnimator.ofFloat(new float[]{f2, (f2 + f) - 15.0f});
                ofFloat3.setDuration((long) ((this.l / this.o) / 2));
                ofFloat3.setInterpolator(new DecelerateInterpolator(IPictureView.DEFAULT_MIN_SCALE));
                ofFloat3.addUpdateListener(new h(this, f, f2));
                Animator ofFloat4 = ValueAnimator.ofFloat(new float[]{((0.5f + r2) * 720.0f) / ((float) this.o), ((r2 + IPictureView.DEFAULT_MIN_SCALE) * 720.0f) / ((float) this.o)});
                ofFloat4.setDuration((long) ((this.l / this.o) / 2));
                ofFloat4.setInterpolator(new LinearInterpolator());
                ofFloat4.addUpdateListener(new i(this));
                Animator animatorSet = new AnimatorSet();
                animatorSet.play(ofFloat).with(ofFloat2);
                animatorSet.play(ofFloat3).with(ofFloat4).after(ofFloat2);
                Builder play = this.u.play(animatorSet);
                if (animator != null) {
                    play.after(animator);
                }
                i++;
                animator = animatorSet;
            }
            this.u.addListener(new e(this));
            this.u.start();
            Iterator it = this.p.iterator();
            while (it.hasNext()) {
                it.next();
            }
            return;
        }
        this.q = this.v;
        this.s = ValueAnimator.ofFloat(new float[]{this.q, this.q + 360.0f});
        this.s.setDuration((long) this.m);
        this.s.setInterpolator(new DecelerateInterpolator(2.0f));
        this.s.addUpdateListener(new c(this));
        this.s.start();
        this.r = 0.0f;
        this.t = ValueAnimator.ofFloat(new float[]{this.r, this.f});
        this.t.setDuration((long) this.n);
        this.t.setInterpolator(new LinearInterpolator());
        this.t.addUpdateListener(new d(this));
        this.t.start();
    }

    public final void b() {
        if (this.s != null) {
            this.s.cancel();
            this.s = null;
        }
        if (this.t != null) {
            this.t.cancel();
            this.t = null;
        }
        if (this.u != null) {
            this.u.cancel();
            this.u = null;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e) {
            a();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public void setVisibility(int i) {
        int visibility = getVisibility();
        super.setVisibility(i);
        if (i == visibility) {
            return;
        }
        if (i == 0) {
            a();
        } else if (i == 8 || i == 4) {
            b();
        }
    }
}
