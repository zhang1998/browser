package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.util.Pair;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.cyclone.UCLoader;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.d;
import com.uc.webview.export.utility.SetupTask;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: ProGuard */
public class bd extends p {
    public void run() {
        UCSetupException uCSetupException;
        Context context = (Context) this.mOptions.get(UCCore.OPTION_CONTEXT);
        boolean z = SDKFactory.r;
        String str = (String) this.mOptions.get("scanUcmPrefix");
        UCElapseTime uCElapseTime = new UCElapseTime();
        List listFromSharedApps;
        if (str != null) {
            listFromSharedApps = UCMPackageInfo.listFromSharedApps(context, this.mOptions);
        } else {
            listFromSharedApps = UCMPackageInfo.a(context, this.mOptions);
        }
        Log.e("ThinEnvTask", "UCMPackageInfo listUCMS:" + String.valueOf(uCElapseTime.getMilis()));
        if (r4.size() > 0) {
            Integer num = (Integer) this.mOptions.get(UCCore.OPTION_VERIFY_POLICY);
            Object obj = !d.a((Boolean) this.mOptions.get("chkDecFinish")) ? 1 : null;
            boolean z2 = !d.a((Boolean) this.mOptions.get(UCCore.OPTION_USE_SDK_SETUP));
            String str2 = (String) this.mOptions.get(UCCore.OPTION_CORE_VERSION_EXCLUDE);
            String str3 = (String) this.mOptions.get(UCCore.OPTION_SDK_VERSION_EXCLUDE);
            ClassLoader classLoader = bd.class.getClassLoader();
            uCSetupException = null;
            for (UCMPackageInfo uCMPackageInfo : r4) {
                try {
                    this.mUCM = uCMPackageInfo;
                    if (obj == null || UCCyclone.isDecompressFinished(new File(uCMPackageInfo.dataDir))) {
                        UCElapseTime a;
                        String str4;
                        boolean z3;
                        String str5;
                        String str6;
                        a(uCMPackageInfo);
                        boolean a2 = a(context, uCMPackageInfo);
                        Object obj2 = !UCCyclone.optimizedFileFor((String) uCMPackageInfo.coreImplModule.first, (String) uCMPackageInfo.coreImplModule.second).exists() ? 1 : null;
                        a(uCMPackageInfo, a2, z2);
                        if (SetupTask.sFirstUCM == null) {
                            SetupTask.sFirstUCM = uCMPackageInfo;
                        }
                        long j = 0;
                        long j2 = 0;
                        if (!(num == null || (num.intValue() & 1) == 0)) {
                            a = p.a(context, num, (String) uCMPackageInfo.sdkShellModule.first);
                            j2 = a.getMilisCpu() + 0;
                            j = 0 + a.getMilis();
                        }
                        UCElapseTime uCElapseTime2 = new UCElapseTime();
                        ClassLoader uCLoader = new UCLoader((String) uCMPackageInfo.sdkShellModule.first, (String) uCMPackageInfo.sdkShellModule.second, uCMPackageInfo.soDirPath, classLoader);
                        long milisCpu = uCElapseTime2.getMilisCpu() + 0;
                        long milis = 0 + uCElapseTime2.getMilis();
                        uCMPackageInfo.mSdkShellClassLoader = uCLoader;
                        this.mShellCL = uCLoader;
                        if (z2) {
                            if (!z) {
                                str4 = (String) Class.forName("com.uc.webview.browser.shell.Build", false, uCLoader).getField("TYPE").get(null);
                                if (!(uCMPackageInfo.isSpecified || str4.toLowerCase().startsWith("ucrelease") || str4.toLowerCase().startsWith("ucpatch"))) {
                                    throw new UCSetupException(4011, String.format("ucrelease or ucpatch is expected but get [%s] to shared UCM.", new Object[]{str4}));
                                }
                            }
                            p.a(str2, uCLoader, "com.uc.webview.browser.shell.Build", "CORE_VERSION");
                            p.a(str3, uCLoader, "com.uc.webview.browser.shell.Build$Version", "NAME");
                            a(uCMPackageInfo, context, uCLoader);
                            if (!(num == null || (num.intValue() & 2) == 0)) {
                                a = p.a(context, num, (String) uCMPackageInfo.browserIFModule.first);
                                j2 += a.getMilisCpu();
                                j += a.getMilis();
                            }
                        }
                        if (!(num == null || (num.intValue() & 8) == 0)) {
                            a = new UCElapseTime();
                            a(uCMPackageInfo, context, uCLoader, num.intValue());
                            j2 += a.getMilisCpu();
                            j += a.getMilis();
                        }
                        if (!(num == null || (num.intValue() & 4) == 0)) {
                            a = p.a(context, num, (String) uCMPackageInfo.coreImplModule.first);
                            j2 += a.getMilisCpu();
                            j += a.getMilis();
                        }
                        UCElapseTime uCElapseTime3 = new UCElapseTime();
                        StringBuilder stringBuilder = new StringBuilder();
                        str4 = (!z2 || uCMPackageInfo.browserIFModule.first == null) ? "" : ((String) uCMPackageInfo.browserIFModule.first) + ":";
                        uCLoader = new UCLoader(stringBuilder.append(str4).append((String) uCMPackageInfo.coreImplModule.first).toString(), (String) uCMPackageInfo.coreImplModule.second, uCMPackageInfo.soDirPath, classLoader);
                        long milisCpu2 = uCElapseTime3.getMilisCpu() + milisCpu;
                        milisCpu = milis + uCElapseTime3.getMilis();
                        uCMPackageInfo.mCoreClassLoader = uCLoader;
                        this.mCL = uCLoader;
                        this.a = a2;
                        if (obj2 != null || milisCpu >= 1000) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        this.b = z3;
                        str4 = IWaStat.SETUP_TASK_VERIFY;
                        boolean z4 = this.b;
                        if (z2) {
                            str5 = "sdk";
                        } else {
                            str5 = "ucm";
                        }
                        a(str4, z4, num, str5, j, j2);
                        String str7 = IWaStat.SETUP_TASK_DEXOPT;
                        boolean z5 = this.b;
                        Integer valueOf = Integer.valueOf(0);
                        if (z2) {
                            str6 = "sdk";
                        } else {
                            str6 = "ucm";
                        }
                        a(str7, z5, valueOf, str6, milisCpu, milisCpu2);
                        Log.e("ThinEnvTask", "tryEnv Time: VERIFY:" + String.valueOf(j) + " DEXOPT:" + String.valueOf(milisCpu));
                        callbackStat(new Pair(IWaStat.SETUP_SUCCESS_SETUPED, null));
                    } else {
                        throw new UCSetupException(2007, String.format("Package [%s] decompress not finished.", new Object[]{uCMPackageInfo.dataDir}));
                    }
                } catch (Throwable e) {
                    throw new UCSetupException(4012, e);
                } catch (UCSetupException e2) {
                    uCSetupException = e2;
                } catch (Throwable e3) {
                    uCSetupException = new UCSetupException((int) SettingsConst.RESTORE_HISTORY_PLAY_POSITION, e3);
                }
            }
        } else {
            uCSetupException = null;
        }
        if (this.mCL == null || this.mUCM == null) {
            if (uCSetupException == null) {
                UCSetupException uCSetupException2 = new UCSetupException((int) SettingsConst.ENABLE_FULL_SCREEN, "UCM packages not found.");
            }
            throw uCSetupException;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        File file = (File) UCMPackageInfo.invoke(10003, context);
        if (str.startsWith(file.getAbsolutePath())) {
            File file2 = new File(str2);
            if (!str.startsWith(new File(new File(file, UCCyclone.getSourceHash(file2.getAbsolutePath())), UCCyclone.getSourceHash(file2.length(), file2.lastModified())).getAbsolutePath())) {
                return true;
            }
        }
        return false;
    }

    private boolean a(Context context, UCMPackageInfo uCMPackageInfo) {
        String str = (String) getOption(UCCore.OPTION_UCM_ZIP_FILE);
        if (!d.a(uCMPackageInfo.dataDir)) {
            if (!d.a(str)) {
                return a(context, uCMPackageInfo.dataDir, str);
            }
            str = (String) getOption(UCCore.OPTION_UCM_UPD_URL);
            if (!d.a(str)) {
                File file = (File) UCMPackageInfo.invoke(10002, context);
                if (uCMPackageInfo.dataDir.startsWith(file.getAbsolutePath())) {
                    File file2 = new File(file, UCCyclone.getSourceHash(str));
                    if (!uCMPackageInfo.dataDir.startsWith(file2.getAbsolutePath())) {
                        return true;
                    }
                    if (!SDKFactory.l) {
                        return false;
                    }
                    try {
                        if (!((Boolean) ((Callable) getOption(UCCore.OPTION_DOWNLOAD_CHECKER)).call()).booleanValue()) {
                            return false;
                        }
                        Pair a = d.a(str, null);
                        if (!uCMPackageInfo.dataDir.startsWith(new File(file2, UCCyclone.getSourceHash(((Long) a.first).longValue(), ((Long) a.second).longValue())).getAbsolutePath())) {
                            return true;
                        }
                    } catch (Throwable th) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
