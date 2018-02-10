package com.ucpro.feature.video.player.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.ucpro.feature.video.player.a.j;
import com.ucpro.feature.video.player.e;
import com.ucpro.feature.video.player.e.a;
import com.ucpro.feature.video.player.p;

@SuppressLint({"ViewConstructor"})
/* compiled from: ProGuard */
public final class d extends View implements p {
    public com.ucpro.feature.video.player.a.d a = null;
    public j b = null;
    private int c = 0;
    private int d;
    private int e;
    private Paint f;
    private a g;

    public d(Context context, a aVar) {
        super(context);
        this.g = aVar;
        this.d = com.ucpro.ui.c.a.c("player_locking_status_progress_fill_color");
        this.e = com.ucpro.ui.c.a.c("player_locking_status_progress_bg_color");
        invalidate();
        this.g.f().a((p) this);
    }

    private void setPercent(int i) {
        this.c = i;
        invalidate();
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i = (this.c * width) / 1000;
        getPaint().setColor(this.d);
        canvas.drawRect(0.0f, 0.0f, (float) i, (float) height, getPaint());
        getPaint().setColor(this.e);
        canvas.drawRect((float) i, 0.0f, (float) width, (float) height, getPaint());
    }

    private Paint getPaint() {
        if (this.f == null) {
            this.f = new Paint();
        }
        return this.f;
    }

    public final void a(boolean z, boolean z2, boolean z3, int i, int i2, boolean z4) {
        if (!z4 && i > 0) {
            setPercent((int) ((((float) i2) / ((float) i)) * 1000.0f));
        }
    }

    public final void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.g.f().a((p) this);
            return;
        }
        e f = this.g.f();
        if (f.t.contains(this)) {
            f.t.remove(this);
        }
    }
}
