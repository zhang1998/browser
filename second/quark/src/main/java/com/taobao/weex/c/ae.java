package com.taobao.weex.c;

import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.text.TextUtils;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.bridge.x;
import com.taobao.weex.bridge.z;
import com.taobao.weex.c.b.k;
import com.taobao.weex.c.b.m;
import com.taobao.weex.i;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ProGuard */
public class ae extends k implements o, Cloneable {
    public static final String m = ae.class.getSimpleName();
    static final ae n;
    private AtomicBoolean l = new AtomicBoolean();
    public int o = 750;
    n p;
    public String q = "_root";
    public String r = "div";
    ao s;
    v t;
    public ai u;
    @Deprecated
    public ae v;
    ArrayList<String> w;
    boolean x = false;
    private List<ae> y;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return v();
    }

    static {
        ae aeVar = new ae();
        n = aeVar;
        aeVar.q = "_destroyed";
    }

    public final void a(ad... adVarArr) {
        int i = 0;
        if (adVarArr != null) {
            for (ad a : adVarArr) {
                a.a(this);
            }
            int u = u();
            while (i < u) {
                b(i).a(adVarArr);
                i++;
            }
        }
    }

    public final String b_() {
        return this.q;
    }

    public final String r() {
        return this.r;
    }

    @NonNull
    public final ao g() {
        if (this.s == null) {
            this.s = new ao();
        }
        return this.s;
    }

    @NonNull
    public final v i() {
        if (this.t == null) {
            this.t = new v();
        }
        return this.t;
    }

    @NonNull
    public final ai c_() {
        if (this.u == null) {
            this.u = new ai();
        }
        return this.u;
    }

    public static void a(ae aeVar, float f, float f2) {
        aeVar.q = "_root";
        ao g = aeVar.g();
        Map hashMap = new HashMap(5);
        if (!g.containsKey("flexDirection")) {
            hashMap.put("flexDirection", "column");
        }
        if (!g.containsKey(Style.BACKGROUND_COLOR)) {
            hashMap.put(Style.BACKGROUND_COLOR, "#ffffff");
        }
        hashMap.put("defaultWidth", Float.valueOf(f2));
        hashMap.put("defaultHeight", Float.valueOf(f));
        aeVar.b(hashMap);
    }

    public final void a(ae aeVar) {
        ai aiVar = null;
        m mVar = aeVar.a_;
        m mVar2 = this.a_;
        mVar.a = mVar2.a;
        mVar.b = mVar2.b;
        mVar.c = mVar2.c;
        mVar.d = mVar2.d;
        mVar.e = mVar2.e;
        mVar.f = mVar2.f;
        mVar.g = mVar2.g;
        mVar.h = mVar2.h;
        mVar.i = mVar2.i;
        mVar.j = mVar2.j;
        mVar.k = mVar2.k;
        mVar.l = mVar2.l;
        mVar.m[1] = mVar2.m[1];
        mVar.m[3] = mVar2.m[3];
        mVar.m[0] = mVar2.m[0];
        mVar.m[2] = mVar2.m[2];
        mVar.n[0] = mVar2.n[0];
        mVar.n[1] = mVar2.n[1];
        mVar.o = mVar2.o;
        mVar.p = mVar2.p;
        mVar.q = mVar2.q;
        mVar.r = mVar2.r;
        aeVar.q = this.q;
        aeVar.r = this.r;
        aeVar.s = this.s == null ? null : this.s.c();
        aeVar.t = this.t == null ? null : this.t.i();
        if (this.u != null) {
            aiVar = this.u.a();
        }
        aeVar.u = aiVar;
        aeVar.b.a(this.b);
    }

    private void a(e eVar) {
        int i = 0;
        if (eVar != null && eVar.size() > 0) {
            this.r = (String) eVar.get("type");
            this.q = (String) eVar.get("ref");
            Object obj = eVar.get("style");
            if (obj != null && (obj instanceof e)) {
                ao aoVar = new ao();
                aoVar.a((e) obj, false);
                this.s = aoVar;
            }
            obj = eVar.get("attr");
            if (obj != null && (obj instanceof e)) {
                this.t = new v((e) obj);
            }
            obj = eVar.get("event");
            if (obj != null && (obj instanceof b)) {
                ai aiVar = new ai();
                b bVar = (b) obj;
                int size = bVar.size();
                while (i < size) {
                    aiVar.add(bVar.c(i));
                    i++;
                }
                this.u = aiVar;
            }
        }
    }

    public void a() {
    }

    public void s() {
    }

    public final boolean t() {
        return f_() || e_();
    }

    public final boolean f() {
        return this.s == null ? false : this.s.b();
    }

    public Object q() {
        return null;
    }

    public final void b(ae aeVar) {
        if (aeVar != null && this.y != null && !this.l.get()) {
            int indexOf = this.y.indexOf(aeVar);
            if (!(aeVar == null || this.y == null || this.l.get())) {
                int indexOf2 = this.y.indexOf(aeVar);
                if (indexOf2 != -1) {
                    ((ae) this.y.remove(indexOf2)).v = null;
                } else if (i.c()) {
                    WXLogUtils.e("[WXDomObject] remove function error");
                }
            }
            if (indexOf != -1) {
                ((k) this.g.remove(indexOf)).h = null;
                h();
            }
        }
    }

    public final int c(ae aeVar) {
        if (aeVar == null || this.y == null || this.l.get()) {
            return -1;
        }
        return this.y.indexOf(aeVar);
    }

    public void a(ae aeVar, int i) {
        if (aeVar != null && i >= -1 && !this.l.get()) {
            if (this.y == null) {
                this.y = new ArrayList();
            }
            if (i >= this.y.size()) {
                i = -1;
            }
            if (i == -1) {
                this.y.add(aeVar);
                super.a((k) aeVar, super.e());
            } else {
                this.y.add(i, aeVar);
                super.a((k) aeVar, i);
            }
            aeVar.v = this;
        }
    }

    public final ae b(int i) {
        if (this.y == null || this.l.get()) {
            return null;
        }
        return (ae) this.y.get(i);
    }

    public void a(Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            if (this.t == null) {
                this.t = new v();
            }
            this.t.putAll(map);
            super.h();
        }
    }

    public void b(Map<String, Object> map) {
        a((Map) map, false);
    }

    public final void a(Map<String, Object> map, boolean z) {
        if (map != null && !map.isEmpty()) {
            if (this.s == null) {
                this.s = new ao();
            }
            this.s.a((Map) map, z);
            super.h();
        }
    }

    public final int u() {
        return this.y == null ? 0 : this.y.size();
    }

    public ae v() {
        ae aeVar = null;
        if (!this.l.get()) {
            try {
                aeVar = af.a(this.r);
                a(aeVar);
            } catch (Throwable e) {
                if (i.c()) {
                    WXLogUtils.e("WXDomObject clone error: ", e);
                }
            }
        }
        return aeVar;
    }

    public Map<String, String> w() {
        return null;
    }

    @Nullable
    public static ae a(e eVar, ac acVar) {
        if (eVar == null || eVar.size() <= 0) {
            return null;
        }
        String str = (String) eVar.get("type");
        if (acVar.n) {
            z zVar = ad.a().o;
            if (zVar != null) {
                x b = zVar.b();
                if (!(b == null || b.a)) {
                    str = TextUtils.isEmpty(b.b) ? "div" : b.b;
                    eVar.a("type", str);
                    if (i.c() && b.c != null) {
                        WXLogUtils.e("[WXDomObject]onComponentValidate failure. >>> " + b.c.n_());
                    }
                }
            }
        }
        ae a = af.a(str);
        a.o = acVar.o;
        if (a == null) {
            return null;
        }
        a.a(eVar);
        a.p = acVar;
        Object obj = eVar.get("children");
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            int size = bVar.size();
            for (int i = 0; i < size; i++) {
                a.a(a(bVar.a(i), acVar), -1);
            }
        }
        return a;
    }
}
