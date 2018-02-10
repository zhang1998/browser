package com.ui.edittext;

/* compiled from: ProGuard */
final class af implements t {
    final /* synthetic */ TextView a;
    private ae b;

    private af(TextView textView) {
        this.a = textView;
    }

    public final void a() {
        this.a.aM = true;
        c().b();
    }

    public final void b() {
        if (this.b != null) {
            this.b.c();
        }
        this.a.aM = false;
    }

    public final void onTouchModeChanged(boolean z) {
        if (!z) {
            b();
        }
    }

    final ae c() {
        if (this.a.V == null) {
            this.a.V = this.a.mContext.getResources().getDrawable(this.a.M);
        }
        if (this.b == null) {
            this.b = new ae(this.a, this.a.V);
        }
        return this.b;
    }

    public final void d() {
        this.a.getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.b != null) {
            this.b.f();
        }
    }
}
