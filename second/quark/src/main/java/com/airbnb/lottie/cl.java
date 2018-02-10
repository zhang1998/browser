package com.airbnb.lottie;

import android.graphics.PointF;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class cl implements ay<bp> {
    static final cl a = new cl();

    private cl() {
    }

    private static PointF a(int i, JSONArray jSONArray) {
        if (i >= jSONArray.length()) {
            throw new IllegalArgumentException("Invalid index " + i + ". There are only " + jSONArray.length() + " points.");
        }
        JSONArray optJSONArray = jSONArray.optJSONArray(i);
        Object opt = optJSONArray.opt(0);
        Object opt2 = optJSONArray.opt(1);
        return new PointF(opt instanceof Double ? new Float(((Double) opt).doubleValue()).floatValue() : (float) ((Integer) opt).intValue(), opt2 instanceof Double ? new Float(((Double) opt2).doubleValue()).floatValue() : (float) ((Integer) opt2).intValue());
    }

    public final /* synthetic */ Object a(Object obj, float f) {
        JSONObject jSONObject;
        if (obj instanceof JSONArray) {
            Object opt = ((JSONArray) obj).opt(0);
            if ((opt instanceof JSONObject) && ((JSONObject) opt).has("v")) {
                jSONObject = (JSONObject) opt;
            }
            jSONObject = null;
        } else {
            if ((obj instanceof JSONObject) && ((JSONObject) obj).has("v")) {
                jSONObject = (JSONObject) obj;
            }
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("v");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("i");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("o");
        boolean optBoolean = jSONObject.optBoolean("c", false);
        if (optJSONArray == null || optJSONArray2 == null || optJSONArray3 == null || optJSONArray.length() != optJSONArray2.length() || optJSONArray.length() != optJSONArray3.length()) {
            throw new IllegalStateException("Unable to process points array or tangents. " + jSONObject);
        } else if (optJSONArray.length() == 0) {
            return new bp(new PointF(), false, Collections.emptyList());
        } else {
            int length = optJSONArray.length();
            PointF a = a(0, optJSONArray);
            a.x *= f;
            a.y *= f;
            List arrayList = new ArrayList(length);
            for (int i = 1; i < length; i++) {
                PointF a2 = a(i, optJSONArray);
                PointF a3 = a(i - 1, optJSONArray);
                PointF a4 = a(i - 1, optJSONArray3);
                PointF a5 = a(i, optJSONArray2);
                a3 = am.a(a3, a4);
                a4 = am.a(a2, a5);
                a3.x *= f;
                a3.y *= f;
                a4.x *= f;
                a4.y *= f;
                a2.x *= f;
                a2.y *= f;
                arrayList.add(new ac(a3, a4, a2));
            }
            if (optBoolean) {
                PointF a6 = a(0, optJSONArray);
                PointF a7 = a(length - 1, optJSONArray);
                PointF a8 = a(length - 1, optJSONArray3);
                PointF a9 = a(0, optJSONArray2);
                a8 = am.a(a7, a8);
                a7 = am.a(a6, a9);
                if (f != IPictureView.DEFAULT_MIN_SCALE) {
                    a8.x *= f;
                    a8.y *= f;
                    a7.x *= f;
                    a7.y *= f;
                    a6.x *= f;
                    a6.y *= f;
                }
                arrayList.add(new ac(a8, a7, a6));
            }
            return new bp(a, optBoolean, arrayList);
        }
    }
}
