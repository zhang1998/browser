package com.ucweb.common.util.l;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class b implements Comparable<b> {
    int a;
    boolean b;
    boolean c;
    List<a> d;

    private b() {
        this.b = false;
        this.c = false;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        if (bVar == null) {
            return 1;
        }
        return this.a - bVar.a;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            if (this.d == null) {
                this.d = new ArrayList();
                this.c = false;
            } else {
                this.c = true;
            }
            this.d.add(aVar);
        }
    }
}
