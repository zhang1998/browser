package com.uc.webview.export.internal.setup;

import com.uc.webview.export.utility.download.UpdateTask;

/* compiled from: ProGuard */
final class cd implements Runnable {
    final /* synthetic */ UpdateTask a;
    final /* synthetic */ cc b;

    cd(cc ccVar, UpdateTask updateTask) {
        this.b = ccVar;
        this.a = updateTask;
    }

    public final void run() {
        this.a.start();
    }
}
