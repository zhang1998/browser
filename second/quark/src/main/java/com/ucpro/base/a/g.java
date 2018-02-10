package com.ucpro.base.a;

import android.os.Handler;
import android.os.Message;
import com.ucweb.common.util.c;
import com.ucweb.common.util.h.m;
import hugo.weaving.DebugLog;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class g {
    public WeakReference<a> a;
    private Handler b;

    public static g a() {
        c.a(d.a.b(), "msg handler is null");
        return d.a;
    }

    private g() {
        this.b = new c(this);
    }

    private a b() {
        return this.a != null ? (a) this.a.get() : null;
    }

    public final void a(int i) {
        a(i, 0, 0, null);
    }

    public final void a(int i, int i2) {
        a(i, i2, 0, null);
    }

    public final void a(int i, Object obj) {
        a(i, 0, 0, obj);
    }

    public final void a(int i, int i2, int i3, Object obj) {
        this.b.sendMessage(c(i, i2, i3, obj));
    }

    public final void a(int i, Object obj, long j) {
        this.b.sendMessageDelayed(c(i, 0, 0, obj), j);
    }

    public final void b(int i) {
        b(i, 0, 0, null);
    }

    public final void b(int i, int i2) {
        b(i, i2, 0, null);
    }

    public final void a(int i, int i2, int i3) {
        b(i, i2, i3, null);
    }

    public final void b(int i, Object obj) {
        b(i, 0, 0, obj);
    }

    public final void b(int i, int i2, int i3, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.obj = obj;
        a(obtain);
    }

    @DebugLog
    public final void a(Message message) {
        c.a(m.c(), "non-ui thread");
        if (m.c()) {
            c.a(this.a);
            if (this.a != null) {
                c.a(this.a.get());
            }
            if (b() != null) {
                b().a(message);
                return;
            }
            return;
        }
        a(message.what, message.arg1, message.arg2, message.obj);
    }

    private static Message c(int i, int i2, int i3, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.obj = obj;
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        obtain2.obj = obtain;
        return obtain2;
    }
}
