package com.uc.weex.component.c.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.uc.imagecodec.export.IPictureView;
import com.uc.weex.component.c.a.a.a;

/* compiled from: ProGuard */
public abstract class q implements OnTouchListener, d {
    protected final p a = new p();
    protected final a b;
    protected final m c;
    protected final o d;
    protected final k e;
    protected l f;
    protected e g = new g();
    protected f h = new h();
    protected float i;
    protected float j;
    protected float k;

    protected abstract n a();

    protected abstract void a(View view, float f);

    protected abstract void a(View view, float f, MotionEvent motionEvent);

    protected abstract j b();

    protected abstract float c();

    public q(a aVar) {
        this.b = aVar;
        this.e = new k(this, -2.0f);
        this.d = new o(this, 2.0f, IPictureView.DEFAULT_MIN_SCALE);
        this.c = new m(this);
        this.f = this.c;
        d().setOnTouchListener(this);
        d().setOverScrollMode(2);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                return this.f.b();
            case 2:
                return this.f.a(motionEvent);
            default:
                return false;
        }
    }

    public final void a(e eVar) {
        this.g = eVar;
    }

    public final void a(f fVar) {
        this.h = fVar;
    }

    public final View d() {
        return this.b.a();
    }

    protected final void a(l lVar) {
        l lVar2 = this.f;
        this.f = lVar;
        this.f.a(lVar2);
    }

    public final void a(float f) {
        this.i = f;
    }
}
