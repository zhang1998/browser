package com.uc.a.d;

import android.os.Environment;
import com.uc.a.a.a;
import com.uc.a.d;
import com.uc.a.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class p implements d {
    public m a;
    private a b;
    private ArrayList<u> c;

    private p(a aVar) {
        this.c = new ArrayList();
        this.b = aVar;
        h.a = new s(this.b);
        c.a();
        c.a(this.b.c, 10800);
        this.a = new m(aVar.i);
        this.a.a((d) this);
        if (this.b.j) {
            String str = this.b.k;
            if (str == null) {
                str = new File(Environment.getExternalStorageDirectory(), "uslog.txt").getAbsolutePath();
            }
            w.a = new a(str);
        }
    }

    public final void a(f fVar) {
        new StringBuilder("[us] us request end and result is: ").append(fVar.c);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((u) it.next()).a(fVar.c);
        }
    }

    public final void a(u uVar) {
        if (uVar != null && !this.c.contains(uVar)) {
            this.c.add(uVar);
        }
    }
}
