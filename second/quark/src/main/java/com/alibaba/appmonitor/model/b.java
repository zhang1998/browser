package com.alibaba.appmonitor.model;

import android.text.TextUtils;
import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;
import com.alibaba.analytics.core.db.annotation.TableName;
import com.alibaba.analytics.core.db.g;
import com.alibaba.appmonitor.a.c;
import com.alibaba.appmonitor.a.d;
import com.alibaba.appmonitor.e.a;
import com.alibaba.appmonitor.f.h;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import java.util.ArrayList;
import java.util.UUID;

@TableName("stat_register_temp")
/* compiled from: ProGuard */
public class b extends g implements a {
    @Column("module")
    public String a;
    @Column("monitor_point")
    public String b;
    @Ingore
    public DimensionSet c;
    @Ingore
    public MeasureSet d;
    @Ingore
    public String e;
    @Column("dimensions")
    private String f;
    @Column("measures")
    private String g;
    @Ingore
    private String h;
    @Column("is_commit_detail")
    private boolean i;

    public b(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = dimensionSet;
        this.d = measureSet;
        this.h = null;
        this.i = z;
        if (dimensionSet != null) {
            this.f = com.alibaba.fastjson.a.a((Object) dimensionSet);
        }
        this.g = com.alibaba.fastjson.a.a((Object) measureSet);
    }

    public final synchronized String b() {
        if (this.e == null) {
            this.e = UUID.randomUUID().toString() + "$" + this.a + "$" + this.b;
        }
        return this.e;
    }

    public final DimensionSet c() {
        if (this.c == null && !TextUtils.isEmpty(this.f)) {
            this.c = (DimensionSet) com.alibaba.fastjson.a.a(this.f, DimensionSet.class);
        }
        return this.c;
    }

    public final MeasureSet d() {
        if (this.d == null && !TextUtils.isEmpty(this.g)) {
            this.d = (MeasureSet) com.alibaba.fastjson.a.a(this.g, MeasureSet.class);
        }
        return this.d;
    }

    public final synchronized boolean e() {
        boolean z;
        if (!this.i) {
            d a = d.a();
            String str = this.a;
            String str2 = this.b;
            com.alibaba.appmonitor.a.a aVar = (com.alibaba.appmonitor.a.a) a.a.get(h.STAT);
            if (aVar == null) {
                z = false;
            } else {
                c cVar = (c) aVar;
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(str);
                arrayList.add(str2);
                z = cVar.b(arrayList);
            }
            if (!z) {
                z = false;
            }
        }
        z = true;
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.a == null ? 0 : this.a.hashCode()) + (((this.h == null ? 0 : this.h.hashCode()) + 31) * 31)) * 31;
        if (this.b != null) {
            i = this.b.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.h == null) {
            if (bVar.h != null) {
                return false;
            }
        } else if (!this.h.equals(bVar.h)) {
            return false;
        }
        if (this.a == null) {
            if (bVar.a != null) {
                return false;
            }
        } else if (!this.a.equals(bVar.a)) {
            return false;
        }
        if (this.b == null) {
            if (bVar.b != null) {
                return false;
            }
            return true;
        } else if (this.b.equals(bVar.b)) {
            return true;
        } else {
            return false;
        }
    }

    public final void a() {
        this.a = null;
        this.b = null;
        this.h = null;
        this.i = false;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    public final void a(Object... objArr) {
        this.a = (String) objArr[0];
        this.b = (String) objArr[1];
        if (objArr.length > 2) {
            this.h = (String) objArr[2];
        }
    }
}
