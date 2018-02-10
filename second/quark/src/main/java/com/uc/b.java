package com.uc;

import com.uc.c.f;
import com.uc.c.g;
import java.io.File;

/* compiled from: ProGuard */
public enum b {
    XIGUA(g.e(), g.c(), new f());
    
    public String b;
    public String c;
    public String d;
    f e;

    private b(String str, String str2, f fVar) {
        this.b = r3;
        this.c = str;
        this.d = str2;
        this.e = fVar;
    }

    public final boolean a() {
        return this.e.a(this.b + File.separator + this.d);
    }
}
