package com.ucpro.ui.widget.tablayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
final class p extends LinearLayout {
    int a = -1;
    float b;
    x c;
    final /* synthetic */ ProTabLayout d;
    private int e;
    private int f;
    private int g;
    private final Paint h;
    private int i = -1;
    private int j = -1;
    private RectF k = new RectF();

    p(ProTabLayout proTabLayout, Context context) {
        this.d = proTabLayout;
        super(context);
        setWillNotDraw(false);
        this.h = new Paint();
    }

    final void a(int i) {
        if (this.h.getColor() != i) {
            this.h.setColor(i);
            ViewCompat.d(this);
        }
    }

    final void b(int i) {
        if (this.e != i) {
            this.e = i;
            ViewCompat.d(this);
        }
    }

    final void c(int i) {
        if (this.f != i) {
            this.f = i;
            ViewCompat.d(this);
        }
    }

    final void d(int i) {
        if (this.g != i) {
            this.g = i;
            ViewCompat.d(this);
        }
    }

    protected final void onMeasure(int i, int i2) {
        Object obj = null;
        super.onMeasure(i, i2);
        if (MeasureSpec.getMode(i) == UCCore.VERIFY_POLICY_QUICK && this.d.t == 1 && this.d.s == 1) {
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (i3 < childCount) {
                int max;
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    max = Math.max(i4, childAt.getMeasuredWidth());
                } else {
                    max = i4;
                }
                i3++;
                i4 = max;
            }
            if (i4 > 0) {
                if (i4 * childCount <= getMeasuredWidth() - (this.d.b(16) * 2)) {
                    i3 = 0;
                    while (i3 < childCount) {
                        Object obj2;
                        LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                        if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                            obj2 = obj;
                        } else {
                            layoutParams.width = i4;
                            layoutParams.weight = 0.0f;
                            obj2 = 1;
                        }
                        i3++;
                        obj = obj2;
                    }
                } else {
                    this.d.s = 0;
                    this.d.a(false);
                    obj = 1;
                }
                if (obj != null) {
                    super.onMeasure(i, i2);
                }
            }
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.c == null || !this.c.a.b()) {
            a();
            return;
        }
        this.c.a.e();
        a(this.a, Math.round(((float) this.c.a.g()) * (IPictureView.DEFAULT_MIN_SCALE - this.c.a.f())));
    }

    final void a() {
        int i;
        int i2;
        View childAt = getChildAt(this.a);
        if (childAt == null || childAt.getWidth() <= 0) {
            i = -1;
            i2 = -1;
        } else {
            i = childAt.getLeft();
            i2 = childAt.getRight();
            if (this.b > 0.0f && this.a < getChildCount() - 1) {
                View childAt2 = getChildAt(this.a + 1);
                i = (int) ((((float) i) * (IPictureView.DEFAULT_MIN_SCALE - this.b)) + (this.b * ((float) childAt2.getLeft())));
                i2 = (int) ((((float) i2) * (IPictureView.DEFAULT_MIN_SCALE - this.b)) + (((float) childAt2.getRight()) * this.b));
            }
        }
        b(i, i2);
    }

    private void b(int i, int i2) {
        if (i != this.i || i2 != this.j) {
            this.i = i;
            this.j = i2;
            ViewCompat.d(this);
        }
    }

    final void a(int i, int i2) {
        if (this.c != null && this.c.a.b()) {
            this.c.a.e();
        }
        Object obj = ViewCompat.h(this) == 1 ? 1 : null;
        View childAt = getChildAt(i);
        if (childAt == null) {
            a();
            return;
        }
        int i3;
        int i4;
        int left = childAt.getLeft();
        int right = childAt.getRight();
        if (Math.abs(i - this.a) <= 1) {
            i3 = this.i;
            i4 = this.j;
        } else {
            int a = this.d.b(24);
            if (i < this.a) {
                if (obj == null) {
                    i4 = right + a;
                    i3 = i4;
                }
            } else if (obj != null) {
                i4 = right + a;
                i3 = i4;
            }
            i4 = left - a;
            i3 = i4;
        }
        if (i3 != left || i4 != right) {
            x a2 = z.a();
            this.c = a2;
            a2.a(o.b);
            a2.a(i2);
            a2.a.d();
            a2.a(new k(this, i3, left, i4, right));
            a2.a.a(new h(a2, new y(this, i)));
            a2.a.a();
        }
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.i >= 0 && this.j > this.i) {
            int i = ((this.j - this.i) - this.f) / 2;
            this.k.left = (float) (this.i + i);
            this.k.top = (float) (getHeight() - this.e);
            this.k.right = (float) (this.j - i);
            this.k.bottom = (float) getHeight();
            canvas.drawRoundRect(this.k, (float) this.g, (float) this.g, this.h);
        }
    }
}
