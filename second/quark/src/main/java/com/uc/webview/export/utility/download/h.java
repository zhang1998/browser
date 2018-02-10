package com.uc.webview.export.utility.download;

import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWaStat.WaStat;

/* compiled from: ProGuard */
final class h implements ValueCallback<DownloadTask> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ ValueCallback b;
    final /* synthetic */ UpdateTask c;

    h(UpdateTask updateTask, ValueCallback valueCallback, ValueCallback valueCallback2) {
        this.c = updateTask;
        this.a = valueCallback;
        this.b = valueCallback2;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        DownloadTask downloadTask = (DownloadTask) obj;
        Throwable exception = downloadTask.getException();
        if (exception != null) {
            WaStat.stat(IWaStat.UCM_LAST_EXCEPTION, String.valueOf(exception.getClass().getName().hashCode()));
            try {
                if (this.c.i != null) {
                    this.c.i.onReceiveValue(new Object[]{Integer.valueOf(7), Integer.valueOf(r0)});
                }
            } catch (Throwable th) {
            }
        }
        long[] c = this.c.c;
        c[3] = c[3] + this.c.c[4];
        if (this.c.c[3] < this.c.c[5]) {
            this.c.e[1] = downloadTask.getException();
            try {
                if (this.a != null) {
                    this.a.onReceiveValue(this.c);
                }
            } catch (Throwable th2) {
            }
            new Handler(Looper.getMainLooper()).postDelayed(new i(this, downloadTask), this.c.c[4]);
            return;
        }
        WaStat.stat(IWaStat.UCM_EXCEPTION_DOWNLOAD);
        this.c.e[1] = new RuntimeException("Download aborted because of up to 10080 retries. Last exception is: " + (downloadTask.getException() != null ? downloadTask.getException().getMessage() : ""));
        try {
            if (this.b != null) {
                this.b.onReceiveValue(this.c);
            }
        } catch (Throwable th3) {
        }
        try {
            if (this.c.i != null) {
                this.c.i.onReceiveValue(new Object[]{Integer.valueOf(4)});
            }
        } catch (Throwable th4) {
        }
    }
}
