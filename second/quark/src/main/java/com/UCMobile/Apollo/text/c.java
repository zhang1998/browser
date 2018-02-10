package com.UCMobile.Apollo.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class c {
    int A;
    private final RectF B = new RectF();
    private final float C;
    private final float D;
    private final float E;
    private final float F;
    private final Paint G;
    final float a;
    final float b;
    final TextPaint c;
    CharSequence d;
    Alignment e;
    float f;
    int g;
    int h;
    float i;
    int j;
    float k;
    boolean l;
    int m;
    int n;
    int o;
    int p;
    int q;
    float r;
    float s;
    int t;
    int u;
    int v;
    int w;
    StaticLayout x;
    int y;
    int z;

    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.b = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.a = obtainStyledAttributes.getFloat(1, IPictureView.DEFAULT_MIN_SCALE);
        obtainStyledAttributes.recycle();
        int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.C = (float) round;
        this.D = (float) round;
        this.E = (float) round;
        this.F = (float) round;
        this.c = new TextPaint();
        this.c.setAntiAlias(true);
        this.c.setSubpixelText(true);
        this.G = new Paint();
        this.G.setAntiAlias(true);
        this.G.setStyle(Style.FILL);
    }

    final void a(Canvas canvas) {
        StaticLayout staticLayout = this.x;
        if (staticLayout != null) {
            int lineCount;
            int i;
            int save = canvas.save();
            canvas.translate((float) this.y, (float) this.z);
            if (Color.alpha(this.o) > 0) {
                this.G.setColor(this.o);
                canvas.drawRect((float) (-this.A), 0.0f, (float) (staticLayout.getWidth() + this.A), (float) staticLayout.getHeight(), this.G);
            }
            if (Color.alpha(this.n) > 0) {
                this.G.setColor(this.n);
                float lineTop = (float) staticLayout.getLineTop(0);
                lineCount = staticLayout.getLineCount();
                float f = lineTop;
                for (i = 0; i < lineCount; i++) {
                    this.B.left = staticLayout.getLineLeft(i) - ((float) this.A);
                    this.B.right = staticLayout.getLineRight(i) + ((float) this.A);
                    this.B.top = f;
                    this.B.bottom = (float) staticLayout.getLineBottom(i);
                    f = this.B.bottom;
                    canvas.drawRoundRect(this.B, this.C, this.C, this.G);
                }
            }
            if (this.q == 1) {
                this.c.setStrokeJoin(Join.ROUND);
                this.c.setStrokeWidth(this.D);
                this.c.setColor(this.p);
                this.c.setStyle(Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (this.q == 2) {
                this.c.setShadowLayer(this.E, this.F, this.F, this.p);
            } else if (this.q == 3 || this.q == 4) {
                lineCount = this.q == 3 ? 1 : 0;
                int i2 = lineCount != 0 ? -1 : this.p;
                if (lineCount != 0) {
                    i = this.p;
                } else {
                    i = -1;
                }
                float f2 = this.E / 2.0f;
                this.c.setColor(this.m);
                this.c.setStyle(Style.FILL);
                this.c.setShadowLayer(this.E, -f2, -f2, i2);
                staticLayout.draw(canvas);
                this.c.setShadowLayer(this.E, f2, f2, i);
            }
            this.c.setColor(this.m);
            this.c.setStyle(Style.FILL);
            staticLayout.draw(canvas);
            this.c.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }
}
