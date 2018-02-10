package com.ucpro.feature.s.b.a.a;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.s.b.a.c;
import com.ucpro.feature.s.b.a.e;

/* compiled from: ProGuard */
public final class d implements c {
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
    private boolean l;

    public d(e eVar) {
        this.a = eVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(eVar.getContext());
        this.c = viewConfiguration.getScaledTouchSlop();
        this.d = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public final boolean a(MotionEvent motionEvent) {
        float f = IPictureView.DEFAULT_MIN_SCALE;
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
                this.l = a();
                this.j = true;
                this.a.a();
                break;
            case 1:
                this.b.computeCurrentVelocity(1000, (float) this.d);
                a((int) y, (long) (-((int) this.b.getYVelocity())));
                this.b.clear();
                this.k = false;
                break;
            case 2:
                if (!this.k) {
                    float f2 = y - this.g;
                    x -= this.e;
                    float f3 = y - this.f;
                    this.g = y;
                    this.h = Math.max(this.h, y);
                    if (this.j && !this.i && a() && this.l && f3 > 0.0f && Math.abs(f3) > ((float) this.c) && Math.abs(f3) > Math.abs(x) * 2.0f) {
                        this.i = true;
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        obtain.setAction(3);
                        this.a.a(obtain);
                    }
                    if (this.i) {
                        x = this.f;
                        if (y > x && this.a.getHeight() > 0) {
                            f = IPictureView.DEFAULT_MIN_SCALE - Math.min(IPictureView.DEFAULT_MIN_SCALE, ((y - x) / ((float) this.a.getHeight())) * 0.5f);
                            f *= (f * f) * f;
                        }
                        this.a.a(Math.round((float) Math.round(f * f2)));
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

    private boolean a() {
        e eVar = this.a;
        if (eVar.a instanceof c) {
            return ((c) eVar.a).a();
        }
        return true;
    }

    private void a(int i, long j) {
        if (this.i) {
            if ((((int) Math.abs(((float) i) - this.f)) <= this.a.getHeight() / 6 || this.h - ((float) i) > ((float) this.c)) && (Math.abs(j) <= ((long) (this.d / 8)) || ((float) i) <= this.f)) {
                this.a.c(j);
            } else {
                this.a.a(j);
            }
        }
        this.j = false;
        this.i = false;
    }

    public final void a(a aVar) {
    }
}
