package com.loc;

import java.util.List;

/* compiled from: ProGuard */
public final class aj {
    public static aq a(n nVar, String str) {
        List a = nVar.a(aq.b(str), aq.class, false);
        return a.size() > 0 ? (aq) a.get(0) : null;
    }

    public static List<aq> a(n nVar, String str, String str2) {
        return nVar.a(aq.b(str, str2), aq.class, false);
    }
}
