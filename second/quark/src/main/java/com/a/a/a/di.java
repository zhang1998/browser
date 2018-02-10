package com.a.a.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
public enum di {
    IDENTITY((short) 1, "identity"),
    TS((short) 2, "ts"),
    VERSION((short) 3, "version");
    
    private static final Map<String, di> d = null;
    private final short e;
    private final String f;

    static {
        d = new HashMap();
        Iterator it = EnumSet.allOf(di.class).iterator();
        while (it.hasNext()) {
            di diVar = (di) it.next();
            d.put(diVar.f, diVar);
        }
    }

    private di(short s, String str) {
        this.e = s;
        this.f = str;
    }
}
