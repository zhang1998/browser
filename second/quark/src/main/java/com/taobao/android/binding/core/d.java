package com.taobao.android.binding.core;

import android.annotation.TargetApi;
import android.mini.support.annotation.NonNull;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

@TargetApi(16)
/* compiled from: ProGuard */
final class d extends f implements FrameCallback {
    private Choreographer a = Choreographer.getInstance();
    private c b;
    private boolean c;

    @TargetApi(16)
    d() {
    }

    final void a() {
        if (this.a != null) {
            this.a.removeFrameCallback(this);
        }
        this.c = false;
    }

    final void b() {
        a();
        this.a = null;
    }

    final void a(@NonNull c cVar) {
        this.b = cVar;
        this.c = true;
        if (this.a != null) {
            this.a.postFrameCallback(this);
        }
    }

    public final void doFrame(long j) {
        if (this.b != null) {
            this.b.a_();
        }
        if (this.a != null && this.c) {
            this.a.postFrameCallback(this);
        }
    }
}
