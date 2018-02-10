package com.ui.edittext;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.SystemClock;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class s {
    int a;
    int b;
    long c;
    final /* synthetic */ TextView d;
    private final Path e = new Path();
    private final Paint f = new Paint(1);

    public s(TextView textView) {
        this.d = textView;
        this.f.setCompatibilityScaling(textView.getResources().getCompatibilityInfo().applicationScale);
        this.f.setStyle(Style.FILL);
    }

    public final void a(Canvas canvas, int i) {
        boolean z;
        if (this.d.h == null) {
            z = false;
        } else {
            int length = this.d.g.length();
            int min = Math.min(length, this.a);
            length = Math.min(length, this.b);
            this.e.reset();
            this.d.h.getSelectionPath(min, length, this.e);
            z = true;
        }
        if (z) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.c;
            if (uptimeMillis > 400) {
                z = false;
            } else {
                this.f.setColor((((int) ((IPictureView.DEFAULT_MIN_SCALE - (((float) uptimeMillis) / 400.0f)) * ((float) Color.alpha(this.d.aF)))) << 24) + (this.d.aF & 16777215));
                z = true;
            }
            if (z) {
                if (i != 0) {
                    canvas.translate(0.0f, (float) i);
                }
                canvas.drawPath(this.e, this.f);
                if (i != 0) {
                    canvas.translate(0.0f, (float) (-i));
                }
                a(true);
                return;
            }
        }
        a();
        a(false);
    }

    final void a(boolean z) {
        if (this.d.h != null) {
            synchronized (TextView.bo) {
                this.e.computeBounds(TextView.bo, false);
                int compoundPaddingLeft = this.d.getCompoundPaddingLeft();
                int extendedPaddingTop = this.d.getExtendedPaddingTop() + this.d.a(true);
                if (z) {
                    this.d.postInvalidateDelayed(16, ((int) TextView.bo.left) + compoundPaddingLeft, ((int) TextView.bo.top) + extendedPaddingTop, ((int) TextView.bo.right) + compoundPaddingLeft, extendedPaddingTop + ((int) TextView.bo.bottom));
                } else {
                    this.d.postInvalidate((int) TextView.bo.left, (int) TextView.bo.top, (int) TextView.bo.right, (int) TextView.bo.bottom);
                }
            }
        }
    }

    final void a() {
        this.d.j = null;
    }
}
