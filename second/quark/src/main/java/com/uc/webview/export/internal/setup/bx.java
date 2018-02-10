package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.utility.download.UpdateTask;

/* compiled from: ProGuard */
final class bx implements ValueCallback<UpdateTask> {
    final ValueCallback a = ((ValueCallback) this.b.invokeO(10007, "updateProgress"));
    final /* synthetic */ bu b;

    bx(bu buVar) {
        this.b = buVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        UpdateTask updateTask = (UpdateTask) obj;
        this.b.mPercent = updateTask.getPercent();
        if (this.a != null) {
            this.a.onReceiveValue(this.b);
        }
    }
}
