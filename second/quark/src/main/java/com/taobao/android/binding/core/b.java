package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.alibaba.fastjson.a;
import com.taobao.weex.ac;
import com.taobao.weex.bridge.c;
import com.taobao.weex.i;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;

/* compiled from: ProGuard */
abstract class b implements be {
    volatile Map<String, List<j>> a;
    c b;
    final Map<String, Object> c = new HashMap();
    String d;
    protected int e;
    av f;
    a<String, h> g = new a();

    protected abstract void a(@NonNull Map<String, Object> map);

    b(@NonNull ac acVar) {
        this.d = acVar.e;
        this.e = acVar.o;
    }

    public void a(@NonNull String str, @Nullable Map<String, Object> map, @Nullable av avVar, @NonNull List<Map<String, Object>> list, @Nullable c cVar) {
        a();
        if (this.a == null) {
            this.a = new HashMap();
        }
        for (Map map2 : list) {
            String a = dz.a(map2, "element");
            String a2 = dz.a(map2, "property");
            av b = dz.b(map2, "expression");
            String a3 = dz.a(map2, "config");
            Map map3 = null;
            if (!TextUtils.isEmpty(a3)) {
                try {
                    map3 = a.b(a3);
                } catch (Exception e) {
                    WXLogUtils.e("ExpressionBinding", "parse config failed.\n" + e.getMessage());
                }
            }
            if (TextUtils.isEmpty(a) || TextUtils.isEmpty(a2) || b == null) {
                WXLogUtils.e("ExpressionBinding", "skip illegal binding args[" + a + "," + a2 + "," + b + "]");
            } else {
                j jVar = new j(a, b, a2, str, map3);
                List list2 = (List) this.a.get(a);
                if (list2 == null) {
                    list2 = new ArrayList(4);
                    this.a.put(a, list2);
                    list2.add(jVar);
                } else if (!list2.contains(jVar)) {
                    list2.add(jVar);
                }
            }
        }
        this.b = cVar;
        this.f = avVar;
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
        ci.a(this.c, this.e);
        dy.a(this.c);
    }

    final boolean a(av avVar, @NonNull Map<String, Object> map) {
        boolean booleanValue;
        if (!(avVar == null || TextUtils.isEmpty(avVar.b))) {
            try {
                booleanValue = ((Boolean) new h(avVar.b).a((Map) map)).booleanValue();
            } catch (Exception e) {
                if (i.c()) {
                    Log.e("ExpressionBinding", "evaluateExitExpression failed. " + e.getMessage());
                }
            }
            if (booleanValue) {
                a();
                try {
                    a(map);
                } catch (Exception e2) {
                    if (i.c()) {
                        Log.e("ExpressionBinding", "execute exit expression failed: " + e2.getMessage());
                    }
                }
                i.c();
            }
            return booleanValue;
        }
        booleanValue = false;
        if (booleanValue) {
            a();
            a(map);
            i.c();
        }
        return booleanValue;
    }

    final void a(@Nullable Map<String, List<j>> map, @NonNull Map<String, Object> map2, @NonNull String str) throws IllegalArgumentException, JSONException {
        if (map == null) {
            WXLogUtils.e("ExpressionBinding", "expression args is null");
        } else if (map.isEmpty()) {
            WXLogUtils.e("ExpressionBinding", "no expression need consumed");
        } else {
            if (i.c()) {
                String.format(Locale.CHINA, "consume expression with %d tasks. event type is %s", new Object[]{Integer.valueOf(map.size()), str});
            }
            for (List<j> it : map.values()) {
                for (j jVar : it) {
                    if (str.equals(jVar.d)) {
                        ab b = ed.b(this.d, jVar.a);
                        if (b == null) {
                            WXLogUtils.e("ExpressionBinding", "failed to execute expression,target component not found.[ref:" + jVar.a + "]");
                        } else {
                            View hostView = b.getHostView();
                            if (hostView == null) {
                                WXLogUtils.e("ExpressionBinding", "failed to execute expression,target view not found.[ref:" + jVar.a + "]");
                            } else {
                                av avVar = jVar.b;
                                if (!(avVar == null || avVar.b == null)) {
                                    h hVar = (h) this.g.get(avVar.b);
                                    if (hVar == null) {
                                        hVar = new h(avVar.b);
                                        this.g.put(avVar.b, hVar);
                                    }
                                    Object a = hVar.a((Map) map2);
                                    if (a == null) {
                                        WXLogUtils.e("ExpressionBinding", "failed to execute expression,expression result is null");
                                    } else {
                                        as.a(jVar.c).a(b, hostView, a, jVar.e);
                                    }
                                }
                            }
                        }
                    } else if (i.c()) {
                        WXLogUtils.d("ExpressionBinding", "skip expression with wrong event type.[expected:" + str + ",found:" + jVar.d + "]");
                    }
                }
            }
        }
    }

    final void a() {
        WXLogUtils.d("ExpressionBinding", "all expression are cleared");
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
        this.f = null;
    }
}
