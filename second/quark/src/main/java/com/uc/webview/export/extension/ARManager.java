package com.uc.webview.export.extension;

import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.extension.IARDetector.ResultListener;
import com.uc.webview.export.internal.uc.CoreFactory;

@Api
/* compiled from: ProGuard */
public abstract class ARManager implements ResultListener {
    private static ARManager a = null;

    public static ARManager getInstance() {
        if (a == null) {
            try {
                a = CoreFactory.q();
            } catch (Exception e) {
            }
        }
        return a;
    }

    public void registerARDetector(String str, String str2) {
        if (a != null) {
            a.registerARDetector(str, str2);
        }
    }
}
