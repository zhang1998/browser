package com.alibaba.analytics.core.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class o {
    int a = -1;
    private List<String> b = new ArrayList();

    private o() {
    }

    public static o a(String str) {
        try {
            o oVar = new o();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("all_d")) {
                oVar.a = jSONObject.optInt("all_d", -1);
            }
            if (!jSONObject.has("arg1")) {
                return oVar;
            }
            List arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("arg1");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            oVar.b = arrayList;
            return oVar;
        } catch (Exception e) {
            return null;
        }
    }

    final boolean b(String str) {
        if (TextUtils.isEmpty(str) || this.b == null) {
            return false;
        }
        for (int i = 0; i < this.b.size(); i++) {
            String str2 = (String) this.b.get(i);
            if (!TextUtils.isEmpty(str2)) {
                if (str2.length() > 2 && str2.startsWith("%") && str2.endsWith("%")) {
                    if (str.contains(str2.substring(1, str2.length() - 1))) {
                        return true;
                    }
                } else if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
