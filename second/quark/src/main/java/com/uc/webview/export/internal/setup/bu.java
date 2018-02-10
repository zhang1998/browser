package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.UCAsyncTask.c;
import com.uc.webview.export.internal.utility.d;
import com.uc.webview.export.utility.download.UpdateTask;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: ProGuard */
public final class bu extends s {
    public UpdateTask a = null;

    public final void run() {
        Context context = (Context) getOption(UCCore.OPTION_CONTEXT);
        String str = (String) getOption(UCCore.OPTION_UCM_UPD_URL);
        Boolean bool = (Boolean) getOption("chkMultiCore");
        Callable callable = (Callable) getOption(UCCore.OPTION_DOWNLOAD_CHECKER);
        int createToken = UCLogger.createToken("i", "UpdateSetupTask");
        if (d.a(str)) {
            throw new UCSetupException(3014, String.format("Option [%s] expected.", new Object[]{UCCore.OPTION_UCM_UPD_URL}));
        }
        long j;
        bf bfVar = new bf();
        Object option = getOption(UCCore.OPTION_UPD_SETUP_TASK_WAIT_MILIS);
        if (option == null) {
            j = 7200000;
        } else if (option instanceof Long) {
            j = ((Long) option).longValue();
        } else if (option instanceof Integer) {
            j = ((Integer) option).longValue();
        } else {
            j = Long.parseLong(String.valueOf(option));
        }
        Long valueOf = Long.valueOf(j);
        UCLogger.print(createToken, "run:update from [" + str + "]", new Throwable[0]);
        synchronized (bfVar) {
            Long l;
            Long l2;
            File file = (File) UCMPackageInfo.invoke(10002, context);
            option = getOption(UCCore.OPTION_DWN_RETRY_WAIT_MILIS);
            if (option == null) {
                l = null;
            } else {
                j = option instanceof Long ? ((Long) option).longValue() : option instanceof Integer ? ((Integer) option).longValue() : Long.parseLong(String.valueOf(option));
                l = Long.valueOf(j);
            }
            option = getOption(UCCore.OPTION_DWN_RETRY_MAX_WAIT_MILIS);
            if (option == null) {
                l2 = null;
            } else {
                j = option instanceof Long ? ((Long) option).longValue() : option instanceof Integer ? ((Integer) option).longValue() : Long.parseLong(String.valueOf(option));
                l2 = Long.valueOf(j);
            }
            this.a = new UpdateTask(context, str, file.getAbsolutePath(), "core.jar", null, l, l2);
            this.a.onEvent("check", new ce(this, context, callable)).onEvent("exception", new cc(this)).onEvent("downloadException", new cb(this)).onEvent("success", new ca(this, bfVar)).onEvent("failed", new bz(this, bfVar)).onEvent("exists", new by(this, bfVar)).onEvent("progress", new bx(this)).start();
            Pair a = bfVar.a(valueOf.longValue());
        }
        if (((Integer) a.first).intValue() == 1) {
            throw new UCSetupException(4010, String.format("Thread [%s] waitting for update is up to [%s] milis.", new Object[]{Thread.currentThread().getName(), String.valueOf(valueOf)}));
        } else if (((Integer) a.first).intValue() == 3) {
            throw new UCSetupException(4019, (Exception) a.second);
        } else {
            Object obj;
            Object obj2 = ((Integer) a.first).intValue() == 0 ? 1 : null;
            if (obj2 != null || ((Integer) a.first).intValue() == 4) {
                obj = 1;
            } else {
                obj = null;
            }
            file = this.a.getUpdateDir();
            Boolean bool2 = (Boolean) getOption(UCCore.OPTION_NOT_SWITCH_UCCORE);
            if (bool2 != null && bool2.booleanValue()) {
                obj = null;
            }
            if (obj == null) {
                return;
            }
            if (obj2 != null || UCSetupTask.getTotalLoadedUCM() == null) {
                ValueCallback valueCallback;
                s sVar = (s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) ((s) new be().invoke(10001, this)).setOptions(this.mOptions)).invoke(10002, this.mCallbacks)).setup(UCCore.OPTION_DEX_FILE_PATH, null)).setup(UCCore.OPTION_SO_FILE_PATH, null)).setup(UCCore.OPTION_RES_FILE_PATH, null)).setup(UCCore.OPTION_UCM_CFG_FILE, null)).setup(UCCore.OPTION_UCM_LIB_DIR, null)).setup(UCCore.OPTION_UCM_ZIP_DIR, null)).setup(UCCore.OPTION_UCM_ZIP_FILE, null)).setup(UCCore.OPTION_UCM_KRL_DIR, file.getAbsolutePath())).onEvent("switch", new bw(this))).onEvent("stop", new c(this));
                str = "setup";
                if (d.a(bool)) {
                    valueCallback = null;
                } else {
                    valueCallback = new bv(this);
                }
                ((s) sVar.onEvent(str, valueCallback)).start();
            }
        }
    }
}
