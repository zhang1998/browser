package com.alibaba.fastjson.b;

import com.alibaba.fastjson.a.a.e;
import com.alibaba.fastjson.a.c;
import com.alibaba.fastjson.a.i;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: ProGuard */
public final class f implements e, u {
    public static final f a = new f();

    private f() {
    }

    public final void a(o oVar, Object obj, Object obj2, Type type) throws IOException {
        aa aaVar = oVar.b;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            if ((aaVar.c & z.WriteNullBooleanAsFalse.x) != 0) {
                aaVar.write("false");
            } else {
                aaVar.write("null");
            }
        } else if (bool.booleanValue()) {
            aaVar.write("true");
        } else {
            aaVar.write("false");
        }
    }

    public final <T> T a(c cVar, Type type, Object obj) {
        i iVar = cVar.e;
        int a = iVar.a();
        if (a == 6) {
            iVar.a(16);
            return Boolean.TRUE;
        } else if (a == 7) {
            iVar.a(16);
            return Boolean.FALSE;
        } else if (a == 2) {
            int n = iVar.n();
            iVar.a(16);
            if (n == 1) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } else {
            Object a2 = cVar.a(null);
            if (a2 != null) {
                return com.alibaba.fastjson.c.e.k(a2);
            }
            return null;
        }
    }
}
