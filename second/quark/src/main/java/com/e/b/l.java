package com.e.b;

import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.b;
import com.alibaba.analytics.core.c;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.model.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class l {
    private static Pattern c = Pattern.compile("(\\|\\||[\t\r\n]|\u0001|\u0000)+");
    private static List<String> d;
    private String a = null;
    private Map<String, String> b = new HashMap();
    private String e = null;

    static {
        d = null;
        d = new ArrayList(34);
        for (Object valueOf : LogField.values()) {
            d.add(String.valueOf(valueOf).toLowerCase());
        }
    }

    public final void a(Map<String, String> map) {
        if (map != null) {
            Map map2;
            String str;
            if (map.containsKey("_bmbu")) {
                map.remove("_bmbu");
                map2 = map;
            } else {
                map2 = new HashMap();
            }
            map2.putAll(this.b);
            map2.putAll(map);
            if (!TextUtils.isEmpty(this.a)) {
                map2.put("_track_id", this.a);
            }
            if (c.a().d) {
                map2.put(a.ALIYUN_PLATFORM_FLAG.toString(), "yes");
            }
            if (map.containsKey("_fuamf")) {
                map2.remove("_fuamf");
            } else if (map2 != null) {
                if (map2.containsKey(LogField.IMEI.toString())) {
                    map2.remove(LogField.IMEI.toString());
                }
                if (map2.containsKey(LogField.IMSI.toString())) {
                    map2.remove(LogField.IMSI.toString());
                }
                if (map2.containsKey(LogField.CARRIER.toString())) {
                    map2.remove(LogField.CARRIER.toString());
                }
                if (map2.containsKey(LogField.ACCESS.toString())) {
                    map2.remove(LogField.ACCESS.toString());
                }
                if (map2.containsKey(LogField.ACCESS_SUBTYPE.toString())) {
                    map2.remove(LogField.ACCESS_SUBTYPE.toString());
                }
                if (map2.containsKey(LogField.CHANNEL.toString())) {
                    map2.remove(LogField.CHANNEL.toString());
                }
                if (map2.containsKey(LogField.LL_USERNICK.toString())) {
                    map2.remove(LogField.LL_USERNICK.toString());
                }
                if (map2.containsKey(LogField.USERNICK.toString())) {
                    map2.remove(LogField.USERNICK.toString());
                }
                if (map2.containsKey(LogField.LL_USERID.toString())) {
                    map2.remove(LogField.LL_USERID.toString());
                }
                if (map2.containsKey(LogField.USERID.toString())) {
                    map2.remove(LogField.USERID.toString());
                }
                if (map2.containsKey(LogField.SDKVERSION.toString())) {
                    map2.remove(LogField.SDKVERSION.toString());
                }
                if (map2.containsKey(LogField.START_SESSION_TIMESTAMP.toString())) {
                    map2.remove(LogField.START_SESSION_TIMESTAMP.toString());
                }
                if (map2.containsKey(LogField.UTDID.toString())) {
                    map2.remove(LogField.UTDID.toString());
                }
                if (map2.containsKey(LogField.SDKTYPE.toString())) {
                    map2.remove(LogField.SDKTYPE.toString());
                }
                if (map2.containsKey(LogField.RESERVE2.toString())) {
                    map2.remove(LogField.RESERVE2.toString());
                }
                if (map2.containsKey(LogField.RESERVE3.toString())) {
                    map2.remove(LogField.RESERVE3.toString());
                }
                if (map2.containsKey(LogField.RESERVE4.toString())) {
                    map2.remove(LogField.RESERVE4.toString());
                }
                if (map2.containsKey(LogField.RESERVE5.toString())) {
                    map2.remove(LogField.RESERVE5.toString());
                }
                if (map2.containsKey(LogField.RESERVES.toString())) {
                    map2.remove(LogField.RESERVES.toString());
                }
                if (map2.containsKey(LogField.RECORD_TIMESTAMP.toString())) {
                    map2.remove(LogField.RECORD_TIMESTAMP.toString());
                }
            }
            if (map2 != null) {
                if (map2.containsKey("_field_os")) {
                    str = (String) map2.get("_field_os");
                    map2.remove("_field_os");
                    map2.put(LogField.OS.toString(), str);
                }
                if (map2.containsKey("_field_os_version")) {
                    str = (String) map2.get("_field_os_version");
                    map2.remove("_field_os_version");
                    map2.put(LogField.OSVERSION.toString(), str);
                }
            }
            map2.put(LogField.SDKTYPE.toString(), "mini");
            if (TextUtils.isEmpty(this.e)) {
                map2.put(LogField.APPKEY.toString(), c.a().c);
            } else {
                map2.put(LogField.APPKEY.toString(), this.e);
            }
            Map hashMap = new HashMap();
            if (map2.containsKey("_track_id")) {
                str = (String) map2.get("_track_id");
                map2.remove("_track_id");
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("_tkid", str);
                }
            }
            if (hashMap.size() > 0) {
                map2.put(LogField.RESERVES.toString(), b.a(hashMap));
            }
            if (!map2.containsKey(LogField.PAGE.toString())) {
                map2.put(LogField.PAGE.toString(), "UT");
            }
            if (VERSION.SDK_INT < 14) {
                Map hashMap2 = new HashMap();
                hashMap2.putAll(map);
                if (e.b().a() != null) {
                    h a = e.b().a();
                    hashMap2 = hashMap2;
                    if (hashMap2.containsKey(LogField.EVENTID.toString())) {
                        if ("2001".equals((String) hashMap2.get(LogField.EVENTID.toString()))) {
                            long parseLong;
                            if (hashMap2.containsKey(LogField.ARG3.toString())) {
                                try {
                                    parseLong = Long.parseLong((String) hashMap2.get(LogField.ARG3.toString()));
                                } catch (Exception e) {
                                }
                                a.a = parseLong + a.a;
                                if (h.a()) {
                                    a.a(a.a);
                                    a.a = 0;
                                }
                            }
                            parseLong = 0;
                            a.a = parseLong + a.a;
                            if (h.a()) {
                                a.a(a.a);
                                a.a = 0;
                            }
                        }
                    }
                }
            }
            if ("2101".equals(map.get(LogField.EVENTID.toString())) || "2102".equals(map.get(LogField.EVENTID.toString()))) {
                com.e.b.b.a.a().a("ctrlClicked:" + ((String) map.get(LogField.ARG1.toString())));
                map2.put("_priority", "4");
            }
            if ("true".equals(com.alibaba.analytics.c.c("sw_plugin"))) {
                int parseInt = Integer.parseInt((String) map.get(LogField.EVENTID.toString()));
                String str2 = (String) map.get(LogField.PAGE.toString());
                String str3 = (String) map.get(LogField.ARG1.toString());
                String str4 = (String) map.get(LogField.ARG2.toString());
                String str5 = (String) map.get(LogField.ARG3.toString());
                com.e.b.b.a.a a2 = com.e.b.b.a.a.a();
                c cVar = new c(this, parseInt, str2, str3, str4, str5, map2);
                a2.b();
            }
            b a3 = b.a();
            if (!com.alibaba.analytics.c.d) {
                af.c("Please call  () before call other method", new Object[0]);
            }
            if (!com.alibaba.analytics.c.d) {
                return;
            }
            if (map2.containsKey("_sls")) {
                try {
                    if (com.alibaba.analytics.c.a != null) {
                        com.alibaba.analytics.c.a.c(map2);
                        return;
                    }
                    af.c("UTAnalytics", "iAnalytics", com.alibaba.analytics.c.a);
                    return;
                } catch (Throwable th) {
                    return;
                }
            }
            com.alibaba.analytics.c.b.a(new a(a3, map2));
        }
    }

    public static void a(Object obj) {
        g.a().b(obj);
    }

    public static void b(Object obj) {
        g.a().a(obj, true);
    }

    public final void c(Object obj) {
        g.a().a(obj, this);
    }

    public static void b(Map<String, String> map) {
        g.a().a((Map) map);
    }

    public static void a(String str) {
        g.a().a(str);
    }

    public static void a(Object obj, String str) {
        g.a().b(obj, str);
    }

    public static void a(Object obj, Map<String, String> map) {
        g.a().a(obj, (Map) map);
    }

    public static void b(Object obj, String str) {
        g.a().a(obj, str);
    }

    public static void a(Object obj, Uri uri) {
        g.a().a(obj, uri);
    }

    public static void d(Object obj) {
        g.a().c(obj);
    }
}
