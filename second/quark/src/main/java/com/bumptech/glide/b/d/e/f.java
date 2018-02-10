package com.bumptech.glide.b.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;
import com.bumptech.glide.b.b.a.g;
import com.bumptech.glide.b.p;
import com.bumptech.glide.c;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.util.j;
import java.nio.ByteBuffer;

/* compiled from: ProGuard */
public class f extends Drawable implements Animatable, k {
    final e a;
    boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private boolean h;
    private Paint i;
    private Rect j;

    public f(Context context, GifDecoder gifDecoder, g gVar, p<Bitmap> pVar, int i, int i2, Bitmap bitmap) {
        this(new e(gVar, new n(c.a(context), gifDecoder, i, i2, (p) pVar, bitmap)));
    }

    f(e eVar) {
        this.e = true;
        this.g = -1;
        this.a = (e) j.a((Object) eVar, "Argument must not be null");
    }

    public final Bitmap a() {
        return this.a.b.j;
    }

    public final ByteBuffer b() {
        return this.a.b.a.a().asReadOnlyBuffer();
    }

    public void start() {
        this.d = true;
        this.f = 0;
        if (this.e) {
            d();
        }
    }

    public void stop() {
        this.d = false;
        e();
    }

    private void d() {
        j.a(!this.b, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.a.b.a() != 1) {
            if (!this.c) {
                this.c = true;
                n nVar = this.a.b;
                if (nVar.h) {
                    throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
                }
                boolean isEmpty = nVar.c.isEmpty();
                if (nVar.c.contains(this)) {
                    throw new IllegalStateException("Cannot subscribe twice in a row");
                }
                nVar.c.add(this);
                if (isEmpty && !nVar.e) {
                    nVar.e = true;
                    nVar.h = false;
                    nVar.c();
                }
            } else {
                return;
            }
        }
        invalidateSelf();
    }

    private void e() {
        this.c = false;
        n nVar = this.a.b;
        nVar.c.remove(this);
        if (nVar.c.isEmpty()) {
            nVar.e = false;
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        j.a(!this.b, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.e = z;
        if (!z) {
            e();
        } else if (this.d) {
            d();
        }
        return super.setVisible(z, z2);
    }

    public int getIntrinsicWidth() {
        return this.a.b.b().getWidth();
    }

    public int getIntrinsicHeight() {
        return this.a.b.b().getHeight();
    }

    public boolean isRunning() {
        return this.c;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.h = true;
    }

    public void draw(Canvas canvas) {
        if (!this.b) {
            if (this.h) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), f());
                this.h = false;
            }
            canvas.drawBitmap(this.a.b.b(), null, f(), g());
        }
    }

    public void setAlpha(int i) {
        g().setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        g().setColorFilter(colorFilter);
    }

    private Rect f() {
        if (this.j == null) {
            this.j = new Rect();
        }
        return this.j;
    }

    private Paint g() {
        if (this.i == null) {
            this.i = new Paint(2);
        }
        return this.i;
    }

    public int getOpacity() {
        return -2;
    }

    public final void c() {
        if (getCallback() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        n nVar = this.a.b;
        if ((nVar.g != null ? nVar.g.a : -1) == this.a.b.a() - 1) {
            this.f++;
        }
        if (this.g != -1 && this.f >= this.g) {
            stop();
        }
    }

    public ConstantState getConstantState() {
        return this.a;
    }
}
