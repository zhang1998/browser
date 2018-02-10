package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.animation.LinearInterpolator;
import com.uc.imagecodec.export.IPictureView;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
public class cu extends Drawable implements Callback {
    static final String a = cu.class.getSimpleName();
    k b;
    final ValueAnimator c = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
    float d = IPictureView.DEFAULT_MIN_SCALE;
    float e = IPictureView.DEFAULT_MIN_SCALE;
    float f = 0.0f;
    @Nullable
    cq g;
    @Nullable
    String h;
    @Nullable
    bz i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    @Nullable
    cn n;
    private final Matrix o = new Matrix();
    private int p = 255;

    public cu() {
        this.c.setRepeatCount(0);
        this.c.setInterpolator(new LinearInterpolator());
        this.c.addUpdateListener(new dv(this));
    }

    public final void a() {
        if (this.g != null) {
            this.g.a();
        }
    }

    final void b() {
        k kVar = this.b;
        Rect rect = kVar.e;
        List emptyList = Collections.emptyList();
        cp cpVar = cp.PreComp;
        List emptyList2 = Collections.emptyList();
        du duVar = new du(new h(), new h(), new dr(), new cs(), new dt());
        this.n = new cn(this, new bx(emptyList, kVar, null, -1, cpVar, -1, null, emptyList2, duVar, 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), Collections.emptyList(), br.a), this.b.d, this.b);
    }

    public void invalidateSelf() {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.p = i;
    }

    public int getAlpha() {
        return this.p;
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -3;
    }

    public void draw(@NonNull Canvas canvas) {
        if (this.n != null) {
            this.o.reset();
            this.o.preScale(this.e, this.e);
            this.n.a(canvas, this.o, this.p);
        }
    }

    public final void a(boolean z) {
        this.c.setRepeatCount(z ? -1 : 0);
    }

    final void b(boolean z) {
        if (this.n == null) {
            this.j = true;
            this.k = false;
            return;
        }
        if (z) {
            this.c.setCurrentPlayTime((long) (this.f * ((float) this.c.getDuration())));
        }
        this.c.start();
    }

    public final void a(float f) {
        this.d = f;
        if (f < 0.0f) {
            this.c.setFloatValues(new float[]{IPictureView.DEFAULT_MIN_SCALE, 0.0f});
        } else {
            this.c.setFloatValues(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
        }
        if (this.b != null) {
            this.c.setDuration((long) (((float) this.b.a()) / Math.abs(f)));
        }
    }

    public final void b(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.f = f;
        if (this.n != null) {
            this.n.a(f);
        }
    }

    public final void c(float f) {
        this.e = f;
        c();
    }

    final void c() {
        if (this.b != null) {
            setBounds(0, 0, (int) (((float) this.b.e.width()) * this.e), (int) (((float) this.b.e.height()) * this.e));
        }
    }

    public final void d() {
        this.j = false;
        this.k = false;
        this.c.cancel();
    }

    public int getIntrinsicWidth() {
        if (this.b == null) {
            return -1;
        }
        return (int) (((float) this.b.e.width()) * this.e);
    }

    public int getIntrinsicHeight() {
        if (this.b == null) {
            return -1;
        }
        return (int) (((float) this.b.e.height()) * this.e);
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
