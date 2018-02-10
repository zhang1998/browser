package com.airbnb.lottie;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class h implements ag<PointF> {
    private final List<dg> a;
    private PointF b;

    static ag<PointF> a(JSONObject jSONObject, k kVar) {
        if (jSONObject.has("k")) {
            return new h(jSONObject.opt("k"), kVar);
        }
        return new by(ci.a(jSONObject.optJSONObject("x"), kVar, true), ci.a(jSONObject.optJSONObject("y"), kVar, true));
    }

    h() {
        this.a = new ArrayList();
        this.b = new PointF(0.0f, 0.0f);
    }

    h(Object obj, k kVar) {
        Object opt;
        JSONArray jSONArray;
        int length;
        int i;
        p a;
        JSONArray optJSONArray;
        PointF pointF;
        PointF pointF2;
        dg dgVar;
        this.a = new ArrayList();
        if (obj instanceof JSONArray) {
            opt = ((JSONArray) obj).opt(0);
            if ((opt instanceof JSONObject) && ((JSONObject) opt).has("t")) {
                opt = 1;
                if (opt == null) {
                    jSONArray = (JSONArray) obj;
                    length = jSONArray.length();
                    for (i = 0; i < length; i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        a = bh.a(optJSONObject, kVar, kVar.g, dd.a);
                        optJSONArray = optJSONObject.optJSONArray("ti");
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("to");
                        if (optJSONArray != null || optJSONArray2 == null) {
                            pointF = null;
                            pointF2 = null;
                        } else {
                            PointF a2 = bb.a(optJSONArray2, kVar.g);
                            pointF = bb.a(optJSONArray, kVar.g);
                            pointF2 = a2;
                        }
                        dgVar = new dg(kVar, (PointF) a.a, (PointF) a.b, a.c, a.d, a.e);
                        if (!(a.b == null || ((PointF) a.a).equals(a.b))) {
                            dgVar.f = dn.a((PointF) a.a, (PointF) a.b, pointF2, pointF);
                        }
                        this.a.add(dgVar);
                    }
                    p.a(this.a);
                }
                this.b = bb.a((JSONArray) obj, kVar.g);
                return;
            }
        }
        opt = null;
        if (opt == null) {
            this.b = bb.a((JSONArray) obj, kVar.g);
            return;
        }
        jSONArray = (JSONArray) obj;
        length = jSONArray.length();
        for (i = 0; i < length; i++) {
            JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
            a = bh.a(optJSONObject2, kVar, kVar.g, dd.a);
            optJSONArray = optJSONObject2.optJSONArray("ti");
            JSONArray optJSONArray22 = optJSONObject2.optJSONArray("to");
            if (optJSONArray != null) {
            }
            pointF = null;
            pointF2 = null;
            dgVar = new dg(kVar, (PointF) a.a, (PointF) a.b, a.c, a.d, a.e);
            dgVar.f = dn.a((PointF) a.a, (PointF) a.b, pointF2, pointF);
            this.a.add(dgVar);
        }
        p.a(this.a);
    }

    public final String toString() {
        return "initialPoint=" + this.b;
    }

    public final bl<?, PointF> a() {
        Object obj;
        if (this.a.isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return new ai(this.b);
        }
        return new cy(this.a);
    }
}
