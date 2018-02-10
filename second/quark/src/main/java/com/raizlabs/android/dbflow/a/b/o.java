package com.raizlabs.android.dbflow.a.b;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.a.b.a.a;
import com.raizlabs.android.dbflow.a.b.a.b;
import com.raizlabs.android.dbflow.a.e;
import com.raizlabs.android.dbflow.a.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
public final class o implements f {
    private int a = -1;
    private final List<b> b = new ArrayList();

    public o(b... bVarArr) {
        Collections.addAll(this.b, bVarArr);
        if (this.b.isEmpty()) {
            this.b.add(a.a);
        }
    }

    @NonNull
    public final <TModel> r<TModel> a(@NonNull Class<TModel> cls) {
        return new r(this, cls);
    }

    @NonNull
    public final String toString() {
        return a();
    }

    public final String a() {
        e eVar = new e("SELECT ");
        if (this.a != -1) {
            if (this.a == 0) {
                eVar.b((Object) "DISTINCT");
            } else if (this.a == 1) {
                eVar.b((Object) "ALL");
            }
            eVar.b();
        }
        eVar.b(e.a((CharSequence) ",", this.b));
        eVar.b();
        return eVar.a();
    }
}
