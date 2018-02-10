package com.uc.aerie.updater;

import android.text.TextUtils;

/* compiled from: ProGuard */
public final class h extends Exception {
    public int a;

    public h(String str, int i) {
        super(str, null);
        this.a = i;
    }

    public h(String str, int i, Throwable th) {
        super(str, th);
        this.a = i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        if (!TextUtils.isEmpty(getLocalizedMessage())) {
            stringBuilder.append(":");
            stringBuilder.append(getLocalizedMessage());
        }
        if (getCause() != null) {
            stringBuilder.append("\ncause by:\n");
            stringBuilder.append(getCause().toString());
        }
        return stringBuilder.toString();
    }
}
