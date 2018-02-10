package com.ucpro.feature.video.player.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import com.uc.framework.resources.aa;
import com.uc.framework.resources.b;
import com.uc.framework.resources.f;
import com.uc.framework.resources.r;
import com.uc.framework.resources.y;

/* compiled from: ProGuard */
public final class t extends View {
    Paint a = new Paint();
    Paint b;
    float c = -1.0f;
    String d;
    String e;
    private String f = "";
    private Rect g;
    private Bitmap h;
    private float i = 10.0f;
    private Matrix j;
    private Paint k;

    public t(Context context) {
        super(context);
        this.a.setColor(-16777216);
        this.a.setTextSize(15.0f);
        this.a.setAntiAlias(true);
        this.g = new Rect();
        this.b = new Paint();
        this.b.setColor(-16777216);
        this.b.setTextSize(15.0f);
        this.b.setAntiAlias(true);
        this.j = new Matrix();
        this.k = new Paint();
        f fVar = r.a().a;
        String str = "video_loading.png";
        if (y.b()) {
            y.a().a(str);
        }
        long currentTimeMillis = System.currentTimeMillis();
        aa aaVar = new aa(com.uc.framework.resources.t.c);
        Context context2 = com.uc.framework.resources.t.a;
        boolean b = aa.b(str);
        Bitmap a = aa.a(context2, str, b ? aaVar.a : null);
        if (a == null && b && !b.a(aaVar.a)) {
            a = aa.a(context2, str, "theme/default/");
        }
        if (a == null) {
            Log.w("Theme", "getBitmap is null!! name: " + str);
        }
        fVar.f = (System.currentTimeMillis() - currentTimeMillis) + fVar.f;
        if (y.b()) {
            y.a().b(str);
        }
        this.h = a;
    }

    public final void setLoadingBitmap(Bitmap bitmap) {
        this.h = bitmap;
    }

    public final void setSpeed(int i) {
        this.i = (float) i;
    }

    public final String getText() {
        return this.f;
    }

    public final void setText(String str) {
        if (str == null) {
            throw new NullPointerException("text is null");
        }
        this.f = str;
        postInvalidate();
    }

    public final int getTextColor() {
        return this.a.getColor();
    }

    public final void setTextColor(int i) {
        this.a.setColor(i);
        this.b.setColor(i);
        postInvalidate();
    }

    public final float getTextSize() {
        return this.a.getTextSize();
    }

    public final void setTextSize(float f) {
        this.a.setTextSize(f);
        postInvalidate();
    }

    protected final void onDraw(Canvas canvas) {
        if (getVisibility() == 0) {
            int width = this.h.getWidth();
            int height = this.h.getHeight();
            int width2 = getWidth();
            int height2 = getHeight();
            float f = ((float) width2) / ((float) width);
            float f2 = ((float) height2) / ((float) height);
            this.j.reset();
            this.j.postScale(f, f2, 0.0f, 0.0f);
            this.i = (this.i + 10.0f) % 360.0f;
            this.j.postRotate(this.i, (float) (width2 / 2), (float) (height2 / 2));
            canvas.drawBitmap(this.h, this.j, this.k);
            if (this.c <= 0.0f) {
                this.a.getTextBounds(this.f, 0, this.f.length(), this.g);
                canvas.drawText(this.f, (float) (getWidth() >> (1 - this.g.centerX())), (float) (getHeight() >> (1 - this.g.centerY())), this.a);
            } else {
                this.a.getTextBounds(this.d, 0, this.d.length(), this.g);
                width = this.g.centerX();
                height = this.g.centerY();
                width2 = this.g.width();
                this.b.getTextBounds(this.e, 0, this.e.length(), this.g);
                height2 = this.g.centerX();
                width = (getWidth() / 2) - (width + height2);
                height = (getHeight() / 2) - Math.min(height, this.g.centerY());
                canvas.drawText(this.d, (float) width, (float) height, this.a);
                canvas.drawText(this.e, ((float) (width + width2)) + (this.a.getTextSize() / 8.0f), (float) height, this.b);
            }
            postInvalidate();
        }
    }
}
