package com.ucpro.feature.webwindow.f;

import java.util.Comparator;

/* compiled from: ProGuard */
final class k implements Comparator<b> {
    final /* synthetic */ e a;

    k(e eVar) {
        this.a = eVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        b bVar = (b) obj;
        b bVar2 = (b) obj2;
        if (bVar.c > bVar2.c) {
            return -1;
        }
        if (bVar.c < bVar2.c) {
            return 1;
        }
        return 0;
    }
}
