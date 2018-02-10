package com.ui.edittext;

import android.graphics.drawable.Drawable;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;

/* compiled from: ProGuard */
final class ae extends aa {
    final /* synthetic */ TextView l;
    private float m;
    private float n;
    private Runnable o;

    public ae(TextView textView, Drawable drawable) {
        this.l = textView;
        super(textView, drawable, drawable);
    }

    public final void b() {
        super.b();
        h();
    }

    public final void g() {
        b();
    }

    private void h() {
        i();
        if (this.o == null) {
            this.o = new ad(this);
        }
        this.l.postDelayed(this.o, 4000);
    }

    private void i() {
        if (this.o != null) {
            this.l.removeCallbacks(this.o);
        }
    }

    protected final int a(int i, int i2, boolean z) {
        return i2 / 2;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Object obj = 1;
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.m = motionEvent.getRawX();
                this.n = motionEvent.getRawY();
                break;
            case 1:
                if (this.j <= 1) {
                    obj = null;
                }
                if (obj == null) {
                    float rawX = this.m - motionEvent.getRawX();
                    float rawY = this.n - motionEvent.getRawY();
                    if ((rawX * rawX) + (rawY * rawY) < ((float) this.l.ad)) {
                        b();
                    }
                }
                h();
                break;
            case 3:
                h();
                break;
        }
        return onTouchEvent;
    }

    public final int d() {
        return this.l.getSelectionStart();
    }

    public final void a(int i) {
        Selection.setSelection((Spannable) this.l.g, i);
    }

    public final void a(float f, float f2) {
        a(this.l.a(f, f2), false);
    }

    final void e() {
        super.e();
        i();
    }

    public final void f() {
        super.f();
        i();
    }
}
