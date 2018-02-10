package com.taobao.android.binding.core;

import android.util.Log;
import com.taobao.weex.i;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: ProGuard */
final class h {
    JSONObject a;

    h(String str) {
        try {
            this.a = (JSONObject) new JSONTokener(str).nextValue();
        } catch (Throwable th) {
            if (i.c()) {
                Log.e("ExpressionBinding", "[Expression] expression is illegal. \n " + th.getMessage());
            }
        }
    }

    final Object a(Map<String, Object> map) throws IllegalArgumentException, JSONException {
        return a(this.a, (Map) map);
    }

    private static double a(Object obj) {
        if (obj instanceof String) {
            return Double.parseDouble((String) obj);
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? 1.0d : 0.0d;
        } else {
            return ((Double) obj).doubleValue();
        }
    }

    private static boolean b(Object obj) {
        if (obj instanceof String) {
            if (((String) obj) == "") {
                return true;
            }
            return false;
        } else if (!(obj instanceof Double)) {
            return ((Boolean) obj).booleanValue();
        } else {
            if (((Double) obj).doubleValue() == 0.0d) {
                return false;
            }
            return true;
        }
    }

    private static boolean a(Object obj, Object obj2) {
        if ((obj instanceof cj) && (obj2 instanceof cj)) {
            if (obj == obj2) {
                return true;
            }
            return false;
        } else if ((obj instanceof String) && (obj2 instanceof String)) {
            return obj.equals(obj2);
        } else {
            if ((obj instanceof Boolean) && (obj2 instanceof Boolean)) {
                if (b(obj) != b(obj2)) {
                    return false;
                }
                return true;
            } else if (a(obj) != a(obj2)) {
                return false;
            } else {
                return true;
            }
        }
    }

    private static boolean b(Object obj, Object obj2) {
        if ((obj instanceof cj) && !(obj2 instanceof cj)) {
            return false;
        }
        if ((obj instanceof Boolean) && !(obj2 instanceof Boolean)) {
            return false;
        }
        if ((obj instanceof Double) && !(obj2 instanceof Double)) {
            return false;
        }
        if ((!(obj instanceof String) || (obj2 instanceof String)) && obj == obj2) {
            return true;
        }
        return false;
    }

