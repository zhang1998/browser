package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class ag implements ValueCallback<s> {
    final /* synthetic */ ae a;

    ag(ae aeVar) {
        this.a = aeVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        UCSetupTask uCSetupTask = (s) obj;
        if (SDKFactory.x != null) {
            SDKFactory.x.onReceiveValue(uCSetupTask.getException());
        }
        if (uCSetupTask.getException() != null) {
            this.a.f = uCSetupTask.getException();
            this.a.g = uCSetupTask;
        }
        Integer num = (Integer) this.a.mOptions.get(UCCore.OPTION_DELETE_CORE_POLICY);
        if (num != null && num.intValue() != 0 && (uCSetupTask instanceof at) && ((uCSetupTask.getException().errCode() == 1008 && (num.intValue() & 1) != 0) || ((uCSetupTask.getException().errCode() == 1011 && (num.intValue() & 8) != 0) || ((uCSetupTask.getException().errCode() == SettingsConst.PRELOAD_CD_PARAMS && (num.intValue() & 2) != 0) || ((uCSetupTask.getException().errCode() == SettingsConst.ENABLE_LITTLE_WIN && (num.intValue() & 16) != 0) || ((uCSetupTask.getException().errCode() == SettingsConst.SINFO_APOLLO_SO_VERSION && (num.intValue() & 4) != 0) || (num.intValue() & 32) != 0)))))) {
            if (this.a.k == null) {
                this.a.k = new ArrayList();
            }
            this.a.k.add((at) uCSetupTask);
        }
        if (ae.b.size() > 0) {
            ((UCSetupTask) ae.b.pop()).start();
        } else if (this.a.c != null) {
            ((s) ((s) ((s) this.a.c.invoke(10001, this.a)).onEvent("success", this.a.l)).onEvent("exception", this.a.m)).start();
            this.a.c = null;
        } else {
            this.a.setException(uCSetupTask.getException());
        }
    }
}
