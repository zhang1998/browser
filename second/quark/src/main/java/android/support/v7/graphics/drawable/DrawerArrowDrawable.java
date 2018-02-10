package android.support.v7.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.q;
import com.uc.imagecodec.export.IPictureView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: ProGuard */
public final class DrawerArrowDrawable extends Drawable {
    private static final float b = ((float) Math.toRadians(45.0d));
    private final Paint a;
    private float c;
    private float d;
    private float e;
    private float f;
    private boolean g;
    private final Path h;
    private final int i;
    private boolean j;
    private float k;
    private float l;
    private int m;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface ArrowDirection {
    }

    public final void draw(Canvas canvas) {
        int i;
        Rect bounds = getBounds();
        switch (this.m) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 1;
                break;
            case 3:
                if (q.h(this) != 0) {
                    i = 0;
                    break;
                } else {
                    i = 1;
                    break;
                }
            default:
                if (q.h(this) != 1) {
                    i = 0;
                    break;
                } else {
                    i = 1;
                    break;
                }
        }
        float sqrt = (float) Math.sqrt((double) ((this.c * this.c) * 2.0f));
        float f = this.d;
        float f2 = f + ((sqrt - f) * this.k);
        sqrt = this.d;
        float f3 = sqrt + ((this.e - sqrt) * this.k);
        float round = (float) Math.round(0.0f + ((this.l - 0.0f) * this.k));
        float f4 = 0.0f + ((b - 0.0f) * this.k);
        if (i != 0) {
            f = 0.0f;
        } else {
            f = -180.0f;
        }
        if (i != 0) {
            sqrt = 180.0f;
        } else {
            sqrt = 0.0f;
        }
        sqrt = ((sqrt - f) * this.k) + f;
        f = (float) Math.round(((double) f2) * Math.cos((double) f4));
        f2 = (float) Math.round(((double) f2) * Math.sin((double) f4));
        this.h.rewind();
        f4 = this.f + this.a.getStrokeWidth();
        f4 += ((-this.l) - f4) * this.k;
        float f5 = (-f3) / 2.0f;
        this.h.moveTo(f5 + round, 0.0f);
        this.h.rLineTo(f3 - (round * 2.0f), 0.0f);
        this.h.moveTo(f5, f4);
        this.h.rLineTo(f, f2);
        this.h.moveTo(f5, -f4);
        this.h.rLineTo(f, -f2);
        this.h.close();
        canvas.save();
        f = this.a.getStrokeWidth();
        canvas.translate((float) bounds.centerX(), (float) (((double) ((float) ((((int) ((((float) bounds.height()) - (IPictureView.DEFAULT_MAX_SCALE * f)) - (this.f * 2.0f))) / 4) * 2))) + ((((double) f) * 1.5d) + ((double) this.f))));
        if (this.g) {
            canvas.rotate(((float) ((i ^ this.j) != 0 ? -1 : 1)) * sqrt);
        } else if (i != 0) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.h, this.a);
        canvas.restore();
    }

    public final void setAlpha(int i) {
        if (i != this.a.getAlpha()) {
            this.a.setAlpha(i);
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final int getIntrinsicHeight() {
        return this.i;
    }

    public final int getIntrinsicWidth() {
        return this.i;
    }

    public final int getOpacity() {
        return -3;
    }
}
