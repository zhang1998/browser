package com.ucpro.feature.navigation.b;

import android.text.TextUtils;
import com.quark.browser.R;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class e {
    private static e a = new e();
    private String[] b;
    private String[] c;
    private String[] d;

    private e() {
    }

    public static e a() {
        return a;
    }

    public final String[] b() {
        if (this.c == null) {
            this.c = d.c().getStringArray(R.array.hardcode_lightapp_urls);
        }
        return this.c;
    }

    public final String[] c() {
        if (this.b == null) {
            this.b = d.c().getStringArray(R.array.hardcode_lightapp_titles);
        }
        return this.b;
    }

    public final String a(String str) {
        int i = 0;
        while (i < b().length) {
            CharSequence charSequence = b()[i];
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(charSequence) || !str.contains(charSequence)) {
                i++;
            } else {
                if (this.d == null) {
                    this.d = d.c().getStringArray(R.array.hardcode_lightapp_colors);
                }
                return this.d[i];
            }
        }
        return "#000000";
    }
}
