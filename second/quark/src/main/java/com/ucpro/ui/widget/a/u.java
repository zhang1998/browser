package com.ucpro.ui.widget.a;

import android.graphics.Rect;

/* compiled from: ProGuard */
final class u implements Runnable {
    final /* synthetic */ z a;
    private int b;
    private int c;

    private u(z zVar) {
        this.a = zVar;
        this.b = 0;
    }

    public final void a(int i, int i2) {
        if (i == 1) {
            this.c = Math.max(i2, 2);
        } else if (i == -1) {
            this.c = -Math.max(i2, 2);
        }
        this.b = i;
        this.a.l.a().post(this);
    }

    public final void a() {
        this.a.l.a().removeCallbacks(this);
    }

    public final void run() {
        int i;
        int i2 = -1;
        if (this.b == 1) {
            if (this.a.g.b(1)) {
                this.a.g.a(this.c);
            }
        } else if (this.b == -1 && this.a.g.b(-1)) {
            this.a.g.a(this.c);
        }
        if (this.a.e != null) {
            Rect bounds = this.a.e.getBounds();
            i2 = bounds.top;
            i = bounds.bottom;
        } else {
            a();
            i = -1;
        }
        int h = this.a.l.h();
        int height = this.a.l.a().getHeight();
        int i3 = this.a.l.i();
        int j = this.a.l.j();
        if (i2 <= 0 && h > 0) {
            ((v) this.a.d).a = 1;
            this.a.l.a().post(this);
        } else if (i >= height && h + i3 < j) {
            ((v) this.a.d).a = 0;
            this.a.l.a().post(this);
        }
    }
}
