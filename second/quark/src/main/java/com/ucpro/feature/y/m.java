package com.ucpro.feature.y;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class m {
    boolean a;
    boolean b;
    float c;
    float d;
    boolean e;
    w f;
    private float g;

    public m() {
        this.a = false;
        this.b = false;
        this.e = false;
        this.g = (float) ViewConfiguration.get(d.a()).getScaledPagingTouchSlop();
        this.g = 10.0f;
    }

    final void a(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float f = y - this.d;
        x -= this.c;
        y -= this.d;
        if (!(this.a || this.b)) {
            if (!this.e && f > this.g && Math.abs(y) > Math.abs(x) * 2.0f) {
                if (this.f != null) {
                    this.f.e();
                }
                this.a = true;
            }
            if (!this.e && f < (-this.g) && Math.abs(y) > Math.abs(x) * 2.0f) {
                this.b = true;
            }
        }
        if (this.f == null) {
            return;
        }
        if (this.a) {
            this.f.a(f);
        } else if (this.b) {
            this.f.c(f);
        }
    }

    final void a() {
        if (!(this.e || this.f == null)) {
            if (this.a) {
                this.f.f();
            } else if (this.b) {
                this.f.g();
            }
        }
        this.a = false;
        this.b = false;
    }
}
