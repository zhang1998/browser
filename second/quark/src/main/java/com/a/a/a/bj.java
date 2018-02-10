package com.a.a.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
public enum bj {
    VERSION((short) 1, "version"),
    ADDRESS((short) 2, "address"),
    SIGNATURE((short) 3, "signature"),
    SERIAL_NUM((short) 4, "serial_num"),
    TS_SECS((short) 5, "ts_secs"),
    LENGTH((short) 6, "length"),
    ENTITY((short) 7, "entity"),
    GUID((short) 8, "guid"),
    CHECKSUM((short) 9, "checksum"),
    CODEX((short) 10, "codex");
    
    private static final Map<String, bj> k = null;
    private final short l;
    private final String m;

    static {
        k = new HashMap();
        Iterator it = EnumSet.allOf(bj.class).iterator();
        while (it.hasNext()) {
            bj bjVar = (bj) it.next();
            k.put(bjVar.m, bjVar);
        }
    }

    private bj(short s, String str) {
        this.l = s;
        this.m = str;
    }
}
