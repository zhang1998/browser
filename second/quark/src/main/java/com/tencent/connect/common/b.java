package com.tencent.connect.common;

import android.os.Handler;
import android.os.Message;

/* compiled from: ProGuard */
final class b extends Handler {
    final /* synthetic */ AssistActivity a;

    b(AssistActivity assistActivity) {
        this.a = assistActivity;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                if (!this.a.isFinishing()) {
                    this.a.finish();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
