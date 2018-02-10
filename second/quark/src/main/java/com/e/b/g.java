package com.e.b;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.c;
import com.alibaba.analytics.core.h.k;
import com.alibaba.wireless.security.SecExceptionCode;
import com.e.b.b.a;
import com.e.b.c.b;
import com.taobao.ju.track.JTrack.Page;
import com.uc.apollo.impl.SettingsConst;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* compiled from: ProGuard */
public final class g {
    private static g i = new g();
    Map<String, m> a = new HashMap();
    Queue<String> b = new LinkedList();
    String c = null;
    boolean d = false;
    public String e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private Map<String, String> j = new HashMap();
    private Map<String, p> k = new HashMap();
    private String l = null;
    private Map<String, String> m = new HashMap();
    private Map<String, String> n = null;
    private Queue<p> o = new LinkedList();
    private Map<String, String> p = new HashMap();
    private Queue<String> q = new LinkedList();

    public static g a() {
        return i;
    }

    private synchronized void a(p pVar) {
        pVar.a = new HashMap();
        pVar.b = 0;
        pVar.c = null;
        pVar.d = null;
        pVar.e = null;
        if (pVar.f == null || pVar.f != n.a) {
            pVar.f = null;
        }
        pVar.g = false;
        pVar.i = false;
        pVar.k = 0;
        pVar.l = null;
        if (!this.o.contains(pVar)) {
            this.o.add(pVar);
        }
        if (this.o.size() > 200) {
            for (int i = 0; i < 100; i++) {
                p pVar2 = (p) this.o.poll();
                if (pVar2 != null && this.k.containsKey(pVar2.j)) {
                    this.k.remove(pVar2.j);
                }
            }
        }
    }

    private synchronized void b(String str) {
        if (!this.q.contains(str)) {
            this.q.add(str);
        }
        if (this.q.size() > 100) {
            for (int i = 0; i < 50; i++) {
                String str2 = (String) this.q.poll();
                if (str2 != null && this.p.containsKey(str2)) {
                    this.p.remove(str2);
                }
            }
        }
    }

    @Deprecated
    public final synchronized void b() {
        this.d = true;
    }

