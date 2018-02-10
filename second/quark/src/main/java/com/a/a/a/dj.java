package com.a.a.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
public enum dj {
    DOMAIN((short) 1, "domain"),
    OLD_ID((short) 2, "old_id"),
    NEW_ID((short) 3, "new_id"),
    TS((short) 4, "ts");
    
    private static final Map<String, dj> e = null;
    private final short f;
    private final String g;

    static {
        e = new HashMap();
        Iterator it = EnumSet.allOf(dj.class).iterator();
        while (it.hasNext()) {
            dj djVar = (dj) it.next();
            e.put(djVar.g, djVar);
        }
    }

    private dj(short s, String str) {
        this.f = s;
        this.g = str;
    }
}
