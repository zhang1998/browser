package com.alibaba.fastjson.b;

import com.alibaba.fastjson.a.a.e;
import com.alibaba.fastjson.a.c;
import com.alibaba.fastjson.a.i;
import com.alibaba.fastjson.d;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* compiled from: ProGuard */
public final class l implements e, u {
    public static l a = new l();

    private l() {
    }

    public final void a(o oVar, Object obj, Object obj2, Type type) throws IOException {
        aa aaVar = oVar.b;
        Number number = (Number) obj;
        if (number != null) {
            if (obj instanceof Long) {
                aaVar.a(number.longValue());
            } else {
                aaVar.b(number.intValue());
            }
            if ((aaVar.c & z.WriteClassName.x) != 0) {
                Class cls = number.getClass();
                if (cls == Byte.class) {
                    aaVar.write(66);
                } else if (cls == Short.class) {
                    aaVar.write(83);
                } else if (cls == Long.class) {
                    long longValue = number.longValue();
                    if (longValue <= 2147483647L && longValue >= -2147483648L && type != Long.class) {
                        aaVar.write(76);
                    }
                }
            }
        } else if ((aaVar.c & z.WriteNullNumberAsZero.x) != 0) {
            aaVar.write(48);
        } else {
            aaVar.write("null");
        }
    }

    public final <T> T a(c cVar, Type type, Object obj) {
        i iVar = cVar.e;
        int a = iVar.a();
        if (a == 8) {
            iVar.a(16);
            return null;
        } else if (a == 2) {
            T valueOf;
            if (type == Long.TYPE || type == Long.class) {
                valueOf = Long.valueOf(iVar.w());
            } else {
                try {
                    valueOf = Integer.valueOf(iVar.n());
                } catch (Throwable e) {
                    throw new d("int value overflow, field : " + obj, e);
                }
            }
            iVar.a(16);
            return valueOf;
        } else if (a == 3) {
            BigDecimal x = iVar.x();
            iVar.a(16);
            if (type == Long.TYPE || type == Long.class) {
                return Long.valueOf(x.longValue());
            }
            return Integer.valueOf(x.intValue());
        } else {
            Object a2 = cVar.a(null);
            try {
                if (type == Long.TYPE || type == Long.class) {
                    return com.alibaba.fastjson.c.e.i(a2);
                }
                return com.alibaba.fastjson.c.e.j(a2);
            } catch (Throwable e2) {
                throw new d("cast error, field : " + obj + ", value " + a2, e2);
            }
        }
    }
}
