package com.ucpro.ui.e;

/* compiled from: ProGuard */
public abstract class d implements e {
    private static int b = 1;
    public String a;

    public static String a() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = b;
        b = i + 1;
        return stringBuilder.append(i).toString();
    }

    public d(String str) {
        this.a = str;
    }

    public final String b() {
        return this.a;
    }
}
