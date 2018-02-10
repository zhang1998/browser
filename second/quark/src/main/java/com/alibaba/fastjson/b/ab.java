package com.alibaba.fastjson.b;

import com.alibaba.fastjson.a.a.e;
import com.alibaba.fastjson.a.c;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: ProGuard */
public final class ab implements e, u {
    public static ab a = new ab();

    private ab() {
    }

    public final void a(o oVar, Object obj, Object obj2, Type type) throws IOException {
        String str = (String) obj;
        aa aaVar = oVar.b;
        if (str == null) {
            aaVar.write("null");
        } else {
            aaVar.a(str);
        }
    }

    public final <T> T a(c cVar, Type type, Object obj) {
        return cVar.d();
    }
}
