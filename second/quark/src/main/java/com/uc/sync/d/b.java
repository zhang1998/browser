package com.uc.sync.d;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: ProGuard */
public final class b {
    private long a = System.currentTimeMillis();
    private String b;
    private String c;

    public b(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new SimpleDateFormat("MM-dd KK:mm:ss", Locale.CHINA).format(Long.valueOf(this.a)));
        stringBuilder.append("\t");
        stringBuilder.append(this.b);
        stringBuilder.append("\t");
        stringBuilder.append(this.c);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
