package com.raizlabs.android.dbflow.a.b;

import com.raizlabs.android.dbflow.a.b.a.b;
import com.raizlabs.android.dbflow.a.e;
import com.raizlabs.android.dbflow.a.f;
import java.util.List;

/* compiled from: ProGuard */
public final class q<TModel, TFromModel> implements f {
    private p a;
    private i b;
    private g c;
    private List<b> d;

    public final String a() {
        e eVar = new e();
        eVar.b(this.a.name().replace("_", " ")).b();
        eVar.b((Object) "JOIN").b().b(this.b.b()).b();
        if (!p.NATURAL.equals(this.a)) {
            if (this.c != null) {
                eVar.b((Object) "ON").b().b(this.c.a()).b();
            } else if (!this.d.isEmpty()) {
                eVar.b((Object) "USING (").b(e.a((CharSequence) ", ", this.d)).b((Object) ")").b();
            }
        }
        return eVar.a();
    }
}
