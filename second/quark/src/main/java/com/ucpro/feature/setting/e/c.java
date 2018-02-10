package com.ucpro.feature.setting.e;

import android.text.TextUtils;
import com.ucpro.business.stat.m;
import com.ucpro.feature.setting.a.h;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class c {
    private c() {
    }

    public static void a(int i, String str) {
        String a = h.a(i);
        new StringBuilder("statSettingItemClick: \nsettingItemKey: ").append(a).append("\nsetValue: ").append(str);
        HashMap hashMap = new HashMap();
        hashMap.put("setting_item_key", a);
        hashMap.put("setting_item_value", str);
        m.a("setting", "setting_item_click", hashMap);
    }

    public static void a(int i, HashMap<String, String> hashMap) {
        hashMap.put("setting_item_key", h.a(i));
        StringBuffer stringBuffer = new StringBuffer("statSettingItemStatus: ");
        for (String append : hashMap.keySet()) {
            stringBuffer.append("\n").append(append).append(" : ").append(hashMap);
        }
        m.a("setting", "setting_item_status", (HashMap) hashMap);
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", str);
            m.a("setting", "select_toolbar_style", hashMap);
        }
    }
}
