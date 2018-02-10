package com.ucpro.ui.widget.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class l implements OnScrollListener {
    float a;
    final /* synthetic */ z b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g;

    final void a() {
        if (this.b.e != null && !this.b.t) {
            Rect bounds = this.b.e.getBounds();
            int h = this.b.l.h();
            int height = this.b.l.a().getHeight();
            int i = this.b.l.i();
            int j = this.b.l.j();
            int i2 = bounds.top;
            int i3 = bounds.bottom;
            int max = (int) Math.max(IPictureView.DEFAULT_MIN_SCALE, ((float) this.c) * this.a);
            if (VERSION.SDK_INT < 14) {
                if (i2 <= 0 && h > 0) {
                    ((v) this.b.d).a = 1;
                    if (this.b.u != null) {
                        this.b.u.a();
                        this.b.u = null;
                    }
                    this.b.u = new u(this.b);
                    this.b.u.a(-1, max);
                } else if (i3 >= height && h + i < j) {
                    ((v) this.b.d).a = 0;
                    if (this.b.u != null) {
                        this.b.u.a();
                        this.b.u = null;
                    }
                    this.b.u = new u(this.b);
                    this.b.u.a(1, max);
                } else if (this.b.u != null) {
                    this.b.u.a();
                    this.b.u = null;
                }
            } else if (i2 <= 0 && h > 0 && this.b.g.b(-1)) {
                ((v) this.b.d).a = 1;
                this.b.l;
            } else if (i3 < height || h + i >= j || !this.b.g.b(1)) {
                ((v) this.b.d).a = -1;
            } else {
                ((v) this.b.d).a = 0;
                this.b.l;
            }
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        long j = -1;
        this.f = i;
        this.g = i + i2;
        this.d = this.d == -1 ? this.f : this.d;
        this.e = this.e == -1 ? this.g : this.e;
        if (this.b.e != null) {
            this.b.o = this.b.b(this.b.f);
            if (this.b.o != null) {
                float top = (float) this.b.o.getTop();
                ac b = this.b.e;
                b.c += b.a - top;
                b.a = top;
                new StringBuilder("on scroll----------> mOriginalY is ").append(b.a).append(" and scroll distance is ").append(b.c);
            }
        }
        if (!this.b.t) {
            if (!(this.b.e == null || this.b.d == null || this.f >= this.d)) {
                int b2 = this.b.a(this.b.f);
                if (b2 != -1) {
                    long itemId = (b2 + -1) - this.b.l.e() >= 0 ? this.b.d.getItemId((b2 - 1) - this.b.l.e()) : -1;
                    View a = this.b.b(itemId);
                    if (a != null) {
                        x.a(z.a, "switch view position is " + ((b2 - 1) - this.b.l.e()));
                        this.b.a(a, itemId, (float) (-a.getHeight()));
                    }
                }
            }
            if (!(this.b.e == null || this.b.d == null || this.g <= this.e)) {
                int b3 = this.b.a(this.b.f);
                if (b3 != -1) {
                    ((v) this.b.d).a = 0;
                    if ((b3 + 1) - this.b.l.e() < this.b.d.getCount()) {
                        j = this.b.d.getItemId((b3 + 1) - this.b.l.e());
                    }
                    View a2 = this.b.b(j);
                    if (a2 != null) {
                        this.b.a(a2, j, (float) a2.getHeight());
                    }
                }
            }
        }
        this.d = this.f;
        this.e = this.g;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        x.a(z.a, "onscroll state change");
        if (VERSION.SDK_INT >= 14 && i == 0 && this.b.e != null) {
            a();
        }
    }
}
