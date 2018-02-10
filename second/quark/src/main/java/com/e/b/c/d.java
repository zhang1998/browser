package com.e.b.c;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: ProGuard */
public final class d extends com.e.b.d {
    public d(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            super.a("_field_page", str);
        }
        super.a("_field_event_id", String.valueOf(i));
        if (!TextUtils.isEmpty(str2)) {
            super.a("_field_arg1", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            super.a("_field_arg2", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            super.a("_field_arg3", str4);
        }
        super.a(map);
    }
}
