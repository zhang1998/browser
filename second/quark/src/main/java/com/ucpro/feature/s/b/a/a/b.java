package com.ucpro.feature.s.b.a.a;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.ucpro.feature.s.b.a.e;

/* compiled from: ProGuard */
public final class b implements c {
    private final e a;
    private VelocityTracker b = VelocityTracker.obtain();
    private final int c;
    private final int d;
    private float e;
    private float f;
    private float g;
    private float h;
    private boolean i;
    private boolean j;
    private boolean k;

    public b(e eVar) {
        this.a = eVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(eVar.getContext());
        this.c = viewConfiguration.getScaledTouchSlop();
        this.d = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public final boolean a(MotionEvent motionEvent) {
        boolean z = false;
        this.b.addMovement(motionEvent);
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.i = false;
                this.e = motionEvent.getX();
                this.f = motionEvent.getY();
                this.g = this.f;
                this.h = 0.0f;
                if (this.f > ((float) this.a.getVisibleTop())) {
                    z = true;
                }
                if (z) {
                    this.j = true;
                    this.a.a();
                    break;
                }
                break;
            case 1:
                this.b.computeCurrentVelocity(1000, (float) this.d);
                a((int) y, (long) (-((int) this.b.getYVelocity())));
                this.b.clear();
                this.k = false;
                break;
            case 2:
                if (!this.k) {
                    float f = y - this.g;
                    x -= this.e;
                    float f2 = y - this.f;
                    this.h = Math.max(this.h, y);
                    this.g = y;
                    if (this.j && !this.i && Math.abs(f2) > ((float) this.c) && Math.abs(f2) > Math.abs(x) * 2.0f) {
                        this.i = true;
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        obtain.setAction(3);
                        this.a.a(obtain);
                    }
                    if (this.i) {
                        this.a.a(Math.round(f));
                        break;
                    }
                }
                break;
            case 3:
            case 4:
                this.k = false;
                a((int) y, 0);
                this.b.clear();
                break;
            case 5:
                if (!this.k) {
                    this.k = true;
                    a((int) y, 0);
                    break;
                }
                break;
        }
        if (this.i) {
            return true;
        }
        return this.a.a(motionEvent);
    }

    public final void a(a aVar) {
        aVar.a = new d(this.a);
    }

    private void a(int i, long j) {
        if (this.i) {
            if (((float) i) <= this.f || Math.abs(((float) i) - this.f) <= ((float) this.c) || this.h - ((float) i) > ((float) this.c)) {
                this.a.c(j);
            } else {
                this.a.a(0);
            }
        }
        this.j = false;
        this.i = false;
    }
}
