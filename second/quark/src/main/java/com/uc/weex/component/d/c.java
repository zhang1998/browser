package com.uc.weex.component.d;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import com.taobao.weex.utils.WXViewUtils;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class c extends View {
    private ValueAnimator a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private Paint h;
    private int i;
    private int j;
    private int k = 0;
    private int l = -11358745;
    private int m;
    private boolean n;

    public c(Context context) {
        super(context);
        setBackgroundColor(0);
        this.b = WXViewUtils.f(7.5f);
        this.c = WXViewUtils.f(6.0f);
        this.h = new Paint();
        this.h.setAntiAlias(true);
        this.a = new ValueAnimator();
        this.a.setFloatValues(new float[]{0.66f, IPictureView.DEFAULT_MIN_SCALE, 0.66f});
        this.a.setDuration(1000);
        this.a.setRepeatCount(-1);
        this.a.addUpdateListener(new b(this));
    }

    public final void a() {
        this.m = (((int) (((float) Color.alpha(this.l)) * 0.6f)) << 24) | (this.l & 16777215);
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        this.d = (width - this.b) - (this.c / 2);
        this.e = height;
        this.f = (width + this.b) + (this.c / 2);
        this.g = height;
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.k);
        this.h.setColor(this.l);
        canvas.drawCircle((float) this.d, (float) this.e, (float) this.i, this.h);
        this.h.setColor(this.m);
        canvas.drawCircle((float) this.f, (float) this.g, (float) this.j, this.h);
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.n && this.a != null) {
            this.n = true;
            a();
            this.a.start();
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            this.a.cancel();
            this.n = false;
        }
        this.a = null;
    }

    final void setCircleColor(int i) {
        this.l = i;
    }
}
