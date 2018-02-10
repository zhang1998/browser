package com.a.a.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
public enum dd {
    RESP_CODE((short) 1, "resp_code"),
    MSG((short) 2, "msg"),
    IMPRINT((short) 3, "imprint");
    
    private static final Map<String, dd> d = null;
    private final short e;
    private final String f;

    static {
        d = new HashMap();
        Iterator it = EnumSet.allOf(dd.class).iterator();
        while (it.hasNext()) {
            dd ddVar = (dd) it.next();
            d.put(ddVar.f, ddVar);
        }
    }

    private dd(short s, String str) {
        this.e = s;
        this.f = str;
    }
}
