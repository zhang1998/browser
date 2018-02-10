package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.utility.d;
import java.io.File;

/* compiled from: ProGuard */
public final class o extends UCSubSetupTask<o, o> {
    public final void run() {
        Object obj = null;
        try {
            UCMRunningInfo totalLoadedUCM = UCSetupTask.getTotalLoadedUCM();
            if (totalLoadedUCM.coreType != 2) {
                boolean z;
                File file;
                Context context = (Context) getOption(UCCore.OPTION_CONTEXT);
                Boolean valueOf = Boolean.valueOf(!d.a((Boolean) getOption("del_dec_fil")));
                if (d.a((Boolean) getOption("del_upd_fil"))) {
                    z = false;
                } else {
                    z = true;
                }
                Boolean valueOf2 = Boolean.valueOf(z);
                try {
                    UCCyclone.deleteUnusedFiles(context);
                } catch (Throwable th) {
                }
                try {
                    UCMPackageInfo.invoke(UCMPackageInfo.deleteTempDecFiles, context);
                } catch (Throwable th2) {
                }
                try {
                    Object obj2;
                    if (totalLoadedUCM.ucmPackageInfo == null || totalLoadedUCM.ucmPackageInfo.coreImplModule == null || totalLoadedUCM.ucmPackageInfo.coreImplModule.second == null) {
                        obj2 = null;
                    } else {
                        obj2 = new File((String) totalLoadedUCM.ucmPackageInfo.coreImplModule.second);
                    }
                    UCCyclone.recursiveDelete((File) UCMPackageInfo.invoke(10004, context), true, obj2);
                } catch (Throwable th3) {
                }
                File file2 = (totalLoadedUCM.ucmPackageInfo == null || totalLoadedUCM.ucmPackageInfo.dataDir == null) ? null : new File(totalLoadedUCM.ucmPackageInfo.dataDir);
                try {
                    file = (File) UCMPackageInfo.invoke(10003, context);
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0 && (valueOf.booleanValue() || listFiles.length >= 2 || (file2 != null && file2.getAbsolutePath().startsWith(file.getAbsolutePath())))) {
                        listFiles = file.listFiles();
                        if (listFiles != null) {
                            for (Object obj3 : listFiles) {
                                UCMPackageInfo.invoke(UCMPackageInfo.deleteUCMSDKDir, context, obj3, file2);
                            }
                        }
                    }
                } catch (Throwable th4) {
                }
                try {
                    file = (File) UCMPackageInfo.invoke(10006, context);
                    if (file2 != null) {
                        obj = file2.getParentFile().getParentFile();
                    }
                    UCCyclone.recursiveDelete(file, true, obj);
                } catch (Throwable th5) {
                }
                try {
                    file = (File) UCMPackageInfo.invoke(10002, context);
                    File[] listFiles2 = file.listFiles();
                    if (listFiles2 != null && listFiles2.length > 0 && (valueOf2.booleanValue() || listFiles2.length >= 2 || (file2 != null && file2.getAbsolutePath().startsWith(file.getAbsolutePath())))) {
                        listFiles2 = file.listFiles();
                        if (listFiles2 != null) {
                            for (Object obj4 : listFiles2) {
                                UCMPackageInfo.invoke(UCMPackageInfo.deleteUCMSDKDir, context, obj4, file2);
                            }
                        }
                    }
                } catch (Throwable th6) {
                }
                k.b(context);
            }
        } catch (Throwable th7) {
        }
    }
}
