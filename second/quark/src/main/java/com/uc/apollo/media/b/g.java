package com.uc.apollo.media.b;

import java.util.Comparator;

/* compiled from: ProGuard */
final class g implements Comparator<i> {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        i iVar = (i) obj;
        i iVar2 = (i) obj2;
        if (iVar.d < iVar2.d) {
            return -1;
        }
        return iVar.d > iVar2.d ? 1 : 0;
    }
}
