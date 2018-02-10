package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public final class am extends UCSetupTask<am, am> {
    public final void run() {
        Context context = (Context) getOption(UCCore.OPTION_CONTEXT);
        String str = (String) getOption(UCCore.OPTION_UCM_ZIP_FILE);
        ValueCallback valueCallback = (ValueCallback) getOption("stat");
        File file = (File) UCMPackageInfo.invoke(10003, context);
        if (file.list().length <= 0 || UCMPackageInfo.checkNeedDecompress(context, file.getAbsolutePath(), str)) {
            ((k) ((k) ((k) ((k) new k().invoke(10001, this)).setup(UCCore.OPTION_CONTEXT, context)).onEvent("stat", new aq(this, valueCallback))).onEvent("success", new an(this, context, str, valueCallback))).start();
        }
    }

    public static s a(ConcurrentHashMap<String, Object> concurrentHashMap) {
        s mVar = new m();
        if (concurrentHashMap != null) {
            mVar.setOptions(concurrentHashMap);
        }
        ((s) mVar.setup(UCCore.OPTION_UCM_LIB_DIR, null)).setup(UCCore.OPTION_UCM_ZIP_DIR, null);
        return mVar;
    }
}
