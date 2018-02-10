package com.ucpro.feature.video.player.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.MeasureSpec;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class ag extends View {
    private static final int u = a.c("player_label_text_color");
    private static final int v = a.c("player_battery_warging");
    private static final int w = a.c("player_batter_charging");
    Paint a = new Paint();
    Paint b = new Paint();
    Paint c = new Paint();
    private RectF d = new RectF();
    private int e;
    private int f = ((int) a.a((int) R.dimen.video_battery_head_height));
    private int g = ((int) a.a((int) R.dimen.video_battery_head_width));
    private int h = ((int) a.a((int) R.dimen.video_battery_body_height));
    private int i = ((int) a.a((int) R.dimen.video_battery_body_width));
    private int j = ((int) a.a((int) R.dimen.video_battery_stroke_width));
    private int k = this.j;
    private Bitmap l;
    private int m;
    private int n;
    private float o = 0.0f;
    private int p = u;
    private int q = v;
    private int r = w;
    private int s = am.c;
    private float t = 0.3f;

    public ag(Context context) {
        super(context);
        this.a.setAntiAlias(true);
        this.a.setStrokeWidth((float) this.j);
        this.a.setStyle(Style.STROKE);
        this.b.setAntiAlias(true);
        this.c.setAntiAlias(true);
        this.l = ((BitmapDrawable) a.a("new_video_top_bar_battery_charg.svg")).getBitmap();
        this.a.setColor(u);
        this.b.setColor(u);
    }

    public final void setProgress(float f) {
        this.o = f;
        if (f <= this.t) {
            this.c.setColor(this.q);
        } else {
            this.c.setColor(this.p);
        }
        invalidate();
    }

    public final void setLevel$1bf19a6c(int i) {
        this.s = i;
        switch (h.a[i - 1]) {
            case 1:
                setProgress(IPictureView.DEFAULT_MIN_SCALE);
                break;
            case 2:
                setProgress(this.t);
                break;
            case 3:
                setProgress(0.6f);
                break;
            case 4:
                this.o = 0.4f;
                this.c.setColor(this.r);
                break;
        }
        invalidate();
    }

    public final void setAlarmingProgress(int i) {
        this.t = (float) i;
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.m = (getMeasuredHeight() - this.h) / 2;
        this.n = ((getMeasuredWidth() - this.i) - this.g) / 2;
        if (this.m < 0) {
            this.m = 0;
        }
        if (this.n < 0) {
            this.n = 0;
        }
        this.d.left = (float) this.n;
        this.d.right = this.d.left + ((float) this.i);
        this.d.top = (float) this.m;
        this.d.bottom = this.d.top + ((float) this.h);
        canvas.drawRoundRect(this.d, (float) this.e, (float) this.e, this.a);
        RectF rectF = new RectF(this.d);
        this.d.left = (float) (this.i + this.n);
        this.d.right = this.d.left + ((float) this.g);
        this.d.top = (float) (((this.h - this.f) / 2) + this.m);
        this.d.bottom = this.d.top + ((float) this.f);
        canvas.drawRoundRect(this.d, (float) this.e, (float) this.e, this.b);
        int i = this.j + this.k;
        this.d.left = (float) (this.n + i);
        this.d.right = this.d.left + (this.o * ((float) (this.i - (i * 2))));
        this.d.top = (float) (this.m + i);
        this.d.bottom = (float) ((this.m + this.h) - i);
        canvas.drawRoundRect(this.d, (float) this.e, (float) this.e, this.c);
        if (this.s == am.d) {
            this.d.right = ((float) (this.i - (i * 2))) + this.d.left;
            canvas.drawBitmap(this.l, null, rectF, null);
        }
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }
}
