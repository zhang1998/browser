package com.airbnb.lottie;

import com.uc.imagecodec.export.IPictureView;
import java.util.Collections;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class g {
    static du a(JSONObject jSONObject, k kVar) {
        h hVar;
        ag a;
        dr drVar;
        dt a2;
        cs csVar = null;
        JSONObject optJSONObject = jSONObject.optJSONObject("a");
        if (optJSONObject != null) {
            hVar = new h(optJSONObject.opt("k"), kVar);
        } else {
            a("anchor");
            hVar = null;
        }
        optJSONObject = jSONObject.optJSONObject("p");
        if (optJSONObject != null) {
            a = h.a(optJSONObject, kVar);
        } else {
            a("position");
            a = null;
        }
        optJSONObject = jSONObject.optJSONObject("s");
        if (optJSONObject != null) {
            ao a3 = ab.a(optJSONObject, IPictureView.DEFAULT_MIN_SCALE, kVar, m.a).a();
            drVar = new dr(a3.a, (cg) a3.b);
        } else {
            drVar = new dr(Collections.emptyList(), new cg());
        }
        optJSONObject = jSONObject.optJSONObject("r");
        if (optJSONObject == null) {
            optJSONObject = jSONObject.optJSONObject("rz");
        }
        if (optJSONObject != null) {
            csVar = ci.a(optJSONObject, kVar, false);
        } else {
            a("rotation");
        }
        optJSONObject = jSONObject.optJSONObject("o");
        if (optJSONObject != null) {
            a2 = ah.a(optJSONObject, kVar);
        } else {
            a2 = new dt(Collections.emptyList(), Integer.valueOf(100));
        }
        return new du(hVar, a, drVar, csVar, a2);
    }

    private static void a(String str) {
        throw new IllegalArgumentException("Missing transform for " + str);
    }
}
