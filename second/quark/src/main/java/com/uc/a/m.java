package com.uc.a;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class m {
    private HashMap<String, String> a;
    private HashMap<String, String> b;

    private m() {
        this.a = new HashMap();
        this.b = new HashMap();
    }

    public final String a(String str) {
        String str2 = (String) this.a.get(str);
        if (TextUtils.isEmpty(str2)) {
            return (String) this.b.get(str);
        }
        return str2;
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.b.put(str, str2);
        }
    }
}
