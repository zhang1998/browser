package com.uc.weex.j;

import android.text.TextUtils;

/* compiled from: ProGuard */
public final class c {
    private int a;
    private int b;
    private int c;
    private int d;

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\.");
        if (split == null || split.length < 4) {
            return null;
        }
        try {
            c cVar = new c();
            cVar.a = Integer.parseInt(split[0]);
            cVar.b = Integer.parseInt(split[1]);
            cVar.c = Integer.parseInt(split[2]);
            cVar.d = Integer.parseInt(split[3]);
            return cVar;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public final int a(c cVar) {
        if (cVar == null) {
            return 1;
        }
        int i = this.a - cVar.a;
        if (i != 0) {
            return i;
        }
        i = this.b - cVar.b;
        if (i == 0) {
            i = this.c - cVar.c;
        }
        if (i == 0) {
            return this.d - cVar.d;
        }
        return i;
    }
}
