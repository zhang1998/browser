package com.bumptech.glide.b.b;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: ProGuard */
final class ax implements Callback {
    ax() {
    }

    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        ((au) message.obj).d();
        return true;
    }
}
