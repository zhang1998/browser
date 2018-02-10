package com.ucpro.feature.privacymode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Region.Op;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.base.system.b;

/* compiled from: ProGuard */
public final class a extends View {
    private final Path a = new Path();
    private int b = com.ucpro.ui.c.a.c("privacymode_circleface_external_bg");
    private int c;
    private int d;
    private int e;

    public a(Context context) {
        super(context);
        setLayerType(1, null);
        int c = b.a.c();
        this.c = ((int) (((float) c) * 0.85f)) / 2;
        this.d = c / 2;
        this.e = this.c + com.ucpro.ui.c.a.c((int) R.dimen.privacymode_circleface_margintop);
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.clipPath(this.a, Op.DIFFERENCE);
        canvas.drawColor(this.b);
        canvas.restore();
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.a.reset();
        this.a.addCircle((float) this.d, (float) this.e, (float) this.c, Direction.CCW);
    }

    public final int getRadius() {
        return this.c;
    }

    public final int getCircleX() {
        return this.d;
    }

    public final int getCircleY() {
        return this.e;
    }
}
