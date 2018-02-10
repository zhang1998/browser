package com.uc.apollo.media.widget;

import com.uc.apollo.media.b;
import com.uc.apollo.media.widget.MediaView.a;

/* compiled from: ProGuard */
final class d extends b {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void onStart() {
        if (this.a.c == null) {
            this.a.c = new com.uc.apollo.a.a(this.a.asView());
        }
        this.a.c.a();
    }

    public final void onError(int i, int i2) {
        a();
    }

    public final void onRelease() {
        a();
    }

    public final void onReset() {
        a();
    }

    public final void onCompletion() {
        a();
    }

    public final void onPause() {
        a();
    }

    private void a() {
        if (this.a.c != null) {
            this.a.c.b();
        }
    }
}
