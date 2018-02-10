package com.uc.webview.export.extension;

import com.uc.webview.export.utility.download.UpdateTask;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ UpdateTask a;
    final /* synthetic */ i b;

    j(i iVar, UpdateTask updateTask) {
        this.b = iVar;
        this.a = updateTask;
    }

    public final void run() {
        this.a.start();
    }
}
