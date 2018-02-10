package com.airbnb.lottie;

import android.graphics.PointF;
import android.os.Build.VERSION;
import android.support.v4.view.a.a;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class bh {
    static <T> p<T> a(JSONObject jSONObject, k kVar, float f, ay<T> ayVar) {
        Object obj;
        Object obj2;
        Interpolator c;
        int i = 1;
        float f2 = 0.0f;
        Object opt;
        if (jSONObject.has("t")) {
            PointF pointF;
            PointF pointF2;
            f2 = (float) jSONObject.optDouble("t", 0.0d);
            Object opt2 = jSONObject.opt("s");
            if (opt2 != null) {
                opt2 = ayVar.a(opt2, f);
            } else {
                opt2 = null;
            }
            opt = jSONObject.opt("e");
            if (opt != null) {
                opt = ayVar.a(opt, f);
            } else {
                opt = null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("o");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("i");
            if (optJSONObject == null || optJSONObject2 == null) {
                pointF = null;
                pointF2 = null;
            } else {
                pointF2 = bb.a(optJSONObject, f);
                pointF = bb.a(optJSONObject2, f);
            }
            if (jSONObject.optInt("h", 0) != 1) {
                i = 0;
            }
            if (i != 0) {
                opt = opt2;
            } else if (pointF2 != null) {
                PathInterpolator pathInterpolator;
                float f3 = pointF2.x / f;
                float f4 = pointF2.y / f;
                float f5 = pointF.x / f;
                float f6 = pointF.y / f;
                if (VERSION.SDK_INT >= 21) {
                    pathInterpolator = new PathInterpolator(f3, f4, f5, f6);
                } else {
                    pathInterpolator = new a(f3, f4, f5, f6);
                }
                Object obj3 = pathInterpolator;
                obj = opt;
                obj2 = opt2;
            }
            c = p.f;
            obj = opt;
            obj2 = opt2;
        } else {
            opt = ayVar.a(jSONObject, f);
            c = null;
            obj = opt;
            obj2 = opt;
        }
        return new p(kVar, obj2, obj, c, f2, null);
    }
}
