package com.taobao.weex.ui.view.refresh.circlebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.mini.support.v4.view.b.a;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class MaterialProgressDrawable extends Drawable implements Animatable {
    private static final Interpolator c = new LinearInterpolator();
    private static final Interpolator d = new a();
    final e a;
    boolean b;
    private final int[] e = new int[]{-16777216};
    private final ArrayList<Animation> f = new ArrayList();
    private float g;
    private Resources h;
    private View i;
    private Animation j;
    private float k;
    private double l;
    private double m;
    private final Callback n = new d(this);

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: ProGuard */
    public @interface ProgressDrawableSize {
    }

    public MaterialProgressDrawable(Context context, View view) {
        this.i = view;
        this.h = context.getResources();
        this.a = new e(this.n);
        this.a.a(this.e);
        e eVar = this.a;
        float f = this.h.getDisplayMetrics().density;
        this.l = ((double) f) * 40.0d;
        this.m = ((double) f) * 40.0d;
        float f2 = 2.5f * f;
        eVar.g = f2;
        eVar.b.setStrokeWidth(f2);
        eVar.d();
        eVar.q = 8.75d * ((double) f);
        eVar.a(0);
        f2 = 10.0f * f;
        f *= 5.0f;
        eVar.r = (int) f2;
        eVar.s = (int) f;
        f = (float) Math.min((int) this.l, (int) this.m);
        if (eVar.q <= 0.0d || f < 0.0f) {
            f = (float) Math.ceil((double) (eVar.g / 2.0f));
        } else {
            f = (float) (((double) (f / 2.0f)) - eVar.q);
        }
        eVar.h = f;
        e eVar2 = this.a;
        Animation bVar = new b(this, eVar2);
        bVar.setRepeatCount(-1);
        bVar.setRepeatMode(1);
        bVar.setInterpolator(c);
        bVar.setAnimationListener(new c(this, eVar2));
        this.j = bVar;
    }

    public final void a(float f, float f2) {
        this.a.a(f);
        this.a.b(f2);
    }

    public final void a(int... iArr) {
        this.a.a(iArr);
        this.a.a(0);
    }

    public final int getIntrinsicHeight() {
        return (int) this.m;
    }

    public final int getIntrinsicWidth() {
        return (int) this.l;
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.g, bounds.exactCenterX(), bounds.exactCenterY());
        e eVar = this.a;
        RectF rectF = eVar.a;
        rectF.set(bounds);
        rectF.inset(eVar.h, eVar.h);
        float f = 360.0f * (eVar.d + eVar.f);
        float f2 = ((eVar.e + eVar.f) * 360.0f) - f;
        eVar.b.setColor(eVar.w);
        canvas.drawArc(rectF, f, f2, false, eVar.b);
        if (eVar.n) {
            if (eVar.o == null) {
                eVar.o = new Path();
                eVar.o.setFillType(FillType.EVEN_ODD);
            } else {
                eVar.o.reset();
            }
            float f3 = ((float) (((int) eVar.h) / 2)) * eVar.p;
            float cos = (float) ((eVar.q * Math.cos(0.0d)) + ((double) bounds.exactCenterX()));
            float sin = (float) ((eVar.q * Math.sin(0.0d)) + ((double) bounds.exactCenterY()));
            eVar.o.moveTo(0.0f, 0.0f);
            eVar.o.lineTo(((float) eVar.r) * eVar.p, 0.0f);
            eVar.o.lineTo((((float) eVar.r) * eVar.p) / 2.0f, ((float) eVar.s) * eVar.p);
            eVar.o.offset(cos - f3, sin);
            eVar.o.close();
            eVar.c.setColor(eVar.w);
            canvas.rotate((f + f2) - 5.0f, bounds.exactCenterX(), bounds.exactCenterY());
            canvas.drawPath(eVar.o, eVar.c);
        }
        if (eVar.t < 255) {
            eVar.u.setColor(eVar.v);
            eVar.u.setAlpha(255 - eVar.t);
            canvas.drawCircle(bounds.exactCenterX(), bounds.exactCenterY(), (float) (bounds.width() / 2), eVar.u);
        }
        canvas.restoreToCount(save);
    }

    public final void setAlpha(int i) {
        this.a.t = i;
    }

    public final int getAlpha() {
        return this.a.t;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        e eVar = this.a;
        eVar.b.setColorFilter(colorFilter);
        eVar.d();
    }

    final void a(float f) {
        this.g = f;
        invalidateSelf();
    }

    public final int getOpacity() {
        return -3;
    }

    public final boolean isRunning() {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public final void start() {
        this.j.reset();
        this.a.b();
        if (this.a.e != this.a.d) {
            this.b = true;
            this.j.setDuration(666);
            this.i.startAnimation(this.j);
            return;
        }
        this.a.a(0);
        this.a.c();
        this.j.setDuration(1332);
        this.i.startAnimation(this.j);
    }

    public final void stop() {
        this.i.clearAnimation();
        a(0.0f);
        this.a.a(false);
        this.a.a(0);
        this.a.c();
    }

    private static void c(float f, e eVar) {
        if (f > 0.75f) {
            float f2 = (f - 0.75f) / 0.25f;
            int i = eVar.i[eVar.j];
            int i2 = eVar.i[eVar.a()];
            i = Integer.valueOf(i).intValue();
            int i3 = (i >> 24) & 255;
            int i4 = (i >> 16) & 255;
            int i5 = (i >> 8) & 255;
            i &= 255;
            i2 = Integer.valueOf(i2).intValue();
            eVar.w = (((int) (f2 * ((float) ((i2 & 255) - i)))) + i) | ((((i3 + ((int) (((float) (((i2 >> 24) & 255) - i3)) * f2))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & 255) - i4)) * f2))) << 16)) | ((((int) (((float) (((i2 >> 8) & 255) - i5)) * f2)) + i5) << 8));
        }
    }

    private static float b(e eVar) {
        return (float) Math.toRadians(((double) eVar.g) / (6.283185307179586d * eVar.q));
    }

    static /* synthetic */ void a(float f, e eVar) {
        c(f, eVar);
        float floor = (float) (Math.floor((double) (eVar.m / 0.8f)) + 1.0d);
        float b = b(eVar);
        eVar.a((((eVar.l - b) - eVar.k) * f) + eVar.k);
        eVar.b(eVar.l);
        eVar.c(((floor - eVar.m) * f) + eVar.m);
    }
}
