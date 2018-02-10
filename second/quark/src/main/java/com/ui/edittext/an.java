package com.ui.edittext;

/* compiled from: ProGuard */
final class an implements t {
    ao a;
    int b;
    int c;
    long d = 0;
    float e;
    float f;
    final /* synthetic */ TextView g;
    private am h;

    an(TextView textView) {
        this.g = textView;
        c();
    }

    public final void a() {
        if (!this.g.o()) {
            this.g.aO = true;
            if (this.g.T == null) {
                this.g.T = this.g.mContext.getResources().getDrawable(this.g.K);
            }
            if (this.g.U == null) {
                this.g.U = this.g.mContext.getResources().getDrawable(this.g.L);
            }
            if (this.a == null) {
                this.a = new ao(this.g, this.g.T, this.g.U);
            }
            if (this.h == null) {
                this.h = new am(this.g, this.g.U, this.g.T);
            }
            this.a.b();
            this.h.b();
            this.g.R();
        }
    }

    public final void b() {
        if (this.a != null) {
            this.a.c();
        }
        if (this.h != null) {
            this.h.c();
        }
        this.g.aO = false;
    }

    public final void c() {
        this.c = -1;
        this.b = -1;
    }

    public final void onTouchModeChanged(boolean z) {
        if (!z) {
            b();
        }
    }

    public final void d() {
        this.g.getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.a != null) {
            this.a.f();
        }
        if (this.h != null) {
            this.h.f();
        }
    }
}
