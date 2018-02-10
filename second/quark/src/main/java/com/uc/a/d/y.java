package com.uc.a.d;

import android.text.TextUtils;
import com.uc.a.j;
import com.uc.base.b.c.c.a;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class y {
    private String a;

    y(String str) {
        this.a = str;
    }

    private static g a(ag agVar) {
        g gVar;
        String[] split;
        int a;
        String[] split2 = agVar.a.split(";");
        if (split2 == null || 6 != split2.length) {
            gVar = null;
        } else {
            split = split2[1].split("=");
            if (split == null || 2 != split.length || TextUtils.isEmpty(split[1])) {
                gVar = null;
            } else {
                gVar = new g();
                gVar.c = split[1];
                split = split2[0].split("=");
                if (split != null && 2 == split.length) {
                    gVar.b = (byte) a.a(split[1], 0);
                }
                split = split2[2].split("=");
                if (split != null && 2 == split.length) {
                    a = a.a(split[1], 0);
                    if (a < j.d) {
                        a = j.d;
                    }
                    gVar.d = a;
                }
                split = split2[3].split("=");
                if (split != null && 2 == split.length) {
                    gVar.f = (int) a.e(split[1]);
                }
                split = split2[4].split("=");
                if (split != null) {
                    gVar.e = split[1];
                }
            }
        }
        if (gVar != null) {
            Iterator it = agVar.b.iterator();
            while (it.hasNext()) {
                String[] split3 = ((String) it.next()).split(";");
                if (split3 != null && 4 == split3.length) {
                    split = split3[0].split("=");
                    if (!(split == null || 2 != split.length || TextUtils.isEmpty(split[1].trim()))) {
                        ArrayList arrayList = gVar.g;
                        ah ahVar = new ah();
                        arrayList.add(ahVar);
                        ahVar.b = split[1].trim();
                        split = split3[1].split("=");
                        if (split != null && 2 == split.length) {
                            ahVar.c = split[1].trim();
                        }
                        split = split3[2].split("=");
                        if (split != null && 2 == split.length) {
                            a = a.a(split[1], 0);
                            if (a < j.a) {
                                a = j.a;
                            }
                            ahVar.d = a;
                        }
                        split = split3[3].split("=");
                        if (split != null && 2 == split.length) {
                            ahVar.e = (int) a.e(split[1].trim());
                        }
                    }
                }
            }
        }
        return gVar;
    }

    public final ArrayList<g> a() {
        ArrayList arrayList;
        ArrayList<g> arrayList2 = null;
        Object f = a.f(this.a);
        if (TextUtils.isEmpty(f)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] split = f.split("\n");
            if (split != null) {
                ag agVar = null;
                Object obj = null;
                Object obj2 = null;
                for (String str : split) {
                    if ("[ServerResBegin]".equals(str)) {
                        agVar = new ag(this);
                        obj = null;
                        obj2 = 1;
                    } else if ("[ServerResEnd]".equals(str)) {
                        arrayList3.add(agVar);
                        agVar = null;
                        obj2 = null;
                    } else if (obj2 != null) {
                        if (str.startsWith("item=")) {
                            agVar.b.add(str.trim());
                        } else if (obj == null && str.startsWith("type=")) {
                            agVar.a = str;
                            int i = 1;
                        }
                    }
                }
            }
            arrayList = arrayList3;
        }
        if (!(arrayList == null || arrayList.isEmpty())) {
            arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                g a = a((ag) it.next());
                if (a != null) {
                    arrayList2.add(a);
                }
            }
        }
        return arrayList2;
    }
}
