package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.UCSetupTask.a;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: ProGuard */
final class bt implements ValueCallback<CALLBACK_TYPE> {
    final /* synthetic */ a a;

    bt(a aVar) {
        this.a = aVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Log.d("UCSetupTask", "SetupCrashImprover.dieCallback MCE(" + this.a.b.exists() + "," + this.a.a.exists() + "," + this.a.c.exists() + ")");
        this.a.a();
    }
}
