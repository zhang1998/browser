package com.uc.weex.a;

import com.taobao.weex.common.s;
import com.uc.weex.h;

/* compiled from: ProGuard */
public final class aa {
    String a;
    String b;
    String c;
    String d;
    boolean e;

    aa(s sVar, String str, boolean z) {
        this.d = str;
        if (sVar != null) {
            this.a = sVar.c;
            this.b = sVar.a;
            this.c = sVar.d;
        }
        this.e = z;
    }

    aa(h hVar, String str) {
        this.a = hVar.g;
        this.c = hVar.h;
        this.d = str;
        this.e = false;
    }
}
