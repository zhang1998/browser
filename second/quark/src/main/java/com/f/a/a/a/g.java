package com.f.a.a.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: ProGuard */
final class g implements d {
    private static final Object f = new Object();
    Map a;
    boolean b = false;
    private final File c;
    private final File d;
    private final int e;
    private WeakHashMap<Object, Object> g;

    g(File file, Map map) {
        this.c = file;
        this.d = b.b(file);
        this.e = 0;
        if (map == null) {
            map = new HashMap();
        }
        this.a = map;
        this.g = new WeakHashMap();
    }

    public final boolean a() {
        if (this.c == null || !new File(this.c.getAbsolutePath()).exists()) {
            return false;
        }
        return true;
    }

    public final boolean d() {
        boolean z;
        synchronized (this) {
            z = this.b;
        }
        return z;
    }

    public final Map<String, ?> b() {
        Map hashMap;
        synchronized (this) {
            hashMap = new HashMap(this.a);
        }
        return hashMap;
    }

    public final String a(String str, String str2) {
        String str3;
        synchronized (this) {
            str3 = (String) this.a.get(str);
            if (str3 == null) {
                str3 = str2;
            }
        }
        return str3;
    }

    public final long a(String str) {
        long longValue;
        synchronized (this) {
            Long l = (Long) this.a.get(str);
            longValue = l != null ? l.longValue() : 0;
        }
        return longValue;
    }

    public final f c() {
        return new h(this);
    }

    private static FileOutputStream a(File file) {
        try {
            return new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            if (!file.getParentFile().mkdir()) {
                return null;
            }
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException e2) {
                return null;
            }
        }
    }

    private boolean e() {
        if (this.c.exists()) {
            if (this.d.exists()) {
                this.c.delete();
            } else if (!this.c.renameTo(this.d)) {
                return false;
            }
        }
        try {
            OutputStream a = a(this.c);
            if (a == null) {
                return false;
            }
            Map map = this.a;
            XmlSerializer eVar = new e();
            eVar.setOutput(a, "utf-8");
            eVar.startDocument(null, Boolean.valueOf(true));
            eVar.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            c.a(map, null, eVar);
            eVar.endDocument();
            a.close();
            this.d.delete();
            return true;
        } catch (XmlPullParserException e) {
            if (this.c.exists()) {
                return false;
            }
            this.c.delete();
            return false;
        } catch (IOException e2) {
            if (this.c.exists()) {
                return false;
            }
            this.c.delete();
            return false;
        }
    }
}