    private Object a(JSONObject jSONObject, Map<String, Object> map) throws IllegalArgumentException, JSONException {
        boolean z = true;
        boolean z2 = false;
        while (true) {
            String string = jSONObject.getString("type");
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            boolean z3 = true;
            switch (string.hashCode()) {
                case -1746151498:
                    if (string.equals("CallExpression")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 33:
                    if (string.equals("!")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 37:
                    if (string.equals("%")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 42:
                    if (string.equals("*")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 43:
                    if (string.equals("+")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 45:
                    if (string.equals("-")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 47:
                    if (string.equals("/")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 60:
                    if (string.equals("<")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 62:
                    if (string.equals(">")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 63:
                    if (string.equals("?")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 1084:
                    if (string.equals("!=")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 1216:
                    if (string.equals("&&")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 1344:
                    if (string.equals("**")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 1921:
                    if (string.equals("<=")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 1952:
                    if (string.equals("==")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 1983:
                    if (string.equals(">=")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 3968:
                    if (string.equals("||")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 33665:
                    if (string.equals("!==")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 60573:
                    if (string.equals("===")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 189157634:
                    if (string.equals("NumericLiteral")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 375032009:
                    if (string.equals("Identifier")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 1074430782:
                    if (string.equals("StringLiteral")) {
                        z3 = false;
                        break;
                    }
                    break;
                case 1816238983:
                    if (string.equals("BooleanLiteral")) {
                        z3 = true;
                        break;
                    }
                    break;
            }
            Object a;
            switch (z3) {
                case false:
                    return jSONObject.getString("value");
                case true:
                    return Double.valueOf(jSONObject.getDouble("value"));
                case true:
                    return Boolean.valueOf(jSONObject.getBoolean("value"));
                case true:
                    return map.get(jSONObject.getString("value"));
                case true:
                    bg bgVar = (bg) a(optJSONArray.getJSONObject(0), (Map) map);
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = optJSONArray.getJSONObject(1).getJSONArray("children");
                    int i;
                    while (i < jSONArray.length()) {
                        arrayList.add(a(jSONArray.getJSONObject(i), (Map) map));
                        i++;
                    }
                    return bgVar.a(arrayList);
                case true:
                    if (!((Boolean) a(optJSONArray.getJSONObject(0), (Map) map)).booleanValue()) {
                        jSONObject = optJSONArray.getJSONObject(2);
                        break;
                    }
                    jSONObject = optJSONArray.getJSONObject(1);
                    break;
                case true:
                    return Double.valueOf(a(a(optJSONArray.getJSONObject(0), (Map) map)) + a(a(optJSONArray.getJSONObject(1), (Map) map)));
                case true:
                    return Double.valueOf(a(a(optJSONArray.getJSONObject(0), (Map) map)) - a(a(optJSONArray.getJSONObject(1), (Map) map)));
                case true:
                    return Double.valueOf(a(a(optJSONArray.getJSONObject(0), (Map) map)) * a(a(optJSONArray.getJSONObject(1), (Map) map)));
                case true:
                    return Double.valueOf(a(a(optJSONArray.getJSONObject(0), (Map) map)) / a(a(optJSONArray.getJSONObject(1), (Map) map)));
                case true:
                    return Double.valueOf(a(a(optJSONArray.getJSONObject(0), (Map) map)) % a(a(optJSONArray.getJSONObject(1), (Map) map)));
                case true:
                    return Double.valueOf(Math.pow(a(a(optJSONArray.getJSONObject(0), (Map) map)), a(a(optJSONArray.getJSONObject(1), (Map) map))));
                case true:
                    if (a(a(optJSONArray.getJSONObject(0), (Map) map)) > a(a(optJSONArray.getJSONObject(1), (Map) map))) {
                        z2 = true;
                    }
                    return Boolean.valueOf(z2);
                case true:
                    if (a(a(optJSONArray.getJSONObject(0), (Map) map)) >= a(a(optJSONArray.getJSONObject(1), (Map) map))) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case true:
                    if (a(a(optJSONArray.getJSONObject(0), (Map) map)) < a(a(optJSONArray.getJSONObject(1), (Map) map))) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case true:
                    if (a(a(optJSONArray.getJSONObject(0), (Map) map)) > a(a(optJSONArray.getJSONObject(1), (Map) map))) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case true:
                    return Boolean.valueOf(a(a(optJSONArray.getJSONObject(0), (Map) map), a(optJSONArray.getJSONObject(1), (Map) map)));
                case true:
                    return Boolean.valueOf(b(a(optJSONArray.getJSONObject(0), (Map) map), a(optJSONArray.getJSONObject(1), (Map) map)));
                case true:
                    if (a(a(optJSONArray.getJSONObject(0), (Map) map), a(optJSONArray.getJSONObject(1), (Map) map))) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case true:
                    if (b(a(optJSONArray.getJSONObject(0), (Map) map), a(optJSONArray.getJSONObject(1), (Map) map))) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case true:
                    a = a(optJSONArray.getJSONObject(0), (Map) map);
                    if (b(a)) {
                        jSONObject = optJSONArray.getJSONObject(1);
                        break;
                    }
                    return a;
                case true:
                    a = a(optJSONArray.getJSONObject(0), (Map) map);
                    if (!b(a)) {
                        jSONObject = optJSONArray.getJSONObject(1);
                        break;
                    }
                    return a;
                case true:
                    if (b(a(optJSONArray.getJSONObject(0), (Map) map))) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                default:
                    return null;
            }
        }
    }
}
