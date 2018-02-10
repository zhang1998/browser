package com.uc.webview.export.extension;

import android.content.Context;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.setup.bu;
import com.uc.webview.export.internal.setup.s;
import com.uc.webview.export.internal.utility.d;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

/* compiled from: ProGuard */
final class a extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ Map b;
    final /* synthetic */ Callable c;
    final /* synthetic */ String d;
    final /* synthetic */ Map e;

    a(Context context, Map map, Callable callable, String str, Map map2) {
        this.a = context;
        this.b = map;
        this.c = callable;
        this.d = str;
        this.e = map2;
    }

    public final void run() {
        int i = 10;
        while (!((Boolean) SDKFactory.invoke(10010, new Object[0])).booleanValue() && !SDKFactory.p) {
            int i2 = i - 1;
            if (i <= 0) {
                i = i2;
                break;
            }
            try {
                Thread.sleep(200);
                i = i2;
            } catch (Exception e) {
                i = i2;
            }
        }
        if (i <= 0) {
            throw new UCSetupException("Waiting timeout for UCCore initialization finish!");
        }
        try {
            UCAsyncTask uCAsyncTask = new UCAsyncTask(Integer.valueOf(0));
            bu buVar = new bu();
            ((s) ((s) ((s) ((s) ((s) ((s) ((s) buVar.setup(UCCore.OPTION_CONTEXT, this.a.getApplicationContext())).invoke(10001, uCAsyncTask)).setup(UCCore.OPTION_UCM_ZIP_DIR, null)).setup(UCCore.OPTION_UCM_ZIP_FILE, null)).setup(UCCore.OPTION_USE_SDK_SETUP, Boolean.valueOf(true))).setup("chkMultiCore", Boolean.valueOf(true))).onEvent("downloadException", new c(this))).onEvent("updateProgress", new b(this));
            if (this.c != null) {
                buVar.setup(UCCore.OPTION_DOWNLOAD_CHECKER, this.c);
            }
            if (!d.a(this.d)) {
                buVar.setup(UCCore.OPTION_UCM_UPD_URL, this.d);
            }
            if (!(this.e == null || this.e.isEmpty())) {
                for (Entry entry : this.e.entrySet()) {
                    buVar.setup((String) entry.getKey(), entry.getValue());
                }
            }
            buVar.start(2000);
            uCAsyncTask.start();
        } catch (Throwable th) {
        }
    }
}
