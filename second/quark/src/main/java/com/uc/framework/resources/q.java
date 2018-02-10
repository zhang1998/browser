package com.uc.framework.resources;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class q extends ac {
    private static boolean o = true;
    long a;
    public boolean b;
    final p c;
    private boolean e;
    private int f;
    private float g;
    private long h;
    private long i;
    private Drawable j;
    private Drawable k;
    private boolean l;
    private int m;
    private boolean n;

    public final boolean a(int i) {
        if (!this.l || this.m == i) {
            return super.a(i);
        }
        this.m = i;
        this.j = getCurrent();
        boolean a = super.a(i);
        this.k = getCurrent();
        if (this.j != this.k) {
            this.e = true;
            this.f = 0;
            this.i = 0;
            this.h = System.currentTimeMillis();
            this.l = false;
            return a;
        }
        this.e = false;
        this.f = 0;
        this.l = false;
        if (this.j != null) {
            this.j.setAlpha(255);
        }
        if (this.k == null) {
            return a;
        }
        this.k.setAlpha(255);
        return a;
    }

    public final boolean setState(int[] iArr) {
        this.l = true;
        return super.setState(iArr);
    }

    public final void draw(Canvas canvas) {
        if (this.e && this.b && o) {
            long currentTimeMillis = System.currentTimeMillis();
            this.i += Math.abs(currentTimeMillis - this.h);
            this.h = currentTimeMillis;
            this.f = (int) (255.0f * (IPictureView.DEFAULT_MIN_SCALE - (((float) this.i) / this.g)));
            this.f = this.f < 0 ? 0 : this.f;
            if (this.j != null) {
                this.j.setAlpha(this.f);
                this.j.draw(canvas);
            }
            if (this.k != null) {
                int i = (255 - this.f) + 128;
                if (i > 255) {
                    i = 255;
                }
                this.k.setAlpha(i);
                this.k.draw(canvas);
            }
            if (((float) this.i) >= this.g) {
                this.e = false;
                this.f = 0;
                this.l = false;
                if (this.j != null) {
                    this.j.setAlpha(255);
                }
                if (this.k != null) {
                    this.k.setAlpha(255);
                }
            }
            invalidateSelf();
            return;
        }
        super.draw(canvas);
    }

    public q() {
        this(null);
    }

    public final void a(int[] iArr, Drawable drawable) {
        if (drawable != null) {
            ab abVar = this.c;
            int i = abVar.f;
            if (i >= abVar.e.length) {
                abVar.a(i, i + 10);
            }
            drawable.setVisible(false, true);
            drawable.setCallback(abVar.b);
            abVar.e[i] = drawable;
            abVar.f++;
            abVar.d |= drawable.getChangingConfigurations();
            abVar.o = false;
            abVar.q = false;
            abVar.h = null;
            abVar.j = false;
            abVar.a[i] = iArr;
            onStateChange(getState());
        }
    }

    public final boolean isStateful() {
        return true;
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.j != null) {
            this.j.setBounds(rect);
        }
        if (this.k != null) {
            this.k.setBounds(rect);
        }
    }

    protected final boolean onStateChange(int[] iArr) {
        int a = p.a(this.c, iArr);
        if (a < 0) {
            a = p.a(this.c, StateSet.WILD_CARD);
        }
        if (a(a)) {
            return true;
        }
        return super.onStateChange(iArr);
    }

    public final Drawable mutate() {
        if (!this.n && super.mutate() == this) {
            int[][] a = this.c.a;
            int length = a.length;
            this.c.a = new int[length][];
            for (int i = 0; i < length; i++) {
                if (a[i] != null) {
                    this.c.a[i] = (int[]) a[i].clone();
                }
            }
            this.n = true;
        }
        return this;
    }

    private q(p pVar) {
        this.g = 256.0f;
        this.b = true;
        ab pVar2 = new p(pVar, this);
        this.c = pVar2;
        this.d = pVar2;
        onStateChange(getState());
    }
}
