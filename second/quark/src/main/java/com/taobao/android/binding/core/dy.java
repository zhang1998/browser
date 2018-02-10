package com.taobao.android.binding.core;

import com.taobao.weex.ui.animation.WXAnimationBean;
import java.util.Map;

/* compiled from: ProGuard */
final class dy {
    private static Object A = new di();
    private static Object B = new dj();
    private static Object C = new dk();
    private static Object D = new dl();
    private static Object E = new dn();
    private static Object F = new do();
    private static Object G = new dp();
    private static Object a = new cq();
    private static Object b = new db();
    private static final dx<dw> c = new dx();
    private static Object d = new dm();
    private static Object e = new dq();
    private static Object f = new dr();
    private static Object g = new ds();
    private static Object h = new dt();
    private static Object i = new du();
    private static Object j = new dv();
    private static Object k = new cr();
    private static Object l = new cs();
    private static Object m = new ct();
    private static Object n = new cu();
    private static Object o = new cv();
    private static Object p = new cw();
    private static Object q = new cx();
    private static Object r = new cy();
    private static Object s = new cz();
    private static Object t = new da();
    private static Object u = new dc();
    private static Object v = new dd();
    private static Object w = new de();
    private static Object x = new df();
    private static Object y = new dg();
    private static Object z = new dh();

    static void a(Map<String, Object> map) {
        map.put(WXAnimationBean.LINEAR, a);
        map.put("easeInQuad", d);
        map.put("easeOutQuad", e);
        map.put("easeInOutQuad", f);
        map.put("easeInCubic", g);
        map.put("easeOutCubic", h);
        map.put("easeInOutCubic", i);
        map.put("easeInQuart", j);
        map.put("easeOutQuart", k);
        map.put("easeInOutQuart", l);
        map.put("easeInQuint", m);
        map.put("easeOutQuint", n);
        map.put("easeInOutQuint", o);
        map.put("easeInSine", p);
        map.put("easeOutSine", q);
        map.put("easeInOutSine", r);
        map.put("easeInExpo", s);
        map.put("easeOutExpo", t);
        map.put("easeInOutExpo", u);
        map.put("easeInCirc", v);
        map.put("easeOutCirc", w);
        map.put("easeInOutCirc", x);
        map.put("easeInElastic", y);
        map.put("easeOutElastic", z);
        map.put("easeInOutElastic", A);
        map.put("easeInBack", B);
        map.put("easeOutBack", C);
        map.put("easeInOutBack", D);
        map.put("easeInBounce", E);
        map.put("easeOutBounce", F);
        map.put("easeInOutBounce", G);
        map.put("cubicBezier", b);
    }

    private static double c(double d, double d2, double d3, double d4) {
        double d5 = d / d4;
        if (d5 < 0.36363636363636365d) {
            return ((d5 * (7.5625d * d5)) * d3) + d2;
        }
        if (d5 < 0.7272727272727273d) {
            d5 -= 0.5454545454545454d;
            return (((d5 * (7.5625d * d5)) + 0.75d) * d3) + d2;
        } else if (d5 < 0.9090909090909091d) {
            d5 -= 0.8181818181818182d;
            return (((d5 * (7.5625d * d5)) + 0.9375d) * d3) + d2;
        } else {
            d5 -= 0.9545454545454546d;
            return (((d5 * (7.5625d * d5)) + 0.984375d) * d3) + d2;
        }
    }

    static /* synthetic */ dw a(float f, float f2, float f3, float f4) {
        for (dw dwVar : c.a) {
            if (Float.compare(dwVar.a, f) == 0 && Float.compare(dwVar.c, f3) == 0 && Float.compare(dwVar.b, f2) == 0 && Float.compare(dwVar.d, f4) == 0) {
                return dwVar;
            }
        }
        return null;
    }
}
