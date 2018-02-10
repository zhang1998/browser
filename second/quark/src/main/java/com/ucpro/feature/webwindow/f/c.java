package com.ucpro.feature.webwindow.f;

import android.os.SystemClock;
import android.text.TextUtils;
import com.uc.a.b.e;
import com.uc.a.d.j;
import com.uc.a.d.l;
import com.ucpro.business.e.f.a;
import com.ucpro.business.stat.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: ProGuard */
public final class c implements j {
    public static boolean a = false;
    private static final Object c = new Object();
    private static final Object e = new Object();
    private static final Object g = new Object();
    private static final Object i = new Object();
    private ConcurrentHashMap<String, String> b;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<h>> d;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<h>> f;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<h>> h;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<h>> j;

    private c() {
    }

    public static c a() {
        return d.a;
    }

    public final List<String> a(String str, String str2) {
        new StringBuilder("hostname: ").append(str).append(" injectTime: ").append(str2);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        ConcurrentHashMap b = b(str2);
        if (b == null || b.isEmpty()) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        for (Entry entry : b.entrySet()) {
            com.ucweb.common.util.c.a((CharSequence) entry.getKey());
            try {
                if (Pattern.matches(((String) entry.getKey()).replace(".", "\\.").replace("*", ".*"), str)) {
                    List<h> list = (List) entry.getValue();
                    if (list == null || list.isEmpty()) {
                        return null;
                    }
                    for (h hVar : list) {
                        if (hVar != null) {
                            String str3 = hVar.b;
                            if (!TextUtils.isEmpty(str3)) {
                                CharSequence a = a(str3);
                                if (!TextUtils.isEmpty(a)) {
                                    arrayList.add(a);
                                }
                            }
                        }
                    }
                } else {
                    continue;
                }
            } catch (PatternSyntaxException e) {
            }
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        new StringBuilder("getInjectJavaScript Cost Time: ").append(Long.toString(uptimeMillis2)).append(" in millis");
        HashMap hashMap = new HashMap();
        hashMap.put("host_name", str);
        hashMap.put("inject_time", str2);
        hashMap.put("time_cost", Long.toString(uptimeMillis2));
        m.a("webwindow", "jsinject", hashMap);
        return arrayList;
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(str) || this.b == null || this.b.isEmpty()) {
            return null;
        }
        return (String) this.b.get(str);
    }

    private void a(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            com.ucweb.common.util.h.m.a(0, new e(this, bArr));
        }
    }

    private ConcurrentHashMap b() {
        if (this.d == null) {
            this.d = new ConcurrentHashMap();
        }
        return this.d;
    }

    private ConcurrentHashMap c() {
        if (this.f == null) {
            this.f = new ConcurrentHashMap();
        }
        return this.f;
    }

    private ConcurrentHashMap d() {
        if (this.h == null) {
            this.h = new ConcurrentHashMap();
        }
        return this.h;
    }

    private ConcurrentHashMap e() {
        if (this.j == null) {
            this.j = new ConcurrentHashMap();
        }
        return this.j;
    }

    public final ConcurrentHashMap b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Object obj = -1;
            switch (str.hashCode()) {
                case 2652:
                    if (str.equals("T0")) {
                        obj = null;
                        break;
                    }
                    break;
                case 2653:
                    if (str.equals("T1")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 2654:
                    if (str.equals("T2")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 2655:
                    if (str.equals("T3")) {
                        obj = 3;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    return b();
                case 1:
                    return c();
                case 2:
                    return d();
                case 3:
                    return e();
            }
        }
        return new ConcurrentHashMap();
    }

    public static Object c(String str) {
        if (!TextUtils.isEmpty(str)) {
            Object obj = -1;
            switch (str.hashCode()) {
                case 2652:
                    if (str.equals("T0")) {
                        obj = null;
                        break;
                    }
                    break;
                case 2653:
                    if (str.equals("T1")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 2654:
                    if (str.equals("T2")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 2655:
                    if (str.equals("T3")) {
                        obj = 3;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    return c;
                case 1:
                    return e;
                case 2:
                    return g;
                case 3:
                    return i;
            }
        }
        return null;
    }

    public final void a(String str, e eVar) {
        if (!TextUtils.isEmpty(str)) {
            byte[] b = a.b(eVar);
            if (1 == eVar.a) {
                com.ucweb.common.util.h.m.a(0, new f(this, str, b));
            }
            a(b);
        }
    }

    static /* synthetic */ void a(c cVar) {
        synchronized (c) {
            cVar.b().clear();
        }
        synchronized (e) {
            cVar.c().clear();
        }
        synchronized (g) {
            cVar.d().clear();
        }
        synchronized (i) {
            cVar.e().clear();
        }
        synchronized ("java_script_map") {
            if (cVar.b != null) {
                cVar.b.clear();
            }
        }
    }

    static /* synthetic */ void a(c cVar, b bVar) {
        String str = null;
        if (bVar != null) {
            String str2;
            if (bVar.b == null) {
                str2 = null;
            } else {
                str2 = bVar.b.toString();
            }
            int i = bVar.c;
            if (bVar.a != null) {
                str = bVar.a.toString();
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && i >= 0) {
                ConcurrentHashMap b = cVar.b(str2);
                h hVar = new h(cVar, i, str);
                ArrayList arrayList = bVar.d;
                if (arrayList != null && !arrayList.isEmpty()) {
                    com.ucweb.common.util.h.m.a(0, new m(cVar, str));
                    com.ucweb.common.util.h.m.a(0, new j(cVar, arrayList, str2, b, hVar));
                }
            }
        }
    }

    static /* synthetic */ void a(c cVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            com.ucweb.common.util.h.m.a(0, new g(cVar, l.a(str), str));
        }
    }

    static /* synthetic */ String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("<body>");
        int indexOf2 = str.indexOf("</body>");
        if (indexOf < 0 || indexOf2 <= 0 || indexOf2 <= indexOf) {
            return null;
        }
        return str.substring(indexOf + 6, indexOf2).trim();
    }
}
