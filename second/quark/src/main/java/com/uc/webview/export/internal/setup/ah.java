package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
final class ah implements ValueCallback<s> {
    final /* synthetic */ ae a;

    ah(ae aeVar) {
        this.a = aeVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        s sVar = (s) obj;
        String str = this.a.j ? "ThickSetupTask_" + ((String) sVar.getOption(UCCore.OPTION_SO_FILE_PATH)) : "";
        if (str == null) {
            str = (String) sVar.getOption(UCCore.OPTION_DEX_FILE_PATH);
        }
        if (str == null) {
            str = (String) sVar.getOption(UCCore.OPTION_UCM_ZIP_FILE);
        }
        if (str == null) {
            str = (String) sVar.getOption(UCCore.OPTION_UCM_LIB_DIR);
        }
        if (str == null) {
            str = (String) sVar.getOption(UCCore.OPTION_UCM_KRL_DIR);
        }
        if (str == null) {
            str = (String) sVar.getOption(UCCore.OPTION_UCM_CFG_FILE);
        }
        sVar.setException(new UCSetupException((int) SettingsConst.SINFO_APOLLO_SO_VERSION, String.format("Multi crash detected in [%s].", new Object[]{str})));
        sVar.onEvent("die", null);
    }
}
