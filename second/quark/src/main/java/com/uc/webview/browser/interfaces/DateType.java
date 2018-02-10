package com.uc.webview.browser.interfaces;

import com.uc.webview.export.annotations.Interface;

@Interface
/* compiled from: ProGuard */
public enum DateType {
    INVALID,
    DATE,
    DATETIME,
    LOCAL,
    MONTH,
    TIME,
    WEEK;

    public static DateType index2DateType(int i) {
        DateType[] values = values();
        if (i < 0 || i >= values.length) {
            return INVALID;
        }
        return values[i];
    }
}
