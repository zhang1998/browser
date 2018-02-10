package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: ProGuard */
final class br implements ValueCallback<Object> {
    final /* synthetic */ UCSetupTask a;

    br(UCSetupTask uCSetupTask) {
        this.a = uCSetupTask;
    }

    public final void onReceiveValue(Object obj) {
        Log.d("UCSetupTask", "print_log onReceiveValue value: " + obj);
        if (obj != null) {
            this.a.a(true, ((Boolean) obj).booleanValue());
        } else {
            this.a.a(false, true);
        }
        this.a.i = true;
    }
}
