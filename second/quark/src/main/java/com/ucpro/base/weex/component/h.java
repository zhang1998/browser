package com.ucpro.base.weex.component;

import android.os.Handler;
import android.os.Looper;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.c;
import com.taobao.weex.common.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ProGuard */
public class h extends o {
    public static Map<String, WeakReference<h>> a = new HashMap();
    public String d = null;
    public boolean e = false;
    public Set<g> f = new HashSet();
    private boolean g = false;
    private Handler h = new Handler(Looper.getMainLooper());

    public static h a(String str) {
        WeakReference weakReference = (WeakReference) a.get(str);
        if (weakReference == null) {
            return null;
        }
        h hVar = (h) weakReference.get();
        if (hVar == null) {
            return null;
        }
        return hVar;
    }

    private static void a() {
        ArrayList arrayList = new ArrayList();
        for (Entry entry : a.entrySet()) {
            if (entry.getValue() == null) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a.remove((String) it.next());
        }
    }

    @JSMethod
    public void addListener(String str, c cVar) {
        byte b = (byte) -1;
        switch (str.hashCode()) {
            case -1884319283:
                if (str.equals("stopped")) {
                    b = (byte) 0;
                    break;
                }
                break;
        }
        switch (b) {
            case (byte) 0:
                g gVar = new g();
                gVar.a = cVar;
                this.f.add(gVar);
                return;
            default:
                return;
        }
    }

    @JSMethod
    public void removeListener(String str, c cVar) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1884319283:
                if (str.equals("stopped")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                for (g gVar : this.f) {
                    if (gVar.a == cVar) {
                        this.f.remove(gVar);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @JSMethod
    public void registerStop() {
        this.e = true;
        this.d = this.b.e;
        a.put(this.b.e, new WeakReference(this));
        a();
    }

    @JSMethod
    public void unregisterStop() {
        this.e = false;
        a(0);
    }

    public final void a(long j) {
        if (!this.g) {
            this.h.postDelayed(new i(this), j);
        }
    }
}
