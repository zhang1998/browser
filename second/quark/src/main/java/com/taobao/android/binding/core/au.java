package com.taobao.android.binding.core;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.text.TextUtils;
import com.taobao.weex.ac;
import com.taobao.weex.bridge.c;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
final class au extends b implements ck {
    private boolean h = false;
    private double i;
    private double j;
    private double k;
    private double l;
    private double m;
    private double n;
    private cl o;
    private cm p;
    private cm q;
    private cm r;
    private String s;
    private LinkedList<Double> t = new LinkedList();
    private ea u = new ea(0.0d);
    private ea v = new ea(1.0d);
    private at w = new at((byte) 0);

    au(@NonNull ac acVar) {
        super(acVar);
        Context b = acVar.b();
        if (b != null) {
            this.o = cl.a(b);
        }
    }

    public final boolean a(@NonNull String str, @NonNull String str2) {
        if (this.o == null) {
            return false;
        }
        cl clVar = this.o;
        if (!(clVar.a == null || clVar.a.contains(this))) {
            clVar.a.add(this);
        }
        return this.o.a();
    }

    public final void a(String str) {
    }

    public final void a(@NonNull String str, @Nullable Map<String, Object> map, @Nullable av avVar, @NonNull List<Map<String, Object>> list, @Nullable c cVar) {
        String str2;
        super.a(str, map, avVar, list, cVar);
        if (map != null) {
            str2 = (String) map.get("sceneType");
            if (TextUtils.isEmpty(str2)) {
                str2 = "2d";
            } else {
                str2 = str2.toLowerCase();
            }
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2) || !("2d".equals(str2) || "3d".equals(str2))) {
            str2 = "2d";
        }
        this.s = str2;
        i.c();
        if ("2d".equals(str2)) {
            this.p = new cm(null, Double.valueOf(90.0d), null);
            this.q = new cm(Double.valueOf(0.0d), null, Double.valueOf(90.0d));
        } else if ("3d".equals(str2)) {
            this.r = new cm(null, null, null);
        }
    }

    public final boolean b(@NonNull String str, @NonNull String str2) {
        a();
        if (this.o == null) {
            return false;
        }
        a("end", this.l, this.m, this.n);
        return this.o.a((ck) this);
    }

    public final void b() {
        if (this.o != null) {
            this.o.a((ck) this);
            this.o.b();
        }
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
    }

    public final void a(double d, double d2, double d3) {
        double round = (double) Math.round(d);
        double round2 = (double) Math.round(d2);
        double round3 = (double) Math.round(d3);
        if (round != this.l || round2 != this.m || round3 != this.n) {
            double doubleValue;
            if (!this.h) {
                this.h = true;
                a("start", round, round2, round3);
                this.i = round;
                this.j = round2;
                this.k = round3;
            }
            Object obj = null;
            cn a;
            if ("2d".equals(this.s)) {
                if (!(this.p == null || this.q == null)) {
                    this.t.add(Double.valueOf(round));
                    if (this.t.size() > 5) {
                        this.t.removeFirst();
                    }
                    a(this.t);
                    doubleValue = (((Double) this.t.get(this.t.size() - 1)).doubleValue() - this.i) % 360.0d;
                    a = this.p.a(round2, round3, doubleValue);
                    cn a2 = this.q.a(round2, round3, doubleValue);
                    this.u.a(0.0d);
                    this.u.a(a);
                    this.v.a(1.0d);
                    this.v.a(a2);
                    double toDegrees = Math.toDegrees(Math.acos(this.u.a)) - 90.0d;
                    double toDegrees2 = Math.toDegrees(Math.acos(this.v.b)) - 90.0d;
                    if (Double.isNaN(toDegrees) || Double.isNaN(toDegrees2) || Double.isInfinite(toDegrees) || Double.isInfinite(toDegrees2)) {
                        obj = null;
                    } else {
                        toDegrees2 = (double) Math.round(toDegrees2);
                        this.w.a = (double) Math.round(toDegrees);
                        this.w.b = toDegrees2;
                    }
                }
                obj = 1;
            } else if ("3d".equals(this.s)) {
                if (this.r != null) {
                    this.t.add(Double.valueOf(round));
                    if (this.t.size() > 5) {
                        this.t.removeFirst();
                    }
                    a(this.t);
                    a = this.r.a(round2, round3, (((Double) this.t.get(this.t.size() - 1)).doubleValue() - this.i) % 360.0d);
                    if (Double.isNaN(a.a) || Double.isNaN(a.b) || Double.isNaN(a.c) || Double.isInfinite(a.a) || Double.isInfinite(a.b) || Double.isInfinite(a.c)) {
                        obj = null;
                    } else {
                        this.w.a = a.a;
                        this.w.b = a.b;
                        this.w.c = a.c;
                    }
                }
                obj = 1;
            }
            if (obj != null) {
                doubleValue = this.w.a;
                double d4 = this.w.b;
                double d5 = this.w.c;
                this.l = round;
                this.m = round2;
                this.n = round3;
                try {
                    ci.a(this.c, round, round2, round3, this.i, this.j, this.k, doubleValue, d4, d5);
                    if (!a(this.f, this.c)) {
                        a(this.a, this.c, "orientation");
                    }
                } catch (Exception e) {
                    WXLogUtils.e("ExpressionBinding", "runtime error\n" + e.getMessage());
                }
            }
        }
    }

    private static void a(List<Double> list) {
        int size = list.size();
        if (size > 1) {
            int i = 1;
            while (i < size) {
                if (!(list.get(i - 1) == null || list.get(i) == null)) {
                    if (((Double) list.get(i)).doubleValue() - ((Double) list.get(i - 1)).doubleValue() < -180.0d) {
                        list.set(i, Double.valueOf(((Math.floor(((Double) list.get(i - 1)).doubleValue() / 360.0d) + 1.0d) * 360.0d) + ((Double) list.get(i)).doubleValue()));
                    }
                    if (((Double) list.get(i)).doubleValue() - ((Double) list.get(i - 1)).doubleValue() > 180.0d) {
                        list.set(i, Double.valueOf(((Double) list.get(i)).doubleValue() - 360.0d));
                    }
                }
                i++;
            }
        }
    }

    protected final void a(@NonNull Map<String, Object> map) {
        a("exit", ((Double) map.get("alpha")).doubleValue(), ((Double) map.get("beta")).doubleValue(), ((Double) map.get("gamma")).doubleValue());
    }

    private void a(String str, double d, double d2, double d3) {
        if (this.b != null) {
            Map hashMap = new HashMap();
            hashMap.put("state", str);
            hashMap.put("alpha", Double.valueOf(d));
            hashMap.put("beta", Double.valueOf(d2));
            hashMap.put("gamma", Double.valueOf(d3));
            this.b.b(hashMap);
            if (i.c()) {
                WXLogUtils.d("ExpressionBinding", ">>>>>>>>>>>fire event:(" + str + "," + d + "," + d2 + "," + d3 + ")");
            }
        }
    }

    public final void c() {
        if (this.o != null) {
            this.o.b();
        }
    }

    public final void d() {
        if (this.o != null) {
            this.o.a();
        }
    }
}
