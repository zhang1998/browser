package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWaStat.WaStat;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.d;
import com.uc.webview.export.utility.download.UpdateTask;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: ProGuard */
public final class n extends UCSubSetupTask<n, n> {
    private List<at> a;

    public n(List<at> list) {
        this.a = list;
    }

    public final void run() {
        Object obj;
        String[] strArr;
        Log.d("DeleteCoreTask", "======deleteSo=====");
        Context context = (Context) getOption(UCCore.OPTION_CONTEXT);
        String[] strArr2 = new String[]{"libWebCore_UC.so", "libV8_UC.so", "libandroid_uc_40.so", "libandroid_uc_41.so", "libandroid_uc_42.so", "libandroid_uc_43.so", "libandroid_uc_44.so", "libandroid_uc_50.so", "libskia_neon_uc.so", "libwebviewuc.so", "libimagehelper.so", "libvinit.so", "libInitHelper_UC.so", "libcrashsdk.so"};
        Object obj2 = null;
        for (at atVar : this.a) {
            String str;
            Object obj3;
            String str2;
            String str3 = null;
            String str4 = null;
            UCMPackageInfo uCMPackageInfo = null;
            ClassLoader classLoader = null;
            if ((atVar instanceof bc) && atVar.a == null) {
                str4 = (String) this.mOptions.get(UCCore.OPTION_SO_FILE_PATH);
                str = (String) this.mOptions.get(UCCore.OPTION_RES_FILE_PATH);
                obj3 = 1;
            } else {
                str = null;
                obj3 = null;
            }
            if (atVar.a == null || atVar.a.mUCM == null) {
                str2 = str4;
            } else {
                UCMPackageInfo uCMPackageInfo2 = atVar.a.mUCM;
                String str5 = uCMPackageInfo2.dataDir;
                String str6 = uCMPackageInfo2.soDirPath;
                str4 = uCMPackageInfo2.resDirPath;
                str3 = str5;
                uCMPackageInfo = atVar.a.mUCM;
                str = str4;
                String str7 = str6;
                classLoader = atVar.a.mShellCL;
                str2 = str7;
            }
            if (str2 == null || !str2.equals(context.getApplicationInfo().nativeLibraryDir)) {
                str4 = str2;
            } else {
                str4 = null;
            }
            str = UCCyclone.getSourceHash(str3 + "_" + str4 + "_" + str);
            r13 = new Object[2];
            r13[0] = UCMPackageInfo.invoke(10005, context);
            r13[1] = "delcore";
            File file = (File) UCMPackageInfo.invoke(UCMPackageInfo.expectCreateDirFile2P, r13);
            File file2 = new File(file, str + "_1");
            File file3 = new File(file, str + "_2");
            File file4 = new File(file, str + "_3");
            if (file4.exists()) {
                Log.d("DeleteCoreTask", "Skip delete UC files (over 3 times).");
                break;
            }
            if (!d.a(str3)) {
                if (str3.startsWith(((File) UCMPackageInfo.invoke(10001, context)).getAbsolutePath())) {
                    if (new File(str3).exists()) {
                        File parentFile;
                        UCMRunningInfo totalLoadedUCM = UCSetupTask.getTotalLoadedUCM();
                        file = (totalLoadedUCM.ucmPackageInfo == null || totalLoadedUCM.ucmPackageInfo.dataDir == null) ? null : new File(totalLoadedUCM.ucmPackageInfo.dataDir);
                        UCMPackageInfo.invoke(UCMPackageInfo.deleteUCMSDKDir, context, parentFile, file);
                        return;
                    }
                    return;
                }
            }
            if (d.a(str4)) {
                obj = obj2;
            } else {
                File file5;
                parentFile = new File(str4).getParentFile();
                try {
                    File file6 = new File(parentFile, UpdateTask.STOP_FLG_FILE_NAME);
                    File file7 = new File(parentFile, UpdateTask.START_FLG_FILE_NAME);
                    if (file6.exists() && file6.isFile() && file6.length() == 0) {
                        file6.delete();
                    }
                    if (file7.exists() && file7.isFile() && file7.length() == 0) {
                        file7.delete();
                    }
                } catch (Throwable th) {
                }
                try {
                    for (File file8 : parentFile.listFiles()) {
                        String name = file8.getName();
                        File parentFile2 = file8.getParentFile();
                        if (name.startsWith(parentFile2.getParentFile().getName() + "_" + parentFile2.getName()) && file8.isFile() && file8.length() == 0) {
                            file8.delete();
                        }
                    }
                } catch (Throwable th2) {
                    Log.w("DeleteCoreTask", "delete flag:", th2);
                }
                String[] strArr3 = null;
                if (classLoader != null) {
                    try {
                        String[][] strArr4;
                        Class cls = Class.forName("com.uc.webview.browser.shell.NativeLibraries", true, classLoader);
                        if (cls != null) {
                            Field declaredField = cls.getDeclaredField("LIBRARIES");
                            declaredField.setAccessible(true);
                            strArr4 = (String[][]) declaredField.get(null);
                        } else {
                            strArr4 = null;
                        }
                        if (strArr4 != null && strArr4.length > 0) {
                            strArr = new String[strArr4.length];
                            int i = 0;
                            while (i < strArr.length) {
                                try {
                                    strArr[i] = strArr4[i][0];
                                    i++;
                                } catch (Throwable th3) {
                                    strArr3 = strArr;
                                }
                            }
                            if (strArr == null) {
                                strArr = strArr2;
                            }
                            for (String file9 : r4) {
                                try {
                                    file5 = new File(str4, file9);
                                    if (file5.exists()) {
                                        file5.delete();
                                    }
                                    Log.d("DeleteCoreTask", "deleteSo:" + file5);
                                } catch (Throwable th4) {
                                    Log.w("DeleteCoreTask", "deleteSo:", th4);
                                }
                            }
                            obj = 1;
                        }
                    } catch (Throwable th5) {
                        strArr = strArr3;
                        if (strArr == null) {
                            strArr = strArr2;
                        }
                        while (r9 < r11) {
                            file5 = new File(str4, file9);
                            if (file5.exists()) {
                                file5.delete();
                            }
                            Log.d("DeleteCoreTask", "deleteSo:" + file5);
                        }
                        obj = 1;
                        if (obj3 == null) {
                            try {
                                new File((String) uCMPackageInfo.coreImplModule.first).delete();
                                Log.d("DeleteCoreTask", "delete dex:" + ((String) uCMPackageInfo.coreImplModule.first));
                            } catch (Throwable th22) {
                                Log.w("DeleteCoreTask", "deleteSo:", th22);
                            }
                            try {
                                new File((String) uCMPackageInfo.browserIFModule.first).delete();
                                Log.d("DeleteCoreTask", "delete dex:" + ((String) uCMPackageInfo.browserIFModule.first));
                            } catch (Throwable th222) {
                                Log.w("DeleteCoreTask", "deleteSo:", th222);
                            }
                            try {
                                new File((String) uCMPackageInfo.sdkShellModule.first).delete();
                                Log.d("DeleteCoreTask", "delete dex:" + ((String) uCMPackageInfo.sdkShellModule.first));
                            } catch (Throwable th2222) {
                                Log.w("DeleteCoreTask", "deleteSo:", th2222);
                            }
                            try {
                                new File((String) uCMPackageInfo.coreImplModule.second, "dex.dex").delete();
                                Log.d("DeleteCoreTask", "delete odex:" + ((String) uCMPackageInfo.coreImplModule.first));
                            } catch (Throwable th22222) {
                                Log.w("DeleteCoreTask", "deleteSo:", th22222);
                            }
                            try {
                                new File((String) uCMPackageInfo.browserIFModule.second, "browser_if.dex").delete();
                                Log.d("DeleteCoreTask", "delete odex:" + ((String) uCMPackageInfo.browserIFModule.first));
                            } catch (Throwable th222222) {
                                Log.w("DeleteCoreTask", "deleteSo:", th222222);
                            }
                            try {
                                new File((String) uCMPackageInfo.sdkShellModule.second, "sdk_shell.dex").delete();
                                Log.d("DeleteCoreTask", "delete odex:" + ((String) uCMPackageInfo.sdkShellModule.first));
                            } catch (Throwable th2222222) {
                                Log.w("DeleteCoreTask", "deleteSo:", th2222222);
                            }
                            obj = 1;
                        }
                        Log.d("DeleteCoreTask", "deleteCoreFlagDir:" + file);
                        if (!file2.exists()) {
                            file2.createNewFile();
                            obj2 = obj;
                        } else if (file3.exists()) {
                            if (!file4.exists()) {
                                file4.createNewFile();
                            }
                            obj2 = obj;
                        } else {
                            file3.createNewFile();
                            obj2 = obj;
                        }
                    }
                }
                strArr = null;
                if (strArr == null) {
                    strArr = strArr2;
                }
                while (r9 < r11) {
                    file5 = new File(str4, file9);
                    if (file5.exists()) {
                        file5.delete();
                    }
                    Log.d("DeleteCoreTask", "deleteSo:" + file5);
                }
                obj = 1;
            }
            if (obj3 == null) {
                new File((String) uCMPackageInfo.coreImplModule.first).delete();
                Log.d("DeleteCoreTask", "delete dex:" + ((String) uCMPackageInfo.coreImplModule.first));
                new File((String) uCMPackageInfo.browserIFModule.first).delete();
                Log.d("DeleteCoreTask", "delete dex:" + ((String) uCMPackageInfo.browserIFModule.first));
                new File((String) uCMPackageInfo.sdkShellModule.first).delete();
                Log.d("DeleteCoreTask", "delete dex:" + ((String) uCMPackageInfo.sdkShellModule.first));
                new File((String) uCMPackageInfo.coreImplModule.second, "dex.dex").delete();
                Log.d("DeleteCoreTask", "delete odex:" + ((String) uCMPackageInfo.coreImplModule.first));
                new File((String) uCMPackageInfo.browserIFModule.second, "browser_if.dex").delete();
                Log.d("DeleteCoreTask", "delete odex:" + ((String) uCMPackageInfo.browserIFModule.first));
                new File((String) uCMPackageInfo.sdkShellModule.second, "sdk_shell.dex").delete();
                Log.d("DeleteCoreTask", "delete odex:" + ((String) uCMPackageInfo.sdkShellModule.first));
                obj = 1;
            }
            try {
                Log.d("DeleteCoreTask", "deleteCoreFlagDir:" + file);
                if (!file2.exists()) {
                    file2.createNewFile();
                    obj2 = obj;
                } else if (file3.exists()) {
                    file3.createNewFile();
                    obj2 = obj;
                } else {
                    if (file4.exists()) {
                        file4.createNewFile();
                    }
                    obj2 = obj;
                }
            } catch (Throwable th6) {
                Log.w("DeleteCoreTask", "deleteCoreFlag:", th6);
                obj2 = obj;
            }
        }
        this.a.clear();
        if (obj2 != null) {
            WaStat.stat(IWaStat.SETUP_DELETE_CORE_COUNT);
        }
    }
}
