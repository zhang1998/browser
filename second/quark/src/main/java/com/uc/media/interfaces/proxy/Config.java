package com.uc.media.interfaces.proxy;

import com.uc.webview.export.annotations.Reflection;

@Reflection
/* compiled from: ProGuard */
public final class Config {
    private static Switch mSwitch = Switch.CDKEY;

    @Reflection
    /* compiled from: ProGuard */
    public enum Switch {
        CDKEY,
        ALL_OFF,
        ALL_ON,
        CACHE_DISABLE
    }

    public static void setSwitch(Switch switchR) {
        mSwitch = switchR;
    }

    public static Switch getSwitch() {
        return mSwitch;
    }

    private Config() {
    }
}
