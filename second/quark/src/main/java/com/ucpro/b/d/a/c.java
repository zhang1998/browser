package com.ucpro.b.d.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ucweb.common.util.d;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ProGuard */
public final class c {
    private static final HashSet<String> b = new HashSet();
    public SharedPreferences a;
    private String c;

    public static c a() {
        return a.a;
    }

    private c() {
        this.c = "2.4.1.985";
        this.a = d.a().getSharedPreferences("__vf", 0);
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean add;
        synchronized (this.a) {
            Set stringSet = this.a.getStringSet(str, new HashSet());
            add = stringSet.add(this.c);
            this.a.edit().putStringSet(str, stringSet).apply();
        }
        return add;
    }

    public final int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int size;
        synchronized (this.a) {
            size = this.a.getStringSet(str, b).size();
        }
        return size;
    }
}
