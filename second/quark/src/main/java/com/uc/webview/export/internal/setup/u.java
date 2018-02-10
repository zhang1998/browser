package com.uc.webview.export.internal.setup;

import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.uc.CoreClassPreLoader;

/* compiled from: ProGuard */
public final class u<RETURN_TYPE extends u<RETURN_TYPE, CALLBACK_TYPE>, CALLBACK_TYPE extends u<RETURN_TYPE, CALLBACK_TYPE>> extends UCSubSetupTask<RETURN_TYPE, CALLBACK_TYPE> {
    private static UCAsyncTask a;
    private static int b;

    public final /* synthetic */ UCAsyncTask start() {
        return b();
    }

    private static synchronized UCAsyncTask a() {
        UCAsyncTask uCAsyncTask;
        synchronized (u.class) {
            if (a == null) {
                a = new x(Integer.valueOf(b)).onEvent("start", new w()).onEvent("die", new v());
            }
            uCAsyncTask = a;
        }
        return uCAsyncTask;
    }

    private synchronized RETURN_TYPE b() {
        RETURN_TYPE return_type;
        if (invokeO(10005, new Object[0]) == null) {
            Integer num = (Integer) this.mOptions.get(UCCore.OPTION_SETUP_THREAD_PRIORITY);
            UCLogger create = UCLogger.create("d", "LoadClassTask");
            if (create != null) {
                create.print("start: setup_priority=" + num, new Throwable[0]);
            }
            if (num != null) {
                b = num.intValue();
            }
            invoke(10001, a());
            return_type = (u) super.start();
            r1.start();
        } else {
            u uVar = (u) super.start();
        }
        return return_type;
    }

    public final void run() {
        CoreClassPreLoader.updateLazy(this.mCL);
        CoreClassPreLoader.loadCoreClass(this.mUCM.mCoreClassLoader);
    }
}
