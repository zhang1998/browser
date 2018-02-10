package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

/* compiled from: ProGuard */
final class e extends f implements Callback {
    private HandlerThread a;
    private Handler b;
    private c c;
    private boolean d;

    e() {
        if (this.a != null) {
            b();
        }
        this.a = new HandlerThread("expression-timing-thread");
        this.a.start();
        this.b = new Handler(this.a.getLooper(), this);
    }

    final void a() {
        if (this.b != null) {
            this.b.removeCallbacksAndMessages(null);
        }
        this.d = false;
    }

    final void b() {
        a();
        if (VERSION.SDK_INT >= 18) {
            this.a.quitSafely();
        } else {
            this.a.quit();
        }
        this.b = null;
        this.a = null;
    }

    final void a(@NonNull c cVar) {
        this.c = cVar;
        this.d = true;
        if (this.b != null) {
            this.b.sendEmptyMessage(100);
        }
    }

    public final boolean handleMessage(Message message) {
        if (message == null || message.what != 100 || this.b == null) {
            return false;
        }
        if (this.c != null) {
            this.c.a_();
        }
        if (this.d) {
            this.b.sendEmptyMessageDelayed(100, 16);
        }
        return true;
    }
}
