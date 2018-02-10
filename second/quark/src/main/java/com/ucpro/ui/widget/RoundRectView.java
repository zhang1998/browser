package com.ucpro.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: ProGuard */
public class RoundRectView extends View {
    private Paint a;
    private Xfermode b;
    private float[] c;
    private Bitmap d;
    private Rect e;
    private Rect f;
    private int g = -1;

    public RoundRectView(Context context) {
        super(context);
        a();
    }

    public RoundRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        this.a = new Paint();
        this.a.setColor(-1);
        this.a.setAntiAlias(true);
        this.b = new PorterDuffXfermode(Mode.SRC_IN);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f = new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    protected void onDraw(Canvas canvas) {
        if (this.d != null) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
            i iVar = new i(this.c, -1);
            iVar.setBounds(0, 0, getWidth(), getHeight());
            iVar.draw(canvas);
            this.a.setXfermode(this.b);
            canvas.drawBitmap(this.d, this.e, this.f, this.a);
            if (this.g != -1) {
                canvas.drawColor(this.g, Mode.SRC_ATOP);
            }
            this.a.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        }
    }

    public void setBorderRadius(int i) {
        this.c = new float[]{(float) i, (float) i, (float) i, (float) i, (float) i, (float) i, (float) i, (float) i};
    }

    public void setBorderRadius(float[] fArr) {
        this.c = fArr;
    }

    public void setSrcBitmap(Bitmap bitmap) {
        this.d = bitmap;
        this.e = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    public void setColorMask(int i) {
        this.g = i;
    }
}