    static String a(Object obj) {
        String str;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = obj.getClass().getSimpleName();
        }
        return str + obj.hashCode();
    }

    private synchronized p d(Object obj) {
        p pVar;
        String a = a(obj);
        if (this.k.containsKey(a)) {
            pVar = (p) this.k.get(a);
        } else {
            pVar = new p();
            this.k.put(a, pVar);
            pVar.j = a;
        }
        return pVar;
    }

    private synchronized void a(String str, p pVar) {
        this.k.put(str, pVar);
    }

    private synchronized void b(p pVar) {
        if (this.k.containsKey(pVar.j)) {
            this.k.remove(pVar.j);
        }
    }

    private synchronized void e(Object obj) {
        String a = a(obj);
        if (this.k.containsKey(a)) {
            this.k.remove(a);
        }
    }

    @Deprecated
    public final synchronized void b(Object obj) {
        a(obj, false);
    }

    final synchronized void a(Object obj, boolean z) {
        af.b();
        if (obj != null) {
            String a = a(obj);
            if (a == null || !a.equals(this.l)) {
                if (this.l != null) {
                    af.d("lost 2001", "Last page requires leave(" + this.l + ").");
                }
                p d = d(obj);
                if (z || !d.h) {
                    Map map;
                    Map hashMap;
                    m g;
                    a.a().a("pageAppear:" + obj.getClass().getSimpleName());
                    a = e.b().b;
                    if (a != null) {
                        e.b().c = a;
                        try {
                            this.j.put("spm", Uri.parse(a).getQueryParameter("spm"));
                        } catch (Throwable th) {
                        }
                        e.b().b = null;
                    }
                    String f = f(obj);
                    try {
                        a = Page.getPageName(obj.getClass().getSimpleName());
                        if (!TextUtils.isEmpty(a)) {
                            if (a.toLowerCase().endsWith("activity")) {
                                a = a.substring(0, a.length() - 8);
                            }
                            af.b("JTrack", "getPageName:" + a);
                            if (!TextUtils.isEmpty(null)) {
                                a = null;
                            }
                            if (!TextUtils.isEmpty(d.d)) {
                                a = d.d;
                            }
                            this.e = a;
                            d.d = a;
                            d.b = SystemClock.elapsedRealtime();
                            d.e = e.b().a;
                            d.g = true;
                            if (this.m != null) {
                                this.n = this.m;
                                d.l = this.m;
                                map = d.a;
                                if (map != null) {
                                    d.a = this.m;
                                } else {
                                    hashMap = new HashMap();
                                    hashMap.putAll(map);
                                    hashMap.putAll(this.m);
                                    d.a = hashMap;
                                }
                            }
                            this.m = null;
                            this.l = a(obj);
                            b(d);
                            a(a(obj), d);
                            if (z && d.h) {
                                g = g(obj);
                                if (g != null) {
                                    g.e = true;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                    }
                    a = f;
                    if (TextUtils.isEmpty(null)) {
                        a = null;
                    }
                    if (TextUtils.isEmpty(d.d)) {
                        a = d.d;
                    }
                    this.e = a;
                    d.d = a;
                    d.b = SystemClock.elapsedRealtime();
                    d.e = e.b().a;
                    d.g = true;
                    if (this.m != null) {
                        this.n = this.m;
                        d.l = this.m;
                        map = d.a;
                        if (map != null) {
                            hashMap = new HashMap();
                            hashMap.putAll(map);
                            hashMap.putAll(this.m);
                            d.a = hashMap;
                        } else {
                            d.a = this.m;
                        }
                    }
                    this.m = null;
                    this.l = a(obj);
                    b(d);
                    a(a(obj), d);
                    g = g(obj);
                    if (g != null) {
                        g.e = true;
                    }
                } else {
                    af.b("skip page[pageAppear]", "page name:" + obj.getClass().getSimpleName());
                }
            }
        } else {
            af.d("pageAppear", "The page object should not be null");
        }
    }

    final synchronized void a(Object obj, Map<String, String> map) {
        if (!(obj == null || map == null)) {
            if (map.size() != 0) {
                Map hashMap = new HashMap();
                hashMap.putAll(map);
                p d = d(obj);
                Map map2 = d.a;
                if (map2 == null) {
                    d.a = hashMap;
                } else {
                    Map hashMap2 = new HashMap();
                    hashMap2.putAll(map2);
                    hashMap2.putAll(hashMap);
                    d.a = hashMap2;
                }
            }
        }
        af.d("updatePageProperties", "failed to update project, parameters should not be null and the map should not be empty");
    }

    final synchronized void a(Object obj, String str) {
        if (obj != null) {
            if (!TextUtils.isEmpty(str)) {
                Map map;
                if (obj == null) {
                    map = null;
                } else {
                    Map hashMap = new HashMap();
                    if (this.j != null) {
                        hashMap.putAll(this.j);
                    }
                    map = d(obj).a;
                    if (map != null) {
                        hashMap.putAll(map);
                    }
                    map = hashMap;
                }
                String str2 = "";
                if (map != null) {
                    str2 = (String) map.get("utparam-cnt");
                }
                CharSequence a = a(str, str2);
                if (!TextUtils.isEmpty(a)) {
                    map = new HashMap();
                    map.put("utparam-cnt", a);
                    a(obj, map);
                }
            }
        }
    }

    final synchronized void b(Object obj, String str) {
        if (obj != null) {
            if (!TextUtils.isEmpty(str)) {
                d(obj).d = str;
                this.e = str;
            }
        }
    }

    final synchronized void a(Object obj, Uri uri) {
        if (obj != null) {
            d(obj).c = uri;
        }
    }

    final synchronized void a(Map<String, String> map) {
        if (map != null) {
            Map hashMap = new HashMap();
            hashMap.putAll(map);
            if (this.m == null) {
                this.m = hashMap;
            } else {
                String str = (String) this.m.get("utparam-url");
                this.m = hashMap;
                if (!TextUtils.isEmpty(str)) {
                    this.m.put("utparam-url", str);
                }
            }
        }
    }

    final synchronized void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = "";
            if (this.m != null) {
                str2 = (String) this.m.get("utparam-url");
            } else {
                this.m = new HashMap();
            }
            CharSequence a = a(str, str2);
            if (!TextUtils.isEmpty(a)) {
                Map hashMap = new HashMap();
                hashMap.put("utparam-url", a);
                this.m.putAll(hashMap);
            }
        }
    }

    final synchronized void c(Object obj) {
        if (obj != null) {
            d(obj).h = true;
        }
    }

    private void d() {
        this.j = new HashMap();
        this.l = null;
        this.e = null;
        this.n = null;
        e.b().c = null;
    }

    @Deprecated
    public final synchronized void a(Object obj, l lVar) {
        af.b();
        if (obj == null) {
            af.d("pageDisAppear", "The page object should not be null");
        } else if (this.l == null) {
            af.d("pageDisAppear", "UT has already recorded the page disappear event on this page");
        } else {
            p d = d(obj);
            if (d.g) {
                String uri;
                Uri uri2;
                String uri3;
                Object obj2;
                String b;
                Map map;
                String str;
                Object obj3;
                Uri uri4;
                Map hashMap;
                Object b2;
                Object obj4;
                String str2;
                CharSequence queryParameter;
                m g;
                boolean equals;
                String str3;
                CharSequence a;
                int indexOf;
                q qVar;
                b a2;
                a.a().a("pageDisAppear:" + obj.getClass().getSimpleName());
                if (d.f != null && n.a == d.f) {
                    if (1 == d.k) {
                        this.m = this.n;
                        e.b().b = e.b().c;
                    }
                    if (1 == d.k || d.i) {
                        a(d);
                        d();
                    }
                }
                long elapsedRealtime = SystemClock.elapsedRealtime() - d.b;
                if (obj instanceof Activity) {
                    if (!(!af.a() || ((Activity) obj).getIntent() == null || ((Activity) obj).getIntent().getData() == null)) {
                        af.b("pageDisAppear", "uri=" + ((Activity) obj).getIntent().getData().toString());
                    }
                    Uri uri5 = d.c;
                    if (uri5 != null) {
                        uri = uri5.toString();
                    } else {
                        uri = null;
                    }
                    uri2 = null;
                    Intent intent = ((Activity) obj).getIntent();
                    if (intent != null) {
                        uri2 = intent.getData();
                    }
                    if (uri2 != null) {
                        uri3 = uri2.toString();
                    } else {
                        uri3 = null;
                    }
                    if ((uri == null || uri.equals(r2)) && (r2 == null || r2.equals(uri))) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (d.c == null && r2 != null) {
                        d.c = uri2;
                    }
                }
                uri = d.d;
                String str4 = d.e;
                if (str4 == null || str4.length() == 0) {
                    str4 = "-";
                }
                Map map2 = this.j;
                if (map2 == null) {
                    map2 = new HashMap();
                }
                try {
                    if (obj instanceof Activity) {
                        uri2 = ((Activity) obj).getIntent().getData();
                        if (uri2 != null) {
                            af.b("JTrack", "uri:" + uri2.toString());
                        }
                        Map map3 = null;
                        if (!TextUtils.isEmpty(d.d)) {
                            map3 = Page.getArgsMap(d.d, uri2);
                            af.b("JTrack", "getArgsMap by pagename:" + d.d);
                        }
                        if (map3 == null || map3.size() == 0) {
                            map3 = Page.getArgsMap((Activity) obj, uri2);
                            af.b("JTrack", "getArgsMap by activity:" + obj.getClass().getName());
                        }
                        if (map3 != null && map3.size() > 0) {
                            map2.putAll(map3);
                            af.b("JTrack", "ArgsMap:" + com.alibaba.analytics.a.b.a(map3));
                        }
                    }
                } catch (Throwable th) {
                }
                if (d.a != null) {
                    map2.putAll(d.a);
                }
                if (obj instanceof f) {
                    f fVar = (f) obj;
                    CharSequence a3 = fVar.a();
                    if (!TextUtils.isEmpty(a3)) {
                        str4 = a3;
                    }
                    Map c = fVar.c();
                    if (c != null && c.size() > 0) {
                        this.j.putAll(c);
                        map2 = this.j;
                    }
                    b = fVar.b();
                    if (!TextUtils.isEmpty(b)) {
                        map = map2;
                        str = str4;
                        obj3 = "";
                        uri3 = "";
                        uri4 = d.c;
                        if (uri4 != null) {
                            try {
                                hashMap = new HashMap();
                                b2 = b(uri4);
                                if (!TextUtils.isEmpty(b2)) {
                                    obj4 = null;
                                    str2 = obj.getClass().getSimpleName() + obj.hashCode();
                                    if (this.p.containsKey(str2) && b2.equals(this.p.get(str2))) {
                                        obj4 = 1;
                                    }
                                    if (obj4 == null) {
                                        hashMap.put("spm", b2);
                                        this.p.put(str2, b2);
                                        b(str2);
                                    }
                                }
                                try {
                                    uri3 = uri4.getQueryParameter("utparam");
                                    queryParameter = uri4.getQueryParameter("scm");
                                    if (!TextUtils.isEmpty(queryParameter)) {
                                        hashMap.put("scm", queryParameter);
                                    }
                                    queryParameter = uri4.getQueryParameter("pg1stepk");
                                    if (!TextUtils.isEmpty(queryParameter)) {
                                        hashMap.put("pg1stepk", queryParameter);
                                    }
                                    if (!TextUtils.isEmpty(uri4.getQueryParameter("point"))) {
                                        hashMap.put("issb", SettingsConst.TRUE);
                                    }
                                    obj3 = a(uri4);
                                    if (!TextUtils.isEmpty(obj3)) {
                                        c.a().e = obj3;
                                    }
                                    if (hashMap.size() > 0) {
                                        map.putAll(hashMap);
                                    }
                                    obj3 = b2;
                                    str4 = uri3;
                                } catch (Throwable th2) {
                                    obj3 = b2;
                                }
                            } catch (Throwable th3) {
                            }
                            g = g(obj);
                            if (g != null) {
                                if (d.f == null && n.a == d.f) {
                                    if (g.d) {
                                        b(map);
                                    }
                                    map.putAll(g.a(false));
                                } else {
                                    equals = a(obj).equals(this.c);
                                    if (g.f) {
                                        if (SettingsConst.TRUE.equals(map.get("skipbk"))) {
                                            g.d = false;
                                        }
                                        if (!g.d || (g.e && equals)) {
                                            uri3 = (String) map.get("spm-cnt");
                                            if (TextUtils.isEmpty(uri3)) {
                                                g.a = uri3;
                                            } else {
                                                g.a = (String) map.get("spm_cnt");
                                            }
                                            if (TextUtils.isEmpty(obj3)) {
                                                g.b = obj3;
                                            } else {
                                                uri3 = (String) map.get("spm-url");
                                                str3 = (String) map.get("spm_url");
                                                if (TextUtils.isEmpty(uri3)) {
                                                    g.b = uri3;
                                                } else if (TextUtils.isEmpty(str3)) {
                                                    g.b = str3;
                                                } else {
                                                    g.b = (String) map.get("spm");
                                                }
                                            }
                                            if (!TextUtils.isEmpty(this.c)) {
                                                g.c = this.f;
                                            }
                                            uri3 = (String) map.get("utparam-cnt");
                                            if (!TextUtils.isEmpty(uri3)) {
                                                g.g = uri3;
                                            }
                                            uri3 = "";
                                            if (TextUtils.isEmpty(this.c)) {
                                                str3 = this.h;
                                            } else {
                                                str3 = uri3;
                                            }
                                            obj2 = a(str4, a((String) map.get("utparam-url"), str3));
                                            if (!TextUtils.isEmpty(obj2)) {
                                                g.h = obj2;
                                            }
                                            if (!TextUtils.isEmpty(this.c)) {
                                                g.i = this.g;
                                            }
                                        }
                                    } else {
                                        g.d = false;
                                    }
                                    if (g.d) {
                                        b(map);
                                    }
                                    map.putAll(g.a(equals));
                                }
                                this.c = a(obj);
                                this.f = g.b;
                                this.g = g.h;
                                this.h = g.g;
                                af.a("ricky", "mLastCacheKey:" + this.c + ",mLastCacheKeySpmUrl:" + this.f + ",mLastCacheKeyUtParam:" + this.g + ",mLastCacheKeyUtParamCnt:" + this.h);
                                g.d = true;
                                g.f = false;
                            }
                            a = k.a().a(d.c, map);
                            if (!TextUtils.isEmpty(a)) {
                                map.put("_tpk", a);
                            }
                            if (d.a != null && d.a.containsKey("_allow_override_value")) {
                                map.putAll(d.a);
                                map.remove("_allow_override_value");
                            }
                            if ("Page_Webview".equalsIgnoreCase(b) && uri4 != null) {
                                str3 = uri4.toString();
                                if (!TextUtils.isEmpty(str3)) {
                                    indexOf = str3.indexOf("?");
                                    if (indexOf == -1) {
                                        a = str3.substring(0, indexOf);
                                    } else {
                                        obj2 = str3;
                                    }
                                    if (TextUtils.isEmpty(a)) {
                                        b2 = a;
                                    } else {
                                        str4 = b;
                                    }
                                    af.a("", "temp", str3, "urlForPageName", a);
                                    qVar = new q(b2);
                                    qVar.a(str).a(elapsedRealtime).a(map);
                                    qVar.a("_priority", "4");
                                    e.b().a = b2;
                                    if (lVar != null) {
                                        throw new NullPointerException("Tracker instance is null,please init sdk first.");
                                    }
                                    lVar.a(qVar.a());
                                    if ((obj instanceof Activity) || (obj instanceof Fragment) || (obj instanceof android.support.v4.app.Fragment)) {
                                        a2 = b.a();
                                        str3 = obj.getClass().getCanonicalName();
                                        if (!(TextUtils.isEmpty(b2) || TextUtils.isEmpty(str3))) {
                                            if (b2.length() > SecExceptionCode.SEC_ERROR_DYN_STORE) {
                                                b2 = b2.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                                            }
                                            try {
                                                b2 = URLEncoder.encode(b2, "UTF-8");
                                            } catch (Exception e) {
                                                af.a("", e);
                                            }
                                            if (str3.length() <= SecExceptionCode.SEC_ERROR_DYN_STORE) {
                                                obj2 = str3.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                                            } else {
                                                uri3 = str3;
                                            }
                                            a2.a.put(b2, obj2);
                                            if (a2.a.size() >= 20) {
                                                a2.b();
                                            }
                                        }
                                    }
                                }
                            }
                            str4 = b;
                            qVar = new q(b2);
                            qVar.a(str).a(elapsedRealtime).a(map);
                            qVar.a("_priority", "4");
                            e.b().a = b2;
                            if (lVar != null) {
                                lVar.a(qVar.a());
                                a2 = b.a();
                                str3 = obj.getClass().getCanonicalName();
                                if (b2.length() > SecExceptionCode.SEC_ERROR_DYN_STORE) {
                                    b2 = b2.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                                }
                                b2 = URLEncoder.encode(b2, "UTF-8");
                                if (str3.length() <= SecExceptionCode.SEC_ERROR_DYN_STORE) {
                                    uri3 = str3;
                                } else {
                                    obj2 = str3.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                                }
                                a2.a.put(b2, obj2);
                                if (a2.a.size() >= 20) {
                                    a2.b();
                                }
                            } else {
                                throw new NullPointerException("Tracker instance is null,please init sdk first.");
                            }
                        }
                        str4 = uri3;
                        g = g(obj);
                        if (g != null) {
                            if (d.f == null) {
                            }
                            equals = a(obj).equals(this.c);
                            if (g.f) {
                                g.d = false;
                            } else {
                                if (SettingsConst.TRUE.equals(map.get("skipbk"))) {
                                    g.d = false;
                                }
                                uri3 = (String) map.get("spm-cnt");
                                if (TextUtils.isEmpty(uri3)) {
                                    g.a = (String) map.get("spm_cnt");
                                } else {
                                    g.a = uri3;
                                }
                                if (TextUtils.isEmpty(obj3)) {
                                    uri3 = (String) map.get("spm-url");
                                    str3 = (String) map.get("spm_url");
                                    if (TextUtils.isEmpty(uri3)) {
                                        g.b = uri3;
                                    } else if (TextUtils.isEmpty(str3)) {
                                        g.b = (String) map.get("spm");
                                    } else {
                                        g.b = str3;
                                    }
                                } else {
                                    g.b = obj3;
                                }
                                if (TextUtils.isEmpty(this.c)) {
                                    g.c = this.f;
                                }
                                uri3 = (String) map.get("utparam-cnt");
                                if (TextUtils.isEmpty(uri3)) {
                                    g.g = uri3;
                                }
                                uri3 = "";
                                if (TextUtils.isEmpty(this.c)) {
                                    str3 = uri3;
                                } else {
                                    str3 = this.h;
                                }
                                obj2 = a(str4, a((String) map.get("utparam-url"), str3));
                                if (TextUtils.isEmpty(obj2)) {
                                    g.h = obj2;
                                }
                                if (TextUtils.isEmpty(this.c)) {
                                    g.i = this.g;
                                }
                            }
                            if (g.d) {
                                b(map);
                            }
                            map.putAll(g.a(equals));
                            this.c = a(obj);
                            this.f = g.b;
                            this.g = g.h;
                            this.h = g.g;
                            af.a("ricky", "mLastCacheKey:" + this.c + ",mLastCacheKeySpmUrl:" + this.f + ",mLastCacheKeyUtParam:" + this.g + ",mLastCacheKeyUtParamCnt:" + this.h);
                            g.d = true;
                            g.f = false;
                        }
                        a = k.a().a(d.c, map);
                        if (TextUtils.isEmpty(a)) {
                            map.put("_tpk", a);
                        }
                        map.putAll(d.a);
                        map.remove("_allow_override_value");
                        str3 = uri4.toString();
                        if (TextUtils.isEmpty(str3)) {
                            indexOf = str3.indexOf("?");
                            if (indexOf == -1) {
                                obj2 = str3;
                            } else {
                                a = str3.substring(0, indexOf);
                            }
                            if (TextUtils.isEmpty(a)) {
                                str4 = b;
                            } else {
                                b2 = a;
                            }
                            af.a("", "temp", str3, "urlForPageName", a);
                            qVar = new q(b2);
                            qVar.a(str).a(elapsedRealtime).a(map);
                            qVar.a("_priority", "4");
                            e.b().a = b2;
                            if (lVar != null) {
                                throw new NullPointerException("Tracker instance is null,please init sdk first.");
                            }
                            lVar.a(qVar.a());
                            a2 = b.a();
                            str3 = obj.getClass().getCanonicalName();
                            if (b2.length() > SecExceptionCode.SEC_ERROR_DYN_STORE) {
                                b2 = b2.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                            }
                            b2 = URLEncoder.encode(b2, "UTF-8");
                            if (str3.length() <= SecExceptionCode.SEC_ERROR_DYN_STORE) {
                                obj2 = str3.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                            } else {
                                uri3 = str3;
                            }
                            a2.a.put(b2, obj2);
                            if (a2.a.size() >= 20) {
                                a2.b();
                            }
                        }
                        str4 = b;
                        qVar = new q(b2);
                        qVar.a(str).a(elapsedRealtime).a(map);
                        qVar.a("_priority", "4");
                        e.b().a = b2;
                        if (lVar != null) {
                            lVar.a(qVar.a());
                            a2 = b.a();
                            str3 = obj.getClass().getCanonicalName();
                            if (b2.length() > SecExceptionCode.SEC_ERROR_DYN_STORE) {
                                b2 = b2.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                            }
                            b2 = URLEncoder.encode(b2, "UTF-8");
                            if (str3.length() <= SecExceptionCode.SEC_ERROR_DYN_STORE) {
                                uri3 = str3;
                            } else {
                                obj2 = str3.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                            }
                            a2.a.put(b2, obj2);
                            if (a2.a.size() >= 20) {
                                a2.b();
                            }
                        } else {
                            throw new NullPointerException("Tracker instance is null,please init sdk first.");
                        }
                    }
                }
                map = map2;
                str = str4;
                b = uri;
                obj3 = "";
                uri3 = "";
                uri4 = d.c;
                if (uri4 != null) {
                    hashMap = new HashMap();
                    b2 = b(uri4);
                    if (TextUtils.isEmpty(b2)) {
                        obj4 = null;
                        str2 = obj.getClass().getSimpleName() + obj.hashCode();
                        obj4 = 1;
                        if (obj4 == null) {
                            hashMap.put("spm", b2);
                            this.p.put(str2, b2);
                            b(str2);
                        }
                    }
                    uri3 = uri4.getQueryParameter("utparam");
                    queryParameter = uri4.getQueryParameter("scm");
                    if (TextUtils.isEmpty(queryParameter)) {
                        hashMap.put("scm", queryParameter);
                    }
                    queryParameter = uri4.getQueryParameter("pg1stepk");
                    if (TextUtils.isEmpty(queryParameter)) {
                        hashMap.put("pg1stepk", queryParameter);
                    }
                    if (TextUtils.isEmpty(uri4.getQueryParameter("point"))) {
                        hashMap.put("issb", SettingsConst.TRUE);
                    }
                    obj3 = a(uri4);
                    if (TextUtils.isEmpty(obj3)) {
                        c.a().e = obj3;
                    }
                    if (hashMap.size() > 0) {
                        map.putAll(hashMap);
                    }
                    obj3 = b2;
                    str4 = uri3;
                    g = g(obj);
                    if (g != null) {
                        if (d.f == null) {
                        }
                        equals = a(obj).equals(this.c);
                        if (g.f) {
                            if (SettingsConst.TRUE.equals(map.get("skipbk"))) {
                                g.d = false;
                            }
                            uri3 = (String) map.get("spm-cnt");
                            if (TextUtils.isEmpty(uri3)) {
                                g.a = uri3;
                            } else {
                                g.a = (String) map.get("spm_cnt");
                            }
                            if (TextUtils.isEmpty(obj3)) {
                                g.b = obj3;
                            } else {
                                uri3 = (String) map.get("spm-url");
                                str3 = (String) map.get("spm_url");
                                if (TextUtils.isEmpty(uri3)) {
                                    g.b = uri3;
                                } else if (TextUtils.isEmpty(str3)) {
                                    g.b = str3;
                                } else {
                                    g.b = (String) map.get("spm");
                                }
                            }
                            if (TextUtils.isEmpty(this.c)) {
                                g.c = this.f;
                            }
                            uri3 = (String) map.get("utparam-cnt");
                            if (TextUtils.isEmpty(uri3)) {
                                g.g = uri3;
                            }
                            uri3 = "";
                            if (TextUtils.isEmpty(this.c)) {
                                str3 = this.h;
                            } else {
                                str3 = uri3;
                            }
                            obj2 = a(str4, a((String) map.get("utparam-url"), str3));
                            if (TextUtils.isEmpty(obj2)) {
                                g.h = obj2;
                            }
                            if (TextUtils.isEmpty(this.c)) {
                                g.i = this.g;
                            }
                        } else {
                            g.d = false;
                        }
                        if (g.d) {
                            b(map);
                        }
                        map.putAll(g.a(equals));
                        this.c = a(obj);
                        this.f = g.b;
                        this.g = g.h;
                        this.h = g.g;
                        af.a("ricky", "mLastCacheKey:" + this.c + ",mLastCacheKeySpmUrl:" + this.f + ",mLastCacheKeyUtParam:" + this.g + ",mLastCacheKeyUtParamCnt:" + this.h);
                        g.d = true;
                        g.f = false;
                    }
                    a = k.a().a(d.c, map);
                    if (TextUtils.isEmpty(a)) {
                        map.put("_tpk", a);
                    }
                    map.putAll(d.a);
                    map.remove("_allow_override_value");
                    str3 = uri4.toString();
                    if (TextUtils.isEmpty(str3)) {
                        indexOf = str3.indexOf("?");
                        if (indexOf == -1) {
                            a = str3.substring(0, indexOf);
                        } else {
                            obj2 = str3;
                        }
                        if (TextUtils.isEmpty(a)) {
                            b2 = a;
                        } else {
                            str4 = b;
                        }
                        af.a("", "temp", str3, "urlForPageName", a);
                        qVar = new q(b2);
                        qVar.a(str).a(elapsedRealtime).a(map);
                        qVar.a("_priority", "4");
                        e.b().a = b2;
                        if (lVar != null) {
                            throw new NullPointerException("Tracker instance is null,please init sdk first.");
                        }
                        lVar.a(qVar.a());
                        a2 = b.a();
                        str3 = obj.getClass().getCanonicalName();
                        if (b2.length() > SecExceptionCode.SEC_ERROR_DYN_STORE) {
                            b2 = b2.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                        }
                        b2 = URLEncoder.encode(b2, "UTF-8");
                        if (str3.length() <= SecExceptionCode.SEC_ERROR_DYN_STORE) {
                            obj2 = str3.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                        } else {
                            uri3 = str3;
                        }
                        a2.a.put(b2, obj2);
                        if (a2.a.size() >= 20) {
                            a2.b();
                        }
                    }
                    str4 = b;
                    qVar = new q(b2);
                    qVar.a(str).a(elapsedRealtime).a(map);
                    qVar.a("_priority", "4");
                    e.b().a = b2;
                    if (lVar != null) {
                        lVar.a(qVar.a());
                        a2 = b.a();
                        str3 = obj.getClass().getCanonicalName();
                        if (b2.length() > SecExceptionCode.SEC_ERROR_DYN_STORE) {
                            b2 = b2.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                        }
                        b2 = URLEncoder.encode(b2, "UTF-8");
                        if (str3.length() <= SecExceptionCode.SEC_ERROR_DYN_STORE) {
                            uri3 = str3;
                        } else {
                            obj2 = str3.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                        }
                        a2.a.put(b2, obj2);
                        if (a2.a.size() >= 20) {
                            a2.b();
                        }
                    } else {
                        throw new NullPointerException("Tracker instance is null,please init sdk first.");
                    }
                }
                str4 = uri3;
                g = g(obj);
                if (g != null) {
                    if (d.f == null) {
                    }
                    equals = a(obj).equals(this.c);
                    if (g.f) {
                        g.d = false;
                    } else {
                        if (SettingsConst.TRUE.equals(map.get("skipbk"))) {
                            g.d = false;
                        }
                        uri3 = (String) map.get("spm-cnt");
                        if (TextUtils.isEmpty(uri3)) {
                            g.a = (String) map.get("spm_cnt");
                        } else {
                            g.a = uri3;
                        }
                        if (TextUtils.isEmpty(obj3)) {
                            uri3 = (String) map.get("spm-url");
                            str3 = (String) map.get("spm_url");
                            if (TextUtils.isEmpty(uri3)) {
                                g.b = uri3;
                            } else if (TextUtils.isEmpty(str3)) {
                                g.b = (String) map.get("spm");
                            } else {
                                g.b = str3;
                            }
                        } else {
                            g.b = obj3;
                        }
                        if (TextUtils.isEmpty(this.c)) {
                            g.c = this.f;
                        }
                        uri3 = (String) map.get("utparam-cnt");
                        if (TextUtils.isEmpty(uri3)) {
                            g.g = uri3;
                        }
                        uri3 = "";
                        if (TextUtils.isEmpty(this.c)) {
                            str3 = uri3;
                        } else {
                            str3 = this.h;
                        }
                        obj2 = a(str4, a((String) map.get("utparam-url"), str3));
                        if (TextUtils.isEmpty(obj2)) {
                            g.h = obj2;
                        }
                        if (TextUtils.isEmpty(this.c)) {
                            g.i = this.g;
                        }
                    }
                    if (g.d) {
                        b(map);
                    }
                    map.putAll(g.a(equals));
                    this.c = a(obj);
                    this.f = g.b;
                    this.g = g.h;
                    this.h = g.g;
                    af.a("ricky", "mLastCacheKey:" + this.c + ",mLastCacheKeySpmUrl:" + this.f + ",mLastCacheKeyUtParam:" + this.g + ",mLastCacheKeyUtParamCnt:" + this.h);
                    g.d = true;
                    g.f = false;
                }
                try {
                    a = k.a().a(d.c, map);
                    if (TextUtils.isEmpty(a)) {
                        map.put("_tpk", a);
                    }
                } catch (Exception e2) {
                }
                map.putAll(d.a);
                map.remove("_allow_override_value");
                str3 = uri4.toString();
                if (TextUtils.isEmpty(str3)) {
                    indexOf = str3.indexOf("?");
                    if (indexOf == -1) {
                        obj2 = str3;
                    } else {
                        a = str3.substring(0, indexOf);
                    }
                    if (TextUtils.isEmpty(a)) {
                        str4 = b;
                    } else {
                        b2 = a;
                    }
                    af.a("", "temp", str3, "urlForPageName", a);
                    qVar = new q(b2);
                    qVar.a(str).a(elapsedRealtime).a(map);
                    qVar.a("_priority", "4");
                    e.b().a = b2;
                    if (lVar != null) {
                        throw new NullPointerException("Tracker instance is null,please init sdk first.");
                    }
                    lVar.a(qVar.a());
                    a2 = b.a();
                    str3 = obj.getClass().getCanonicalName();
                    if (b2.length() > SecExceptionCode.SEC_ERROR_DYN_STORE) {
                        b2 = b2.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                    }
                    b2 = URLEncoder.encode(b2, "UTF-8");
                    if (str3.length() <= SecExceptionCode.SEC_ERROR_DYN_STORE) {
                        obj2 = str3.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                    } else {
                        uri3 = str3;
                    }
                    a2.a.put(b2, obj2);
                    if (a2.a.size() >= 20) {
                        a2.b();
                    }
                }
                str4 = b;
                qVar = new q(b2);
                qVar.a(str).a(elapsedRealtime).a(map);
                qVar.a("_priority", "4");
                e.b().a = b2;
                if (lVar != null) {
                    lVar.a(qVar.a());
                    a2 = b.a();
                    str3 = obj.getClass().getCanonicalName();
                    if (b2.length() > SecExceptionCode.SEC_ERROR_DYN_STORE) {
                        b2 = b2.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                    }
                    b2 = URLEncoder.encode(b2, "UTF-8");
                    if (str3.length() <= SecExceptionCode.SEC_ERROR_DYN_STORE) {
                        uri3 = str3;
                    } else {
                        obj2 = str3.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE);
                    }
                    a2.a.put(b2, obj2);
                    if (a2.a.size() >= 20) {
                        a2.b();
                    }
                } else {
                    throw new NullPointerException("Tracker instance is null,please init sdk first.");
                }
            }
            af.d("UT", "Please call pageAppear first(" + f(obj) + ").");
            if (d.h) {
                a(d);
            } else if (d.f == null || n.a != d.f) {
                e(obj);
            } else {
                a(d);
            }
            d();
        }
    }

    private static String a(Uri uri) {
        if (uri != null) {
            List<String> queryParameters = uri.getQueryParameters("ttid");
            if (queryParameters != null) {
                for (String str : queryParameters) {
                    if (!str.contains("@") && !str.contains("%40")) {
                        return str;
                    }
                }
            }
        }
        return null;
    }

    private static String f(Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName == null || !simpleName.toLowerCase().endsWith("activity")) {
            return simpleName;
        }
        return simpleName.substring(0, simpleName.length() - 8);
    }

    private synchronized m g(Object obj) {
        m mVar;
        if (obj instanceof Activity) {
            String a = a(obj);
            if (!this.b.contains(a)) {
                this.b.add(a);
            }
            if (this.a.containsKey(a)) {
                mVar = (m) this.a.get(a);
            } else {
                mVar = new m();
                this.a.put(a, mVar);
            }
        } else {
            mVar = null;
        }
        return mVar;
    }

    final synchronized void c() {
        if (this.b.size() > 100) {
            for (int i = 0; i < 50; i++) {
                String str = (String) this.b.poll();
                if (str != null && this.a.containsKey(str)) {
                    this.a.remove(str);
                }
            }
        }
    }

    private static String b(Uri uri) {
        String queryParameter = uri.getQueryParameter("spm");
        if (TextUtils.isEmpty(queryParameter)) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri.toString(), "UTF-8"));
                queryParameter = uri.getQueryParameter("spm");
            } catch (UnsupportedEncodingException e) {
            }
        }
        if (TextUtils.isEmpty(queryParameter)) {
            queryParameter = uri.getQueryParameter("spm_url");
            if (TextUtils.isEmpty(queryParameter)) {
                try {
                    queryParameter = Uri.parse(URLDecoder.decode(uri.toString(), "UTF-8")).getQueryParameter("spm_url");
                } catch (UnsupportedEncodingException e2) {
                }
            }
        }
        return queryParameter;
    }

    private static void b(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            map.remove("spm-cnt");
            map.remove("spm-url");
            map.remove("spm-pre");
            map.remove("utparam-cnt");
            map.remove("utparam-url");
            map.remove("utparam-pre");
        }
    }

    private static String a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            Map c = c(str);
            if (c == null || c.size() <= 0) {
                return str2;
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            Object c2 = c(str2);
            if (c2 == null || c2.size() <= 0) {
                return str;
            }
            c2.putAll(c);
            return com.alibaba.fastjson.a.a(c2);
        } catch (Exception e) {
            af.a("", e);
            return "";
        }
    }

    private static Map<String, String> c(String str) {
        try {
            return (Map) com.alibaba.fastjson.a.a(str);
        } catch (Exception e) {
            return null;
        }
    }
}
