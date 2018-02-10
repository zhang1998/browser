package com.uc.quark.p2p.service;

import com.uc.a;
import com.uc.c;

/* compiled from: ProGuard */
final class d {
    static c a(String str) {
        for (a aVar : a.values()) {
            c a = aVar.b.a(str);
            if (a != null) {
                return a;
            }
        }
        return null;
    }
}
