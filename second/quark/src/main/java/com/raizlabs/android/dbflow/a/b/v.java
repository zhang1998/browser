package com.raizlabs.android.dbflow.a.b;

import com.raizlabs.android.dbflow.a.e;
import com.raizlabs.android.dbflow.a.f;
import com.raizlabs.android.dbflow.annotation.b;
import com.raizlabs.android.dbflow.config.FlowManager;

/* compiled from: ProGuard */
public final class v<TModel> implements f {
    public final Class<TModel> a;
    private b b = b.NONE;

    public v(Class<TModel> cls) {
        this.a = cls;
    }

    public final String a() {
        e eVar = new e("UPDATE ");
        if (!(this.b == null || this.b.equals(b.NONE))) {
            eVar.b((Object) "OR").a(this.b.name());
        }
        eVar.b(FlowManager.a(this.a)).b();
        return eVar.a();
    }
}
