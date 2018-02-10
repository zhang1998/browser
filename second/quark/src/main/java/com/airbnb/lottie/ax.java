package com.airbnb.lottie;

import android.graphics.PointF;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class ax implements ay<PointF> {
    static final ax a = new ax();

    private ax() {
    }

    public final /* synthetic */ Object a(Object obj, float f) {
        if (obj instanceof JSONArray) {
            return bb.a((JSONArray) obj, f);
        }
        if (obj instanceof JSONObject) {
            return bb.a((JSONObject) obj, f);
        }
        throw new IllegalArgumentException("Unable to parse point from " + obj);
    }
}
