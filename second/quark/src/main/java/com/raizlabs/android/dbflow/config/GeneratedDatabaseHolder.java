package com.raizlabs.android.dbflow.config;

import com.raizlabs.android.dbflow.d.b;
import com.raizlabs.android.dbflow.d.c;
import com.raizlabs.android.dbflow.d.d;
import com.raizlabs.android.dbflow.d.e;
import com.raizlabs.android.dbflow.d.f;
import com.raizlabs.android.dbflow.d.g;
import com.raizlabs.android.dbflow.d.h;
import com.raizlabs.android.dbflow.d.i;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

/* compiled from: ProGuard */
public final class GeneratedDatabaseHolder extends f {
    public GeneratedDatabaseHolder() {
        this.typeConverters.put(Boolean.class, new g());
        this.typeConverters.put(Character.class, new d());
        this.typeConverters.put(BigDecimal.class, new f());
        this.typeConverters.put(BigInteger.class, new i());
        this.typeConverters.put(Date.class, new h());
        this.typeConverters.put(Time.class, new h());
        this.typeConverters.put(Timestamp.class, new h());
        this.typeConverters.put(Calendar.class, new c());
        this.typeConverters.put(GregorianCalendar.class, new c());
        this.typeConverters.put(java.util.Date.class, new e());
        this.typeConverters.put(UUID.class, new b());
        v vVar = new v(this);
        u uVar = new u(this);
    }
}
