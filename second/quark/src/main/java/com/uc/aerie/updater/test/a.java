package com.uc.aerie.updater.test;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ProGuard */
final class a extends Handler {
    final /* synthetic */ AerieUpdaterTestActivity a;

    a(AerieUpdaterTestActivity aerieUpdaterTestActivity, Looper looper) {
        this.a = aerieUpdaterTestActivity;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                AerieUpdaterTestActivity.a(this.a, message);
                return;
            case 1:
                if (message.arg1 == 0) {
                    AerieUpdaterTestActivity.b(this.a, message);
                    return;
                } else if (1 == message.arg1) {
                    AerieUpdaterTestActivity.c(this.a, message);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
