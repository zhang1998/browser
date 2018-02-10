package com.taobao.android.binding.core;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.text.TextUtils;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class ci {
    private static Object A = new by();
    private static ArgbEvaluator B = new ArgbEvaluator();
    private static Object C = new bz();
    private static Object D = new ca();
    public static Object a = Double.valueOf(2.718281828459045d);
    private static Object b = new bh();
    private static Object c = new bs();
    private static Object d = new cb();
    private static Object e = new cc();
    private static Object f = new cd();
    private static Object g = new ce();
    private static Object h = new cf();
    private static Object i = new cg();
    private static Object j = new ch();
    private static Object k = new bi();
    private static Object l = new bj();
    private static Object m = new bk();
    private static Object n = new bl();
    private static Object o = new bm();
    private static Object p = new bn();
    private static Object q = new bo();
    private static Object r = new bp();
    private static Object s = new bq();
    private static Object t = new br();
    private static Object u = Double.valueOf(3.141592653589793d);
    private static Object v = new bt();
    private static Object w = new bu();
    private static Object x = new bv();
    private static Map<Integer, Object> y = new HashMap();
    private static Object z = new bx();

    static void a(Map<String, Object> map, double d, double d2, int i) {
        map.put("x", Double.valueOf(WXViewUtils.b(d, i)));
        map.put("y", Double.valueOf(WXViewUtils.b(d2, i)));
        map.put("internal_x", Double.valueOf(d));
        map.put("internal_y", Double.valueOf(d2));
    }

    static void a(Map<String, Object> map, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        map.put("alpha", Double.valueOf(d));
        map.put("beta", Double.valueOf(d2));
        map.put("gamma", Double.valueOf(d3));
        map.put("dalpha", Double.valueOf(d - d4));
        map.put("dbeta", Double.valueOf(d2 - d5));
        map.put("dgamma", Double.valueOf(d3 - d6));
        map.put("x", Double.valueOf(d7));
        map.put("y", Double.valueOf(d8));
        map.put("z", Double.valueOf(d9));
    }

    static void a(Map<String, Object> map, double d) {
        map.put("t", Double.valueOf(d));
    }

    static void a(Map<String, Object> map, double d, double d2, double d3, double d4, double d5, double d6, int i) {
        map.put("x", Double.valueOf(WXViewUtils.b(d, i)));
        map.put("y", Double.valueOf(WXViewUtils.b(d2, i)));
        map.put("dx", Double.valueOf(WXViewUtils.b(d3, i)));
        map.put("dy", Double.valueOf(WXViewUtils.b(d4, i)));
        map.put("tdx", Double.valueOf(WXViewUtils.b(d5, i)));
        map.put("tdy", Double.valueOf(WXViewUtils.b(d6, i)));
        map.put("internal_x", Double.valueOf(d));
        map.put("internal_y", Double.valueOf(d2));
    }

    static void a(Map<String, Object> map, int i) {
        map.put("sin", b);
        map.put("cos", c);
        map.put("tan", d);
        map.put("asin", e);
        map.put("acos", f);
        map.put("atan", g);
        map.put("atan2", h);
        map.put("pow", i);
        map.put("exp", j);
        map.put("sqrt", k);
        map.put("cbrt", l);
        map.put("log", m);
        map.put("abs", n);
        map.put("sign", o);
        map.put("ceil", p);
        map.put("floor", q);
        map.put("round", r);
        map.put("max", s);
        map.put("min", t);
        map.put("PI", u);
        map.put("E", a);
        map.put(Style.WX_TRANSLATE, v);
        map.put("scale", w);
        map.put("matrix", x);
        String str = "real";
        Object obj = y.get(Integer.valueOf(i));
        if (obj == null) {
            obj = new bw(i);
            y.put(Integer.valueOf(i), obj);
        }
        map.put(str, obj);
        map.put("rgb", z);
        map.put("rgba", A);
        map.put("evaluateColor", C);
        map.put("asArray", D);
    }

    static /* synthetic */ int a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Unknown color");
        }
        if (str.startsWith("'") || str.startsWith("\"")) {
            str = str.substring(1, str.length() - 1);
        }
        int parseColor = Color.parseColor(str);
        return Color.argb(255, Color.red(parseColor), Color.green(parseColor), Color.blue(parseColor));
    }
}
