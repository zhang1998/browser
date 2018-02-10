package com.alibaba.analytics.core.h;

import android.text.TextUtils;
import com.alibaba.analytics.core.model.LogField;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class p extends m {
    private static p b = null;
    private Map<String, s> a = new HashMap();

    public static p a() {
        if (b == null) {
            b = new p();
        }
        return b;
    }

    private p() {
    }

    public final synchronized String a(Map<String, String> map) {
        String a;
        int parseInt;
        String str;
        if (map.containsKey(LogField.EVENTID.toString())) {
            try {
                parseInt = Integer.parseInt((String) map.get(LogField.EVENTID.toString()));
            } catch (Exception e) {
            }
            if (map.containsKey(LogField.ARG1.toString())) {
                str = null;
            } else {
                str = (String) map.get(LogField.ARG1.toString());
            }
            a = a(parseInt, str);
            if (a == null) {
                a = a(parseInt - (parseInt % 10), str);
                if (a == null) {
                    a = a(parseInt - (parseInt % 100), str);
                    if (a == null) {
                        a = a(parseInt - (parseInt % 1000), str);
                        if (a == null) {
                            a = a(-1, str);
                            if (a == null) {
                                a = "stm_d";
                            }
                        }
                    }
                }
            }
        }
        parseInt = -1;
        if (map.containsKey(LogField.ARG1.toString())) {
            str = null;
        } else {
            str = (String) map.get(LogField.ARG1.toString());
        }
        a = a(parseInt, str);
        if (a == null) {
            a = a(parseInt - (parseInt % 10), str);
            if (a == null) {
                a = a(parseInt - (parseInt % 100), str);
                if (a == null) {
                    a = a(parseInt - (parseInt % 1000), str);
                    if (a == null) {
                        a = a(-1, str);
                        if (a == null) {
                            a = "stm_d";
                        }
                    }
                }
            }
        }
        return a;
    }

    private String a(int i, String str) {
        String valueOf = String.valueOf(i);
        if (!this.a.containsKey(valueOf)) {
            return null;
        }
        s sVar = (s) this.a.get(valueOf);
        if (!TextUtils.isEmpty(str)) {
            String str2;
            if (str != null) {
                for (String str22 : sVar.a.keySet()) {
                    if (str22.startsWith("%") && str22.endsWith("%")) {
                        if (str.contains(str22.substring(1, str22.length() - 1))) {
                            str22 = (String) sVar.a.get(str22);
                            break;
                        }
                    } else if (str.equals(str22)) {
                        str22 = (String) sVar.a.get(str22);
                        break;
                    }
                }
            }
            str22 = null;
            if (str22 != null) {
                return str22;
            }
        }
        return sVar.b;
    }

    public final synchronized void a(String str, Map<String, String> map) {
        this.a.clear();
        for (String str2 : map.keySet()) {
            String str3 = (String) map.get(str2);
            if (str3 != null) {
                s a = s.a(str3);
                if (a != null) {
                    this.a.put(str2, a);
                }
            }
        }
    }

    public final String[] c() {
        return new String[]{"ut_stream"};
    }
}
