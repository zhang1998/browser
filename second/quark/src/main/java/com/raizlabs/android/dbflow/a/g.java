package com.raizlabs.android.dbflow.a;

import com.raizlabs.android.dbflow.c.a;
import java.util.HashMap;

/* compiled from: ProGuard */
final class g extends HashMap<String, h> {
    g() {
        put(Byte.TYPE.getName(), h.INTEGER);
        put(Short.TYPE.getName(), h.INTEGER);
        put(Integer.TYPE.getName(), h.INTEGER);
        put(Long.TYPE.getName(), h.INTEGER);
        put(Float.TYPE.getName(), h.REAL);
        put(Double.TYPE.getName(), h.REAL);
        put(Boolean.TYPE.getName(), h.INTEGER);
        put(Character.TYPE.getName(), h.TEXT);
        put(byte[].class.getName(), h.BLOB);
        put(Byte.class.getName(), h.INTEGER);
        put(Short.class.getName(), h.INTEGER);
        put(Integer.class.getName(), h.INTEGER);
        put(Long.class.getName(), h.INTEGER);
        put(Float.class.getName(), h.REAL);
        put(Double.class.getName(), h.REAL);
        put(Boolean.class.getName(), h.INTEGER);
        put(Character.class.getName(), h.TEXT);
        put(CharSequence.class.getName(), h.TEXT);
        put(String.class.getName(), h.TEXT);
        put(Byte[].class.getName(), h.BLOB);
        put(a.class.getName(), h.BLOB);
    }
}
