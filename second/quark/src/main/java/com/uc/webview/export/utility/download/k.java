package com.uc.webview.export.utility.download;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWaStat.WaStat;

/* compiled from: ProGuard */
final class k implements ValueCallback<DownloadTask> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ UpdateTask b;

    k(UpdateTask updateTask, ValueCallback valueCallback) {
        this.b = updateTask;
        this.a = valueCallback;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        DownloadTask downloadTask = (DownloadTask) obj;
        downloadTask.delete();
        String str = new StringBuilder("DownloadTask failed with:") + (downloadTask.getException() != null ? downloadTask.getException().getMessage() : "");
        WaStat.stat(IWaStat.UCM_FAILED_DOWNLOAD);
        this.b.e[1] = new RuntimeException(str);
        try {
            if (this.a != null) {
                this.a.onReceiveValue(this.b);
            }
        } catch (Throwable th) {
        }
    }
}
