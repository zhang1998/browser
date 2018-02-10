package android.support.v4.view.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class q implements a {
    final /* synthetic */ aj a;
    final /* synthetic */ v b;

    q(v vVar, aj ajVar) {
        this.b = vVar;
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
}
