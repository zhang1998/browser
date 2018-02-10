package com.loc;

import android.content.Context;

/* compiled from: ProGuard */
public final class br {
    Context a;
    ep b;
    String c;

    public br(Context context, ep epVar, String str) {
        this.a = context.getApplicationContext();
        this.b = epVar;
        this.c = str;
    }

    static String a(Context context, ep epVar, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("\"sdkversion\":\"").append(epVar.b()).append("\",\"product\":\"").append(epVar.a()).append("\",\"nt\":\"").append(ei.c(context)).append("\",\"details\":").append(str);
        } catch (Throwable th) {
        }
        return stringBuilder.toString();
    }
}
