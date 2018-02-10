package com.ucpro.base.a;

import android.os.Handler;
import android.os.Message;
import com.ucweb.common.util.c;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class f {
    public WeakReference<i> a;
    private Handler b = new b(this);

    public static f a() {
        c.a(h.a.a, "handler can't be null. forgot to call init() ?");
        return h.a;
    }

    public final void a(int i, int i2, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = 0;
        obtain.obj = obj;
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        obtain2.arg1 = 1;
        obtain2.obj = obtain;
        this.b.sendMessage(obtain2);
    }

    public final void a(int i) {
        a(i, 0, null, true);
    }

    public final void a(int i, int i2) {
        a(i, i2, null, true);
    }

    public final void a(int i, int i2, Object obj, boolean z) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = 0;
        obtain.obj = obj;
        a(obtain, z);
    }

    final void a(Message message, boolean z) {
        c.a(this.a);
        if (this.a.get() != null) {
            ((i) this.a.get()).a(message, z);
        }
    }
}
