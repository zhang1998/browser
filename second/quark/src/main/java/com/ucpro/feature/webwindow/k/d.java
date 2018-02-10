package com.ucpro.feature.webwindow.k;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class d extends View {
    Paint a = new Paint(1);
    float b = 0.0f;
    float c = -90.0f;
    boolean d = true;
    final /* synthetic */ a e;
    private int f = a.c((int) R.dimen.webpage_pull_refresh_loading_arc_width);
    private RectF g = null;

    public d(a aVar, Context context) {
        this.e = aVar;
        super(context);
        this.a.setStrokeWidth((float) this.f);
        this.a.setStyle(Style.STROKE);
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.g = new RectF((float) (this.f / 2), (float) (this.f / 2), (float) (getMeasuredWidth() - (this.f / 2)), (float) (getMeasuredHeight() - (this.f / 2)));
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.g != null) {
            canvas.drawArc(this.g, this.c, this.b, false, this.a);
        }
    }
}
