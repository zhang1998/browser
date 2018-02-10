package com.e.b;

import android.text.TextUtils;
import com.uc.apollo.impl.SettingsConst;

/* compiled from: ProGuard */
public final class q extends d {
    public q(String str) {
        if (!TextUtils.isEmpty(str)) {
            super.a("_field_page", str);
        }
        super.a("_field_event_id", "2001");
        super.a("_field_arg3", SettingsConst.FALSE);
    }

    public final q a(long j) {
        if (j < 0) {
            j = 0;
        }
        super.a("_field_arg3", String.valueOf(j));
        return this;
    }

    public final q a(String str) {
        if (!TextUtils.isEmpty(str)) {
            super.a("_field_arg1", str);
        }
        return this;
    }
}
