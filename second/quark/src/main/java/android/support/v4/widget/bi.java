package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;

/* compiled from: ProGuard */
final class bi extends OvalShape {
    final /* synthetic */ cb a;
    private RadialGradient b;
    private Paint c = new Paint();
    private int d;

    public bi(cb cbVar, int i, int i2) {
        this.a = cbVar;
        cbVar.b = i;
        this.d = i2;
        this.b = new RadialGradient((float) (this.d / 2), (float) (this.d / 2), (float) cbVar.b, new int[]{1023410176, 0}, null, TileMode.CLAMP);
        this.c.setShader(this.b);
    }

    public final void draw(Canvas canvas, Paint paint) {
        int width = this.a.getWidth();
        int height = this.a.getHeight();
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.d / 2) + this.a.b), this.c);
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.d / 2), paint);
    }
}
