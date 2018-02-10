package com.uc.webview.browser.interfaces;

import com.uc.webview.export.annotations.Interface;

@Deprecated
@Interface
/* compiled from: ProGuard */
public abstract class IPlatformInfo {
    private static IPlatformInfo a = null;

    public abstract boolean platformGetBool(String str);

    public abstract double platformGetDouble(String str);

    public abstract int platformGetInt(String str);

    public abstract String platformGetString(String str);

    public abstract void platformSetBool(String str, boolean z);

    public abstract void platformSetDouble(String str, double d);

    public abstract void platformSetInt(String str, int i);

    public abstract void platformString(String str, String str2);

    public static void setInstance(IPlatformInfo iPlatformInfo) {
        a = iPlatformInfo;
    }

    public static IPlatformInfo getInstance() {
        return a;
    }
}
