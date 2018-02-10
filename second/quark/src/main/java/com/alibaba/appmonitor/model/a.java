package com.alibaba.appmonitor.model;

import com.alibaba.appmonitor.b.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class a {
    private static a b;
    public List<b> a = new ArrayList(3);

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    private a() {
    }

    public final void a(b bVar) {
        if (this.a.contains(bVar)) {
            this.a.remove(bVar);
        }
        this.a.add(bVar);
    }

    public final b a(String str, String str2) {
        if (str == null || str2 == null || this.a == null) {
            return null;
        }
        b bVar;
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            bVar = (b) this.a.get(i);
            if (bVar != null && bVar.a.equals(str) && bVar.b.equals(str2)) {
                return bVar;
            }
        }
        f.a();
        bVar = f.a(str, str2);
        if (bVar == null) {
            return bVar;
        }
        this.a.add(bVar);
        return bVar;
    }
}
