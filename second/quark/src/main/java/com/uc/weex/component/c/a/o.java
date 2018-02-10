package com.uc.weex.component.c.a;

import android.view.MotionEvent;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class o implements l {
    protected final float a = 2.0f;
    protected final float b = IPictureView.DEFAULT_MIN_SCALE;
    final n c;
    int d;
    final /* synthetic */ q e;

    public o(q qVar, float f, float f2) {
        this.e = qVar;
        this.c = qVar.a();
    }

    public final int a() {
        return this.d;
    }

    public final boolean a(MotionEvent motionEvent) {
        if (this.e.a.a != motionEvent.getPointerId(0)) {
            this.e.a(this.e.e);
        } else {
            View a = this.e.b.a();
            if (this.c.a(a, motionEvent)) {
                float f;
                float f2 = this.c.b / (this.c.c == this.e.a.c ? this.a : this.b);
                if (this.c.b > 0.0f) {
                    if (this.e.c() - this.e.k < this.e.i) {
                        f = ((this.c.a + f2) - this.e.k) - this.e.i;
                        if (f > 0.0f) {
                            f2 -= f;
                        }
                    }
                }
                f = this.c.a + f2;
                if ((!this.e.a.c || this.c.c || f > this.e.a.b) && (this.e.a.c || !this.c.c || f < this.e.a.b)) {
                    if (a.getParent() != null) {
                        a.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    long eventTime = motionEvent.getEventTime() - motionEvent.getHistoricalEventTime(0);
                    if (eventTime > 0) {
                        this.e.j = f2 / ((float) eventTime);
                    }
                    this.e.a(a, f);
                    this.e.h.a(f, -f2, this.e.b.b());
                } else {
                    this.e.a(a, this.e.a.b, motionEvent);
                    this.e.h.a(0.0f, 0.0f, this.e.b.b());
                    this.e.a(this.e.c);
                }
            }
        }
        return true;
    }

    public final boolean b() {
        this.e.a(this.e.e);
        return false;
    }

    public final void a(l lVar) {
        this.d = this.e.a.c ? 1 : 2;
        this.e.g.a(lVar.a(), this.d, this.e.c() - this.e.k);
    }
}
