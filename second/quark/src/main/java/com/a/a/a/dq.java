package com.a.a.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
public enum dq {
    VALUE((short) 1, "value"),
    TS((short) 2, "ts"),
    GUID((short) 3, "guid");
    
    private static final Map<String, dq> d = null;
    private final short e;
    private final String f;

    static {
        d = new HashMap();
        Iterator it = EnumSet.allOf(dq.class).iterator();
        while (it.hasNext()) {
            dq dqVar = (dq) it.next();
            d.put(dqVar.f, dqVar);
        }
    }

    private dq(short s, String str) {
        this.e = s;
        this.f = str;
    }
}
