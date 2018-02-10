package com.ucpro.feature.navigation.b;

import android.text.TextUtils;
import com.ucpro.feature.navigation.view.ax;
import com.ucweb.common.util.h.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class r implements q {
    private final j a;
    private ArrayList<ax> b = a(this.a);

    public r(j jVar) {
        this.a = jVar;
    }

    private static ArrayList<ax> a(j jVar) {
        ArrayList<ax> arrayList = new ArrayList();
        Iterator it = jVar.b.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            ax axVar = new ax();
            axVar.d = gVar.c;
            axVar.a(gVar.b);
            axVar.a = gVar.f;
            axVar.f = gVar.d;
            axVar.g = gVar.e;
            axVar.b = gVar.g;
            axVar.i = gVar.h;
            arrayList.add(axVar);
        }
        return arrayList;
    }

    public final ArrayList<ax> a() {
        return this.b;
    }

    public final ax a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.b.size(); i++) {
            ax axVar = (ax) this.b.get(i);
            if (str.equals(axVar.d)) {
                return axVar;
            }
        }
        return null;
    }

    public final void a(ax axVar, int i) {
        if (axVar != null && i >= 0 && i < this.b.size()) {
            this.b.remove(axVar);
            this.b.add(i, axVar);
        }
    }

    public final void a(ax axVar) {
        this.b.remove(axVar);
    }

    public final ax a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        ax axVar = new ax();
        axVar.a = System.currentTimeMillis();
        axVar.a(str);
        axVar.d = str2;
        axVar.f = str3;
        axVar.g = str4;
        axVar.i = 2;
        int i = -1;
        int i2 = 0;
        while (i2 < this.b.size() && ((ax) this.b.get(i2)).b == 0) {
            i = i2;
            i2++;
        }
        this.b.add(i + 1, axVar);
        return axVar;
    }

    public final void b() {
        boolean z;
        ArrayList arrayList = this.b;
        j jVar = new j();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            ax axVar = (ax) it.next();
            if (axVar.b == 0) {
                g gVar = new g();
                gVar.b = axVar.e;
                gVar.c = axVar.d;
                gVar.f = axVar.a;
                gVar.d = axVar.f;
                gVar.e = axVar.g;
                gVar.g = axVar.b;
                gVar.h = axVar.i;
                jVar.b.add(gVar);
                i2 = i + 1;
                if (i2 >= 10) {
                    break;
                }
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (jVar.b.size() == 0) {
            z = true;
        } else {
            z = false;
        }
        jVar.c = z;
        m.a(0, new t(this, jVar));
        m.a(0, new l(this, jVar));
    }
}
