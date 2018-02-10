package com.taobao.weex.ui.view.refresh.circlebar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;

/* compiled from: ProGuard */
final class a extends OvalShape {
    final /* synthetic */ CircleProgressBar a;
    private RadialGradient b;
    private int c;
    private Paint d = new Paint();
    private int e;

    public a(CircleProgressBar circleProgressBar, int i, int i2) {
        this.a = circleProgressBar;
        this.c = i;
        this.e = i2;
        this.b = new RadialGradient((float) (this.e / 2), (float) (this.e / 2), (float) this.c, new int[]{1023410176, 0}, null, TileMode.CLAMP);
        this.d.setShader(this.b);
    }

    public final void draw(Canvas canvas, Paint paint) {
        int width = this.a.getWidth();
        int height = this.a.getHeight();
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.e / 2) + this.c), this.d);
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.e / 2), paint);
    }
}
