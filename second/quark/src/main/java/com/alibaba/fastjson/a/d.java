package com.alibaba.fastjson.a;

import com.alibaba.fastjson.a.a.e;
import java.lang.reflect.Type;

/* compiled from: ProGuard */
public final class d implements e {
    protected final Enum[] a;
    private final Class<?> b;

    public d(Class<?> cls) {
        this.b = cls;
        this.a = (Enum[]) cls.getEnumConstants();
    }

    public final <T> T a(c cVar, Type type, Object obj) {
        try {
            i iVar = cVar.e;
            int i = iVar.a;
            if (i == 2) {
                int n = iVar.n();
                iVar.a(16);
                if (n >= 0 && n <= this.a.length) {
                    return this.a[n];
                }
                throw new com.alibaba.fastjson.d("parse enum " + this.b.getName() + " error, value : " + n);
            } else if (i == 4) {
                String p = iVar.p();
                iVar.a(16);
                if (p.length() != 0) {
                    return Enum.valueOf(this.b, p);
                }
                return null;
            } else if (i == 8) {
                iVar.a(16);
                return null;
            } else {
                throw new com.alibaba.fastjson.d("parse enum " + this.b.getName() + " error, value : " + cVar.a(null));
            }
        } catch (com.alibaba.fastjson.d e) {
            throw e;
        } catch (Throwable e2) {
            throw new com.alibaba.fastjson.d(e2.getMessage(), e2);
        }
    }
}
