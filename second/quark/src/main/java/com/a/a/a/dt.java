package com.a.a.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
public enum dt {
    SNAPSHOTS((short) 1, "snapshots"),
    JOURNALS((short) 2, "journals"),
    CHECKSUM((short) 3, "checksum");
    
    private static final Map<String, dt> d = null;
    private final short e;
    private final String f;

    static {
        d = new HashMap();
        Iterator it = EnumSet.allOf(dt.class).iterator();
        while (it.hasNext()) {
            dt dtVar = (dt) it.next();
            d.put(dtVar.f, dtVar);
        }
    }

    private dt(short s, String str) {
        this.e = s;
        this.f = str;
    }
}
