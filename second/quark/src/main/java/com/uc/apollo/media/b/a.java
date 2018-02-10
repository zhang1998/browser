package com.uc.apollo.media.b;

import java.util.Locale;

/* compiled from: ProGuard */
public final class a {
    public int a;

    a(String str, int i) throws d {
        Object obj;
        this.a = -1;
        this.a = -1;
        String toUpperCase = str.toUpperCase(Locale.getDefault());
        int indexOf = toUpperCase.indexOf("BANDWIDTH=");
        if (indexOf != -1) {
            int i2 = indexOf + 10;
            indexOf = toUpperCase.indexOf(44, i2);
            if (indexOf == -1) {
                indexOf = toUpperCase.length();
            }
            this.a = Integer.valueOf(toUpperCase.substring(i2, indexOf)).intValue();
        }
        if (this.a == -1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            throw new d(toUpperCase, i, "not specify attribute-list, or invalid");
        }
    }
}
