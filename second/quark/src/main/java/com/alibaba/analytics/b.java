package com.alibaba.analytics;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.analytics.a.af;

/* compiled from: ProGuard */
public final class b extends Handler {
    private boolean a = false;

    public b(Looper looper) {
        super(looper);
    }

    public final void a(Runnable runnable) {
        af.b();
        try {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = runnable;
            sendMessage(obtain);
        } catch (Throwable th) {
        }
    }

    public final void handleMessage(Message message) {
        try {
            if (message.obj != null && (message.obj instanceof Runnable)) {
                ((Runnable) message.obj).run();
            }
        } catch (Throwable th) {
            af.b("AnalyticsMgr", th, new Object[0]);
        }
        super.handleMessage(message);
    }
}
