package com.alibaba.appmonitor.a;

import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;
import com.alibaba.analytics.core.db.g;
import com.uc.apollo.impl.SettingsConst;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: ProGuard */
public class a extends g implements Cloneable {
    @Column("mp")
    protected String a;
    @Column("module")
    protected String b;
    @Column("offline")
    protected String c;
    @Column("cp")
    private int d;
    @Ingore
    private HashMap<String, a> e;

    final boolean a(int i, ArrayList<String> arrayList) {
        while (arrayList.size() != 0) {
            String str = (String) arrayList.remove(0);
            if (!a(str)) {
                return b(i);
            }
            this = (a) this.e.get(str);
        }
        return b(i);
    }

    private boolean b(int i) {
        af.a("sampling", "module", this.b, "monitorPoint", this.a, "samplingSeed", Integer.valueOf(i), "sampling", Integer.valueOf(this.d));
        if (i < this.d) {
            return true;
        }
        return false;
    }

    public final synchronized void a(String str, a aVar) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        if (a(str)) {
            a aVar2 = (a) this.e.get(str);
            if (!(aVar2 == null || aVar2.e == null || aVar.e == null)) {
                aVar.e.putAll(aVar2.e);
            }
            af.c("config object order errror", "config:", String.valueOf(aVar));
        }
        this.e.put(str, aVar);
    }

    protected final synchronized boolean a(String str) {
        boolean z;
        if (this.e == null) {
            z = false;
        } else {
            z = this.e.containsKey(str);
        }
        return z;
    }

    public final synchronized a b(String str) {
        a aVar;
        a c = c(str);
        if (c == null) {
            try {
                aVar = (a) clone();
                try {
                    aVar.b = str;
                } catch (CloneNotSupportedException e) {
                }
            } catch (CloneNotSupportedException e2) {
                aVar = c;
            }
        } else {
            aVar = c;
        }
        this.e.put(str, aVar);
        return aVar;
    }

    public final synchronized a c(String str) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        return (a) this.e.get(str);
    }

    public void a(int i) {
        this.d = i;
    }

    final boolean a(ArrayList<String> arrayList) {
        while (arrayList.size() != 0) {
            String str = (String) arrayList.remove(0);
            if (!a(str)) {
                return a();
            }
            this = (a) this.e.get(str);
        }
        return a();
    }

    private boolean a() {
        return SettingsConst.TRUE.equalsIgnoreCase(this.c);
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
