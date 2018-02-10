package com.uc.webview.browser.interfaces;

import com.uc.webview.export.annotations.Interface;

@Interface
/* compiled from: ProGuard */
public enum ResourceType {
    UNKNOWN,
    MAINRESOURCE,
    IMAGERESOURCE,
    SCRIPT,
    CSSSTYLESHEET;

    public static ResourceType fromInt(int i) {
        ResourceType[] values = values();
        if (i < 0 || i >= values.length) {
            return UNKNOWN;
        }
        return values[i];
    }
}
