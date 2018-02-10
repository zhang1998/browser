package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class aj implements ValueCallback<s> {
    final ValueCallback a = ((ValueCallback) this.b.invokeO(10007, "downloadException"));
    final /* synthetic */ ae b;

    aj(ae aeVar) {
        this.b = aeVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        s sVar = (s) obj;
        if (this.a != null) {
            if (sVar.getExtraException() != null) {
                this.b.setExtraException(sVar.getExtraException());
            }
            this.a.onReceiveValue(this.b);
        }
    }
}
