package com.ucpro.feature.t;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.SparseArray;
import android.view.View;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.util.b;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class c implements n {
    SparseArray<Bitmap> a = new SparseArray(15);
    int b;
    int c;
    private final m d;

    public c(m mVar) {
        this.d = mVar;
    }

    public final Bitmap a(int i, boolean z) {
        System.currentTimeMillis();
        Bitmap bitmap = (Bitmap) this.a.get(i);
        if (bitmap == null) {
            Bitmap a = b.a(this.b, this.c, Config.ARGB_8888);
            if (!a(i, a, false)) {
                return bitmap;
            }
            this.a.put(i, a);
            return a;
        } else if (!z) {
            return bitmap;
        } else {
            a(i, bitmap, false);
            return bitmap;
        }
    }

    public final Bitmap a(int i) {
        System.currentTimeMillis();
        Bitmap bitmap = null;
        g d = this.d.d(i);
        if (d != null) {
            bitmap = b.a(d.getWidth(), d.getHeight(), Config.RGB_565);
        }
        a(i, bitmap, true);
        return bitmap;
    }

    private boolean a(int i, Bitmap bitmap, boolean z) {
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        g d = this.d.d(i);
        if (d == null) {
            return false;
        }
        if (!(d == null || bitmap == null)) {
            Canvas canvas;
            Bitmap bitmap2 = null;
            if (z) {
                canvas = new Canvas(bitmap);
            } else {
                bitmap2 = b.a(bitmap);
                if (bitmap2 != null) {
                    canvas = new Canvas(bitmap2);
                }
            }
            int width = d.getWidth();
            float width2 = ((float) bitmap.getWidth()) / ((float) width);
            if (width2 != IPictureView.DEFAULT_MIN_SCALE) {
                canvas.translate((float) ((bitmap.getWidth() - width) / 2), 0.0f);
                canvas.scale(width2, width2, (float) (width / 2), 0.0f);
            }
            View f = this.d.f();
            if (f != null) {
                canvas.save();
                f.draw(canvas);
                canvas.restore();
            }
            d.draw(canvas);
            if (!(z || bitmap2 == null)) {
                canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setShader(new BitmapShader(bitmap2, TileMode.CLAMP, TileMode.CLAMP));
                RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
                int c = a.c((int) R.dimen.multi_window_cardview2_corner_radius);
                canvas.drawRoundRect(rectF, (float) c, (float) c, paint);
                bitmap2.recycle();
            }
        }
        return true;
    }
}
