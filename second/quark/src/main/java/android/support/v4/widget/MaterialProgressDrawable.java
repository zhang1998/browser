package android.support.v4.widget;

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
import android.support.v4.view.a.b;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class MaterialProgressDrawable extends Drawable implements Animatable {
    private static final Interpolator c = new LinearInterpolator();
    private static final Interpolator d = new b();
    final ag a;
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
    private final Callback n = new ao(this);

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: ProGuard */
    public @interface ProgressDrawableSize {
    }

    public MaterialProgressDrawable(Context context, View view) {
        this.i = view;
        this.h = context.getResources();
        this.a = new ag(this.n);
        this.a.a(this.e);
        a(1);
        ag agVar = this.a;
        Animation arVar = new ar(this, agVar);
        arVar.setRepeatCount(-1);
        arVar.setRepeatMode(1);
        arVar.setInterpolator(c);
        arVar.setAnimationListener(new ci(this, agVar));
        this.j = arVar;
    }

    private void a(double d, double d2, double d3, double d4, float f, float f2) {
        ag agVar = this.a;
        float f3 = this.h.getDisplayMetrics().density;
        this.l = ((double) f3) * d;
        this.m = ((double) f3) * d2;
        float f4 = ((float) d4) * f3;
        agVar.g = f4;
        agVar.b.setStrokeWidth(f4);
        agVar.d();
        agVar.q = ((double) f3) * d3;
        agVar.a(0);
        f4 = f * f3;
        f3 *= f2;
        agVar.r = (int) f4;
        agVar.s = (int) f3;
        f3 = (float) Math.min((int) this.l, (int) this.m);
        if (agVar.q <= 0.0d || f3 < 0.0f) {
            f3 = (float) Math.ceil((double) (agVar.g / 2.0f));
        } else {
            f3 = (float) (((double) (f3 / 2.0f)) - agVar.q);
        }
        agVar.h = f3;
    }

    public final void a(@ProgressDrawableSize int i) {
        if (i == 0) {
            a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public final void a(boolean z) {
        this.a.a(z);
    }

    public final void a(float f) {
        ag agVar = this.a;
        if (f != agVar.p) {
            agVar.p = f;
            agVar.d();
        }
    }

    public final void b(float f) {
        this.a.a(0.0f);
        this.a.b(f);
    }

    public final void b(int i) {
        this.a.v = i;
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
        ag agVar = this.a;
        RectF rectF = agVar.a;
        rectF.set(bounds);
        rectF.inset(agVar.h, agVar.h);
        float f = 360.0f * (agVar.d + agVar.f);
        float f2 = ((agVar.e + agVar.f) * 360.0f) - f;
        agVar.b.setColor(agVar.w);
        canvas.drawArc(rectF, f, f2, false, agVar.b);
        if (agVar.n) {
            if (agVar.o == null) {
                agVar.o = new Path();
                agVar.o.setFillType(FillType.EVEN_ODD);
            } else {
                agVar.o.reset();
            }
            float f3 = ((float) (((int) agVar.h) / 2)) * agVar.p;
            float cos = (float) ((agVar.q * Math.cos(0.0d)) + ((double) bounds.exactCenterX()));
            float sin = (float) ((agVar.q * Math.sin(0.0d)) + ((double) bounds.exactCenterY()));
            agVar.o.moveTo(0.0f, 0.0f);
            agVar.o.lineTo(((float) agVar.r) * agVar.p, 0.0f);
            agVar.o.lineTo((((float) agVar.r) * agVar.p) / 2.0f, ((float) agVar.s) * agVar.p);
            agVar.o.offset(cos - f3, sin);
            agVar.o.close();
            agVar.c.setColor(agVar.w);
            canvas.rotate((f + f2) - 5.0f, bounds.exactCenterX(), bounds.exactCenterY());
            canvas.drawPath(agVar.o, agVar.c);
        }
        if (agVar.t < 255) {
            agVar.u.setColor(agVar.v);
            agVar.u.setAlpha(255 - agVar.t);
            canvas.drawCircle(bounds.exactCenterX(), bounds.exactCenterY(), (float) (bounds.width() / 2), agVar.u);
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
        ag agVar = this.a;
        agVar.b.setColorFilter(colorFilter);
        agVar.d();
    }

    final void c(float f) {
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
        c(0.0f);
        this.a.a(false);
        this.a.a(0);
        this.a.c();
    }

    private static void c(float f, ag agVar) {
        if (f > 0.75f) {
            float f2 = (f - 0.75f) / 0.25f;
            int i = agVar.i[agVar.j];
            int i2 = agVar.i[agVar.a()];
            i = Integer.valueOf(i).intValue();
            int i3 = (i >> 24) & 255;
            int i4 = (i >> 16) & 255;
            int i5 = (i >> 8) & 255;
            i &= 255;
            i2 = Integer.valueOf(i2).intValue();
            agVar.w = (((int) (f2 * ((float) ((i2 & 255) - i)))) + i) | ((((i3 + ((int) (((float) (((i2 >> 24) & 255) - i3)) * f2))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & 255) - i4)) * f2))) << 16)) | ((((int) (((float) (((i2 >> 8) & 255) - i5)) * f2)) + i5) << 8));
        }
    }

    private static float b(ag agVar) {
        return (float) Math.toRadians(((double) agVar.g) / (6.283185307179586d * agVar.q));
    }

    static /* synthetic */ void a(float f, ag agVar) {
        c(f, agVar);
        float floor = (float) (Math.floor((double) (agVar.m / 0.8f)) + 1.0d);
        float b = b(agVar);
        agVar.a((((agVar.l - b) - agVar.k) * f) + agVar.k);
        agVar.b(agVar.l);
        agVar.c(((floor - agVar.m) * f) + agVar.m);
    }
}
