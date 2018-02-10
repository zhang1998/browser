package com.ucpro.feature.webwindow.o;

import android.text.TextUtils;
import android.widget.Toast;
import com.UCMobile.Apollo.Global;
import com.uc.apollo.impl.SettingsConst;
import com.ucpro.business.stat.m;
import com.ucpro.feature.setting.b.c.b;
import com.ucweb.common.util.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class a {
    private static Map<String, c> a = new HashMap(4);
    private static boolean b = b.a.b();

    private static void a() {
        Iterator it = a.entrySet().iterator();
        while (it.hasNext()) {
            c cVar = (c) ((Entry) it.next()).getValue();
            if (com.ucpro.c.b.b()) {
                new StringBuilder("stat bean:").append(cVar.toString());
            }
            if (cVar != null && (cVar.c >= 0 || cVar.d >= 0 || cVar.e >= 0 || cVar.f >= 0)) {
                long j;
                long j2 = cVar.c < 0 ? 0 : cVar.c - cVar.b;
                long j3 = cVar.d < 0 ? 0 : cVar.d - cVar.c;
                long j4 = cVar.e < 0 ? 0 : cVar.e - cVar.d;
                if (cVar.f < 0) {
                    j = 0;
                } else {
                    j = cVar.f - cVar.e;
                }
                if (j2 != 0 || j3 != 0 || j4 != 0 || j != 0) {
                    m.a("core", "page_time", "t0", String.valueOf(j2), "t1", String.valueOf(j3), "t2", String.valueOf(j4), "t3", String.valueOf(j));
                }
            }
            it.remove();
        }
    }

    private static void a(String str, long j, int i) {
        if (!a.containsKey(str)) {
            a.put(str, new c());
        }
        c cVar = (c) a.get(str);
        cVar.a = str;
        switch (i) {
            case 4:
                cVar.b = j;
                return;
            case 5:
                cVar.c = j;
                return;
            case 6:
                cVar.d = j;
                return;
            case 7:
                cVar.e = j;
                return;
            case 8:
                cVar.f = j;
                return;
            default:
                return;
        }
    }

    public static void a(int i, Object obj) {
        if (obj != null && (obj instanceof HashMap)) {
            HashMap hashMap = (HashMap) obj;
            String str = (String) hashMap.get("id");
            hashMap.get("time");
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (com.ucpro.c.b.b() && 7 == i && b) {
                    String str2 = (String) hashMap.get("route");
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.equals(SettingsConst.FALSE)) {
                            str2 = "未知";
                        } else if (str2.equals(SettingsConst.TRUE)) {
                            str2 = "直连";
                        } else if (str2.equals(Global.APOLLO_SERIES)) {
                            str2 = "中转";
                        }
                        Toast.makeText(d.a(), "[T2] Route类型:>>>\t" + str2 + "<<<\t[开发模式有开关]", 0).show();
                    }
                }
                switch (i) {
                    case 4:
                        a();
                        a(str, currentTimeMillis, i);
                        return;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        a(str, currentTimeMillis, i);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static void a(boolean z) {
        b = z;
    }
}
