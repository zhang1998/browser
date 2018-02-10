package com.alibaba.fastjson.b;

import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: ProGuard */
final class i implements u {
    i() {
    }

    public final void a(o oVar, Object obj, Object obj2, Type type) throws IOException {
        aa aaVar = oVar.b;
        if ((aaVar.c & z.WriteEnumUsingToString.x) != 0) {
            String str = ((Enum) obj).toString();
            if ((aaVar.c & z.UseSingleQuotes.x) != 0) {
                aaVar.b(str);
                return;
            } else {
                aaVar.a(str, '\u0000', false);
                return;
            }
        }
        aaVar.b(((Enum) obj).ordinal());
    }
}
