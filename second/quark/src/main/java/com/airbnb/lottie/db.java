package com.airbnb.lottie;

import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import android.util.Log;
import com.taobao.weex.ui.component.ab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class db {
    final List<Object> a;
    private final String b;

    @Nullable
    static Object a(JSONObject jSONObject, k kVar) {
        String optString = jSONObject.optString("ty");
        Object obj = -1;
        switch (optString.hashCode()) {
            case 3239:
                if (optString.equals("el")) {
                    obj = 7;
                    break;
                }
                break;
            case 3270:
                if (optString.equals("fl")) {
                    obj = 3;
                    break;
                }
                break;
            case 3295:
                if (optString.equals("gf")) {
                    obj = 4;
                    break;
                }
                break;
            case 3307:
                if (optString.equals("gr")) {
                    obj = null;
                    break;
                }
                break;
            case 3308:
                if (optString.equals("gs")) {
                    obj = 2;
                    break;
                }
                break;
            case 3488:
                if (optString.equals("mm")) {
                    obj = 11;
                    break;
                }
                break;
            case 3633:
                if (optString.equals("rc")) {
                    obj = 8;
                    break;
                }
                break;
            case 3669:
                if (optString.equals("sh")) {
                    obj = 6;
                    break;
                }
                break;
            case 3679:
                if (optString.equals("sr")) {
                    obj = 10;
                    break;
                }
                break;
            case 3681:
                if (optString.equals("st")) {
                    obj = 1;
                    break;
                }
                break;
            case 3705:
                if (optString.equals("tm")) {
                    obj = 9;
                    break;
                }
                break;
            case 3710:
                if (optString.equals("tr")) {
                    obj = 5;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                JSONArray optJSONArray = jSONObject.optJSONArray("it");
                String optString2 = jSONObject.optString("nm");
                List arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    Object a = a(optJSONArray.optJSONObject(i), kVar);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                return new db(optString2, arrayList);
            case 1:
                return cv.a(jSONObject, kVar);
            case 2:
                return cc.a(jSONObject, kVar);
            case 3:
                co coVar = null;
                dt dtVar = null;
                JSONObject optJSONObject = jSONObject.optJSONObject("c");
                if (optJSONObject != null) {
                    coVar = bi.a(optJSONObject, kVar);
                }
                optJSONObject = jSONObject.optJSONObject("o");
                if (optJSONObject != null) {
                    dtVar = ah.a(optJSONObject, kVar);
                }
                return new av(jSONObject.optBoolean("fillEnabled"), jSONObject.optInt("r", 1) == 1 ? FillType.WINDING : FillType.EVEN_ODD, coVar, dtVar);
            case 4:
                return bn.a(jSONObject, kVar);
            case 5:
                return g.a(jSONObject, kVar);
            case 6:
                return new cw(jSONObject.optString("nm"), jSONObject.optInt("ind"), dh.a(jSONObject.optJSONObject("ks"), kVar));
            case 7:
                return new dp(h.a(jSONObject.optJSONObject("p"), kVar), z.a(jSONObject.optJSONObject("s"), kVar));
            case 8:
                return new u(h.a(jSONObject.optJSONObject("p"), kVar), z.a(jSONObject.optJSONObject("s"), kVar), ci.a(jSONObject.optJSONObject("r"), kVar));
            case 9:
                return new dm(o.a(jSONObject.optInt(ab.PROP_FS_MATCH_PARENT, 1)), ci.a(jSONObject.optJSONObject("s"), kVar, false), ci.a(jSONObject.optJSONObject("e"), kVar, false), ci.a(jSONObject.optJSONObject("o"), kVar, false));
            case 10:
                cs a2;
                cs a3;
                b a4 = b.a(jSONObject.optInt("sy"));
                cs a5 = ci.a(jSONObject.optJSONObject("pt"), kVar, false);
                ag a6 = h.a(jSONObject.optJSONObject("p"), kVar);
                cs a7 = ci.a(jSONObject.optJSONObject("r"), kVar, false);
                cs a8 = ci.a(jSONObject.optJSONObject("or"), kVar);
                cs a9 = ci.a(jSONObject.optJSONObject("os"), kVar, false);
                if (a4 == b.Star) {
                    a2 = ci.a(jSONObject.optJSONObject("ir"), kVar);
                    a3 = ci.a(jSONObject.optJSONObject("is"), kVar, false);
                } else {
                    a2 = null;
                    a3 = null;
                }
                return new ce(a4, a5, a6, a7, a2, a8, a3, a9);
            case 11:
                return new ak(ap.a(jSONObject.optInt("mm", 1)));
            default:
                Log.w("LOTTIE", "Unknown shape type " + optString);
                return null;
        }
    }

    db(String str, List<Object> list) {
        this.b = str;
        this.a = list;
    }

    public final String toString() {
        return "ShapeGroup{name='" + this.b + "' Shapes: " + Arrays.toString(this.a.toArray()) + '}';
    }
}
