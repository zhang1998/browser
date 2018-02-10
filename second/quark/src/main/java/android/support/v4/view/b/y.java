package android.support.v4.view.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class y implements e {
    final /* synthetic */ aj a;
    final /* synthetic */ ah b;

    y(ah ahVar, aj ajVar) {
        this.b = ahVar;
        this.a = ajVar;
    }

    public final boolean b() {
        return aj.b();
    }

    public final List<Object> c() {
        List list = null;
        aj.c();
        List<Object> arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((s) list.get(i)).b);
        }
        return arrayList;
    }

    public final Object a() {
        aj.a();
        return null;
    }

    public final Object d() {
        aj.d();
        return null;
    }
}
