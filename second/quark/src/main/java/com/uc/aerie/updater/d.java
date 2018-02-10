package com.uc.aerie.updater;

import android.text.TextUtils;

/* compiled from: ProGuard */
public final class d extends Exception {
    public int a;
    private String b;
    private String c;
    private String d;

    public d(String str, int i, String str2, String str3, String str4) {
        super(str, null);
        this.a = i;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        if (!TextUtils.isEmpty(getLocalizedMessage())) {
            stringBuilder.append(":");
            stringBuilder.append(getLocalizedMessage());
            stringBuilder.append("\nmoduleName: ").append(this.b).append(", ").append(this.c).append("-").append(this.d);
        }
        if (getCause() != null) {
            stringBuilder.append("\ncause by:\n");
            stringBuilder.append(getCause().toString());
        }
        return stringBuilder.toString();
    }
}
