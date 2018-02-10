package com.uc.c;

import android.text.TextUtils;
import com.uc.c;
import com.uc.d;

/* compiled from: ProGuard */
public final class e implements d {
    private d a;

    public final c a(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf("xg://") != 0) {
            return null;
        }
        if (this.a == null) {
            this.a = new d();
        }
        this.a.a = str;
        return this.a;
    }
}
