package com.airbnb.lottie;

import com.uc.imagecodec.export.IPictureView;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class ci {
    static cs a(JSONObject jSONObject, k kVar) {
        return a(jSONObject, kVar, true);
    }

    static cs a(JSONObject jSONObject, k kVar, boolean z) {
        float f;
        if (z) {
            f = kVar.g;
        } else {
            f = IPictureView.DEFAULT_MIN_SCALE;
        }
        ao a = ab.a(jSONObject, f, kVar, n.a).a();
        return new cs(a.a, (Float) a.b);
    }
}
