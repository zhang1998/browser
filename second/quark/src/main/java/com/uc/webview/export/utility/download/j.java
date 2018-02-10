package com.uc.webview.export.utility.download;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWaStat.WaStat;
import java.io.File;

/* compiled from: ProGuard */
final class j implements ValueCallback<DownloadTask> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ UpdateTask b;

    j(UpdateTask updateTask, ValueCallback valueCallback) {
        this.b = updateTask;
        this.a = valueCallback;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        long totalSize;
        int i = -1;
        DownloadTask downloadTask = (DownloadTask) obj;
        try {
            totalSize = downloadTask.getTotalSize();
            totalSize = totalSize == 0 ? 0 : ((downloadTask.getCurrentSize() * 10) / totalSize) * 10;
            int i2 = (totalSize > 100 || totalSize < 0) ? -1 : (int) totalSize;
            if (i2 > this.b.f || i2 == 100) {
                this.b.f = this.b.f + 10;
                WaStat.stat(IWaStat.UCM_PERCENT, String.valueOf(i2));
                File file = new File(downloadTask.getFilePath());
                totalSize = file.getTotalSpace();
                long freeSpace = file.getFreeSpace();
                WaStat.stat(IWaStat.UCM_DISK_MB, String.valueOf((int) (freeSpace / 1048576)));
                totalSize = totalSize == 0 ? 0 : ((freeSpace * 10) / totalSize) * 10;
                i2 = (totalSize > 100 || totalSize < 0) ? -1 : (int) totalSize;
                WaStat.stat(IWaStat.UCM_DISK_PERCENT, String.valueOf(i2));
            }
        } catch (Throwable th) {
        }
        try {
            totalSize = downloadTask.getTotalSize();
            totalSize = totalSize == 0 ? 0 : (downloadTask.getCurrentSize() * 100) / totalSize;
            if (totalSize <= 100 && totalSize >= 0) {
                i = (int) totalSize;
            }
            if (this.a != null && i > this.b.g) {
                this.b.g = i;
                this.a.onReceiveValue(this.b);
            }
        } catch (Throwable th2) {
        }
    }
}
