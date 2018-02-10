package com.ucpro.a;

import android.webkit.ValueCallback;
import com.uc.webview.export.utility.SetupTask;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class r implements ValueCallback<SetupTask> {
    final /* synthetic */ f a;

    r(f fVar) {
        this.a = fVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        SetupTask setupTask = (SetupTask) obj;
        f.a = 4;
        f.d = setupTask.getLoadedUCM();
        if (this.a.c != null) {
            m.a(2, new h(this));
        }
    }
}
