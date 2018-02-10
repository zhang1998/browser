package com.ucpro.feature.t.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

/* compiled from: ProGuard */
public final class b extends View {
    final /* synthetic */ k a;
    private Bitmap b = null;
    private Paint c = new Paint(1);
    private Rect d = new Rect();
    private RectF e = new RectF();
    private boolean f = false;

    public b(k kVar, Context context) {
        this.a = kVar;
        super(context);
    }

    protected final void onDraw(Canvas canvas) {
        if (this.b != null && !this.b.isRecycled() && this.f) {
            canvas.drawBitmap(this.b, this.d, this.e, this.c);
        }
    }

    public final void setDrawBitmap(Bitmap bitmap) {
        this.b = bitmap;
        a();
        invalidate();
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        a();
    }

    private void a() {
        if (!this.f && getMeasuredHeight() > 0 && this.b != null) {
            this.d.set(0, 0, this.b.getWidth(), this.b.getHeight());
            this.e.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) ((int) ((((float) this.b.getHeight()) / ((float) this.b.getWidth())) * ((float) getMeasuredWidth()))));
            this.f = true;
        }
    }
}
