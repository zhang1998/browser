package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.util.Pair;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import java.util.List;

/* compiled from: ProGuard */
public final class bb extends p {
    public final void run() {
        long j = 0;
        setup(UCCore.OPTION_DEX_FILE_PATH, null);
        Context context = (Context) this.mOptions.get(UCCore.OPTION_CONTEXT);
        List a = UCMPackageInfo.a(context, this.mOptions);
        if (a.size() != 1) {
            throw new UCSetupException((int) SettingsConst.COMPATIBLE_WITH_SYSTEM_MEDIAPLAYER_API, "1 UCMPackage expected for thick mode.");
        }
        long j2;
        Integer num = (Integer) this.mOptions.get(UCCore.OPTION_VERIFY_POLICY);
        UCMPackageInfo uCMPackageInfo = (UCMPackageInfo) a.get(0);
        this.mUCM = uCMPackageInfo;
        if (num == null || (num.intValue() & 8) == 0) {
            j2 = 0;
        } else {
            UCElapseTime uCElapseTime = new UCElapseTime();
            a(uCMPackageInfo, context, UCMPackageInfo.class.getClassLoader(), num.intValue());
            j2 = 0 + uCElapseTime.getMilisCpu();
            j = 0 + uCElapseTime.getMilis();
        }
        a(IWaStat.SETUP_TASK_VERIFY, false, num, "thick", j, j2);
        this.mCL = UCMPackageInfo.class.getClassLoader();
        this.a = false;
        this.b = false;
        callbackStat(new Pair(IWaStat.SETUP_SUCCESS_SETUPED, null));
    }
}
