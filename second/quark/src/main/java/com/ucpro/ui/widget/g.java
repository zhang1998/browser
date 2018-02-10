package com.ucpro.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.uc.util.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class g extends Drawable {
    private int a;
    private int b;
    private int c;
    private int d;
    private List<Bitmap> e = new ArrayList();
    private Bitmap f;
    private Rect g = new Rect();
    private RectF h = new RectF();
    private Paint i = new Paint();

    public g(Bitmap bitmap) throws Exception {
        this.i.setFilterBitmap(true);
        this.f = bitmap;
        this.a = bitmap.getWidth();
        this.b = bitmap.getHeight();
        this.c = a(bitmap);
        this.d = (this.b / this.c) + 1;
        int[] iArr = new int[(this.a * this.c)];
        for (int i = 0; i < this.d; i++) {
            int i2;
            if ((i + 1) * this.c < this.b) {
                i2 = this.c;
            } else {
                i2 = this.b - (this.c * i);
            }
            int i3 = this.a;
            Config config = bitmap.getConfig();
            if (config == null) {
                config = Config.ARGB_8888;
            }
            Bitmap a = b.a(i3, i2, config);
            if (a == null || a.isRecycled()) {
                a();
                throw new Exception("Get null native bitmap !");
            }
            bitmap.getPixels(iArr, 0, this.a, 0, i * this.c, this.a, i2);
            a.setPixels(iArr, 0, this.a, 0, 0, this.a, i2);
            this.e.add(a);
        }
    }

    private static int a(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        int i = 1024;
        while (((long) ((((bitmap.getByteCount() * i) / bitmap.getHeight()) / 1024) / 1024)) >= com.ucpro.base.system.b.a.s() && i > 128) {
            i /= 2;
        }
        return i;
    }

    public final void draw(Canvas canvas) {
        int i = 0;
        float f = 0.0f;
        while (i < this.d) {
            Bitmap bitmap = (Bitmap) this.e.get(i);
            this.g.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            float width = (float) getBounds().width();
            float width2 = ((((float) getBounds().width()) / ((float) bitmap.getWidth())) * ((float) bitmap.getHeight())) + f;
            if (i == this.d - 1) {
                width2 = (float) getBounds().height();
            }
            this.h.set(0.0f, f, width, width2);
            canvas.drawBitmap(bitmap, this.g, this.h, this.i);
            i++;
            f = width2;
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return -1;
    }

    public final int getIntrinsicHeight() {
        return this.b;
    }

    public final int getIntrinsicWidth() {
        return this.a;
    }

    private void a() {
        for (Bitmap bitmap : this.e) {
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }
}
