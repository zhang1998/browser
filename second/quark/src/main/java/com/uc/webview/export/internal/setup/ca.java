package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.utility.download.UpdateTask;

/* compiled from: ProGuard */
final class ca implements ValueCallback<UpdateTask> {
    final /* synthetic */ bf a;
    final /* synthetic */ bu b;

    ca(bu buVar, bf bfVar) {
        this.b = buVar;
        this.a = bfVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.a.a(0, null);
    }
}
