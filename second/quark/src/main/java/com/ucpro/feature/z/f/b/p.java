package com.ucpro.feature.z.f.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.ucweb.common.util.c;
import com.ucweb.common.util.i.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public class p {
    private static final String b = p.class.getSimpleName();
    int a = 0;
    private HashSet<n> c = new HashSet();

    public final p a(List<n> list) {
        c.a((Object) list);
        for (n nVar : list) {
            if (!this.c.contains(nVar)) {
                this.c.add(nVar);
            }
        }
        return this;
    }

    public final void a(@NonNull String str, @NonNull Collection<m> collection) {
        c.a((Object) str);
        c.a((Object) collection);
        if (!TextUtils.isEmpty(str) && !this.c.isEmpty()) {
            int i;
            ArrayList arrayList = new ArrayList();
            String toLowerCase = str.trim().toLowerCase();
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                String c = nVar.c();
                String a = nVar.a();
                i = -1;
                if (c != null) {
                    i = c.indexOf(toLowerCase);
                }
                int a2 = a(toLowerCase, a);
                if (i >= 0 || a2 >= 0) {
                    m mVar = new m();
                    mVar.a = nVar.d();
                    mVar.c = nVar.b();
                    mVar.b = f.TITLE_AND_URL;
                    mVar.d = c;
                    mVar.e = a;
                    mVar.f = i;
                    mVar.g = toLowerCase.length();
                    mVar.h = a2;
                    mVar.i = toLowerCase.length();
                    a(new e(mVar, nVar), arrayList);
                }
            }
            int min = Math.min(arrayList.size(), this.a);
            for (i = 0; i < min; i++) {
                collection.add(((e) arrayList.get(i)).a);
            }
        }
    }

    private static int a(String str, String str2) {
        int i = 0;
        try {
            String str3;
            String str4 = new e(str2).a;
            String[] split = str4.split("\\.");
            if (split.length == 3) {
                str3 = split[1];
                i = split[0].length() + 1;
            } else if (split.length == 2) {
                str3 = split[0];
            } else {
                str3 = str4;
            }
            if (!str3.contains(str)) {
                return -1;
            }
            return (str2.indexOf(str4) + i) + str3.indexOf(str);
        } catch (Throwable e) {
            Log.w(b, "parse url fail", e);
            return -1;
        }
    }

    private static void a(e<m, n> eVar, ArrayList<e<m, n>> arrayList) {
        if (arrayList.isEmpty()) {
            arrayList.add(eVar);
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            int i;
            Object obj;
            int i2;
            e eVar2 = (e) arrayList.get(size);
            int i3 = ((m) eVar.a).f >= 0 ? ((m) eVar.a).f : Integer.MAX_VALUE;
            if (((m) eVar2.a).f >= 0) {
                i = ((m) eVar2.a).f;
            } else {
                i = Integer.MAX_VALUE;
            }
            i3 = -(i3 - i);
            if (i3 == 0) {
                int i4;
                if (((m) eVar.a).h >= 0) {
                    i3 = ((m) eVar.a).h;
                } else {
                    i3 = Integer.MAX_VALUE;
                }
                if (((m) eVar2.a).h >= 0) {
                    i4 = ((m) eVar2.a).h;
                } else {
                    i4 = Integer.MAX_VALUE;
                }
                if (((m) eVar.a).e.startsWith("https")) {
                    i3 -= 8;
                } else if (((m) eVar.a).e.startsWith("http")) {
                    i3 -= 7;
                }
                if (((m) eVar2.a).e.startsWith("https://")) {
                    i4 -= 8;
                } else if (((m) eVar2.a).e.startsWith("http://")) {
                    i4 -= 7;
                }
                i3 = -(i3 - i4);
            }
            if (i3 == 0) {
                if (((m) eVar.a).d == null) {
                    obj = -2;
                } else if (((m) eVar.a).d.equalsIgnoreCase(((m) eVar2.a).d) && ((m) eVar.a).e.equalsIgnoreCase(((m) eVar2.a).e)) {
                    i2 = ((n) eVar.b).l() - ((n) eVar2.b).l() > 0 ? 2 : -2;
                }
                if (obj != 1) {
                    if (size == 0) {
                        arrayList.add(0, eVar);
                        return;
                    }
                } else if (obj == -1) {
                    arrayList.add(size + 1, eVar);
                    return;
                } else if (obj == 2) {
                    arrayList.remove(size);
                    arrayList.add(size, eVar);
                    return;
                } else if (obj != -2) {
                    return;
                }
            }
            if (i3 == 0) {
                i = ((n) eVar.b).l() - ((n) eVar2.b).l();
            } else {
                i = i3;
            }
            if (i == 0) {
                i = ((n) eVar.b).e() - ((n) eVar2.b).e();
            }
            if (i == 0) {
                i2 = (int) (((n) eVar.b).f() - ((n) eVar2.b).f());
            } else {
                i2 = i;
            }
            i2 = i2 > 0 ? 1 : -1;
            if (obj != 1) {
                if (obj == -1) {
                    arrayList.add(size + 1, eVar);
                    return;
                } else if (obj == 2) {
                    arrayList.remove(size);
                    arrayList.add(size, eVar);
                    return;
                } else if (obj != -2) {
                    return;
                }
            } else if (size == 0) {
                arrayList.add(0, eVar);
                return;
            }
        }
    }
}
