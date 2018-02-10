package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.utility.download.UpdateTask;

/* compiled from: ProGuard */
final class bz implements ValueCallback<UpdateTask> {
    final /* synthetic */ bf a;
    final /* synthetic */ bu b;

    bz(bu buVar, bf bfVar) {
        this.b = buVar;
        this.a = bfVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        UpdateTask updateTask = (UpdateTask) obj;
        updateTask.delete();
        this.a.a(3, updateTask.getException());
    }
}
