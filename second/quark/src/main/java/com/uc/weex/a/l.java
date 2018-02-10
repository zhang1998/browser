package com.uc.weex.a;

import com.taobao.weex.a.i;
import com.taobao.weex.common.s;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class l implements i {
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    boolean g = true;
    boolean h;
    Map<String, String> i = new HashMap();
    int j = 6000;
    s k;
    k l;
    private Map<String, List<String>> m;

    l() {
    }

    final String a(String str) {
        if (this.m == null || this.m.isEmpty()) {
            return null;
        }
        for (Entry entry : this.m.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey()) && entry.getValue() != null && !((List) entry.getValue()).isEmpty()) {
                return (String) ((List) entry.getValue()).get(0);
            }
        }
        return null;
    }

    public final void a() {
    }

    public final void a(int i, Map<String, List<String>> map) {
        this.m = map;
    }

    public final void a(int i) {
    }

    public final void a(s sVar) {
        this.k = sVar;
        if (this.l != null) {
            this.l.a(this);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (this.b == null ? lVar.b != null : !this.b.equals(lVar.b)) {
            return false;
        }
        if (this.d != null) {
            return this.d.equals(lVar.d);
        }
        if (lVar.d != null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        if (this.b != null) {
            hashCode = this.b.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.d != null) {
            i = this.d.hashCode();
        }
        return hashCode + i;
    }
}
