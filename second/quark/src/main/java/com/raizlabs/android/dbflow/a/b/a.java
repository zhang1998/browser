package com.raizlabs.android.dbflow.a.b;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.a.e;
import com.raizlabs.android.dbflow.a.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: ProGuard */
public final class a<T> extends c implements f {
    private List<T> g;

    private a(b<T> bVar, Collection<T> collection) {
        super(bVar.h());
        this.g = new ArrayList();
        this.g.addAll(collection);
        this.a = String.format(" %1s ", new Object[]{"IN"});
    }

    public final void a(@NonNull e eVar) {
        e b = eVar.b(c()).b(f()).b((Object) "(");
        CharSequence charSequence = ",";
        Iterable iterable = this.g;
        StringBuilder stringBuilder = new StringBuilder();
        boolean z = true;
        for (Object next : iterable) {
            if (z) {
                z = false;
            } else {
                stringBuilder.append(charSequence);
            }
            stringBuilder.append(a(next, false));
        }
        b.b(stringBuilder.toString()).b((Object) ")");
    }

    public final String a() {
        e eVar = new e();
        a(eVar);
        return eVar.a();
    }
}
