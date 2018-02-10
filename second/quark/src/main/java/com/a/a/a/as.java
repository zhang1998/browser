package com.a.a.a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public abstract class as {
    final String a;
    List<du> b;
    do c;
    private final int d = 10;
    private final int e = 20;

    public abstract String b();

    public as(String str) {
        this.a = str;
    }

    public final boolean a() {
        if (this.c == null || this.c.c <= 20) {
            return true;
        }
        return false;
    }

    public final void a(cv cvVar) {
        this.c = (do) cvVar.a.get(this.a);
        List<du> list = cvVar.b;
        if (list != null && list.size() > 0) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            for (du duVar : list) {
                if (this.a.equals(duVar.a)) {
                    this.b.add(duVar);
                }
            }
        }
    }
}
