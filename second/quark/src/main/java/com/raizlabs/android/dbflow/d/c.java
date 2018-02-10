package com.raizlabs.android.dbflow.d;

import com.raizlabs.android.dbflow.annotation.TypeConverter;
import java.util.Calendar;
import java.util.GregorianCalendar;

@TypeConverter(allowedSubtypes = {GregorianCalendar.class})
/* compiled from: ProGuard */
public final class c extends a<Long, Calendar> {
    public final /* synthetic */ Object a(Object obj) {
        Calendar calendar = (Calendar) obj;
        return calendar == null ? null : Long.valueOf(calendar.getTimeInMillis());
    }
}
