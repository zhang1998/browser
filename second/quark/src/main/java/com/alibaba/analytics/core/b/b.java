package com.alibaba.analytics.core.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.alibaba.analytics.a.ae;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.r;
import com.alibaba.analytics.b.a;
import com.alibaba.analytics.core.e.d;
import com.alibaba.analytics.core.e.e;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.o;
import com.uc.apollo.impl.SettingsConst;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class b {
    private static volatile String a = null;
    private static volatile String b = null;

    private static void a(String str, Map<String, String> map, Map<String, String> map2) {
        if (!map.containsKey(str) && map2.get(str) != null) {
            map.put(str, map2.get(str));
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        Context context;
        Object obj;
        Object obj2;
        Context context2 = com.alibaba.analytics.core.b.a().b;
        if (context2 != null || o.i() == null) {
            context = context2;
        } else {
            context = o.i().getApplicationContext();
        }
        d a = e.a(context);
        if (a != null) {
            obj = a.a;
            obj2 = a.b;
        } else {
            obj2 = null;
            obj = null;
        }
        if (obj != null && obj2 != null && map.get(LogField.IMEI.toString()) == null && map.get(LogField.IMSI.toString()) == null) {
            map.put(LogField.IMEI.toString(), obj);
            map.put(LogField.IMSI.toString(), obj2);
        }
        if (!TextUtils.isEmpty(com.alibaba.analytics.core.b.a().h)) {
            map.put(LogField.USERNICK.toString(), com.alibaba.analytics.core.b.a().h);
        }
        if (!TextUtils.isEmpty(com.alibaba.analytics.core.b.a().i)) {
            map.put(LogField.LL_USERNICK.toString(), com.alibaba.analytics.core.b.a().i);
        }
        if (!TextUtils.isEmpty(com.alibaba.analytics.core.b.a().j)) {
            map.put(LogField.USERID.toString(), com.alibaba.analytics.core.b.a().j);
        }
        if (!TextUtils.isEmpty(com.alibaba.analytics.core.b.a().k)) {
            map.put(LogField.LL_USERID.toString(), com.alibaba.analytics.core.b.a().k);
        }
        if (!map.containsKey(LogField.SDKVERSION.toString())) {
            String logField = LogField.SDKVERSION.toString();
            a.a();
            map.put(logField, a.b());
        }
        if (!map.containsKey(LogField.APPKEY.toString())) {
            map.put(LogField.APPKEY.toString(), com.alibaba.analytics.core.b.a().c);
        }
        if (!TextUtils.isEmpty(com.alibaba.analytics.core.b.a().e())) {
            map.put(LogField.CHANNEL.toString(), com.alibaba.analytics.core.b.a().e());
        }
        if (!TextUtils.isEmpty(com.alibaba.analytics.core.b.a().d())) {
            map.put(LogField.APPVERSION.toString(), com.alibaba.analytics.core.b.a().d());
        }
        if (!map.containsKey(LogField.RECORD_TIMESTAMP.toString())) {
            map.put(LogField.RECORD_TIMESTAMP.toString(), (System.currentTimeMillis() + h.a().a));
        }
        if (!map.containsKey(LogField.START_SESSION_TIMESTAMP.toString())) {
            map.put(LogField.START_SESSION_TIMESTAMP.toString(), e.a().a);
        }
        if (!map.containsKey(LogField.SDKTYPE.toString())) {
            map.put(LogField.SDKTYPE.toString(), com.alibaba.analytics.core.a.a());
        }
        Map a2 = ae.a(context);
        if (a2 == null) {
            return null;
        }
        StringBuilder stringBuilder;
        boolean z;
        Context context3;
        String str;
        map.put(LogField.BRAND.toString(), a2.get(LogField.BRAND.toString()));
        map.put(LogField.DEVICE_MODEL.toString(), a2.get(LogField.DEVICE_MODEL.toString()));
        map.put(LogField.RESOLUTION.toString(), a2.get(LogField.RESOLUTION.toString()));
        map.put(LogField.OS.toString(), a2.get(LogField.OS.toString()));
        map.put(LogField.OSVERSION.toString(), a2.get(LogField.OSVERSION.toString()));
        map.put(LogField.UTDID.toString(), a2.get(LogField.UTDID.toString()));
        a(LogField.IMEI.toString(), map, a2);
        a(LogField.IMSI.toString(), map, a2);
        a(LogField.APPVERSION.toString(), map, a2);
        a(com.alibaba.analytics.core.model.a.DEVICE_ID.toString(), map, a2);
        a(LogField.LANGUAGE.toString(), map, a2);
        a(LogField.ACCESS.toString(), map, a2);
        a(LogField.ACCESS_SUBTYPE.toString(), map, a2);
        a(LogField.CARRIER.toString(), map, a2);
        if (map.containsKey(com.alibaba.analytics.core.model.a.ALIYUN_PLATFORM_FLAG.toString())) {
            map.put(LogField.OS.toString(), "y");
        }
        logField = (String) map.get(LogField.RESERVES.toString());
        if (TextUtils.isEmpty(logField)) {
            stringBuilder = new StringBuilder(100);
        } else {
            stringBuilder = new StringBuilder(logField);
        }
        if (TextUtils.isEmpty(b)) {
            try {
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                    b = com.alibaba.analytics.core.d.e.b(context);
                }
            } catch (Exception e) {
            }
        }
        if (b != null) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",_mac=").append(b);
            } else {
                stringBuilder.append("_mac=").append(b);
            }
            map.remove("_mac");
        }
        logField = (String) map.get(com.alibaba.analytics.core.model.a.DEVICE_ID.toString());
        if (logField != null) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",_did=").append(logField);
            } else {
                stringBuilder.append("_did=").append(logField);
            }
            map.remove(com.alibaba.analytics.core.model.a.DEVICE_ID.toString());
        }
        logField = g.a(context);
        if (logField != null) {
            if (map.containsKey(LogField.UTDID.toString()) && logField.equals(map.get(LogField.UTDID.toString()))) {
                logField = "utdid";
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",_umid=").append(logField);
            } else {
                stringBuilder.append("_umid=").append(logField);
            }
        }
        if (a == null) {
            logField = a(context);
            if (logField == null) {
                a = "";
            } else {
                a = logField;
            }
        }
        if (!TextUtils.isEmpty(a)) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",_bssid=").append(a);
            } else {
                stringBuilder.append("_bssid=").append(a);
            }
        }
        com.alibaba.analytics.core.b a3 = com.alibaba.analytics.core.b.a();
        if (!(a3.u || a3.b == null)) {
            a3.u = a3.b.getSharedPreferences("UTCommon", 0).getBoolean("_isolddevice", false);
        }
        if (a3.u) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",_io=1");
            } else {
                stringBuilder.append("_io=1");
            }
        }
        a3 = com.alibaba.analytics.core.b.a();
        if (!a3.w) {
            Context context4 = a3.b;
            if (context4 == null) {
                z = false;
                if (z) {
                    a3 = com.alibaba.analytics.core.b.a();
                    if (a3.y) {
                        context3 = a3.b;
                        if (context3 != null) {
                            logField = null;
                        } else {
                            a3.x = r.a(context3, "build_id");
                            a3.y = true;
                            logField = a3.x;
                        }
                    } else {
                        logField = a3.x;
                    }
                    if (!TextUtils.isEmpty(logField)) {
                        if (stringBuilder.length() <= 0) {
                            stringBuilder.append(",_buildid=").append(logField);
                        } else {
                            stringBuilder.append("_buildid=").append(logField);
                        }
                    }
                }
                if (stringBuilder.length() <= 0) {
                    stringBuilder.append(",_timeAdjust=").append(h.a().b ? SettingsConst.TRUE : SettingsConst.FALSE);
                } else {
                    stringBuilder.append("_timeAdjust=").append(h.a().b ? SettingsConst.TRUE : SettingsConst.FALSE);
                }
                logField = (String) map.get(LogField.APPKEY.toString());
                str = com.alibaba.analytics.core.b.a().c;
                if (!(TextUtils.isEmpty(logField) || TextUtils.isEmpty(str) || str.equalsIgnoreCase(logField))) {
                    if (stringBuilder.length() <= 0) {
                        stringBuilder.append(",_mak=").append(str);
                    } else {
                        stringBuilder.append("_mak=").append(str);
                    }
                }
                logField = ae.b(com.alibaba.analytics.core.b.a().b) ? SettingsConst.TRUE : SettingsConst.FALSE;
                if (stringBuilder.length() <= 0) {
                    stringBuilder.append(",_pad=").append(logField);
                } else {
                    stringBuilder.append("_pad=").append(logField);
                }
                logField = r.d(context);
                if (!TextUtils.isEmpty(logField)) {
                    if (stringBuilder.length() <= 0) {
                        stringBuilder.append(",_channel2=").append(logField);
                    } else {
                        stringBuilder.append("_channel2=").append(logField);
                    }
                }
                a2 = com.alibaba.analytics.core.b.a().f();
                if (a2 != null && a2.size() > 0) {
                    logField = com.alibaba.analytics.a.b.b(a2);
                    if (!TextUtils.isEmpty(logField)) {
                        if (stringBuilder.length() <= 0) {
                            stringBuilder.append(",").append(logField);
                        } else {
                            stringBuilder.append(logField);
                        }
                    }
                }
                logField = stringBuilder.toString();
                if (logField != null) {
                    map.put(LogField.RESERVES.toString(), logField);
                }
                return b((Map) map);
            }
            if (SettingsConst.TRUE.equalsIgnoreCase(r.a(context4, "package_type"))) {
                a3.v = true;
                a3.w = true;
            }
        }
        z = a3.v;
        if (z) {
            a3 = com.alibaba.analytics.core.b.a();
            if (a3.y) {
                context3 = a3.b;
                if (context3 != null) {
                    a3.x = r.a(context3, "build_id");
                    a3.y = true;
                    logField = a3.x;
                } else {
                    logField = null;
                }
            } else {
                logField = a3.x;
            }
            if (TextUtils.isEmpty(logField)) {
                if (stringBuilder.length() <= 0) {
                    stringBuilder.append("_buildid=").append(logField);
                } else {
                    stringBuilder.append(",_buildid=").append(logField);
                }
            }
        }
        if (stringBuilder.length() <= 0) {
            if (h.a().b) {
            }
            stringBuilder.append("_timeAdjust=").append(h.a().b ? SettingsConst.TRUE : SettingsConst.FALSE);
        } else {
            if (h.a().b) {
            }
            stringBuilder.append(",_timeAdjust=").append(h.a().b ? SettingsConst.TRUE : SettingsConst.FALSE);
        }
        logField = (String) map.get(LogField.APPKEY.toString());
        str = com.alibaba.analytics.core.b.a().c;
        if (stringBuilder.length() <= 0) {
            stringBuilder.append("_mak=").append(str);
        } else {
            stringBuilder.append(",_mak=").append(str);
        }
        if (ae.b(com.alibaba.analytics.core.b.a().b)) {
        }
        if (stringBuilder.length() <= 0) {
            stringBuilder.append("_pad=").append(logField);
        } else {
            stringBuilder.append(",_pad=").append(logField);
        }
        logField = r.d(context);
        if (TextUtils.isEmpty(logField)) {
            if (stringBuilder.length() <= 0) {
                stringBuilder.append("_channel2=").append(logField);
            } else {
                stringBuilder.append(",_channel2=").append(logField);
            }
        }
        a2 = com.alibaba.analytics.core.b.a().f();
        logField = com.alibaba.analytics.a.b.b(a2);
        if (TextUtils.isEmpty(logField)) {
            if (stringBuilder.length() <= 0) {
                stringBuilder.append(logField);
            } else {
                stringBuilder.append(",").append(logField);
            }
        }
        logField = stringBuilder.toString();
        if (logField != null) {
            map.put(LogField.RESERVES.toString(), logField);
        }
        return b((Map) map);
    }

    private static String b(Map<String, String> map) {
        String a;
        int i;
        Map a2 = a.a(map);
        StringBuffer stringBuffer = new StringBuffer();
        for (LogField logField : LogField.values()) {
            if (logField == LogField.ARGS) {
                break;
            }
            if (a2.containsKey(logField.toString())) {
                a = com.alibaba.analytics.a.b.a(a2.get(logField.toString()));
                a2.remove(logField.toString());
            } else {
                a = null;
            }
            stringBuffer.append(b(a)).append("||");
        }
        if (a2.containsKey(LogField.ARGS.toString())) {
            stringBuffer.append(b(com.alibaba.analytics.a.b.a(a2.get(LogField.ARGS.toString()))));
            a2.remove(LogField.ARGS.toString());
            i = 0;
        } else {
            i = 1;
        }
        int i2 = i;
        for (String a3 : a2.keySet()) {
            String a4;
            if (a2.containsKey(a3)) {
                a4 = com.alibaba.analytics.a.b.a(a2.get(a3));
            } else {
                a4 = null;
            }
            if (i2 != 0) {
                if ("StackTrace".equals(a3)) {
                    stringBuffer.append("StackTrace=====>").append(a4);
                } else {
                    stringBuffer.append(b(a3)).append("=").append(a4);
                }
                i2 = 0;
            } else if ("StackTrace".equals(a3)) {
                stringBuffer.append(",StackTrace=====>").append(a4);
            } else {
                stringBuffer.append(",").append(b(a3)).append("=").append(a4);
            }
        }
        if (stringBuffer.length() > 40960) {
            a3 = stringBuffer.substring(0, 40960);
            af.d("", "args len", Integer.valueOf(stringBuffer.length()));
        } else {
            a3 = stringBuffer.toString();
        }
        if (!TextUtils.isEmpty(a3) && a3.endsWith("||")) {
            a3 = a3 + "-";
        }
        if (af.a()) {
            af.a("", "lLogResult:" + a3);
        }
        return a3;
    }

    public static Map<String, String> a(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        String[] c = c(str);
        LogField[] values = LogField.values();
        int length = values.length;
        int i2 = 0;
        while (i < length) {
            LogField logField = values[i];
            if (i2 < 34 && c[i2] != null) {
                hashMap.put(logField.toString(), c[i2]);
            }
            i2++;
            i++;
        }
        return hashMap;
    }

    private static String[] c(String str) {
        int i = 0;
        String[] strArr = new String[34];
        int i2 = 0;
        while (i < 33) {
            int indexOf = str.indexOf("||", i2);
            if (indexOf == -1) {
                strArr[i] = str.substring(i2);
                break;
            }
            strArr[i] = str.substring(i2, indexOf);
            i2 = indexOf + 2;
            i++;
        }
        strArr[33] = str.substring(i2);
        return strArr;
    }

    private static String a(Context context) {
        try {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getBSSID();
        } catch (Throwable th) {
            return null;
        }
    }

    public static String a(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6, String str7) {
        Map hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(LogField.PAGE.toString(), str);
        }
        hashMap.put(LogField.EVENTID.toString(), str2);
        if (!TextUtils.isEmpty(str3)) {
            if (str3.length() > 40960) {
                hashMap.put(LogField.ARG1.toString(), str3.substring(0, 40960));
                af.d("", "arg1 len", Integer.valueOf(str3.length()));
            } else {
                hashMap.put(LogField.ARG1.toString(), str3);
            }
        }
        if (!TextUtils.isEmpty(str4)) {
            if (str4.length() > 40960) {
                hashMap.put(LogField.ARG2.toString(), str4.substring(0, 40960));
                af.d("", "arg2 len", Integer.valueOf(str4.length()));
            } else {
                hashMap.put(LogField.ARG2.toString(), str4);
            }
        }
        if (!TextUtils.isEmpty(str5)) {
            if (str5.length() > 40960) {
                hashMap.put(LogField.ARG3.toString(), str5.substring(0, 40960));
                af.d("", "arg3 len", Integer.valueOf(str5.length()));
            } else {
                hashMap.put(LogField.ARG3.toString(), str5);
            }
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put(LogField.RECORD_TIMESTAMP.toString(), str7);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put(LogField.RESERVE3.toString(), str6);
        }
        return a(hashMap);
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "-";
        }
        return str;
    }
}
