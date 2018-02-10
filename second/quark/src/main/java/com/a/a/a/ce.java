package com.a.a.a;

import java.util.Calendar;

/* compiled from: ProGuard */
public final class ce {
    static long a(long j, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i2 = ((instance.get(12) / 6) + 1) + (instance.get(11) * 10);
        int i3 = instance.get(13);
        int i4 = 0;
        if (i == 1002) {
            i4 = 360 - (((instance.get(12) % 6) * 60) + i3);
        } else if (i == 1001) {
            i4 = 60 - (i3 % 60);
            if (i2 % 6 == 0) {
                i4 += 60;
            }
        }
        return (long) (i4 * 1000);
    }

    static int a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return instance.get(5);
    }
}
