package com.raizlabs.android.dbflow.runtime;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.transaction.q;
import com.raizlabs.android.dbflow.structure.g;

/* compiled from: ProGuard */
final class f implements q {
    final /* synthetic */ i a;

    f(i iVar) {
        this.a = iVar;
    }

    public final void a(Object obj) {
        if (obj instanceof g) {
            ((g) obj).a();
        } else if (obj != null) {
            FlowManager.g(obj.getClass()).a(obj);
        }
    }
}
