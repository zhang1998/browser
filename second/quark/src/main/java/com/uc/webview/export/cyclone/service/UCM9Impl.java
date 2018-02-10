package com.uc.webview.export.cyclone.service;

import android.content.Context;
import com.uc.webview.export.cyclone.Constant;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.cyclone.UCLibrary;

@Constant
/* compiled from: ProGuard */
public class UCM9Impl {
    private static boolean mSoIsLoaded = false;
    private static UCKnownException mSoIsLoadedException = null;

    private static synchronized void loadSo(Context context) {
        synchronized (UCM9Impl.class) {
            if (!mSoIsLoaded) {
                if (mSoIsLoadedException != null) {
                    throw mSoIsLoadedException;
                }
                try {
                    UCLibrary.load(context, UCCyclone.genFile(context, null, "libm9codec", ".so", 24869030, "844be42f7bfce3332b23a965dd831ab1", UCM9ImplConstant.genCodes(), new Object[0]).getAbsolutePath(), null);
                    mSoIsLoaded = true;
                } catch (Throwable th) {
                    mSoIsLoadedException = new UCKnownException(th);
                }
            }
        }
    }
}
