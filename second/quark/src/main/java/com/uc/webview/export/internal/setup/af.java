package com.uc.webview.export.internal.setup;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCDex;
import com.uc.webview.export.cyclone.UCHashMap;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.cyclone.UCVmsize;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWaStat.WaStat;
import com.uc.webview.export.internal.setup.UCSubSetupTask.a;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import com.uc.webview.export.internal.utility.d;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: ProGuard */
final class af implements ValueCallback<s> {
    final /* synthetic */ ae a;

    af(ae aeVar) {
        this.a = aeVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        s sVar = (s) obj;
        if (sVar.getLoadedUCM() != null) {
            Object[] objArr;
            UCSubSetupTask uCSubSetupTask;
            try {
                String str;
                String str2;
                Object obj2;
                Object obj3;
                Object obj4;
                Object obj5;
                Object crashCode;
                Object simpleName;
                Integer num;
                Object obj6;
                UCMRunningInfo loadedUCM = sVar.getLoadedUCM();
                this.a.setLoadedUCM(loadedUCM);
                this.a.setTotalLoadedUCM(loadedUCM);
                UCLogger create = UCLogger.create("d", "SdkSetupTask");
                if (!(create == null || UCSetupTask.getTotalLoadedUCM().ucmPackageInfo == null)) {
                    create.print(String.format("mSuccessCB: dataDir is [%s].", new Object[]{UCSetupTask.getTotalLoadedUCM().ucmPackageInfo.dataDir}), new Throwable[0]);
                }
                try {
                    this.a.callbackFinishStat(String.valueOf(UCSetupTask.getTotalLoadedUCM().coreType));
                } catch (Throwable th) {
                }
                try {
                    str = (String) this.a.getOption(UCCore.OPTION_UCM_UPD_URL);
                    if (str != null) {
                        r6 = new Object[2];
                        r6[0] = UCMPackageInfo.invoke(10005, this.a.d);
                        r6[1] = "uc_upd";
                        File file = (File) UCMPackageInfo.invoke(UCMPackageInfo.expectCreateDirFile2P, r6);
                        File file2 = new File(file, UCCyclone.getSourceHash(str) + "_frun");
                        if (file2.exists() || file2.createNewFile()) {
                            long j;
                            long j2;
                            if (loadedUCM.coreType != 2) {
                                File file3 = new File(file, UCCyclone.getSourceHash(str) + "_ucrun");
                                if (file3.exists() || file3.createNewFile()) {
                                    long lastModified = file3.lastModified() - file2.lastModified();
                                    if (loadedUCM.isOldExtraKernel) {
                                        j = 0;
                                        j2 = lastModified;
                                    } else {
                                        File file4 = new File(file, UCCyclone.getSourceHash(str) + "_curucrun");
                                        if (file4.exists() || file4.createNewFile()) {
                                            j = file4.lastModified() - file2.lastModified();
                                            j2 = lastModified;
                                        } else {
                                            throw new Exception("createNewFile currentUcRunFlagFile failed");
                                        }
                                    }
                                }
                                throw new Exception("createNewFile ucrunFlagFile failed");
                            }
                            j2 = System.currentTimeMillis() - file2.lastModified();
                            j = 0;
                            if (j == 0) {
                                j = System.currentTimeMillis() - file2.lastModified();
                            }
                            WaStat.stat(IWaStat.SETUP_UCCORE_COST_HOUR, String.valueOf((int) Math.ceil((double) (j2 / 3600000))));
                            WaStat.stat(IWaStat.SETUP_CUR_UCCORE_COST_HOUR, String.valueOf((int) Math.ceil((double) (j / 3600000))));
                        } else {
                            throw new Exception("createNewFile firstTimeRunFlagFile failed");
                        }
                    }
                } catch (Throwable th2) {
                }
                try {
                    WaStat.stat(IWaStat.UCM_OLD, UCSetupTask.getTotalLoadedUCM().isOldExtraKernel ? SettingsConst.TRUE : SettingsConst.FALSE);
                } catch (Throwable th3) {
                }
                String str3;
                try {
                    String str4 = "";
                    str2 = "";
                    str3 = "";
                    String str5 = "";
                    str = "";
                    obj2 = (UCSetupTask.getTotalLoadedUCM().coreType != 2 || this.a.f == null) ? null : 1;
                    if (obj2 != null) {
                        str4 = String.valueOf(this.a.f.errCode());
                        try {
                            str2 = this.a.f.getRootCause().getClass().getSimpleName();
                        } catch (Throwable th4) {
                        }
                        try {
                            str3 = this.a.f.getRootCause().getMessage();
                        } catch (Throwable th5) {
                        }
                        obj3 = str3;
                        obj4 = str2;
                        obj5 = str4;
                        crashCode = this.a.g.getCrashCode();
                        simpleName = this.a.g.getClass().getSimpleName();
                    } else {
                        String str6 = str3;
                        String str7 = str2;
                        String str8 = str4;
                        str4 = str5;
                        str2 = str;
                    }
                    num = (Integer) this.a.getOption(UCCore.OPTION_SETUP_THREAD_PRIORITY);
                    Callable callable = (Callable) this.a.getOption(UCCore.OPTION_DOWNLOAD_CHECKER);
                    str5 = callable == null ? "N" : ((Boolean) callable.call()).booleanValue() ? "T" : "F";
                    obj6 = str5;
                } catch (Throwable th6) {
                }
                Object obj7 = new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", String.valueOf(UCSetupTask.getTotalLoadedUCM().coreType)).set("dir", UCSetupTask.getTotalLoadedUCM().ucmPackageInfo == null ? "null" : UCSetupTask.getTotalLoadedUCM().ucmPackageInfo.getDirAlias(this.a.d)).set("old", UCSetupTask.getTotalLoadedUCM().isOldExtraKernel ? "T" : "F").set("frun", UCSetupTask.getTotalLoadedUCM().isFirstTimeOdex ? "T" : "F").set("cpu_cnt", d.a()).set("cpu_freq", d.b()).set("cost_cpu", String.valueOf(this.a.e.getMilisCpu())).set("cost", String.valueOf(this.a.e.getMilis())).set("pri", num == null ? "n" : String.valueOf(num)).set("wifi", obj6);
                ae aeVar = this.a;
                String str9 = IWaStat.SETUP_SUCCESS;
                if (obj2 != null) {
                    obj7 = obj7.set("multi_core", SDKFactory.k ? SettingsConst.TRUE : SettingsConst.FALSE).set("err", obj5).set("cls", obj4).set("msg", obj3).set("crash", crashCode).set("task", simpleName);
                }
                aeVar.callbackStat(new Pair(str9, obj7));
                WaStat.stat(IWaStat.UCM_OLD, UCSetupTask.getTotalLoadedUCM().isOldExtraKernel ? SettingsConst.TRUE : SettingsConst.FALSE);
                try {
                    if (UCSetupTask.getTotalLoadedUCM().coreType != 2) {
                        UCMPackageInfo.invoke(UCMPackageInfo.initUCMBuildInfo, loadedUCM.shellClassLoader);
                    }
                } catch (Throwable th7) {
                }
                try {
                    SDKFactory.a(SDKFactory.a(loadedUCM.ucmPackageInfo, (String) this.a.getOption(UCCore.OPTION_LOAD_POLICY)));
                } catch (Throwable th8) {
                }
                try {
                    Boolean bool = (Boolean) this.a.getOption(UCCore.OPTION_VMSIZE_SAVING);
                    Object obj8 = (bool == null || !bool.booleanValue()) ? null : 1;
                    obj6 = ReflectionUtil.invokeNoThrow("com.uc.crashsdk.export.CrashApi", "getInstance");
                    if (obj6 != null) {
                        str2 = "addHeaderInfo";
                        Class[] clsArr = new Class[]{String.class, String.class};
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = "vmsize_saving_enable";
                        objArr2[1] = obj8 != null ? "true" : "false";
                        ReflectionUtil.invokeNoThrow(obj6, str2, clsArr, objArr2);
                    }
                    if (create != null) {
                        create.print("mSuccessCB: vmsize_saving_enable=" + (obj8 != null ? "true" : "false"), new Throwable[0]);
                    }
                    if (obj8 != null) {
                        new UCAsyncTask(new UCVmsize(this.a.d)).invoke(10001, UCSetupTask.getRoot()).start();
                    }
                } catch (Throwable th9) {
                }
                try {
                    ((o) ((o) ((o) ((o) new o().invoke(10001, UCSetupTask.getRoot())).setup(UCCore.OPTION_CONTEXT, this.a.d)).setup("del_dec_fil", Boolean.valueOf(true))).setup("del_upd_fil", Boolean.valueOf(false))).start();
                } catch (Throwable th10) {
                }
                if (this.a.k != null) {
                    n nVar = new n(this.a.k);
                    objArr = new Object[]{UCSetupTask.getRoot()};
                    uCSubSetupTask = this.a;
                    uCSubSetupTask.getClass();
                    ((n) ((n) ((n) nVar.invoke(10001, objArr)).setOptions(this.a.mOptions)).onEvent("stat", new a(uCSubSetupTask))).start();
                }
                this.a.k = null;
            } catch (Throwable th11) {
                this.a.setException(new UCSetupException((int) SettingsConst.SINFO_SERIES_CODE, th11));
                return;
            }
            try {
                if (UCSetupTask.getTotalLoadedUCM().coreType != 2) {
                    ar arVar = new ar();
                    objArr = new Object[]{UCSetupTask.getRoot()};
                    uCSubSetupTask = this.a;
                    uCSubSetupTask.getClass();
                    ((ar) ((ar) ((ar) arVar.invoke(10001, objArr)).setOptions(this.a.mOptions)).onEvent("stat", new a(uCSubSetupTask))).start();
                }
            } catch (Throwable th12) {
            }
            try {
                Log.d("SdkSetupTask", "CDInitTask new");
                ((UCSubSetupTask) ReflectionUtil.invoke("com.uc.webview.export.cd.Utils", "createInitTaskForSdkSetupTask", new Class[]{String.class, ae.class}, new Object[]{"stat", this.a})).setOptions(this.a.mOptions).start();
            } catch (Throwable th13) {
            }
            try {
                if (this.a.c != null) {
                    this.a.c.start(2000);
                    this.a.c = null;
                    new UCAsyncTask(new UCDex()).invoke(10001, UCSetupTask.getRoot()).start();
                    return;
                }
                return;
            } catch (Throwable th14) {
                return;
            }
        }
        this.a.setException(new UCSetupException((int) SettingsConst.SINFO_VERSION, String.format("Task [%s] report success but no loaded UCM.", new Object[]{sVar.getClass().getName()})));
    }
}
