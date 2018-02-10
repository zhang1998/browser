package com.uc.base.wa;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.uc.apollo.impl.SettingsConst;
import com.uc.base.wa.a.c;
import com.uc.base.wa.config.m;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class z {
    private static boolean a = true;

    private static long a(long j, int i, long j2) {
        return ((((j + j2) + 86400000) / 86400000) * 86400000) + (((long) i) * 3600000);
    }

    private static String a(String str, String str2, int i, String str3) {
        return String.valueOf(str2) + ":" + String.valueOf(i) + ":" + str3 + "`" + str;
    }

    public static boolean a() {
        return a;
    }

    public static void b() {
        a = false;
    }

    public static HashMap<String, String> c() {
        long j = (long) Calendar.getInstance().get(15);
        HashMap<String, String> hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences a = m.a("ffc1d42b1ca5e3db2657d00b91997f6a").a();
        Editor edit = a.edit();
        try {
            for (Entry entry : ((HashMap) a.getAll()).entrySet()) {
                Object obj = null;
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                int indexOf = str2.indexOf(":");
                int indexOf2 = str2.indexOf(":", indexOf + 1);
                int indexOf3 = str2.indexOf("`");
                long longValue = Long.valueOf(str2.substring(0, indexOf)).longValue();
                Integer valueOf = Integer.valueOf(str2.substring(indexOf + 1, indexOf2));
                String substring = str2.substring(indexOf2 + 1, indexOf3);
                if (0 == longValue) {
                    obj = 1;
                } else if (SettingsConst.TRUE.equals(substring)) {
                    if (currentTimeMillis > longValue - j) {
                        obj = 1;
                    } else if (currentTimeMillis < (longValue - j) - 172800000) {
                        String substring2 = str2.substring(indexOf3 + 1);
                        hashMap.put(str, substring2);
                        edit.putString(str, a(substring2, String.valueOf(a(currentTimeMillis, valueOf.intValue(), j)), valueOf.intValue(), String.valueOf(substring)));
                        obj = null;
                    }
                }
                if (obj != null) {
                    str2 = str2.substring(indexOf3 + 1);
                    hashMap.put(str, str2);
                    if (SettingsConst.TRUE.equals(substring)) {
                        edit.putString(str, a(str2, String.valueOf(a(currentTimeMillis, valueOf.intValue(), j)), valueOf.intValue(), String.valueOf(substring)));
                    }
                }
                if (SettingsConst.FALSE.equals(substring)) {
                    edit.remove(str);
                }
            }
        } catch (Throwable e) {
            Log.e("gzm_wa_WaStatus", "", e);
            c.a().b(e.toString());
        } finally {
            edit.commit();
        }
        return hashMap;
    }
}
