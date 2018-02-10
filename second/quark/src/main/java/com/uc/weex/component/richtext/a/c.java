package com.uc.weex.component.richtext.a;

/* compiled from: ProGuard */
public final class c {
    d a;
    a b;
    c c;
    boolean d;

    public c(d dVar, boolean z) {
        this.a = dVar;
        if (z) {
            this.b = new a(dVar.g);
        } else {
            this.b = new a();
        }
        this.c = null;
        this.d = false;
    }

    public final boolean a(c cVar) {
        return (this.a.d & cVar.a.e) != 0;
    }

    public final void a(String str, String str2) {
        d dVar = this.a;
        a aVar = this.b;
        if (!str.equals("xmlns") && !str.startsWith("xmlns:")) {
            String a = dVar.a(str, true);
            String a2 = d.a(str);
            int index = aVar.getIndex(str);
            String intern;
            if (index == -1) {
                intern = str.intern();
                String str3 = "CDATA";
                if (!str3.equals("CDATA")) {
                    str2 = d.b(str2);
                }
                int i = aVar.a + 1;
                if (i > 0) {
                    if (aVar.b == null || aVar.b.length == 0) {
                        index = 25;
                    } else if (aVar.b.length < i * 5) {
                        index = aVar.b.length;
                    }
                    while (index < i * 5) {
                        index *= 2;
                    }
                    Object obj = new String[index];
                    if (aVar.a > 0) {
                        System.arraycopy(aVar.b, 0, obj, 0, aVar.a * 5);
                    }
                    aVar.b = obj;
                }
                aVar.b[aVar.a * 5] = a;
                aVar.b[(aVar.a * 5) + 1] = a2;
                aVar.b[(aVar.a * 5) + 2] = intern;
                aVar.b[(aVar.a * 5) + 3] = str3;
                aVar.b[(aVar.a * 5) + 4] = str2;
                aVar.a++;
                return;
            }
            intern = aVar.getType(index);
            if (!intern.equals("CDATA")) {
                str2 = d.b(str2);
            }
            if (index < 0 || index >= aVar.a) {
                a.b(index);
                return;
            }
            aVar.b[index * 5] = a;
            aVar.b[(index * 5) + 1] = a2;
            aVar.b[(index * 5) + 2] = str;
            aVar.b[(index * 5) + 3] = intern;
            aVar.b[(index * 5) + 4] = str2;
        }
    }
}
