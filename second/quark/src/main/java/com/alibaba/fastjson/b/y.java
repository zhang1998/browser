package com.alibaba.fastjson.b;

import com.alibaba.fastjson.c.c;
import com.alibaba.fastjson.f;
import com.alibaba.fastjson.h;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class y {
    public static final y a = new y();
    protected String b = "@type";
    public h c;
    private final c<u> d = new c();

    public y() {
        this.d.a(Boolean.class, f.a);
        this.d.a(Character.class, r.a);
        this.d.a(Byte.class, l.a);
        this.d.a(Short.class, l.a);
        this.d.a(Integer.class, l.a);
        this.d.a(Long.class, l.a);
        this.d.a(Float.class, t.a);
        this.d.a(Double.class, t.a);
        this.d.a(Number.class, t.a);
        this.d.a(BigDecimal.class, e.a);
        this.d.a(BigInteger.class, e.a);
        this.d.a(String.class, ab.a);
        this.d.a(Object[].class, b.a);
        this.d.a(Class.class, r.a);
        this.d.a(SimpleDateFormat.class, r.a);
        this.d.a(Locale.class, r.a);
        this.d.a(Currency.class, r.a);
        this.d.a(TimeZone.class, r.a);
        this.d.a(UUID.class, r.a);
        this.d.a(URI.class, r.a);
        this.d.a(URL.class, r.a);
        this.d.a(Pattern.class, r.a);
        this.d.a(Charset.class, r.a);
    }

    public final u a(Class<?> cls) {
        Object obj = null;
        u uVar = (u) this.d.a(cls);
        if (uVar != null) {
            return uVar;
        }
        if (Map.class.isAssignableFrom(cls)) {
            this.d.a(cls, new q());
        } else if (List.class.isAssignableFrom(cls)) {
            this.d.a(cls, new p());
        } else if (Collection.class.isAssignableFrom(cls)) {
            this.d.a(cls, g.a);
        } else if (Date.class.isAssignableFrom(cls)) {
            this.d.a(cls, h.a);
        } else if (com.alibaba.fastjson.c.class.isAssignableFrom(cls)) {
            this.d.a(cls, r.a);
        } else if (n.class.isAssignableFrom(cls)) {
            this.d.a(cls, r.a);
        } else if (f.class.isAssignableFrom(cls)) {
            this.d.a(cls, r.a);
        } else {
            if (!cls.isEnum()) {
                Class superclass = cls.getSuperclass();
                if (superclass == null || superclass == Object.class || !superclass.isEnum()) {
                    if (cls.isArray()) {
                        superclass = cls.getComponentType();
                        this.d.a(cls, new c(superclass, a(superclass)));
                    } else if (Throwable.class.isAssignableFrom(cls)) {
                        m mVar = new m(cls, this.c);
                        mVar.b |= z.WriteClassName.x;
                        this.d.a(cls, mVar);
                    } else if (TimeZone.class.isAssignableFrom(cls)) {
                        this.d.a(cls, r.a);
                    } else if (Charset.class.isAssignableFrom(cls)) {
                        this.d.a(cls, r.a);
                    } else if (Enumeration.class.isAssignableFrom(cls)) {
                        this.d.a(cls, r.a);
                    } else if (Calendar.class.isAssignableFrom(cls)) {
                        this.d.a(cls, h.a);
                    } else {
                        Object obj2;
                        Class[] interfaces = cls.getInterfaces();
                        int length = interfaces.length;
                        int i = 0;
                        while (i < length) {
                            Class cls2 = interfaces[i];
                            if (cls2.getName().equals("net.sf.cglib.proxy.Factory") || cls2.getName().equals("org.springframework.cglib.proxy.Factory")) {
                                obj2 = null;
                                obj = 1;
                                break;
                            } else if (cls2.getName().equals("javassist.util.proxy.ProxyObject")) {
                                i = 1;
                                break;
                            } else {
                                i++;
                            }
                        }
                        obj2 = null;
                        if (obj == null && r0 == null) {
                            this.d.a(cls, new m(cls, this.c));
                        } else {
                            uVar = a(cls.getSuperclass());
                            this.d.a(cls, uVar);
                            return uVar;
                        }
                    }
                }
            }
            this.d.a(cls, new i());
        }
        return (u) this.d.a(cls);
    }
}
