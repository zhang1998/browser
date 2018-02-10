package com.ui.edittext;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

/* compiled from: ProGuard */
abstract class aa extends View implements av {
    private int A = 0;
    protected Drawable a;
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected Drawable f;
    protected Drawable g;
    boolean h;
    protected int i;
    int j = 0;
    final /* synthetic */ TextView k;
    private final PopupWindow l;
    private int m;
    private int n;
    private float o;
    private int p;
    private float q;
    private float r;
    private float s;
    private float t;
    private int u;
    private int v;
    private int w = -1;
    private boolean x = true;
    private final long[] y = new long[5];
    private final int[] z = new int[5];

    protected abstract int a(int i, int i2, boolean z);

    public abstract void a(float f, float f2);

    protected abstract void a(int i);

    public abstract int d();

    public aa(TextView textView, Drawable drawable, Drawable drawable2) {
        this.k = textView;
        super(textView.mContext);
        this.l = new PopupWindow(textView.mContext, null, 16843464);
        this.l.setContentView(this);
        this.f = drawable;
        this.g = drawable2;
        a();
        int intrinsicHeight = this.a.getIntrinsicHeight();
        this.s = -0.3f * ((float) intrinsicHeight);
        this.t = ((float) intrinsicHeight) * 0.7f;
    }

    protected final void a() {
        boolean isRtlCharAt = this.k.h.isRtlCharAt(d());
        this.a = isRtlCharAt ? this.g : this.f;
        this.b = this.a.getIntrinsicWidth();
        this.c = this.a.getIntrinsicHeight();
        this.d = this.b * 2;
        this.e = (int) (((float) this.c) * 1.5f);
        this.i = a(this.b, this.d, isRtlCharAt);
    }

    private void b(int i) {
        this.A = (this.A + 1) % 5;
        this.z[this.A] = i;
        this.y[this.A] = SystemClock.uptimeMillis();
        this.j++;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.d, this.e);
    }

    private void g() {
        this.h = false;
        this.l.dismiss();
        f();
    }

    public final void c() {
        g();
        this.k.getPositionListener().a(this);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    protected final void a(int i, boolean z) {
        if (this.k.h == null) {
            this.k.G();
        } else if (i != this.w || z) {
            a(i);
            b(i);
            int lineForOffset = this.k.h.getLineForOffset(i);
            this.m = (int) (this.k.h.getPrimaryHorizontal(i) - ((float) this.i));
            this.n = this.k.h.getLineBottom(lineForOffset);
            this.m += this.k.z();
            this.n += this.k.A();
            this.w = i;
            this.x = true;
        }
    }

    public final void a(int i, int i2, boolean z, boolean z2) {
        a(d(), z2);
        if (z || this.x) {
            boolean z3;
            if (this.h) {
                if (!(i == this.u && i2 == this.v)) {
                    this.q += (float) (i - this.u);
                    this.r += (float) (i2 - this.v);
                    this.u = i;
                    this.v = i2;
                }
                e();
            }
            if (this.h) {
                z3 = true;
            } else if (this.k.o()) {
                z3 = false;
            } else {
                z3 = this.k.e(this.m, this.n);
            }
            if (z3) {
                int i3 = this.m + i;
                int i4 = this.n + i2;
                if (this.l.isShowing()) {
                    this.l.update(i3, i4, -1, -1);
                } else {
                    this.l.showAtLocation(this.k, 0, i3, i4);
                }
            } else if (this.l.isShowing()) {
                g();
            }
            this.x = false;
        }
    }

    protected void onDraw(Canvas canvas) {
        int i = (this.mRight - this.mLeft) / 2;
        this.a.setBounds(i - (this.a.getIntrinsicWidth() / 2), 0, i + (this.a.getIntrinsicWidth() / 2), this.a.getIntrinsicHeight());
        this.a.draw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int d;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.k.ab = rawX;
                this.k.ac = rawY;
                d = d();
                this.j = 0;
                b(d);
                this.q = rawX - ((float) this.m);
                this.r = rawY - ((float) this.n);
                ak m = this.k.getPositionListener();
                this.u = m.a;
                this.v = m.b;
                this.h = true;
                this.p = 0;
                this.o = rawX;
                break;
            case 1:
                long uptimeMillis = SystemClock.uptimeMillis();
                d = this.A;
                int min = Math.min(this.j, 5);
                int i = d;
                d = 0;
                while (d < min && uptimeMillis - this.y[i] < 150) {
                    d++;
                    i = ((this.A - d) + 5) % 5;
                }
                if (d > 0 && d < min && uptimeMillis - this.y[i] > 350) {
                    a(this.z[i], false);
                }
                this.h = false;
                u uVar;
                if (this.p != 0) {
                    if (this.p == 1 && this.k.ap != null) {
                        uVar = u.NONE;
                        if (this.k.aM) {
                            uVar = u.INSERTION_HANDLE_DRAG_OVER;
                        } else if (this.k.aO) {
                            uVar = u.SELECTION_HANDLE_DRAG_OVER;
                        }
                        this.k.ap.a(uVar);
                        break;
                    }
                } else if (this.k.ap != null) {
                    uVar = u.NONE;
                    if (this.k.aM) {
                        uVar = u.INSERTION_HANDLE_TAP;
                    } else if (this.k.aO) {
                        uVar = u.SELECTION_HANDLE_TAP;
                    }
                    this.k.ap.a(uVar);
                    break;
                }
                break;
            case 2:
                float f = this.r - ((float) this.v);
                float f2 = (rawY - ((float) this.n)) - ((float) this.v);
                if (f < this.t) {
                    f = Math.max(Math.min(f2, this.t), f);
                } else {
                    f = Math.min(Math.max(f2, this.t), f);
                }
                this.r = f + ((float) this.v);
                a((rawX - this.q) + ((float) this.i), (rawY - this.r) + this.s);
                if (this.p == 0 && Math.abs(rawX - this.o) > 8.0f) {
                    this.p = 1;
                    this.k.n();
                    break;
                }
            case 3:
                this.h = false;
                break;
        }
        return true;
    }

    void e() {
    }

    public void f() {
    }

    public void b() {
        if (!this.l.isShowing()) {
            this.k.getPositionListener().a(this, true);
            this.w = -1;
            a(d(), false);
        }
    }
}
