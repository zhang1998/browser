package com.ucpro.feature.video.player;

import android.content.Context;
import com.ucpro.feature.video.player.a.g;
import com.ucpro.feature.video.player.a.i;
import com.ucpro.feature.video.player.b.h;
import com.ucpro.feature.video.player.b.j;
import com.ucpro.feature.video.player.b.x;
import com.ucpro.feature.video.player.e.a;
import com.ucpro.feature.video.player.e.b;
import com.ucpro.feature.video.player.e.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public abstract class q<T> implements g, i, e {
    private h<T> a = new h();
    public g p;
    public Context q;
    public a r;

    public abstract void a(h<T> hVar);

    public abstract void a(List<Class<?>> list);

    public q(Context context, g gVar, a aVar) {
        this.q = context;
        this.p = gVar;
        this.r = aVar;
        b();
        a(this.a);
        a();
    }

    public final void a(Class<?> cls, b bVar, b bVar2) {
        h hVar = this.a;
        Integer num = (Integer) hVar.b.get(cls);
        if (num != null) {
            j jVar = hVar.a;
            int intValue = num.intValue();
            int a = bVar2.a();
            if (j.a(a)) {
                Object obj;
                x xVar = (x) jVar.d.get(intValue);
                if (xVar == null || xVar.a == a) {
                    obj = null;
                } else {
                    xVar.a = a;
                    obj = 1;
                }
                if (obj != null) {
                    jVar.a();
                }
            }
        }
    }

    public void c() {
        this.a.a.a();
    }

    private void b() {
        List arrayList = new ArrayList();
        a(arrayList);
        if (arrayList.size() > 0) {
            int size;
            this.a.a(arrayList);
            for (size = arrayList.size() - 1; size >= 0; size--) {
                this.r.g().a((Class) arrayList.get(size), (e) this);
            }
            b[] bVarArr = new b[arrayList.size()];
            for (size = 0; size < bVarArr.length; size++) {
                bVarArr[size] = this.r.g().a((Class) arrayList.get(size));
            }
            this.a.a(bVarArr);
        }
    }

    public void a() {
    }
}
