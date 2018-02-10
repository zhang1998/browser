package com.uc.webview.export.internal.setup;

import android.os.HandlerThread;

/* compiled from: ProGuard */
final class bg extends HandlerThread {
    final /* synthetic */ UCAsyncTask a;

    bg(UCAsyncTask uCAsyncTask, String str, int i) {
        this.a = uCAsyncTask;
        super(str, i);
    }

    protected final void onLooperPrepared() {
        this.a.j = new bh(this, getLooper()).post(this.a);
    }
}
