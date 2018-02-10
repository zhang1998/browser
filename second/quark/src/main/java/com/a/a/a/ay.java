package com.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ProGuard */
public final class ay {
    Set<String> a = new HashSet();
    private Context b;

    public ay(Context context) {
        this.b = context;
    }

    public final void a() {
        if (!this.a.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String append : this.a) {
                stringBuilder.append(append);
                stringBuilder.append(',');
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            this.b.getSharedPreferences("umeng_general_config", 0).edit().putString("invld_id", stringBuilder.toString()).commit();
        }
    }

    public final void b() {
        int i = 0;
        Object string = this.b.getSharedPreferences("umeng_general_config", 0).getString("invld_id", null);
        if (!TextUtils.isEmpty(string)) {
            String[] split = string.split(",");
            if (split != null) {
                int length = split.length;
                while (i < length) {
                    CharSequence charSequence = split[i];
                    if (!TextUtils.isEmpty(charSequence)) {
                        this.a.add(charSequence);
                    }
                    i++;
                }
            }
        }
    }
}
