package com.ucpro.feature.bookmarkhis.a.a;

import java.util.Comparator;

/* compiled from: ProGuard */
public final class b implements Comparator<f> {
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        f fVar = (f) obj;
        f fVar2 = (f) obj2;
        if (fVar == null && fVar2 == null) {
            return 0;
        }
        if (fVar == null) {
            return -1;
        }
        if (fVar2 != null) {
            if (fVar.a < fVar2.a) {
                return -1;
            }
            if (fVar.a == fVar2.a) {
                return 0;
            }
        }
        return 1;
    }
}
