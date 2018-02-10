package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class ai implements ValueCallback<s> {
    final ValueCallback a = ((ValueCallback) this.b.invokeO(10007, "updateProgress"));
    final /* synthetic */ ae b;

    ai(ae aeVar) {
        this.b = aeVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        s sVar = (s) obj;
        this.b.mPercent = ((Integer) sVar.invokeO(UCAsyncTask.getPercent, new Object[0])).intValue();
        if (this.a != null) {
            this.a.onReceiveValue(this.b);
        }
    }
}
