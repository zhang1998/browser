package com.uc.webview.export.utility;

import android.util.Pair;
import com.uc.apollo.impl.SettingsConst;
import com.uc.crashsdk.export.LogType;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.cyclone.UCHashMap;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.setup.UCSetupTask;
import com.uc.webview.export.internal.utility.Log;
import java.util.Map.Entry;

@Api
/* compiled from: ProGuard */
public abstract class SetupTask extends UCSetupTask<SetupTask, SetupTask> {
    public static UCMPackageInfo sFirstUCM = null;
    private final String a = "SetupTask";

    public void startSync() {
        start();
        try {
            Thread.sleep(200);
        } catch (Throwable th) {
        }
        SDKFactory.invoke(10029, new Object[0]);
    }

    public void callbackFinishStat(String str) {
        UCLogger create = UCLogger.create("i", "SetupTask");
        if (create != null) {
            create.print("finish: core=" + str, new Throwable[0]);
        }
    }

    public void setException(UCSetupException uCSetupException) {
        setException(uCSetupException, true);
    }

    public void setException(UCSetupException uCSetupException, boolean z) {
        super.setException(uCSetupException);
        callStatException(IWaStat.SETUP_TOTAL_EXCEPTION, uCSetupException);
        callbackFinishStat(SettingsConst.FALSE);
        if (z) {
            SDKFactory.invoke(UCMPackageInfo.compareVersion, uCSetupException.toRunnable());
        }
    }

    public void callStatException(String str, UCSetupException uCSetupException) {
        int i = LogType.UNEXP;
        try {
            Object obj;
            Object substring;
            String str2 = "";
            String str3 = "";
            try {
                str2 = uCSetupException.getRootCause().getClass().getName();
                String message = uCSetupException.getRootCause().getMessage();
                if (LogType.UNEXP > message.length()) {
                    i = message.length();
                }
                obj = str2;
                substring = message.substring(0, i);
            } catch (Exception e) {
                String str4 = str3;
                str3 = str2;
                str2 = str4;
            }
            callbackStat(new Pair(str, new UCHashMap().set("cnt", SettingsConst.TRUE).set("err", String.valueOf(uCSetupException.errCode())).set("cls", obj).set("msg", substring)));
        } catch (Throwable th) {
        }
    }

    public SetupTask setAsDefault() {
        SDKFactory.D = this;
        SDKFactory.q = true;
        return this;
    }

    public String getFirstUCMFileHashs() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (sFirstUCM != null) {
                for (Entry entry : sFirstUCM.getFileHashs().entrySet()) {
                    stringBuilder.append((String) entry.getKey()).append("=").append((String) entry.getValue()).append(";");
                }
            } else {
                stringBuilder.append("first_ucm=null;");
            }
        } catch (Throwable th) {
            Log.d("SetupTask", "getFirstUCMFileHashs error", th);
        }
        return stringBuilder.toString();
    }
}
