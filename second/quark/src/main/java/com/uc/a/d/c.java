package com.uc.a.d;

import android.text.TextUtils;
import com.uc.a.b.b;
import com.uc.a.b.e;
import com.uc.a.d;
import com.uc.a.f;
import com.uc.a.j;
import com.uc.base.b.c.c.a;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class c implements d, j {
    private static c a = new c();
    private int b = a.a();
    private boolean c = true;
    private boolean d = false;

    public static c a() {
        return a;
    }

    private c() {
    }

    public static void a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            g a = x.a(x.a());
            if (a == null) {
                ArrayList arrayList = x.a().b;
                a = new g();
                arrayList.add(a);
                a.b = (byte) 0;
            }
            a.c = str;
            if (i < j.d || i > j.c) {
                i = j.b;
            }
            a.d = i;
        }
    }

    public final void a(String str, e eVar) {
        if (eVar != null) {
            byte[] a = e.a(eVar);
            if (a != null && a.length > 0) {
                com.uc.a.b.d dVar = new com.uc.a.b.d();
                if (dVar.a(a)) {
                    ArrayList arrayList = x.a().b;
                    ArrayList arrayList2 = dVar.a;
                    g a2 = x.a(x.a());
                    if (a2 != null) {
                        int i;
                        int i2;
                        b bVar;
                        Object obj = a2.c;
                        if (arrayList2 == null || TextUtils.isEmpty(obj)) {
                            i = -1;
                        } else {
                            int size = arrayList2.size();
                            for (i2 = 0; i2 < size; i2++) {
                                bVar = (b) arrayList2.get(i2);
                                if (bVar != null && obj.equals(bVar.b())) {
                                    i = i2;
                                    break;
                                }
                            }
                            i = -1;
                        }
                        if (i >= 0) {
                            bVar = (b) arrayList2.remove(i);
                            if (!(a2 == null || bVar == null)) {
                                if (bVar.a > 0) {
                                    a2.d = bVar.a;
                                }
                                a2.f = a.a();
                                if (bVar.c() != null) {
                                    a2.e = bVar.c();
                                }
                            }
                        }
                        arrayList.clear();
                        arrayList.add(a2);
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            Object obj2;
                            bVar = (b) it.next();
                            if (bVar == null) {
                                obj2 = null;
                            } else {
                                g gVar = new g();
                                gVar.b = (byte) 1;
                                gVar.c = bVar.b();
                                gVar.e = bVar.c();
                                i2 = bVar.a;
                                if (i2 < j.d || i2 > j.c) {
                                    i2 = j.b;
                                }
                                gVar.d = i2;
                                if (bVar.b == 1) {
                                    i = gVar.d - j.a;
                                    if (i <= 0) {
                                        i = j.a;
                                    }
                                    gVar.f = a.a() - i;
                                } else {
                                    gVar.f = a.a();
                                }
                                g gVar2 = gVar;
                            }
                            if (obj2 != null) {
                                arrayList.add(obj2);
                            }
                        }
                        this.d = true;
                    }
                }
            }
        }
    }

    private static g b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = x.a().b;
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            boolean equals;
            g gVar = (g) it.next();
            String str2 = gVar.c;
            if (str2 != null) {
                equals = str2.equals(str);
                continue;
            } else if (str == null) {
                equals = true;
                continue;
            } else {
                equals = false;
                continue;
            }
            if (equals) {
                return gVar;
            }
        }
        return null;
    }

    public static g a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = x.a().b;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (gVar != null && a(gVar.g, str) != null) {
                return gVar;
            }
        }
        return null;
    }

    private static ah a(ArrayList<ah> arrayList, String str) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ah ahVar = (ah) it.next();
            if (ahVar.b.equals(str)) {
                return ahVar;
            }
        }
        return null;
    }

    public final void b(String str, e eVar) {
        if (eVar != null) {
            String b = eVar.b();
            Object c = eVar.c();
            g b2;
            ArrayList arrayList;
            ah a;
            if ("00000000".equals(c)) {
                if (!TextUtils.isEmpty(b)) {
                    if (!TextUtils.isEmpty(str)) {
                        b2 = b(str);
                        if (b2 != null) {
                            arrayList = b2.g;
                            a = a(arrayList, b);
                            if (a != null) {
                                arrayList.remove(a);
                            }
                        }
                    } else if (!TextUtils.isEmpty(b)) {
                        arrayList = x.a().b;
                        if (!(arrayList == null || arrayList.isEmpty())) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                b2 = (g) it.next();
                                if (b2 != null) {
                                    arrayList = b2.g;
                                    ah a2 = a(arrayList, b);
                                    if (a2 != null) {
                                        arrayList.remove(a2);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(c)) {
                ah ahVar = new ah();
                ahVar.b = b;
                ahVar.c = c;
                ahVar.e = a.a();
                if (TextUtils.isEmpty(str)) {
                    b2 = x.a(x.a());
                } else {
                    b2 = b(str);
                }
                if (b2 != null) {
                    arrayList = b2.g;
                    a = a(arrayList, ahVar.b);
                    if (a != null) {
                        arrayList.remove(a);
                    }
                    arrayList.add(ahVar);
                } else if (!TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(str)) {
                        c = null;
                    } else {
                        c = new g();
                        c.b = (byte) 1;
                        c.c = str;
                        c.d = j.b;
                        c.f = a.a();
                        c.g.add(ahVar);
                    }
                    if (c != null) {
                        x.a().b.add(c);
                    }
                }
            } else {
                return;
            }
            this.d = true;
        }
    }

    public static boolean a(g gVar) {
        if (Math.abs(a.a() - gVar.f) >= gVar.d) {
            return true;
        }
        return false;
    }

    public final void b(g gVar) {
        int a = a.a();
        if (gVar != null) {
            gVar.f = a;
            Iterator it = gVar.g.iterator();
            while (it.hasNext()) {
                ah ahVar = (ah) it.next();
                if (ahVar != null) {
                    ahVar.e = a;
                }
            }
        }
        this.d = true;
    }

    public static g b() {
        return x.a(x.a());
    }

    public final void a(f fVar) {
        if (this.d) {
            x.b();
            this.d = false;
        }
    }
}
