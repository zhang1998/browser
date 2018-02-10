package com.ucpro.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Shader.TileMode;
import android.widget.LinearLayout;
import com.uc.util.b;

/* compiled from: ProGuard */
public final class v extends LinearLayout {
    public ValueAnimator a;
    d b;
    public Path c;
    public int d = 0;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    Runnable j = new n(this);
    private Paint k;
    private Bitmap l;
    private float m;

    public v(Context context, d dVar, int i, int i2) {
        super(context);
        this.b = dVar;
        this.g = i;
        this.h = i2;
    }

    protected final void dispatchDraw(Canvas canvas) {
        Object obj;
        if (this.a == null || !this.a.isRunning()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            super.dispatchDraw(canvas);
        } else if (this.d == 1) {
            canvas.save();
            try {
                if (a(this.l)) {
                    this.c.reset();
                    this.c.addCircle((float) this.e, (float) this.f, this.m, Direction.CCW);
                    canvas.drawPath(this.c, this.k);
                }
            } catch (Throwable th) {
            }
            canvas.restore();
        } else {
            canvas.save();
            this.c.reset();
            this.c.addCircle((float) this.e, (float) this.f, this.m, Direction.CCW);
            try {
                canvas.clipPath(this.c);
            } catch (UnsupportedOperationException e) {
            }
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    public final void a() {
        try {
            if (this.k == null) {
                this.k = new Paint();
            }
            b();
            this.l = b.a(getWidth(), getHeight(), Config.ARGB_8888);
            if (this.l != null && this.l.getWidth() > 0) {
                super.dispatchDraw(new Canvas(this.l));
                this.k.setShader(new BitmapShader(this.l, TileMode.CLAMP, TileMode.CLAMP));
            }
        } catch (Throwable th) {
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.i) {
            a();
            this.i = false;
        }
    }

    private static boolean a(Bitmap bitmap) {
        return (bitmap == null || bitmap.isRecycled()) ? false : true;
    }

    protected final void b() {
        if (a(this.l)) {
            this.l.recycle();
            this.l = null;
        }
    }
}
