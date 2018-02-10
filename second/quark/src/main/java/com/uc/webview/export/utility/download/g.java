package com.uc.webview.export.utility.download;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWaStat.WaStat;
import java.io.File;

/* compiled from: ProGuard */
final class g implements ValueCallback<DownloadTask> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ ValueCallback b;
    final /* synthetic */ ValueCallback c;
    final /* synthetic */ ValueCallback d;
    final /* synthetic */ UpdateTask e;

    g(UpdateTask updateTask, ValueCallback valueCallback, ValueCallback valueCallback2, ValueCallback valueCallback3, ValueCallback valueCallback4) {
        this.e = updateTask;
        this.a = valueCallback;
        this.b = valueCallback2;
        this.c = valueCallback3;
        this.d = valueCallback4;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        DownloadTask downloadTask = (DownloadTask) obj;
        try {
            this.e.c[1] = downloadTask.getTotalSize();
            this.e.c[2] = downloadTask.getLastModified();
            File updateDir = this.e.getUpdateDir();
            if (UpdateTask.isFinished(updateDir, this.e.h)) {
                WaStat.stat(IWaStat.UCM_EXISTS);
                try {
                    if (this.a != null) {
                        this.a.onReceiveValue(this.e);
                    }
                } catch (Throwable th) {
                }
                downloadTask.stop();
                return;
            }
            try {
                long totalSize = downloadTask.getTotalSize();
                totalSize = totalSize == 0 ? 0 : ((downloadTask.getCurrentSize() * 10) / totalSize) * 10;
                int i = (totalSize > 100 || totalSize < 0) ? -1 : (int) totalSize;
                WaStat.stat(IWaStat.UCM_PERCENT, String.valueOf(i));
            } catch (Exception e) {
            }
            if (updateDir.exists()) {
                WaStat.stat(IWaStat.UCM_RECOVERED);
                try {
                    if (this.b != null) {
                        this.b.onReceiveValue(this.e);
                    }
                } catch (Throwable th2) {
                }
            }
            try {
                if (this.c != null) {
                    this.c.onReceiveValue(this.e);
                }
            } catch (Throwable th3) {
            }
        } catch (Throwable th4) {
        }
    }
}
