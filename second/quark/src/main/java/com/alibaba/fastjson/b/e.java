package com.alibaba.fastjson.b;

import com.alibaba.fastjson.a.c;
import com.alibaba.fastjson.a.i;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: ProGuard */
public final class e implements com.alibaba.fastjson.a.a.e, u {
    public static final e a = new e();

    private e() {
    }

    public final void a(o oVar, Object obj, Object obj2, Type type) throws IOException {
        aa aaVar = oVar.b;
        if (obj == null) {
            if ((aaVar.c & z.WriteNullNumberAsZero.x) != 0) {
                aaVar.write(48);
            } else {
                aaVar.write("null");
            }
        } else if (obj instanceof BigInteger) {
            aaVar.write(((BigInteger) obj).toString());
        } else {
            BigDecimal bigDecimal = (BigDecimal) obj;
            aaVar.write(bigDecimal.toString());
            if ((aaVar.c & z.WriteClassName.x) != 0 && type != BigDecimal.class && bigDecimal.scale() == 0) {
                aaVar.write(46);
            }
        }
    }

    public final <T> T a(c cVar, Type type, Object obj) {
        i iVar = cVar.e;
        int a = iVar.a();
        if (a == 2) {
            String f = iVar.f();
            iVar.a(16);
            if (type == BigInteger.class) {
                return new BigInteger(f);
            }
            return new BigDecimal(f);
        } else if (a == 3) {
            T x = iVar.x();
            iVar.a(16);
            if (type == BigInteger.class) {
                return x.toBigInteger();
            }
            return x;
        } else {
            Object a2 = cVar.a(null);
            if (a2 == null) {
                return null;
            }
            if (type == BigInteger.class) {
                return com.alibaba.fastjson.c.e.f(a2);
            }
            return com.alibaba.fastjson.c.e.e(a2);
        }
    }
}
