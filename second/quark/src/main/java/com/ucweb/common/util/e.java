package com.ucweb.common.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ProGuard */
public class e extends Handler {
    String b;

    public e(String str) {
        this.b = str;
    }

    public e(String str, Looper looper) {
        super(looper);
        this.b = str;
    }

    public String toString() {
        return "HandlerEx (" + this.b + ") {}";
    }

    public boolean sendMessageAtTime(Message message, long j) {
        return super.sendMessageAtTime(message, j);
    }

    public void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }
}
