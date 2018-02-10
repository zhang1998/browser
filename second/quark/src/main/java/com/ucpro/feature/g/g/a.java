package com.ucpro.feature.g.g;

import android.content.SharedPreferences;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class a {
    public SharedPreferences a;

    private a() {
        this.a = d.a().getSharedPreferences("__cs", 0);
    }

    public final boolean a() {
        String str = "C3F8534E79898E10";
        if ("".equals(str)) {
            return false;
        }
        return this.a.getBoolean(str, false);
    }
}
