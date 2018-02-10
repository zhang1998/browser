package com.airbnb.lottie;

import com.taobao.weex.ui.component.ab;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class cv {
    static bj a(JSONObject jSONObject, k kVar) {
        cs csVar;
        List arrayList = new ArrayList();
        co a = bi.a(jSONObject.optJSONObject("c"), kVar);
        cs a2 = ci.a(jSONObject.optJSONObject(ab.PROP_FS_WRAP_CONTENT), kVar);
        dt a3 = ah.a(jSONObject.optJSONObject("o"), kVar);
        bg bgVar = bg.values()[jSONObject.optInt("lc") - 1];
        ae aeVar = ae.values()[jSONObject.optInt("lj") - 1];
        cs csVar2 = null;
        if (jSONObject.has("d")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("d");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("n");
                if (optString.equals("o")) {
                    csVar2 = ci.a(optJSONObject.optJSONObject("v"), kVar);
                } else if (optString.equals("d") || optString.equals("g")) {
                    arrayList.add(ci.a(optJSONObject.optJSONObject("v"), kVar));
                }
            }
            if (arrayList.size() == 1) {
                arrayList.add(arrayList.get(0));
            }
            csVar = csVar2;
        } else {
            csVar = null;
        }
        return new bj(csVar, arrayList, a, a3, a2, bgVar, aeVar);
    }
}
