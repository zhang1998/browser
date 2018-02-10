package com.a.a.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
public enum dw {
    PROPERTY((short) 1, "property"),
    VERSION((short) 2, "version"),
    CHECKSUM((short) 3, "checksum");
    
    private static final Map<String, dw> d = null;
    private final short e;
    private final String f;

    static {
        d = new HashMap();
        Iterator it = EnumSet.allOf(dw.class).iterator();
        while (it.hasNext()) {
            dw dwVar = (dw) it.next();
            d.put(dwVar.f, dwVar);
        }
    }

    private dw(short s, String str) {
        this.e = s;
        this.f = str;
    }
}
