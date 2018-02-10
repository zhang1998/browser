package com.uc.weex.component.richtext.a;

import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import java.util.HashMap;

/* compiled from: ProGuard */
public abstract class k {
    HashMap a = new HashMap();
    String b = "";
    String c = "";
    d d = null;
    private HashMap e = new HashMap();

    public final void a(String str, int i, int i2, int i3) {
        d dVar = new d(str, i, i2, i3, this);
        this.e.put(str.toLowerCase(), dVar);
        if (i2 == SectionHeader.SHT_LOUSER) {
            this.d = dVar;
        }
    }

    public final void a(String str, String str2) {
        d a = a(str);
        d a2 = a(str2);
        if (a == null) {
            throw new Error("No child " + str + " for parent " + str2);
        } else if (a2 == null) {
            throw new Error("No parent " + str2 + " for child " + str);
        } else {
            a.h = a2;
        }
    }

    public final void a(String str, int i) {
        this.a.put(str, new Integer(i));
    }

    public final d a(String str) {
        return (d) this.e.get(str.toLowerCase());
    }

    public final void b(String str) {
        this.b = str;
    }

    public final void c(String str) {
        this.c = str;
    }
}
