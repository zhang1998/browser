package com.uc.webview.export.extension;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWaStat.WaStat;
import com.uc.webview.export.utility.download.UpdateTask;

/* compiled from: ProGuard */
final class n implements ValueCallback<UpdateTask> {
    n() {
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        WaStat.stat(IWaStat.VIDEO_UNZIP_SUCCESS);
    }
}
