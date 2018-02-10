package com.raizlabs.android.dbflow.a.c;

import android.database.Cursor;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.a.b.z;
import com.raizlabs.android.dbflow.a.e;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.b;
import java.util.List;

/* compiled from: ProGuard */
public class c<TModel> extends b {
    public List<e> a;
    public List<String> b;
    private final Class<TModel> c;
    private e d;
    private e e;
    private String f;

    public c(Class<TModel> cls) {
        this.c = cls;
    }

    public final void a(@NonNull b bVar) {
        e eVar;
        if (this.d == null) {
            this.d = new e().b((Object) "ALTER").a((Object) "TABLE");
        }
        String a = this.d.a();
        Object a2 = FlowManager.a(this.c);
        if (this.e != null) {
            eVar = new e(a);
            String str = this.f;
            if (str.equals("*")) {
                eVar = eVar.b((Object) str);
            } else {
                eVar.b(e.a(str));
            }
            bVar.a(eVar.b(this.e.a()).b(a2).toString());
        }
        if (this.a != null) {
            Cursor d = z.a(new com.raizlabs.android.dbflow.a.b.a.b[0]).a(this.c).a(0).d(bVar);
            if (d != null) {
                try {
                    String eVar2 = new e(a).b(a2).toString();
                    for (int i = 0; i < this.a.size(); i++) {
                        eVar = (e) this.a.get(i);
                        if (d.getColumnIndex(e.b((String) this.b.get(i))) == -1) {
                            bVar.a(eVar2 + " ADD COLUMN " + eVar.a());
                        }
                    }
                } finally {
                    d.close();
                }
            }
        }
    }

    @CallSuper
    public final void b() {
        this.d = null;
        this.e = null;
        this.a = null;
        this.b = null;
    }
}
