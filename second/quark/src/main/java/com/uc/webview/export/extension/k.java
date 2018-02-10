package com.uc.webview.export.extension;

import android.webkit.ValueCallback;
import com.uc.webview.export.utility.download.UpdateTask;

/* compiled from: ProGuard */
final class k implements ValueCallback<UpdateTask> {
    k() {
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        ((UpdateTask) obj).delete();
    }
}
