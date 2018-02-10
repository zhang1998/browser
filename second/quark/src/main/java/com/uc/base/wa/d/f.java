package com.uc.base.wa.d;

import android.util.Log;
import com.uc.base.wa.d.k.com.uc.base.wa.d.f.com.uc.base.wa.d.e;
import com.uc.base.wa.t;
import com.uc.base.wa.u;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class f implements g {
    final /* synthetic */ String a;
    final /* synthetic */ List b;
    final /* synthetic */ k c;
    private HashMap<u, e> d = new HashMap();

    f(k kVar, String str, List list) {
        this.c = kVar;
        this.a = str;
        this.b = list;
    }

    private e a(u uVar) {
        e eVar = (e) this.d.get(uVar);
        if (eVar != null) {
            return eVar;
        }
        eVar = new e(this);
        this.d.put(uVar, eVar);
        return eVar;
    }

    public final String a() {
        File file = new File(this.c.n);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(this.c.o);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (this.c.k) {
            this.c.p = new File(this.c.n);
        } else if (this.c.l) {
            this.c.p = new File(this.c.o);
        }
        if (!this.c.p.exists()) {
            this.c.p.mkdirs();
        }
        this.c.a(k.a());
        this.c.h = this.c.g;
        boolean a = a(false, 1);
        boolean a2 = this.c.a(this.a, this.b);
        boolean a3 = a(a2, 2);
        if (a2) {
            String str;
            String[] list = this.c.p.list();
            if (list == null || list.length == 0) {
                str = null;
            } else {
                List asList = Arrays.asList(list);
                Collections.sort(asList);
                str = ((String) asList.get(0)).replace(".wa", "");
            }
            if (str != null) {
                return str;
            }
        } else if (a || a3) {
            return String.valueOf(System.currentTimeMillis());
        }
        return "";
    }

    public final void a(int i) {
        int i2 = 0;
        if (this.c.a == null) {
            return;
        }
        if (this.c.b == File.class) {
            boolean z;
            this.c.a.a(i, this.c.j, this.c.f, this.c.p);
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            if (l.e.size() != 0) {
                for (Entry entry : l.e.entrySet()) {
                    entry.getKey();
                    t a = a((u) entry.getValue());
                    a.b = z;
                    ((u) entry.getValue()).a(3, a);
                }
            }
            if (i == 0) {
                k kVar = this.c;
                if (kVar.p != null && kVar.p.exists() && !kVar.p.delete()) {
                    File[] listFiles = kVar.p.listFiles();
                    if (listFiles != null) {
                        int length = listFiles.length;
                        while (i2 < length) {
                            listFiles[i2].delete();
                            i2++;
                        }
                    }
                    if (!kVar.p.delete()) {
                        Log.e("gzm_wa_WaNet", "", new Throwable());
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new Error("param invalid");
    }

    private boolean a(boolean z, int i) {
        if (l.e.size() == 0) {
            return false;
        }
        int i2 = 0;
        for (Entry entry : l.e.entrySet()) {
            String str = (String) entry.getKey();
            if (!this.c.m || str.equals("forced")) {
                Object a = a((u) entry.getValue());
                a.c = z;
                a.d = str;
                ((u) entry.getValue()).a(i, a);
                i2 = a.a | i2;
            }
        }
        if (i2 != 0) {
            try {
                this.c.e.write(10);
            } catch (Throwable e) {
                Log.e("gzm_wa_WaNet", "", e);
            }
        }
        return i2;
    }
}
