package com.uc.apollo.rebound;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

/* compiled from: ProGuard */
abstract class a {

    @TargetApi(16)
    /* compiled from: ProGuard */
    final class a extends f {
        private final Choreographer b;
        private final FrameCallback c = new b(this);
        private boolean d;
        private long e;

        public a(Choreographer choreographer) {
            this.b = choreographer;
        }

        public final void a() {
            if (!this.d) {
                this.d = true;
                this.e = SystemClock.uptimeMillis();
                this.b.removeFrameCallback(this.c);
                this.b.postFrameCallback(this.c);
            }
        }

        public final void b() {
            this.d = false;
            this.b.removeFrameCallback(this.c);
        }
    }

    /* compiled from: ProGuard */
    final class b extends f {
        private final Handler b;
        private final Runnable c = new c(this);
        private boolean d;
        private long e;

        public b(Handler handler) {
            this.b = handler;
        }

        public final void a() {
            if (!this.d) {
                this.d = true;
                this.e = SystemClock.uptimeMillis();
                this.b.removeCallbacks(this.c);
                this.b.post(this.c);
            }
        }

        public final void b() {
            this.d = false;
            this.b.removeCallbacks(this.c);
        }
    }
}
