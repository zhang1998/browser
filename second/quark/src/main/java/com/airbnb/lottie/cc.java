package com.airbnb.lottie;

import com.taobao.weex.ui.component.ab;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class cc {
    static bw a(JSONObject jSONObject, k kVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject("g");
        if (optJSONObject != null && optJSONObject.has("k")) {
            optJSONObject = optJSONObject.optJSONObject("k");
        }
        x xVar = null;
        if (optJSONObject != null) {
            xVar = r.a(optJSONObject, kVar);
        }
        optJSONObject = jSONObject.optJSONObject("o");
        dt dtVar = null;
        if (optJSONObject != null) {
            dtVar = ah.a(optJSONObject, kVar);
        }
        int i = jSONObject.optInt("t", 1) == 1 ? w.a : w.b;
        optJSONObject = jSONObject.optJSONObject("s");
        ch chVar = null;
        if (optJSONObject != null) {
            chVar = z.a(optJSONObject, kVar);
        }
        optJSONObject = jSONObject.optJSONObject("e");
        ch chVar2 = null;
        if (optJSONObject != null) {
            chVar2 = z.a(optJSONObject, kVar);
        }
        cs a = ci.a(jSONObject.optJSONObject(ab.PROP_FS_WRAP_CONTENT), kVar, true);
        bg bgVar = bg.values()[jSONObject.optInt("lc") - 1];
        ae aeVar = ae.values()[jSONObject.optInt("lj") - 1];
        cs csVar = null;
        List arrayList = new ArrayList();
        if (jSONObject.has("d")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("d");
            cs csVar2 = null;
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                String optString = optJSONObject2.optString("n");
                if (optString.equals("o")) {
                    csVar2 = ci.a(optJSONObject2.optJSONObject("v"), kVar, true);
                } else if (optString.equals("d") || optString.equals("g")) {
                    arrayList.add(ci.a(optJSONObject2.optJSONObject("v"), kVar, true));
                }
            }
            if (arrayList.size() == 1) {
                arrayList.add(arrayList.get(0));
            }
            csVar = csVar2;
        }
        return new bw(i, xVar, dtVar, chVar, chVar2, a, bgVar, aeVar, arrayList, csVar);
    }
}
