package com.ucpro.feature.downloadpage.dirselect;

import java.util.Comparator;

/* compiled from: ProGuard */
final class i implements Comparator<String> {
    final /* synthetic */ m a;

    i(m mVar) {
        this.a = mVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((String) obj).compareToIgnoreCase((String) obj2);
    }
}
