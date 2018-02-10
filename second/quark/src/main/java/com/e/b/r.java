package com.e.b;

import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.c;

/* compiled from: ProGuard */
public final class r extends d {
    public r(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Control name can not be empty.");
        }
        String str2 = g.a().e;
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("Please call in at PageAppear and PageDisAppear.");
        }
        String str3 = str2 + "_" + str;
        super.a("_field_page", str2);
        super.a("_field_event_id", "2101");
        super.a("_field_arg1", str3);
    }

    public r(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            if (c.f) {
                throw new IllegalArgumentException("Control name can not be empty.");
            }
            af.d("Control name can not be empty.", new Object[0]);
        } else if (!TextUtils.isEmpty(str)) {
            String str3 = str + "_" + str2;
            super.a("_field_page", str);
            super.a("_field_event_id", "2101");
            super.a("_field_arg1", str3);
        } else if (c.f) {
            throw new IllegalArgumentException("Page name can not be empty.");
        } else {
            af.d("Page name can not be empty.", new Object[0]);
        }
    }
}
