package com.ucpro.feature.navigation.view;

import android.text.TextUtils;
import com.ucpro.b.a.a;
import com.ucpro.c.d;

/* compiled from: ProGuard */
public final class ax {
    public long a = -1;
    public int b = 0;
    boolean c = true;
    public String d;
    public String e;
    public String f;
    public String g;
    String h;
    public int i;

    public final void a(String str) {
        this.e = str;
        String str2 = this.e;
        if (!(a.a() && d.a())) {
            StringBuilder stringBuilder = new StringBuilder("");
            if (!TextUtils.isEmpty(str2)) {
                int length = str2.length();
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj;
                    char charAt = str2.charAt(i2);
                    if (charAt < '一' || charAt > '龥') {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    int i3 = obj != null ? 2 : 1;
                    if (i + i3 > 8) {
                        break;
                    }
                    i += i3;
                    stringBuilder.append(charAt);
                }
            }
            str2 = stringBuilder.toString();
        }
        this.h = str2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("w_id:" + this.a + ",");
        stringBuilder.append(this.e + ",");
        stringBuilder.append("type:" + this.b + "\n");
        return stringBuilder.toString();
    }
}
