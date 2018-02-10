package com.taobao.weex;

import android.app.Application;
import android.content.Context;
import com.UCMobile.Apollo.ApolloMetaData;
import com.taobao.weex.b.a.a;
import com.taobao.weex.b.c.g;
import com.taobao.weex.bridge.s;
import com.taobao.weex.bridge.v;
import com.taobao.weex.c.ag;
import com.taobao.weex.c.al;
import com.taobao.weex.c.am;
import com.taobao.weex.c.x;
import com.taobao.weex.common.l;
import com.taobao.weex.common.o;
import com.taobao.weex.d.j;
import com.taobao.weex.ui.a.k;
import com.taobao.weex.ui.animation.e;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.ad;
import com.taobao.weex.ui.component.ae;
import com.taobao.weex.ui.component.aj;
import com.taobao.weex.ui.component.ak;
import com.taobao.weex.ui.component.an;
import com.taobao.weex.ui.component.ap;
import com.taobao.weex.ui.component.aq;
import com.taobao.weex.ui.component.ar;
import com.taobao.weex.ui.component.as;
import com.taobao.weex.ui.component.at;
import com.taobao.weex.ui.component.au;
import com.taobao.weex.ui.component.av;
import com.taobao.weex.ui.component.b.h;
import com.taobao.weex.ui.component.b.m;
import com.taobao.weex.ui.component.b.r;
import com.taobao.weex.ui.component.bd;
import com.taobao.weex.ui.component.be;
import com.taobao.weex.ui.component.bg;
import com.taobao.weex.ui.component.bk;
import com.taobao.weex.ui.component.bn;
import com.taobao.weex.ui.component.bp;
import com.taobao.weex.ui.component.br;
import com.taobao.weex.ui.component.bs;
import com.taobao.weex.ui.component.bt;
import com.taobao.weex.ui.component.ca;
import com.taobao.weex.ui.component.cd;
import com.taobao.weex.ui.f;
import com.taobao.weex.ui.i;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.a.b;
import com.taobao.weex.utils.a.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class q {
    private static volatile boolean a = false;
    private static final Object b = new Object();

    public static boolean a() {
        boolean z;
        synchronized (b) {
            z = a;
        }
        return z;
    }

    public static void a(Context context, d dVar) {
        synchronized (b) {
            if (a) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            i.f = context;
            Application application = (Application) context.getApplicationContext();
            i.e = application;
            i.j = false;
            s.a().a(new n(dVar, application));
            c cVar = new c(s.a());
            try {
                a(new f(bt.class, new bs()), false, "text");
                a(new f(ae.class, new ad()), false, "container", "div", ApolloMetaData.KEY_HEADER, "footer");
                a(new f(ap.class, new an()), false, "image", "img");
                a(new f(be.class, new bd()), false, "scroller");
                a(new f(bk.class, new bg()), true, "slider", "cycleslider");
                a(new f(bp.class, new bn()), true, "slider-neighbor");
                a(h.class, false, "simplelist");
                a(r.class, false, "list", "vlist", "recycler", "waterfall");
                a(com.taobao.weex.ui.component.b.f.class, false, "hlist");
                a("cell", m.class, true);
                a("indicator", ar.class, true);
                a("video", ca.class, false);
                a("input", as.class, false);
                a("textarea", com.taobao.weex.ui.component.q.class, false);
                a("switch", br.class, false);
                a("a", com.taobao.weex.ui.component.s.class, false);
                a("embed", aj.class, true);
                c("web", cd.class);
                c("refresh", av.class);
                c("loading", at.class);
                c("loading-indicator", au.class);
                c(ApolloMetaData.KEY_HEADER, ak.class);
                b("modal", com.taobao.weex.ui.a.h.class, false);
                b("instanceWrap", l.class, true);
                b("animation", e.class, true);
                b("webview", com.taobao.weex.ui.a.m.class, true);
                b("stream", j.class, false);
                b("timer", k.class, false);
                b("storage", com.taobao.weex.b.c.r.class, true);
                b("clipboard", a.class, true);
                b("globalEvent", j.class, false);
                b("meta", com.taobao.weex.ui.a.a.class, true);
                b("webSocket", com.taobao.weex.b.d.f.class, false);
                ag.a("simplelist", al.class);
                ag.a("indicator", aq.class);
                ag.a("text", com.taobao.weex.c.at.class);
                ag.a(ApolloMetaData.KEY_HEADER, x.class);
                ag.a("cell", x.class);
                ag.a("input", com.taobao.weex.c.c.class);
                ag.a("textarea", com.taobao.weex.c.s.class);
                ag.a("switch", com.taobao.weex.c.aq.class);
                ag.a("list", al.class);
                ag.a("vlist", al.class);
                ag.a("hlist", al.class);
                ag.a("scroller", com.taobao.weex.c.an.class);
                ag.a("recycler", am.class);
                ag.a("waterfall", am.class);
            } catch (Throwable e) {
                WXLogUtils.e("[WXSDKEngine] register:", e);
            }
            cVar.c = false;
            cVar.a.a(new b(cVar));
            cVar.a.a(null);
            i.s = System.currentTimeMillis() - currentTimeMillis;
            WXLogUtils.renderPerformanceLog("SDKInitInvokeTime", i.s);
            a = true;
        }
    }

    public static boolean a(String str, Class<? extends ab> cls, boolean z) throws com.taobao.weex.common.h {
        return a((Class) cls, z, str);
    }

    private static boolean a(Class<? extends ab> cls, boolean z, String... strArr) throws com.taobao.weex.common.h {
        if (cls == null) {
            return false;
        }
        return a(new f(cls), z, strArr);
    }

    private static boolean a(com.taobao.weex.ui.b bVar, boolean z, String... strArr) throws com.taobao.weex.common.h {
        boolean z2 = true;
        for (String str : strArr) {
            Map hashMap = new HashMap();
            if (z) {
                hashMap.put("append", "tree");
            }
            z2 = z2 && i.a(str, bVar, hashMap);
        }
        return z2;
    }

    public static <T extends o> boolean b(String str, Class<T> cls, boolean z) throws com.taobao.weex.common.h {
        return cls != null && v.a(str, new com.taobao.weex.common.f(cls), z);
    }

    public static boolean a(String str, Class<? extends o> cls) throws com.taobao.weex.common.h {
        return b(str, cls, false);
    }

    public static boolean b(String str, Class<? extends com.taobao.weex.c.ae> cls) throws com.taobao.weex.common.h {
        return ag.a(str, cls);
    }

    public static boolean c(String str, Class<? extends ab> cls) throws com.taobao.weex.common.h {
        return i.a(str, new f(cls), new HashMap());
    }

    public static com.taobao.weex.b.c.i b() {
        ad a = ad.a();
        if (a.k == null) {
            if (i.e != null) {
                a.k = new g(i.e);
            } else {
                WXLogUtils.e("WXStorageModule", "No Application context found,you should call WXSDKEngine#initialize() method in your application");
            }
        }
        return a.k;
    }

    public static void c() {
        Context e = i.e();
        i.o = i.o;
        s a = s.a();
        a.d = false;
        a.a(i.o);
        s.a().b(null);
        try {
            s.a().b();
        } catch (com.taobao.weex.common.h e2) {
        }
        v.a();
        i.a();
        ad.a().a(new o(e), 1000);
    }
}
