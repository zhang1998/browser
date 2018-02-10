package com.taobao.android.binding.core;

import java.util.Collections;
import java.util.Map;

/* compiled from: ProGuard */
final class j {
    String a;
    av b;
    String c;
    String d;
    Map<String, Object> e;

    j(String str, av avVar, String str2, String str3, Map<String, Object> map) {
        this.a = str;
        this.b = avVar;
        this.c = str2;
        this.d = str3;
        if (map == null) {
            this.e = Collections.emptyMap();
        } else {
            this.e = Collections.unmodifiableMap(map);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.a == null ? jVar.a != null : !this.a.equals(jVar.a)) {
            return false;
        }
        if (this.b == null ? jVar.b != null : !this.b.equals(jVar.b)) {
            return false;
        }
        if (this.c == null ? jVar.c != null : !this.c.equals(jVar.c)) {
            return false;
        }
        if (this.d == null ? jVar.d != null : !this.d.equals(jVar.d)) {
            return false;
        }
        if (this.e != null) {
            return this.e.equals(jVar.e);
        }
        if (jVar.e != null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = (this.a != null ? this.a.hashCode() : 0) * 31;
        if (this.b != null) {
            hashCode = this.b.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.c != null) {
            hashCode = this.c.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.d != null) {
            hashCode = this.d.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (this.e != null) {
            i = this.e.hashCode();
        }
        return hashCode + i;
    }
}
