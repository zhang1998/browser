package com.uc.a.d;

import com.uc.base.b.c.d;
import com.uc.base.b.d.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class x {
    static q a;

    public static synchronized q a() {
        q qVar;
        boolean z = false;
        synchronized (x.class) {
            if (a == null) {
                a = new q();
                d a = c.a(false, (byte) 1, (byte) 3).a("us", "resdata");
                if (a != null) {
                    z = a.a(a);
                }
                if (!z) {
                    String b = h.a.b();
                    if (b != null) {
                        if (b.endsWith(File.separator)) {
                            b = b + "usreslist.ini";
                        } else {
                            b = b + "/usreslist.ini";
                        }
                        if (new File(b).exists()) {
                            Collection a2 = new y(b).a();
                            if (!(a2 == null || a2.isEmpty())) {
                                ArrayList arrayList = a.b;
                                arrayList.clear();
                                arrayList.addAll(a2);
                                b();
                            }
                        }
                    }
                }
                qVar = a;
                if (a(qVar) == null) {
                    ArrayList arrayList2 = qVar.b;
                    g gVar = new g();
                    gVar.b = (byte) 0;
                    gVar.c = "http://ucus.ucweb.com/usquery.php";
                    arrayList2.add(gVar);
                }
            }
            qVar = a;
        }
        return qVar;
    }

    public static boolean b() {
        if (a == null) {
            return false;
        }
        h.b(new k(c.a(false, (byte) 1, (byte) 3)));
        return true;
    }

    public static g a(q qVar) {
        Iterator it = qVar.b.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (gVar.b == (byte) 0) {
                return gVar;
            }
        }
        return null;
    }
}
