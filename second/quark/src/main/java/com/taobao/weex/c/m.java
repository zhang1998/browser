package com.taobao.weex.c;

import android.text.TextUtils;
import android.util.Pair;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.c.a.i;
import com.taobao.weex.c.b.h;
import com.taobao.weex.common.w;
import com.taobao.weex.ui.animation.WXAnimationBean;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.c;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.ui.d;
import com.taobao.weex.ui.k;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public final class m implements e {
    final ConcurrentHashMap<String, ae> a;
    ad b;
    String c;
    com.taobao.weex.ui.m d;
    ArrayList<c> e;
    Set<Pair<String, Map<String, Object>>> f;
    h g;
    volatile boolean h;
    boolean i = false;
    Map<String, i> j = new HashMap();
    private ad k;

    public m(String str, com.taobao.weex.ui.m mVar) {
        this.c = str;
        this.g = new h();
        this.a = new ConcurrentHashMap();
        this.e = new ArrayList();
        this.f = new LinkedHashSet();
        this.d = mVar;
        this.b = new h(this.a);
        this.k = new l(this.a);
    }

    public final String a() {
        return this.c;
    }

    public final ad b() {
        return this.b;
    }

    public final ad e() {
        return this.k;
    }

    public final void a(String str, ab abVar) {
        i iVar = new i();
        iVar.a = abVar;
        this.j.put(str, iVar);
    }

    final void f() {
        int size = this.e.size();
        for (int i = 0; i < size && !this.i; i++) {
            com.taobao.weex.ui.m mVar = this.d;
            mVar.b.post(w.a(new k(mVar, this.c, (c) this.e.get(i))));
        }
        this.e.clear();
    }

    final void g() {
        for (Pair pair : this.f) {
            if (!TextUtils.isEmpty((CharSequence) pair.first)) {
                WXAnimationBean b = b((String) pair.first, (Map) pair.second);
                if (b != null) {
                    a(new i((String) pair.first, b));
                }
            }
        }
    }

    final void a(ab abVar) {
        if (abVar != null) {
            ae aeVar = (ae) this.a.get(abVar.getRef());
            if (aeVar != null) {
                aeVar.x = false;
                abVar.updateDom(aeVar);
                if (abVar instanceof bv) {
                    bv bvVar = (bv) abVar;
                    int j = bvVar.j();
                    for (int i = 0; i < j; i++) {
                        a(bvVar.h(i));
                    }
                }
            }
        }
    }

    public final void a(String str, Map<String, Object> map) {
        this.f.add(new Pair(str, map));
        this.h = true;
    }

    public final void a(p pVar) {
        this.e.add(new r(pVar, this.d.a(this.c)));
        this.h = true;
    }

    public final void a(String str) {
        this.a.remove(str);
    }

    public final void b(String str, ab abVar) {
        com.taobao.weex.ui.m mVar = this.d;
        d dVar = (d) mVar.a.get(this.c);
        if (dVar != null) {
            dVar.a.put(str, abVar);
        }
    }

    public final ab b(String str) {
        return this.d.a(this.c, str);
    }

    public final ac d() {
        return this.d.b(this.c);
    }

    public final ae c(String str) {
        return (ae) this.a.get(str);
    }

    private WXAnimationBean b(String str, Map<String, Object> map) {
        if (map != null) {
            try {
                Object obj = map.get("transform");
                if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                    String str2 = (String) map.get("transformOrigin");
                    WXAnimationBean wXAnimationBean = new WXAnimationBean();
                    ae aeVar = (ae) this.a.get(str);
                    int o = (int) aeVar.o();
                    int p = (int) aeVar.p();
                    wXAnimationBean.styles = new Style();
                    wXAnimationBean.styles.init(str2, (String) obj, o, p, ad.a(this.c));
                    return wXAnimationBean;
                }
            } catch (Throwable e) {
                WXLogUtils.e("", e);
                return null;
            }
        }
        return null;
    }

    public final ad c() {
        if (a.a == null) {
            a.a = new a();
        }
        return a.a;
    }
}
