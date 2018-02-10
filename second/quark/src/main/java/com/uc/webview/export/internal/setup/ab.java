package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.uc.webview.export.Build;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.UCAsyncTask.a;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public final class ab extends s {
    public final void run() {
        Context context = (Context) getOption(UCCore.OPTION_CONTEXT);
        if (((File) UCMPackageInfo.invoke(10006, context)).list().length > 0) {
            int i = 1;
        } else {
            boolean z = false;
        }
        File expectFile = UCCyclone.expectFile(context.getPackageResourcePath());
        r5 = new Object[2];
        r5[0] = (File) UCMPackageInfo.invoke(10006, context);
        r5[1] = UCCyclone.getSourceHash(expectFile.getAbsolutePath());
        File file = (File) UCMPackageInfo.invoke(UCMPackageInfo.expectCreateDirFile2P, (File) UCMPackageInfo.invoke(UCMPackageInfo.expectCreateDirFile2P, r5), UCCyclone.getSourceHash(expectFile.length(), expectFile.lastModified()));
        boolean decompressIfNeeded = UCCyclone.decompressIfNeeded(context, false, expectFile, file, new ac(this), false);
        ConcurrentHashMap concurrentHashMap = this.mCallbacks;
        this.mCallbacks = null;
        String format = String.format("/lib/%s/libkernelu4_uc_7z.so", new Object[]{Build.CPU_ARCH});
        s sVar = (s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) new m().invoke(10001, this)).setOptions(this.mOptions)).invoke(10002, concurrentHashMap)).setup(UCCore.OPTION_DEX_FILE_PATH, null)).setup(UCCore.OPTION_SO_FILE_PATH, null)).setup(UCCore.OPTION_RES_FILE_PATH, null)).setup(UCCore.OPTION_UCM_CFG_FILE, null)).setup(UCCore.OPTION_UCM_KRL_DIR, null)).setup(UCCore.OPTION_UCM_ZIP_FILE, file.getAbsolutePath() + format);
        if (!decompressIfNeeded || r6 == 0) {
            sVar.onEvent("start", new a(this));
        } else {
            resetCrashFlag();
        }
        sVar.start();
    }
}
