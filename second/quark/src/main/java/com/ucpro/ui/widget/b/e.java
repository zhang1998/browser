package com.ucpro.ui.widget.b;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class e extends View {
    public long a;
    public int b;
    public int c;
    public int d;
    Runnable e = new c(this);
    private long f;
    private long g = 25;
    private float h;
    private float i = 0.95f;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private Handler t = new com.ucweb.common.util.e(getClass().getName(), Looper.getMainLooper());
    private Rect u = new Rect();
    private ValueAnimator v;
    private f w;
    private b x = null;

    public e(Context context) {
        super(context);
        setWillNotDraw(false);
        a();
    }

    public final Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public final void draw(Canvas canvas) {
        long j;
        f fVar;
        long j2 = 0;
        canvas.save();
        if (!this.q) {
            this.q = true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.s) {
            j = 0;
        } else {
            j = currentTimeMillis - this.f;
        }
        this.j = Math.abs(((float) j) / 1000.0f);
        this.f = currentTimeMillis;
        this.a = j + this.a;
        this.m = getVelocity();
        this.l += this.m * this.j;
        if (!this.p && this.l > this.i) {
            this.l = this.i;
            if (this.w != null) {
                fVar = this.w;
                if (!fVar.d) {
                    fVar.d = true;
                    fVar.c = new GradientDrawable(Orientation.RIGHT_LEFT, fVar.a);
                    fVar.e = false;
                }
            }
        }
        this.u.right = (int) (this.l * this.h);
        this.t.removeCallbacksAndMessages(null);
        this.t.postDelayed(this.e, this.g);
        if (getOffsetY() != 0.0f) {
            canvas.translate(0.0f, getOffsetY());
        }
        super.draw(canvas);
        float f = this.j;
        this.o = (float) this.u.right;
        if (this.p) {
            this.k = (f * 1200.0f) + this.k;
            this.o += this.k;
            if (this.o >= this.h) {
                this.o = this.h;
                if (!c()) {
                    if (this.v == null) {
                        this.v = ValueAnimator.ofFloat(new float[]{0.0f, (float) (-getHeight())});
                        this.v.setDuration(500);
                        this.v.addUpdateListener(new d(this));
                        this.v.addListener(new a(this));
                    }
                    this.v.start();
                }
            }
        }
        if (this.w != null) {
            fVar = this.w;
            int i = (int) this.o;
            int height = getHeight();
            fVar.i = 0;
            fVar.j = 0;
            fVar.k = i;
            fVar.l = height;
            if (fVar.b != null) {
                fVar.b.setBounds(0, 0, fVar.a(), fVar.b());
            }
            if (fVar.c != null) {
                fVar.c.setBounds(0, 0, fVar.a(), fVar.b());
            }
            f fVar2 = this.w;
            if (fVar2.a() > 0) {
                Drawable drawable;
                Drawable drawable2;
                canvas.save();
                canvas.translate((float) fVar2.i, (float) fVar2.j);
                canvas.clipRect(0, 0, fVar2.a(), fVar2.b());
                j = System.currentTimeMillis();
                if (fVar2.f != 0) {
                    j2 = j - fVar2.f;
                }
                fVar2.g = Math.abs(((float) j2) / 1000.0f);
                fVar2.f = j;
                if (fVar2.d) {
                    fVar2.h = (int) (((float) fVar2.h) + (fVar2.g * 600.0f));
                    if (fVar2.h >= fVar2.a()) {
                        fVar2.e = !fVar2.e;
                    }
                    fVar2.h %= fVar2.a();
                    canvas.translate((float) fVar2.h, 0.0f);
                }
                if (fVar2.e) {
                    drawable = fVar2.c;
                    drawable2 = fVar2.b;
                } else {
                    drawable = fVar2.b;
                    drawable2 = fVar2.c;
                }
                if (drawable != null && fVar2.h >= 0 && fVar2.h < fVar2.a()) {
                    drawable.draw(canvas);
                }
                if (fVar2.d && drawable2 != null && fVar2.h > 0 && fVar2.h <= fVar2.a()) {
                    canvas.save();
                    canvas.translate((float) (-drawable2.getBounds().width()), 0.0f);
                    drawable2.draw(canvas);
                    canvas.restore();
                }
                canvas.restore();
            }
        }
        canvas.restore();
    }

    private float getVelocity() {
        if (this.p) {
            if (this.r) {
                return IPictureView.DEFAULT_MIN_SCALE;
            }
            return 0.4f;
        } else if (this.a >= 2000) {
            return 0.05f;
        } else {
            if (this.c != 1) {
                return this.b == 1 ? this.r ? 0.4f : 0.2f : this.r ? 0.2f : 0.05f;
            } else {
                if (this.r) {
                    return IPictureView.DEFAULT_MIN_SCALE;
                }
                return 0.4f;
            }
        }
    }

    public final void a() {
        int c = a.c("default_purpleblue");
        int c2 = a.c("default_purpleblue");
        this.w = new f(new int[]{c, c2});
        invalidate();
    }

    private boolean c() {
        return this.v != null && this.v.isRunning();
    }

    public final void b() {
        if (!this.p) {
            this.p = true;
            this.k = 0.0f;
            if (this.w != null) {
                f fVar = this.w;
                fVar.h = 0;
                fVar.d = false;
                fVar.e = false;
            }
            if (this.x != null) {
                this.x.a();
            }
        }
    }

    public final void setVisible(boolean z) {
        if (z) {
            this.r = true;
            this.f = System.currentTimeMillis();
            this.j = 0.0f;
            this.a = 0;
            this.p = false;
            this.k = 0.0f;
            this.l = 0.0f;
            this.h = (float) getMeasuredWidth();
            this.o = 0.0f;
            this.s = false;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            setOffsetY(0.0f);
            setVisibility(0);
            invalidate();
            return;
        }
        if (c()) {
            this.v.cancel();
        }
        setOffsetY(0.0f);
        setVisibility(8);
    }

    private void setOffsetY(float f) {
        this.n = f;
    }

    private float getOffsetY() {
        return this.n;
    }

    public final float getProgress() {
        return this.l;
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.u.bottom = getHeight();
        this.h = (float) getWidth();
    }

    public final void setProgressListener(b bVar) {
        this.x = bVar;
    }
}
