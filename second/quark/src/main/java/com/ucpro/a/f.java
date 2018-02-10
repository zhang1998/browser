package com.ucpro.a;

import android.content.Context;
import com.uc.webview.browser.BrowserCore;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.UCMRunningInfo;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.utility.SetupTask;

/* compiled from: ProGuard */
class f {
    static volatile int a = 1;
    static UCSetupException b;
    private static UCMRunningInfo d;
    private static int e = 0;
    n c = this;
    private Context f;
    private String g;

    public f(Context context) {
        this.f = context;
    }

    final synchronized void a() {
        if (this.g != null) {
            UCCore.setParam(this.g);
        }
        ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) BrowserCore.setup(UCCore.OPTION_CONTEXT, this.f).setup(UCCore.OPTION_UCM_LIB_DIR, this.f.getApplicationInfo().nativeLibraryDir)).setup(UCCore.OPTION_INIT_IN_SETUP_THREAD, Boolean.valueOf(true))).setup(UCCore.OPTION_VERIFY_POLICY, Integer.valueOf(0))).setup(UCCore.OPTION_WEBVIEW_POLICY, Integer.valueOf(1))).setup(UCCore.OPTION_HARDWARE_ACCELERATED, Boolean.valueOf(true))).setup(UCCore.OPTION_SETUP_THREAD_PRIORITY, Integer.valueOf(-2))).onEvent("success", new r(this))).onEvent("exception", new e(this))).start();
        synchronized (f.class) {
            a = 2;
        }
        if (this.c != null) {
            this.c.d();
        }
    }
}
