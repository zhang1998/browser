package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.apollo.impl.SettingsConst;
import java.io.File;

/* compiled from: ProGuard */
final class g implements ValueCallback<s> {
    final /* synthetic */ File a;
    final /* synthetic */ BrowserSetupTask b;

    g(BrowserSetupTask browserSetupTask, File file) {
        this.b = browserSetupTask;
        this.a = file;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        s sVar = (s) obj;
        sVar.setException(new UCSetupException((int) SettingsConst.SINFO_APOLLO_SO_VERSION, String.format("Multi crash detected in [%s].", new Object[]{this.a.getAbsolutePath()})));
        sVar.onEvent("die", null);
    }
}
