package com.ucpro.business.c.a;

import com.uc.base.b.c.m;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class e extends a {
    public b d = new b();

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return c();
    }

    public final e c() {
        e eVar = new e();
        eVar.d.putAll((HashMap) this.d.clone());
        return eVar;
    }

    protected final boolean b(m mVar) {
        int i = 0;
        boolean b = super.b(mVar);
        if (!b) {
            return false;
        }
        ArrayList arrayList = this.b;
        ArrayList arrayList2 = this.c;
        if (arrayList.size() != arrayList2.size()) {
            c.a("BeanMapQuickSS parse error");
            return false;
        }
        int size = arrayList.size();
        while (i < size) {
            this.d.put(arrayList.get(i), arrayList2.get(i));
            i++;
        }
        arrayList.clear();
        arrayList2.clear();
        return b;
    }

    protected final boolean a(m mVar) {
        ArrayList arrayList = this.b;
        ArrayList arrayList2 = this.c;
        arrayList.clear();
        arrayList2.clear();
        for (Entry entry : this.d.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        return super.a(mVar);
    }
}
