package com.ucpro.a;

import android.webkit.ValueCallback;
import com.uc.webview.export.utility.SetupTask;

/* compiled from: ProGuard */
final class e implements ValueCallback<SetupTask> {
    final /* synthetic */ f a;

    e(f fVar) {
        this.a = fVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        SetupTask setupTask = (SetupTask) obj;
        f.a = 8;
        f.b = setupTask.getException();
        f.e = setupTask.getLoadedUCM().coreType;
        if (this.a.c != null) {
            this.a.c.a(f.b);
        }
    }
}
