package com.e.b;

import android.text.TextUtils;
import com.alibaba.analytics.a.g;
import com.alibaba.analytics.core.model.LogField;
import com.uc.apollo.impl.SettingsConst;
import java.util.Map;

/* compiled from: ProGuard */
public final class j extends d {
    public j(String str) {
        if (!TextUtils.isEmpty(str)) {
            super.a("_field_arg1", str);
        }
        super.a("_field_event_id", "19999");
        super.a("_field_arg3", SettingsConst.FALSE);
        super.a("_priority", "4");
    }

    public final Map<String, String> a() {
        Map<String, String> a = super.a();
        if (a != null) {
            String str = (String) a.get(LogField.PAGE.toString());
            String str2 = (String) a.get(LogField.ARG1.toString());
            if (str2 != null) {
                a.remove(LogField.ARG1.toString());
                a.remove(LogField.PAGE.toString());
                a = g.a(a);
                a.put(LogField.ARG1.toString(), str2);
                a.put(LogField.PAGE.toString(), str);
                return a;
            }
        }
        return a;
    }

    public final j a(String str) {
        if (!TextUtils.isEmpty(str)) {
            super.a("_field_page", str);
        }
        return this;
    }
}
