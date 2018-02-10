package com.uc.webview.export.internal.setup;

import android.os.SystemClock;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.cyclone.UCDex;
import com.uc.webview.export.cyclone.UCHashMap;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.cyclone.UCVmsize;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import com.uc.webview.export.internal.utility.d;
import java.util.concurrent.Callable;

/* compiled from: ProGuard */
final class a implements ValueCallback<s> {
    final /* synthetic */ BrowserSetupTask a;

    a(BrowserSetupTask browserSetupTask) {
        this.a = browserSetupTask;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        s sVar = (s) obj;
        if (sVar.getLoadedUCM() != null) {
            try {
                Integer num;
                Object obj2;
                UCMRunningInfo loadedUCM = sVar.getLoadedUCM();
                this.a.setLoadedUCM(loadedUCM);
                this.a.setTotalLoadedUCM(loadedUCM);
                UCLogger create = UCLogger.create("d", "BrowserSetupTask");
                try {
                    ((o) ((o) ((o) ((o) new o().invoke(10001, UCSetupTask.getRoot())).setup(UCCore.OPTION_CONTEXT, this.a.e)).setup("del_dec_fil", Boolean.valueOf(this.a.f == null))).setup("del_upd_fil", Boolean.valueOf(true))).start();
                } catch (Throwable th) {
                }
                try {
                    this.a.callbackFinishStat(String.valueOf(UCSetupTask.getTotalLoadedUCM().coreType));
                } catch (Throwable th2) {
                }
                try {
                    num = (Integer) this.a.getOption(UCCore.OPTION_SETUP_THREAD_PRIORITY);
                    Callable callable = (Callable) this.a.getOption(UCCore.OPTION_DOWNLOAD_CHECKER);
                    String str = callable == null ? "N" : ((Boolean) callable.call()).booleanValue() ? "T" : "F";
                    obj2 = str;
                } catch (Throwable th3) {
                }
                this.a.callbackStat(new Pair(IWaStat.SETUP_SUCCESS, new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", String.valueOf(UCSetupTask.getTotalLoadedUCM().coreType)).set("dir", UCSetupTask.getTotalLoadedUCM().ucmPackageInfo == null ? "null" : UCSetupTask.getTotalLoadedUCM().ucmPackageInfo.getDirAlias(this.a.e)).set("old", UCSetupTask.getTotalLoadedUCM().isOldExtraKernel ? "T" : "F").set("frun", UCSetupTask.getTotalLoadedUCM().isFirstTimeOdex ? "T" : "F").set("cpu_cnt", d.a()).set("cpu_freq", d.b()).set("cost_cpu", String.valueOf(SystemClock.currentThreadTimeMillis() - this.a.h)).set("cost", String.valueOf(this.a.g.getMilis())).set("pri", num == null ? "n" : String.valueOf(num)).set("wifi", obj2)));
                try {
                    UCMPackageInfo.invoke(UCMPackageInfo.initUCMBuildInfo, loadedUCM.shellClassLoader);
                } catch (Throwable th4) {
                }
                try {
                    Boolean bool = (Boolean) this.a.getOption(UCCore.OPTION_VMSIZE_SAVING);
                    Object obj3 = ((bool != null || Math.random() <= 0.5d) && (bool == null || !bool.booleanValue())) ? null : 1;
                    obj2 = ReflectionUtil.invokeNoThrow("com.uc.crashsdk.export.CrashApi", "getInstance");
                    if (obj2 != null) {
                        String str2 = "addHeaderInfo";
                        Class[] clsArr = new Class[]{String.class, String.class};
                        Object[] objArr = new Object[2];
                        objArr[0] = "vmsize_saving_enable";
                        objArr[1] = obj3 != null ? "true" : "false";
                        ReflectionUtil.invokeNoThrow(obj2, str2, clsArr, objArr);
                    }
                    if (create != null) {
                        create.print("mSuccessCB: vmsize_saving_enable=" + (obj3 != null ? "true" : "false"), new Throwable[0]);
                    }
                    if (obj3 != null) {
                        new UCAsyncTask(new UCVmsize(this.a.e)).invoke(10001, UCSetupTask.getRoot()).start();
                    }
                } catch (Throwable th5) {
                }
                try {
                    ar arVar = new ar();
                    Object[] objArr2 = new Object[]{UCSetupTask.getRoot()};
                    UCSubSetupTask uCSubSetupTask = this.a;
                    uCSubSetupTask.getClass();
                    ((ar) ((ar) ((ar) arVar.invoke(10001, objArr2)).setOptions(this.a.mOptions)).onEvent("stat", new com.uc.webview.export.internal.setup.UCSubSetupTask.a(uCSubSetupTask))).start();
                } catch (Throwable th6) {
                }
                try {
                    if (this.a.c != null) {
                        ((s) this.a.c.invoke(10001, UCSetupTask.getRoot())).start(5000);
                        this.a.c = null;
                        new UCAsyncTask(new UCDex()).invoke(10001, UCSetupTask.getRoot()).start();
                    }
                } catch (Throwable th7) {
                }
                try {
                    Log.d("BrowserSetupTask", "CDInitTask new");
                    ((UCSubSetupTask) ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "createInitTaskForBrowserSetupTask", new Class[]{String.class, BrowserSetupTask.class}, new Object[]{"stat", this.a})).setOptions(this.a.mOptions).start();
                    return;
                } catch (Throwable th8) {
                    return;
                }
            } catch (Throwable th9) {
                this.a.setException(new UCSetupException((int) SettingsConst.SINFO_SERIES_CODE, th9));
                return;
            }
        }
        this.a.setException(new UCSetupException((int) SettingsConst.SINFO_VERSION, String.format("Task [%s] report success but no loaded UCM.", new Object[]{sVar.getClass().getName()})));
    }
}
