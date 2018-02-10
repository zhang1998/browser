package com.raizlabs.android.dbflow.d;

import com.raizlabs.android.dbflow.annotation.TypeConverter;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@TypeConverter(allowedSubtypes = {Time.class, Timestamp.class})
/* compiled from: ProGuard */
public final class h extends a<Long, Date> {
    public final /* synthetic */ Object a(Object obj) {
        Date date = (Date) obj;
        return date == null ? null : Long.valueOf(date.getTime());
    }
}
