package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.UCSetupTask.a;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: ProGuard */
final class bs implements ValueCallback<CALLBACK_TYPE> {
    final /* synthetic */ a a;

    bs(a aVar) {
        this.a = aVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Log.d("UCSetupTask", "SetupCrashImprover.startCallback MCE(" + this.a.b.exists() + "," + this.a.a.exists() + "," + this.a.c.exists() + ")");
        a.a(this.a);
        a aVar = this.a;
        try {
            if (!aVar.a.exists()) {
                aVar.a.createNewFile();
            } else if (!aVar.c.exists()) {
                aVar.c.createNewFile();
            } else if (!aVar.b.exists()) {
                aVar.b.createNewFile();
            }
        } catch (Throwable th) {
        }
    }
}
