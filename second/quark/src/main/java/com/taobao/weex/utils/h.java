package com.taobao.weex.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.os.Build.VERSION;
import android.widget.ImageView.ScaleType;

/* compiled from: ProGuard */
public final class h extends PaintDrawable {
    public float[] a;
    public int b;
    public int c;

    public static Drawable a(@Nullable Drawable drawable, @NonNull ScaleType scaleType, int i, int i2, boolean z) {
        if (!z && i > 0 && i2 > 0) {
            h hVar;
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (bitmap != null) {
                    hVar = new h();
                    hVar.c = bitmap.getWidth();
                    hVar.b = bitmap.getHeight();
                    BitmapShader bitmapShader = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
                    a(scaleType, i, i2, hVar, bitmapShader);
                    hVar.getPaint().setShader(bitmapShader);
                    a(hVar);
                    return hVar;
                }
            }
            if (drawable instanceof h) {
                hVar = (h) drawable;
                if (hVar.getPaint() != null && (hVar.getPaint().getShader() instanceof BitmapShader)) {
                    a(scaleType, i, i2, hVar, (BitmapShader) hVar.getPaint().getShader());
                    a(hVar);
                    return hVar;
                }
            }
        }
        return drawable;
    }

    private static void a(@NonNull ScaleType scaleType, int i, int i2, h hVar, BitmapShader bitmapShader) {
        Matrix a = a(scaleType, i, i2, hVar.c, hVar.b);
        if (scaleType == ScaleType.FIT_CENTER) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) hVar.c, (float) hVar.b);
            RectF rectF2 = new RectF();
            a.mapRect(rectF2, rectF);
            i = (int) rectF2.width();
            i2 = (int) rectF2.height();
            a = a(scaleType, i, i2, hVar.c, hVar.b);
        }
        hVar.setIntrinsicWidth(i);
        hVar.setIntrinsicHeight(i2);
        bitmapShader.setLocalMatrix(a);
    }

    @NonNull
    private static Matrix a(@NonNull ScaleType scaleType, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        if (i3 * i2 > i4 * i) {
            f = ((float) i2) / ((float) i4);
            f2 = f;
            f = (((float) i) - (((float) i3) * f)) * 0.5f;
            f3 = 0.0f;
        } else {
            f = ((float) i) / ((float) i3);
            f3 = (((float) i2) - (((float) i4) * f)) * 0.5f;
            f2 = f;
            f = 0.0f;
        }
        Matrix matrix = new Matrix();
        if (scaleType == ScaleType.FIT_XY) {
            matrix.setScale(((float) i) / ((float) i3), ((float) i2) / ((float) i4));
        } else if (scaleType == ScaleType.FIT_CENTER) {
            matrix.setRectToRect(new RectF(0.0f, 0.0f, (float) i3, (float) i4), new RectF(0.0f, 0.0f, (float) i, (float) i2), ScaleToFit.CENTER);
        } else if (scaleType == ScaleType.CENTER_CROP) {
            matrix.setScale(f2, f2);
            matrix.postTranslate(f + 0.5f, f3 + 0.5f);
        }
        return matrix;
    }

    private h() {
    }

    public final void setCornerRadii(float[] fArr) {
        this.a = fArr;
        if (VERSION.SDK_INT <= 16) {
            if (fArr != null) {
                setShape(new g(this, fArr));
            } else if (getShape() != null) {
                setShape(null);
            }
            invalidateSelf();
            return;
        }
        super.setCornerRadii(fArr);
    }

    private static void a(h hVar) {
        if (VERSION.SDK_INT <= 16) {
            Rect rect = new Rect();
            if (!hVar.getPadding(rect)) {
                hVar.setPadding(rect);
            }
        }
    }
}
