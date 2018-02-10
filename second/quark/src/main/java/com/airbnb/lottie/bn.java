package com.airbnb.lottie;

import android.graphics.Path.FillType;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class bn {
    static az a(JSONObject jSONObject, k kVar) {
        x a;
        dt a2;
        ch a3;
        ch a4;
        JSONObject optJSONObject = jSONObject.optJSONObject("g");
        if (optJSONObject != null && optJSONObject.has("k")) {
            optJSONObject = optJSONObject.optJSONObject("k");
        }
        if (optJSONObject != null) {
            a = r.a(optJSONObject, kVar);
        } else {
            a = null;
        }
        optJSONObject = jSONObject.optJSONObject("o");
        if (optJSONObject != null) {
            a2 = ah.a(optJSONObject, kVar);
        } else {
            a2 = null;
        }
        FillType fillType = jSONObject.optInt("r", 1) == 1 ? FillType.WINDING : FillType.EVEN_ODD;
        int i = jSONObject.optInt("r", 1) == 1 ? w.a : w.b;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("s");
        if (optJSONObject2 != null) {
            a3 = z.a(optJSONObject2, kVar);
        } else {
            a3 = null;
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("e");
        if (optJSONObject3 != null) {
            a4 = z.a(optJSONObject3, kVar);
        } else {
            a4 = null;
        }
        return new az(i, fillType, a, a2, a3, a4);
    }
}
