package com.airbnb.lottie;

import org.json.JSONArray;

/* compiled from: ProGuard */
final class m implements ay<cg> {
    static final m a = new m();

    public final /* synthetic */ Object a(Object obj, float f) {
        JSONArray jSONArray = (JSONArray) obj;
        return new cg((((float) jSONArray.optDouble(0, 1.0d)) / 100.0f) * f, (((float) jSONArray.optDouble(1, 1.0d)) / 100.0f) * f);
    }

    private m() {
    }
}
