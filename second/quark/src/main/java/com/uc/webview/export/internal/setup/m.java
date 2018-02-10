package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.util.Pair;
import com.UCMobile.Apollo.Global;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.Build;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.cyclone.UCHashMap;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.UCAsyncTask.c;
import com.uc.webview.export.internal.utility.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class m extends s {
    public void run() {
        float freeSpace;
        Object valueOf;
        Object obj;
        Object valueOf2;
        UCKnownException e;
        Object obj2;
        String str;
        Throwable th;
        String str2 = (String) getOption(UCCore.OPTION_UCM_ZIP_FILE);
        boolean a = d.a((String) getOption(UCCore.OPTION_UCM_ZIP_DIR));
        boolean a2 = d.a(str2);
        if (!(a && a2) && (a || a2)) {
            File file;
            String str3;
            Context context = (Context) getOption(UCCore.OPTION_CONTEXT);
            if (a2) {
                file = (File) UCMPackageInfo.invoke(UCMPackageInfo.getKernelFileIfMultiCoreFromDir, str3, context);
            } else {
                file = UCCyclone.expectFile(str2);
            }
            if (file == null) {
                throw new UCSetupException((int) SettingsConst.USE_DEFAULT_AUDIO_FOCUS_CHANGE_LISTENER, String.format("No kernel file found in dir [%s].", new Object[]{str3}));
            }
            File file2;
            boolean decompressIfNeeded;
            synchronized (m.class) {
                r6 = new Object[2];
                r6[0] = (File) UCMPackageInfo.invoke(10003, context);
                r6[1] = UCCyclone.getSourceHash(file.getAbsolutePath());
                file2 = (File) UCMPackageInfo.invoke(UCMPackageInfo.expectCreateDirFile2P, (File) UCMPackageInfo.invoke(UCMPackageInfo.expectCreateDirFile2P, r6), UCCyclone.getSourceHash(file.length(), file.lastModified()));
                String str4 = "";
                Object obj3 = SettingsConst.FALSE;
                Object obj4 = SettingsConst.FALSE;
                String str5 = "";
                float f = 0.0f;
                try {
                    UCElapseTime uCElapseTime = new UCElapseTime();
                    freeSpace = (float) (file2.getFreeSpace() / 1024);
                    try {
                        decompressIfNeeded = UCCyclone.decompressIfNeeded(context, false, file, file2, null, false);
                        if (decompressIfNeeded) {
                            str2 = SettingsConst.FALSE;
                            try {
                                valueOf = String.valueOf(uCElapseTime.getMilisCpu());
                                try {
                                    obj = str2;
                                    valueOf2 = String.valueOf(uCElapseTime.getMilis());
                                } catch (UCKnownException e2) {
                                    e = e2;
                                    obj2 = obj3;
                                    str = str2;
                                    valueOf2 = valueOf;
                                    f = freeSpace;
                                    try {
                                        str4 = Global.APOLLO_SERIES;
                                        try {
                                            str = String.valueOf(e.errCode());
                                            try {
                                                throw e;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                freeSpace = f;
                                                obj4 = valueOf2;
                                                valueOf = str;
                                                valueOf2 = obj2;
                                                obj = str4;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            freeSpace = f;
                                            obj4 = valueOf2;
                                            str = str4;
                                            valueOf2 = obj2;
                                            str3 = str5;
                                            try {
                                                callbackStat(new Pair("sdk_7z", new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", obj).set("cost", valueOf2).set("cost_cpu", obj4).set("data", valueOf).set("cpu_cnt", d.a()).set("cpu_freq", d.b()).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(freeSpace))));
                                            } catch (Throwable th4) {
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        freeSpace = f;
                                        obj4 = valueOf2;
                                        str3 = str5;
                                        valueOf2 = obj2;
                                        callbackStat(new Pair("sdk_7z", new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", obj).set("cost", valueOf2).set("cost_cpu", obj4).set("data", valueOf).set("cpu_cnt", d.a()).set("cpu_freq", d.b()).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(freeSpace))));
                                        throw th;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    obj4 = valueOf;
                                    str = str2;
                                    valueOf2 = obj3;
                                    str3 = str5;
                                    callbackStat(new Pair("sdk_7z", new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", obj).set("cost", valueOf2).set("cost_cpu", obj4).set("data", valueOf).set("cpu_cnt", d.a()).set("cpu_freq", d.b()).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(freeSpace))));
                                    throw th;
                                }
                            } catch (UCKnownException e3) {
                                e = e3;
                                f = freeSpace;
                                obj2 = obj3;
                                str = str2;
                                valueOf2 = obj4;
                                str4 = Global.APOLLO_SERIES;
                                str = String.valueOf(e.errCode());
                                throw e;
                            } catch (Throwable th7) {
                                th = th7;
                                str3 = str5;
                                str = str2;
                                valueOf2 = obj3;
                                callbackStat(new Pair("sdk_7z", new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", obj).set("cost", valueOf2).set("cost_cpu", obj4).set("data", valueOf).set("cpu_cnt", d.a()).set("cpu_freq", d.b()).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(freeSpace))));
                                throw th;
                            }
                        }
                        obj = SettingsConst.TRUE;
                        valueOf = obj4;
                        valueOf2 = obj3;
                    } catch (UCKnownException e4) {
                        e = e4;
                        f = freeSpace;
                        valueOf2 = obj4;
                        obj2 = obj3;
                        str = str4;
                        str4 = Global.APOLLO_SERIES;
                        str = String.valueOf(e.errCode());
                        throw e;
                    } catch (Throwable th8) {
                        th = th8;
                        str3 = str5;
                        valueOf2 = obj3;
                        str = str4;
                        callbackStat(new Pair("sdk_7z", new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", obj).set("cost", valueOf2).set("cost_cpu", obj4).set("data", valueOf).set("cpu_cnt", d.a()).set("cpu_freq", d.b()).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(freeSpace))));
                        throw th;
                    }
                    try {
                        String str6 = ((Context) getOption(UCCore.OPTION_CONTEXT)).getApplicationInfo().nativeLibraryDir;
                        try {
                            str6 = String.valueOf(a(new ArrayList(), file2.getAbsolutePath() + String.format("/lib/%s/", new Object[]{Build.CPU_ARCH})));
                            callbackStat(new Pair("sdk_7z", new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", obj).set("cost", valueOf2).set("cost_cpu", valueOf).set("data", str5).set("cpu_cnt", d.a()).set("cpu_freq", d.b()).set(IWaStat.KEY_LINK_SO_CODE, str6).set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(freeSpace))));
                        } catch (Throwable th9) {
                        }
                    } catch (UCKnownException e5) {
                        e = e5;
                        obj2 = valueOf2;
                        valueOf2 = valueOf;
                        f = freeSpace;
                        str4 = Global.APOLLO_SERIES;
                        str = String.valueOf(e.errCode());
                        throw e;
                    } catch (Throwable th10) {
                        th = th10;
                        obj4 = valueOf;
                        str3 = str5;
                        callbackStat(new Pair("sdk_7z", new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", obj).set("cost", valueOf2).set("cost_cpu", obj4).set("data", valueOf).set("cpu_cnt", d.a()).set("cpu_freq", d.b()).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(freeSpace))));
                        throw th;
                    }
                } catch (UCKnownException e6) {
                    e = e6;
                    valueOf2 = obj4;
                    obj2 = obj3;
                    obj = str4;
                    str4 = Global.APOLLO_SERIES;
                    str = String.valueOf(e.errCode());
                    throw e;
                } catch (Throwable th11) {
                    th = th11;
                    freeSpace = 0.0f;
                    valueOf2 = obj3;
                    str = str4;
                    str3 = str5;
                    callbackStat(new Pair("sdk_7z", new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", obj).set("cost", valueOf2).set("cost_cpu", obj4).set("data", valueOf).set("cpu_cnt", d.a()).set("cpu_freq", d.b()).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(freeSpace))));
                    throw th;
                }
            }
            if (decompressIfNeeded || UCSetupTask.getTotalLoadedUCM() == null) {
                ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) new be().invoke(10001, this)).setOptions(this.mOptions)).invoke(10002, this.mCallbacks)).setup(UCCore.OPTION_DEX_FILE_PATH, null)).setup(UCCore.OPTION_SO_FILE_PATH, null)).setup(UCCore.OPTION_RES_FILE_PATH, null)).setup(UCCore.OPTION_UCM_CFG_FILE, null)).setup(UCCore.OPTION_UCM_KRL_DIR, file2.getAbsolutePath())).onEvent("stop", new c(this))).start();
            }
            this.mCallbacks = null;
            return;
        }
        throw new UCSetupException((int) SettingsConst.SHOW_DEFAULT_CONTROLLER_MOBILE_NETWORK_PLAY_TOAST, String.format("Option [%s] or  [%s] expected.", new Object[]{UCCore.OPTION_UCM_ZIP_DIR, UCCore.OPTION_UCM_ZIP_FILE}));
    }

    private static int a(List<File> list, String str) {
        int i = 0;
        for (File file : list) {
            File file2 = new File(str + File.separator + file.getName());
            if (file.exists()) {
                try {
                    d.a(file, file2, file2, false);
                    if (!new File(str + File.separator + file.getName()).exists()) {
                        i = 4027;
                    }
                } catch (UCSetupException e) {
                    return e.errCode();
                }
            }
            i = 4026;
        }
        return i;
    }
}
