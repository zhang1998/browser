package com.e.b.b;

import android.text.TextUtils;
import java.util.List;
import java.util.Vector;

/* compiled from: ProGuard */
public final class a {
    private static a c = new a();
    private List<String> a = new Vector();
    private int b = 1000;

    private a() {
    }

    public static a a() {
        return c;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.a.size() >= this.b) {
                this.a.remove(0);
            }
            this.a.add(str);
        }
    }
}
