package com.ucpro.feature.inputenhance;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.FrameLayout.LayoutParams;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.system.b;
import com.ucweb.common.util.f;
import com.ucweb.common.util.h.a;

/* compiled from: ProGuard */
public class SliderView extends View {
    j a;
    boolean b;
    private int c;
    private RectF d;
    private Rect e;
    private RectF f;
    private Drawable g;
    private Drawable h;
    private Rect i;
    private int j;
    private int k;
    private Paint l;
    private int m;
    private int n;
    private k o;
    private int p;
    private a q;
    private a r;
    private a s;
    private long t;
    private long u;
    private boolean v;

    public SliderView(Context context) {
        this(context, null);
    }

    public SliderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 0;
        this.o = k.IDLE;
        this.b = false;
        this.v = true;
        this.j = (int) (com.ucweb.common.util.a.a.a(getContext(), 27.0f) / 2.0f);
        this.d = new RectF();
        this.e = new Rect();
        this.f = new RectF();
        this.i = new Rect();
        this.l = new Paint();
        this.l.setAntiAlias(true);
        this.l.setDither(true);
        this.l.setStyle(Style.FILL);
        a();
        this.c = (int) (com.ucweb.common.util.a.a.a(getContext(), 10.0f) / 2.0f);
        this.n = (int) (((double) b.a.f()) * 0.01d);
        if (this.n < 10) {
            this.n = 10;
        }
        this.q = new n(this);
        this.r = new r(this);
        this.s = new an(this);
    }

    public final void a() {
        this.g = com.ucpro.ui.c.a.a("active_slide_indicator.png");
        this.h = com.ucpro.ui.c.a.a("not_active_slide_indicator.png");
        if (this.b) {
            this.l.setColor(com.ucpro.ui.c.a.c("input_enhance_slide_enable_color"));
        } else {
            this.l.setColor(com.ucpro.ui.c.a.c("input_enhance_slide_not_enable_color"));
        }
    }

    private void a(k kVar) {
        if (this.o == kVar) {
            new StringBuilder("current state is already ").append(kVar).append(" no need switch");
            return;
        }
        if (this.o == k.HITED && kVar == k.SlIDE) {
            this.t = System.currentTimeMillis();
            removeCallbacks(this.s);
            if (this.a != null) {
                this.a.a(false);
            }
        } else if (this.o == k.SlIDE && kVar == k.IDLE) {
            if (this.a != null) {
                this.a.b(false);
            }
            b();
        } else if (this.o == k.HITED && kVar == k.LONG_SLIDE) {
            this.u = System.currentTimeMillis();
            if (this.a != null) {
                f.a(getContext());
                this.a.b(-1);
                this.a.a(true);
            }
        } else if (this.o == k.IDLE && kVar == k.HITED) {
            removeCallbacks(this.s);
            postDelayed(this.s, (long) ViewConfiguration.getLongPressTimeout());
            if (this.a != null) {
                this.a.clearFocus();
            }
        } else if (this.o == k.LONG_SLIDE && kVar == k.IDLE) {
            if (this.a != null) {
                this.a.b(true);
            }
            b();
        } else if (this.o == k.HITED && kVar == k.IDLE) {
            removeCallbacks(this.s);
            b();
        } else {
            removeCallbacks(this.s);
            b();
        }
        this.o = kVar;
    }

    public void setSlideViewEnabled(boolean z) {
        if (z) {
            this.l.setColor(com.ucpro.ui.c.a.c("input_enhance_slide_enable_color"));
        } else {
            this.l.setColor(com.ucpro.ui.c.a.c("input_enhance_slide_not_enable_color"));
            if (this.o != k.IDLE) {
                a(k.IDLE);
            }
        }
        this.b = z;
        invalidate();
    }

    private void b(int i) {
        this.k = i;
        invalidate();
    }

    private int c(int i) {
        return i - ((b.a.f() - getWidth()) / 2);
    }

    public final void a(int i) {
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r6 = 1077936128; // 0x40400000 float:3.0 double:5.325712093E-315;
        r1 = 1;
        r0 = 0;
        r2 = r7.b;
        if (r2 != 0) goto L_0x000d;
    L_0x0008:
        r0 = super.onTouchEvent(r8);
    L_0x000c:
        return r0;
    L_0x000d:
        r2 = r8.getAction();
        switch(r2) {
            case 0: goto L_0x001f;
            case 1: goto L_0x00be;
            case 2: goto L_0x0059;
            case 3: goto L_0x00be;
            case 4: goto L_0x00be;
            default: goto L_0x0014;
        };
    L_0x0014:
        r2 = r0;
    L_0x0015:
        if (r2 != 0) goto L_0x001d;
    L_0x0017:
        r2 = super.onTouchEvent(r8);
        if (r2 == 0) goto L_0x000c;
    L_0x001d:
        r0 = r1;
        goto L_0x000c;
    L_0x001f:
        r2 = r8.getRawX();
        r2 = (int) r2;
        r3 = r7.c(r2);
        r4 = (float) r3;
        r5 = r7.getContext();
        r5 = com.ucweb.common.util.a.a.a(r5, r6);
        r4 = r4 + r5;
        r5 = r7.i;
        r5 = r5.left;
        r5 = (float) r5;
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 < 0) goto L_0x0014;
    L_0x003b:
        r3 = (float) r3;
        r4 = r7.getContext();
        r4 = com.ucweb.common.util.a.a.a(r4, r6);
        r3 = r3 - r4;
        r4 = r7.i;
        r4 = r4.right;
        r4 = (float) r4;
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r3 > 0) goto L_0x0014;
    L_0x004e:
        r7.m = r2;
        r7.p = r2;
        r2 = com.ucpro.feature.inputenhance.k.HITED;
        r7.a(r2);
    L_0x0057:
        r2 = r1;
        goto L_0x0015;
    L_0x0059:
        r2 = r8.getRawX();
        r2 = (int) r2;
        r3 = r7.o;
        r4 = com.ucpro.feature.inputenhance.k.HITED;
        if (r3 != r4) goto L_0x007f;
    L_0x0064:
        r3 = r7.m;
        r3 = r2 - r3;
        r3 = java.lang.Math.abs(r3);
        r4 = r7.n;
        r4 = r4 / 2;
        if (r3 <= r4) goto L_0x0014;
    L_0x0072:
        r3 = com.ucpro.feature.inputenhance.k.SlIDE;
        r7.a(r3);
        r7.b(r2);
        r7.e(r2);
        r2 = r1;
        goto L_0x0015;
    L_0x007f:
        r3 = r7.o;
        r4 = com.ucpro.feature.inputenhance.k.SlIDE;
        if (r3 != r4) goto L_0x008c;
    L_0x0085:
        r7.b(r2);
        r7.e(r2);
        goto L_0x0057;
    L_0x008c:
        r3 = r7.o;
        r4 = com.ucpro.feature.inputenhance.k.LONG_SLIDE;
        if (r3 != r4) goto L_0x00af;
    L_0x0092:
        r3 = r7.v;
        if (r3 == 0) goto L_0x00a6;
    L_0x0096:
        r3 = r7.m;
        r3 = r2 - r3;
        r3 = java.lang.Math.abs(r3);
        r4 = r7.n;
        r4 = r4 / 2;
        if (r3 <= r4) goto L_0x00a6;
    L_0x00a4:
        r7.v = r0;
    L_0x00a6:
        r7.b(r2);
        r7.d(r2);
        r2 = r0;
        goto L_0x0015;
    L_0x00af:
        r2 = new java.lang.StringBuilder;
        r3 = "current state is ";
        r2.<init>(r3);
        r3 = r7.o;
        r2.append(r3);
        r2 = r0;
        goto L_0x0015;
    L_0x00be:
        r2 = r7.q;
        r7.removeCallbacks(r2);
        r2 = r7.r;
        r7.removeCallbacks(r2);
        r2 = com.ucpro.feature.inputenhance.k.IDLE;
        r7.a(r2);
        r2 = r7.k;
        r3 = com.ucpro.base.system.b.a;
        r3 = r3.f();
        r3 = r3 / 2;
        if (r2 == r3) goto L_0x0057;
    L_0x00d9:
        r3 = 2;
        r3 = new int[r3];
        r3[r0] = r2;
        r2 = com.ucpro.base.system.b.a;
        r2 = r2.f();
        r2 = r2 / 2;
        r3[r1] = r2;
        r2 = android.animation.ValueAnimator.ofInt(r3);
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r2.setDuration(r4);
        r3 = new com.ucpro.ui.animation.a.a;
        r3.<init>();
        r2.setInterpolator(r3);
        r3 = new com.ucpro.feature.inputenhance.aj;
        r3.<init>(r7);
        r2.addUpdateListener(r3);
        r2.start();
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.inputenhance.SliderView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void d(int i) {
        removeCallbacks(this.r);
        if (i < ((int) com.ucweb.common.util.a.a.a(getContext(), 25.0f)) + this.j) {
            if (this.a != null) {
                this.a.b(1);
                this.r.f = Integer.valueOf((int) com.ucweb.common.util.a.a.a(getContext(), 15.0f));
                postDelayed(this.r, 90);
            }
            this.p = (int) com.ucweb.common.util.a.a.a(getContext(), 25.0f);
        } else if (i > (getExpandStateWidth() + ((int) com.ucweb.common.util.a.a.a(getContext(), 5.0f))) - this.j) {
            if (this.a != null) {
                this.a.b(0);
                this.r.f = Integer.valueOf(getWidth() + ((int) com.ucweb.common.util.a.a.a(getContext(), 15.0f)));
                postDelayed(this.r, 90);
            }
            this.p = getWidth() + ((int) com.ucweb.common.util.a.a.a(getContext(), 5.0f));
        } else if (i - this.p > this.n / 2 && i < (getExpandStateWidth() + ((int) com.ucweb.common.util.a.a.a(getContext(), 5.0f))) - this.j) {
            if (this.a != null) {
                this.a.b(0);
            }
            this.p = i;
        } else if (i - this.p < (-this.n) / 2 && i > this.j + ((int) com.ucweb.common.util.a.a.a(getContext(), 25.0f))) {
            if (this.a != null) {
                this.a.b(1);
            }
            this.p = i;
        }
    }

    private void e(int i) {
        removeCallbacks(this.q);
        if (i - this.p > this.n / 2 && i < (getExpandStateWidth() + ((int) com.ucweb.common.util.a.a.a(getContext(), 5.0f))) - this.j) {
            if (this.a != null) {
                this.a.a(0);
            }
            this.p = i;
        } else if (i - this.p < (-this.n) / 2 && i > this.j + ((int) com.ucweb.common.util.a.a.a(getContext(), 25.0f))) {
            if (this.a != null) {
                this.a.a(1);
            }
            this.p = i;
        } else if (i < ((int) com.ucweb.common.util.a.a.a(getContext(), 25.0f)) + this.j) {
            if (this.a != null) {
                this.a.a(1);
                this.q.f = Integer.valueOf((int) com.ucweb.common.util.a.a.a(getContext(), 15.0f));
                postDelayed(this.q, 90);
            }
            this.p = (int) com.ucweb.common.util.a.a.a(getContext(), 25.0f);
        } else if (i > (getExpandStateWidth() + ((int) com.ucweb.common.util.a.a.a(getContext(), 5.0f))) - this.j) {
            if (this.a != null) {
                this.a.a(0);
                this.q.f = Integer.valueOf(getWidth() + ((int) com.ucweb.common.util.a.a.a(getContext(), 15.0f)));
                postDelayed(this.q, 90);
            }
            this.p = getWidth() + ((int) com.ucweb.common.util.a.a.a(getContext(), 5.0f));
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.d.set(0.0f, (float) ((getHeight() / 2) - this.c), (float) (this.c * 2), (float) ((getHeight() / 2) + this.c));
        canvas.drawArc(this.d, 90.0f, 180.0f, false, this.l);
        this.e.set(this.c, (getHeight() / 2) - this.c, getWidth() - this.c, (getHeight() / 2) + this.c);
        canvas.drawRect(this.e, this.l);
        this.f.set((float) (getWidth() - (this.c * 2)), (float) ((getHeight() / 2) - this.c), (float) getWidth(), (float) ((getHeight() / 2) + this.c));
        canvas.drawArc(this.f, -90.0f, 180.0f, false, this.l);
        if (this.i.isEmpty() || this.k == 0) {
            this.i.set((getWidth() / 2) - this.j, (getHeight() / 2) - this.j, (getWidth() / 2) + this.j, (getHeight() / 2) + this.j);
        } else {
            int c = c(this.k);
            if (c <= this.j) {
                c = this.j - ((int) com.ucweb.common.util.a.a.a(getContext(), (float) IPictureView.DEFAULT_MIN_SCALE));
            }
            if (c >= getWidth() - this.j) {
                c = (getWidth() - this.j) + ((int) com.ucweb.common.util.a.a.a(getContext(), (float) IPictureView.DEFAULT_MIN_SCALE));
            }
            this.i.set(c - this.j, (getHeight() / 2) - this.j, c + this.j, (getHeight() / 2) + this.j);
        }
        if (this.b) {
            this.g.setBounds(this.i);
            this.g.draw(canvas);
            return;
        }
        this.h.setBounds(this.i);
        this.h.draw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != UCCore.VERIFY_POLICY_QUICK) {
            size = (int) com.ucweb.common.util.a.a.a(getContext(), 44.0f);
        }
        if (mode2 != UCCore.VERIFY_POLICY_QUICK) {
            size2 = (int) com.ucweb.common.util.a.a.a(getContext(), 27.0f);
        }
        setMeasuredDimension(size, size2);
    }

    public final void b() {
        this.p = 0;
        this.o = k.IDLE;
        this.k = 0;
        this.t = 0;
        this.u = 0;
        this.v = true;
    }

    private int getExpandStateWidth() {
        return b.a.f() - ((int) com.ucweb.common.util.a.a.a(getContext(), 15.0f));
    }
}
